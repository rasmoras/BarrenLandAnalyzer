package com.project.barrenland.model;

import com.project.barrenland.constants.Constants;

/**
 * Class representing the farm
 */

public class Farm {

    /**
     * 2 dimensional array representing the farm
     */
    private int[][] farmland = new int[Constants.MAX_X][Constants.MAX_Y];

    /**
     * Represents barren land coordinates
     */
    private int[][] barrenLand;

    /**
     * @return
     */
    public int[][] getFarmLand() {
        return farmland;
    }

    /**
     * @param barrenLand
     */
    public void setBarrenLand(final int[][] barrenLand) {
        this.barrenLand = barrenLand;
    }

    /**
     * @return
     */
    public int[][] getBarrenLand() {
        return barrenLand;
    }

    /**
     * plots the farm land
     */
    public void print() {
        final String ANSI_RESET = "\u001B[0m";
        final String white = "\u001B[37m";
        final String[] colours = {"\u001B[32m", "\u001B[33m", "\u001B[34m", "\u001B[35m", "\u001B[36m"};

        for (int i = 0; i < farmland.length; i++) {
            for (int j = 0; j < farmland[i].length; j++) {
                int marker = farmland[i][j];
                if (marker == Constants.BARREN_MARKER) {
                    System.out.print(white + marker + ANSI_RESET);
                } else {
                    int colourIndex = marker % colours.length;
                    System.out.print(colours[colourIndex] + marker + ANSI_RESET);
                }
            }
            System.out.println();
        }
    }

}
