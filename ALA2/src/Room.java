/**
 * Program name: ALA1
 * Uses classes
 *
 * @author Logan Kramer
 * Date: 1/30/20
 * @version 1.0
 */

import java.util.Scanner;

public class Room {
    private String name;
    private String location;
    private int capacity;
    private double length;
    private double width;

    //constructor
    Room() {
        name = "none";
        location = "none";
        capacity = 0;
        length = 0.0;
        width = 0.0;
    }

    Room(String n, String loc, int c, double l, double w) {
        name = n;
        location = loc;
        capacity = c;
        length = l;
        width = w;
    }
    //get methods
    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getCapacity() {
        return capacity;
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }
    //set methods
    public void setName(String n){
        name = n;
    }
    public void setLocation(String loc) {
        location = loc;
    }
    public void setCapacity(int cap){
        capacity = cap;
    }
    public void setLength(int l){
        length = l;
    }
    public void setWidth(int w){
        width = w;
    }
    public double getArea(){
        return length * width;
    }
}