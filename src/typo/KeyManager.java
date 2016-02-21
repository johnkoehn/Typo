package typo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

//Global key listener libraries
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;


public class KeyManager
{
	ArrayList<Key> keys;
	Key k;
	
	Key currPressed;
	Key lastReleased;
	
	Key lastKeyReleased;
	Key currKeyReleased;
	Key lastKeyPressed;
	
	private String user;
	boolean hasNextKeyTyped;	
	
	public KeyManager(String user, boolean newUser)
	{
		keys = new ArrayList<Key>();
		this.user = user;
		
		if(newUser)
		{
			//Adds all of the keys to ArrayList<Key> keys
			k = new Key(NativeKeyEvent.VC_A);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_B);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_C);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_D);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_E);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_F);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_G);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_H);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_I);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_J);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_K);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_L);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_M);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_N);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_O);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_P);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_Q);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_R);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_S);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_T);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_U);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_V);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_W);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_X);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_Y);
			keys.add(k);
			k = new Key(NativeKeyEvent.VC_Z);
			keys.add(k);	
			k = new Key(NativeKeyEvent.VC_SPACE);
			keys.add(k);
		}
		else
		{
			loadKeyData();
		}

	
	}
	
	private void loadKeyData()
	{
		//Adds all of the keys to ArrayList<Key> keys
		k = new Key(NativeKeyEvent.VC_A, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_B, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_C, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_D, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_E, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_F, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_G, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_H, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_I, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_J, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_K, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_L, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_M, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_N, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_O, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_P, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_Q, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_R, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_S, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_T, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_U, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_V, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_W, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_X, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_Y, user);
		keys.add(k);
		k = new Key(NativeKeyEvent.VC_Z, user);
		keys.add(k);	
		k = new Key(NativeKeyEvent.VC_SPACE, user);
		keys.add(k);
	}
	
	public void createListener()
	{
		 try {
	         GlobalScreen.registerNativeHook();
	         Logger logger = Logger.getLogger(GlobalScreen.class.getPackage().getName());
	         logger.setLevel(Level.OFF);
	     }
	     catch (NativeHookException ex) {
	         System.err.println("There was a problem registering the native hook.");
	         System.err.println(ex.getMessage());

	         System.exit(1);
	     }
		 
     GlobalScreen.addNativeKeyListener(new NativeKeyListener() {
		
			@Override
			public void nativeKeyReleased(NativeKeyEvent e)
			{
				System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
				//currKeyReleased = new Key(e.getKeyCode());
				alertKeyReleased(e.getKeyCode());
			}
			
			@Override
			public void nativeKeyPressed(NativeKeyEvent e)
			{
				int keyID = e.getKeyCode();
				alertKeyPressed(keyID);
				System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
			
				//lastKeyReleased = currKeyReleased;
			}

			@Override
			public void nativeKeyTyped(NativeKeyEvent e)
			{
				System.out.println("Key Typed: " + e.getKeyChar());
			}
		}
     );
	}
	
		public void alertKeyPressed(int keyCode)
		{
			for(int i = 0; i < keys.size(); i++)
			{
				k = keys.get(i);
				
				if(k.getID() == keyCode)
				{
					k.pressed();
					if(lastKeyReleased != null)
					{
						System.out.println("2");
						lastKeyReleased.setNextKey(keyCode);
					}
					lastKeyReleased = k;
					break;
			
				}
			}	
		}
		
		public void alertKeyReleased(int keyCode)
		{
			for(int i = 0; i < keys.size(); i++)
			{
				k = keys.get(i);
				if(k.getID() == keyCode)
				{
					k.released();
					break;
				}
			}
			
			System.out.println("Last Key Pressed: " + NativeKeyEvent.getKeyText(lastKeyReleased.getID()) + "\n");
		}
		
		public void write()
		{
			for(Key key : keys)
			{
				key.write(user);
			}
		}
		
		public void writeBig(){
			File file = new File(user + "_Big.txt");
			try
			{
				PrintWriter writer = new PrintWriter(file);
				
				for(int i = 0; i < keys.size(); i += 1){
					ArrayList<String> lines = keys.get(i).writeBig();
					
					for(int j = 0; j < lines.size(); j += 1){
						writer.println(lines.get(j));
					}
				}
				
				writer.close();
			} catch (FileNotFoundException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
}
	
	

