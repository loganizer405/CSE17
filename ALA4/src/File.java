public class File extends Document { //class inherited from Document
    private String pathname;

    File() {
        super("");
        pathname = "";
    }

    File(String pathname, String text) {
        super(text);
        this.pathname = pathname;
    }

    public String toString() { //override: prints file
        return "Pathname: " + pathname + "\nText:\n" + getText();
    }
}
