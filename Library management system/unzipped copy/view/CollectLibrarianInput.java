package view;
import model.book.BookGenre;
import utils.Validator;
import java.util.ArrayList;
import java.util.Scanner;

public class CollectLibrarianInput {
    static Scanner scan = new Scanner(System.in);
    static String bookName;
    static String ISBN;
    static BookGenre genre;
    static String authorName;
    public static ArrayList<Object> getBookInput(){
        getAndSetBookName();
        getAndSetISBN();
        getAndSetGenre();
        getAndSetAuthorName();
        ArrayList<Object> returnValues= new ArrayList<>();
        returnValues.add(bookName);
        returnValues.add(ISBN);
        returnValues.add(authorName);
        returnValues.add(genre);
        return returnValues;
    }
    private static void getAndSetGenre(){
        System.out.println("Select the Genre of the book : ");
        Mainblock:while(true) {
            for (BookGenre options : BookGenre.values())
                System.out.println(options.ordinal() + 1 + " . " + options.name());
            int option = Validator.getIntInRange(BookGenre.values().length);
            BookGenre choice = BookGenre.values()[option - 1];
            switch (choice) {
                case FICTION:
                    genre = BookGenre.FICTION;
                    break Mainblock;
                case FANTASY:
                    genre = BookGenre.FANTASY;
                    break Mainblock;
                case CRIME:
                    genre = BookGenre.CRIME;
                    break Mainblock;
                case NOVEL:
                    genre = BookGenre.NOVEL;
                    break Mainblock;
                case HISTORY:
                    genre = BookGenre.HISTORY;
                    break Mainblock;
            }
        }
    }
    private static void getAndSetAuthorName() {
        System.out.println("Enter the name of the author : ");
        authorName = scan.nextLine();
        if (authorName.length() == 0) {
            System.out.println("Author name cannot be empty");
            getAndSetAuthorName();}
        else if (!authorName.matches("^[^0-9]+$")) {
                System.out.println("Author name cannot contain numbers");
                getAndSetAuthorName();
            }
        else if(!authorName.matches("^[a-zA-Z]+( [a-zA-Z]+)*$")){
            System.out.println("Author name should have only single space between the first and last name and numbers");
            getAndSetAuthorName();
        }
        }
        private static void getAndSetISBN () {
            System.out.println("Enter the ISBN number of the book :");
            ISBN = scan.nextLine();
            if (ISBN.length() == 0) {
                System.out.println("ISBN cannot be empty");
                getAndSetISBN();
            }
            else if (!ISBN.matches("^[0-9]{1,3}-[0-9]{1,2}-[0-9]{1,5}-[0-9]{1,2}-[0-9]")) {
                System.out.println("Enter correct ISBN number");
                getAndSetISBN();
            }
        }
        private static void getAndSetBookName(){
            System.out.println("Enter the Book name : ");
            bookName = scan.nextLine();
            if(bookName.length()==0){
                System.out.println("Book name cannot be empty");
                getAndSetBookName();
            } else if (!bookName.matches("^[a-zA-Z0-9]+( [a-zA-Z0-9]+)*$")) {
                System.out.println("Book name should contain only single space between the first and the last name");
                getAndSetBookName();

            }
        }
    }
