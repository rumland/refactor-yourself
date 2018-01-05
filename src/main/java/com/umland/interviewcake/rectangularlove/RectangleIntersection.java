package com.umland.interviewcake.rectangularlove;

/**
 * A crack team of love scientists from OkEros (a hot new dating site) have devised a way to represent dating profiles
 * as rectangles on a two-dimensional plane.
 * <p>
 * They need help writing an algorithm to find the intersection of two users' love rectangles. They suspect finding
 * that intersection is the key to a matching algorithm so powerful it will cause an immediate acquisition by Google or
 * Facebook or Obama or something.
 * <p>
 * <img src="./doc-files/rectangular_love_it_must_be_love.png" />
 * <p>
 * Two rectangles overlapping a little. It must be love.
 * Write a method to find the rectangular intersection of two given love rectangles.
 * <p>
 * As with the example above, love rectangles are always "straight" and never "diagonal." More rigorously: each side
 * is parallel with either the x-axis or the y-axis.
 */
public class RectangleIntersection {
    private final Rectangle rectangleA;
    private final Rectangle rectangleB;
    private Rectangle intersection = null;

    RectangleIntersection(Rectangle rectangleA, Rectangle rectangleB) {
        int xA = rectangleA.getLeftX();
        int xB = rectangleB.getLeftX();

        if (xA < xB) {
            this.rectangleA = rectangleA;
            this.rectangleB = rectangleB;
        } else {
            this.rectangleA = rectangleB;
            this.rectangleB = rectangleA;
        }
    }

    public Rectangle getIntersection() {
        if (intersection == null) {
            if (xIntersectionDoesNotExist() || yIntersectionDoesNotExist()) {
                intersection = new Rectangle(0, 0, 0, 0);
            } else {

                int Xi = rectangleB.getLeftX();
                int Yi = rectangleB.getBottomY();
                int width = rectangleA.getWidth() - (rectangleB.getLeftX() - rectangleA.getLeftX());
                int height = rectangleA.getHeight() - (rectangleB.getBottomY() - rectangleA.getBottomY());

                intersection = new Rectangle(Xi, Yi, width, height);
            }
        }

        return intersection;
    }

    private boolean xIntersectionDoesNotExist() {
        return rectangleA.getLeftX() + rectangleA.getWidth() <= rectangleB.getLeftX();
    }

    private boolean yIntersectionDoesNotExist() {
        return rectangleA.getBottomY() + rectangleA.getHeight() <= rectangleB.getBottomY();
    }
}
