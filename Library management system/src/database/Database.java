package database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.book.Book;
import model.user.Customer;
import model.user.Librarian;

class Database {
    final Librarian librarian;
    boolean isLibrarian;
    final String librarianPassword = "12345";

    {
        librarian = new Librarian("Lavanya", librarianPassword, "LavanyaLIB#1");
    }

    private final Map<String, Book> allBooks;
    private final Map<String, Book> availableBooks;
//    private final Map<String, String> rentedBooks;
    private final Map<String, String> bookBorrowedData;

    private final Map<String, Customer> allCustomers;
    private final Map<String, String> customerCredentials;
    private final Map<String, Map<String,Integer >> returnOnlyBooks;
    private final Map<String ,Book> removedBooks;
    private Customer currentCustomer;

    private Database() {
        allBooks = new HashMap<>();
        availableBooks = new HashMap<>();
        bookBorrowedData = new HashMap<>();
        allCustomers = new HashMap<>();
        customerCredentials = new HashMap<>();
        returnOnlyBooks = new HashMap<>();
        removedBooks = new HashMap<>();
    }

    private static Database instance = null;

    static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    Map<String, Book> getAllBooks() {
        return new HashMap<>(allBooks);
    }

    Map<String, Book> getAvailableBooks() {
        return new HashMap<>(availableBooks);
    }

    Map<String, Customer> getAllCustomers() {
        return new HashMap<>(allCustomers);
    }

    Map<String, String> getBookBorrowedData() {
        return new HashMap<>(bookBorrowedData);
    }

    Map<String, String> getCustomerCredentials() {
        return new HashMap<>(customerCredentials);
    }

    private Book getBookInstance(String ISBN) {
        if(allBooks.containsKey(ISBN))
            return allBooks.get(ISBN);
        else
            return removedBooks.get(ISBN);
    }

    Customer getCustomerInstance(String userID) {
        return allCustomers.get(userID);
    }

    String borrowBook(String ISBN) {
        if (allBooks.containsKey(ISBN)) {
            if (availableBooks.containsKey(ISBN) && availableBooks.get(ISBN).getBookCount() >= 1) {
                getBookInstance(ISBN).subtractBookCount();
               bookBorrowedData.put(ISBN, currentCustomer.userID);
                bookBorrowedData.get(ISBN).add(currentCustomer.userID);
                if (getBookInstance(ISBN).getBookCount() == 0)
                    availableBooks.remove(ISBN);
                return "Book " + ISBN + " is borrowed by you successfully";
            } else return "Book not available to borrow";
        } else return "ISBN not available";
    }

    String returnBook(String ISBN) {
        if (allBooks.containsKey(ISBN)) {
            if (bookBorrowedData.containsKey(ISBN)) {
                if (bookBorrowedData.get(ISBN).equals(currentCustomer.userID)) {
                    if (getBookInstance(ISBN).getBookCount() >= getBookInstance(ISBN).totalCount)
                        return "Invalid operation";
                    getBookInstance(ISBN).addBookCount();
                    bookBorrowedData.remove(ISBN,currentCustomer.userID);
                    bookBorrowedData.get(ISBN).remove(currentCustomer.userID);
                    if (!availableBooks.containsKey(ISBN))
                        availableBooks.put(ISBN, getBookInstance(ISBN));
                    return "Book " + ISBN + " is returned by you successfully,thank you";
                }else
                    return "This book is not borrowed by you and so you can't return it";
            }else
                return "Invalid book is being returned";
        }else if (removedBooks.containsKey(ISBN)){
            returnOnlyBooks.remove(ISBN, getBookInstance(ISBN));
            return "Book " + ISBN + " is returned by you successfully,thank you";
        }
        else {
            return "Invalid book is being returned";}
    }
    String addBook(Book book) {
        if (allBooks.containsKey(book.ISBN))
            return "Book already exists";
        allBooks.put(book.ISBN, book);
        bookBorrowedData.put(book.ISBN,new ArrayList<>());
        availableBooks.put(book.ISBN, book);
        return "Book added successfully";
    }

    String removeBook(String ISBN) {//todo
        boolean status = false;
        if (allBooks.containsKey(ISBN)) {
            if (bookBorrowedData.containsKey(ISBN)) {
                returnOnlyBooks.put((ISBN),);
                status = true;
            }
            availableBooks.remove(ISBN, getBookInstance(ISBN));
            allBooks.remove(ISBN, getBookInstance(ISBN));
            if (status)
                return "Book removed successfully but it should be returned by our customer(s)";
            else
                return "Book removed successfully";
        }else return"Wrong ISBN number";
}

    String addCustomers(String userID,String password,Customer customer){//OK
        allCustomers.put(userID,customer);
        customerCredentials.put(userID,password);
        return "Sign up successful.\nYour userId is "+userID;
    }
    void setCurrentCustomer(Customer customer) {
        currentCustomer = customer;
    }
    Customer getCurrentCustomer(){
        return currentCustomer;
    }
    String logoutCustomer(){
        currentCustomer=null;
        return "Logged out successfully";
    }

}
//to be added
//3.book count should be added
//4.already existing ISBN can only update the count of the book
//&& availableBooks.get(ISBN).getBookCount() >= 1
//return "This book cannot be removed right now as it is borrowed";
//            else {
//String returnBook(String ISBN) {
//        if (allBooks.containsKey(ISBN)) {
//            if (rentedBooks.containsKey(ISBN)) {
//                if (rentedBooks.get(ISBN).equals(currentCustomer.userID)) {
//                    if (getBookInstance(ISBN).getBookCount() >= getBookInstance(ISBN).initialCount)
//                        return "Invalid operation";
//                    getBookInstance(ISBN).addBookCount();
//                    if (!availableBooks.containsKey(ISBN))
//                        availableBooks.put(ISBN, getBookInstance(ISBN));
//                    return "Book " + ISBN + " is returned by you successfully,thank you";
//                } else {
//                    return "This book is not borrowed by you and so you can't return it";
//                }
//            } else {
//                return "Invalid book is being returned";
//            }
//        }else if(returnOnlyBooks.containsKey(ISBN)){
//            returnOnlyBooks.remove(ISBN,getBookInstance(ISBN));
//        }
//    }