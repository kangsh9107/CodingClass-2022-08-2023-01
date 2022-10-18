package iostream;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.swing.JDesktopPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class MyTextEditor extends JFrame {

	private JPanel contentPane;
	private JDesktopPane desktopPane;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	
	protected static Editor get; // 클릭된 프레임이 타겟에 대입된다. 타겟이 된 프레임을 대상으로 저장, 수정 등의 기능 적용
	private JLabel result;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyTextEditor frame = new MyTextEditor();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void fileSave() {
		try {
			String data = get.getTextArea().getText();
			byte[] bytes = data.getBytes();
			File file = new File(get.getFileName());
			OutputStream os = new FileOutputStream(file);
			os.write(bytes);
			os.close();
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(MyTextEditor.this, ex.getMessage());
		}
	}

	/**
	 * Create the frame.
	 */
	public MyTextEditor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getDesktopPane(), BorderLayout.CENTER);
		contentPane.add(getResult(), BorderLayout.SOUTH);
	}

	public JDesktopPane getDesktopPane() {
		if (desktopPane == null) {
			desktopPane = new JDesktopPane();
		}
		return desktopPane;
	}
	public JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnNewMenu());
		}
		return menuBar;
	}
	public JMenu getMnNewMenu() {
		if (mnNewMenu == null) {
			mnNewMenu = new JMenu("File");
			mnNewMenu.add(getMntmNewMenuItem());
			mnNewMenu.add(getMntmNewMenuItem_1());
			mnNewMenu.add(getMntmNewMenuItem_2());
			mnNewMenu.add(getMntmNewMenuItem_3());
		}
		return mnNewMenu;
	}
	public JMenuItem getMntmNewMenuItem() {
		if (mntmNewMenuItem == null) {
			mntmNewMenuItem = new JMenuItem("새 파일");
			mntmNewMenuItem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JInternalFrame editor = new Editor();
					desktopPane.add(editor);
					desktopPane.updateUI();
					editor.toFront();
					get = (Editor)editor; // 새파일 만들었을 때 자동으로 활성화.
											 // 정석은 Editor가 아니라 JInternalFrame로 target 설정해야 더 자연스러움
				}
			});
		}
		return mntmNewMenuItem;
	}
	public JMenuItem getMntmNewMenuItem_1() {
		if (mntmNewMenuItem_1 == null) {
			mntmNewMenuItem_1 = new JMenuItem("열기");
			mntmNewMenuItem_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					try {
						JFileChooser fc = new JFileChooser();
						int flag = fc.showOpenDialog(MyTextEditor.this);
						
						if(flag == JFileChooser.APPROVE_OPTION) {
							File f = fc.getSelectedFile();
							StringBuffer sb = new StringBuffer();
							int readCnt = 0;
							byte[] bytes = new byte[4096];
							InputStream is = new FileInputStream(f);
							
							while( (readCnt=is.read(bytes)) != -1 ) {
								sb.append(new String(bytes, 0, readCnt));
							}
							
							Editor editor = new Editor();
							editor.setFileName(f.getPath());
							editor.getTextArea().setText(sb.toString());
							
							desktopPane.add(editor);
							desktopPane.updateUI();
							editor.toFront();
							
							get = editor;
						}
					} catch (Exception ex) {
						JOptionPane.showMessageDialog(MyTextEditor.this, ex.getMessage());
					}
				}
			});
		}
		return mntmNewMenuItem_1;
	}
	public JMenuItem getMntmNewMenuItem_2() {
		if (mntmNewMenuItem_2 == null) {
			mntmNewMenuItem_2 = new JMenuItem("저장");
			mntmNewMenuItem_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					// 파일명 지정여부 체크
					String fn = get.getFileName();
					if(fn.equals("noname.txt")) {
						JFileChooser fc = new JFileChooser(); // 파일열기 버튼 누르면 나오는 파일 선택 창
						
						int flag = fc.showSaveDialog(MyTextEditor.this); // 확인, 취소 버튼 누르면 상수값 반환
						if(flag == JFileChooser.APPROVE_OPTION) {        // APPROVE_OPTION, CANCLE_OPTION
							File f = fc.getSelectedFile();
							get.setFileName(f.getPath());
							fileSave(); // 저장 메서드
						}
					} else {
						fileSave();
					}
				}
			});
		}
		return mntmNewMenuItem_2;
	}
	public JMenuItem getMntmNewMenuItem_3() {
		if (mntmNewMenuItem_3 == null) {
			mntmNewMenuItem_3 = new JMenuItem("다른 이름으로 저장");
		}
		return mntmNewMenuItem_3;
	}
	public JLabel getResult() {
		if (result == null) {
			result = new JLabel("상태 표시 창");
		}
		return result;
	}
}
