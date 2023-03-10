package view.application;

import controller.CustomerHandler;
import controller.PersonAccess;
import utils.Validator;
import view.ui.enums.CustomerOptions;

import static view.ui.enums.CustomerOptions.VIEW_ALL_BOOKS;
import static view.ui.enums.CustomerOptions.VIEW_AVAILABLE_BOOKS;

public class CustomerMenu {
    private final CustomerHandler customerHandler = new CustomerHandler();
    private final PersonAccess personAccess = new PersonAccess();
    public void customerMenu(String msg){
        System.out.println(msg);
        while(true){
            for(CustomerOptions options:CustomerOptions.values())
                System.out.println(options.ordinal()+1+" . "+options.name());
            int option= Validator.getIntInRange(CustomerOptions.values().length);
            CustomerOptions choice = CustomerOptions.values()[option-1];
            switch(choice){
                case VIEW_ALL_BOOKS:
                    System.out.println(customerHandler.display(VIEW_ALL_BOOKS));break;
                case VIEW_AVAILABLE_BOOKS:
                    System.out.println(customerHandler.display(VIEW_AVAILABLE_BOOKS));break;
                case BORROW_BOOK:
                    System.out.println(customerHandler.borrowBook(Validator.getISBN()));break;
                case RETURN_BOOK:
                    System.out.println(customerHandler.returnBook(Validator.getISBN()));break;
                case LOGOUT:
                    System.out.println(personAccess.logoutCustomer());return;
            }
        }
    }
}
