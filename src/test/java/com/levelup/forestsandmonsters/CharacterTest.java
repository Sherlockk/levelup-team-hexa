package com.levelup.forestsandmonsters;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.Executable;

import org.junit.Test;

import com.levelup.forestsandmonsters.Character;
import java.awt.Point;

public class CharacterTest {
   
    @Test
    public void moveTest() {
        Map map = new Map();
        Point point = new Point(0,0);
        Character character = new Character("Test");
        character.init(map, point);
        int initMoves = character.getNumOfMoves();


        assertEquals(initMoves, 1);
    }

    @Test
    public void customInitializationWorks() {

        try {
        Map map = new Map(5,9);
        assertEquals(5, map.getWidth());
        assertEquals(9, map.getHeight());
        } catch (Exception e) {

        }
    }

    @Test
    public void initializeNegativeWidthBlocked() {
        assertThrows(Exception.class, () -> {
            Map map = new Map(-1, 10);   ;
        });
    }

    @Test
    public void initializeNegativeHeightBlocked() {

        try {
        Map map = new Map(1, -10);
        
        assertNull(map, "Unable to create map with negative dimension");
        } catch (Exception e) {}
    }
}
