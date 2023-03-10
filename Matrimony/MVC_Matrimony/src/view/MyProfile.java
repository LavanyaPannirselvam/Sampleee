package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.CheckCurrentUser;
import controller.RemoveProfile;
import controller.ShowProfile;

public class MyProfile {

    public String myProfile() {
        ShowProfile sp = new ShowProfile();
        return sp.showMe();
    }

    Scanner scan = new Scanner(System.in);

    public String removeMe() {
        if (!CheckCurrentUser.checkCurrentUser())
            return "Login yourself to proceed further";
        while (true) {
            System.out.println(
                    "If you remove your profile,you will no longer be able to access the application\nAre you sure to remove your profile?");
            System.out.println("0. No \n1. Yes");
            try {
                int choice = scan.nextInt();
                scan.nextLine();
                switch (choice) {
                    case 0:
                        return "You can proceed further";
                    case 1:
                        RemoveProfile rp = new RemoveProfile();
                        return rp.removeProfile();
                    default:
                        System.out.println("Invalid selection");
                        continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input format");
                scan.nextLine();
                continue;
            }
        }
    }
}