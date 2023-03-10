package database.interfaces;

import model.book.Book;
import model.user.Customer;
import model.user.Person;

import java.util.ArrayList;
import java.util.Map;

public interface LibrarianOperations {
    Map<String,Customer> viewAllCustomer();
    String addBook(Book book);
   // String removeBook(String ISBN);
    //Map<String,String> viewRentedCustomers();
    Map<String, ArrayList<String>> viewRentedBooks();

}
