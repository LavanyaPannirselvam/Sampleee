package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.CheckCurrentUser;
import controller.ShowProfile;

public class Filters {
    ShowProfile sp = new ShowProfile();
    Scanner s = new Scanner(System.in);

    public String getFilters() {
        if (!CheckCurrentUser.checkCurrentUser())
            return "Login yourself to proceed further!";
        Mainloop: while (true) {
            try {
                System.out.println("You want to view profiles \n1.without filters \n2.with filters \n0.Exit");
                int choice = s.nextInt();
                s.nextLine();
                switch (choice) {
                    case 0:
                        break Mainloop;
                    case 1:
                        System.out.println(sp.showWithoutFilters());
                        getAdditionalFilters();
                        break;
                    case 2:
                        filterOption();
                        break;
                    default:
                        System.out.println("Enter correct option!!");
                        continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter correct format input!!");
                s.nextLine();
                continue;
            }
        }
        return "";
    }

    private void filterOption() {
        Mainblock :while (true) {
            System.out.println("Filter based on: \n1.Age\n2.Occupation\n3.Living city\n4.Marital status\n0.Exit");
            try {
                int option = s.nextInt();
                s.nextLine();
                switch (option) {
                    case 0:
                        break Mainblock;
                    case 1:
                        System.out.println("Enter the age you want:");
                        System.out.println(sp.showWithFilterAge(s.nextInt()));
                        getAdditionalFilters();
                        break;

                    case 2:
                        System.out.println("Enter the Occupation you want:");
                        System.out.println(sp.showWithFilters(s.next(), option));
                        getAdditionalFilters();
                        break;

                    case 3:
                        System.out.println("Enter the Living City you want:");
                        System.out.println(sp.showWithFilters(s.next(), option));
                        getAdditionalFilters();
                        break;

                    case 4:
                        System.out.println("Enter the Marital Status you want(Single/Divorced/Widow):");
                        System.out.println(sp.showWithFilters(s.next(), option));
                        getAdditionalFilters();
                        break;
                    default:
                        System.out.println("Enter correct input!!");
                        continue;
                }

            } catch (InputMismatchException e) {
                System.out.println("Enter correct format input!!");
                s.nextLine();
                continue;
            }
        }
    }

    private void getAdditionalFilters() {
        Mainblock:while (true) {
            System.out.println(
                    "Want to see all details of another profile click 1 else 0");
            try {
                int choice=s.nextInt();
                s.nextLine();
                switch (choice) {
                    case 0:
                        break Mainblock;
                    case 1:
                        System.out.println("Enter the username of the profile to view more:");
                        System.out.println(sp.showAll(s.next()));
                        break;
                    default:
                        System.out.println("Enter correct option!!");
                        continue;
                        
                }
            }catch(InputMismatchException e)
            {
                System.out.println("Enter correct format input!!");
                s.nextLine();
                continue;
            }
        }
    }
}
