package com.project.barrenland.model;

/**
 * Class to represent co-ordinates
 */

public class Coordinate {
    private int x;
    private int y;

    /**
     * Initialize cooridnates
     *
     * @param x
     * @param y
     */
    public Coordinate(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}
