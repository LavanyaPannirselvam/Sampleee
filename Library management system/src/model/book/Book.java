package model.book;

public class Book {
    private final String bookName;
    public final String  ISBN;
    private final String authorName;
    private int bookCount;
    public final int totalCount;
    private final BookGenre genre;

    public Book(String bookName, String  ISBN, String authorName, BookGenre genre,int bookCount) {
        this.bookName = bookName;
        this.ISBN = ISBN;
        this.authorName = authorName;
        this.genre = genre;
        this.bookCount = bookCount;
        totalCount = bookCount;
    }

    public void addBookCount(){bookCount++;}
    public void subtractBookCount(){bookCount--;}
    public int getBookCount(){return bookCount;}
    public  String display(){
        return (this.bookName+"\t\t\t\t\t"+this.authorName+"\t\t\t\t\t"+this.genre+"\t\t\t\t\t"+this.bookCount);
    }
    public String displayAllBooks(){
        return (this.bookName+"\t\t\t\t\t"+this.authorName+"\t\t\t\t\t"+this.genre);

    }
}
