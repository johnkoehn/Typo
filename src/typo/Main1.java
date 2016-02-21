package typo;

public class Main1
{

	public static void main(String[] args)
	{
		KeyManager mang = new KeyManager();
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
							System.out.println("test");
							
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
}