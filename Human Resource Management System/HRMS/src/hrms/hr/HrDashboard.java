package hrms.hr;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import hrms.admin.AdminDsahBoard;
import hrms.admin.DeleteDepartment;
import hrms.admin.EditDepartment;
import hrms.common.Login;

import java.awt.Color;
import java.awt.Frame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class HrDashboard extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HrDashboard frame = new HrDashboard();
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
	public HrDashboard() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("HrDashboard");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 584, 477);
		
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
				JOptionPane.showMessageDialog(HrDashboard.this, "Thank you for using me");
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
		} );
	
		contentPane = new JPanel();
		contentPane.setBackground(new Color(180, 167, 216));
		contentPane.setBorder(new LineBorder(new Color(0, 0, 0), 5, true));

		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 195, 700);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnadd = new JButton("Add Employee");
		btnadd.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 16));
		
		btnadd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Employee em=new Employee();
				em.setVisible(true);
				
			}
			
		});
		
		btnadd.setBounds(10, 11, 175, 33);
		panel.add(btnadd);
		
		JButton btndlt = new JButton("Delete Employee");
		btndlt.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 16));
		btndlt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				DeleteEmployee dl=new DeleteEmployee();
				dl.setVisible(true);
			}
		});
		btndlt.setBounds(10, 188, 175, 33);
		panel.add(btndlt);
		
		JButton btnedit = new JButton("Edit Employee");
		btnedit.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 16));
		btnedit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EditEmployee ee=new EditEmployee();
				ee.setVisible(true);
			}
		});
		btnedit.setBounds(10, 425, 162, 33);
		panel.add(btnedit);
	}
}
