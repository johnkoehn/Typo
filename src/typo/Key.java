package typo;

public class Key
{
	private DwellTimeManager dManager;
	private int KeyID;
	
	private boolean pressed;
	private boolean released;
	
	private int timePressed;
	private int timeReleased;
	
	private int dwellTime;
	private int FlightTime;
	
	private int nextKeyID;
	private boolean keyEdgeCase;
	
	public Key(int ID)
	{ 
		KeyID = ID;
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
		
		if(keyEdgeCase == true)
		{
			handleKeyPress();
		}
	}
	
	public int getDwellTime()
	{
		dwellTime = (timeReleased - timePressed);
		return dwellTime;
	}
	
	public void handleKeyPress()
	{
		dManager.pressed(nextKeyID, dwellTime);
	}
	
	public void setNextKey(int ID)
	{
		keyEdgeCase = true;
		
		if(released == true){
			dManager.pressed(nextKeyID, dwellTime);
			keyEdgeCase = false;
		}
		else
		{
			keyEdgeCase = true;
		}
		nextKeyID = ID;
	}
	
	public int getNextKey()
	{
		return nextKeyID;
	}
	
	
}
