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
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.Vector;

import javax.swing.DefaultListModel;
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

public class ServerMain extends JInternalFrame {
	ServerSocket server;
	ServerThread st;
	Vector<ServerThread> clients = new Vector<>();
	boolean flagServer;
	//Vector<String> users = new Vector<>(); // 여기서 벡터는 시차가 생겨서 오류가 날 때 있고 안 날 때 있다
	DefaultListModel userListModel = new DefaultListModel<String>();
	
	final static int SERVER_START = 1; // command는 이렇게 작성하는게 정석이다
	final static int SERVER_STOP  = 2; // final로 선언해서 상수화 시킨다. 상수는 대문자로 작성하기때문에 카멜타입이 아니라 _를 사용한다
	final static int LOGIN        = 3;
	final static int LOGOUT       = 4;
	final static int MESSAGE      = 5;
	final static int USERS        = 6;
	final static int WHISPER      = 7;
	
	private JPanel panel;
	private JLabel lblNewLabel;
	private JTextField tfIp;
	private JButton btnStart;
	private JButton btnStop;
	private JPanel panel_1;
	private JTextField tfMessage;
	private JButton btnSend;
	private JButton btnWhisper;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JList list;
	private JTextArea textArea;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ServerMain frame = new ServerMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// 클라이언트 접속할 때까지 아무것도 못한다. 이게 deadlock 상태다. 그래서 thread가 필요하다.
	public void start() {
		try {
			Thread t = new Thread(new Runnable() {
				public void run() {
					try {
						textArea.append("서버 시작\n");
						btnStart.setEnabled(false);
						btnStop.setEnabled(true);
						btnSend.setEnabled(true);
						btnWhisper.setEnabled(true);
						
						server = new ServerSocket(5555);
						flagServer = true;
						
						while(flagServer) {
							Socket socket = server.accept();
							
							if(flagServer) { // stop 눌렀을 때 블록킹모드 풀려고 자기 자신으로 접속 할 때 쓰레드를 만들지 않기 위해 if문 사용
								st = new ServerThread(socket, ServerMain.this);
								st.start();
								clients.add(st);
							}
						}
						
						for(ServerThread st : clients) {
							st.br.close();
							st.bw.close();
							st.socket.close();
						}
						//clients.remove(st); // 강퇴시킬 클라이언트 찾아서 remove하면 그게 강퇴다
						clients.clear();
						
						/* 2) ServerSocket 종료 */
						server.close();
						userListModel.clear();
					} catch(Exception ex) {
						ex.printStackTrace();
					}
				}
			});
			t.start();
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void stop() {
		try {
			/* 1) 접속된 모든 클라이언트들에게 서버 중지 통보 */
			JSONObject jData = new JSONObject();
			jData.put("user", "server");
			jData.put("command", SERVER_STOP); // jData.put("command", 2); 보다 명시적이다
			jData.put("message", "서버가 중지되었습니다.");
			
			for(ServerThread st : clients) {
				//String msg = "SERVER_STOP";
				//st.sendMsg(msg);
				//System.out.println(jData.toJSONString());
				st.bw.write(jData.toJSONString() + "\n"); // {user:server, command:SERVER_STOP, ...} JSON구조가 아니면 파싱 불가능
				st.bw.flush();
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		
		/* 3) 버튼들을 토클 */
		btnStart.setEnabled(true);
		btnStop.setEnabled(false);
		btnSend.setEnabled(false);
		btnWhisper.setEnabled(false);
		userListModel.removeAllElements();
		
		/* 4) 서버를 중지하기 위한 가상의 클라이언트로 접속 */
		flagServer = false;
		
		try {
			Socket tempSocket = new Socket("127.0.0.1", 5555); // 127.0.0.1은 자기 자신이다
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void send() {
		String msg = tfMessage.getText();
		tfMessage.setText("");
		
		JSONObject obj = new JSONObject();
		obj.put("user", "server");
		obj.put("command", ServerMain.MESSAGE);
		obj.put("message", msg);
		
		textArea.append(msg + "\n");;
		textArea.setCaretPosition(textArea.getText().length());
		
		for(ServerThread st : clients) {
			try {
				st.bw.write(obj.toJSONString() + "\n");
				st.bw.flush();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}
	
	public void sendWhisper() {
		String msg = tfMessage.getText();
		
		JSONObject obj = new JSONObject();
		obj.put("user", "server");
		obj.put("command", ServerMain.WHISPER);
		obj.put("message", msg);
		
		textArea.append(msg + "\n");
		textArea.setCaretPosition(textArea.getText().length());
		
		List<String> receiveUsers = getList().getSelectedValuesList();
		
		for(ServerThread st : clients) {
			if(!receiveUsers.contains(st.user)) continue;
			
			try {
				st.bw.write(obj.toJSONString() + "\n");
				st.bw.flush();
			} catch(Exception ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * Create the frame.
	 */
	public ServerMain() {
		super("서버UI", true, true, true, true);
		setVisible(true);
		setBounds(100, 100, 600, 400);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(getPanel(), BorderLayout.NORTH);
		getContentPane().add(getPanel_1(), BorderLayout.SOUTH);
		getContentPane().add(getPanel_2(), BorderLayout.CENTER);

	}
	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(new Color(0, 0, 0));
			panel.setLayout(null);
			panel.setPreferredSize(new Dimension(10, 40));
			panel.add(getLblNewLabel());
			panel.add(getTfIp());
			panel.add(getBtnNewButton_1_2());
			panel.add(getBtnNewButton_3());
		}
		return panel;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("서버IP");
			lblNewLabel.setForeground(new Color(255, 128, 0));
			lblNewLabel.setFont(new Font("굴림", Font.BOLD, 16));
			lblNewLabel.setBounds(12, 10, 60, 24);
		}
		return lblNewLabel;
	}
	public JTextField getTfIp() {
		if (tfIp == null) {
			tfIp = new JTextField();
			tfIp.setBorder(new LineBorder(new Color(255, 128, 0), 2));
			tfIp.setColumns(10);
			tfIp.setBounds(68, 10, 296, 24);
			InetAddress ia;
			try {
				ia = InetAddress.getLocalHost();
				tfIp.setText(ia.getHostAddress());
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		return tfIp;
	}
	public JButton getBtnNewButton_1_2() {
		if (btnStart == null) {
			btnStart = new JButton("시작");
			btnStart.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 서버를 시작하고 클라이언트의 접속대기
					start();
				}
			});
			btnStart.setBackground(new Color(0, 0, 0));
			btnStart.setBorder(new LineBorder(new Color(255, 128, 0), 2));
			btnStart.setForeground(new Color(255, 128, 0));
			btnStart.setFont(new Font("굴림", Font.BOLD, 16));
			btnStart.setBounds(376, 10, 95, 24);
		}
		return btnStart;
	}
	public JButton getBtnNewButton_3() {
		if (btnStop == null) {
			btnStop = new JButton("종료");
			btnStop.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 모든 클라이언트한테 서버종료를 알림
					stop();
				}
			});
			btnStop.setBackground(new Color(0, 0, 0));
			btnStop.setBorder(new LineBorder(new Color(255, 128, 0), 2));
			btnStop.setForeground(new Color(255, 128, 0));
			btnStop.setEnabled(false);
			btnStop.setFont(new Font("굴림", Font.BOLD, 16));
			btnStop.setBounds(483, 10, 95, 24);
		}
		return btnStop;
	}
	public JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setBackground(new Color(0, 0, 0));
			panel_1.setLayout(null);
			panel_1.setPreferredSize(new Dimension(10, 40));
			panel_1.add(getTextField_1_1());
			panel_1.add(getBtnNewButton_1_1_1());
			panel_1.add(getBtnNewButton_2_1());
		}
		return panel_1;
	}
	public JTextField getTextField_1_1() {
		if (tfMessage == null) {
			tfMessage = new JTextField();
			tfMessage.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						//String msg = tfMessage.getText();
						//textArea.append(msg + "\n");
						//st.sendMsgAll(msg);
						send();
					}
				}
			});
			tfMessage.setBorder(new LineBorder(new Color(255, 128, 0), 2));
			tfMessage.setColumns(10);
			tfMessage.setBounds(12, 10, 352, 24);
		}
		return tfMessage;
	}
	public JButton getBtnNewButton_1_1_1() {
		if (btnSend == null) {
			btnSend = new JButton("전송");
			btnSend.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//String msg = tfMessage.getText();
					//textArea.append(msg + "\n");
					//st.sendMsgAll(msg);
					send();
				}
			});
			btnSend.setBackground(new Color(0, 0, 0));
			btnSend.setBorder(new LineBorder(new Color(255, 128, 0), 2));
			btnSend.setForeground(new Color(255, 128, 0));
			btnSend.setEnabled(false);
			btnSend.setFont(new Font("굴림", Font.BOLD, 16));
			btnSend.setBounds(376, 10, 95, 24);
		}
		return btnSend;
	}
	public JButton getBtnNewButton_2_1() {
		if (btnWhisper == null) {
			btnWhisper = new JButton("귓속말");
			btnWhisper.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					sendWhisper();
				}
			});
			btnWhisper.setBackground(new Color(0, 0, 0));
			btnWhisper.setBorder(new LineBorder(new Color(255, 128, 0), 2));
			btnWhisper.setForeground(new Color(255, 128, 0));
			btnWhisper.setEnabled(false);
			btnWhisper.setFont(new Font("굴림", Font.BOLD, 16));
			btnWhisper.setBounds(483, 10, 95, 24);
		}
		return btnWhisper;
	}
	public JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setBackground(new Color(0, 0, 0));
			panel_2.setLayout(null);
			panel_2.add(getPanel_3_1());
			panel_2.add(getPanel_4());
		}
		return panel_2;
	}
	public JPanel getPanel_3_1() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setBorder(new LineBorder(new Color(255, 128, 0), 2));
			panel_3.setBounds(12, 10, 99, 281);
			panel_3.setLayout(new BorderLayout(0, 0));
			panel_3.add(getScrollPane(), BorderLayout.CENTER);
		}
		return panel_3;
	}
	public JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setBorder(new LineBorder(new Color(255, 128, 0), 2));
			panel_4.setBounds(123, 10, 455, 281);
			panel_4.setLayout(new BorderLayout(0, 0));
			panel_4.add(getScrollPane_1(), BorderLayout.CENTER);
		}
		return panel_4;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getList());
			scrollPane.setColumnHeaderView(getLblNewLabel_1());
		}
		return scrollPane;
	}
	public JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setViewportView(getTextArea());
			scrollPane_1.setColumnHeaderView(getLblNewLabel_3());
		}
		return scrollPane_1;
	}
	public JList getList() {
		if (list == null) {
			list = new JList(userListModel);
		}
		
		//users.add("Kim"); // JList에 잘 뜨는지 테스트
		//users.add("Hong");
		
		//list.setListData(users);
		
		return list;
	}
	public JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("접속자");
			lblNewLabel_1.setForeground(new Color(0, 128, 255));
			lblNewLabel_1.setHorizontalTextPosition(SwingConstants.CENTER);
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 16));
		}
		return lblNewLabel_1;
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
}
