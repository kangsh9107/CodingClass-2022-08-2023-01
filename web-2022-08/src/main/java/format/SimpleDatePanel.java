package format;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SimpleDatePanel extends JPanel {
	private JLabel lblNewLabel;
	private JTextField format;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel lblSimpledate;

	/**
	 * Create the panel.
	 */
	public SimpleDatePanel() {
		setLayout(null);
		add(getLblNewLabel());
		add(getFormat());
		add(getBtnNewButton());
		add(getScrollPane());
		add(getLblSimpledate());

	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("포멧");
			lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
			lblNewLabel.setBounds(12, 10, 83, 38);
		}
		return lblNewLabel;
	}
	public JTextField getFormat() {
		if (format == null) {
			format = new JTextField();
			format.setFont(new Font("굴림", Font.BOLD, 20));
			format.setColumns(10);
			format.setBounds(107, 10, 331, 38);
		}
		return format;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("실행");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					SimpleDateFormat sd = new SimpleDateFormat(format.getText());
					String r = sd.format(new Date());
					textArea.append("format : " + format.getText() + "\n");
					textArea.append("result : " + r + "\n");
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
	public JLabel getLblSimpledate() {
		if (lblSimpledate == null) {
			lblSimpledate = new JLabel("Date");
			lblSimpledate.setForeground(new Color(255, 128, 0));
			lblSimpledate.setFont(new Font("굴림", Font.BOLD, 20));
			lblSimpledate.setBounds(12, 106, 83, 38);
		}
		return lblSimpledate;
	}
}
