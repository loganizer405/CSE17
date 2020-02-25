import java.io.*;
import java.util.Scanner;

public class Airplane {
    private char[][] seatMap;

    Airplane() { //initialize seatMap and fill with .
        seatMap = new char[9][8];
        for (int i = 0; i < seatMap.length; i++) {
            for (int j = 0; j < seatMap[i].length; j++)
                seatMap[i][j] = '.';
        }
    }

    Airplane(String filename) {
        seatMap = new char[9][8];
        seatMap = readMapFromFile(filename);
    }

    public char[][] readMapFromFile(String filename) {
        Scanner fileScanner;
        try {
            fileScanner = new Scanner(new FileInputStream(filename)); //initialize scanner
        }
        catch (FileNotFoundException e) {
            //fill array with dots
            for (int i = 0; i < seatMap.length; i++) {
                for (int j = 0; j < seatMap[i].length; j++)
                    seatMap[i][j] = '.';
            }
            //print to file
            saveMap(filename);
            return seatMap;
        }
        //assuming all went well, read file
        for (int i = 0; i < seatMap.length; i++) {
            String line = fileScanner.nextLine();
            for (int j = 0; j < seatMap[i].length; j++)
                seatMap[i][j] = line.charAt(j * 2); //every other character, so ignore spaces
        }
        fileScanner.close(); //close scanner
        return seatMap;
    }

    public void saveMap(String filename) {
        try {
            PrintWriter fileWriter = new PrintWriter(new FileOutputStream(filename)); //initialize writer, this creates the file if not already there
            for (char[] chars : seatMap) {
                for (char c : chars)
                    fileWriter.print(c + " "); //prints characters and spaces
                fileWriter.println(); //move to next time
            }
            fileWriter.close(); //close writer
        }
        catch (FileNotFoundException e) {
            //if file not found? should not occur since file is created above
        }
    }

    public boolean checkSeat(String seat) throws InvalidSeatException {
        if (seat.matches("[1-9][A-H]"))
            return true;
        //else, throw exception and return false
        throw new InvalidSeatException();
    }

    public boolean reserveSeat(String seat) throws InvalidSeatException {
        try {
            checkSeat(seat);
        }
        catch (InvalidSeatException e) {
            throw new InvalidSeatException(""); //blank so the error does not print twice
        }
        int row = seat.charAt(0) - '1';
        int col = seat.charAt(1) - 'A';
        if (seatMap[row][col] == '.') {
            seatMap[row][col] = 'X';
            return true;
        }
        //otherwise, if X found
        return false;
    }

    public boolean freeSeat(String seat) throws InvalidSeatException {
        try {
            checkSeat(seat);
        }
        catch (InvalidSeatException e) {
            throw new InvalidSeatException(""); //blank so the error does not print twice
        }
        int row = seat.charAt(0) - '1';
        int col = seat.charAt(1) - 'A';
        if (seatMap[row][col] == 'X') {
            seatMap[row][col] = '.';
            return true;
        }
        //otherwise, if . found
        return false;
    }

    public String toString() {
        String str = "\tA B C D E F G H\n";
        for (int i = 0; i < seatMap.length; i++) {
            str += (i + 1) + "\t";
            for (int j = 0; j < seatMap[i].length; j++)
                str += seatMap[i][j] + " ";
            str += "\n";
        }
        return str;
    }
}

