package quotes;

public class Quotes {
    private String author;
    private String text;

    //private ArrayList<String> tags= new ArrayList<String>();

    public Quotes(String author, String text ){
        this.author=author;
        this.text=text;
    }

    public String getAuthor() {
        return author;
    }

    public String getText() {
        return text;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Quotes{" +
                "author='" + author + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
