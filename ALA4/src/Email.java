public class Email extends Document{
    private String sender;
    private String recipient;
    private String subject;
    Email(){
        super("");
        sender = "";
        recipient = "";
        subject = "";
    }
    Email(String sender, String recipient, String subject, String text){
        super(text);
        this.sender = sender;
        this.recipient = recipient;
        this.subject = subject;
    }

    public String getSender() {
        return sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public String getSubject() {
        return subject;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    public String toString() {
        return "From: " + sender + "\nTo: " + recipient + "\nSubject: " + subject + "\nBody:\n" + getText();
    }
}
