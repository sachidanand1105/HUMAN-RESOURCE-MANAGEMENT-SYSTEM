package hrms.admin;

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
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class SearchDepartment extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSearch;
	private JTextField txtName;
	private JTextField txtEmail;
	private JTextField txtPhone;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchDepartment frame = new SearchDepartment();
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
	public SearchDepartment() {
		setTitle("Search Department\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 465);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 4));

		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search Department");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 38, 212, 59);
		contentPane.add(lblNewLabel);
		
		txtSearch = new JTextField();
		txtSearch.setFont(new Font("Calibri", Font.ITALIC, 18));
		txtSearch.setBounds(232, 54, 187, 37);
		contentPane.add(txtSearch);
		txtSearch.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setIcon(new ImageIcon(SearchDepartment.class.getResource("/hrms/image/icons8-search-24.png")));
		btnSearch.setForeground(new Color(255, 0, 0));
		btnSearch.setFont(new Font("Trebuchet MS", Font.BOLD, 18));
		btnSearch.setBounds(468, 52, 134, 30);
		btnSearch.addActionListener(this);
		contentPane.add(btnSearch);
		
		JLabel lblNewLabel_1 = new JLabel("Hod Name\r\n");
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(118, 174, 119, 30);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(131, 247, 80, 30);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Phone No");
		lblNewLabel_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_3.setFont(new Font("Trebuchet MS", Font.BOLD, 19));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(118, 331, 119, 23);
		contentPane.add(lblNewLabel_3);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setFont(new Font("Calibri", Font.ITALIC, 20));
		txtName.setBounds(333, 174, 177, 37);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setFont(new Font("Calibri", Font.ITALIC, 20));
		txtEmail.setBounds(333, 238, 177, 37);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtPhone = new JTextField();
		txtPhone.setFont(new Font("Calibri", Font.ITALIC, 20));
		txtPhone.setEditable(false);
		txtPhone.setBounds(333, 318, 177, 37);
		contentPane.add(txtPhone);
		txtPhone.setColumns(10);
	}
	
	public void searchDept() 
	{
		String Deptname=txtSearch.getText();
		
	    Connection con=DbConnection.openConnection();
        PreparedStatement ps=null;
        ResultSet rs =null;
        
        String selectQuery="select * from department where dept_name=?";
        
        if(!(Deptname.isEmpty()))
        {
        	try {
                ps=con.prepareStatement(selectQuery);
				
				ps.setString(1, Deptname);
				
				rs=ps.executeQuery();
				
				if(rs.next())//to move the cursor in the dataset
				{
				
				txtName.setText(rs.getString("hod_name"));
				txtEmail.setText(rs.getString("email"));
				txtPhone.setText(rs.getString("phone_no"));
				
				}
				else {
					JOptionPane.showMessageDialog(this,"Department name is not exist");
					txtSearch.setText("");
				}
        	}
        	catch(SQLException se){
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
		
		

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		searchDept();
	}
}
