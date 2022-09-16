package com.levelup.forestsandmonsters;

import java.awt.Point;

public class GameController { 
    // TODO: If your stakeholder wants to call this CHARACTER, change var name for
    // low representational gap
    static final String DEFAULT_CHARACTER_NAME = "Character";

    public class GameStatus {
        // TODO: Add other status data
        public String characterName = DEFAULT_CHARACTER_NAME;
        public Point currentPosition = null;
        public int moveCount = 0;

        public void setCharacterPosition (Point coordinates) {
            this.currentPosition = coordinates;
        }
    }

    GameStatus status;
    Map map;
    Character character;

    public GameController() {
        status = new GameStatus();
    }

    public static enum DIRECTION {
        NORTH, SOUTH, EAST, WEST
    }

    // Pre-implemented to demonstrate ATDD
    // TODO: Update this if it does not match your design
    public void createCharacter(String name) {
        if (name != null && !name.equals("")) {
            status.characterName = name;
        } else {
            status.characterName = DEFAULT_CHARACTER_NAME;
        }
        this.character = new Character(status.characterName);
    }

    public void startGame() {
        // TODO: Implement startGame - Should probably create tiles and put the character
        // on them?
        // TODO: Should also update the game results?
        this.map = new Map();
        Point position = new Point(0,0);
        this.character.init(map, position);
        status.currentPosition = position;
        
    }

    public GameStatus getStatus() {
        return this.status;
    }

    public void move(DIRECTION directionToMove) throws GameNotStartedException {
        this.character.move(directionToMove);
        this.status.currentPosition = this.character.getCurrentPosition();
        this.status.moveCount++;
    }

    public void setCharacterPosition(Point coordinate) {
        // TODO
    }
    public int getTotalPositions() {
        if (this.map != null) {
            return (this.map.getHeight() +1) * (this.map.getWidth() + 1);
        } else {
            return -1;
        }
    }
    public int getMoveCount() {
        return getStatus().moveCount;
    }
    public Character getCharacter() {
        return this.character;
    }
}
