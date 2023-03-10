package service;

import java.util.Set;

import database.DBAccess;
import model.Gender;
import model.User;

public class ServiceImpl implements ServiceInterface {
    DBAccess dba = new DBAccess();
    private Set<User> accounts = dba.giveDB();
    ShowDetails sd = new ShowDetails();

    public String showWithFilters(int age, Gender gender) {
        int count = 0;
        for (User u : accounts) {
            if (gender != u.getGender() && u.getAge() == age) {
                count = 1;
                sd.displayBasicDetails(u);
            }
        }
        if (count == 0)
            return "Sorry no profiles to show you at the moment,click 0 to go to menu";
        return "";
    }

    public String showAll(Gender gender) {
        int count = 0;
        for (User u : accounts) {
            if (gender != u.getGender()) {
                count = 1;
                sd.displayBasicDetails(u);
            }
        }
        if (count == 0)
            return "Sorry no profiles to show you at the moment,click 0 to go to menu";
        return "";
    }

    public String showWithFilters(String filter, int option, Gender gender) {
        int count = 0;
        switch (option) {
            case 2:
                for (User u : accounts) {
                    if (gender != u.getGender() && u.getOccupation().equalsIgnoreCase(filter)) {
                        count = 1;
                        sd.displayBasicDetails(u);
                    }

                }
                if (count == 0)
                    return "Sorry no profiles to show you at the moment,click 0 to go to menu";
                count = 0;

            case 3:
                for (User u : accounts) {
                    if (gender != u.getGender() && u.getLivingCity().equalsIgnoreCase(filter)) {
                        count = 1;
                        sd.displayBasicDetails(u);
                    }

                }
                if (count == 0)
                    return "Sorry no profiles to show you at the moment,click 0 to go to menu";
                count = 0;

            case 4:
                for (User u : accounts) {
                    if (gender != u.getGender() && u.getMaritalStatus().toString().equalsIgnoreCase(filter)) {
                        count = 1;
                        sd.displayBasicDetails(u);
                    }
                }
                if (count == 0)
                    return "Sorry no profiles to show you at the moment,click 0 to go to menu";
                count = 0;

                
        }
        return "";
    }

}
