package com.levelup.forestsandmonsters;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

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


    //Make sure we have initialized all the start values
    public void startGameTest(){

        GameController testObj = new GameController();
        testObj.createCharacter("Roy");
        testObj.startGame();
        assertEquals(testObj.getStatus().characterName, "Roy");
        assertEquals(testObj.getStatus().currentPosition.x, 0);
        assertEquals(testObj.getStatus().currentPosition.y, 0);
        assertEquals(testObj.getTotalPositions(), 0);
        //assertEquals(testObj.getStatus().currentPosition.x, 0);
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
