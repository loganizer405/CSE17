public class Email extends Document { //class inherited from Document
    private String sender;
    private String recipient;
    private String subject;

    Email() {
        super("");
        sender = "";
        recipient = "";
        subject = "";
    }

    Email(String sender, String recipient, String subject, String text) {
        super(text);
        this.sender = sender;
        this.recipient = recipient;
        this.subject = subject;
    }

    public String getSender() { //returns sender
        return sender;
    }

    public String getRecipient() { //returns recipient
        return recipient;
    }

    public String getSubject() { //returns subject
        return subject;
    }

    public void setRecipient(String recipient) { //sets recipient
        this.recipient = recipient;
    }

    public void setSender(String sender) { //sets sender
        this.sender = sender;
    }

    public void setSubject(String subject) { //sets subject
        this.subject = subject;
    }

    public String toString() { //override: prints email
        return "From: " + sender + "\nTo: " + recipient + "\nSubject: " + subject + "\nBody:\n" + getText();
    }
}
