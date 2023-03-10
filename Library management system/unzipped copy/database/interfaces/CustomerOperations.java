package database.interfaces;

import model.book.Book;

import java.util.Map;

public interface CustomerOperations {
    String borrowBook(String  ISBN);
    String returnBook(String ISBN);


}
