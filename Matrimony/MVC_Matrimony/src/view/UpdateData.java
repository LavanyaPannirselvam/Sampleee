package view;

import java.util.InputMismatchException;
import java.util.Scanner;

import controller.ChangeData;
import controller.CheckCurrentUser;

public class UpdateData {
    int age;
    String livingCity;
    String occupation;
    long salary;
    String phoneNumber;
    float weight;
    String pswd;
    Scanner s = new Scanner(System.in);
    Scanner i;

    public String changeDetails() {
        if (!CheckCurrentUser.checkCurrentUser())
            return "Login yourself to proceed further";
        ChangeData changeData = new ChangeData();
        Mainblock: while (true) {
            System.out.println("Choose the option to change your saved data");
            System.out.println(
                    "0.Exit\n1.Age\n2.Living City\n3.Occupation\n4.Salary\n5.Phone number\n6.Weight\n7.Password");
            try {
                int choice = s.nextInt();
                s.nextLine();
                switch (choice) {
                    case 0:
                        break Mainblock;
                    case 1:
                        getAge();
                        System.out.println(changeData.updateAge(age));
                        break;
                    case 2:
                        getLivingCity();
                        System.out.println(changeData.updateLivingCity(livingCity));
                        break;
                    case 3:
                        getOccupation();
                        System.out.println(changeData.updateOccupation(occupation));
                        break;
                    case 4:
                        getSalary();
                        System.out.println(changeData.updateSalary(salary));
                        break;
                    case 5:
                        getPhoneNumber();
                        System.out.println(changeData.updatePhonenumber(phoneNumber));
                        break;
                    case 6:
                        getWeight();
                        System.out.println(changeData.updateWeight(weight));
                        break;
                    case 7:
                        getPassword();
                        System.out.println(changeData.updatePassword(pswd));
                        break;
                    default:
                        System.out.println("Invalid selection");
                        continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input format");
                s.nextLine();
                continue;
            }
        }
        return "";
    }

    private void getAge() {
        System.out.println("Enter new age ");
        try {
            age = s.nextInt();
            s.nextLine();
            if (age < 18 || age > 70) {
                System.out.println("Your age should be greater than 18 and less than 70 as per guidelines ");
                getAge();
            }
        } catch (InputMismatchException e) {
            System.out.println("Wrong format input");
            s.nextLine();
            getAge();
        }
    }

    private void getLivingCity() {
        System.out.println("Enter new Living city:");
        livingCity = s.nextLine();
        if (!isCorrect(livingCity.trim()) || livingCity.length() < 3) {
            System.out.println(
                    "Living city should contain only alphabets and only single space between them and should have atleast 3 characters");
            getLivingCity();
        }
    }

    private void getOccupation() {
        System.out.println("Enter new occupation:");
        occupation = s.nextLine();
        if (!isCorrect(occupation.trim()) || occupation.length() < 3) {
            System.out.println(
                    "Occupation should contain only alphabets and only single space between them and should have atleast 3 characters");
            getOccupation();
        }
    }

    private void getSalary() {
        i = new Scanner(System.in);
        System.out.println("Enter new salary:");
        try {
            salary = i.nextLong();
            i.nextLine();
            if (salary <= 0) {
                System.out.println("Salary should not be negative or zero");
                getSalary();
            }
        } catch (InputMismatchException e) {
            System.out.println("Enter numbers only");
            i.nextLine();
            getSalary();
        }
    }

    private void getPhoneNumber() {
        s = new Scanner(System.in);
        System.out.println("Enter new mobile number:");
        phoneNumber = i.nextLine();
        if (!phoneNumber.matches("^[0-9]{1,10}") || phoneNumber.length() != 10 || 0 == Long.parseLong(phoneNumber)) {
            System.out.println("Enter correct format and upto 10 digits is allowed!!");
            getPhoneNumber();
        }
    }

    private void getWeight() {
        i = new Scanner(System.in);
        System.out.println("Enter new weight(in kgs):");
        try {
            weight = i.nextFloat();
            i.nextLine();
            if (weight <= 10 || weight > 150) {
                System.out.println("Weight should be greater than 10 kgs and less than 150 kgs");
                getWeight();
            }
        } catch (InputMismatchException e) {
            System.out.println("Weight should contain only numbers");
            getWeight();
        }
    }

    private void getPassword() {
        System.out.println("Enter new password to login further:");
        pswd = s.nextLine();
        if (pswd.length() < 5) {
            System.out.println("Password should be atleast 5 characters long");
            getPassword();
        }
    }

    private boolean isCorrect(String name) {
        String pattern = "^[a-zA-Z]+( [a-zA-Z]+)*$";
        return name.matches(pattern);
    }

}
