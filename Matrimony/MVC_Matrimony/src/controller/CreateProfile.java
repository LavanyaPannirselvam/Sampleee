package controller;

import database.DBAccess;
import model.*;

public class CreateProfile {
    public CreateProfile() {
    }

    public String completeProfile(String name, int age, Gender gender, MaritalStatus maritalStatus, String occupation,
            String livingCity, long salary, String phoneNumber, String nativeCity, Horoscope horoscope,
            String fatherName,
            String motherName, int sisters, int brothers, float height, float weight, String pswd) {
        User u = new User(name, age, gender, maritalStatus, occupation, livingCity, salary, phoneNumber, nativeCity,
                horoscope,
                fatherName, motherName, sisters, brothers, height, weight, pswd);
        DBAccess dba = new DBAccess();
        return "Registration Successful! Your username is " + dba.dbAddUsers(u);
    }
}
