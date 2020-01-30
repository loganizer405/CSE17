/**
 * Program name: ALA1
 * Uses classes
 *
 * @author Logan Kramer
 * Date: 1/30/20
 * @version 1.0
 */

import java.util.Scanner;

public class RoomTest {

    public static void main(String[] args) {
        Room[] cseRooms = new Room[5];
        cseRooms[0] = new Room("sandbox lab", "PL - 112", 65, 15.5, 30.75);
        cseRooms[1] = new Room("sunlab", "PL - 122", 45, 10, 15);
        cseRooms[2] = new Room("classroom", "PL - 415", 80, 20, 30);
        cseRooms[3] = new Room("faculty", "PL - 252", 1, 10.5, 10.75);
        cseRooms[4] = new Room("admin office", "PL - 115", 1, 12.25, 10.35);
        System.out.print("       Name:\tLocation:  Capacity:    Length:     Width:     Area:");
        for(int i = 0; i < cseRooms.length; i++)
            System.out.printf("\n%12s    %8s    %8d      %2.2f      %2.2f    %4.2f",
                    cseRooms[i].getName(), cseRooms[i].getLocation(), cseRooms[i].getCapacity(), cseRooms[i].getLength(), cseRooms[i].getWidth(), cseRooms[i].getArea());
    }
}