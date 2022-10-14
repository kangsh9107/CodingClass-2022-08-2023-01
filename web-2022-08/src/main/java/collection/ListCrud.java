package collection;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class ListCrud extends JPanel {
	private JSeparator separator;
	private JButton btnNewButton_1;
	private JButton btnNewButton_1_1;
	private JButton btnNewButton_1_2;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;
	private JTextField textField_1;
	private JTextField textField_2;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public ListCrud() {
		setLayout(null);
		add(getSeparator());
		add(getBtnNewButton_1());
		add(getBtnNewButton_1_1());
		add(getBtnNewButton_1_2());
		add(getTextField());
		add(getLblNewLabel_2());
		add(getLblNewLabel_1());
		add(getLblNewLabel());
		add(getTextField_1());
		add(getTextField_2());
		add(getBtnNewButton());
		add(getScrollPane());

	}

	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(12, 130, 342, 2);
		}
		return separator;
	}
	public JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("저장");
			btnNewButton_1.setForeground(new Color(255, 128, 0));
			btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 20));
			btnNewButton_1.setBackground(new Color(255, 128, 0));
			btnNewButton_1.setBounds(104, 142, 80, 30);
		}
		return btnNewButton_1;
	}
	public JButton getBtnNewButton_1_1() {
		if (btnNewButton_1_1 == null) {
			btnNewButton_1_1 = new JButton("수정");
			btnNewButton_1_1.setForeground(new Color(255, 128, 0));
			btnNewButton_1_1.setFont(new Font("굴림", Font.BOLD, 20));
			btnNewButton_1_1.setBackground(new Color(255, 128, 0));
			btnNewButton_1_1.setBounds(196, 142, 80, 30);
		}
		return btnNewButton_1_1;
	}
	public JButton getBtnNewButton_1_2() {
		if (btnNewButton_1_2 == null) {
			btnNewButton_1_2 = new JButton("삭제");
			btnNewButton_1_2.setForeground(new Color(255, 128, 0));
			btnNewButton_1_2.setFont(new Font("굴림", Font.BOLD, 20));
			btnNewButton_1_2.setBackground(new Color(255, 128, 0));
			btnNewButton_1_2.setBounds(288, 142, 80, 30);
		}
		return btnNewButton_1_2;
	}
	public JTextField getTextField() {
		if (textField == null) {
			textField = new JTextField();
			textField.setFont(new Font("굴림", Font.BOLD, 20));
			textField.setColumns(10);
			textField.setBorder(new LineBorder(new Color(0, 0, 255), 2));
			textField.setBounds(104, 90, 264, 30);
		}
		return textField;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("나이");
			lblNewLabel_2.setForeground(Color.BLUE);
			lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 20));
			lblNewLabel_2.setBounds(12, 90, 80, 30);
		}
		return lblNewLabel_2;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("성명");
			lblNewLabel_1.setForeground(Color.BLUE);
			lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
			lblNewLabel_1.setBounds(12, 50, 80, 30);
		}
		return lblNewLabel_1;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("아이디");
			lblNewLabel.setForeground(Color.BLUE);
			lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
			lblNewLabel.setBounds(12, 10, 80, 30);
		}
		return lblNewLabel;
	}
	public JTextField getTextField_1() {
		if (textField_1 == null) {
			textField_1 = new JTextField();
			textField_1.setFont(new Font("굴림", Font.BOLD, 20));
			textField_1.setColumns(10);
			textField_1.setBorder(new LineBorder(new Color(0, 0, 255), 2));
			textField_1.setBounds(104, 10, 264, 30);
		}
		return textField_1;
	}
	public JTextField getTextField_2() {
		if (textField_2 == null) {
			textField_2 = new JTextField();
			textField_2.setFont(new Font("굴림", Font.BOLD, 20));
			textField_2.setColumns(10);
			textField_2.setBorder(new LineBorder(new Color(0, 0, 255), 2));
			textField_2.setBounds(104, 50, 264, 30);
		}
		return textField_2;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("조회");
			btnNewButton.setForeground(new Color(255, 128, 0));
			btnNewButton.setFont(new Font("굴림", Font.BOLD, 20));
			btnNewButton.setBackground(new Color(255, 128, 0));
			btnNewButton.setBounds(380, 10, 80, 30);
		}
		return btnNewButton;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(472, 10, 356, 551);
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
