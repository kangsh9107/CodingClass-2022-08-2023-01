package chatt;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import org.json.simple.JSONObject;

public class ClientMain extends JInternalFrame {
	ClientThread ct;
	Vector<String> users = new Vector<>();
	
	private JPanel panel;
	private JLabel lblip;
	private JTextField tfIp;
	private JButton btnConnect;
	private JButton btnDisconnect;
	private JPanel panel_1;
	private JTextField tfMessage;
	private JButton btnSend;
	private JButton btnWhisper;
	private JLabel lblNewLabel_1;
	private JTextField tfUser;
	private JPanel panel_2;
	private JPanel panel_3;
	private JScrollPane scrollPane;
	private JList list;
	private JPanel panel_4;
	private JScrollPane scrollPane_1;
	private JTextArea textArea;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientMain frame = new ClientMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void connect() {
		try {
			String ip = tfIp.getText();
			int port = 5555;
			Socket s = new Socket(ip, port);
			ct = new ClientThread(s, this); // ClientMain.this로 명시해도 되고 안해도 된다
			ct.start();
			
			btnConnect.setEnabled(false);
			btnDisconnect.setEnabled(true);
			btnSend.setEnabled(true);
			btnWhisper.setEnabled(true);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void disconnect() {
		// 1) 서버에게 자신의 종료 사실을 알림
		//String msg = "CLIENT_DISCONNECT";
		JSONObject obj = new JSONObject();
		obj.put("user", tfUser.getText());
		obj.put("command", ServerMain.LOGOUT);
		obj.put("message", "난 이제 그만 갈게");
		
		ct.sendMsg(obj.toJSONString());
		
		// 2) 자신의 쓰레드인 ct 종료
		try {
			ct.br.close();
			ct.bw.close();
			ct.socket.close();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		ct = null;
		
		// 3) 버튼 상태 변경
		btnConnect.setEnabled(true);
		btnDisconnect.setEnabled(false);
		btnSend.setEnabled(false);
		btnWhisper.setEnabled(false);
	}

	/**
	 * Create the frame.
	 */
	public ClientMain() {
		super("클라이언트UI", true, true, true, true);
		setVisible(true);
		setBounds(100, 100, 600, 600);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(getPanel(), BorderLayout.NORTH);
		getContentPane().add(getPanel_1(), BorderLayout.SOUTH);
		getContentPane().add(getPanel_2(), BorderLayout.CENTER);

	}
	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(0, 0, 0));
			panel.setPreferredSize(new Dimension(10, 40));
			panel.setLayout(null);
			panel.add(getLblip());
			panel.add(getTfIp());
			panel.add(getBtnConnect());
			panel.add(getBtnDisconnect());
			panel.add(getLblNewLabel_1());
			panel.add(getTfUser());
		}
		return panel;
	}
	public JLabel getLblip() {
		if (lblip == null) {
			lblip = new JLabel("서버IP");
			lblip.setForeground(new Color(255, 128, 0));
			lblip.setPreferredSize(new Dimension(15, 15));
			lblip.setFont(new Font("굴림", Font.BOLD, 16));
			lblip.setBounds(12, 10, 49, 24);
		}
		return lblip;
	}
	public JTextField getTfIp() {
		if (tfIp == null) {
			tfIp = new JTextField();
			tfIp.setBorder(new LineBorder(new Color(255, 128, 0), 2));
			tfIp.setColumns(10);
			tfIp.setBounds(68, 10, 115, 24);
			InetAddress ia;
			try {
				ia = InetAddress.getLocalHost();
				String ip = ia.getHostAddress();
				tfIp.setText(ip);
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return tfIp;
	}
	public JButton getBtnConnect() {
		if (btnConnect == null) {
			btnConnect = new JButton("접속");
			btnConnect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					connect();
				}
			});
			btnConnect.setBackground(new Color(0, 0, 0));
			btnConnect.setForeground(new Color(255, 128, 0));
			btnConnect.setBorder(new LineBorder(new Color(255, 128, 0), 2));
			btnConnect.setFont(new Font("굴림", Font.BOLD, 16));
			btnConnect.setBounds(376, 10, 95, 24);
		}
		return btnConnect;
	}
	public JButton getBtnDisconnect() {
		if (btnDisconnect == null) {
			btnDisconnect = new JButton("종료");
			btnDisconnect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					disconnect();
				}
			});
			btnDisconnect.setBackground(new Color(0, 0, 0));
			btnDisconnect.setForeground(new Color(255, 128, 0));
			btnDisconnect.setBorder(new LineBorder(new Color(255, 128, 0), 2));
			btnDisconnect.setEnabled(false);
			btnDisconnect.setFont(new Font("굴림", Font.BOLD, 16));
			btnDisconnect.setBounds(483, 10, 95, 24);
		}
		return btnDisconnect;
	}
	public JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(new Color(0, 0, 0));
			panel_1.setPreferredSize(new Dimension(10, 40));
			panel_1.setLayout(null);
			panel_1.add(getTfMessage());
			panel_1.add(getBtnSend());
			panel_1.add(getBtnWhisper());
		}
		return panel_1;
	}
	public JTextField getTfMessage() {
		if (tfMessage == null) {
			tfMessage = new JTextField();
			tfMessage.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						String msg = tfMessage.getText();
						ct.sendMsg(msg);
						tfMessage.setText("");
					}
				}
			});
			tfMessage.setBorder(new LineBorder(new Color(255, 128, 0), 2));
			tfMessage.setColumns(10);
			tfMessage.setBounds(12, 10, 352, 24);
		}
		return tfMessage;
	}
	public JButton getBtnSend() {
		if (btnSend == null) {
			btnSend = new JButton("전송");
			btnSend.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String msg = tfMessage.getText();
					ct.sendMsg(msg);
					tfMessage.setText("");
				}
			});
			btnSend.setBackground(new Color(0, 0, 0));
			btnSend.setForeground(new Color(255, 128, 0));
			btnSend.setBorder(new LineBorder(new Color(255, 128, 0), 2));
			btnSend.setEnabled(false);
			btnSend.setFont(new Font("굴림", Font.BOLD, 16));
			btnSend.setBounds(376, 10, 95, 24);
		}
		return btnSend;
	}
	public JButton getBtnWhisper() {
		if (btnWhisper == null) {
			btnWhisper = new JButton("귓속말");
			btnWhisper.setBackground(new Color(0, 0, 0));
			btnWhisper.setForeground(new Color(255, 128, 0));
			btnWhisper.setBorder(new LineBorder(new Color(255, 128, 0), 2));
			btnWhisper.setEnabled(false);
			btnWhisper.setFont(new Font("굴림", Font.BOLD, 16));
			btnWhisper.setBounds(483, 10, 95, 24);
		}
		return btnWhisper;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("접속자");
			lblNewLabel_1.setForeground(new Color(255, 128, 0));
			lblNewLabel_1.setPreferredSize(new Dimension(25, 15));
			lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 16));
			lblNewLabel_1.setBounds(191, 10, 58, 24);
		}
		return lblNewLabel_1;
	}
	public JTextField getTfUser() {
		if (tfUser == null) {
			tfUser = new JTextField();
			tfUser.setBorder(new LineBorder(new Color(255, 128, 0), 2));
			tfUser.setColumns(10);
			tfUser.setBounds(249, 10, 115, 24);
		}
		return tfUser;
	}
	public JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBackground(new Color(0, 0, 0));
			panel_2.setLayout(null);
			panel_2.add(getPanel_3());
			panel_2.add(getPanel_4());
		}
		return panel_2;
	}
	public JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setBorder(new LineBorder(new Color(255, 128, 0), 2));
			panel_3.setBounds(12, 10, 99, 481);
			panel_3.setLayout(new BorderLayout(0, 0));
			panel_3.add(getScrollPane(), BorderLayout.CENTER);
		}
		return panel_3;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getList());
			scrollPane.setColumnHeaderView(getLblNewLabel());
		}
		return scrollPane;
	}
	public JList getList() {
		if (list == null) {
			list = new JList();
		}
		return list;
	}
	public JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setBorder(new LineBorder(new Color(255, 128, 0), 2));
			panel_4.setBounds(123, 10, 455, 481);
			panel_4.setLayout(new BorderLayout(0, 0));
			panel_4.add(getScrollPane_1(), BorderLayout.CENTER);
		}
		return panel_4;
	}
	public JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setViewportView(getTextArea());
			scrollPane_1.setColumnHeaderView(getLblNewLabel_3());
		}
		return scrollPane_1;
	}
	public JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("대화내용");
			lblNewLabel_3.setForeground(new Color(0, 128, 255));
			lblNewLabel_3.setHorizontalTextPosition(SwingConstants.CENTER);
			lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 16));
		}
		return lblNewLabel_3;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("접속자");
			lblNewLabel.setForeground(new Color(0, 128, 255));
			lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
			lblNewLabel.setFont(new Font("굴림", Font.BOLD, 16));
			lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return lblNewLabel;
	}
}
