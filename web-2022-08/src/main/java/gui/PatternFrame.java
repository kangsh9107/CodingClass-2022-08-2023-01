package gui;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;

public class PatternFrame extends JInternalFrame {
	private JLabel lblNewLabel;
	private JTextField emailPattern;
	private JLabel lblNewLabel_1;
	private JTextField emailValue;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1_1;
	private JTextField phoneValue;
	private JTextField phonePattern;
	private JButton btnNewButton_1;
	private JSeparator separator;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnNewButton_1_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PatternFrame frame = new PatternFrame();
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
	public PatternFrame() {
		super("패턴", true, true, true, true);
		setVisible(true);
		setBounds(100, 100, 559, 382);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getEmailPattern());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getEmailValue());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getLblNewLabel_1_1());
		getContentPane().add(getPhoneValue());
		getContentPane().add(getPhonePattern());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getSeparator());
		getContentPane().add(getScrollPane());
		getContentPane().add(getBtnNewButton_1_2());

	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("이메일 패턴");
			lblNewLabel.setBounds(12, 10, 72, 31);
		}
		return lblNewLabel;
	}
	public JTextField getEmailPattern() {
		if (emailPattern == null) {
			emailPattern = new JTextField();
			emailPattern.setText("\\w+@\\w+\\.\\w+(\\.\\w+)?");
			emailPattern.setBounds(96, 10, 332, 31);
			emailPattern.setColumns(10);
		}
		return emailPattern;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("이메일 입력");
			lblNewLabel_1.setBounds(12, 51, 72, 31);
		}
		return lblNewLabel_1;
	}
	public JTextField getEmailValue() {
		if (emailValue == null) {
			emailValue = new JTextField();
			emailValue.setText("hipwg@,hipwg@naver,hipwg@naver.com");
			emailValue.setColumns(10);
			emailValue.setBounds(96, 51, 332, 31);
		}
		return emailValue;
	}
	public JButton getBtnNewButton_1_2() {
		if (btnNewButton_1_2 == null) {
			btnNewButton_1_2 = new JButton("이메일 체크");
			btnNewButton_1_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String ep = emailPattern.getText();
					String[] temp1 = emailValue.getText().split(",");
					for(int i=0; i<temp1.length; i++) {
						boolean b = Pattern.matches(ep, temp1[i]);
						textArea.append("emailPattern : " + ep + "\n");
						textArea.append("email : " + temp1[i] + "\n");
						textArea.append("check : " + b + "\n");
					}
				}
			});
			btnNewButton_1_2.setBounds(440, 10, 97, 72);
		}
		return btnNewButton_1_2;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("연락처 패턴");
			lblNewLabel_2.setBounds(12, 104, 72, 31);
		}
		return lblNewLabel_2;
	}
	public JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("연락처 입력");
			lblNewLabel_1_1.setBounds(12, 145, 72, 31);
		}
		return lblNewLabel_1_1;
	}
	public JTextField getPhoneValue() {
		if (phoneValue == null) {
			phoneValue = new JTextField();
			phoneValue.setText("02-12-1234,02-123-1234,02-1234-123");
			phoneValue.setColumns(10);
			phoneValue.setBounds(96, 145, 332, 31);
		}
		return phoneValue;
	}
	public JTextField getPhonePattern() {
		if (phonePattern == null) {
			phonePattern = new JTextField();
			phonePattern.setText("\\d{2,3}-\\d{3,4}-\\d{4}$");
			phonePattern.setColumns(10);
			phonePattern.setBounds(96, 104, 332, 31);
		}
		return phonePattern;
	}
	public JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("연락처 체크");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String pp = phonePattern.getText();
					String[] temp2 = phoneValue.getText().split(",");
					for(int i=0; i<temp2.length; i++) {
						boolean b = Pattern.matches(pp, temp2[i]);
						textArea.append("phonePattern : " + pp + "\n");
						textArea.append("phone : " + temp2[i] + "\n");
						textArea.append("check : " + b + "\n");
					}
				}
			});
			btnNewButton_1.setBounds(440, 104, 97, 72);
		}
		return btnNewButton_1;
	}
	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(12, 92, 525, 2);
		}
		return separator;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 186, 525, 157);
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
}
