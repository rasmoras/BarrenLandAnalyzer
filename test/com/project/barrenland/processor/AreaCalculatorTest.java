package com.project.barrenland.processor;

import com.project.barrenland.model.Farm;
import org.junit.Test;
import org.junit.Before;

import java.util.List;
import java.util.Arrays;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class AreaCalculatorTest {

    @Before

    public void before() {

    }

    @Test
    public void test_Area_Calculator_target_Test_1() {
        int[][] coordinates = new int[][]{
                {0, 292, 399, 307}
        };
        String expected = "116800 116800";

        String actual = invokeBarrenLandAnalzyer(coordinates);
        assertTest(expected, actual, coordinates);
    }

    @Test
    public void test_Area_Calculator_target_Test_2() {
        int[][] coordinates = new int[][]{
                {48, 192, 351, 207},
                {48, 392, 351, 407},
                {120, 52, 135, 547},
                {260, 52, 275, 547}
        };
        String expected = "22816 192608";

        String actual = invokeBarrenLandAnalzyer(coordinates);
        assertTest(expected, actual, coordinates);
    }

    @Test
    public void test_Area_Calculator_No_Fertile_Area() {
        int[][] coordinates = new int[][]{
                {0, 0, 399, 599}
        };
        String expected = "";

        String actual = invokeBarrenLandAnalzyer(coordinates);
        assertTest(expected, actual, coordinates);
    }


    @Test
    public void test_Area_Calculator_area_boundaries_1() {
        int[][] coordinates = new int[][]{
                {0, 0, 1, 1}
        };
        String expected = "239996";

        String actual = invokeBarrenLandAnalzyer(coordinates);
        assertTest(expected, actual, coordinates);
    }

    @Test
    public void test_Area_Calculator_area_boundaries_2() {
        int[][] coordinates = new int[][]{
                {0, 0, 0, 599}
        };
        String expected = "239400";

        String actual = invokeBarrenLandAnalzyer(coordinates);
        assertTest(expected, actual, coordinates);
    }

    @Test
    public void test_Area_Calculator_area_boundaries_3() {
        int[][] coordinates = new int[][]{
                {0, 0, 0, 599},
                {2, 0, 2, 599}
        };
        String expected = "600 238200";

        String actual = invokeBarrenLandAnalzyer(coordinates);
        assertTest(expected, actual, coordinates);
    }

    @Test
    public void test_Area_Calculator__area_1() {
        int[][] coordinates = new int[][]{
                {0, 0, 0, 599},
                {2, 0, 2, 599},
                {3, 2, 399, 3},
                {5, 0, 5, 1},
                {10, 4, 12, 599}
        };
        String expected = "4 600 788 4172 230652";

        String actual = invokeBarrenLandAnalzyer(coordinates);
        assertTest(expected, actual, coordinates);
    }

    @Test
    public void test_Area_Calculator__area_2() {
        int[][] coordinates = new int[][]{
                {0, 0, 0, 599},
                {2, 0, 2, 599},
                {3, 2, 399, 3}
        };
        String expected = "600 794 236612";

        String actual = invokeBarrenLandAnalzyer(coordinates);
        assertTest(expected, actual, coordinates);
    }


    @Test
    public void test_Area_Calculator_area_3() {
        int[][] coordinates = new int[][]{
                {0, 0, 0, 599},
                {2, 0, 2, 599},
                {3, 2, 399, 3},
                {5, 0, 5, 1}
        };
        String expected = "4 600 788 236612";

        String actual = invokeBarrenLandAnalzyer(coordinates);
        assertTest(expected, actual, coordinates);
    }

    @Test
    public void test_Area_Calculator_area_4() {
        int[][] coordinates = new int[][]{
                {0, 0, 0, 599},
                {0, 0, 399, 0},
                {399, 0, 399, 599},
                {0, 599, 399, 599}
        };
        String expected = "238004";

        String actual = invokeBarrenLandAnalzyer(coordinates);
        assertTest(expected, actual, coordinates);
    }

    /**
     * invoke test
     *
     * @param coordinates
     * @return
     */
    private String invokeBarrenLandAnalzyer(int[][] coordinates) {
        Farm farm = new Farm();
        farm.setBarrenLand(coordinates);

        Plotter plotter = new Plotter();
        plotter.plotFarmLand(farm);

        AreaCalculator calculator = new AreaCalculator();
        List<Integer> areas = calculator.calculateArea(farm);

        //farm.print();

        StringBuilder result = new StringBuilder();

        for (Integer area : areas) {
            result.append(area);
            result.append(" ");
        }
        return result.toString().trim();
    }

    /**
     * assert and print results
     */

    private void assertTest(String expected, String actual, int[][] coordinates) {
        System.out.println("Input: " + Arrays.deepToString(coordinates) + "\n Output: " + actual);
        System.out.println();
        assertEquals(actual, expected);
    }
}
