Feature: Start Game
![Gamer](images/gamerErin.png)

Start a game for a given Character


Scenario Outline: Start Game
    Given a Character with name <characterName>
    When Player starts the Game
    Then Game creates a Map and sets initial position and set them as part of the Character 
    Examples:
        | characterName | characterNameOutput |
        | "" | ""       |
        | Geo | Geo, move count zero, New Map and Initial Position   0,0 |
        | Roy | Roy, move count zero, New Map and Initial Position   0,0 | 

