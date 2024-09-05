package hrms.common;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import hrms.dbinfo.DbConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.sql.*;

public class AllDepartment extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllDepartment frame = new AllDepartment();
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
	public AllDepartment() {
		setTitle("AllDepartment");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 516, 507);
		contentPane = new JPanel();
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(45, 11, 416, 446);
		contentPane.add(scrollPane);
		
		table = new JTable();
		JTableHeader header=table.getTableHeader();
		
		header.setBackground(Color.cyan);
		header.setForeground(Color.red);
		header.setFont(new Font("Comic Sans Ms",Font.PLAIN,18));
		allDept();
		
		scrollPane.setViewportView(table);
	}
	
	public void allDept() 
	{
		Connection con=DbConnection.openConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String selctQuery="select * from department ";
		
		try {
			ps=con.prepareStatement(selctQuery);
			rs=ps.executeQuery();
			
			TableModel tm=DbUtils.resultSetToTableModel(rs);
			
			table.setModel(tm);
			
			TableColumnModel tcm=table.getColumnModel();
			
			tcm.getColumn(0).setHeaderValue("Department Name");
			tcm.getColumn(1).setHeaderValue("Head Name");
			tcm.getColumn(2).setHeaderValue("Email ID");
			tcm.getColumn(3).setHeaderValue("Mobile Number");
			
			
			
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
}
