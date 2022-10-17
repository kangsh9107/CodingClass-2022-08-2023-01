package thread;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ThreadFrame extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JTextField textField;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnThread;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ThreadFrame frame = new ThreadFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ThreadFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 624, 550);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getBtnNewButton());
		contentPane.add(getTextField());
		contentPane.add(getScrollPane());
		contentPane.add(getBtnThread());
	}

	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("Run");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 시간이 많이 걸리는 테스트
					long sum = 0l;
					for(double i=0; i<999999999; i=i+0.5) {
						sum += (long)i;
					}
					textArea.setText("sum=" + sum);
				}
			});
			btnNewButton.setBounds(324, 9, 131, 52);
		}
		return btnNewButton;
	}
	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setBounds(12, 10, 300, 52);
			textField.setColumns(10);
		}
		return textField;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 72, 586, 431);
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	public JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
		}
		return textArea;
	}
	public JButton getBtnThread() {
		if (btnThread == null) {
			btnThread = new JButton("Thread");
			btnThread.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					/*
					 * Thread test = new Thread(new Runnable() {});
					 * Runnable은 인터페이스라서 추상 메서드를 반드시 재정의 해야 한다.
					 */
					Thread t = new Thread(new Runnable() {
						@Override
						public void run() {
							// 시간이 많이 걸리는 테스트
							long sum = 0l;
							for(double i=0; i<99999999; i=i+0.1) {
								sum += (long)i;
							}
							textArea.setText("sum=" + sum);
						}
					});
					
				}
			});
			btnThread.setBounds(467, 9, 131, 52);
		}
		return btnThread;
	}
}
