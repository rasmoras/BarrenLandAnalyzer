package com.project.barrenland.runner;


import com.project.barrenland.model.Farm;
import com.project.barrenland.processor.AreaCalculator;
import com.project.barrenland.processor.Plotter;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        int[][] barrenLandCoordinates = new int[][]{
                {48, 192, 351, 207},
                {48, 392, 351, 407},
                {120, 52, 135, 547},
                {260, 52, 275, 547}
        };

        Farm farm = new Farm();
        farm.setBarrenLand(barrenLandCoordinates);

        Plotter plotter = new Plotter();
        plotter.plotFarmLand(farm);

        System.out.println("Calculating areas");

        AreaCalculator calculator = new AreaCalculator();
        List<Integer> area = calculator.calculateArea(farm);
        System.out.println("Areas of all fertile lands = " + area);

        farm.print();
    }
}
