package database.interfaces;

import javafx.util.Pair;
import model.user.Customer;

public interface DatabaseOperations {
    String addCustomer(String userID,String password,Customer customer);
    String loginCustomer(String userID, String password);
    String loginLibrarian(String userID, String password);
    String logoutCustomer();
    String logoutLibrarian();
}
