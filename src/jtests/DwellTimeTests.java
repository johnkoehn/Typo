package jtests;

import static org.junit.Assert.*;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.junit.Before;
import org.junit.Test;

import typo.DwellTime;

public class DwellTimeTests
{
	private DwellTime dTime;
	
	@Before
	public void init()
	{
		dTime = new DwellTime(NativeKeyEvent.VC_A, NativeKeyEvent.VC_J);
	}
	
	@Test
	public void test1()
	{
		assertEquals(dTime.getTime(), 0);
		dTime.receive(60);
		assertEquals(dTime.getTime(), 60);
		dTime.receive(50);
		assertEquals(dTime.getTime(), 55);
		dTime.receive(85);
		assertEquals(dTime.getTime(), 65);
		dTime.receive(50);
		dTime.receive(50);
		dTime.receive(55);;
		assertEquals(dTime.getTime(), 58);
		
		assertEquals(dTime.write(), "J,A,58");
	}

}
