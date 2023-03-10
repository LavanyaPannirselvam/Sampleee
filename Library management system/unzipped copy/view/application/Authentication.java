package view.application;

import controller.PersonAccess;

import java.util.Scanner;
public class Authentication {
    private final Scanner scan=new Scanner(System.in);
    private final PersonAccess personAccess = new PersonAccess();
    public String signIn()
    {
        String name=getAndSetName();
        String password=getAndSetPassword();
        return personAccess.signIn(name,password);
    }

    private String getAndSetName() {
        String name ;
        do{
        System.out.println("Enter your name:");
         name=scan.nextLine();
         if (!isCorrect(name.trim()) || name.length() < 3) {
            System.out.println(
                    "Name should contain only alphabets ,only single space between your first and last name and should have atleast 3 characters");
        }}while(!isCorrect(name.trim()) || name.length() < 3);
        return name.trim();
    }

    private String getAndSetPassword() {
        String password ;
        do{
            System.out.println("Enter your password to login further of atleast 5 characters:");
            password= scan.nextLine();
            if(password.trim().isEmpty())
                System.out.println("Invalid password");
            else if(password.length()<5)
                System.out.println("Password is not of length 5");
        }while(password.length()<5||password.trim().isEmpty());
        return password;
    }

    private boolean isCorrect(String name) {
        String pattern = "^[a-zA-Z]+( [a-zA-Z]+)*$";
        return name.matches(pattern);
    }

    public String login(){
        String userID=getUserID();
        String password=getPassword();
        return personAccess.logIn(userID,password);

    }

    private String getUserID() {
        String userID;
        do {
            System.out.println("Enter your userID:");
            userID = scan.nextLine();
            if (!userID.contains("CUS") && !userID.contains("LIB")) {
                System.out.println("Invalid userID");
            }
        } while (!userID.contains("CUS") && !userID.contains("LIB"));
        return userID;
    }
    private String getPassword()
    {
        String password;
        do{
        System.out.println("Enter your password:");
        password= scan.nextLine();
        if(password.trim().isEmpty()){
            System.out.println("Invalid password");
        }
//        if (password.length() == 0) {
//            System.out.println("Password cannot be empty");
//            return getPassword();
        }while(password.trim().isEmpty());
        return password;
    }

}
