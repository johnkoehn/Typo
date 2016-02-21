package typo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import org.jnativehook.keyboard.NativeKeyEvent;

public class DwellTimeManager
{
	private ArrayList<DwellTime> dTimes = new ArrayList<DwellTime>();
	
	private int masterId;
	
	public DwellTimeManager(int masterId){
		dTimes.add(new DwellTime(NativeKeyEvent.VC_A, masterId));
		dTimes.add(new DwellTime(NativeKeyEvent.VC_B, masterId));
		dTimes.add(new DwellTime(NativeKeyEvent.VC_C, masterId));
		dTimes.add(new DwellTime(NativeKeyEvent.VC_D, masterId));
		dTimes.add(new DwellTime(NativeKeyEvent.VC_E, masterId));
		dTimes.add(new DwellTime(NativeKeyEvent.VC_F, masterId));
		dTimes.add(new DwellTime(NativeKeyEvent.VC_G, masterId));
		dTimes.add(new DwellTime(NativeKeyEvent.VC_H, masterId));
		dTimes.add(new DwellTime(NativeKeyEvent.VC_I, masterId));
		dTimes.add(new DwellTime(NativeKeyEvent.VC_J, masterId));
		dTimes.add(new DwellTime(NativeKeyEvent.VC_K, masterId));
		dTimes.add(new DwellTime(NativeKeyEvent.VC_L, masterId));
		dTimes.add(new DwellTime(NativeKeyEvent.VC_M, masterId));
		dTimes.add(new DwellTime(NativeKeyEvent.VC_N, masterId));
		dTimes.add(new DwellTime(NativeKeyEvent.VC_O, masterId));
		dTimes.add(new DwellTime(NativeKeyEvent.VC_P, masterId));
		dTimes.add(new DwellTime(NativeKeyEvent.VC_Q, masterId));
		dTimes.add(new DwellTime(NativeKeyEvent.VC_R, masterId));
		dTimes.add(new DwellTime(NativeKeyEvent.VC_S, masterId));
		dTimes.add(new DwellTime(NativeKeyEvent.VC_T, masterId));
		dTimes.add(new DwellTime(NativeKeyEvent.VC_U, masterId));
		dTimes.add(new DwellTime(NativeKeyEvent.VC_V, masterId));
		dTimes.add(new DwellTime(NativeKeyEvent.VC_W, masterId));
		dTimes.add(new DwellTime(NativeKeyEvent.VC_X, masterId));
		dTimes.add(new DwellTime(NativeKeyEvent.VC_Y, masterId));
		dTimes.add(new DwellTime(NativeKeyEvent.VC_Z, masterId));
		dTimes.add(new DwellTime(NativeKeyEvent.VC_SPACE, masterId));
		
		this.masterId = masterId;
	}
	
