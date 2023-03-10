package controller;

import database.DatabaseHandler;
import javafx.util.Pair;
import model.user.Customer;
import view.application.CustomerMenu;
import view.application.LibrarianMenu;


public class PersonAccess {
    private final DatabaseHandler databaseHandler = new DatabaseHandler();

    public String signIn(String userName, String password) {
        Customer customer = new Customer(userName, password, userName + "CUS#");
            return databaseHandler.addCustomer(customer.userID, password, customer);
        }

    public String logIn(String userID, String password) {
        if (userID.contains("CUS")) {
            String returnCustomerValue = databaseHandler.loginCustomer(userID, password);
            if(returnCustomerValue.equals("Login successful"))
                new CustomerMenu().customerMenu(returnCustomerValue);
            else
                return returnCustomerValue;
        } else {
            String returnLibrarianValue=databaseHandler.loginLibrarian(userID, password);
            if(returnLibrarianValue.equals("Librarian login successful"))
                new LibrarianMenu().menu(returnLibrarianValue);
            else
                return returnLibrarianValue;
        }
        return "";
    }
    public String logoutLibrarian(){
            return databaseHandler.logoutLibrarian();
    }
    public String logoutCustomer(){
        return databaseHandler.logoutCustomer();
    }

}


