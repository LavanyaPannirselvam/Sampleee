package model;

public class User {
    private static int userCount = 0;
    private final String name;
    private  int age;
    private  String occupation;
    private final Gender gender;
    private final MaritalStatus maritalStatus;
    private  String livingCity;
    private  long salary;
    private  String phoneNumber;
    private final String nativeCity;
    private final Horoscope horoscope;
    private final String fatherName;
    private final String motherName;
    private final int sisters;
    private final int brothers;
    private final float height;
    private  float weight;
    private  String password;

    private String userName;

    public User(String name, int age, Gender gender, MaritalStatus maritalStatus, String occupation, String livingCity,
            long salary, String phoneNumber, String nativeCity, Horoscope horoscope, String fatherName,
            String motherName, int sisters,
            int brothers, float height, float weight, String pswd) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.occupation = occupation;
        this.livingCity = livingCity;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.nativeCity = nativeCity;
        this.horoscope = horoscope;
        this.fatherName = fatherName;
        this.motherName = motherName;
        this.sisters = sisters;
        this.brothers = brothers;
        this.height = height;
        this.weight = weight;
        this.password = pswd;
        this.userName = name + (++userCount);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getOccupation() {
        return occupation;
    }

    public Gender getGender() {
        return gender;
    }

    public MaritalStatus getMaritalStatus() {
        return maritalStatus;
    }

    public String getLivingCity() {
        return livingCity;
    }

    public long getSalary() {
        return salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getNativeCity() {
        return nativeCity;
    }

    public Horoscope getHoroscope() {
        return horoscope;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getMotherName() {
        return motherName;
    }

    public int getSisters() {
        return sisters;
    }

    public int getBrothers() {
        return brothers;
    }

    public float getHeight() {
        return height;
    }

    public float getWeight() {
        return weight;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public static void setUserCount(int userCount) {
        User.userCount = userCount;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public void setLivingCity(String livingCity) {
        this.livingCity = livingCity;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
