package ui;

import java.util.ArrayList;

import javax.swing.AbstractListModel;

public class UserModel extends AbstractListModel<Object>
{
	private ArrayList<String> users;
	
	public UserModel()
	{
		users = new ArrayList<String>();
		users.add("poop");
		users.add("shit");
	}
	
	@Override
	public Object getElementAt(int index)
	{
		if(index >= users.size() || index < 0)
			return null;
		
		return users.get(index);
	}

	@Override
	public int getSize()
	{
		return users.size();
	}

}
