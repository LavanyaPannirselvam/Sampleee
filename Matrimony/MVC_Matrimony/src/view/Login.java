package view;

import java.util.Scanner;

import controller.CheckCurrentUser;
import controller.CheckProfile;

public class Login {
    static Scanner s = new Scanner(System.in);
    String userName;
    String pswd;
    public String signIn() {
        if (CheckCurrentUser.checkCurrentUser())
            return "Already logged in";
        getAndSetUserName();
        getAndSetPassword();
        CheckProfile profile = new CheckProfile();
        return profile.checkSignIn(userName, pswd);
    }

    private void getAndSetUserName()
    {
        System.out.println("Enter your username:");
        userName = s.nextLine();
    }

    private void getAndSetPassword()
    {
        System.out.println("Enter your password:");
        pswd = s.nextLine();
        if (pswd.length() == 0) {
            System.out.println("Password cannot be empty");
            getAndSetPassword();
        }
    }
}
