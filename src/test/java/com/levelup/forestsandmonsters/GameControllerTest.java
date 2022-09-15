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

    /*******************    createCharacter() tests           *************** */
    // creates a character with the name Roy
    @Test
    public void createCharacterRoyTest() {
        String characterName = "Roy";
        assertCharacterName(characterName);
    }
    // creates a character with a digit
    @Test
    public void createCharacterWithDigitTest() {
        String characterName = "Roy1";
        assertCharacterName(characterName);
    }
    // creates a character with no name
    @Test
    public void createCharacterNoNameTest() {
        assertCharacterName("");
    }
    // creates a character with special character
    @Test
    public void createCharacterWithSpecialCharTest() {
        String characterName = "R3n3!";
        assertCharacterName(characterName);
    }
    // creates a character with spaces
    @Test
    public void createCharacterWithSpaceTest() {
        String characterName = "Joe Biden";
        assertCharacterName(characterName);
    }
    // creates an international name
    @Test
    public void createCharacterInternationalTest() {
        String characterName = "Rená";
        assertCharacterName(characterName);
    }

    /*******************    move() tests           *************** */
    // Test valid move north
    @Test
    public void validMoveNorth(){
        int startingMoveCount = 45;
        GameController testObj = setupGameControllerForMove(startingMoveCount, "Ted", new Point(3,4));
        testObj.move(GameController.DIRECTION.NORTH);
        assertEquals(testObj.getStatus().currentPosition.x, 3);
        assertEquals(testObj.getStatus().currentPosition.y, 5);
        assertEquals(testObj.getStatus().moveCount, startingMoveCount+1);

    }

    private GameController setupGameControllerForMove(int startingMoveCount, String characterName, Point startingPosition) {
        GameController testObj = new GameController();
        testObj.createCharacter(characterName);
        testObj.startGame();
        testObj.setCharacterPosition(startingPosition);
        testObj.getStatus().moveCount = startingMoveCount;
        return testObj;
    }
    // Test valid move south
    @Test
    public void validMoveSouth(){
        int startingMoveCount = 67;
        GameController testObj = setupGameControllerForMove(startingMoveCount, "Ted Turner", new Point(3,4));
        testObj.move(GameController.DIRECTION.SOUTH);
        assertEquals(testObj.getStatus().currentPosition.x, 3);
        assertEquals(testObj.getStatus().currentPosition.y, 3);
        assertEquals(testObj.getStatus().moveCount, startingMoveCount+1);

    }
    // Test valid move east
    @Test
    public void validMoveEast(){
        int startingMoveCount = 213;
        GameController testObj = setupGameControllerForMove(startingMoveCount, "Ted Turner", new Point(3,4));

        testObj.move(GameController.DIRECTION.EAST);
        assertEquals(testObj.getStatus().currentPosition.x, 4);
        assertEquals(testObj.getStatus().currentPosition.y, 4);
        assertEquals(testObj.getStatus().moveCount, startingMoveCount+1);

    }
    // Test valid move west
    @Test
    public void validMoveWest(){
        int startingMoveCount = 51;
        GameController testObj = setupGameControllerForMove(startingMoveCount, "Ted Turner", new Point(3,4));
        testObj.move(GameController.DIRECTION.WEST);
        assertEquals(testObj.getStatus().currentPosition.x, 2);
        assertEquals(testObj.getStatus().currentPosition.y, 4);
        assertEquals(testObj.getStatus().moveCount, startingMoveCount+1);

    }
    // Test invalid move north
    @Test
    public void invalidMoveNorth(){
        int startingMoveCount = 31;
        GameController testObj = setupGameControllerForMove(startingMoveCount, "Ted Turner", new Point(3,9));
        testObj.move(GameController.DIRECTION.NORTH);
        assertEquals(testObj.getStatus().currentPosition.x, 3);
        assertEquals(testObj.getStatus().currentPosition.y, 9);
        assertEquals(testObj.getStatus().moveCount, startingMoveCount+1);
    }
    // Test invalid move south
    @Test
    public void invalidMoveSouth(){
        int startingMoveCount = 99;
        GameController testObj = setupGameControllerForMove(startingMoveCount, "Ted Turner", new Point(7,0));
        testObj.move(GameController.DIRECTION.SOUTH);
        assertEquals(testObj.getStatus().currentPosition.x, 7);
        assertEquals(testObj.getStatus().currentPosition.y, 0);
        assertEquals(testObj.getStatus().moveCount, startingMoveCount+1);
    }
    // Test invalid move east
    @Test
    public void invalidMoveEast(){
        int startingMoveCount = 31;
        GameController testObj = setupGameControllerForMove(startingMoveCount, "Ted Turner", new Point(5,9));
        testObj.move(GameController.DIRECTION.EAST);
        assertEquals(testObj.getStatus().currentPosition.x, 5);
        assertEquals(testObj.getStatus().currentPosition.y, 9);
        assertEquals(testObj.getStatus().moveCount, startingMoveCount+1);
    }
    // Test invalid move west
    @Test
    public void invalidMoveWest(){
        int startingMoveCount = 39;
        GameController testObj = setupGameControllerForMove(startingMoveCount, "Ted Turner", new Point(0,2));
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

    private void assertCharacterName(String characterName) {
        GameController testObj = new GameController();
        testObj.createCharacter(characterName);
        assertNotNull(testObj.getStatus().characterName);
        if (characterName.equals("")) {
            assertEquals(GameController.DEFAULT_CHARACTER_NAME, testObj.getStatus().characterName);
        } else {
            assertEquals(characterName, testObj.getStatus().characterName);
        }
    }
}
