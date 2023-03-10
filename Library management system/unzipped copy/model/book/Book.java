package model.book;

public class Book {
    private final String bookName;
    public final String  ISBN;
    private final String authorName;
    boolean isAvailable;
    private final BookGenre genre;

    public Book(String bookName, String  isbn, String authorName, boolean isAvailable, BookGenre genre) {
        this.bookName = bookName;
        ISBN = isbn;
        this.authorName = authorName;
        this.isAvailable = isAvailable;
        this.genre = genre;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    public  String display(){
        return (this.bookName+"\t\t\t\t\t"+this.authorName+"\t\t\t\t\t"+this.genre+"\t\t\t\t\t"+this.isAvailable);
    }
}
