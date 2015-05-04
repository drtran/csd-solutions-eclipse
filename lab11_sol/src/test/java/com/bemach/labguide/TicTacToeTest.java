package com.bemach.labguide;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

/**
 * Created by ktran on 4/27/2015.
 */
public class TicTacToeTest {

    private TicTacToe board;

    @Before
    public void setUp() {
        board = new TicTacToe();
    }

    @Test
    public void shouldCreateBoard() {
        assertNotNull("Cannot create a board.", board);
    }

    @Test
    public void shouldSetACircleAtACoordinate() {
        board.setCircle(1,1);
        assertTrue("(x,y) does not contain a circle.", board.isCircleAt(1, 1));
    }

    @Test
    public void shouldSetACrossAtACoordinate() {
        board.setCross(2, 2);
        assertTrue("(x,y) does not contain a cross.", board.isCrossAt(2, 2));
    }

    @Test
    public void shouldBeDefautAsBlank() {
        assertTrue("(x,y) does not contain blank as default.", board.isBlankAt(3, 3));
    }

    @Test
    public void shouldNotSetWhenOccupied() {
        board.setCircle(1,1);
        board.setCross(1, 1);
        assertTrue("(x,y) does not contain a circle.", board.isCircleAt(1, 1));
    }

    @Test
    public void shouldBeOccupiedWhenSet() {
        board.setCross(1,1);
        assertTrue("(x,y) does not contain a circle.", board.isOccupiedAt(1, 1));
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenOutOfBoundOnSetCircle() {
        board.setCircle(4, 4);
    }

    @Test (expected = ArrayIndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenOutOfBoundOnSetCross() {
        board.setCircle(0,0);
    }
}
