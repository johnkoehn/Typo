package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;

public class MainUI extends JFrame
{

	private JPanel contentPane;
	private JList userList;
	private UserModel userModel;
	private JScrollPane scrollPaneList;

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
					MainUI frame = new MainUI();
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
	public MainUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		initUserList();
		contentPane.add(scrollPaneList);
		
		JButton btnAddNewPersonal = new JButton("Add New Personal");
		btnAddNewPersonal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAddNewPersonal.setBounds(10, 408, 134, 28);
		contentPane.add(btnAddNewPersonal);
		
		JButton btnRemovePersonal = new JButton("Remove Personal");
		btnRemovePersonal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRemovePersonal.setBounds(156, 408, 134, 28);
		contentPane.add(btnRemovePersonal);
		
		JButton btnStartSecureSession = new JButton("Secure Mode");
		btnStartSecureSession.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnStartSecureSession.setBounds(299, 408, 134, 28);
		contentPane.add(btnStartSecureSession);
		
		JLabel lblNewLabel = new JLabel("Authorized Personal");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel.setBounds(25, 35, 233, 28);
		contentPane.add(lblNewLabel);
	}
	
	private void initUserList()
	{
		//user model data
		UserModel model = new UserModel();
		
		userList = new JList();
		userList.setSelectionBackground(Color.YELLOW);
		userList.setModel(model);
		
		scrollPaneList = new JScrollPane(userList);
		scrollPaneList.setBounds(10, 106, 231, 266);
		
	}
}
