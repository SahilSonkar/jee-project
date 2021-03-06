package login;

import java.awt.EventQueue;

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
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.regex.Pattern;

import javax.swing.JPasswordField;
import javax.swing.JInternalFrame;
import com.toedter.calendar.JDateChooser;

public class registration {

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
				 registration window = new registration();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame =  JFrame();
		frame.getContentPane().setBackground(new Color(255, 204, 153));
		frame.setBounds(100, 100, 450, 521);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration");
		lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 24));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(101, 29, 205, 42);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(32, 84, 86, 52);
		frame.getContentPane().add(lblNewLabel_1);
		
	final	JLabel nameWarning = new JLabel("");
	nameWarning.setForeground(Color.RED);
		nameWarning.setHorizontalAlignment(SwingConstants.CENTER);
		nameWarning.setBounds(220, 126, 140, 16);
		frame.getContentPane().add(nameWarning);
		
		name = new JTextField();
		name.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 18));
		name.setBounds(197, 93, 189, 28);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		JLabel lblEmailid = new JLabel("Email-Id");
		lblEmailid.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 18));
		lblEmailid.setBounds(42, 158, 124, 33);
		frame.getContentPane().add(lblEmailid);
		
		email = new JTextField();
		email.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 18));
		email.setBounds(197, 154, 189, 28);
		frame.getContentPane().add(email);
		email.setColumns(10);
		
		 JLabel lblNewLabel_2 = new JLabel("D.O.B");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 18));
		lblNewLabel_2.setBounds(27, 211, 105, 42);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblGender = new JLabel("Gender");
		lblGender.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 18));
		lblGender.setBounds(42, 284, 105, 28);
		frame.getContentPane().add(lblGender);
		
		final JRadioButton Male = new JRadioButton("Male");
		Male.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 13));
		buttonGroup.add(Male);
		Male.setBounds(197, 287, 127, 25);
		frame.getContentPane().add(Male);
		
		
		final JRadioButton Female = new JRadioButton("Female");
		Female.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 13));
		buttonGroup.add(Female);
		Female.setBounds(197, 317, 127, 25);
		frame.getContentPane().add(Female);
		
		final JRadioButton Others = new JRadioButton("Others");
		Others.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 13));
		buttonGroup.add(Others);
		Others.setBounds(197, 347, 127, 25);
		frame.getContentPane().add(Others);
		
		JLabel lblPhoneNo = new JLabel("Phone no");
		lblPhoneNo.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 18));
		lblPhoneNo.setBounds(42, 395, 124, 16);
		frame.getContentPane().add(lblPhoneNo);
		
		phone = new JTextField();
		phone.setBounds(190, 393, 196, 22);
		frame.getContentPane().add(phone);
		phone.setColumns(10);
		
		final JDateChooser dob = new JDateChooser();
		dob.setBounds(197, 211, 189, 31);
		frame.getContentPane().add(dob);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname=name.getText();
				String Email=email.getText();
				
				String Phone=phone.getText();
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
			            
			            if((currentDateYr - dateYr) >= age)
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
			                                JOptionPane.showMessageDialog(null, "Age must be greater than or equal to17 yrs", "Alert",JOptionPane.WARNING_MESSAGE);
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
			                JOptionPane.showMessageDialog(null, "Age must be greater than or equal to 17 yrs", "Alert",JOptionPane.WARNING_MESSAGE);
			            }
			            
			        }
					catch(Exception e1)
			        {
			            JOptionPane.showMessageDialog(null, "Enter Age", "Alert",JOptionPane.WARNING_MESSAGE);
			        }
				
				if(!Pattern.matches("^[A-Z][a-z]*([ ][A-Za-z]*)*", fname ))
				{
					//nameWarning.setText("* check your name");
					JOptionPane.showMessageDialog(null, "Invalid Name");
				}
			    if(!Pattern.matches("[A-Za-z0-9\\._+]+@[A-Za-z]+\\.(com|ac|org){1}(.in){0,1}",Email))
					JOptionPane.showMessageDialog(null, "Invalid Email");
			   
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
					JOptionPane.showMessageDialog(null, "Invalid gender");
	
				 if( !Pattern.matches("(\\+91){0,1}[0-9]{10}",Phone))
					JOptionPane.showMessageDialog(null, "Invalid Number");
//				
//				this.setVisible(false);
//				new login().setVisible(true);
			}
		});
		btnSubmit.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 18));
		btnSubmit.setBounds(142, 436, 132, 25);
		frame.getContentPane().add(btnSubmit);
		
	
	
	}

	private JFrame JFrame() {
		// TODO Auto-generated method stub
		return null;
	}
}

