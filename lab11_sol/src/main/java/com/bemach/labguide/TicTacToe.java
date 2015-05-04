package com.bemach.labguide;

/**
 * Created by ktran on 4/27/2015.
 */
public class TicTacToe {
    private char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};

    public void setCircle(int x, int y) {
        setBoard(x, y, 'o');
    }

    private void setBoard(int x, int y, char value) {
        if (!isOccupied(x, y)) {
            board[x - 1][y - 1] = value;
        }
    }

    private boolean isOccupied(int x, int y) {
        return board[x-1][y-1] != ' ';
    }

    public boolean isCircleAt(int x, int y) {
        return checkBoard(x, y, 'o');
    }

    private boolean checkBoard(int x, int y, char value) {
        return board[x-1][y-1] == value;
    }

    public boolean isCrossAt(int x, int y) {
        return checkBoard(x, y, 'x');
    }

    public void setCross(int x, int y) {
        setBoard(x, y, 'x');
    }

    public boolean isBlankAt(int x, int y) {
        return checkBoard(x, y, ' ');
    }

    public boolean isOccupiedAt(int x, int y) {
        return isOccupied(x, y);
    }
}
