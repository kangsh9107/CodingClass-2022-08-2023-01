package collection;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;

public class ListFrame extends JInternalFrame {
	List<Data> li = new ArrayList<>();
	int m_index = -1; // 전역형으로 사용
	
	private JSeparator separator;
	private JButton btnNewButton_1;
	private JButton btnNewButton_1_1;
	private JButton btnNewButton_1_2;
	private JTextField inputAge;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel;
	private JTextField inputId;
	private JTextField inputIrum;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTextArea textArea;
	private JButton btnNewButton_2;
	private JTextField message;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ListFrame frame = new ListFrame();
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
	public ListFrame() {
		super("회원정보입력", true, true, true, true);
		setBounds(100, 100, 850, 400);
		setVisible(true);
		getContentPane().setLayout(null);
		getContentPane().add(getSeparator());
		getContentPane().add(getBtnNewButton_1());
		getContentPane().add(getBtnNewButton_1_1());
		getContentPane().add(getBtnNewButton_1_2());
		getContentPane().add(getInputAge());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getInputId());
		getContentPane().add(getInputIrum());
		getContentPane().add(getBtnNewButton());
		getContentPane().add(getScrollPane());
		getContentPane().add(getBtnNewButton_2());
		getContentPane().add(getMessage());

	}

	public JSeparator getSeparator() {
		if (separator == null) {
			separator = new JSeparator();
			separator.setBounds(12, 130, 356, 2);
		}
		return separator;
	}
	public JButton getBtnNewButton_1() {
		if (btnNewButton_1 == null) {
			btnNewButton_1 = new JButton("저장");
			btnNewButton_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String mId = inputId.getText();
					String mIrum = inputIrum.getText();
					int mAge = Integer.parseInt(inputAge.getText());
					
					Data data = new Data(mId, mIrum, mAge);
					li.add(data);
					
					inputId.requestFocus(); // 커서 이동
					inputId.selectAll();    // 전체 선택
					message.setText("저장완료!");
				}
			});
			btnNewButton_1.setForeground(new Color(255, 255, 255));
			btnNewButton_1.setFont(new Font("굴림", Font.BOLD, 20));
			btnNewButton_1.setBackground(new Color(0, 0, 0));
			btnNewButton_1.setBounds(104, 142, 80, 30);
		}
		return btnNewButton_1;
	}
	public JButton getBtnNewButton_1_1() {
		if (btnNewButton_1_1 == null) {
			btnNewButton_1_1 = new JButton("수정");
			btnNewButton_1_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(m_index >= 0) {
						String mId = inputId.getText();
						String mIrum = inputIrum.getText();
						int mAge = Integer.parseInt( inputAge.getText() );
						Data d = new Data(mId, mIrum, mAge);
						li.set(m_index, d);
						m_index = -1;
						message.setText("수정완료!");
					} else {
						message.setText("수정할 자료를 먼저 검색해 주세요.");
					}
				}
			});
			btnNewButton_1_1.setForeground(new Color(255, 255, 255));
			btnNewButton_1_1.setFont(new Font("굴림", Font.BOLD, 20));
			btnNewButton_1_1.setBackground(new Color(0, 0, 0));
			btnNewButton_1_1.setBounds(196, 142, 80, 30);
		}
		return btnNewButton_1_1;
	}
	public JButton getBtnNewButton_1_2() {
		if (btnNewButton_1_2 == null) {
			btnNewButton_1_2 = new JButton("삭제");
			btnNewButton_1_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(m_index >= 0) {
						li.remove(m_index);
						inputId.setText("");
						inputIrum.setText("");
						inputAge.setText("");
						textArea.setText("");
						inputId.requestFocus();
						m_index = -1;
						message.setText("삭제완료!");
					} else {
						message.setText("삭제할 자료를 먼저 검색해 주세요.");
					}
				}
			});
			btnNewButton_1_2.setForeground(new Color(255, 255, 255));
			btnNewButton_1_2.setFont(new Font("굴림", Font.BOLD, 20));
			btnNewButton_1_2.setBackground(new Color(0, 0, 0));
			btnNewButton_1_2.setBounds(288, 142, 80, 30);
		}
		return btnNewButton_1_2;
	}
	public JTextField getInputAge() {
		if (inputAge == null) {
			inputAge = new JTextField();
			inputAge.setText("20");
			inputAge.setFont(new Font("굴림", Font.BOLD, 20));
			inputAge.setColumns(10);
			inputAge.setBorder(new LineBorder(new Color(0, 0, 255), 2));
			inputAge.setBounds(104, 90, 80, 30);
		}
		return inputAge;
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
	public JTextField getInputId() {
		if (inputId == null) {
			inputId = new JTextField();
			inputId.setText("a001");
			inputId.setFont(new Font("굴림", Font.BOLD, 20));
			inputId.setColumns(10);
			inputId.setBorder(new LineBorder(new Color(0, 0, 255), 2));
			inputId.setBounds(104, 10, 264, 30);
		}
		return inputId;
	}
	public JTextField getInputIrum() {
		if (inputIrum == null) {
			inputIrum = new JTextField();
			inputIrum.setText("hong");
			inputIrum.setFont(new Font("굴림", Font.BOLD, 20));
			inputIrum.setColumns(10);
			inputIrum.setBorder(new LineBorder(new Color(0, 0, 255), 2));
			inputIrum.setBounds(104, 50, 172, 30);
		}
		return inputIrum;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("조회");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String mId = inputId.getText();
					
					// 재정의한 hashCode와 equals가 id만 비교하기 때문에 irum과 age는 뭘적든 상관없다
					Data temp = new Data(mId, "kim", 12);
					m_index = li.indexOf(temp);
					if(m_index >= 0) {
						Data d = li.get(m_index);
						inputIrum.setText(d.getIrum());
						inputAge.setText(d.getAge() + "");
						message.setText("조회완료!");
					}
					else {
						message.setText("찾는 데이터가 없습니다.");
						inputIrum.setText("");
						inputAge.setText("");
					}
				}
			});
			btnNewButton.setForeground(new Color(255, 255, 255));
			btnNewButton.setFont(new Font("굴림", Font.BOLD, 20));
			btnNewButton.setBackground(new Color(0, 0, 0));
			btnNewButton.setBounds(380, 10, 80, 30);
		}
		return btnNewButton;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBounds(472, 50, 356, 261);
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}
	public JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setFont(new Font("굴림", Font.BOLD, 20));
			textArea.setBorder(new LineBorder(new Color(0, 0, 255), 2));
		}
		return textArea;
	}
	public JButton getBtnNewButton_2() {
		if (btnNewButton_2 == null) {
			btnNewButton_2 = new JButton("전체출력");
			btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					textArea.setText("");
					for(Data d : li) {
						textArea.append(d.toString());
					}
				}
			});
			btnNewButton_2.setForeground(Color.WHITE);
			btnNewButton_2.setFont(new Font("굴림", Font.BOLD, 20));
			btnNewButton_2.setBackground(Color.BLACK);
			btnNewButton_2.setBounds(472, 10, 356, 30);
		}
		return btnNewButton_2;
	}
	public JTextField getMessage() {
		if (message == null) {
			message = new JTextField();
			message.setBorder(new LineBorder(new Color(0, 0, 255), 2));
			message.setFont(new Font("굴림", Font.BOLD, 20));
			message.setBounds(12, 321, 816, 40);
			message.setColumns(10);
		}
		return message;
	}
}
