package typo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;

public class Main {
	
	 static int flightTime;
	 static int dwellTime;
	 static String lastReleased;
	 static String currPressed;
	 
	 static int timePress;
	 static int timeRelease;
	 
	 static String dwell;
	 static String flight;
	 
	 static boolean first = true;
	 
	 static File f = new File("type.txt");
	 static PrintWriter writer;
	 
    public static void main(String[] args) throws IOException {
    	
        try {
            GlobalScreen.registerNativeHook();
        }
        catch (NativeHookException ex) {
            System.err.println("There was a problem registering the native hook.");
            System.err.println(ex.getMessage());

            System.exit(1);
        }
       
        try {
			writer = new PrintWriter(new FileWriter((f), true));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        writer.write("");
        GlobalScreen.addNativeKeyListener(new NativeKeyListener() {
			
			@Override
			public void nativeKeyTyped(NativeKeyEvent e)
			{
				System.out.println("Key Typed" + e.getKeyChar());
			}
			
			@Override
			public void nativeKeyReleased(NativeKeyEvent e)
			{
				 try {
						writer = new PrintWriter(new FileWriter((f), true));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
				timeRelease = (int) System.currentTimeMillis();
				dwellTime = (int)(timeRelease - timePress);
				dwell = ("Dwell Time of " + currPressed + ": " + dwellTime);
				
				writer.println(dwell);
				writer.println("hrhello");
				writer.flush();
				
				System.out.println("Key Released: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
				lastReleased = NativeKeyEvent.getKeyText(e.getKeyCode());
			}
			
			@Override
			public void nativeKeyPressed(NativeKeyEvent e)
			{
				 try {
						writer = new PrintWriter(new FileWriter((f), true));
					} catch (FileNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} 
				 
				 if(first == true)
				 {
					 writer.write("");
				 }
				 
				currPressed = NativeKeyEvent.getKeyText(e.getKeyCode());
				timePress = (int) System.currentTimeMillis();
				flightTime = (int)(timePress - timeRelease);
				
				flight = ("Flight time from " + lastReleased + " to " + currPressed + ": " + flightTime);
				writer.println(flight);
				writer.flush();
				System.out.println("Key Pressed: " + NativeKeyEvent.getKeyText(e.getKeyCode()));
				
				first = false;
				
				}
			}
        );
        
        writer.close();
    }
}