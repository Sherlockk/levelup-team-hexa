Feature: Get Character Status
![Gamer](images/gamerErin.png)

Get the status for a given Character


Scenario Outline: Get Character Status
    Given a Character with name <characterName>
    When Player Ends the Game
    Then the Game displays the <characterNameOutput>
    And the current positionX <currentPositionX> 
    And the current positionY <currentPositionY>
    And the move count <moveCount>
    Examples:
        | characterName | characterNameOutput | currentPositionX | currentPositionY | moveCount |
        | "Geo" | "Geo" | 0 | 0 | 0 |
        | "Roy" | "Roy" | 3 | 2 | 5 | 

