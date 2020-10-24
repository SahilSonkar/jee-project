package jee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class marks {

	private JFrame frame;
	private JTextField M;
	private JTextField P;
	private JLabel lblNewLabel;
	private JTextField C;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					marks window = new marks();
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
	int rollno;
	Connection conn = null;
	PreparedStatement pst= null;
	ResultSet rs = null;
	String roll="";
	
	public marks() {
		initialize();
		conn = DBConnection.connect();
	}
	public marks(String R) {
		initialize();
		roll=R;
		conn = DBConnection.connect();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.GRAY);
		frame.getContentPane().setLayout(null);
		
		final JLabel Maths = new JLabel("Mathematics");
		Maths.setHorizontalAlignment(SwingConstants.CENTER);
		Maths.setFont(new Font("Tahoma", Font.BOLD, 25));
		Maths.setBounds(28, 161, 184, 36);
		frame.getContentPane().add(Maths);
		
		M = new JTextField();
		M.setFont(new Font("Tahoma", Font.BOLD, 20));
		M.setBounds(243, 173, 152, 22);
		frame.getContentPane().add(M);
		M.setColumns(10);
		
		final JLabel Physics = new JLabel("Physics");
		Physics.setHorizontalAlignment(SwingConstants.LEFT);
		Physics.setFont(new Font("Tahoma", Font.BOLD, 25));
		Physics.setBounds(38, 208, 174, 36);
		frame.getContentPane().add(Physics);
		
		P = new JTextField();
		P.setFont(new Font("Tahoma", Font.BOLD, 20));
		P.setBounds(243, 220, 152, 22);
		frame.getContentPane().add(P);
		P.setColumns(10);
		
		final JLabel Chemestry = new JLabel("Chemistry");
		Chemestry.setFont(new Font("Tahoma", Font.BOLD, 25));
		Chemestry.setBounds(48, 263, 152, 36);
		frame.getContentPane().add(Chemestry);
		
		C = new JTextField();
		C.setFont(new Font("Tahoma", Font.BOLD, 20));
		C.setBounds(246, 272, 149, 22);
		frame.getContentPane().add(C);
		C.setColumns(10);
		
		final JLabel cato = new JLabel("");
		cato.setFont(new Font("Tahoma", Font.PLAIN, 16));
		cato.setBounds(243, 456, 116, 35);
		frame.getContentPane().add(cato);
		frame.setBounds(100, 100, 451, 557);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{  
				String ct="Select * from students where rollno = ?";
				
				String cat="";
				try {
					pst= conn.prepareStatement(ct);
					pst.setString(1,roll);
					rs=pst.executeQuery();
					if(rs.next()){
					cat=rs.getString("category");
					System.out.print(cat);}
					
				} catch (SQLException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				
				
				
			
				String maths=M.getText();
				String physics=P.getText();
				String chemestry=C.getText();
				int m=Integer.parseInt(maths);
				int p=Integer.parseInt(physics);
				int c=Integer.parseInt(chemestry);
				int total = (m+p+c);
				int x=0;
				try {
				rollno=Integer.parseInt(roll);
					String ins="update  students  set maths = "+m+" ,total= "+total+" , physics = "+p+" , chemistry = "+c+" where rollno ="+rollno+"";
					pst = conn.prepareStatement(ins);
					pst.executeQuery();
				
					
			
					//System.out.print(ins)
					pst.executeUpdate();
					
				} catch (Exception e2) {
					// TODO: handle exception
					e2.printStackTrace();
					x=1;
				}
				if(x==0)
					JOptionPane.showMessageDialog(null,"marks accepted");
				
				
				
			try {
					pst=conn.prepareStatement("select * from students order by total desc");
					 ResultSet rs = pst.executeQuery();
					 
					 
						int count =0;
						while(rs.next())
						{
							count++;
							int re = rs.getInt("rollno");
//						String cs = rs.getString("category");
//						System.out.println("LO0VE"+cat);
//						System.out.println(re);
//						if( re != rollno)
//						{
//							if(cs.equals(cat))
//								cat_rank++;
//						}
							
						if(re == rollno )
						{
//							cat_rank++;
//							System.out.println("\n"+"cat_rank"+ cat_rank);
							break;
						}
						}
						lblNewLabel.setText(Integer.toString(count));
			}
						
				 catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			String cat_ra = "SELECT * from STUDENTS where category = ? ORDER BY total desc";
				try {
					int cat_rank =0;
					pst = conn.prepareStatement(cat_ra);
					pst.setString(1,cat);
					rs = pst.executeQuery();
					while(rs.next()){
						cat_rank++;
						int re = rs.getInt("rollno");
						if(re == rollno){
							System.out.print(cat_rank);
							cato.setText(String.valueOf(cat_rank) + "("+cat+")");
							break;
						}
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				

				
				
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnSubmit.setBounds(71, 338, 130, 36);
		frame.getContentPane().add(btnSubmit);
		
		JButton btnCancle = new JButton("Homepage");
		btnCancle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				HomePage w=new HomePage();
				w.getFrame().setVisible(true);
			}
		});
		btnCancle.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnCancle.setBounds(212, 338, 117, 36);
		frame.getContentPane().add(btnCancle);
		
		JLabel lblBestOfLuck = new JLabel("Best Of Luck");
		lblBestOfLuck.setHorizontalAlignment(SwingConstants.CENTER);
		lblBestOfLuck.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblBestOfLuck.setBounds(53, 23, 299, 36);
		frame.getContentPane().add(lblBestOfLuck);
		
		JLabel lblConductedByNational = new JLabel("Conducted By National Institute Of Technology");
		lblConductedByNational.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblConductedByNational.setHorizontalAlignment(SwingConstants.CENTER);
		lblConductedByNational.setBounds(0, 72, 420, 24);
		frame.getContentPane().add(lblConductedByNational);
	 lblNewLabel = new JLabel("");
	 lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	 lblNewLabel.setForeground(Color.RED);
	 lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 19));
		lblNewLabel.setBounds(243, 407, 130, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblRank = new JLabel("Rank");
		lblRank.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRank.setBounds(83, 407, 83, 36);
		frame.getContentPane().add(lblRank);
		
		JLabel lblCategoryRank = new JLabel("Category Rank");
		lblCategoryRank.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblCategoryRank.setBounds(71, 456, 130, 27);
		frame.getContentPane().add(lblCategoryRank);
		
		
	}
	public JFrame getFrame() {
		return frame;
	}
	public void setFrame(JFrame frame) {
		this.frame = frame;
	}
}
