package view;

import java.util.InputMismatchException;
import java.util.Scanner;


import controller.CheckCurrentUser;
import controller.CreateProfile;
import model.Gender;
import model.Horoscope;
import model.MaritalStatus;

public class Registration {
    String name;
    int age;
    Gender gender;
    MaritalStatus maritalStatus;
    String occupation;
    String livingCity;
    long salary;
    String phoneNumber;
    String nativeCity;
    Horoscope horoscope;
    String fatherName;
    String motherName;
    int sisters;
    int brothers;
    float height;
    float weight;
    String pswd;
    Scanner s = new Scanner(System.in);
    Scanner i;

    public String register() {
        if (CheckCurrentUser.checkCurrentUser())
            return "Already registered and logged in";
        getAndSetName();
        getAndSetAge();
        getAndSetGender();
        getAndSetOccupation();
        getAndSetSalary();
        getAndSetPhoneNumber();
        getAndSetMaritalStatus();
        getAndSetLivingCity();
        getAndSetNativeCity();
        getAndSetHoroscope();
        getAndSetFatherName();
        getAndSetMotherName();
        getAndSetSisters();
        getAndSetBrothers();
        getAndSetHeight();
        getAndSetWeight();
        getAndSetPassword();
        CreateProfile cp = new CreateProfile();
        return cp.completeProfile(name, age, gender, maritalStatus, occupation, livingCity, salary, phoneNumber,
                nativeCity,
                horoscope, fatherName, motherName, sisters, brothers, height, weight, pswd);
    }

    private void getAndSetName() {
        System.out.println("Enter your name:");
        name = s.nextLine();
        if (!isCorrect(name.trim()) || name.length() < 3) {
            System.out.println(
                    "Name should contain only alphabets ,only single space between your first and last name and should have atleast 3 characters");
            getAndSetName();
        }
    }

    private void getAndSetAge() {
        int value = 0;
        i = new Scanner(System.in);
        System.out.println("Enter your age:");
        try {
            value = i.nextInt();
            i.nextLine();
            if (value < 18 || value > 70) {
                System.out.println("Your age should be greater than 18 and less than 70 as per guidelines ");
                getAndSetAge();
            }
            age = value;
        } catch (InputMismatchException e) {
            System.out.println("Wrong format input");
            getAndSetAge();
        }

    }

