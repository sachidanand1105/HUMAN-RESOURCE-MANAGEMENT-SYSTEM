package hrms.common;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import hrms.admin.AdminDsahBoard;
import hrms.hr.HrDashboard;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;

public class Login extends JFrame implements ActionListener,KeyListener{

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtid;
	private JPasswordField txtpass;
	private JRadioButton rdhr,rdAdmin;
	private final ButtonGroup groupRoles = new ButtonGroup();
	private JLabel lblimage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
		EventQueue.invokeLater(new Runnable() {//Event dispatcher thread that governs GUI programing
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Login.class.getResource("/hrms/image/login.png")));
		setResizable(false);
		setTitle("Login Frame");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 648, 456);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 228, 109));
		contentPane.setBorder(new LineBorder(new Color(64, 0, 0), 5, true));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		JLabel lblNewLabel = new JLabel("ID");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel.setBounds(120, 69, 108, 35);
		contentPane.add(lblNewLabel);
		
		txtid = new JTextField();
		txtid.setToolTipText(" Enter ID");
		txtid.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtid.setForeground(new Color(255, 0, 0));
		txtid.setBounds(317, 67, 186, 43);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_1.setBounds(110, 163, 134, 37);
		contentPane.add(lblNewLabel_1);
		
		txtpass = new JPasswordField();
		txtpass.setToolTipText("Enter Password Here");
		txtpass.setFont(new Font("Calibri", Font.PLAIN, 14));
		txtpass.setForeground(new Color(255, 0, 0));
		txtpass.setBounds(317, 162, 186, 43);
		contentPane.add(txtpass);
		
	    rdhr = new JRadioButton("HR");
		rdhr.setBackground(new Color(220, 228, 109));
		groupRoles.add(rdhr);
		rdhr.setFont(new Font("Calibri", Font.PLAIN, 20));
		rdhr.setForeground(new Color(255, 0, 0));
		rdhr.setBounds(135, 246, 109, 23);
		contentPane.add(rdhr);
		
	    rdAdmin = new JRadioButton("Admin");
		rdAdmin.setBackground(new Color(220, 228, 109));
		groupRoles.add(rdAdmin);
		rdAdmin.setFont(new Font("Calibri", Font.PLAIN, 20));
		rdAdmin.setForeground(new Color(255, 0, 0));
		rdAdmin.setBounds(349, 246, 108, 23);
		contentPane.add(rdAdmin);
		
		JButton btnSubmit = new JButton("Submit\r\n");
		btnSubmit.addActionListener(this);
		btnSubmit.addKeyListener(this);
		btnSubmit.setFont(new Font("Calibri", Font.PLAIN, 20));
		btnSubmit.setForeground(new Color(255, 0, 0));
		btnSubmit.setBounds(211, 306, 140, 31);
		contentPane.add(btnSubmit);
		
		////to show custom size image on label
		
        ImageIcon ic=new ImageIcon(SplashScreen.class.getResource("/hrms/image/retrosupply-jLwVAUtLOAQ-unsplash.jpg"));
		
		Image i2=ic.getImage().getScaledInstance(632, 417, Image.SCALE_DEFAULT);//for image scaling
		
		ImageIcon ic1=new ImageIcon(i2);
	
		lblimage = new JLabel("");
		lblimage.setIcon(ic1);
		lblimage.setBounds(0, 0, 632, 417);
		contentPane.add(lblimage);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
//		System.out.println("button is clicked");
		login();	
	}
	
	public void login() 
	{
		String id=txtid.getText().trim();//trim method remove leading and trailing space
		
		char[] pass=txtpass.getPassword();
		
		String password=String.valueOf(pass);//converting array into string
		
		String userRole="";
		
		if(rdAdmin.isSelected())//to check which radio button is selected
			userRole=rdAdmin.getText();//fetch the text
		
		if(rdhr.isSelected())
			userRole=rdhr.getText();
		
		// validation code for mandatory field
		
		if(id.length()==0||password.isEmpty()||userRole.length()==0)
			
		JOptionPane.showMessageDialog(this, "All Fields are Mandatory");
		else {
			if(id.equalsIgnoreCase("Ayush") && password.equals("admin") &&userRole.equals("Admin"))
			{
				AdminDsahBoard admindash=new  AdminDsahBoard();
				admindash.setVisible(true);
				this.dispose();
			}
			
			else if(id.equalsIgnoreCase("Sonu") && password.equals("hr") && userRole.equals("HR"))
			{
				HrDashboard hrdash=new  HrDashboard();
				hrdash.setVisible(true);
				this.dispose();
			}
			
			else {
				JOptionPane.showMessageDialog(this, "Invalid Credentials", "Login Error",JOptionPane.ERROR_MESSAGE );
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int keyCode=e.getKeyCode();//get the specific ASCII value for that key
//		System.out.println(keyCode);
		if(keyCode==10)
			login();
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	
}
