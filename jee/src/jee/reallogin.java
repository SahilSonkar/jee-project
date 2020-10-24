package jee;

import java.awt.EventQueue;
import java.awt.Frame;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.nio.file.PathMatcher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class reallogin {

	private JFrame frame;
	private JTextField loginroll;
	private JTextField loginemail;
	private JButton btnLogin;
	private JButton btnCancel;
	private JLabel lblLoginForm;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					reallogin window = new reallogin();
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
	public reallogin() {
		initialize();
		conn = DBConnection.connect();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	int x=1;
	PreparedStatement pst=null;
	ResultSet rs = null;
	Connection conn =null;
	
	
	
	private void initialize() {
		setFrame(new JFrame());
		getFrame().getContentPane().setFont(new Font("Tahoma", Font.BOLD, 25));
		getFrame().getContentPane().setBackground(Color.GRAY);
		getFrame().getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Roll No");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setBounds(47, 89, 99, 40);
		getFrame().getContentPane().add(lblName);
		
		loginroll = new JTextField();
		loginroll.setFont(new Font("Tahoma", Font.BOLD, 18));
		loginroll.setBounds(206, 92, 188, 27);
		getFrame().getContentPane().add(loginroll);
		loginroll.setColumns(10);
		
		JLabel lblEnail = new JLabel("Email");
		lblEnail.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblEnail.setBounds(59, 157, 87, 27);
		getFrame().getContentPane().add(lblEnail);
		
		loginemail = new JTextField();
		loginemail.setFont(new Font("Tahoma", Font.BOLD, 18));
		loginemail.setBounds(206, 157, 188, 27);
		getFrame().getContentPane().add(loginemail);
		loginemail.setColumns(10);
		
		btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String R=loginroll.getText();
				String E=loginemail.getText();
				if( !Pattern.matches("(\\+91){0,1}[0-9]{4}",R))
				{
					JOptionPane.showMessageDialog(null,"please Enter your roll no.");
				}
				if(!Pattern.matches("[A-Za-z0-9\\._+]+@[A-Za-z]+\\.(com|ac|org){1}(.in){0,1}",E))
				{
					JOptionPane.showMessageDialog(null,"please enter your Email");
				}
				 try
				 {
					 String query="SELECT * from students where email=? and rollno=?";
					 pst =conn.prepareStatement(query);
					 pst.setString(1,E);
					 pst.setString(2,R);
					 rs=pst.executeQuery();
					 if(rs.next())
					 {
						 JOptionPane.showMessageDialog(null ,"Successfully Login");
						 x=0;
						 frame.setVisible(false);
						 new marks(R).getFrame().setVisible(true);
						 
					 }
					 if(x==1)
						 JOptionPane.showMessageDialog(null,"Invalid Login");
					 
					 
					 
					 
				 }
				 catch (Exception e2) {
				    e2.printStackTrace();
				    
				}
					
				
				
				
				
				
				
				
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnLogin.setBounds(83, 275, 147, 50);
		getFrame().getContentPane().add(btnLogin);
		
		btnCancel = new JButton("Cancel");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnCancel.setBounds(255, 275, 139, 50);
		getFrame().getContentPane().add(btnCancel);
		
		lblLoginForm = new JLabel("Login Form");
		lblLoginForm.setHorizontalAlignment(SwingConstants.CENTER);
		lblLoginForm.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblLoginForm.setBounds(83, 28, 258, 48);
		getFrame().getContentPane().add(lblLoginForm);
		getFrame().setBounds(100, 100, 450, 437);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

}
