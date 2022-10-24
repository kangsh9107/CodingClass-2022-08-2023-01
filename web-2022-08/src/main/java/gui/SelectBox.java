package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import jdbc.DBConn;

public class SelectBox extends JInternalFrame {
	private JPanel panel;
	private JTextField tfSql;
	private JButton btnNewButton;
	private JScrollPane scrollPane;
	private JTable table;
	private JLabel lblNewLabel;
	
	Connection conn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectBox frame = new SelectBox();
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
	public SelectBox() {
		super("SQL", true, true, true, true);
		setVisible(true);
		setBounds(100, 100, 650, 300);
		getContentPane().setLayout(new BorderLayout(0, 0));
		getContentPane().add(getPanel(), BorderLayout.NORTH);
		getContentPane().add(getScrollPane(), BorderLayout.CENTER);

	}
	
	public void select() {
		try {
			conn = new DBConn().getConn();
			
			String sql = tfSql.getText();
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
				Vector v = new Vector(); // while문 안에서 new로 계속 생성
				v.add(no);
				for(int i=1; i<=meta.getColumnCount(); i++) {
					v.add(rs.getString(meta.getColumnName(i)));
				}
				vector.add(v);
				no++;
			}
			
			DefaultTableModel model = new DefaultTableModel();
			model.setDataVector(vector, header);
			//DefaultTableModel model = new DefaultTableModel(vector, header); 로 압축 가능
			table.setModel(model);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setPreferredSize(new Dimension(10, 30));
			panel.setLayout(new BorderLayout(0, 0));
			panel.add(getTfSql(), BorderLayout.CENTER);
			panel.add(getBtnNewButton(), BorderLayout.EAST);
			panel.add(getLblNewLabel(), BorderLayout.WEST);
		}
		return panel;
	}
	public JTextField getTfSql() {
		if (tfSql == null) {
			tfSql = new JTextField();
			tfSql.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if(e.getKeyCode() == KeyEvent.VK_ENTER) {
						select();
					}
				}
			});
			tfSql.setColumns(10);
		}
		return tfSql;
	}
	public JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("실행");
			btnNewButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					select(); // MVC로 나누지 않고 그냥 SelectBox 생성자 밑에 작성 했다.
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
