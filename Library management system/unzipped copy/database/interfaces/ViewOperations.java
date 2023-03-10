package database.interfaces;

import model.book.Book;

import java.util.Map;

public interface ViewOperations {
    Map<String , Book> getAllBooks();
    Map<String ,Book> getAvailableBooks();

}
