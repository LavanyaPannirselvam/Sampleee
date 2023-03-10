package database;

import java.util.*;
import model.*;

public class DB {

    private static Set<User> userAccounts = new HashSet<>();

    private DB() {
    };

    private User currentUser = null;

    private static DB db = new DB();

    static DB getDB() {
        return db;
    }

    void setCurrentUser(User u) {
        currentUser = u;
    }

    User getCurrentUser() {
        return currentUser;
    }

    Set<User> giveDB() {
        return new HashSet<>(userAccounts);
    }

    String addUser(User u) {
        userAccounts.add(u);
        return u.getUserName();
    }

    String removeUser(User u) {
        setCurrentUser(null);
        userAccounts.remove(u);
        return "Your profile removed successfully!!Thankyou for choosing us";
    }

    User u1 = new User("Divakar", 32, Gender.MALE, MaritalStatus.SINGLE, "UI Designer", "Chennai", 10000000,
            "9876543210", "Trichy",
            Horoscope.LIBRA, "Ganapathy", "Shanthi", 1, 0, 170, 65, "diva123");
    String msg1 = addUser(u1);
    User u2 = new User("Lavanya", 23, Gender.FEMALE, MaritalStatus.SINGLE, "Engineer", "Chennai", 5600000, "8957645321",
            "Thanjavur",
            Horoscope.ARIES, "Pannir", "Viji", 1, 0, 165, 57, "lav5702");
    String msg2 = addUser(u2);
    User u3 = new User("Abishek", 23, Gender.MALE, MaritalStatus.DIVORCED, "Engineer", "Chennai", 8000000, "9576345123",
            "Chennai",
            Horoscope.VIRGO, "Senthil", "Shanthi", 1, 0, 175, 60, "123789");
    String msg3 = addUser(u3);
    User u4 = new User("Senthil", 29, Gender.MALE, MaritalStatus.WIDOW, "Doctor", "Chennai", 25000000, "6784536587",
            "Chennai",
            Horoscope.GEMINI, "Kumar", "Lakshmi", 0, 0, 189, 75, "dr.Se");
    String msg4 = addUser(u4);
    User u5 = new User("Rekha", 35, Gender.FEMALE, MaritalStatus.DIVORCED, "Teacher", "Thiruvanamalai", 200000,
            "9874123546",
            "Thiruvanamalai", Horoscope.TAURUS, "Moorthi", "Rama", 0, 2, 145, 65, "rekHaM");
    String msg5 = addUser(u5);
    User u6 = new User("Sathya", 28, Gender.FEMALE, MaritalStatus.WIDOW, "Doctor", "Kerala", 450000, "9845837534",
            "Delhi",
            Horoscope.ARIES, "Tilak", "Devi", 0, 0, 140, 50, "12345678");
    String msg6 = addUser(u6);
}
