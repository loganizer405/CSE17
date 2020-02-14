public class File extends Document {
    private String pathname;
    File(){
        super("");
        pathname = "";
    }
    File(String pathname, String text){
        super(text);
        this.pathname = pathname;
    }
    public String toString() {
        return "Pathname: " + pathname + "\nText:\n" + getText();
    }
}
