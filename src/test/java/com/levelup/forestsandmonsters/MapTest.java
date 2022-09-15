package com.levelup.forestsandmonsters;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.lang.reflect.Executable;
import java.awt.Point;

import org.junit.Test;

public class MapTest {
   
    @Test
    public void defaultInitializationWorks() {
        Map map = new Map();
        assertEquals(9, map.getWidth());
        assertEquals(9, map.getHeight());
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

    @Test
    public void calculatePositionWorks() {

        Point p = new Point(1,1);
        Map map = new Map();

        Point end = map.calculatePosition(p, GameController.DIRECTION.NORTH);
        assertEquals(new Point(1,2), end);
        end = map.calculatePosition(p, GameController.DIRECTION.SOUTH);
        assertEquals(new Point(1,0), end);
        end = map.calculatePosition(p, GameController.DIRECTION.EAST);
        assertEquals(new Point(2,1), end);
        end = map.calculatePosition(p, GameController.DIRECTION.WEST);
        assertEquals(new Point(0,1), end);

        p = new Point(0,0);
        end = map.calculatePosition(p, GameController.DIRECTION.NORTH);
        assertEquals(new Point(0,1), end);
        end = map.calculatePosition(p, GameController.DIRECTION.SOUTH);
        assertEquals(new Point(0,0), end);
        end = map.calculatePosition(p, GameController.DIRECTION.EAST);
        assertEquals(new Point(1,0), end);
        end = map.calculatePosition(p, GameController.DIRECTION.WEST);
        assertEquals(new Point(0,0), end);

    }
    
    @Test
    public void validatePositionWorks() {

    }
}
