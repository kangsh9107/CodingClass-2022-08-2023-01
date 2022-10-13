package format;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.text.ChoiceFormat;
import java.awt.event.ActionEvent;

public class ChoicePanel extends JPanel {
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JTextField grade;
	private JTextField limit;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JLabel lblChoice;
	private JLabel lblNewLabel_1_1;
	private JTextField score;

	/**
	 * Create the panel.
	 */
	public ChoicePanel() {
		setLayout(null);
		add(getLblNewLabel_2());
		add(getLblNewLabel_1_1());
		add(getTextField_2());
		add(getTextField_1_1());
		add(getBtnNewButton_1());
		add(getScrollPane_1());
		add(getLblChoice());
		add(getLblNewLabel_1_1_1());
		add(getScore());

	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("등급컷");
			lblNewLabel.setFont(new Font("굴림", Font.BOLD, 20));
			lblNewLabel.setBounds(12, 10, 83, 38);
		}
		return lblNewLabel;
	}
	public JLabel getLblNewLabel_1_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("등급");
			lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
			lblNewLabel_1.setBounds(12, 58, 83, 38);
		}
		return lblNewLabel_1;
	}
	public JTextField getTextField_2() {
		if (grade == null) {
			grade = new JTextField();
			grade.setText("F,D,C,B,A");
			grade.setFont(new Font("굴림", Font.BOLD, 20));
			grade.setColumns(10);
			grade.setBounds(107, 58, 331, 38);
		}
		return grade;
	}
	public JTextField getTextField_1_1() {
		if (limit == null) {
			limit = new JTextField();
			limit.setText("0,40,60,80,100");
			limit.setFont(new Font("굴림", Font.BOLD, 20));
			limit.setColumns(10);
			limit.setBounds(107, 10, 331, 38);
		}
		return limit;
	}
	public JButton getBtnNewButton_1() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("실행");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					String[] temp1 = score.getText().split(",");
					int[] s = new int[temp1.length];
					for(int i=0; i<s.length; i++) {
						s[i] = Integer.parseInt(temp1[i]);
					}
					
					String[] temp2 = limit.getText().split(",");
					double[] d = new double[temp2.length];
					for(int i=0; i<d.length; i++) {
						d[i] = Double.parseDouble(temp2[i]);
					}
					
					String[] g = grade.getText().split(",");
					ChoiceFormat c = new ChoiceFormat(d, g);
					
					for(int i=0; i<s.length; i++) {
						textArea.append(s[i] + " = " + c.format(s[i]) + "\n");
					}
					
				}
			});
			btnNewButton.setFont(new Font("굴림", Font.BOLD, 20));
			btnNewButton.setBounds(107, 156, 331, 38);
		}
		return btnNewButton;
	}
	public JScrollPane getScrollPane_1() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 204, 426, 87);
			scrollPane.setViewportView(getTextArea_1());
		}
		return scrollPane;
	}
	public JTextArea getTextArea_1() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setFont(new Font("굴림", Font.BOLD, 20));
		}
		return textArea;
	}
	public JLabel getLblChoice() {
		if (lblChoice == null) {
			lblChoice = new JLabel("Choice");
			lblChoice.setForeground(new Color(255, 128, 0));
			lblChoice.setFont(new Font("굴림", Font.BOLD, 20));
			lblChoice.setBounds(12, 156, 83, 38);
		}
		return lblChoice;
	}
	public JLabel getLblNewLabel_1_1_1() {
		if (lblNewLabel_1_1 == null) {
			lblNewLabel_1_1 = new JLabel("점수");
			lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 20));
			lblNewLabel_1_1.setBounds(12, 108, 83, 38);
		}
		return lblNewLabel_1_1;
	}
	public JTextField getScore() {
		if (score == null) {
			score = new JTextField();
			score.setText("10,123,5235,50,60,70,80,90,100,0,56,82");
			score.setFont(new Font("굴림", Font.BOLD, 20));
			score.setColumns(10);
			score.setBounds(107, 108, 331, 38);
		}
		return score;
	}
}
