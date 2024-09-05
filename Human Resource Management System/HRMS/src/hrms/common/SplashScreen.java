package hrms.common;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.ImageIcon;

public class SplashScreen extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SplashScreen frame = new SplashScreen();
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
	
	//to load login frame
	
	public void showLogin()
	{
		Thread t=new Thread(new Runnable() {
			
			@Override
			public void run()
			{
				try 
				{
					Thread.sleep(5000);
					Login login=new Login();
					   login.setVisible(true);
					   
					SplashScreen.this.dispose();
					
				} catch (InterruptedException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
		
		t.start();
	}
	public SplashScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 527, 473);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HRMS Welcomes you!");
		lblNewLabel.setForeground(new Color(255, 0, 0));
		lblNewLabel.setFont(new Font("Trebuchet MS", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(99, 48, 317, 42);
		contentPane.add(lblNewLabel);
		
		//to show custom size image on label
		
		ImageIcon ic=new ImageIcon(SplashScreen.class.getResource("/hrms/image/tim-mossholder-8FBTtjCZ9oM-unsplash (1).jpg"));
		
		Image i2=ic.getImage().getScaledInstance(313, 243, Image.SCALE_DEFAULT);//for image scaling
		
		ImageIcon ic1=new ImageIcon(i2);
		
		
		JLabel lblimage = new JLabel("New label");
		lblimage.setIcon(ic1);
		lblimage.setBounds(103, 134, 313, 243);
		contentPane.add(lblimage);
		showLogin();
	}

}
