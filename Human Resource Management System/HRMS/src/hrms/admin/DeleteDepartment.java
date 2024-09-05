package hrms.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import hrms.dbinfo.DbConnection;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.sql.*;

public class DeleteDepartment extends JFrame implements ActionListener,KeyListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteDepartment frame = new DeleteDepartment();
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
	public DeleteDepartment() {
		setTitle("Delete  Department");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 570, 384);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 128));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 4, true));

		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtname = new JTextField();
		txtname.addKeyListener(this);
		txtname.setFont(new Font("Calibri", Font.ITALIC, 20));
		txtname.setForeground(new Color(0, 0, 0));
		txtname.setBounds(147, 80, 253, 61);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete\r\n");
		btnNewButton.setIcon(new ImageIcon(DeleteDepartment.class.getResource("/hrms/image/icons8-delete-24.png")));
		btnNewButton.addActionListener(this);
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 18));
		btnNewButton.setBounds(198, 215, 147, 35);
		contentPane.add(btnNewButton);
	}
	
	public void deleteData() {
		String deptname=txtname.getText();
		
		if(deptname.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Name Required");
		}
		else 
		{
			int choice=JOptionPane.showConfirmDialog(this, "Do you really wish to delete"+deptname+" department");
			
			//System.out.println(choice);
			
			if(choice==0)
			{
				
				Connection con=DbConnection.openConnection();
				
				PreparedStatement ps=null;
				
				String deleteQuery="delete from department where dept_name=?";
				
				try {
					
					ps=con.prepareStatement(deleteQuery);
					
					ps.setString(1, deptname);
					
           		   //System.out.println(ps);
					
					int status=ps.executeUpdate();
					
					if(status>0) 
						
						JOptionPane.showMessageDialog(this, "data deleted");
					
					else JOptionPane.showMessageDialog(this,deptname+" does not exists");
					
				}
				catch(SQLException se)
				{
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
	    deleteData();
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		char c=e.getKeyChar();
		//System.out.println(c);
		
		if(e.getSource()==txtname)
		{
			if(!(Character.isAlphabetic(c) || c==KeyEvent.VK_BACK_SPACE ||c==KeyEvent.VK_DELETE ||c==KeyEvent.VK_SPACE))
			{
				JOptionPane.showMessageDialog(this, "Only alphabets allowed");
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

}
