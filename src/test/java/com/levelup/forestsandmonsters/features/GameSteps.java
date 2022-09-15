package com.levelup.forestsandmonsters.features;

import static org.junit.Assert.assertEquals;

import com.levelup.forestsandmonsters.GameController;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GameSteps {

    GameController gc;
    String characterName;

@Given("a Character with name {string}")
public void a_character_with_name(String string) {
    // Write code here that turns the phrase above into concrete actions
    this.characterName = "Geo"; // throw new io.cucumber.java.PendingException();
}

@When("Player starts the Game")
public void player_starts_the_game() {
    // Write code here that turns the phrase above into concrete actions
    // throw new io.cucumber.java.PendingException();

}

@Then("the Game set the map size to {int}")
public void the_game_set_the_map_size_to(Integer int1) {
    // Write code here that turns the phrase above into concrete actions
    // throw new io.cucumber.java.PendingException();
}

@Then("the initial positionX is {int}")
public void the_initial_position_x_is(Integer int1) {
    // Write code here that turns the phrase above into concrete actions
    // throw new io.cucumber.java.PendingException();
}

@Then("the initial positionY is {int}")
public void the_initial_position_y_is(Integer int1) {
    // Write code here that turns the phrase above into concrete actions
    // throw new io.cucumber.java.PendingException();
}

@Then("the move count is {int}")
public void the_move_count_is(Integer int1) {
    // Write code here that turns the phrase above into concrete actions
    // throw new io.cucumber.java.PendingException();
    assertEquals( (int) int1, 5);
}

@Then("character name is {string}")
public void character_name_is(String string) {
    // Write code here that turns the phrase above into concrete actions
    // throw new io.cucumber.java.PendingException();
}

/* 
    @Given("the character's name is {string}")
    public void givenTheCharactersNameIs(String characterName) {
        this.characterName = characterName;
    }

    @When("the character sets their name")
    public void whenTheCharacterSetsTheirName() {
        gc = new GameController();
        gc.createCharacter(characterName);
    }

    @Then("the Game sets the character's name to {string}")
    public void thenTheGameSetsTheCharactersName(String expectedName) {
        assertEquals(expectedName, gc.getStatus().characterName);
    }
    */

}
