package com.levelup.forestsandmonsters;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.awt.Point;

import org.junit.Test;

public class GameControllerTest {
    @Test
    public void InitializationCreatesResults() {
        GameController testObj = new GameController();
        assertNotNull(testObj.status);
    }

    // creates a character with the name Roy
    @Test
    public void createCharacterRoyTest() {
        String CHARACTER_NAME = "Roy";
        assertCharacterName(CHARACTER_NAME);
    }
    // creates a character with a digit
    @Test
    public void createCharacterWithDigitTest() {
        String CHARACTER_NAME = "Roy1";
        assertCharacterName(CHARACTER_NAME);
    }
    // creates a character with no name
    @Test
    public void createCharacterNoNameTest() {
        assertCharacterName("");
    }
    // creates a character with special character
    @Test
    public void createCharacterWithSpecialCharTest() {
        String CHARACTER_NAME = "R3n3!";
        assertCharacterName(CHARACTER_NAME);
    }
    // creates a character with spaces
    @Test
    public void createCharacterWithSpaceTest() {
        String CHARACTER_NAME = "Joe Biden";
        assertCharacterName(CHARACTER_NAME);
    }
    // creates an international name
    @Test
    public void createCharacterInternationalTest() {
        String CHARACTER_NAME = "Rene";
        assertCharacterName(CHARACTER_NAME);
    }

    /*******************    move() tests           *************** */
    // Test valid move north
    @Test
    public void validMoveNorth(){
        GameController testObj = new GameController();
        testObj.createCharacter("Ted");
        testObj.startGame();
        testObj.setCharacterPosition(new Point(3,4));
        int startingMoveCount = 45;
        testObj.getStatus().moveCount = startingMoveCount;
        testObj.move(GameController.DIRECTION.NORTH);
        assertEquals(testObj.getStatus().currentPosition.x, 3);
        assertEquals(testObj.getStatus().currentPosition.y, 5);
        assertEquals(testObj.getStatus().moveCount, startingMoveCount+1);

    }
    // Test valid move south
    @Test
    public void validMoveSouth(){
        GameController testObj = new GameController();
        testObj.createCharacter("Ted");
        testObj.startGame();
        testObj.setCharacterPosition(new Point(3,4));
        int startingMoveCount = 67;
        testObj.getStatus().moveCount = startingMoveCount;
        testObj.move(GameController.DIRECTION.SOUTH);
        assertEquals(testObj.getStatus().currentPosition.x, 3);
        assertEquals(testObj.getStatus().currentPosition.y, 3);
        assertEquals(testObj.getStatus().moveCount, startingMoveCount+1);

    }
    // Test valid move east
    @Test
    public void validMoveEast(){
        GameController testObj = new GameController();
        testObj.createCharacter("Ted");
        testObj.startGame();
        testObj.setCharacterPosition(new Point(3,4));
        int startingMoveCount = 213;
        testObj.getStatus().moveCount = startingMoveCount;
        testObj.move(GameController.DIRECTION.EAST);
        assertEquals(testObj.getStatus().currentPosition.x, 4);
        assertEquals(testObj.getStatus().currentPosition.y, 4);
        assertEquals(testObj.getStatus().moveCount, startingMoveCount+1);

    }
    // Test valid move west
    @Test
    public void validMoveWest(){
        GameController testObj = new GameController();
        testObj.createCharacter("Ted");
        testObj.startGame();
        testObj.setCharacterPosition(new Point(3,4));
        int startingMoveCount = 51;
        testObj.getStatus().moveCount = startingMoveCount;
        testObj.move(GameController.DIRECTION.WEST);
        assertEquals(testObj.getStatus().currentPosition.x, 2);
        assertEquals(testObj.getStatus().currentPosition.y, 4);
        assertEquals(testObj.getStatus().moveCount, startingMoveCount+1);

    }
    // Test invalid move north
    @Test
    public void invalidMoveNorth(){
        GameController testObj = new GameController();
        testObj.createCharacter("Ted");
        testObj.startGame();
        testObj.setCharacterPosition(new Point(3,9));
        int startingMoveCount = 31;
        testObj.getStatus().moveCount = startingMoveCount;
        testObj.move(GameController.DIRECTION.NORTH);
        assertEquals(testObj.getStatus().currentPosition.x, 3);
        assertEquals(testObj.getStatus().currentPosition.y, 9);
        assertEquals(testObj.getStatus().moveCount, startingMoveCount+1);
    }
    // Test invalid move south
    @Test
    public void invalidMoveSouth(){
        GameController testObj = new GameController();
        testObj.createCharacter("Ted");
        testObj.startGame();
        testObj.setCharacterPosition(new Point(7,0));
        int startingMoveCount = 99;
        testObj.getStatus().moveCount = startingMoveCount;
        testObj.move(GameController.DIRECTION.SOUTH);
        assertEquals(testObj.getStatus().currentPosition.x, 7);
        assertEquals(testObj.getStatus().currentPosition.y, 0);
        assertEquals(testObj.getStatus().moveCount, startingMoveCount+1);
    }
    // Test invalid move east
    @Test
    public void invalidMoveEast(){
        GameController testObj = new GameController();
        testObj.createCharacter("Ted");
        testObj.startGame();
        testObj.setCharacterPosition(new Point(5,9));
        int startingMoveCount = 31;
        testObj.getStatus().moveCount = startingMoveCount;
        testObj.move(GameController.DIRECTION.EAST);
        assertEquals(testObj.getStatus().currentPosition.x, 5);
        assertEquals(testObj.getStatus().currentPosition.y, 9);
        assertEquals(testObj.getStatus().moveCount, startingMoveCount+1);
    }
    // Test invalid move west
    @Test
    public void invalidMoveWest(){
        GameController testObj = new GameController();
        testObj.createCharacter("Ted");
        testObj.startGame();
        testObj.setCharacterPosition(new Point(0,2));
        int startingMoveCount = 31;
        testObj.getStatus().moveCount = startingMoveCount;
        testObj.move(GameController.DIRECTION.WEST);
        assertEquals(testObj.getStatus().currentPosition.x, 0);
        assertEquals(testObj.getStatus().currentPosition.y, 2);
        assertEquals(testObj.getStatus().moveCount, startingMoveCount+1);
    }

    /*******************    startGameTest() tests           *************** */
    @Test
    //Make sure we have initialized all the start values
    public void startGameTest(){

        GameController testObj = new GameController();
        testObj.createCharacter("Roy");
        testObj.startGame();
        assertEquals(testObj.getStatus().characterName, "Roy");
        assertEquals(testObj.getStatus().currentPosition.x, 0);
        assertEquals(testObj.getStatus().currentPosition.y, 0);
        assertEquals(testObj.getTotalPositions(), 100);
        assertEquals(testObj.getStatus().moveCount, 0);
    }

    private void assertCharacterName(String CHARACTER_NAME) {
        GameController testObj = new GameController();
        testObj.createCharacter(CHARACTER_NAME);
        assertNotNull(testObj.getStatus().characterName);
        if (CHARACTER_NAME.equals("")) {
            assertEquals(GameController.DEFAULT_CHARACTER_NAME, testObj.getStatus().characterName);
        } else {
            assertEquals(CHARACTER_NAME, testObj.getStatus().characterName);
        }
    }
}
