package com.bemach.labguide.lab2;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class TicTacToeTest {
	
	@Test
	public void shouldGetInstance() {
		TicTacToe game = new TicTacToe();
		assertNotNull("Game cannot be created!", game);
	}

	
}
