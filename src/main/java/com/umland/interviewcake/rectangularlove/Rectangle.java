package com.umland.interviewcake.rectangularlove;

import java.util.Objects;

public class Rectangle {
    // coordinates of bottom left corner
    private int leftX;
    private int bottomY;

    // dimensions
    private int width;
    private int height;

    Rectangle(int leftX, int bottomY, int width, int height) {
        this.leftX = leftX;
        this.bottomY = bottomY;
        this.width = width;
        this.height = height;
    }

    public int getLeftX() {
        return leftX;
    }

    public int getBottomY() {
        return bottomY;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rectangle rectangle = (Rectangle) o;
        return getLeftX() == rectangle.getLeftX() &&
                getBottomY() == rectangle.getBottomY() &&
                getWidth() == rectangle.getWidth() &&
                getHeight() == rectangle.getHeight();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLeftX(), getBottomY(), getWidth(), getHeight());
    }
}
