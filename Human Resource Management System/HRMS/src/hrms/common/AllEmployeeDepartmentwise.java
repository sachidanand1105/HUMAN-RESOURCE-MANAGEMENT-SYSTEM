package hrms.common;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.xml.crypto.dsig.XMLObject;

import hrms.dbinfo.DbConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class AllEmployeeDepartmentwise extends JFrame implements ItemListener {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JComboBox<String> cmbname;
	private JScrollPane scrollPane;
    
	/**
	 * Launch the application.
	 */
	
	public void fillcombo()
	{
		Connection con=DbConnection.openConnection();//create connection to establish connection
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String selectQuery="select dept_name from department";
		
		try {
			ps=con.prepareStatement(selectQuery);
			rs=ps.executeQuery();
			int count=0;
			while(rs.next())
			{
				count=1;
				
				String name=rs.getString("dept_name");
				
				cmbname.addItem(name);
				
			}
			
			if(count==0) {
				JOptionPane.showMessageDialog(this, " deparment data is not found");
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
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllEmployeeDepartmentwise frame = new AllEmployeeDepartmentwise();
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
	public AllEmployeeDepartmentwise() {
		setTitle("All Employee Departmentwise");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 497);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		cmbname = new JComboBox();
		cmbname.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 18));
		cmbname.setModel(new DefaultComboBoxModel(new String[] {"Select Department"}));
		cmbname.setBounds(103, 27, 265, 46);
		cmbname.addItemListener(this);
		fillcombo();
		contentPane.add(cmbname);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 124, 425, 323);
		contentPane.add(scrollPane);
		
		table = new JTable();
		
	}
	
	public void deptwise(String id)
	{
		Connection con=DbConnection.openConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String selctQuery="select * from employee where dept_name=?";
		
		try {
			ps=con.prepareStatement(selctQuery);
			ps.setString(1,id );
			rs=ps.executeQuery();
			
			DefaultTableModel model=(DefaultTableModel) table.getModel();
			model.setRowCount(0);//this method is clear to Privious data
			
			TableModel tm=DbUtils.resultSetToTableModel(rs);
			
			if(tm.getRowCount()>0) 
			{
			table.setModel(tm);
			
			TableColumnModel tcm=table.getColumnModel();
			
			tcm.getColumn(4).setHeaderValue("Department Name");
			
			}
			else {
				JOptionPane.showMessageDialog(this, "There is no employee exist");
				
			}
				
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				
				if (rs!=null)
					rs.close();
				if(ps!=null)
					rs.close();
				if(con!=null)
					con.close();
				
			}
			catch(SQLException se) {
				se.printStackTrace();
			}
		}
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		String name=null;
		if(e.getStateChange()==2)
		{
			name=(String)cmbname.getSelectedItem();
			
			deptwise(name);
			scrollPane.setViewportView(table);
		}
		
		
	}
}
