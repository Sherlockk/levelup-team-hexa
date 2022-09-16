package com.levelup.forestsandmonsters;

import java.awt.Point;

public class Character {
    private String name;
    private int numOfMoves;
    private Point currentPosition;
    private Map map;

    public Character(String pName) {
        name = pName;
    }

    public String getName() {
        return name;
    }

    public int getNumOfMoves() {
        return numOfMoves;
    }

    public void init(Map pMap, Point position) {
        currentPosition = position;
        map = pMap;
    }

    public void move(GameController.DIRECTION direction) throws GameNotStartedException {
        if (map != null && currentPosition != null) {
           currentPosition =  map.calculatePosition(currentPosition, direction);
           numOfMoves++;
        } else {
            throw new GameNotStartedException("Game not started Character");
        }
    }

}
