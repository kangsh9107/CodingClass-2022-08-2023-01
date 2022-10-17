package collection;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.awt.event.ActionEvent;

public class SetFrame extends JInternalFrame {
	private JButton btnNewButton_2;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnNewButton_2_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetFrame frame = new SetFrame();
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
	public SetFrame() {
		super("로또 번호 추첨", false, true, false, true);
		setBounds(100, 100, 420, 400);
		getContentPane().setLayout(null);
		getContentPane().add(getBtnNewButton_2());
		getContentPane().add(getScrollPane());
		getContentPane().add(getBtnNewButton_2_1());
		setVisible(true);

	}

	List<Integer> li = new ArrayList<>();
	public JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("로또 번호 추첨");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Set<Integer> hs = new HashSet<>();
					
					for(int i=0; i<5; i++) {
						while(hs.size() < 6) {
							hs.add( (int)((Math.random()*45) + 1) );
						}
						
						Iterator<Integer> iter = hs.iterator();
						while(iter.hasNext()) {
							li.add(iter.next());
						}
						
						Collections.sort(li);
						
						textArea.append(li.toString() + "\n");
						hs.removeAll(hs);
						li.removeAll(li);
					}
				}
			});
			btnNewButton_2.setForeground(Color.WHITE);
			btnNewButton_2.setFont(new Font("굴림", Font.BOLD, 20));
			btnNewButton_2.setBackground(new Color(82, 208, 21));
			btnNewButton_2.setBounds(12, 331, 180, 30);
		}
		return btnNewButton_2;
	}
	
	public String s() {
		String str = "";
		
		for(int i=0; i<6; i++) {
			
		}
		
		return str;
	}
	
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(12, 10, 386, 311);
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	public JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setBorder(new LineBorder(new Color(0, 0, 255), 2));
			textArea.setFont(new Font("굴림", Font.BOLD, 20));
		}
		return textArea;
	}
	public JButton getBtnNewButton_2_1() {
		if (btnNewButton_2_1 == null) {
			btnNewButton_2_1 = new JButton("화면 지우기");
			btnNewButton_2_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textArea.setText("");
				}
			});
			btnNewButton_2_1.setForeground(Color.WHITE);
			btnNewButton_2_1.setFont(new Font("굴림", Font.BOLD, 20));
			btnNewButton_2_1.setBackground(new Color(146, 18, 37));
			btnNewButton_2_1.setBounds(218, 331, 180, 30);
		}
		return btnNewButton_2_1;
	}
}
