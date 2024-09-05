package hrms.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import hrms.dbinfo.DbConnection;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.DefaultComboBoxModel;
import java.sql.*;

public class EditDepartment extends JFrame implements ActionListener,KeyListener,ItemListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtemail;
	private JTextField txtphone;
	private JTextField txthname;
	private JComboBox<String>  cmbname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditDepartment frame = new EditDepartment();
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
	public void fillcombo()
	{
		Connection con=DbConnection.openConnection();//create connection to establish connection
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String selectQuery="select dept_name from department";
		
		try {
			ps=con.prepareStatement(selectQuery);//to prepare the query with dbms
			rs=ps.executeQuery();//to execute the query with rddms and hold the reference in rs
			int count=0;
			while(rs.next())// to put pointer in the dataset and check for the availability of data
			{
				count=1;
				
				String name=rs.getString("dept_name");//to fetch data from dept_name column
				
				cmbname.addItem(name);//to add item in combobox
				
			}
			
			if(count==0) {
				JOptionPane.showMessageDialog(this, "No dept data to edit");
			}
			
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		finally 
		{
			try {
				
				if(rs!=null)
					rs.close();
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
	public EditDepartment() {
		setTitle("Edit Department");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 584, 462);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(180, 167, 216));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));

		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cmbname = new JComboBox();
		cmbname.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 16));
		cmbname.setModel(new DefaultComboBoxModel(new String[] {"Select Department"}));
		cmbname.setBounds(152, 36, 261, 41);
		cmbname.addItemListener(this);
		fillcombo();//populate combobox with items from table
		contentPane.add(cmbname);
		
		txtemail = new JTextField();
		txtemail.addKeyListener(this);
		txtemail.setFont(new Font("Calibri", Font.ITALIC, 16));
		txtemail.setBounds(327, 123, 185, 32);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		txtphone = new JTextField();
		txtphone.addKeyListener(this);
		txtphone.setFont(new Font("Calibri", Font.ITALIC, 16));
		txtphone.setBounds(327, 181, 185, 32);
		contentPane.add(txtphone);
		txtphone.setColumns(10);
		
		txthname = new JTextField();
		txthname.addKeyListener(this);
		txthname.setFont(new Font("Calibri", Font.ITALIC, 16));
		txthname.setBounds(327, 240, 185, 32);
		contentPane.add(txthname);
		txthname.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(112, 126, 86, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Phone no");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setBounds(107, 184, 91, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Head name");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(112, 240, 104, 26);
		contentPane.add(lblNewLabel_2);
		
		JButton btnedit = new JButton("Edit");
		btnedit.addActionListener(this);
		btnedit.addKeyListener(this);
		btnedit.setIcon(new ImageIcon(EditDepartment.class.getResource("/hrms/image/icons8-edit-24.png")));
		btnedit.setForeground(new Color(255, 0, 0));
		btnedit.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
		btnedit.setBounds(221, 322, 120, 32);
		contentPane.add(btnedit);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		//JOptionPane.showMessageDialog(this, "Data updated successfully");
		editDept();
	}
	
	public void editDept()
	{
		String deptname=(String)cmbname.getSelectedItem();
		String email=txtemail.getText();
		String phoneno=txtphone.getText();
		String hname=txthname.getText();
		
		if(deptname.equalsIgnoreCase("Select Department")) {
			JOptionPane.showMessageDialog(this, "Please select Department Name");
		}
		if(email.isEmpty() || phoneno.isEmpty() || hname.isEmpty()) {
			JOptionPane.showMessageDialog(this, "All fields are mandatory");
		}
		else {
			if(phoneno.length()>10 || phoneno.length()<10)
				
				JOptionPane.showMessageDialog(this, "PhoneNumber must have 10 digits");
			
			else if(email.indexOf('@')==-1 || email.indexOf(".")==-1)
			{
				JOptionPane.showMessageDialog(this, "Invalid email format");
			}
			else {
				
				Connection con=DbConnection.openConnection();
				
				PreparedStatement ps=null;
				
				String updateQuery="update department set email=?,phone_no=?,hod_name=? where dept_name=?";
				
				try {
					ps=con.prepareStatement(updateQuery);
					ps.setString(1, email);
					ps.setString(2, phoneno);
					ps.setString(3, hname);
					ps.setString(4, deptname);
					
					int status=ps.executeUpdate();
					
					if(status>0)
					{
						JOptionPane.showMessageDialog(this,deptname+" department details updated suceesfully");
					}
				}
				catch(SQLException se) {
					se.printStackTrace();
				}
				finally 
				{
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
		//System.out.println(c);
		
		if(e.getSource()==txthname)
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void itemStateChanged(ItemEvent e)
	{
//		System.out.println(e.getStateChange());
//		System.out.println("hello combo");
		
		String name=null;
		
		if(e.getStateChange()==2) //current state
		{
			name=(String)cmbname.getSelectedItem();
			System.out.println("Department name is "+name);
			
			Connection con=DbConnection.openConnection();
			
			PreparedStatement ps=null;
			ResultSet rs=null;
			
			String selctQuery="select * from department where dept_name=?";
			
			try {
				ps=con.prepareStatement(selctQuery);
				
				ps.setString(1, name);
				
				rs=ps.executeQuery();
				
				rs.next();//to move the cursor in the dataset
				
				String hodname=rs.getString("hod_name");
				
				String phone=rs.getString("phone_no");
				
				txthname.setText(hodname);
				txtphone.setText(phone);
				txtemail.setText(rs.getString("email"));
				
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			finally 
			{
				try {
					
					if(rs!=null)
						rs.close();
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
