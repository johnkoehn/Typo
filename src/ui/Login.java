package ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import javafx.scene.control.PasswordField;
import sun.util.logging.resources.logging;
import typo.UserData;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Login extends JFrame 
{

	private JPanel contentPane;
	private JTextField userField;
	private JPasswordField passwordField;
	private UserData userData;
	private BufferedImage image;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() 
	{
		//init UserData
		userData = new UserData();
		
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUser = new JLabel("Username");
		lblUser.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblUser.setBounds(29, 119, 107, 38);
		contentPane.add(lblUser);
		
		userField = new JTextField();
		userField.setFont(new Font("Verdana", Font.PLAIN, 12));
		userField.setBounds(29, 168, 144, 20);
		contentPane.add(userField);
		userField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		passwordLabel.setBounds(29, 199, 107, 20);
		contentPane.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setFont(new Font("Verdana", Font.PLAIN, 12));
		passwordField.setColumns(10);
		passwordField.setBounds(29, 230, 144, 20);
		contentPane.add(passwordField);
		
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(238, 181, 107, 38);
		contentPane.add(loginButton);
		

		//load Typo logo
		try
		{
			image = ImageIO.read(new File("logo_2.png"));
			JLabel logo = new JLabel(new ImageIcon(image));
			logo.setBounds(10, 11, 368, 118);
			contentPane.add(logo);
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		
		//add action listener for login button to check is the username and password are correct
		loginButton.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//check for valid login
				checkLogin();
				
			}
		});
		
		//if the user hits enter when typing in their password, also check for correct username and password
		passwordField.addKeyListener(new KeyListener() 
		{
			
			@Override
			public void keyTyped(KeyEvent e) 
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) 
			{
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) 
			{
				if(e.getKeyCode() == KeyEvent.VK_ENTER)
				{
					//check for a valid login
					checkLogin();
					
				}
					
			}
		});
		

	}
	
	private void checkLogin()
	{
		if(userData.getUsername().equals(userField.getText()) && userData.getPassword().equals(passwordField.getText()))
		{
			//successful login, dispose current window and open MainUI
			dispose();
			EventQueue.invokeLater(new Runnable()
			{
				
				@Override
				public void run()
				{
					MainUI ui = new MainUI(new UserData());
					ui.setVisible(true);
					
				}
			});
		}
		else
		{
			JOptionPane.showMessageDialog(new JFrame(), "Invalid Username or Password!!");
			
			//clear password field
			passwordField.setText("");
			revalidate();
		}
			
	}
}
