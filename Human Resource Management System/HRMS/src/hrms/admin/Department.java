package hrms.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import hrms.dbinfo.DbConnection;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;

public class Department extends JFrame implements ActionListener,KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txthname;
	private JTextField txtphone;
	private JTextField txtemail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Department frame = new Department();
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
	public Department() {
		setBackground(new Color(0, 255, 255));
		setTitle("Department ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 579, 494);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(56, 181, 194));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
		
		
        setLocationRelativeTo(null);//it will place the component in center
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Department Details");
		lblNewLabel.setBounds(167, 24, 252, 27);
		lblNewLabel.setForeground(new Color(1, 7, 80));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 25));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Department Name");
		lblNewLabel_1.setBounds(34, 91, 182, 34);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 22));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Head Name");
		lblNewLabel_2.setBounds(34, 155, 182, 34);
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Department Phone No");
		lblNewLabel_3.setBounds(21, 219, 217, 34);
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 22));
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Department Email");
		lblNewLabel_4.setBounds(34, 280, 195, 41);
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("Candara", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblNewLabel_4);
		
		txtname = new JTextField();
		txtname.addKeyListener(this);
		txtname.setBounds(298, 83, 208, 34);
		txtname.setToolTipText("Enter a  department name");
		txtname.setForeground(new Color(0, 0, 0));
		txtname.setFont(new Font("Calibri", Font.ITALIC, 16));
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		txthname = new JTextField();
		txthname.addKeyListener(this);
		txthname.setBounds(298, 154, 208, 34);
		txthname.setToolTipText("Enter a name");
		txthname.setForeground(new Color(0, 0, 0));
		txthname.setFont(new Font("Calibri", Font.ITALIC, 16));
		contentPane.add(txthname);
		txthname.setColumns(10);
		
		txtphone = new JTextField();
		txtphone.addKeyListener(this);
		txtphone.setBounds(298, 218, 208, 34);
		txtphone.setToolTipText("Enter a Phone no");
		txtphone.setForeground(new Color(0, 0, 0));
		txtphone.setFont(new Font("Calibri", Font.ITALIC, 16));
		contentPane.add(txtphone);
		txtphone.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setBounds(298, 280, 208, 34);
		txtemail.setToolTipText("Enter a Email");
		txtemail.setFont(new Font("Calibri", Font.ITALIC, 16));
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(this);
		btnNewButton.addKeyListener(this);
		btnNewButton.setBounds(200, 352, 129, 34);
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 20));
		contentPane.add(btnNewButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
//		System.out.println("Button is being Clicked");
		addDepartment();
	}

	public void addDepartment()
	{
		String deptname=txtname.getText();
		
		String headname=txthname.getText();
		
		String phoneno=txtphone.getText();
		
		String email=txtemail.getText();
		
		if(deptname.isEmpty()|| headname.isEmpty() || phoneno.isEmpty() || email.isEmpty())
			
			JOptionPane.showMessageDialog(this, "All Fields are Mandatory");
		else {
			
			if(phoneno.length()>10 || phoneno.length()<10)
	
				JOptionPane.showMessageDialog(this, "PhoneNumber must have 10 digits");
			
			else if(email.indexOf('@')==-1 || email.indexOf(".")==-1)
			{
				JOptionPane.showMessageDialog(this, "Invalid email format");
			}	
			else {
			
			
			Connection con=DbConnection.openConnection();//Connection with hrms_db
			String insertQuery="insert into department(dept_name, hod_name, email, phone_no, date) values(?,?,?,?,?)";
			   PreparedStatement ps=null;
			   
			   try {
				   
				   ps=con.prepareStatement(insertQuery);//it passes the query to RDMS and RDMS compiles the query and store it into a buffer and assign address of that buffer ps
				   
				   java.util.Date d=new java.util.Date();//fully qaulified class name means a class name with package name
				   
				   long dt=d.getTime();
				   
				   java.sql.Date sd=new java.sql.Date(dt);
				   
				   ps.setString(1, deptname);//textbox fetched value
				   ps.setString(2, headname);
				   ps.setString(3,email );
				   ps.setString(4, phoneno);
				   ps.setDate(5, sd);
				   
				   System.out.println(ps);
				   
				   int status=ps.executeUpdate();//to insert data in value call this method
				   
				   if(status>0) {
					   JOptionPane.showMessageDialog(this, "Department data added successfully");
					   
					   txtname.setText("");
					   txthname.setText("");
					   txtemail.setText("");
					   txtphone.setText("");
				   }
				   
			   }
			   catch(SQLException se)
			   {
				   se.printStackTrace();
				   
//				   System.out.println("errorcode "+se.getErrorCode());
				   
				   if(se.getErrorCode()==1062) {
					   JOptionPane.showMessageDialog(this, deptname+"Departname Already Exists");
				   }
			   }
			   finally {// closing all the resources
				  try {
					  
					  if(ps!=null) 
						  ps.close();
					  
					  if(con!=null)
						  con.close();  
				  }
				  catch(SQLException se) {
					  
					  se.printStackTrace();
				  }
			   }
			}
		}
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
		char c=e.getKeyChar();//it will return the character
		//System.out.println(c);
		
		if(e.getSource()==txtname || e.getSource()==txthname)
		{
		if(!(Character.isAlphabetic(c) || c==KeyEvent.VK_BACK_SPACE ||c==KeyEvent.VK_DELETE ||c==KeyEvent.VK_SPACE))
		{
			JOptionPane.showMessageDialog(this, "Only alphabets allowed");
			   e.consume();
		}
		
		}
		
		if(e.getSource()==txtphone)
		{
			if(!(Character.isDigit(c) || c==KeyEvent.VK_BACK_SPACE ||c==KeyEvent.VK_DELETE ))
			{
				JOptionPane.showMessageDialog(this, "Only numbers allowed");
				   e.consume();
			}	
		}
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode=e.getKeyCode();
		if(keyCode==10)
			addDepartment();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
