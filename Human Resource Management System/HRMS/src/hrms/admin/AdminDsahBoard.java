package hrms.admin;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import hrms.common.AllDepartment;
import hrms.common.AllEmployee;
import hrms.common.AllEmployeeDepartmentwise;
import hrms.common.Login;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.awt.event.WindowListener;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class AdminDsahBoard extends JFrame  {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminDsahBoard frame = new AdminDsahBoard();
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
	public AdminDsahBoard() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("Admin Dashboard\r\n");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 666, 492);
		
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				
				JOptionPane.showMessageDialog(AdminDsahBoard.this, "Thank you for using me");
				Login login=new Login();
				login.setVisible(true);
				
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnDepartment = new JMenu("Department");
		menuBar.add(mnDepartment);
		
		JMenuItem mi_add = new JMenuItem("New Department");
		
		mi_add.addActionListener(
				
				new ActionListener()//anonymous inner class object-> that implements ActionListener
				{
					@Override
					public void actionPerformed(ActionEvent e) {
						 Department d=new Department();
						    d.setVisible(true);	
					}
					
				}//local anonymous inner class body
				
				);
		
		mi_add.setIcon(new ImageIcon(AdminDsahBoard.class.getResource("/hrms/image/icons8-add-24.png")));
		mnDepartment.add(mi_add);
		
		JMenuItem mi_edit = new JMenuItem("Edit");
		
		mi_edit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				EditDepartment ud=new  EditDepartment();
				ud.setVisible(true);
				
			}
		});
		mi_edit.setIcon(new ImageIcon(AdminDsahBoard.class.getResource("/hrms/image/icons8-edit-24.png")));
		mnDepartment.add(mi_edit);
		
		JMenuItem mi_delete = new JMenuItem("Delete");
		
		mi_delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DeleteDepartment dd=new DeleteDepartment();
				  dd.setVisible(true);
				
			}
		});
		mi_delete.setIcon(new ImageIcon(AdminDsahBoard.class.getResource("/hrms/image/icons8-delete-24.png")));
		mnDepartment.add(mi_delete);
		
		JMenu mnNewMenu = new JMenu("Reports");
		menuBar.add(mnNewMenu);
		
		JMenuItem mi_dept = new JMenuItem("All Department");
		
		mi_dept.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AllDepartment ad=new AllDepartment();
				  ad.setVisible(true);
			}
		});
		mi_dept.setIcon(new ImageIcon(AdminDsahBoard.class.getResource("/hrms/image/icons8-department-27.png")));
		mnNewMenu.add(mi_dept);
		
		JMenuItem mi_emp = new JMenuItem("All Employee");
		
		mi_emp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AllEmployee Ae=new AllEmployee();
				   Ae.setVisible(true);
			}
		});
		
		mi_emp.setIcon(new ImageIcon(AdminDsahBoard.class.getResource("/hrms/image/icons8-employee-27.png")));
		mnNewMenu.add(mi_emp);
		
		JMenuItem mi_emp_dept = new JMenuItem("All Employee Departmentwise");
		
		mi_emp_dept.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AllEmployeeDepartmentwise aed=new AllEmployeeDepartmentwise();
				   aed.setVisible(true);
			}
		});
		mi_emp_dept.setIcon(new ImageIcon(AdminDsahBoard.class.getResource("/hrms/image/icons8-employee-24.png")));
		mnNewMenu.add(mi_emp_dept);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar.add(menuBar_1);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 4));

		setContentPane(contentPane);
		contentPane.setLayout(null);
	}
}
