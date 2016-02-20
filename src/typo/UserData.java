package typo;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class UserData {

	public String username;
	public String password;
	private ArrayList<String> authorizedUsers = new ArrayList<String>();
	private File input = new File("UserData.txt");
	private Scanner scan;
	
	public UserData(){
		readFile();
	}
	
	public void setUsername(String desiredUsername){
		username = desiredUsername;
	}
	
	public void setPassword(String desiredPassword){
		password = desiredPassword;
	}
	
	private void readFile(){
		int i = 0;
		try {
			scan = new Scanner(input);
			while(scan.hasNextLine()){
				
				if(i == 0)
					username = scan.nextLine();
				else if(i==1)
					password = scan.nextLine();
				else
					authorizedUsers.add(scan.nextLine());
			
				i += 1;
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String getUsername(){
		return username;
	}
	
	
	public String getPassword(){
		return password;
	}

	public void addAuthorizedUser(String user){
		authorizedUsers.add(user);
	}
	
	public void removeAuthorizedUser(int index)
	{
		authorizedUsers.remove(index);
	}
	
	public ArrayList<String> getAuthorizedUsers(){
		return authorizedUsers;
	}

	public void writeToFile(){
		PrintWriter output;
		try {
			output = new PrintWriter(input);
			output.println(username);
			output.println(password);
			for(int i=0; i < authorizedUsers.size(); i += 1){
				output.println(authorizedUsers.get(i));
				
			}
			output.close();
		
		
		} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
	}
	
}
