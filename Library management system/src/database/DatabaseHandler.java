package database;

import database.interfaces.DatabaseOperations;
import model.user.Customer;

public class DatabaseHandler implements DatabaseOperations {
    private final Database database = Database.getInstance();
    @Override
    public String addCustomer(String userID,String password,Customer customer) {
        return database.addCustomers(userID,password,customer);
    }
    @Override
    public String loginCustomer(String userID,String password){
        if(database.getCustomerCredentials().containsKey(userID)){
            if(password.equals(database.getCustomerCredentials().get(userID))){
                database.setCurrentCustomer(database.getCustomerInstance(userID));
                return "Login successful";
            }else
                return "Wrong password";
        }else
            return "Customer not found";

    }
    @Override
    public String loginLibrarian(String userID, String password){
        if(database.librarian.userID.equals(userID)){
            if(password.equals(database.librarianPassword)){
                database.isLibrarian =true;
                return "Librarian login successful";
            }
            else {
                return "Wrong password";
            }
        }
        else return "Librarian not found";
    }
    @Override
    public String logoutCustomer(){
        return database.logoutCustomer();
    }
    @Override
    public String logoutLibrarian(){
        database.isLibrarian =false;
        return "Logged out successfully";
    }


}
