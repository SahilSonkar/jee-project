package jee;

import java.awt.EventQueue;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.sql.*;

public class showresult {

	private JFrame frame;
	private JTable resultable;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					showresult window = new showresult();
					window.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	Connection conn=null;
	PreparedStatement pst = null;
	ResultSet rst = null;
	public showresult() {
		conn = DBConnection .connect();
		initialize();
		showTableData();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 450, 556);
		((JFrame) getFrame()).setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		((JFrame) getFrame()).getContentPane().setLayout(null);
		
		resultable = new JTable();
		resultable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"Student's Name", "Roll No", "General Rank", "Category Rank", "Total Marks"
			}
		));
		resultable.setBounds(0, 0, 432, 253);
		((JFrame) getFrame()).getContentPane().add(resultable);
		
		table_1 = new JTable();
		table_1.setBounds(12, 13, 420, 240);
		((JFrame) getFrame()).getContentPane().add(table_1);
		
		
	}
	public void showTableData(){
		String fetch = "Select category,RANK() OVER(PARTITION BY CATEGORY ORDER BY TOTAL DESC) AS CATEGORY_Rank,RANK() OVER(ORDER BY total desc) AS AIR_RANK ,name,rollno,physics ,chemistry,maths,total from students order by total desc";
		try {
			pst = conn.prepareStatement(fetch);
			rst = pst.executeQuery();
			resultable.setModel(DbUtils.resultSetToTableModel(rst));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}


}
