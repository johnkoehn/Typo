package typo;

import java.util.ArrayList;


//Global key listener libraries
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

import java.util.logging.*;


public class KeyManager
{
	ArrayList<Key> keys;
	Key k;
	
	Key currPressed;
	Key lastReleased;
	
	Key lastKeyReleased;
	Key currKeyReleased;
	Key lastKeyPressed;
	
	boolean hasNextKeyTyped;	
	
	public KeyManager()
	{
		keys = new ArrayList<Key>();
		
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
				currKeyReleased = new Key(e.getKeyCode());
				alertKeyReleased(e.getKeyCode());
			}
			
			@Override
			public void nativeKeyPressed(NativeKeyEvent e)
			{
				int keyID = e.getKeyCode();
				alertKeyPressed(keyID);
				System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
			
				lastKeyReleased = currKeyReleased;
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
			for(int i = 0; i < keys.size() && (k.getID() == keyCode); i++)
			{
				k = keys.get(i);
				
				if(k.getID() == keyCode)
				{
					k.pressed();
					if(lastKeyReleased != null)
					{
						lastKeyReleased.setNextKey(keyCode);
					}
					lastKeyReleased = k;
			
				}
			}	
		}
		
		public void alertKeyReleased(int keyCode)
		{
			for(int i = 0; i < keys.size() && (k.getID() == keyCode) ; i++)
			{
				k = keys.get(i);
				if(k.getID() == keyCode)
				{
					k.released();
				}
			}
			
			System.out.println("Last Key Pressed: " + NativeKeyEvent.getKeyText(lastKeyReleased.getID()) + "\n");
		}
		
		public void write()
		{
			for(Key key : keys)
			{
				key.write();
			}
		}
}
	
	

