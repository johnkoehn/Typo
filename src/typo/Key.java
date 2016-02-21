package typo;

public class Key
{
	private DwellTimeManager dManager;
	private int KeyID;
	
	private boolean pressed;
	private boolean released;
	
	private int timePressed;
	private int timeReleased;
	
	private int dwellTime = 0;
	private int FlightTime;
	
	private int nextKeyID;
	private volatile boolean keyEdgeCase;
	
	public Key(int ID)
	{ 
		KeyID = ID;
		dManager = new DwellTimeManager(ID);
	}
	
	public int getID()
	{
		return KeyID;
	}
	
	public void pressed()
	{
		timePressed = (int)System.currentTimeMillis();
		pressed = true;
		released = false;
	}
	
	public void released()
	{
		timeReleased = (int)System.currentTimeMillis();
		getDwellTime();
		pressed = false;
		released = true;
		
		if(keyEdgeCase == true);
		{
			handleKeyPress();
			validateKey();
		}
	}
	
	public int getDwellTime()
	{
		dwellTime = (timeReleased - timePressed);
		return dwellTime;
	}
	
	public void handleKeyPress()
	{
		if(!KeyManager.validate)
		{
			dManager.pressed(nextKeyID, dwellTime);
		}
		
	}
	
	public void setNextKey(int ID)
	{
		keyEdgeCase = true;
		nextKeyID = ID;
		
		if(released == true)
		{
			handleKeyPress();
			validateKey();
			System.out.println("1");
			keyEdgeCase = false;
		}
		else
		{
			keyEdgeCase = true;
		}
		
	}
	
	public int getNextKey()
	{
		return nextKeyID;
	}
	
	public void validateKey()
	{
			if(KeyManager.validate){
			int value = dManager.validate(nextKeyID, dwellTime);
			
			//make sure the validation worked
			if(value != 2 && KeyManager.count < KeyManager.numberOfCheckedKeyPresses)
			{
				KeyManager.checkedKeyPresses[KeyManager.count] = value; 
				KeyManager.count += 1;
			}
			
			if(KeyManager.count == KeyManager.numberOfCheckedKeyPresses)
			{
				KeyManager.validate(this);
			}
		}
	}
	
	public void write()
	{
		dManager.write("test");
	}
	
}
