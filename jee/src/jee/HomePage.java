  package jee;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomePage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
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
	public HomePage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		setFrame(new JFrame());
		getFrame().setBounds(100, 100, 810, 541);
		getFrame().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(final JFrame frame) {
		this.frame = frame;
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 22));
		frame.getContentPane().setBackground(Color.GRAY);
		frame.getContentPane().setLayout(null);
		
		JLabel lblHomePage = new JLabel("HOME PAGE");
		lblHomePage.setBounds(116, 36, 495, 65);
		lblHomePage.setHorizontalAlignment(SwingConstants.CENTER);
		lblHomePage.setFont(new Font("Tahoma", Font.BOLD, 35));
		frame.getContentPane().add(lblHomePage);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				reallogin window1 = new reallogin();
				window1.getFrame().setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(278, 190, 225, 84);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnShowResult = new JButton("SHOW RESULT");
		btnShowResult.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				showresult win = new showresult();
				win.getFrame().setVisible(true);
			}
		});
		btnShowResult.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnShowResult.setBounds(530, 190, 250, 84);
		frame.getContentPane().add(btnShowResult);
		
		JLabel lblExaminationConductedBy = new JLabel("Examination Conducted by National Institute Of Technology Jamshedpur");
		lblExaminationConductedBy.setFont(new Font("Tahoma", Font.PLAIN, 22));
		lblExaminationConductedBy.setBounds(39, 97, 741, 42);
		frame.getContentPane().add(lblExaminationConductedBy);
		
		JButton btnNewButton_1 = new JButton("Registration");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				frame.setVisible(false);
				Jee window1 = new Jee();
				window1.getFrame().setVisible(true);
				
			}
		});
		btnNewButton_1.setBounds(33, 190, 211, 84);
		frame.getContentPane().add(btnNewButton_1);
	}

}
