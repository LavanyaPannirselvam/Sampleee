package database;

import database.interfaces.LibrarianOperations;
import database.interfaces.ViewOperations;
import model.book.Book;
import model.user.*;

import java.util.Map;

class LibrarianDBHandler implements LibrarianOperations, ViewOperations {
    private final Database database = Database.getInstance();
    public String addBook(Book book) {
        return database.addBook(book);
    }

    @Override
    public String removeBook(String ISBN) {
        return database.removeBook(ISBN);
    }

    @Override
    public Map<String,Customer> viewAllCustomer() {
        return database.getAllCustomers();
    }

    @Override
    public Map<String, String> viewRentedBooks() {
        return database.getRentedBooks();
    }

    @Override
    public Map<String , Book> getAllBooks() {
        return database.getAllBooks();
    }

    @Override
    public Map<String , Book> getAvailableBooks() {
        return database.getAvailableBooks();
    }


}
