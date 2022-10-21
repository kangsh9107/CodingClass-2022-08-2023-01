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

import iostream.ScoreDao;
import iostream.ScoreVo;

public class ScoreInput extends JInternalFrame {
	MyInterMain main;
	ScoreDao dao;
	
	private JLabel lblNewLabel;
	private JTextField tfSerial;
	private JLabel lblId;
	private JTextField tfId;
	private JLabel lblSubject;
	private JTextField tfMdate;
	private JLabel lblDate;
	private JTextField tfSubject;
	private JLabel lblScore;
	private JTextField tfScore;
	private JButton btnSave;
	private JButton btnModify;
	private JButton btnDelete;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ScoreInput frame = new ScoreInput();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ScoreInput(MyInterMain main) {
		this();
		this.main = main;
	}
	
	/**
	 * Create the frame.
	 */
	public ScoreInput() {
		super("성적입력", false, true, true, true);
		setVisible(true);
		dao = new ScoreDao();
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				main.si = null;
			}
		});
		setBounds(100, 100, 340, 210);
		getContentPane().setLayout(null);
		getContentPane().add(getLblNewLabel());
		getContentPane().add(getTfSerial());
		getContentPane().add(getLblId());
		getContentPane().add(getTfId());
		getContentPane().add(getLblSubject());
		getContentPane().add(getTfMdate());
		getContentPane().add(getLblDate());
		getContentPane().add(getTfSubject());
		getContentPane().add(getLblScore());
		getContentPane().add(getTfScore());
		getContentPane().add(getBtnSave());
		getContentPane().add(getBtnModify());
		getContentPane().add(getBtnDelete());

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
			tfSerial.setBounds(76, 7, 95, 21);
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
			lblSubject = new JLabel("시험일자");
			lblSubject.setBounds(12, 66, 52, 15);
		}
		return lblSubject;
	}
	public JTextField getTfMdate() {
		if (tfMdate == null) {
			tfMdate = new JTextField();
			tfMdate.setColumns(10);
			tfMdate.setBounds(76, 63, 138, 21);
		}
		return tfMdate;
	}
	public JLabel getLblDate() {
		if (lblDate == null) {
			lblDate = new JLabel("과목");
			lblDate.setBounds(12, 94, 52, 15);
		}
		return lblDate;
	}
	public JTextField getTfSubject() {
		if (tfSubject == null) {
			tfSubject = new JTextField();
			tfSubject.setColumns(10);
			tfSubject.setBounds(76, 91, 245, 21);
		}
		return tfSubject;
	}
	public JLabel getLblScore() {
		if (lblScore == null) {
			lblScore = new JLabel("점수");
			lblScore.setBounds(12, 122, 52, 15);
		}
		return lblScore;
	}
	public JTextField getTfScore() {
		if (tfScore == null) {
			tfScore = new JTextField();
			tfScore.setColumns(10);
			tfScore.setBounds(76, 119, 95, 21);
		}
		return tfScore;
	}
	public JButton getBtnSave() {
		if (btnSave == null) {
			btnSave = new JButton("저장");
			btnSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int serial = Integer.parseInt(tfSerial.getText());
					String id = tfId.getText();
					String mDate = tfMdate.getText();
					String subject = tfSubject.getText();
					int score = Integer.parseInt(tfScore.getText());
					
					ScoreVo vo = new ScoreVo(serial, id, mDate, subject, score);
					dao.write(vo);
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
					// 수정된 정보를 가져와 ScoreVo객체 생성
					int serial = Integer.parseInt(getTfSerial().getText());
					String id = getTfId().getText();
					String mDate = getTfMdate().getText();
					String subject = getTfSubject().getText();
					int score = Integer.parseInt(getTfScore().getText());
					
					ScoreVo vo = new ScoreVo(serial, id, mDate, subject, score);
					
					// ScoreDao.modify(vo) 호출
					dao.modify(vo);
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
					
					dao.delete(serial);
				}
			});
			btnDelete.setBounds(226, 147, 95, 23);
		}
		return btnDelete;
	}
}
