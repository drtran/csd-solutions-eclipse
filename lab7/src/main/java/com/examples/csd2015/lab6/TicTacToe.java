package com.examples.csd2015.lab6;

public class TicTacToe {
	private char[][] table = new char[3][3];

	public boolean setCross(int x, int y){
		table[x][y] = 'x';
		return true;
	}

	public boolean isCross(int x, int y) {
		return table[x][y] == 'x';
	}
}
