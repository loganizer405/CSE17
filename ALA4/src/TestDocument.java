/**
 * Program name: ALA4
 * Uses classes and a stack
 *
 * @author Logan Kramer
 * Date: 2/13/20
 * @version 1.0
 */
public class TestDocument {
    public static void main(String[] args) {
        //initialize file and email
        Email myEmail = new Email("boo111@lehigh.edu", "hoo111@lehigh.edu", "Late Working Hours", "Hello\nThis is a reminder for your approval of late working hours on 01/24/2020.\nBest regards,\nBen");
        File myFile = new File("/home/boo111/CSE17/Practice.java", "public class Lab1{\npublic static void main(String[] args) {\npublic static void main(String[] args){\nSystem.out.println(\"Hello World!\");\n} // end of the main method\n} // end of the class Lab1");
        //find if email and file contain late
        if (containsKeyword(myEmail, "late") && containsKeyword(myFile, "late")) {
            System.out.println("Both file and email contain keyword 'late'");
        }
        else if (containsKeyword(myEmail, "late")) //if only email contains late
            System.out.println("Only email contains keyword 'late'");
        else if (containsKeyword(myFile, "late")) //if only file contains late
            System.out.println("Only file contains keyword 'late'");
        else //if neither contain late
            System.out.println("Neither the file nor email contains keyword 'late'");
        //find if email and file contain hello
        if (containsKeyword(myEmail, "hello") && containsKeyword(myFile, "hello")) {
            System.out.println("Both file and email contain keyword 'hello'");
        }
        else if (containsKeyword(myEmail, "hello")) //if only email contains hello
            System.out.println("Only email contains keyword 'hello'");
        else if (containsKeyword(myFile, "hello")) //if only file contains hello
            System.out.println("Only file contains keyword 'hello'");
        else //if neither contain hello
            System.out.println("Neither the file nor email contains keyword 'hello'");
    }

    public static boolean containsKeyword(Document docObject, String keyword) {
        return docObject.toString().toLowerCase().contains(keyword); //return true if contains word, false if not
    }
}
