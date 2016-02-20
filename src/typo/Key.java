package typo;

import java.util.ArrayList;

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
			dManager.pressed(ID, dwellTime);
			System.out.println("1");
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
	
	public void write()
	{
		dManager.write("test");
	}
	
	public ArrayList<String> writeBig(){
		return dManager.writeBig();
	}
	
}
