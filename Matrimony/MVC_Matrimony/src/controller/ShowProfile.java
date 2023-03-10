package controller;

public class ShowProfile {
    CallService cs = new CallService();

    public String showWithoutFilters() {
        return cs.callShowAll();
    }

    public String showWithFilterAge(int age) {
        return cs.callShowWithAge(age);
    }

    public String showWithFilters(String filter, int option) {
        return cs.callShowFilters(filter, option);
    }

    public String showAll(String username) {
        return cs.callDisplay(username);
    }

    public String showMe() {
        return cs.callDisplay();
    }

}
