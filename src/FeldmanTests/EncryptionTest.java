package FeldmanTests;

import typo.Encryptor;

public class EncryptionTest {
	public static void main(String[] args){
		String s= "jacob feldman";
		
		s = Encryptor.encrypt(s);
		System.out.println(s);
		
		s = Encryptor.decrypt(s);
		System.out.println(s);
	}
}
