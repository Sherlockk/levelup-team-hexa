package com.levelup.forestsandmonsters.features;

import static org.junit.Assert.assertEquals;

import com.levelup.forestsandmonsters.GameController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CharacterSteps {
    GameController gc = new GameController();
    String playerName;

    @When("Player Ends the Game")
    public void player_ends_the_game() {
        // Write code here that turns the phrase above into concrete actions
        gc.getStatus();
    }
    
    @Then("the Game displays the {string}")
    public void the_game_displays_the(String string) {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        assertEquals("", "1");
    }
    
    @Then("the current positionX {int}")
    public void the_current_position_x(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        // throw new io.cucumber.java.PendingException();
        assertEquals(1, 2);
    }
    
    @Then("the current positionY {int}")
    public void the_current_position_y(Integer int1) {
        // Write code here that turns the phrase above into concrete actions

        assertEquals(1, 2);
    }
    
    @Then("the move count {int}")
    public void the_move_count(Integer int1) {
        // Write code here that turns the phrase above into concrete actions

        assertEquals(1, 2);
    }

}
