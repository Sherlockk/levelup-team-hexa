package com.levelup.forestsandmonsters;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.Executable;

import org.junit.Test;

import com.levelup.forestsandmonsters.cli.LevelUpCharacter;

public class CharacterTest {
   
    @Test
    public void moveTest() {
        // GameController gc = new GameController();
        // gc.createCharacter("Test");
        // LevelUpCharacter character =  new LevelUpCharacter("Test");
        // Map map = new Map();
        // map.
        assertEquals(0, 1);
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
