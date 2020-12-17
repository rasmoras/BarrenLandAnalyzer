package com.project.barrenland.processor;

import com.project.barrenland.constants.Constants;
import com.project.barrenland.model.Coordinate;
import com.project.barrenland.model.Farm;

import java.util.*;

/**
 * Module to calculate areas
 */
public class AreaCalculator {

    /**
     * calculates the fertile land area
     *
     * @param farm
     * @return
     */
    public List<Integer> calculateArea(final Farm farm) {
        int[][] nodes = farm.getFarmLand();
        List<Integer> areas = new ArrayList<Integer>();

        // Marker represents the type of land. Fertile lands start from market 2
        int marker = Constants.FERTILE_LAND_MARKER_START;

        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes[0].length; j++) {
                // Traverse nodes not visited
                if (nodes[i][j] == Constants.UN_VISITED_MARKER) {
                    Queue<Coordinate> queue = new LinkedList<Coordinate>();
                    queue.add(new Coordinate(i, j));
                    int area = bfs(queue, nodes, marker++);
                    areas.add(area);
                }
            }
        }

        Collections.sort(areas);
        return areas;
    }

    /**
     * BFS traversal to calculate the area
     *
     * @param queue
     * @param nodes
     * @param marker
     * @return
     */
    private int bfs(final Queue<Coordinate> queue, final int[][] nodes, final int marker) {
        int area = 0;
        while (!queue.isEmpty()) {
            Coordinate coordinate = queue.poll();
            if (nodes[coordinate.getX()][coordinate.getY()] == Constants.UN_VISITED_MARKER) {
                // count each coordinate to calculate the area
                area = area + 1;

                // mark node as visited
                nodes[coordinate.getX()][coordinate.getY()] = marker;
                for (Coordinate neighbor : getNeighbors(coordinate, nodes)) {
                    queue.add(neighbor);
                }
            }
        }
        return area;
    }

    /**
     * return neighbouring coordinates
     *
     * @param coordinate
     * @param nodes
     * @return
     */
    private List<Coordinate> getNeighbors(Coordinate coordinate, int[][] nodes) {
        List<Coordinate> neigbors = new ArrayList<Coordinate>();

        int i = coordinate.getX();
        int j = coordinate.getY();

        // Add neighbors

        if (i > 0) {
            addToNeighborList(i - 1, j, nodes, neigbors);
        }

        if (i < nodes.length - 1) {
            addToNeighborList(i + 1, j, nodes, neigbors);
        }

        if (j < nodes[0].length - 1) {
            addToNeighborList(i, j + 1, nodes, neigbors);
        }

        if (j > 0) {
            addToNeighborList(i, j - 1, nodes, neigbors);
        }

        return neigbors;
    }

    private void addToNeighborList(int i, int j, int[][] nodes, List<Coordinate> neigbors) {
        // Add neighbor only if not visited earlier
        if (nodes[i][j] == Constants.UN_VISITED_MARKER) {
            neigbors.add(new Coordinate(i, j));
        }
    }


}
