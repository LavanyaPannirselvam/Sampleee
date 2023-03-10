package service;

import model.Gender;
//to show basic details to the user after filters
public interface ServiceInterface {
    String showAll(Gender gender);
    String showWithFilters(int age, Gender gender);   
    String showWithFilters(String filter, int option, Gender gender);
}
