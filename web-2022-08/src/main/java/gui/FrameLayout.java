package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Dimension;

public class FrameLayout extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JPanel panel;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		// 쓰레드를 통한 다중처리
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrameLayout frame = new FrameLayout();
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
	public FrameLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 555, 451);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 128, 255));
		contentPane.setForeground(new Color(0, 255, 0));
		contentPane.setBorder(new LineBorder(new Color(255, 0, 128)));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getBtnNewButton(), BorderLayout.NORTH);
		contentPane.add(getPanel(), BorderLayout.WEST);
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
		}
		return btnNewButton;
	}
	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.add(getBtnNewButton_1());
		}
		return panel;
	}
	public JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("New button");
		}
		return btnNewButton_1;
	}
}
