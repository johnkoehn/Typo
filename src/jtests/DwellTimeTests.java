package jtests;

import static org.junit.Assert.*;

import org.jnativehook.keyboard.NativeKeyEvent;
import org.junit.Before;
import org.junit.Test;

import typo.DwellTime;

public class DwellTimeTests
{
	private DwellTime dwellTime;
	
	@Before
	public void init()
	{
		dwellTime = new DwellTime(NativeKeyEvent.VC_A, NativeKeyEvent.VC_J);
	}
	
	@Test
	public void test1()
	{
		assertEquals(0, 0);
	}

}
