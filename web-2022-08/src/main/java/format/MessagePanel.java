package format;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.awt.event.ActionEvent;

public class MessagePanel extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField message;
	private JTextField members;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel lblMessage;

	/**
	 * Create the panel.
	 */
	public MessagePanel() {
		setLayout(null);
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getMessage());
		add(getMembers());
		add(getBtnNewButton());
		add(getScrollPane());
		add(getLblMessage());

	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("고객명단");
			lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
			lblNewLabel.setBounds(12, 10, 83, 38);
		}
		return lblNewLabel;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("메시지");
			lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
			lblNewLabel_1.setBounds(12, 58, 83, 38);
		}
		return lblNewLabel_1;
	}
	public JTextField getMessage() {
		if (message == null) {
			message = new JTextField();
			message.setText("{0}님 방가요.");
			message.setFont(new Font("굴림", Font.BOLD, 20));
			message.setColumns(10);
			message.setBounds(107, 58, 331, 38);
		}
		return message;
	}
	public JTextField getMembers() {
		if (members == null) {
			members = new JTextField();
			members.setText("가,나,다,라,마,바,사");
			members.setFont(new Font("굴림", Font.BOLD, 20));
			members.setColumns(10);
			members.setBounds(107, 10, 331, 38);
		}
		return members;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("실행");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					String str = "name : {0} \nage : {1} \naddress : {2}";
//					String args[] = {"hong","18","남원"};
//					String r = MessageFormat.format(str, args);
//					System.out.println(r);
					
//					SimpleDateFormat sd = new SimpleDateFormat(format.getText());
//					String r = sd.format(new Date());
//					textArea.append("format : " + format.getText() + "\n");
//					textArea.append("result : " + r + "\n");
					
					String member = members.getText();
					String[] arr = member.split(",");
					
//					String s = message.getText();
//					String r = MessageFormat.format(s, arr);
//					textArea.append(r);
					
					for(String s : arr) {
						String r = MessageFormat.format(message.getText(), s);
						textArea.append(r + "\n");
					}
				}
			});
			btnNewButton.setFont(new Font("굴림", Font.BOLD, 20));
			btnNewButton.setBounds(107, 106, 331, 38);
		}
		return btnNewButton;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 154, 426, 137);
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	public JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setFont(new Font("굴림", Font.BOLD, 20));
		}
		return textArea;
	}
	public JLabel getLblMessage() {
		if (lblMessage == null) {
			lblMessage = new JLabel("Message");
			lblMessage.setForeground(new Color(255, 128, 0));
			lblMessage.setFont(new Font("굴림", Font.BOLD, 20));
			lblMessage.setBounds(12, 106, 93, 38);
		}
		return lblMessage;
	}
}
