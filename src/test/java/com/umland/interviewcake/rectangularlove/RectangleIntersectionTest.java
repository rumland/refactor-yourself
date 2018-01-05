package com.umland.interviewcake.rectangularlove;

import org.junit.Test;

import static org.junit.Assert.*;

public class RectangleIntersectionTest {
    @Test
    public void getIntersectionTest() {
        RectangleIntersection rectangleIntersection = new RectangleIntersection(
                new Rectangle(3, 2, 4, 3),
                new Rectangle(4, 3, 10, 10));
        Rectangle expectedRectangle = new Rectangle(4, 3, 3, 2);
        Rectangle intersection = rectangleIntersection.getIntersection();
        assertEquals(expectedRectangle, intersection);
    }

    @Test
    public void getShareEdgeIntersectionTest() {
        RectangleIntersection rectangleIntersection = new RectangleIntersection(
                new Rectangle(3, 2, 4, 3),
                new Rectangle(7, 3, 10, 10));
        Rectangle expectedRectangle = new Rectangle(0, 0, 0, 0);
        Rectangle intersection = rectangleIntersection.getIntersection();
        assertEquals(expectedRectangle, intersection);
    }

    @Test
    public void getNoIntersectionTest() {
        RectangleIntersection rectangleIntersection = new RectangleIntersection(
                new Rectangle(3, 2, 4, 3),
                new Rectangle(8, 3, 10, 10));
        Rectangle expectedRectangle = new Rectangle(0, 0, 0, 0);
        Rectangle intersection = rectangleIntersection.getIntersection();
        assertEquals(expectedRectangle, intersection);
    }

    @Test
    public void getEntiretyIntersectionTest() {
        RectangleIntersection rectangleIntersection = new RectangleIntersection(
                new Rectangle(3, 2, 4, 3),
                new Rectangle(3, 2, 4, 3));
        Rectangle expectedRectangle = new Rectangle(3, 2, 4, 3);
        Rectangle intersection = rectangleIntersection.getIntersection();
        assertEquals(expectedRectangle, intersection);
    }
}