package format;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import java.awt.Dimension;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;

public class FormatEx extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormatEx frame = new FormatEx();
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
	public FormatEx() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 678, 664);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
//		JPanel dp = new DecimalPanel(); // 다형성
//		contentPane.add(dp);    // 이거만 적으면 반영이 느리다.
//		MessageFormat mf = new MessageFormat();
//		contentPane.add(mf);
//		contentPane.updateUI(); // 이걸 적어야 반영이 빠르다.
	}
	public JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.setPreferredSize(new Dimension(0, 50));
			
			mnNewMenu = new JMenu("포멧");
			mnNewMenu.setFont(new Font("굴림", Font.BOLD, 20));
			menuBar.add(mnNewMenu);
			
			mntmNewMenuItem = new JMenuItem("DecimalFormat");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					contentPane.removeAll();
					JPanel panel = new DecimalPanel();
					contentPane.add(panel);
					contentPane.updateUI();
				}
			});
			mntmNewMenuItem.setFont(new Font("굴림", Font.BOLD, 20));
			mnNewMenu.add(mntmNewMenuItem);
			
			mntmNewMenuItem_1 = new JMenuItem("MessageFormat");
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					contentPane.removeAll();
					JPanel panel = new MessagePanel();
					contentPane.add(panel);
					contentPane.updateUI();
				}
			});
			mntmNewMenuItem_1.setFont(new Font("굴림", Font.BOLD, 20));
			mnNewMenu.add(mntmNewMenuItem_1);
			
			mntmNewMenuItem_2 = new JMenuItem("SimpleDateFormat");
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					contentPane.removeAll();
					JPanel panel = new SimpleDatePanel();
					contentPane.add(panel);
					contentPane.updateUI();
				}
			});
			mntmNewMenuItem_2.setFont(new Font("굴림", Font.BOLD, 20));
			mnNewMenu.add(mntmNewMenuItem_2);
			
			mntmNewMenuItem_3 = new JMenuItem("ChoiceFormat");
			mntmNewMenuItem_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					contentPane.removeAll();
					JPanel panel = new ChoicePanel();
					contentPane.add(panel);
					contentPane.updateUI();
				}
			});
			mntmNewMenuItem_3.setFont(new Font("굴림", Font.BOLD, 20));
			mnNewMenu.add(mntmNewMenuItem_3);
		}
		return menuBar;
	}
}