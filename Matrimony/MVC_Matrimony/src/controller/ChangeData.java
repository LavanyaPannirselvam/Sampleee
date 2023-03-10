package controller;

public class ChangeData {
    CallService cs = new CallService();

    public String updateAge(int age) {
        return cs.setUserAge(age);
    }

    public String updateLivingCity(String city) {
        return cs.setUserLivingCity(city);
    }

    public String updateOccupation(String occupation) {
        return cs.setUserOccupation(occupation);
    }
    public String updateSalary(long salary) {
        return cs.setUserSalary(salary);
    }

    public String updatePhonenumber(String phNo) {
        return cs.setUserPhoneNumber(phNo);
    }

    public String updateWeight(float weight) {
        return cs.setUserWeight(weight);
    }

    public String updatePassword(String pswd) {
        return cs.setUserPassword(pswd);
    }
}
