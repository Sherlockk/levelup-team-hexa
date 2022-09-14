Feature: Start Game
![Gamer](images/gamerErin.png)

Start a game for a given Character


Scenario Outline: Start Game
    Given a Character with name <characterName>
    When Player starts the Game
    Then the Game set the map size to <mapSize>
    And the initial position is <initialPositionX> 
    And <initialPositionY>
    And the move count is <initialMoveCount>
    Examples:
        | characterName | characterNameOutput | mapSize | initialPositionX | initialPositionY | initialMoveCount
        | "" | "" | null | null | null | null
        | "Geo" | "Geo" | 100 | 0 | 0 | 0
        | "Roy" | "Roy" | 100 | 0 | 0 | 0 

