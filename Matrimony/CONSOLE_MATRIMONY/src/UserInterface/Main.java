package UserInterface;

import java.util.InputMismatchException;
import java.util.Scanner;

import user.User;

public class Main {
    static Scanner scan = new Scanner(System.in);
    public static void mainmenu() {
        System.out.println("Welcome!!");
        while (true) {
            System.out
                    .println("------Menu------\n 1.Register\n 2.My Profile \n 3.View my matches \n 4.Logout \n 5.Exit");
            System.out.println("Enter your option:");
            try {
                int option = scan.nextInt();
                switch (option) {
                    case 1:
                        register();
                        break;
                    case 2:
                        login();
                        break;
                    case 3:
                        viewProfiles();
                        break;
                    case 4:
                        logout();
                        break;
                    case 5:
                        System.out.println("Exited successfully");
                        scan.close();
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Enter correct option!!");
                        break;
                }
            } catch (InputMismatchException e) {
                scan.next();
                System.out.println("Check your input format!!");
            }
        }
    }

    private static void register() {
        User user = SignUp();
        if (user == null) {
            System.out.println("Registration unsuccessful!!");
            return;
        }
        System.out.println("Registration Successful!!");
        System.out.println("Registration Successful!\nNow setup password for you account");
        //System.out.println("Your username is:" + user.getUserName());
        System.out.println("Set password for your account:");
        String pswd = scan.next();
        System.out.println("Re-enter password:");
        boolean status = (scan.next().equals(pswd));
        if (status) {
            Credentials c = new Credentials();
            c.setCredentials(user, pswd);
            System.out.println("Your username is:" + user.getUserName() + " and password is:" + pswd);
        }
    }

    public static void login() {
        System.out.println("Enter your username:");
        Scanner scan=new Scanner(System.in);
        String uname=scan.next();
        System.out.println("Enter your password");
        String pwsd=scan.next();
    };

    public static void viewProfiles() {
    };

    public static void logout() {
    };

    static User SignUp() {
        String Father_name;
        String Mother_name;
        String name;
        int age;
        String occupation;
        String livingCity;
        long salary;
        String nativeCity;
        String horoscope;
        int siblings;
        int sisters;
        int brothers;
        float height;
        float weight;
        String marital_status;
        String gender;
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("Enter your name:");
            name = s.nextLine();
            System.out.println("Enter your age:");
            age = s.nextInt();
            if (age < 18) {
                System.out.println("Your age should be greater than 18 as per guidelines");
                return null;
            }
            System.out.println("Are you a(bride/groom):");
            gender = s.next();
            System.out.println("Enter your occupation:");
            occupation = s.next();
            System.out.println("Enter your salary:");
            salary = s.nextLong();
            System.out.println("Enter your marital status:");
            marital_status = s.next();
            System.out.println("Enter your Living city:");
            livingCity = s.next();
            System.out.println("Enter your Native city:");
            nativeCity = s.next();
            System.out.println("Enter your Horoscope:");
            horoscope = s.next();
            System.out.println("Enter your Father's name:");
            Father_name = s.next();
            System.out.println("Enter your Mother's name:");
            Mother_name = s.next();
            System.out.println("Enter number of siblings you have:");
            siblings = s.nextInt();
            System.out.println("Enter number of sisters you have:");
            sisters = s.nextInt();
            System.out.println("Enter number of brothers you have:");
            brothers = s.nextInt();
            System.out.println("Enter your height(in cms):");
            height = s.nextFloat();
            System.out.println("Enter your weight(in kgs):");
            weight = s.nextFloat();
        } catch (InputMismatchException e) {
            System.out.println("Enter correct format input!!");
            return null;
        }
        User r = new User(name, age, gender, marital_status, occupation, livingCity, salary, nativeCity,
                horoscope, Father_name, Mother_name, siblings, sisters, brothers, height, weight);
        return r;
    }

    static void signIn() {
    };

    public static void main(String[] args) {
        mainmenu();
    }
}
