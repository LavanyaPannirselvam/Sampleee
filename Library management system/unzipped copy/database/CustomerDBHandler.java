package database;

import database.interfaces.CustomerOperations;
import database.interfaces.ViewOperations;
import model.book.Book;

import java.util.Map;

class CustomerDBHandler implements CustomerOperations, ViewOperations {
    private final Database database =Database.getInstance();
    @Override
    public String borrowBook(String ISBN) {
        return database.borrowBook(ISBN);
    }
    @Override
    public String returnBook(String ISBN) {
        return database.returnBook(ISBN);
    }

    @Override
    public Map<String , Book>getAllBooks() {
        return database.getAllBooks();
    }

    @Override
    public Map<String , Book> getAvailableBooks() {
        return database.getAvailableBooks();
    }


}
