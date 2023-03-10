package service;

import model.User;
//methods to display details
class ShowDetails{

    void displayBasicDetails(User u)
    {
        System.out.println("-------------------");
        System.out.println("Username :"+u.getUserName());
        System.out.println("Name :"+u.getName());
        System.out.println("Age :"+u.getAge());
        System.out.println("Gender :"+u.getGender());
        System.out.println("Phone number :"+u.getPhoneNumber());
        System.out.println("Occupation :"+u.getOccupation());
        System.out.println("Marital Status :"+u.getMaritalStatus());
        System.out.println("Living City :"+u.getLivingCity());
        System.out.println("Horoscope :"+u.getHoroscope());
        System.out.println("-------------------");

    }
    void displayAllDetails(User u)
    {
        System.out.println("-------------------");
        System.out.println("Username :"+u.getUserName());
        System.out.println("Name :"+u.getName());
        System.out.println("Age :"+u.getAge());
        System.out.println("Phone number :"+u.getPhoneNumber());
        System.out.println("Occupation :"+u.getOccupation());
        System.out.println("Gender :"+u.getGender());
        System.out.println("Marital Status :"+u.getMaritalStatus());
        System.out.println("Living City :"+u.getLivingCity());
        System.out.println("Native City :"+u.getNativeCity());
        System.out.println("Horoscope :"+u.getHoroscope());
        System.out.println("Father Name :"+u.getFatherName());
        System.out.println("Mother Name :"+u.getMotherName());
        System.out.println("Sisters :"+u.getSisters());
        System.out.println("Brothers :"+u.getBrothers());
        System.out.println("Height :"+u.getHeight());
        System.out.println("Weight :"+u.getWeight());
        System.out.println("-------------------");

    }
}