	public DwellTimeManager(int masterId, String user)
	{
		this.masterId = masterId;
		File file = new File("");
		
		//read in data
		switch(masterId)
		{
		case(NativeKeyEvent.VC_A):
			file = new File(user + "_A");
			break;
		case(NativeKeyEvent.VC_B):
			file = new File(user + "_B");
			break;
		case(NativeKeyEvent.VC_C):
			file = new File(user + "_C");
			break;
		case(NativeKeyEvent.VC_D):
			file = new File(user + "_D");
			break;
		case(NativeKeyEvent.VC_E):
			file = new File(user + "_E");
			break;
		case(NativeKeyEvent.VC_F):
			file = new File(user + "_F");
			break;
		case(NativeKeyEvent.VC_G):
			file = new File(user + "_G");
			break;
		case(NativeKeyEvent.VC_H):
			file = new File(user + "_H");
			break;
		case(NativeKeyEvent.VC_I):
			file = new File(user + "_I");
			break;
		case(NativeKeyEvent.VC_J):
			file = new File(user + "_J");
			break;
		case(NativeKeyEvent.VC_K):
			file = new File(user + "_K");
			break;
		case(NativeKeyEvent.VC_L):
			file = new File(user + "_L");
			break;
		case(NativeKeyEvent.VC_M):
			file = new File(user + "_M");
			break;
		case(NativeKeyEvent.VC_N):
			file = new File(user + "_N");
			break;
		case(NativeKeyEvent.VC_O):
			file = new File(user + "_O");
			break;
		case(NativeKeyEvent.VC_P):
			file = new File(user + "_P");
			break;
		case(NativeKeyEvent.VC_Q):
			file = new File(user + "_Q");
			break;
		case(NativeKeyEvent.VC_R):
			file = new File(user + "_R");
			break;
		case(NativeKeyEvent.VC_S):
			file = new File(user + "_S");
			break;
		case(NativeKeyEvent.VC_T):
			file = new File(user + "_T");
			break;
		case(NativeKeyEvent.VC_U):
			file = new File(user + "_U");
			break;
		case(NativeKeyEvent.VC_V):
			file = new File(user + "_V");
			break;
		case(NativeKeyEvent.VC_W):
			file = new File(user + "_W");
			break;
		case(NativeKeyEvent.VC_X):
			file = new File(user + "_X");
			break;
		case(NativeKeyEvent.VC_Y):
			file = new File(user + "_Y");
			break;
		case(NativeKeyEvent.VC_Z):
			file = new File(user + "_Z");
			break;
		case(NativeKeyEvent.VC_SPACE):
			file = new File(user + "_SP");
			break;
		case(NativeKeyEvent.VC_ENTER):
			file = new File(user + "_Enter");
			break;
		case(NativeKeyEvent.VC_COMMA):
			file = new File(user + "_Comma");
			break;
		case(NativeKeyEvent.VC_PERIOD):
			file = new File(user + "_Period");
			break;
		case(NativeKeyEvent.VC_SHIFT_L):
			file = new File(user + "_Shift_L");
			break;
		case(NativeKeyEvent.VC_SHIFT_R):
			file = new File(user + "_Shift_R");
			break;
		case(NativeKeyEvent.VC_SEMICOLON):
			file = new File(user + "_Semicolon");
			break;
		case(NativeKeyEvent.VC_BACKSPACE):
			file = new File(user + "_Backspace");
			break;
		case(NativeKeyEvent.VC_0):
			file = new File(user + "_0");
			break;
		case(NativeKeyEvent.VC_1):
			file = new File(user + "_1");
			break;
		case(NativeKeyEvent.VC_2):
			file = new File(user + "_2");
			break;
		case(NativeKeyEvent.VC_3):
			file = new File(user + "_3");
			break;
		case(NativeKeyEvent.VC_4):
			file = new File(user + "_4");
			break;
		case(NativeKeyEvent.VC_5):
			file = new File(user + "_5");
			break;
		case(NativeKeyEvent.VC_6):
			file = new File(user + "_6");
			break;
		case(NativeKeyEvent.VC_7):
			file = new File(user + "_7");
			break;
		case(NativeKeyEvent.VC_8):
			file = new File(user + "_8");
			break;
		case(NativeKeyEvent.VC_9):
			file = new File(user + "_9");
			break;
		default:
			break;
	}
		try
		{
			Scanner scan = new Scanner(file);
			scan.useDelimiter(",");
			scan.next();
			scan.next();
			dTimes.add(new DwellTime(NativeKeyEvent.VC_A, masterId, Integer.parseInt(scan.next()), Integer.parseInt(scan.next())));
			
			scan.next();
			scan.next();
			dTimes.add(new DwellTime(NativeKeyEvent.VC_B, masterId, Integer.parseInt(scan.next()), Integer.parseInt(scan.next())));
			
			scan.next();
			scan.next();
			dTimes.add(new DwellTime(NativeKeyEvent.VC_C, masterId, Integer.parseInt(scan.next()), Integer.parseInt(scan.next())));
			
			scan.next();
			scan.next();
			dTimes.add(new DwellTime(NativeKeyEvent.VC_D, masterId, Integer.parseInt(scan.next()), Integer.parseInt(scan.next())));
			
			scan.next();
			scan.next();
			dTimes.add(new DwellTime(NativeKeyEvent.VC_E, masterId, Integer.parseInt(scan.next()), Integer.parseInt(scan.next())));
			
			scan.next();
			scan.next();
			dTimes.add(new DwellTime(NativeKeyEvent.VC_F, masterId, Integer.parseInt(scan.next()), Integer.parseInt(scan.next())));
			
			scan.next();
			scan.next();
			dTimes.add(new DwellTime(NativeKeyEvent.VC_G, masterId, Integer.parseInt(scan.next()), Integer.parseInt(scan.next())));
			
			scan.next();
			scan.next();
			dTimes.add(new DwellTime(NativeKeyEvent.VC_H, masterId, Integer.parseInt(scan.next()), Integer.parseInt(scan.next())));
			
			scan.next();
			scan.next();
			dTimes.add(new DwellTime(NativeKeyEvent.VC_I, masterId, Integer.parseInt(scan.next()), Integer.parseInt(scan.next())));
			
			scan.next();
			scan.next();
			dTimes.add(new DwellTime(NativeKeyEvent.VC_J, masterId, Integer.parseInt(scan.next()), Integer.parseInt(scan.next())));
			
			scan.next();
			scan.next();
			dTimes.add(new DwellTime(NativeKeyEvent.VC_K, masterId, Integer.parseInt(scan.next()), Integer.parseInt(scan.next())));
			
			scan.next();
			scan.next();
			dTimes.add(new DwellTime(NativeKeyEvent.VC_L, masterId, Integer.parseInt(scan.next()), Integer.parseInt(scan.next())));
			
			scan.next();
			scan.next();
			dTimes.add(new DwellTime(NativeKeyEvent.VC_M, masterId, Integer.parseInt(scan.next()), Integer.parseInt(scan.next())));
			
			scan.next();
			scan.next();
			dTimes.add(new DwellTime(NativeKeyEvent.VC_N, masterId, Integer.parseInt(scan.next()), Integer.parseInt(scan.next())));
			
			scan.next();
			scan.next();
			dTimes.add(new DwellTime(NativeKeyEvent.VC_O, masterId, Integer.parseInt(scan.next()), Integer.parseInt(scan.next())));
			
			scan.next();
			scan.next();
			dTimes.add(new DwellTime(NativeKeyEvent.VC_P, masterId, Integer.parseInt(scan.next()), Integer.parseInt(scan.next())));
			
			scan.next();
			scan.next();
			dTimes.add(new DwellTime(NativeKeyEvent.VC_Q, masterId, Integer.parseInt(scan.next()), Integer.parseInt(scan.next())));
			
			scan.next();
			scan.next();
			dTimes.add(new DwellTime(NativeKeyEvent.VC_R, masterId, Integer.parseInt(scan.next()), Integer.parseInt(scan.next())));
			
			scan.next();
			scan.next();
			dTimes.add(new DwellTime(NativeKeyEvent.VC_S, masterId, Integer.parseInt(scan.next()), Integer.parseInt(scan.next())));
			
			scan.next();
			scan.next();
			dTimes.add(new DwellTime(NativeKeyEvent.VC_T, masterId, Integer.parseInt(scan.next()), Integer.parseInt(scan.next())));
			
			scan.next();
			scan.next();
			dTimes.add(new DwellTime(NativeKeyEvent.VC_U, masterId, Integer.parseInt(scan.next()), Integer.parseInt(scan.next())));
			
			scan.next();
			scan.next();
			dTimes.add(new DwellTime(NativeKeyEvent.VC_V, masterId, Integer.parseInt(scan.next()), Integer.parseInt(scan.next())));
			
			scan.next();
			scan.next();
			dTimes.add(new DwellTime(NativeKeyEvent.VC_W, masterId, Integer.parseInt(scan.next()), Integer.parseInt(scan.next())));
			
			scan.next();
			scan.next();
			dTimes.add(new DwellTime(NativeKeyEvent.VC_X, masterId, Integer.parseInt(scan.next()), Integer.parseInt(scan.next())));
			
			scan.next();
			scan.next();
			dTimes.add(new DwellTime(NativeKeyEvent.VC_Y, masterId, Integer.parseInt(scan.next()), Integer.parseInt(scan.next())));
			
			scan.next();
			scan.next();
			dTimes.add(new DwellTime(NativeKeyEvent.VC_Z, masterId, Integer.parseInt(scan.next()), Integer.parseInt(scan.next())));
			
			scan.next();
			scan.next();
			dTimes.add(new DwellTime(NativeKeyEvent.VC_SPACE, masterId, Integer.parseInt(scan.next()), Integer.parseInt(scan.next())));
			
			
			scan.close();
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	public void pressed(int id, int time){
		//loop through array, look for dwellTime that has the id, call .recieve(time)
		for(int i = 0; i < dTimes.size(); i += 1){
			if(dTimes.get(i).getId() == id){
				dTimes.get(i).receive(time);
				i = dTimes.size();
			}
		}
	}
	
	public boolean write(String user){
		//loop through the array, everything is going to call .write()
		PrintWriter write;
		File file;
		switch(masterId){
			case(NativeKeyEvent.VC_A):
				file = new File(user + "_A");
				break;
			case(NativeKeyEvent.VC_B):
				file = new File(user + "_B");
				break;
			case(NativeKeyEvent.VC_C):
				file = new File(user + "_C");
				break;
			case(NativeKeyEvent.VC_D):
				file = new File(user + "_D");
				break;
			case(NativeKeyEvent.VC_E):
				file = new File(user + "_E");
				break;
			case(NativeKeyEvent.VC_F):
				file = new File(user + "_F");
				break;
			case(NativeKeyEvent.VC_G):
				file = new File(user + "_G");
				break;
			case(NativeKeyEvent.VC_H):
				file = new File(user + "_H");
				break;
			case(NativeKeyEvent.VC_I):
				file = new File(user + "_I");
				break;
			case(NativeKeyEvent.VC_J):
				file = new File(user + "_J");
				break;
			case(NativeKeyEvent.VC_K):
				file = new File(user + "_K");
				break;
			case(NativeKeyEvent.VC_L):
				file = new File(user + "_L");
				break;
			case(NativeKeyEvent.VC_M):
				file = new File(user + "_M");
				break;
			case(NativeKeyEvent.VC_N):
				file = new File(user + "_N");
				break;
			case(NativeKeyEvent.VC_O):
				file = new File(user + "_O");
				break;
			case(NativeKeyEvent.VC_P):
				file = new File(user + "_P");
				break;
			case(NativeKeyEvent.VC_Q):
				file = new File(user + "_Q");
				break;
			case(NativeKeyEvent.VC_R):
				file = new File(user + "_R");
				break;
			case(NativeKeyEvent.VC_S):
				file = new File(user + "_S");
				break;
			case(NativeKeyEvent.VC_T):
				file = new File(user + "_T");
				break;
			case(NativeKeyEvent.VC_U):
				file = new File(user + "_U");
				break;
			case(NativeKeyEvent.VC_V):
				file = new File(user + "_V");
				break;
			case(NativeKeyEvent.VC_W):
				file = new File(user + "_W");
				break;
			case(NativeKeyEvent.VC_X):
				file = new File(user + "_X");
				break;
			case(NativeKeyEvent.VC_Y):
				file = new File(user + "_Y");
				break;
			case(NativeKeyEvent.VC_Z):
				file = new File(user + "_Z");
				break;
			case(NativeKeyEvent.VC_SPACE):
				file = new File(user + "_SP");
				break;
			case(NativeKeyEvent.VC_ENTER):
				file = new File(user + "_Enter");
				break;
			case(NativeKeyEvent.VC_COMMA):
				file = new File(user + "_Comma");
				break;
			case(NativeKeyEvent.VC_PERIOD):
				file = new File(user + "_Period");
				break;
			case(NativeKeyEvent.VC_SHIFT_L):
				file = new File(user + "_Shift_L");
				break;
			case(NativeKeyEvent.VC_SHIFT_R):
				file = new File(user + "_Shift_R");
				break;
			case(NativeKeyEvent.VC_SEMICOLON):
				file = new File(user + "_Semicolon");
				break;
			case(NativeKeyEvent.VC_BACKSPACE):
				file = new File(user + "_Backspace");
				break;
			case(NativeKeyEvent.VC_0):
				file = new File(user + "_0");
				break;
			case(NativeKeyEvent.VC_1):
				file = new File(user + "_1");
				break;
			case(NativeKeyEvent.VC_2):
				file = new File(user + "_2");
				break;
			case(NativeKeyEvent.VC_3):
				file = new File(user + "_3");
				break;
			case(NativeKeyEvent.VC_4):
				file = new File(user + "_4");
				break;
			case(NativeKeyEvent.VC_5):
				file = new File(user + "_5");
				break;
			case(NativeKeyEvent.VC_6):
				file = new File(user + "_6");
				break;
			case(NativeKeyEvent.VC_7):
				file = new File(user + "_7");
				break;
			case(NativeKeyEvent.VC_8):
				file = new File(user + "_8");
				break;
			case(NativeKeyEvent.VC_9):
				file = new File(user + "_9");
				break;
			default:
				return false;
		}
		try
		{
			write = new PrintWriter(file);
			for(int i = 0; i < dTimes.size(); i += 1){
				write.println(dTimes.get(i).write());
		
			}
			write.close();
		} catch (FileNotFoundException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		return true;
	}
	
	public int validate(int ID, int time)
	{
		for(int i = 0; i < dTimes.size(); i++)
		{
			if(ID == dTimes.get(i).getId())
			{
				return dTimes.get(i).validate(time);
			}
		}
		return 2;
	}
	
	//-1 = not recording key
	public int getTime(int id){
		for(int i = 0; i < dTimes.size(); i += 1){
			if(dTimes.get(i).getId() == id){
				return dTimes.get(i).getTime();
			}
		}
		return - 1;
	}
	
	public ArrayList<String> writeBig(){
		ArrayList<String> lines= new ArrayList<String>();
		for(int i = 0; i < dTimes.size(); i += 1){
			lines.add(dTimes.get(i).write());
		}
		return lines;
	}
	
}
