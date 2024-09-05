package hrms.hr;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import hrms.dbinfo.DbConnection;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.print.attribute.standard.JobPrioritySupported;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class EditEmployee extends JFrame implements ActionListener,KeyListener,ItemListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtemail;
	private JTextField txtphone;
	private JTextField txtDept;
	private JTextField txtDesig;
	private JTextArea  txtAdd;
	private JComboBox<String>  cmbemp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EditEmployee frame = new EditEmployee();
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
		
		String selectQuery="select ID from employee";
		
		try {
			ps=con.prepareStatement(selectQuery);//to prepare the query with dbms
			rs=ps.executeQuery();//to execute the query with rddms and hold the reference in rs
			int count=0;
			while(rs.next())// to put pointer in the dataset and check for the availability of data
			{
				count=1;
				
				String name=rs.getString("ID");//to fetch data from ID column
				
				cmbemp.addItem(name);//to add item in combobox
				
			}
			
			if(count==0) {
				JOptionPane.showMessageDialog(this, "No Employee data to edit");
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
	public EditEmployee() {
		setTitle("Edit Employee");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 551, 503);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 128, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));

		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel.setBounds(59, 83, 86, 21);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(76, 142, 69, 21);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Phone No");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(59, 208, 86, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Department");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setBounds(48, 260, 109, 44);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Designation");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setBounds(59, 315, 109, 44);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Address");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setBounds(59, 383, 109, 21);
		contentPane.add(lblNewLabel_5);
		
		JButton btnedit = new JButton("Edit");
		btnedit.addActionListener(this);
		btnedit.addKeyListener(this);
		btnedit.setIcon(new ImageIcon(EditEmployee.class.getResource("/hrms/image/icons8-edit-24.png")));
		btnedit.setForeground(new Color(255, 0, 0));
		btnedit.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 16));
		btnedit.setBounds(155, 420, 109, 33);
		contentPane.add(btnedit);
		
		txtname = new JTextField();
		txtname.addKeyListener(this);
		txtname.setFont(new Font("Tahoma", Font.ITALIC, 15));
		txtname.setBounds(247, 71, 194, 33);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.addKeyListener(this);
		txtemail.setFont(new Font("Calibri", Font.ITALIC, 15));
		txtemail.setBounds(247, 130, 194, 33);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		txtphone = new JTextField();
		txtphone.addKeyListener(this);
		txtphone.setFont(new Font("Calibri", Font.ITALIC, 15));
		txtphone.setBounds(247, 190, 194, 33);
		contentPane.add(txtphone);
		txtphone.setColumns(10);
		
		txtDept = new JTextField();
		txtDept.addKeyListener(this);
		txtDept.setFont(new Font("Calibri", Font.ITALIC, 15));
		txtDept.setBounds(247, 252, 194, 35);
		contentPane.add(txtDept);
		txtDept.setColumns(10);
		
		txtDesig = new JTextField();
		txtDesig.addKeyListener(this);
		txtDesig.setFont(new Font("Calibri", Font.ITALIC, 15));
		txtDesig.setBounds(247, 313, 194, 35);
		contentPane.add(txtDesig);
		txtDesig.setColumns(10);
		
		txtAdd = new JTextArea();
		txtAdd.addKeyListener(this);
		txtAdd.setFont(new Font("Calibri", Font.ITALIC, 15));
		txtAdd.setBounds(247, 371, 194, 44);
		contentPane.add(txtAdd);
		
		cmbemp = new JComboBox();
		cmbemp.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 16));
		cmbemp.setModel(new DefaultComboBoxModel(new String[] {"Select  ID"}));
		cmbemp.setBounds(124, 11, 249, 35);
		cmbemp.addItemListener(this);
		fillcombo();
		contentPane.add(cmbemp);
	}

	public void editemp()
	{
		String empid=(String)cmbemp.getSelectedItem();
		
	    String name=txtname.getText();
	    
        String email=txtemail.getText();
		
		String phoneno=txtphone.getText();
		
		String dept=txtDept.getText();
		
		String designation=txtDesig.getText();
		
		String address=txtAdd.getText();
		
		if(empid.equalsIgnoreCase("Select  ID")) {
			JOptionPane.showMessageDialog(this, "Please select Employee ID");
		}
		
		if(name.isEmpty() || email.isEmpty() || phoneno.isEmpty() || dept.isEmpty() || designation.isEmpty() || address.isEmpty()) 
		{
			JOptionPane.showMessageDialog(this, "All fields are mandatory");
		}
		else
		{
            if(phoneno.length()>10 || phoneno.length()<10)
				
				JOptionPane.showMessageDialog(this, "PhoneNumber must have 10 digits");
			
			else if(email.indexOf('@')==-1 || email.indexOf(".")==-1)
			{
				JOptionPane.showMessageDialog(this, "Invalid email format");
			}
			else 
			{
                Connection con=DbConnection.openConnection();
				
				PreparedStatement ps=null;
				
				String updateQuery="update employee set name=?,email=?,phone=?,dept_name=?,designation=?,address=? where ID=?";
				
				try
				{
					ps=con.prepareStatement(updateQuery);
					ps.setString(1, name);
					ps.setString(2, email);
					ps.setString(3, phoneno);
					ps.setString(4, dept);
					ps.setString(5, designation);
					ps.setString(6, address);
					ps.setString(7, updateQuery);
					
					int status=ps.executeUpdate();
					
					if(status>0)
					{
						JOptionPane.showMessageDialog(this,empid+" Employee details updated suceesfully");
					}
				}
				catch(SQLException se)
				{
					se.printStackTrace();
				}
				finally 
				{
					try 
					{
		
						if(ps!=null)
							ps.close();
						if(con!=null)
							con.close();
					}
					catch(SQLException se)
					{
						se.printStackTrace();
					}
			    }
			}
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		editemp();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char c=e.getKeyChar();
//      System.out.println(c);
		
		if(e.getSource()==txtname || e.getSource()==txtDept || e.getSource()==txtDesig ||e.getSource()==txtAdd )
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
//     	System.out.println("hello combobox");
		
		String ID=null;
		
		if(e.getStateChange()==2) //current state
		{
			ID=(String)cmbemp.getSelectedItem();
			System.out.println("Employee ID  is "+ID);
			
			Connection con=DbConnection.openConnection();
			
			PreparedStatement ps=null;
			ResultSet rs=null;
			
			String selctQuery="select * from employee where ID=?";
			
			try {
				ps=con.prepareStatement(selctQuery);
				
				ps.setString(1, ID);
				
				rs=ps.executeQuery();
				
				rs.next();//to move the cursor in the dataset
				
				txtname.setText(rs.getString("name"));
				txtemail.setText(rs.getString("email"));
				txtphone.setText(rs.getString("phone"));
				txtDept.setText(rs.getString("dept_name"));
				txtDesig.setText(rs.getString("designation"));
				txtAdd.setText(rs.getString("address"));
				
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
