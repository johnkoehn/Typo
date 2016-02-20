package typo;

public class DwellTime
{
	private int id;
	private int masterId;
	int times[] = new int[5];
	int avgTime = 0;
	boolean first = true;
	int index;
	
	public DwellTime(int id, int masterId)
	{
		this.id = id;
		this.masterId = masterId;
		index = times.length;
	}
	
	public void receive(int time)
	{
		//check if this is the first time received
		if(!first)
		{
			for(int i = 0; i < times.length - 1; i++)
			{
				times[i] = times[i+1];
			}
			if(index > 0)
			{
				index -= 1;
			}
			avg();

		}
		else
		{
			times[4] = time;
			avgTime = time;
			first = false;
			index += 1;
		}
	}
	
	private void avg()
	{
		int sum = 0;
		int count = 0;
		for(int i = times.length; i >= index; i--)
		{
			sum += times[i];
			count += 1;
		}
		
		avgTime = sum/count;
	}
	
	public int getId()
	{
		return id;
	}
	
	public int getTime()
	{
		return avgTime;
	}
	
	public String write()
	{
		return masterId + "," + id + "," + avgTime;
	}
}
