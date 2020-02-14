public class TestDocument {
    public static void main(String[] args){
       Email myEmail = new Email("boo111@lehigh.edu", "hoo111@lehigh.edu", "Late Working Hours", "Hello\nThis is a reminder for your approval of late working house on 01/24/2020.\nBest regards,\nBen");
       File myFile = new File("/home/boo111/CSE17/Practice.java", "public class Lab1{\npublic static void main(String[] args) {\npublic static void main(String[] args){\nSystem.out.println(\"Hello World!\");\n} // end of the main method\n} // end of the class Lab1");
       if(containsKeyword(myEmail, "working") && containsKeyword(myFile, "working")){
           System.out.println("Both file and email contain keyword 'working'");
       }
       else if(containsKeyword(myEmail, "working"))
           System.out.println("Only email contains keyword 'working'");
       else if(containsKeyword(myFile, "working"))
           System.out.println("Only file contains keyword 'working'");
       else
           System.out.println("Neither file nor email contains keyword 'working'");
       System.out.println(myEmail.toString());
       System.out.println(myFile.toString());
    }
    public static boolean containsKeyword(Document docObject, String keyword) {
        return docObject.toString().contains(keyword); //return true if contains word
    }
}
