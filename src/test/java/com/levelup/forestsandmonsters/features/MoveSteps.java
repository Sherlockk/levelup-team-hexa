package com.levelup.forestsandmonsters.features;

import com.levelup.forestsandmonsters.GameController;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.awt.Point;

public class MoveSteps {

    GameController gc;
    int startX, startY, endX, endY;
    GameController.DIRECTION direction;
    Point currentPosition;
    
    @Given("the character starts at position with XCoordinates {int}")
    public void givenTheCharacterStartsAtX (int startX) {
        this.startX = startX;
    }

    @Given("the character starts at position with YCoordinates {int}")
    public void givenTheCharacterStartsAtY (int startY) {
        this.startY = startY;
    }

    @Given ("the plyer choses to move in direction {word}")
    public void givenPlayerChoosesDirection (String direction)
    {
        this.direction=GameController.DIRECTION.valueOf(direction);        
    }


    @When("the character moves")
    public void theCharactersMoves() {
        gc = new GameController();
        gc.setCharacterPosition(new Point(this.startX,this.startY));
        gc.move(this.direction);
        GameController.GameStatus status = gc.getStatus();
        this.currentPosition = status.currentPosition;
    }

    @Then("the character is now at position with XCoordinates {int}")
    public void checkXCoordinates(int endX) {
        assertNotNull("Expected position not null", this.currentPosition);
        assertEquals(endX, this.currentPosition.x);
    }


    @Then("the character is now at position with YCoordinates {int}")
    public void checkYCoordinates(int endY) {
        assertNotNull("Expected position not null", this.currentPosition);
        assertEquals(endY, this.currentPosition.y);
    }
}
