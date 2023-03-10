package service;

import model.User;

public class UpdateData {

    public String setUserAge(int age, User u) {
        u.setAge(age);
        return "Updated successfully";
    }

    public String setUserLivingCity(String city, User u) {
        u.setLivingCity(city);
        return "Updated successfully";
    }

    public String setUserOccupation(String occupation, User u) {
        u.setOccupation(occupation);
        return "Updated successfully";
    }

    public String setUserSalary(long amount, User u) {
        u.setSalary(amount);
        return "Updated successfully";
    }

    public String setUserPhoneNumber(String phNo, User u) {
        u.setPhoneNumber(phNo);
        return "Updated successfully";
    }

    public String setUserWeight(float weight, User u) {
        u.setWeight(weight);
        return "Updated successfully";
    }

    public String setUserPassword(String pswd, User u) {
        u.setPassword(pswd);
        return "Updated successfully";
    }
}
