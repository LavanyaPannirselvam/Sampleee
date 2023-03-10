package controller;

import database.HandlerFactory;
import database.interfaces.LibrarianOperations;
import database.interfaces.ViewOperations;
import model.book.Book;
import model.book.BookGenre;
import model.user.Customer;
import view.ui.enums.LibrarianOptions;

import java.util.ArrayList;
import java.util.Map;


public class LibrarianHandler{
    private final LibrarianOperations obj = HandlerFactory.getLibrarianHandlerObject();
    private final ViewOperations viewObj = (ViewOperations) obj;
    public String display(LibrarianOptions option){
        if(option==LibrarianOptions.VIEW_ALL_BOOKS) {
            if (viewObj.getAllBooks().isEmpty())
                return "Sorry no books are available now to show you";
            else {
                System.out.println("ISBN \t\t\t\t\t BOOK NAME \t\t\t AUTHOR NAME \t\t\t GENRE ");
                for (Map.Entry<String, Book> book : viewObj.getAllBooks().entrySet()) {
                    System.out.print(book.getKey() + "\t");
                    System.out.println(book.getValue().displayAllBooks());
                }
            }
        }
        else if(option==LibrarianOptions.VIEW_AVAILABLE_BOOKS) {
            if (viewObj.getAvailableBooks().isEmpty())
                return "Sorry no books are available now to show you";
            else {
                System.out.println("ISBN \t\t\t\t\t BOOK NAME \t\t\t AUTHOR NAME \t\t\t GENRE \t\t\t AVAILABLE COUNT");
                for (Map.Entry<String, Book> book : viewObj.getAvailableBooks().entrySet()) {
                    System.out.print(book.getKey() + "\t\t");
                    System.out.println(book.getValue().display());
                }
            }
        }
        else if(option==LibrarianOptions.VIEW_ALL_CUSTOMERS){
            if(obj.viewAllCustomer().isEmpty())
                return "Sorry no customers are available now to show you";
            else{
                System.out.println("CUSTOMER NAME \t\t\t CUSTOMER USERID");
                for(Map.Entry<String,Customer> customer:obj.viewAllCustomer().entrySet()){
                System.out.println(customer.getValue().name+" \t "+customer.getValue().userID );
            }
        }}
        else if(option==LibrarianOptions.VIEW_RENTED_BOOKS) {
            if (obj.viewRentedBooks().isEmpty())
                return "Sorry no books are available now to show you";
            else {
                System.out.println("ISBN \t\t\t CUSTOMER USERID");
                for (Map.Entry<String, String> rented : obj.viewRentedBooks().entrySet()) {
                    System.out.println(rented.getKey() + " \t " + rented.getValue());
                }
            }
        }
        else
            return "Invalid option";
        return "";
    }
    public String addBook(ArrayList<Object> values){
        return obj.addBook(new Book(values.get(0).toString(),values.get(1).toString(),values.get(2).toString(),(BookGenre) values.get(3),(int)values.get(4)));
    }

    public String removeBook(String ISBN){
        return obj.removeBook(ISBN);
    }

}
