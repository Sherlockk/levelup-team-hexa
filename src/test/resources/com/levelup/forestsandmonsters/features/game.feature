Feature: Start Game
![Gamer](images/gamerErin.png)

Start a game for a given Character


Scenario Outline: Start Game
    Given a Character
    When Player starts the Game
    Then Game creates a Map and sets initial position and set them as part of the Character 
    Examples:
        | Character | Character Output |
        | DNE       | DNE        |
        | Character with Name  "Geo"        | Character with Name Geo, move count zero, New Map and Initial Position   0,0    |
        | Character with Name "Roy".        | Character with Name Roy, move count zero, New Map and Initial Position   0,0  

