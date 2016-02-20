package ui;

import java.util.ArrayList;

import javax.swing.AbstractListModel;

import typo.UserData;

public class UserModel extends AbstractListModel<Object>
{
	private UserData data;
	
	public UserModel(UserData data)
	{
		this.data = data;
	}
	
	@Override
	public Object getElementAt(int index)
	{
		if(index >= data.getAuthorizedUsers().size() || index < 0)
			return null;
		
		return data.getAuthorizedUsers().get(index);
	}

	@Override
	public int getSize()
	{
		return data.getAuthorizedUsers().size();
	}
	
	public void addUser(String userName)
	{
		data.addAuthorizedUser(userName);
		data.writeToFile();
		fireContentsChanged(data.getAuthorizedUsers(), 0, getSize());
	}
	
	public void removeUser(int index)
	{
		data.removeAuthorizedUser(index);
		data.writeToFile();
		fireContentsChanged(data.getAuthorizedUsers(), 0, getSize());
	}

}
