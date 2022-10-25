package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import jdbc.MemberDto;
import jdbc.MemberVo;
import javax.swing.JPanel;

public class MemberInputDB extends JInternalFrame {
	MyInterMain main;
	Connection conn;
	
	// 라디오 버튼을 그룹화
	ButtonGroup bg = new ButtonGroup();
	
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JTextField tfPicture;
	private JTextField tfPhone;
	private JTextField tfIrum;
	private JTextField tfId;
	private JButton btnSave;
	private JButton btnModify;
	private JButton btnDelete;
	
	private JRadioButton btnGenderM;
	private JRadioButton btnGenderF;
	private JButton btnPictureSelect;
	private JTextField tfResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberInputDB frame = new MemberInputDB();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	// 강사님 코드(조회에서 테이블 클릭하면 가입화면에 뿌려줌)
	public void loadData(MemberVo vo) {
		tfId.setText(vo.getId());
		tfIrum.setText(vo.getId());
		tfPhone.setText(vo.getId());
		tfPicture.setText(vo.getId());
		
		if(vo.getGender().equals("m")) btnGenderM.setSelected(true);
		else btnGenderF.setSelected(true);
	}
	
	public MemberInputDB(MyInterMain main) {
		this();
		this.main = main;
	}

	/**
	 * Create the frame.
	 */
	public MemberInputDB() {
		super("회원가입DB", false, true, true, true);
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				main.mid = null;
			}
		});
		setVisible(true);
		setBounds(100, 100, 440, 233);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getLblNewLabel_1());
		getContentPane().add(getLblNewLabel_2());
		getContentPane().add(getLblNewLabel_3());
		getContentPane().add(getLblNewLabel_4());
		getContentPane().add(getTfPicture());
		getContentPane().add(getTfPhone());
		getContentPane().add(getTfIrum());
		getContentPane().add(getTfId());
		getContentPane().add(getBtnSave());
		getContentPane().add(getBtnModify());
		getContentPane().add(getBtnDelete());
		getContentPane().add(getBtnGenderM());
		getContentPane().add(getBtnGenderF());
		getContentPane().add(getBtnPictureSelect());

		bg.add(getBtnGenderM());
		bg.add(getBtnGenderF());
		getContentPane().add(getTfResult());
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("아이디");
			lblNewLabel.setBounds(12, 13, 52, 15);
		}
		return lblNewLabel;
	}
	public JLabel getLblNewLabel_1() {
		if (lblNewLabel_1 == null) {
			lblNewLabel_1 = new JLabel("성명");
			lblNewLabel_1.setBounds(12, 41, 52, 15);
		}
		return lblNewLabel_1;
	}
	public JLabel getLblNewLabel_2() {
		if (lblNewLabel_2 == null) {
			lblNewLabel_2 = new JLabel("성별");
			lblNewLabel_2.setBounds(12, 69, 52, 15);
		}
		return lblNewLabel_2;
	}
	public JLabel getLblNewLabel_3() {
		if (lblNewLabel_3 == null) {
			lblNewLabel_3 = new JLabel("연락처");
			lblNewLabel_3.setBounds(12, 97, 52, 15);
		}
		return lblNewLabel_3;
	}
	public JLabel getLblNewLabel_4() {
		if (lblNewLabel_4 == null) {
			lblNewLabel_4 = new JLabel("증명사진");
			lblNewLabel_4.setBounds(12, 125, 52, 15);
		}
		return lblNewLabel_4;
	}
	public JTextField getTfPicture() {
		if (tfPicture == null) {
			tfPicture = new JTextField();
			tfPicture.setColumns(10);
			tfPicture.setBounds(76, 122, 224, 21);
		}
		return tfPicture;
	}
	public JTextField getTfPhone() {
		if (tfPhone == null) {
			tfPhone = new JTextField();
			tfPhone.setColumns(10);
			tfPhone.setBounds(76, 94, 160, 21);
		}
		return tfPhone;
	}
	public JTextField getTfIrum() {
		if (tfIrum == null) {
			tfIrum = new JTextField();
			tfIrum.setColumns(10);
			tfIrum.setBounds(76, 38, 160, 21);
		}
		return tfIrum;
	}
	public JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setColumns(10);
			tfId.setBounds(76, 10, 160, 21);
		}
		return tfId;
	}
	public JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("저장");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String id = tfId.getText();
					String irum = tfIrum.getText();
					String gender = btnGenderM.isSelected() ? "m" : "f";
					String phone = tfPhone.getText();
					String picture = tfPicture.getText();
					
					// 어떻게든 MemberVo 객체를 만들어서 인수로 입력
					MemberVo vo = new MemberVo(id, irum, gender, phone, picture);
					MemberDto dto = new MemberDto();
					
					int cnt = dto.insert(vo);
					if(cnt > 0) JOptionPane.showMessageDialog(MemberInputDB.this, "저장완료");
					else JOptionPane.showMessageDialog(MemberInputDB.this, "저장오류");
					
				}
			});
			btnSave.setBounds(76, 153, 106, 23);
		}
		return btnSave;
	}
	public JButton getBtnModify() {
		if (btnModify == null) {
			btnModify = new JButton("수정");
			btnModify.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String id = tfId.getText();
					String irum = tfIrum.getText();
					String gender = btnGenderM.isSelected() ? "m" : "f";
					String phone = tfPhone.getText();
					String picture = tfPicture.getText();
					
					MemberVo vo = new MemberVo(id, irum, gender, phone, picture);
					MemberDto dto = new MemberDto();
					int cnt = dto.update(vo);
					if(cnt > 0) {
						tfResult.setText("수정완료");
					} else {
						tfResult.setText("수정오류");
					}
				}
			});
			btnModify.setBounds(194, 153, 106, 23);
		}
		return btnModify;
	}
	public JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭제");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String id = tfId.getText();
					MemberDto dto = new MemberDto();
					
					int cnt = dto.delete(id);
					if(cnt > 0) {
						tfResult.setText("삭제완료");
						tfId.setText("");
						tfIrum.setText("");
						tfPhone.setText("");
						tfPicture.setText("");
					} else {
						tfResult.setText("삭제오류");
					}
				}
			});
			btnDelete.setBounds(312, 153, 106, 23);
		}
		return btnDelete;
	}
	public JRadioButton getBtnGenderM() {
		if (btnGenderM == null) {
			btnGenderM = new JRadioButton("늑대");
			btnGenderM.setBounds(72, 65, 52, 23);
		}
		return btnGenderM;
	}
	public JRadioButton getBtnGenderF() {
		if (btnGenderF == null) {
			btnGenderF = new JRadioButton("여시");
			btnGenderF.setBounds(130, 65, 52, 23);
		}
		return btnGenderF;
	}
	public JButton getBtnPictureSelect() {
		if (btnPictureSelect == null) {
			btnPictureSelect = new JButton("사진선택");
			btnPictureSelect.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JFileChooser fc = new JFileChooser();
					int flag = fc.showOpenDialog(MemberInputDB.this);
					
					if(flag == JFileChooser.APPROVE_OPTION) {
						String fn = fc.getSelectedFile().getPath();
						tfPicture.setText(fn);
					}
				}
			});
			btnPictureSelect.setBounds(312, 121, 106, 23);
		}
		return btnPictureSelect;
	}
	public JTextField getTfResult() {
		if (tfResult == null) {
			tfResult = new JTextField();
			tfResult.setBounds(0, 183, 430, 21);
			tfResult.setColumns(10);
		}
		return tfResult;
	}
}
