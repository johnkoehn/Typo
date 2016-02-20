package typo;

import java.util.ArrayList;

import org.jnativehook.keyboard.NativeKeyEvent;

public class DwellTimeManager
{
	private ArrayList<DwellTime> dTimes;
	
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
	
	public void write(){
		//loop through the array, everything is going to call .write()
		for(int i = 0; i < dTimes.size(); i += 1){
			dTimes.get(i).write();
		}
	}
	
	public int getTime(int id){
		for(int i = 0; i < dTimes.size(); i += 1){
			if(dTimes.get(i).getId() == id){
				return dTimes.get(i).getTime();
			}
		}
		return - 1;
	}
	
}
