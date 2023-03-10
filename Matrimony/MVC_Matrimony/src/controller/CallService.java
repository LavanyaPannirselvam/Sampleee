package controller;

import service.CallImpl;
import service.CheckUser;
import service.ServiceImpl;
import service.UpdateData;
import database.*;

class CallService {
    ServiceImpl sImpl = new ServiceImpl();
    CallImpl cImpl = new CallImpl();
    CheckUser cku = new CheckUser();
    DBAccess dba = new DBAccess();
    UpdateData upd=new UpdateData();

    String validateDBUser(String uname, String pswd) {
        return cku.validateUser(uname, pswd);
    }

    String callShowAll() {
        return sImpl.showAll(dba.returnCurrentUser().getGender());
    }

    String callShowWithAge(int age) {
        return sImpl.showWithFilters(age, dba.returnCurrentUser().getGender());
    }

    String callShowFilters(String filter, int option) {
        return sImpl.showWithFilters(filter, option, dba.returnCurrentUser().getGender());
    }

    String callDisplay(String uname) {
        return cImpl.callDisplay(uname);
    }

    String callDisplay() {
        return cImpl.callDisplay();
    }
    
    String setUserAge(int age){
        return upd.setUserAge(age, dba.returnCurrentUser());
    }

    String setUserOccupation(String occupation){
        return upd.setUserOccupation(occupation,dba.returnCurrentUser());
    }
    String setUserLivingCity(String city){
        return upd.setUserLivingCity(city, dba.returnCurrentUser());
    }

    String setUserSalary(long salary){
        return upd.setUserSalary(salary, dba.returnCurrentUser());
    }

    String setUserPhoneNumber(String phNo){
        return upd.setUserPhoneNumber(phNo, dba.returnCurrentUser());
    }

    String setUserWeight(float weight){
        return upd.setUserWeight(weight, dba.returnCurrentUser());
    }

    String setUserPassword(String pswd){
        return upd.setUserPassword(pswd, dba.returnCurrentUser());
    }
}
