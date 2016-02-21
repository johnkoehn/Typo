package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import jdk.nashorn.internal.scripts.JO;
import typo.KeyManager;
import typo.UserData;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDialog;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
					MainUI frame = new MainUI(new UserData());
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
	public MainUI(UserData data)
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 474, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		initUserList(data);
		contentPane.add(scrollPaneList);
		
		JButton btnAddNewPersonal = new JButton("Add New Personal");
		btnAddNewPersonal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnAddNewPersonal.setBounds(10, 408, 134, 28);
		contentPane.add(btnAddNewPersonal);
		
		btnAddNewPersonal.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				//add a new user
				String name = JOptionPane.showInputDialog("Enter name of new User:");
				if(name != null)
				{
					userModel.addUser(name);
					revalidate();	
					
					JDialog messageDialog = new JDialog(MainUI.this, "Learning your typing patterns");
					//messageDialog.setTitle("Learning");
					messageDialog.setSize(300, 150);
					messageDialog.setLocationRelativeTo(MainUI.this);
					messageDialog.add(new JLabel("Learning your typing patterns!"));
					//messageDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
					messageDialog.setVisible(true);
					
					//launch a session
					EventQueue.invokeLater(new Runnable()
					{
						
						@Override
						public void run()
						{
							KeyManager mang = new KeyManager(name, true);
							mang.createListener();
							
							Thread thred = new Thread(new Runnable()
							{
								@Override
								public void run()
								{
									while(true)
									{
										try
										{
											Thread.sleep(30000);
											mang.write();
											mang.writeBig();
										} catch (InterruptedException e)
										{
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										
									}	
								}
							});
							
							thred.start();
							
							Thread validationThread = new Thread(new Runnable()
							{
								@Override
								public void run()
								{
									while(true)
									{
										try
										{
											Thread.sleep(1);
											if((System.currentTimeMillis() - KeyManager.timeOfLastKeyPress) > 30000)
											{
												KeyManager.validate = true;
												
											}
										} catch (InterruptedException e)
										{
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										
									}	
								}
							});
							validationThread.start();
							
						}
					});
					
				}
				else 
				{
					JOptionPane.showMessageDialog(new JFrame(), "Enter valid name!");
				}
				
			}
		});
		
		JButton btnRemovePersonal = new JButton("Remove Personal");
		btnRemovePersonal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnRemovePersonal.setBounds(156, 408, 134, 28);
		contentPane.add(btnRemovePersonal);
		
		btnRemovePersonal.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int index = userList.getSelectedIndex();
				
				if(index < 0)
				{
					JOptionPane.showMessageDialog(MainUI.this, "Please select a user to remove!");
					return;
				}
				
				userModel.removeUser(userList.getSelectedIndex());
				revalidate();
				
			}
		});
		
		JButton btnStartSecureSession = new JButton("Secure Mode");
		btnStartSecureSession.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnStartSecureSession.setBounds(299, 408, 134, 28);
		contentPane.add(btnStartSecureSession);
		
		//when secure mode pressed, hide gui
		btnStartSecureSession.addActionListener(new ActionListener()
		{
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				int index = userList.getSelectedIndex();
				
				if(index < 0)
				{
					JOptionPane.showMessageDialog(MainUI.this, "Please select a user to start the session as!");
					return;
				}
				
				setVisible(false);
				EventQueue.invokeLater(new Runnable()
				{
					
					@Override
					public void run()
					{
						KeyManager mang = new KeyManager((String)userModel.getElementAt(index), false);
						mang.createListener();
						
						Thread thred = new Thread(new Runnable()
						{
							@Override
							public void run()
							{
								while(true)
								{
									try
									{
										Thread.sleep(30000);
										mang.write();
										mang.writeBig();
									} catch (InterruptedException e)
									{
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
								}	
							}
						});
						
						thred.start();
						
						Thread validationThread = new Thread(new Runnable()
						{
							@Override
							public void run()
							{
								while(true)
								{
									try
									{
										Thread.sleep(1);
										if((System.currentTimeMillis() - KeyManager.timeOfLastKeyPress) > 30000)
										{
											KeyManager.validate = true;
											
										}
									} catch (InterruptedException e)
									{
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									
								}	
							}
						});
						validationThread.start();
						
					}
				});
			}
		});
		
		JLabel lblNewLabel = new JLabel("Authorized Personal");
		lblNewLabel.setFont(new Font("Verdana", Font.PLAIN, 20));
		lblNewLabel.setBounds(25, 35, 233, 28);
		contentPane.add(lblNewLabel);
	}
	
	private void initUserList(UserData data)
	{
		//user model data
		userModel = new UserModel(data);
		
		userList = new JList();
		userList.setSelectionBackground(Color.YELLOW);
		userList.setModel(userModel);
		
		scrollPaneList = new JScrollPane(userList);
		scrollPaneList.setBounds(10, 106, 231, 266);
		
	}
}
