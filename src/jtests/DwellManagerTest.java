package jtests;

import static org.junit.Assert.assertEquals;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.junit.Test;

import typo.DwellTimeManager;

public class DwellManagerTest
{

	
	private DwellTimeManager dmanager = new DwellTimeManager(NativeKeyEvent.VC_A);
	@Test
	public void test()
	{
		dmanager.pressed(NativeKeyEvent.VC_A, 50);
		dmanager.pressed(NativeKeyEvent.VC_P, 50);
		
		dmanager.pressed(NativeKeyEvent.VC_A, 50);
		dmanager.pressed(NativeKeyEvent.VC_P, 50);
		
		dmanager.pressed(NativeKeyEvent.VC_A, 50);
		dmanager.pressed(NativeKeyEvent.VC_P, 50);
		
		dmanager.pressed(NativeKeyEvent.VC_A, 50);
		dmanager.pressed(NativeKeyEvent.VC_P, 50);
		
		assertEquals(dmanager.getTime(NativeKeyEvent.VC_A), 50);
	}
	
	@Test
	public void writeFileTest(){
		dmanager.pressed(NativeKeyEvent.VC_D, 50);
		dmanager.pressed(NativeKeyEvent.VC_E, 50);
		
		dmanager.pressed(NativeKeyEvent.VC_F, 50);
		dmanager.pressed(NativeKeyEvent.VC_A, 50);
		
		dmanager.pressed(NativeKeyEvent.VC_SPACE, 50);
		dmanager.pressed(NativeKeyEvent.VC_J, 50);
		
		dmanager.pressed(NativeKeyEvent.VC_D, 100);
//		dmanager.pressed(NativeKeyEvent.VC_D, 100);
		
		dmanager.write("Feldman");
		
		
	}

}
