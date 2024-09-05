package hrms.common;

import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

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
import java.awt.Color;

public class AllEmployee extends JFrame {

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
					AllEmployee frame = new AllEmployee();
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
	public AllEmployee() {
		setTitle("AllEmployee\r\n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 633, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(48, 11, 523, 340);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setForeground(new Color(64, 0, 0));
        JTableHeader header=table.getTableHeader();
		
		header.setBackground(Color.LIGHT_GRAY);
		header.setForeground(Color.black);
		
		header.setFont(new Font("Calibri",Font.PLAIN,18));
		
		allEmployee();
		scrollPane.setViewportView(table);
	}
	public void allEmployee()
	{
		Connection con=DbConnection.openConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String selctQuery="select * from employee ";
		
		try {
			ps=con.prepareStatement(selctQuery);
			rs=ps.executeQuery();
			
			TableModel tm=DbUtils.resultSetToTableModel(rs);
			
			table.setModel(tm);
			
			TableColumnModel tcm=table.getColumnModel();
			
			tcm.getColumn(4).setHeaderValue("Department Name");
			
			
			
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
