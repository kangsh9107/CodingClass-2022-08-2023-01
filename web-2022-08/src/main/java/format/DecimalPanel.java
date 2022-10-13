package format;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Color;

public class DecimalPanel extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel lblDecimalformat;
	private JTextField pattern;
	private JTextField number;

	/**
	 * Create the panel.
	 */
	public DecimalPanel() {
		setLayout(null);
		add(getLblNewLabel());
		add(getLblNewLabel_1());
		add(getBtnNewButton());
		add(getScrollPane());
		add(getLblDecimalformat());
		add(getTextField_2());
		add(getTextField_1_1());

	}

	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("패턴");
			lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
			lblNewLabel.setBounds(12, 10, 83, 38);
		}
		return lblNewLabel;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("숫자");
			lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
			lblNewLabel_1.setBounds(12, 58, 83, 38);
		}
		return lblNewLabel_1;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("실행");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					double d = Double.parseDouble(number.getText());
					String p = pattern.getText();
					DecimalFormat df = new DecimalFormat(p);
					String r = df.format(d);
					textArea.append("pattern : " + p + "\n");
					textArea.append("number  : " + d + "\n");
					textArea.append("result  : " + r + "\n");
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
		}
		return textArea;
	}
	public JLabel getLblDecimalformat() {
		if (lblDecimalformat == null) {
			lblDecimalformat = new JLabel("Decimal");
			lblDecimalformat.setForeground(new Color(255, 128, 0));
			lblDecimalformat.setFont(new Font("굴림", Font.BOLD, 20));
			lblDecimalformat.setBounds(12, 106, 83, 38);
		}
		return lblDecimalformat;
	}
	public JTextField getTextField_2() {
		if (pattern == null) {
			pattern = new JTextField();
			pattern.setFont(new Font("굴림", Font.BOLD, 20));
			pattern.setColumns(10);
			pattern.setBounds(107, 10, 331, 38);
		}
		return pattern;
	}
	public JTextField getTextField_1_1() {
		if (number == null) {
			number = new JTextField();
			number.setFont(new Font("굴림", Font.BOLD, 20));
			number.setColumns(10);
			number.setBounds(107, 58, 331, 38);
		}
		return number;
	}
}
