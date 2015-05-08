package com.examples.csd2015.lab6;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TicTacToeTest {
	
	private TicTacToe game;

	@Before
	public void setUp() {
		game = new TicTacToe();
	}
	
	@Test 
	public void shouldCreateInstance() {
		assertNotNull("Game is NULL", game);
	}
	@Test
	public void shouldSetCrossAtCoordinate() {
		
		boolean actualResult = game.setCross(1, 1);
		assertTrue("Failed to set a cross", actualResult);
	}
	
	
	@Test
	public void shouldGetCrossAfterSettingAtXY() {
		
		game.setCross(1, 1);
		assertTrue("Cross is not there.", game.isCross(1,1));
	}
}
