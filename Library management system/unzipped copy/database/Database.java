package database;

import java.util.HashMap;
import java.util.Map;

import model.book.Book;
import model.user.Customer;
import model.user.Librarian;

class Database {
    final Librarian librarian;
    boolean isLibrarian;
    final String librarianPassword="12345";
    {
        librarian=new Librarian("Lavanya",librarianPassword,"LavanyaLIB#1");
    }
    private final Map<String, Book> allBooks ;
    private final Map<String ,Book> availableBooks ;
    private final Map<String , String> rentedBooks ;
    private final Map<String,Customer> allCustomers;
    private final Map<String,String> customerCredentials;
    private Customer currentCustomer;
    private Database(){
        allBooks=new HashMap<>();
        availableBooks=new HashMap<>();
        rentedBooks=new HashMap<>();
        allCustomers=new HashMap<>();
        customerCredentials = new HashMap<>();
    }
    private static Database instance=null;
    static Database getInstance() {
        if (instance == null) {
            instance = new Database();
        }
        return instance;
    }

    Map<String ,Book> getAllBooks(){return new HashMap<>(allBooks);}
    Map<String ,Book> getAvailableBooks(){return new HashMap<>(availableBooks);}
    Map<String,Customer> getAllCustomers(){return new HashMap<>(allCustomers);}

    Map<String,String> getRentedBooks(){return new HashMap<>(rentedBooks);}
    Map<String,String> getCustomerCredentials(){return new HashMap<>(customerCredentials);}
    private Book getBookInstance(String ISBN){
        if(allBooks.containsKey(ISBN))
            return allBooks.get(ISBN);
        else return availableBooks.get(ISBN);
    }
    Customer getCustomerInstance(String userID){
        return allCustomers.get(userID);
   }

    String borrowBook(String ISBN) {
        if (availableBooks.containsKey(ISBN)) {
            getBookInstance(ISBN).setAvailable(false);
            rentedBooks.put(ISBN, currentCustomer.userID);
            availableBooks.remove(ISBN);
            return "Book " + ISBN + " is borrowed by you successfully";
        } else return "ISBN not available";
    }
    String  returnBook(String ISBN) {
        if (rentedBooks.containsKey(ISBN)) {
            if (rentedBooks.get(ISBN).equals(currentCustomer.userID)) {
                getBookInstance(ISBN).setAvailable(true);
                rentedBooks.remove(ISBN);
                availableBooks.put(ISBN, getBookInstance(ISBN));
                return "Book " + ISBN + " is returned by you successfully,thank you";
            } else {
                return "This book is not borrowed by you and so you can't return it";
            }
        }else {
                return "Invalid book is being returned";
            }
        }
    String addBook(Book book) {
        allBooks.put(book.ISBN,book);
        availableBooks.put(book.ISBN, book);
        return "Book added successfully";
    }
    String removeBook(String ISBN) {
        if (allBooks.containsKey(ISBN)) {
            if (rentedBooks.containsKey(ISBN))
                return "This book cannot be removed right now as it is borrowed";
            else {
                allBooks.remove(ISBN, getBookInstance(ISBN));
                availableBooks.remove(ISBN, getBookInstance(ISBN));
                return "Book removed successfully";
            }
        }else return "Wrong ISBN number";
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
