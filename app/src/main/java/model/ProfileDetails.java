package model;

public class ProfileDetails {
    String names,gender,ages;
     int img;

    public ProfileDetails(String names, String gender, int img, String ages) {
        this.names = names;
        this.gender = gender;
        this.img = img;
        this.ages = ages;
    }



    public String getNames() {
        return names;
    }

    public String getGender() {
        return gender;
    }

    public int getImg() {
        return img;
    }

    public String getAges() {
        return ages;
    }
}
