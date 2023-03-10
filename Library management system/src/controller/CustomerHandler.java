package controller;
import view.ui.enums.CustomerOptions;
import database.HandlerFactory;
import database.interfaces.CustomerOperations;
import database.interfaces.ViewOperations;
import model.book.Book;
import java.util.Map;
import static view.ui.enums.PersonRoles.CUSTOMER;

public class CustomerHandler {
    private final CustomerOperations obj = HandlerFactory.getCustomerHandlerObject(CUSTOMER);
    private final ViewOperations viewObj= (ViewOperations) obj;
    public String display(CustomerOptions option){
        if(option==CustomerOptions.VIEW_ALL_BOOKS){
            if(viewObj.getAllBooks().isEmpty())
                return "Sorry no books are available now to show you";
            else{
                System.out.println("ISBN \t\t\t\t\t BOOK NAME \t\t\t AUTHOR NAME \t\t\t GENRE ");
                for(Map.Entry<String ,Book> book:viewObj.getAllBooks().entrySet()){
                System.out.print(book.getKey()+"\t");
                System.out.println(book.getValue().displayAllBooks());
            }
            }
        }
        else if(option==CustomerOptions.VIEW_AVAILABLE_BOOKS){
            if(viewObj.getAvailableBooks().isEmpty())
                return "Sorry no books are available now to show you";
            else{
                System.out.println("ISBN \t\t\t\t\t BOOK NAME \t\t\t AUTHOR NAME \t\t\t GENRE \t\t\t AVAILABLE COUNT");
                for(Map.Entry<String,Book> book:viewObj.getAvailableBooks().entrySet()){
                System.out.print(book.getKey()+"\t");
                System.out.println(book.getValue().display());
            }
        }}
        else
            return "Invalid option";
        return "";
    }
    public String borrowBook(String ISBN){
        return obj.borrowBook(ISBN);
    }
    public String returnBook(String ISBN){
        return obj.returnBook(ISBN);
    }


}
