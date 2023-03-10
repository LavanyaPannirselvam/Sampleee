import java.util.InputMismatchException;
import java.util.Scanner;

import view.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to Matrimony!!!");
        Registration register = new Registration();
        Login login = new Login();
        Logout logout = new Logout();
        MyProfile myprofile = new MyProfile();
        Scanner scan = new Scanner(System.in);
        UpdateData updateData = new UpdateData();        
        while (true) {
            System.out
                    .println(
                            "------Menu------\n 1.Register \n 2.Login \n 3.My Profile \n 4.View my matches \n 5.Change Data \n 6.Logout \n 7.Remove Profile \n 8.Exit");
            System.out.println("Enter your option:");
            try {
                int option = scan.nextInt();
                scan.nextLine();
                switch (option) {
                    case 1:
                        System.out.println(register.register());
                        break;
                    case 2:
                        System.out.println(login.signIn());
                        break;
                    case 3:
                        System.out.println(myprofile.myProfile());
                        break;
                    case 4:
                        System.out.println(new Filters().getFilters());
                        break;
                    case 5:
                        System.out.println(updateData.changeDetails());
                        break;
                    case 6:
                        System.out.println(logout.logout());
                        break;
                    case 7:
                        System.out.println(myprofile.removeMe());
                        break;
                    case 8:
                        System.out.println("Exited successfully");
                        scan.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Enter correct option!!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Check your input format!!");
                scan.nextLine();
            }
        }
    }
}
