package typo;
//static methods only
public class Encryptor {
	public static String encrypt(String input){
		char[] inputs = input.toCharArray();
		int asciiValue;
		for(int i = 0; i < input.length(); i += 1){
			asciiValue = (int) inputs[i];
			inputs[i] = (char) (asciiValue + 10);
		}
		return String.copyValueOf(inputs);
		
	}
	public static String decrypt(String input){
		char[] inputs = input.toCharArray();
		int asciiValue;
		for(int i = 0; i < input.length(); i += 1){
			asciiValue = (int) inputs[i];
			inputs[i] = (char) (asciiValue - 10);
		}
		return String.copyValueOf(inputs);
		
	}
	
	
}
