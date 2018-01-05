package com.umland.interviewcake.rectangularlove;

import org.junit.Test;

import static org.junit.Assert.*;

public class RectangleTest {
    private Rectangle rectangle = new Rectangle(3, 2, 4, 3);

    @Test
    public void getLeftXTest() {
        assertEquals(3, rectangle.getLeftX());
    }

    @Test
    public void getBottomYTest() {
        assertEquals(2, rectangle.getBottomY());
    }

    @Test
    public void getWidthTest() {
        assertEquals(4, rectangle.getWidth());
    }

    @Test
    public void getHeightTest() {
        assertEquals(3, rectangle.getHeight());
    }

    @Test
    public void equalsTest() {
        Rectangle rec = new Rectangle(3, 2, 4, 3);
        assertEquals(rectangle, rec);
    }

    @Test
    public void equalsReferenceTest() {
        assertEquals(rectangle, rectangle);
    }

    @Test
    public void notEqualsTest() {
        Rectangle rec = new Rectangle(4, 2, 4, 3);
        assertNotEquals(rectangle, rec);
    }
}