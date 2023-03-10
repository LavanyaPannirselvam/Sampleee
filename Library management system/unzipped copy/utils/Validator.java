package utils;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Validator {
    static Scanner scan=new Scanner(System.in);
    public static int getIntInRange(int max) {
        int num = 0;
        try {
            num = scan.nextInt();
            scan.nextLine();
            if (num > 0 && num <= max)
                return num;
            else {
                System.out.println("Wrong option entered!\nChoose your option:");
                return getIntInRange(max);
            }
        } catch (InputMismatchException e) {
            System.out.println("Wrong format input\nEnter the correct option");
            scan.nextLine();
            return getIntInRange(max);
        }
    }
    public static String getISBN(){
        System.out.println("Enter the ISBN number of the book :");
        String input=scan.nextLine();
        if(!input.matches("^[0-9]{1,3}-[0-9]{1,2}-[0-9]{1,5}-[0-9]{1,2}-[0-9]")){
            System.out.println("Enter correct ISBN number");
            getISBN();
        }
        return input;
    }
}

