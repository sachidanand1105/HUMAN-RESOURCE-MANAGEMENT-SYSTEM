package hrms.hr;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import hrms.dbinfo.DbConnection;

public class Employee extends JFrame implements ActionListener,KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtname;
	private JTextField txtemail;
	private JTextField txtphone;
	private JTextField txtdept;
	private JTextField txtdesing;
	private JTextArea  txtadd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee frame = new Employee();
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
	public Employee() {
		setBackground(new Color(192, 192, 192));
		setTitle("Employee\r\n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 589, 507);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 128));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));

		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(68, 25, 46, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(58, 71, 78, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Phone No");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(49, 167, 104, 24);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Department");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(40, 213, 136, 31);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(58, 118, 78, 24);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Designation");
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(49, 261, 127, 38);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Address");
		lblNewLabel_6.setForeground(new Color(0, 0, 0));
		lblNewLabel_6.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(60, 326, 104, 30);
		contentPane.add(lblNewLabel_6);
		
		txtadd = new JTextArea();
		txtadd.addKeyListener(this);
		txtadd.setToolTipText("Enter a Address");
		txtadd.setFont(new Font("Calibri", Font.ITALIC, 18));
		txtadd.setBounds(262, 327, 238, 56);
		contentPane.add(txtadd);
		
		txtid = new JTextField();
		txtid.addKeyListener(this);
		txtid.setToolTipText("Enter a id");
		txtid.setFont(new Font("Calibri", Font.ITALIC, 18));
		txtid.setBounds(262, 25, 238, 29);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		txtname = new JTextField();
		txtname.addKeyListener(this);
		txtname.setToolTipText("Enter a name");
		txtname.setFont(new Font("Calibri", Font.ITALIC, 18));
		txtname.setBounds(262, 76, 238, 31);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.addKeyListener(this);
		txtemail.setFont(new Font("Calibri", Font.ITALIC, 18));
		txtemail.setToolTipText("Enter a email");
		txtemail.setBounds(262, 123, 238, 31);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		txtphone = new JTextField();
		txtphone.addKeyListener(this);
		txtphone.setFont(new Font("Calibri", Font.ITALIC, 18));
		txtphone.setToolTipText("Enter a phoneno");
		txtphone.setBounds(262, 172, 238, 31);
		contentPane.add(txtphone);
		txtphone.setColumns(10);
		
		txtdept = new JTextField();
		txtdept.addKeyListener(this);
		txtdept.setToolTipText("Enter a department");
		txtdept.setFont(new Font("Calibri", Font.ITALIC, 18));
		txtdept.setBounds(262, 221, 238, 31);
		contentPane.add(txtdept);
		txtdept.setColumns(10);
		
		txtdesing = new JTextField();
		txtdesing.addKeyListener(this);
		txtdesing.setToolTipText("Enter a designation");
		txtdesing.setFont(new Font("Calibri", Font.ITALIC, 18));
		txtdesing.setBounds(262, 269, 238, 32);
		contentPane.add(txtdesing);
		txtdesing.setColumns(10);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(this);
		btnNewButton.addKeyListener(this);
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 16));
		btnNewButton.setBounds(155, 394, 127, 38);
		contentPane.add(btnNewButton);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		System.out.println("Button is being Clicked");
		addEmployee();
		
	}
	
	public void addEmployee()
	{
		String id=txtid.getText();
		
		String name=txtname.getText();
		
		String email=txtemail.getText();
		
		String phoneno=txtphone.getText();
		
		String dept=txtdept.getText();
		
		String designation=txtdesing.getText();
		
		String address=txtadd.getText();
		
		if(id.isEmpty() || name.isEmpty() || email.isEmpty() || phoneno.isEmpty() || dept.isEmpty() || designation.isEmpty() || address.isEmpty())
			
			JOptionPane.showMessageDialog(this, "All Fields are Manadatory");
		else {
			if(phoneno.length()>10 || phoneno.length()<10)
				
				JOptionPane.showMessageDialog(this, "PhoneNumber must have 10 digits");
			
			else if(email.indexOf('@')==-1 || email.indexOf(".")==-1)
			{
				JOptionPane.showMessageDialog(this, "Invalid email format");
			}	
		
		   else {
			Connection con=DbConnection.openConnection();
			String insertQuery="insert into employee(ID, name, email, phone, dept_name, designation, address)values(?,?,?,?,?,?,?)";
			   PreparedStatement ps=null;
			   
			   try {
				   
				   ps=con.prepareStatement(insertQuery);
				   
				   ps.setString(1,id );
				   ps.setString(2,name );
				   ps.setString(3,email );
				   ps.setString(4,phoneno );
				   ps.setString(5,dept );
				   ps.setString(6,designation );
				   ps.setString(7,address );
				   
				   System.out.println(ps);
				   
				   int status=ps.executeUpdate();
				   
				   if(status>0) {
					   JOptionPane.showMessageDialog(this, "Employee data added successfully");
					   
					   txtid.setText("");
					   txtname.setText("");
					   txtemail.setText("");
					   txtphone.setText("");
					   txtdept.setText("");
					   txtdesing.setText("");
					   txtadd.setText("");
					   
				   }
				   
				   
			   }
			   catch(SQLException se) {
				   se.printStackTrace();
				   
				   System.out.println(se.getErrorCode());
				   
				   if(se.getErrorCode()==1062) {
					   JOptionPane.showMessageDialog(this,id+"ID Already Exists" );
				   }
			   }
			   finally {
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
		// TODO Auto-generated method stub
		char c=e.getKeyChar();
//        System.out.println(c);
		
		if(e.getSource()==txtname || e.getSource()==txtdept || e.getSource()==txtdesing ||e.getSource()==txtadd )
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
		int keycode=e.getKeyCode();
		
		if(keycode==10)
			addEmployee();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}
