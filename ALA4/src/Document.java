public class Document {
    private String text;
    Document(){
        text = "";
    }
    Document(String text){
        this.text = text;
    }
    public void setText(String text){
        this.text = text;
    }
    public String getText() {
        return text;
    }
    public String toString() {
        return text;
    }
}
