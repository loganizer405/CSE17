/*
 * Author: Logan Kramer
 * Program Name: Java Test
 * Date: 1/21/20
 * Version: 1.0
 */

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Circle circle1 = new Circle(1.5);
        Circle circle2 = new Circle(2.75);
        swap1(circle1, circle2);
        System.out.println("Afterswap1:circle1 =" + circle1.getRadius() + "circle2 =" + circle2.getRadius());
        swap2(circle1, circle2);
        System.out.println("Afterswap2:circle1 =" + circle1.getRadius() + "circle2 =" + circle2.getRadius());
    }

    public static void swap1(Circle x, Circle y) {
        Circle temp = x;
        x = y;
        y = temp;
    }

    public static void swap2(Circle x, Circle y) {
        double temp = x.getRadius();
        x.setRadius(y.getRadius());
        y.setRadius(temp);
    }
}