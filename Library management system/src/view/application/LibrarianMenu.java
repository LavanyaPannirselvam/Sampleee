package view.application;

import controller.LibrarianHandler;
import controller.PersonAccess;
import utils.Validator;
import view.CollectLibrarianInput;
import view.ui.enums.LibrarianOptions;

import static view.ui.enums.LibrarianOptions.*;

public class LibrarianMenu {
    private final LibrarianHandler librarianHandler = new LibrarianHandler();
    private final PersonAccess personAccess = new PersonAccess();

    public void menu(String msg){
        System.out.println(msg);
        while(true){
            for(LibrarianOptions options: LibrarianOptions.values())
                System.out.println(options.ordinal()+1+" . "+options.name());
            int option= Validator.getIntInRange(LibrarianOptions.values().length);
            LibrarianOptions choice = LibrarianOptions.values()[option-1];
            switch(choice){
                case VIEW_ALL_BOOKS:
                    System.out.println(librarianHandler.display(VIEW_ALL_BOOKS));break;
                case VIEW_AVAILABLE_BOOKS:
                    System.out.println(librarianHandler.display(VIEW_AVAILABLE_BOOKS));break;
                case ADD_BOOK:
                    System.out.println(librarianHandler.addBook(CollectLibrarianInput.getBookInput()));break;
//                case REMOVE_BOOK:
//                    System.out.println(librarianHandler.removeBook(Validator.getISBN()));break;
                case VIEW_RENTED_BOOKS:
                    System.out.println(librarianHandler.display(VIEW_RENTED_BOOKS));break;
                case VIEW_ALL_CUSTOMERS:
                    System.out.println(librarianHandler.display(VIEW_ALL_CUSTOMERS));break;
                case LOGOUT:
                    System.out.println(personAccess.logoutLibrarian());return;
            }
        }
    }
}
