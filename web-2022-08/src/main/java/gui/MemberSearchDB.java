package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import jdbc.DBConn;
import jdbc.MemberDto;

public class MemberSearchDB extends JInternalFrame {
	private JPanel panel;
	private JTextField findStr;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblNewLabel;
	
	MyInterMain main;
	Connection conn;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MemberSearchDB frame = new MemberSearchDB();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/*
	public void select() {
		try {
			conn = new DBConn("mydb").getConn();
			
			String sql = finStr.getText();
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			ResultSetMetaData meta = rs.getMetaData();
			
			Vector header = new Vector();
			header.add("NO");
			
			for(int i=1; i<=meta.getColumnCount(); i++) {
				header.add(meta.getColumnName(i));
			}
			
			Vector vector = new Vector();
			int no = 1;
			
			while(rs.next()) {
				Vector v = new Vector();
				v.add(no);
				
				for(int i=1; i<=meta.getColumnCount(); i++) {
					v.add(rs.getString(meta.getColumnName(i)));
				}
				
				vector.add(v);
				no++;
			}
			
			DefaultTableModel model = new DefaultTableModel(vector, header);
			table.setModel(model);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	*/
	
	public void select() {
		// 검색어를 가져와서 MemberDto.select 호출
		String f = findStr.getText();
		MemberDto dto = new MemberDto();
		Vector<Vector> list = dto.select(f);
		
		// DefaultTableModel에 있는 모든 데이터를 삭제
		DefaultTableModel model = (DefaultTableModel)table.getModel();
		model.setRowCount(0); // 데이터 삭제
		
		// DefaultTableModel에 리턴받은 Vector 데이터를 추가
		for(Vector v : list) {
			model.addRow(v);
		}
	}

	public MemberSearchDB(MyInterMain main) {
		this();
		this.main = main;
	}

	/**
	 * Create the frame.
	 */
	public MemberSearchDB() {
		super("회원조회DB", true, true, true, true);
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				main.msd = null;
			}
		});
		setVisible(true);
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(getPanel(), BorderLayout.NORTH);
		getContentPane().add(getScrollPane(), BorderLayout.CENTER);

	}

	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(10, 40));
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getFindStr(), BorderLayout.CENTER);
			panel.add(getBtnNewButton(), BorderLayout.EAST);
			panel.add(getLblNewLabel(), BorderLayout.WEST);
		}
		return panel;
	}
	public JTextField getFindStr() {
		if (findStr == null) {
			findStr = new JTextField();
			findStr.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						select();
					}
				}
			});
			findStr.setColumns(10);
		}
		return findStr;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("검색");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					select();
				}
			});
		}
		return btnNewButton;
	}
	public JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setViewportView(getTable());
		}
		return scrollPane;
	}
	public JTable getTable() {
		if (table == null) {
			table = new JTable();
			
			String[] header = {"아이디","성명","성별","연락처","등록일"};
			DefaultTableModel model = new DefaultTableModel(null, header);
			table.setModel(model);
			
			table.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					int row = table.getSelectedRow();
					
					if(main.mid == null) {
						main.mid = new MemberInputDB(main);
						main.getDesktopPane().add(main.mid);
						main.getDesktopPane().updateUI();
						main.mid.toFront();
					}
					
					MemberInputDB mid = (MemberInputDB)main.mid;
					String id = (String)table.getValueAt(row, 0);
					String irum = (String)table.getValueAt(row, 1);
					String gender = (String)table.getValueAt(row, 2);
					String phone = (String)table.getValueAt(row, 3);
					
					mid.getTfId().setText(id);
					mid.getTfIrum().setText(irum);
					mid.getTfPhone().setText(phone);
					
					// picture
					try {
						conn = new DBConn("mydb").getConn();
						
						String sql = "select picture from member "
								   + "where id = ?";
						PreparedStatement ps = conn.prepareStatement(sql);
						ps.setString(1, id);
						
						ResultSet rs = ps.executeQuery();
						String temp = "";
						while(rs.next()) {
							temp = rs.getString("picture");
						}
						mid.getTfPicture().setText(temp);
					} catch(Exception ex) {
						ex.printStackTrace();
					}
					
					// radio 버튼 클릭
					if(gender.equals("m")) {
						mid.getBtnGenderM().setSelected(true);
					} else {
						mid.getBtnGenderF().setSelected(true);
					}
				}
			});
		}
		return table;
	}
	public JLabel getLblNewLabel() {
		if (lblNewLabel == null) {
			lblNewLabel = new JLabel(" SQL");
			lblNewLabel.setPreferredSize(new Dimension(30, 15));
		}
		return lblNewLabel;
	}
}
