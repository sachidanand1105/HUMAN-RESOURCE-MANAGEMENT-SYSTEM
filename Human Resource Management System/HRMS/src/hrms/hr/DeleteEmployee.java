package hrms.hr;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import hrms.dbinfo.DbConnection;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.ImageIcon;

public class DeleteEmployee extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteEmployee frame = new DeleteEmployee();
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
	public DeleteEmployee() {
		setTitle("Delete Employee\r\n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 538, 378);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));
		
        setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtid = new JTextField();
		txtid.setFont(new Font("Calibri", Font.ITALIC, 20));
		txtid.setBounds(126, 76, 274, 62);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JButton btndelete = new JButton("Delete\r\n");
		btndelete.addActionListener(this);
		btndelete.setIcon(new ImageIcon(DeleteEmployee.class.getResource("/hrms/image/icons8-delete-24.png")));
		btndelete.setForeground(new Color(255, 0, 0));
		btndelete.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
		btndelete.setBounds(193, 208, 122, 29);
		contentPane.add(btndelete);
	}
	public void deleteData() {
		String empid=txtid.getText();
		
		if(empid.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "ID is required");
		}
		else
		{
			int choice=JOptionPane.showConfirmDialog(this, "Do you really wish to delete "+empid+" Employee");
//			System.out.println(choice);
			
			if(choice==0)
			{
				Connection con=DbConnection.openConnection();
				
				PreparedStatement ps=null;
				
				String deleteQuery="delete from employee where ID=?";
				
				try 
				{
					ps=con.prepareStatement(deleteQuery);
					
					ps.setString(1,empid );
					
					System.out.println(ps);
					
					int status=ps.executeUpdate();
					
					if(status>0) {
						JOptionPane.showMessageDialog(this, "Data deleted");
					}else {
						JOptionPane.showMessageDialog(this, empid+" does not exists");
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
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		deleteData();
	}

}
