package database;

import view.ui.enums.PersonRoles;
import static view.ui.enums.PersonRoles.*;

public class HandlerFactory {
    private static final Database database = Database.getInstance();

    public static CustomerDBHandler getCustomerHandlerObject(PersonRoles role){
       if(role.equals(CUSTOMER) && database.getAllCustomers().containsKey(database.getCurrentCustomer().userID))
            return new CustomerDBHandler();
       return null;
    }
    public static LibrarianDBHandler getLibrarianHandlerObject() {
       if(database.isLibrarian)
            return new LibrarianDBHandler();
       return null;
    }


}
