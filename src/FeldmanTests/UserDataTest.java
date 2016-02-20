package FeldmanTests;

import typo.UserData;

public class UserDataTest {

	public static void main(String[] args){
		UserData a = new UserData();
		System.out.println(a.username);
		System.out.println(a.password);
		
		
//		a.setUsername("admin");
//		a.setPassword("toast");
		
//		a.removeAuthorizedUser("ExampleUser1");
		
		System.out.println(a.getAuthorizedUsers());
		a.writeToFile();
		
		
	}
}
