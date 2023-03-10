package user;

public class User {
    private static int user_count = 0;
    private String name;
    private String uname;
    private int user_id;
    private int age;
    private String gender; // TODO enum
    private String marital_status;// TODO enum implementation for marital status
    private String occupation;
    private String livingCity;
    private long salary;
    private String nativeCity;
    private String horoscope;
    private String Father_name;
    private String Mother_name;
    private int siblings;
    private int sisters;
    private int brothers;
    private float height;
    private float weight;

    public User(String name, int age, String gender, String marital_status, String occupation, String livingCity,
            long salary,
            String nativeCity, String horoscope, String Father_name, String Mother_name, int siblings, int sisters,
            int brothers, float height, float weight) {
        this.name = name;
        // TODO
        this.uname = name + ++user_count;
        this.user_id = user_count;
        this.age = age;
        this.gender = gender;
        this.marital_status = marital_status;
        this.occupation = occupation;
        this.livingCity = livingCity;
        this.salary = salary;
        this.nativeCity = nativeCity;
        this.horoscope = horoscope;
        this.Father_name = Father_name;
        this.Mother_name = Mother_name;
        this.siblings = siblings;
        this.sisters = sisters;
        this.brothers = brothers;
        this.height = height;
        this.weight = weight;
    }

    public String getUserName() {
        return uname;
    }

    enum Gender {
        MALE, FEMALE
    };

    enum MaritalStatus {
        SINGLE, WIDOW, DIVORSED
    }

    public static int getUser_count() {
        return user_count;
    }

    public static void setUser_count(int user_count) {
        User.user_count = user_count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMarital_status() {
        return marital_status;
    }

    public void setMarital_status(String marital_status) {
        this.marital_status = marital_status;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getLivingCity() {
        return livingCity;
    }

    public void setLivingCity(String livingCity) {
        this.livingCity = livingCity;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getNativeCity() {
        return nativeCity;
    }

    public void setNativeCity(String nativeCity) {
        this.nativeCity = nativeCity;
    }

    public String getHoroscope() {
        return horoscope;
    }

    public void setHoroscope(String horoscope) {
        this.horoscope = horoscope;
    }

    public String getFather_name() {
        return Father_name;
    }

    public void setFather_name(String father_name) {
        Father_name = father_name;
    }

    public String getMother_name() {
        return Mother_name;
    }

    public void setMother_name(String mother_name) {
        Mother_name = mother_name;
    }

    public int getSiblings() {
        return siblings;
    }

    public void setSiblings(int siblings) {
        this.siblings = siblings;
    }

    public int getSisters() {
        return sisters;
    }

    public void setSisters(int sisters) {
        this.sisters = sisters;
    }

    public int getBrothers() {
        return brothers;
    }

    public void setBrothers(int brothers) {
        this.brothers = brothers;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    };

}
