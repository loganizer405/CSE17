/**
 * Exam 1 assignment
 *
 * @author Logan Kramer
 * Date: 2/27/20
 * @version 1.0
 */

public class Test {
    public static void main(String[] args) {
        Faculty[] facultyList = new Faculty[100]; //create array of length 100
        for (int i = 0; i < facultyList.length; i++) { //loop for length of facultyList(100)
            String name = "name" + (i + 1); //sequential naming
            int id = (int) (Math.random() * 90000) + 10000; //random 5-digit ID
            int r = (int) (Math.random() * 4); //random number between 0 and 3
            String rank = "";
            switch (r) { //switch random number to determine rank
                case 0:
                    rank = "lecturer";
                    break;
                case 1:
                    rank = "assistant";
                    break;
                case 2:
                    rank = "associate";
                    break;
                case 3:
                    rank = "full";
                    break;
            }
            double salary = Math.random() * 50000 + 50000; //random salary
            //create object in array
            facultyList[i] = new Faculty(name, id, rank, salary);
        }
        //get and print average salaries for each rank
        System.out.printf("Average salary for all ranks: \t\t\t $%6.2f \n", averageSalary(facultyList, ""));
        System.out.printf("Average salary for lecturers: \t\t\t $%6.2f \n", averageSalary(facultyList, "lecturer"));
        System.out.printf("Average salary for assistant professors: $%6.2f \n", averageSalary(facultyList, "assistant"));
        System.out.printf("Average salary for associate professors: $%6.2f \n", averageSalary(facultyList, "associate"));
        System.out.printf("Average salary for full professors: \t $%6.2f \n", averageSalary(facultyList, "full"));
    }

    public static double averageSalary(Faculty[] list, String givenRank) {
        double sum = 0.0; //for adding all salaries together before averaging
        if (givenRank.equals("")) { //if blank string, get all salaries
            for (Faculty f : list) //run for each faculty in list
                sum += f.getSalary(); //add salary to total sum
            return sum / list.length; //divide total by whole length of list
        }
        //if string is not blank, run for when rank equals givenRank
        int numValues = 0; //to keep track of the number of salaries, for dividing at the end
        for (Faculty f : list) { //run for each faculty in list
            if (f.getRank().equals(givenRank)) { //if rank is same as given
                sum += f.getSalary(); //add salary to total
                numValues++; //add one to number of values
            }
        }
        return sum / numValues; //divide total by number of values for average
    }
}

