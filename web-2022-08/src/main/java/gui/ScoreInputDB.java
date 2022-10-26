package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import jdbc.ScoreDto;
import jdbc.ScoreVo;

public class ScoreInputDB extends JInternalFrame {
	MyInterMain main;
	ScoreDto dto;
	
	private JLabel lblNewLabel;
	private JTextField tfSerial;
	private JLabel lblId;
	private JTextField tfId;
	private JLabel lblSubject;
	private JTextField tfSubject;
	private JLabel lblDate;
	private JTextField tfScore;
	private JLabel lblScore;
	private JTextField tfMdate;
	private JButton btnSave;
	private JButton btnModify;
	private JButton btnDelete;
	private JTextField tfResult;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreInputDB frame = new ScoreInputDB();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void loadData(ScoreVo vo) {
		String serial = Integer.toString(vo.getSerial());
		String score = Double.toString(vo.getScore());
		
		tfSerial.setText(serial);
		tfId.setText(vo.getId());
		tfSubject.setText(vo.getSubject());
		tfScore.setText(score);
		tfMdate.setText(vo.getMdate());
	}

	public ScoreInputDB(MyInterMain main) {
		this();
		this.main = main;
	}
	
	/**
	 * Create the frame.
	 */
	public ScoreInputDB() {
		super("성적입력DB", false, true, true, true);
		setVisible(true);
		dto = new ScoreDto();
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				main.sid = null;
			}
		});
		setBounds(100, 100, 340, 230);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getTfSerial());
		getContentPane().add(getLblId());
		getContentPane().add(getTfId());
		getContentPane().add(getLblSubject());
		getContentPane().add(getTfSubject());
		getContentPane().add(getLblDate());
		getContentPane().add(getTfScore());
		getContentPane().add(getLblScore());
		getContentPane().add(getTfMdate());
		getContentPane().add(getBtnSave());
		getContentPane().add(getBtnModify());
		getContentPane().add(getBtnDelete());
		getContentPane().add(getTfResult());

	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel("Serial");
			lblNewLabel.setBounds(12, 10, 52, 15);
		}
		return lblNewLabel;
	}
	public JTextField getTfSerial() {
		if (tfSerial == null) {
			tfSerial = new JTextField();
			tfSerial.setBounds(76, 7, 52, 21);
			tfSerial.setColumns(10);
		}
		return tfSerial;
	}
	public JLabel getLblId() {
		if (lblId == null) {
			lblId = new JLabel("ID");
			lblId.setBounds(12, 38, 52, 15);
		}
		return lblId;
	}
	public JTextField getTfId() {
		if (tfId == null) {
			tfId = new JTextField();
			tfId.setColumns(10);
			tfId.setBounds(76, 35, 138, 21);
		}
		return tfId;
	}
	public JLabel getLblSubject() {
		if (lblSubject == null) {
			lblSubject = new JLabel("과목");
			lblSubject.setBounds(12, 66, 52, 15);
		}
		return lblSubject;
	}
	public JTextField getTfSubject() {
		if (tfSubject == null) {
			tfSubject = new JTextField();
			tfSubject.setColumns(10);
			tfSubject.setBounds(76, 63, 245, 21);
		}
		return tfSubject;
	}
	public JLabel getLblDate() {
		if (lblDate == null) {
			lblDate = new JLabel("점수");
			lblDate.setBounds(12, 94, 52, 15);
		}
		return lblDate;
	}
	public JTextField getTfScore() {
		if (tfScore == null) {
			tfScore = new JTextField();
			tfScore.setColumns(10);
			tfScore.setBounds(76, 91, 52, 21);
		}
		return tfScore;
	}
	public JLabel getLblScore() {
		if (lblScore == null) {
			lblScore = new JLabel("시험일자");
			lblScore.setBounds(12, 122, 52, 15);
		}
		return lblScore;
	}
	public JTextField getTfMdate() {
		if (tfMdate == null) {
			tfMdate = new JTextField();
			tfMdate.setColumns(10);
			tfMdate.setBounds(76, 119, 95, 21);
		}
		return tfMdate;
	}
	public JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("저장");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// 전처리
					String id = tfId.getText();
					String subject = tfSubject.getText();
					double score = Double.parseDouble(tfScore.getText());
					String mdate = tfMdate.getText();
					
					// serial이 autoIncreament면 serial 입력값 가져올 필요없이 그냥 명시적으로 0을 작성
					// 0, id, subject, score, mdate로 작성하기 보단 생성자를 중복작성해서 id, subject, score, mdate를 입력받게 하는 게 정석
					/*
					 * 컬럼명 INT AUTO_INCREMENT PRIMARY KEY,
					 * ALTER TABLE 테이블명 MODIFY 칼럼명 INT NOT NULL AUTO_INCREAMENT PRIMARY KEY FIRST;
					 * ALTER TABLE 테이블명 MODIFY 칼럼명 INT NOT NULL AUTO_INCREAMENT;
					 */
					
					// 메인
					ScoreVo vo = new ScoreVo(0, id, subject, score, mdate);
					int cnt = dto.insert(vo);
					
					// 후처리
					if(cnt > 0) {
						tfResult.setText("저장완료");

						if(main.ssd == null) {
							main.ssd = new ScoreSearchDB(main);
							main.getDesktopPane().add(main.ssd);
							main.getDesktopPane().updateUI();
							main.ssd.toFront();
						}
						
						main.ssd.getFindStr().setText("");
						main.ssd.select();
					} else {
						tfResult.setText("저장오류");
					}
				}
			});
			btnSave.setBounds(12, 147, 95, 23);
		}
		return btnSave;
	}
	public JButton getBtnModify() {
		if (btnModify == null) {
			btnModify = new JButton("수정");
			btnModify.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int serial = Integer.parseInt(tfSerial.getText());
					String id = tfId.getText();
					String subject = tfSubject.getText();
					double score = Double.parseDouble(tfScore.getText());
					String mdate = tfMdate.getText();
					
					ScoreVo vo = new ScoreVo(serial, id, subject, score, mdate);
					int cnt = dto.update(vo);
					
					if(cnt > 0) {
						tfResult.setText("수정완료");

						if(main.ssd == null) {
							main.ssd = new ScoreSearchDB(main);
							main.getDesktopPane().add(main.ssd);
							main.getDesktopPane().updateUI();
							main.ssd.toFront();
						}
						
						main.ssd.getFindStr().setText("");
						main.ssd.select();
					} else {
						tfResult.setText("수정오류");
					}
				}
			});
			btnModify.setBounds(119, 147, 95, 23);
		}
		return btnModify;
	}
	public JButton getBtnDelete() {
		if (btnDelete == null) {
			btnDelete = new JButton("삭제");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int serial = Integer.parseInt(getTfSerial().getText());
					
					int cnt = dto.delete(serial);
					if(cnt > 0) {
						tfResult.setText("삭제완료");
						tfSerial.setText("");
						tfId.setText("");
						tfSubject.setText("");
						tfScore.setText("");
						tfMdate.setText("");
						
						if(main.ssd == null) {
							main.ssd = new ScoreSearchDB(main);
							main.getDesktopPane().add(main.ssd);
							main.getDesktopPane().updateUI();
							main.ssd.toFront();
						}
						
						main.ssd.getFindStr().setText("");
						main.ssd.select();
					} else {
						tfResult.setText("삭제오류");
					}
				}
			});
			btnDelete.setBounds(226, 147, 95, 23);
		}
		return btnDelete;
	}
	public JTextField getTfResult() {
		if (tfResult == null) {
			tfResult = new JTextField();
			tfResult.setBounds(1, 180, 329, 21);
			tfResult.setColumns(10);
		}
		return tfResult;
	}
}
