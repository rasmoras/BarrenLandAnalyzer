package com.project.barrenland.processor;

import com.project.barrenland.constants.Constants;
import com.project.barrenland.model.Coordinate;
import com.project.barrenland.model.Farm;

/**
 * Class to set markers in the farm
 */
public class Plotter {

    /**
     * Initializes farm areas
     *
     * @param farm
     */
    public void plotFarmLand(Farm farm) {
        initializeFarmLand(farm.getFarmLand());

        for (int[] coordinate : farm.getBarrenLand()) {
            fillBarrenLand(new Coordinate(coordinate[0], coordinate[1]), new Coordinate(coordinate[2], coordinate[3]), farm.getFarmLand());
        }
    }

    /**
     * Initializes all farm areas to 0
     *
     * @param farmland
     */
    private void initializeFarmLand(int[][] farmland) {
        for (int i = 0; i < farmland.length; i++) {
            for (int j = 0; j < farmland[0].length; j++) {
                farmland[i][j] = Constants.UN_VISITED_MARKER;
            }
        }
    }

    /**
     * Initializes all barren lands areas to 1
     *
     * @param from
     * @param to
     * @param farmland
     */

    private void fillBarrenLand(Coordinate from, Coordinate to, int[][] farmland) {
        for (int i = from.getX(); i <= to.getX(); i++) {
            for (int j = from.getY(); j <= to.getY(); j++) {
                farmland[i][j] = Constants.BARREN_MARKER;
            }
        }
    }

}
