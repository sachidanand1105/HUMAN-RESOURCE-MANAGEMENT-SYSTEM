package hrms.hr;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import hrms.dbinfo.DbConnection;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class SearchEmployee extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtPhone;
	private JLabel lblNewLabel_2;
	private JButton btnSearch;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JTextField txtname;
	private JTextField txtemail;
	private JTextField txtdept;
	private JTextField txtdesig;
	private JTextArea txtadd;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchEmployee frame = new SearchEmployee();
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
	public SearchEmployee() {
		setTitle("Search Employee");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 570, 540);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));

		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(74, 40, 69, 24);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Phone No");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_1.setBounds(74, 118, 97, 24);
		contentPane.add(lblNewLabel_1);
		
		txtid = new JTextField();
		txtid.setFont(new Font("Calibri", Font.ITALIC, 18));
		txtid.setBounds(225, 29, 137, 36);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Calibri", Font.ITALIC, 18));
		txtPhone.setBounds(225, 115, 137, 36);
		contentPane.add(txtPhone);
		txtPhone.setColumns(10);
		
		lblNewLabel_2 = new JLabel("OR");
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(262, 76, 55, 24);
		contentPane.add(lblNewLabel_2);
		
		btnSearch = new JButton("Search");
		btnSearch.setIcon(new ImageIcon(SearchEmployee.class.getResource("/hrms/image/icons8-search-24.png")));
		btnSearch.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 20));
		btnSearch.setForeground(new Color(255, 0, 0));
		btnSearch.setBounds(395, 67, 129, 36);
		btnSearch.addActionListener(this);
		contentPane.add(btnSearch);
		
		lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_3.setBounds(103, 190, 91, 36);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(115, 252, 69, 36);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("Department");
		lblNewLabel_5.setForeground(new Color(0, 0, 0));
		lblNewLabel_5.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(92, 312, 122, 24);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Designation");
		lblNewLabel_6.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_6.setForeground(new Color(0, 0, 0));
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setBounds(92, 373, 122, 24);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Address");
		lblNewLabel_7.setForeground(new Color(0, 0, 0));
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
		lblNewLabel_7.setBounds(103, 439, 91, 24);
		contentPane.add(lblNewLabel_7);
		
		txtname = new JTextField();
		txtname.setFont(new Font("Calibri", Font.ITALIC, 16));
		txtname.setEditable(false);
		txtname.setBounds(278, 196, 135, 31);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		txtemail = new JTextField();
		txtemail.setEditable(false);
		txtemail.setFont(new Font("Calibri", Font.ITALIC, 16));
		txtemail.setBounds(278, 258, 135, 31);
		contentPane.add(txtemail);
		txtemail.setColumns(10);
		
		txtdept = new JTextField();
		txtdept.setFont(new Font("Calibri", Font.ITALIC, 16));
		txtdept.setEditable(false);
		txtdept.setBounds(278, 312, 135, 31);
		contentPane.add(txtdept);
		txtdept.setColumns(10);
		
		txtdesig = new JTextField();
		txtdesig.setEditable(false);
		txtdesig.setFont(new Font("Calibri", Font.ITALIC, 16));
		txtdesig.setBounds(278, 373, 135, 31);
		contentPane.add(txtdesig);
		txtdesig.setColumns(10);
		
		txtadd = new JTextArea();
		txtadd.setFont(new Font("Calibri", Font.ITALIC, 16));
		txtadd.setEditable(false);
		txtadd.setBounds(262, 429, 170, 36);
		contentPane.add(txtadd);
	}
	public void searchEmp() 
	{
		String empid=txtid.getText();
		String Phoneno=txtPhone.getText();
		
		Connection con=DbConnection.openConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String selectQueryId="select * from employee where ID=?";
		String selectQueryPhone="select * from employee where phone=?";
		
		if(!(empid.isEmpty()))
		{
			try {
				ps=con.prepareStatement(selectQueryId);
				
				ps.setString(1, empid);
			
				rs=ps.executeQuery();
				
				if(rs.next()) 
				{
					txtname.setText(rs.getString("name"));
					txtemail.setText(rs.getString("email"));
					txtdept.setText(rs.getString("dept_name"));
					txtdesig.setText(rs.getString("designation"));
					txtadd.setText(rs.getString("address"));
				}
				else {
					JOptionPane.showMessageDialog(this,"Employee ID is not exist");
					txtid.setText("");
				}
				
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			finally {
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

		if(!(Phoneno.isEmpty()))
		{
			try {
				ps=con.prepareStatement(selectQueryPhone);
				
				ps.setString(1, Phoneno);
			
				rs=ps.executeQuery();
				
				if(rs.next()) 
				{
					txtname.setText(rs.getString("name"));
					txtemail.setText(rs.getString("email"));
					txtdept.setText(rs.getString("dept_name"));
					txtdesig.setText(rs.getString("designation"));
					txtadd.setText(rs.getString("address"));
				}
				else {
					JOptionPane.showMessageDialog(this,"Employee Phone no is not exist");
					txtPhone.setText("");
				}
				
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
			finally {
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

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		searchEmp();
	}
}
