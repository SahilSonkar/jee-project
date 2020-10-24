package jee;

import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import javax.swing.JPasswordField;
import javax.swing.JInternalFrame;
import com.toedter.calendar.JDateChooser;
import javax.swing.JComboBox;
import javax.xml.transform.Source;
import javax.swing.DefaultComboBoxModel;


public class Jee {

	private JFrame frame;
	private JTextField name;
	private JTextField email;
	private JTextField phone;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Jee window = new Jee();
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
	static int y = 1000;
	static JComboBox c1;
	Connection conn = null;
	PreparedStatement pst= null;
	ResultSet rs = null;
	public Jee() 
	{
		initialize();
		conn = DBConnection.connect();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().getContentPane().setFont(new Font("Tahoma", Font.BOLD, 15));
		getFrame().getContentPane().setBackground(Color.GRAY);
		getFrame().setBounds(100, 100, 450, 570);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration");
		lblNewLabel.setBounds(96, 13, 205, 42);
		lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getFrame().getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(46, 56, 86, 42);
		lblNewLabel_1.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		getFrame().getContentPane().add(lblNewLabel_1);
		
	final	JLabel nameWarning = new JLabel("");
	nameWarning.setBounds(218, 111, 140, 16);
	nameWarning.setForeground(Color.RED);
		nameWarning.setHorizontalAlignment(SwingConstants.CENTER);
		getFrame().getContentPane().add(nameWarning);
		
		name = new JTextField();
		name.setBounds(197, 68, 189, 28);
		name.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 18));
		getFrame().getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblEmailid = new JLabel("Email-Id");
		lblEmailid.setBounds(46, 124, 124, 33);
		lblEmailid.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 18));
		getFrame().getContentPane().add(lblEmailid);
		
		email = new JTextField();
		email.setBounds(197, 126, 189, 28);
		email.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 18));
		getFrame().getContentPane().add(email);
		email.setColumns(10);
		
		 JLabel lblNewLabel_2 = new JLabel("D.O.B");
		 lblNewLabel_2.setBounds(32, 170, 105, 42);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 18));
		getFrame().getContentPane().add(lblNewLabel_2);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setBounds(42, 235, 105, 28);
		lblGender.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 18));
		getFrame().getContentPane().add(lblGender);
		
		final JRadioButton Male = new JRadioButton("Male");
		Male.setBounds(197, 235, 127, 25);
		Male.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 13));
		buttonGroup.add(Male);
		getFrame().getContentPane().add(Male);
		
		
		final JRadioButton Female = new JRadioButton("Female");
		Female.setBounds(197, 265, 127, 25);
		Female.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 13));
		buttonGroup.add(Female);
		getFrame().getContentPane().add(Female);
		
		final JRadioButton Others = new JRadioButton("Others");
		Others.setBounds(197, 295, 127, 25);
		Others.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 13));
		buttonGroup.add(Others);
		getFrame().getContentPane().add(Others);
		
		JLabel lblPhoneNo = new JLabel("Phone no");
		lblPhoneNo.setBounds(53, 456, 124, 16);
		lblPhoneNo.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 18));
		getFrame().getContentPane().add(lblPhoneNo);
		
		phone = new JTextField();
		phone.setBounds(197, 450, 196, 22);
		getFrame().getContentPane().add(phone);
		phone.setColumns(10);
		
		final JDateChooser dob = new JDateChooser();
		dob.setBounds(197, 181, 189, 31);
		getFrame().getContentPane().add(dob);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select", "General", "Obc", "Sc", "St"}));
		comboBox.setBounds(197, 348, 127, 22);
		frame.getContentPane().add(comboBox);
		
		
		
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(147, 485, 132, 25);
		btnSubmit.addActionListener(new ActionListener() {
			
			int x=0;
			public void actionPerformed(ActionEvent e) {
				String fname=name.getText();
				String Email=email.getText();
				String Phone=phone.getText();
				String combox= (String)comboBox.getSelectedItem();
				String gender = "";
				//String warning=warning.getText();
			/*	String m=Male.getText();
				String f=Female.getText();
				String o=Others.getText();*/

				
				try{
//			        date = sdf.format(dateChooser.getDate());
//			        currentDate = sdf.format(new Date());
//			        //Date date1 = format.parse(date);
//			        //Date currentDate1 = format.parse(currentDate);
//			        long diff= currentDate.compareTo(date);
//			        System.out.println(date + " "+currentDate+" "+diff);
			            Date dat = dob.getDate();
			            Date currentDate = new Date();
			            
			            long age = 17;
			            
			            Calendar dateCal = new GregorianCalendar();
			            Calendar currentDateCal = new GregorianCalendar();
			            
			            dateCal.setTime(dat);
			            currentDateCal.setTime(currentDate);
			            
			            long dateYr = dateCal.get(Calendar.YEAR);
			            long dateMm = dateCal.get(Calendar.MONTH);
			            dateMm+=1;
			            long dateDay  =dateCal.get(Calendar.DAY_OF_MONTH);
			            
			            long currentDateYr = currentDateCal.get(Calendar.YEAR);
			            long currentDateMm = currentDateCal.get(Calendar.MONTH);
			            currentDateMm+=1;
			            long currentDateDay  = currentDateCal.get(Calendar.DAY_OF_MONTH);
			           
			            
			            
			            if((currentDateYr - dateYr) >= age && (currentDateYr - dateYr)<=age+4)
			            {
			                if((currentDateYr - dateYr)==age)
			                {
			                    if((currentDateMm - dateMm)>=0)
			                    {
			                        if((currentDateMm - dateMm)==0)
			                        {
			                            if((currentDateDay - dateDay)>=0)
			                            {
			                 
			                            }
			                            else
			                            {
			                                JOptionPane.showMessageDialog(null, "Age must be greater than or equal to 17 yrs", "Alert",JOptionPane.WARNING_MESSAGE);
			                            }
			                        }
			                    }
			                    else
			                    {
			                         JOptionPane.showMessageDialog(null, "Age must be greater than or equal to 17 yrs", "Alert",JOptionPane.WARNING_MESSAGE);
			                    }
			                }
			            }
			            else
			            {
			                JOptionPane.showMessageDialog(null, "Age must be greater than or equal to 17 yrs and less than 21", "Alert",JOptionPane.WARNING_MESSAGE);
			            }
			            
			        }
					catch(Exception e1)
			        {
			            JOptionPane.showMessageDialog(null, "Enter Age", "Alert",JOptionPane.WARNING_MESSAGE);
			            x++;
			        }

				
				
				
				if(!Pattern.matches("^[A-Z][a-z]*([ ][A-Za-z]*)*", fname ))
				{
					//nameWarning.setText("* check your name");
					JOptionPane.showMessageDialog(null, "Invalid Name");
					x++;
				}
			    if(!Pattern.matches("[A-Za-z0-9\\._+]+@[A-Za-z]+\\.(com|ac|org){1}(.in){0,1}",Email)){
					JOptionPane.showMessageDialog(null, "Invalid Email");
					x++;
			    }
			   
			/*	else if(dob.equals("")){
					JOptionPane.showMessageDialog(null, "D.O.B can't be empty");
				}*/
				if(Male.isSelected())
				{
					gender="M";
				}
				else if(Female.isSelected())
				{
					gender="F";
				}
				else if(Others.isSelected())
				{
					gender="O";
				}
				 if(gender=="")
					{
					 JOptionPane.showMessageDialog(null, "Invalid gender");
					 x++;
					}
	
				 if( !Pattern.matches("(\\+91){0,1}[0-9]{10}",Phone))
					{JOptionPane.showMessageDialog(null, "Invalid Number");
					x++;
					}
				
				 
//				
//				this.setVisible(false);
//				new login().setVisible(true);
				 if(x==0)
				 { 
					int roll = generaterollno();
					 
					DecimalFormat df=new DecimalFormat("000");
					String rol = "1"+df.format(roll);
					
					
					 SimpleDateFormat sfd= new SimpleDateFormat("yyyy-MM-dd");
					 String date = sfd.format(dob.getDate());
					 int x=0;
					 try {
						 String ins ="INSERT INTO students(rollno,name,email,dob,Phone,gender,category,physics,chemistry,maths,total) VALUES (?,?,?,?,?,?,?,"+x+","+x+","+x+","+x+")";
						 pst = conn.prepareStatement(ins);
						 pst.setString(1,rol);
						 pst.setString(2,fname); 						 
						 pst.setString(3,Email);
						 pst.setString(4,date);
						 pst.setString(5,Phone);
						 pst.setString(6,gender);
						 pst.setString(7, combox);
						 pst.executeUpdate();
						 //String rolln = rs.getString("roll");
					    JOptionPane.showMessageDialog(null, rol );

					} catch (Exception e2) {
						// TODO: handle exception
						e2.printStackTrace();
						x=1;
						
					}
					
				 }
				 if(x==0)
				 {
					getFrame().setVisible(false);
					HomePage window1 = new HomePage();
					window1.getFrame().setVisible(true);
					
				 }
			}
		});
		
		btnSubmit.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 18));
		getFrame().getContentPane().add(btnSubmit);
		
		JLabel lblCaste = new JLabel("Caste");
		lblCaste.setBounds(36, 342, 96, 28);
		lblCaste.setHorizontalAlignment(SwingConstants.CENTER);
		lblCaste.setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().add(lblCaste);
		
		
	}
		public int generaterollno()
		{
			int y=0;
			try {
				
				String query="SELECT *from students";
				pst=conn.prepareStatement(query);
				rs=pst.executeQuery();
				if(rs.next())
				{
					do{
						y++;
					}while(rs.next());
				}
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
				
			}
			return y;
		
	
	}

		public JFrame getFrame() {
			return frame;
		}

		public void setFrame(JFrame frame) {
			this.frame = frame;
		}
}