    private void getAndSetGender() {
        i = new Scanner(System.in);
        int value;
        Mainblock: while (true) {
            System.out.println("Gender :\n 1.Female \t 2.Male");
            try {
                value = i.nextInt();
                i.nextLine();
                switch (value) {
                    case 1:
                        gender = Gender.FEMALE;
                        break Mainblock;
                    case 2:
                        gender = Gender.MALE;
                        break Mainblock;
                    default:
                        System.out.println("Invalid selection");
                        continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input format");
                i.nextLine();
                continue;
            }
        }
    }

    private void getAndSetOccupation() {
        System.out.println("Enter your occupation:");
        occupation = s.nextLine();
        if (!isCorrect(occupation.trim()) || occupation.length() < 3) {
            System.out.println("Occupation should contain only alphabets and only single space between them and should have atleast 3 characters");
            getAndSetOccupation();
        }

    }

    private void getAndSetSalary() {
        i = new Scanner(System.in);
        System.out.println("Enter your salary:");
        try {
            salary = i.nextLong();
            i.nextLine();
            if (salary <= 0) {
                System.out.println("Salary should not be negative or zero");
                getAndSetSalary();
            }
        } catch (InputMismatchException e) {
            System.out.println("Enter numbers only");
            i.nextLine();
            getAndSetSalary();
        }
    }

    private void getAndSetPhoneNumber() {
        s = new Scanner(System.in);
        System.out.println("Enter your mobile number:");
        phoneNumber = i.nextLine();
        if (!phoneNumber.matches("^[0-9]{1,10}") || phoneNumber.length() != 10 || 0==Long.parseLong(phoneNumber)) {
            System.out.println("Enter correct format and upto 10 digits is allowed!!");
            getAndSetPhoneNumber();
        }
    }

    private void getAndSetMaritalStatus() {
        i = new Scanner(System.in);
        int value;
        Mainblock: while (true) {
            System.out.println("Enter your marital status: \n 1.Single \t 2.Divorced \t 3.Widowed");
            try {
                value = i.nextInt();
                i.nextLine();
                switch (value) {
                    case 1:
                        maritalStatus = MaritalStatus.SINGLE;
                        break Mainblock;
                    case 2:
                        maritalStatus = MaritalStatus.DIVORCED;
                        break Mainblock;
                    case 3:
                        maritalStatus = MaritalStatus.WIDOW;
                        break Mainblock;
                    default:
                        System.out.println("Invalid Selection");
                        continue;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input format");
                i.nextLine();
                continue;
            }
        }
    }

    private void getAndSetLivingCity() {
        System.out.println("Enter your Living city:");
        livingCity = s.nextLine();
        if (!isCorrect(livingCity.trim()) || livingCity.length() < 3) {
            System.out.println(
                    "Living city should contain only alphabets and only single space between them and should have atleast 3 characters");
            getAndSetLivingCity();
        }
    }

    private void getAndSetNativeCity() {
        System.out.println("Enter your Native city:");
        nativeCity = s.nextLine();
        if (!isCorrect(nativeCity.trim()) || nativeCity.length() < 3) {
            System.out.println(
                    "Native city should contain only alphabets and only single space between them and should have atleast 3 characters");
            getAndSetNativeCity();
        }
    }

    private void getAndSetHoroscope() {
        i = new Scanner(System.in);
        int value;
        Mainblock: while (true) {
            System.out.println(
                    "Enter your Horoscope: \n1.ARIES\t2.TAURUS\t3.CANCER\t4.GEMINI\t5.LEO\t6.VIRGO\n7.LIBRA\t8.SCORPIO\t9.SAGITTARIUS\t10.CAPRICORN\t11.AQUARIUS\t12.PISCES");
            try {
                value = i.nextInt();
                i.nextLine();
                switch (value) {
                    case 1:
                        horoscope = Horoscope.ARIES;
                        break Mainblock;
                    case 2:
                        horoscope = Horoscope.TAURUS;
                        break Mainblock;
                    case 3:
                        horoscope = Horoscope.CANCER;
                        break Mainblock;
                    case 4:
                        horoscope = Horoscope.GEMINI;
                        break Mainblock;
                    case 5:
                        horoscope = Horoscope.LEO;
                        break Mainblock;
                    case 6:
                        horoscope = Horoscope.VIRGO;
                        break Mainblock;
                    case 7:
                        horoscope = Horoscope.LIBRA;
                        break Mainblock;
                    case 8:
                        horoscope = Horoscope.SCORPIO;
                        break Mainblock;
                    case 9:
                        horoscope = Horoscope.SAGITTARIUS;
                        break Mainblock;
                    case 10:
                        horoscope = Horoscope.CAPRICORN;
                        break Mainblock;
                    case 11:
                        horoscope = Horoscope.AQUARIUS;
                        break Mainblock;
                    case 12:
                        horoscope = Horoscope.PISCES;
                        break Mainblock;
                    default:
                        System.out.println("Invalid selection");
                        continue;

                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input format");
                i.nextLine();
                continue;
            }
        }
    }

    private void getAndSetFatherName() {
        System.out.println("Enter your Father's name:");
        fatherName = s.nextLine();
        if (!isCorrect(fatherName.trim()) || fatherName.length() < 3) {
            System.out.println(
                    "Father Name should contain only alphabets, only single space between first and last name and should have atleast 3 characters");
            getAndSetFatherName();
        }
    }

    private void getAndSetMotherName() {
        System.out.println("Enter your Mother's name:");
        motherName = s.nextLine();
        if (!isCorrect(motherName.trim()) || motherName.length() < 3) {
            System.out.println(
                    "Mother name should contain only alphabets, only single space between first and last name and should have atleast 3 characters");
            getAndSetMotherName();
        }
    }

    private void getAndSetSisters() {
        i = new Scanner(System.in);
        Mainblock: while (true) {
            System.out.println("Enter number of sisters you have:");
            try {
                String value = i.nextLine();
                if (!value.matches("^[0-9]*$")) {
                    System.out.println("Sister count cannot contain special characters");
                    continue;
                }
                sisters = Integer.parseInt(value);
                if (sisters > 20) {
                    System.out.println("Sister count cannot be more than 20");
                    continue;
                }
                break Mainblock;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input format");
                i.nextLine();
                continue;
            }
        }
    }

    private void getAndSetBrothers() {
        i = new Scanner(System.in);
        Mainblock: while (true) {
            System.out.println("Enter number of brothers you have:");
            try {
                String value = i.nextLine();
                if (!value.matches("^[0-9]*$")) {
                    System.out.println("Brother count cannot contain special characters");
                    continue;
                }
                brothers = Integer.parseInt(value);
                if (brothers > 20) {
                    System.out.println("Brother count cannot be more than 20");
                    continue;
                }
                break Mainblock;
            } catch (InputMismatchException e) {
                System.out.println("Invalid input format");
                i.nextLine();
                continue;
            }
        }
    }

    private void getAndSetHeight() {
        i = new Scanner(System.in);
        System.out.println("Enter your height(in cms):");
        try {
            height = i.nextInt();
            i.nextLine();
            if (height <= 20 || height > 400) {
                System.out.println("Height should be greater than 20 cms and less than 400 cms");
                getAndSetHeight();
            }
        } catch (InputMismatchException e) {
            System.out.println("Height should contain only numbers");
            getAndSetHeight();
        }
    }

    private void getAndSetWeight() {
        i = new Scanner(System.in);
        System.out.println("Enter your weight(in kgs):");
        try {
            weight = i.nextFloat();
            i.nextLine();
            if (weight <= 10 || weight > 150) {
                System.out.println("Weight should be greater than 10 kgs and less than 150 kgs");
                getAndSetWeight();
            }
        } catch (InputMismatchException e) {
            System.out.println("Weight should contain only numbers");
            getAndSetWeight();
        }
    }

    private void getAndSetPassword() {
        System.out.println("Enter your password to login further of atleast 5 characters:");
        pswd = s.nextLine();
        if (pswd.length() < 5) {
            System.out.println("Password should be atleast 5 characters long");
            getAndSetPassword();
        }
    }

    private boolean isCorrect(String name) {
        String pattern = "^[a-zA-Z]+( [a-zA-Z]+)*$";
        return name.matches(pattern);
    }


}
