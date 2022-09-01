package qademo.pages;

import com.github.javafaker.Faker;

import java.util.Locale;

import static qademo.utils.RandomUtils.*;

public class TestData {
    static Faker faker = new Faker(new Locale("en-US"));


    private final String firstName = faker.name().firstName();
    private final String lastName = faker.name().lastName();
    private final String email = faker.internet().emailAddress();
    private final String gender = "Male";
    private final String phoneNumber = getRandomPhoneNumber();
    private final String birthDate = "06 June,1997";
    private final String day = "06";
    private final String month = "5";
    private final String year = "1997";
    private final String subject = "History";
    private final String hobbies = "Reading";
    private final String hobbies_number = "2";
    private final String picture_path = "src\\test\\resources\\scrooge.png";
    private final String picture_name = "scrooge.png";
    private final String address = faker.address().fullAddress();
    private final String state = "Haryana";
    private final String city = "Panipat";
    private final String titleThanks = "Thanks for submitting the form";
    private final String titleRegistration = "Student Registration Form";

    public String getFirstName() {

        return firstName;
    }

    public String getLastName() {

        return lastName;
    }

    public String getEmail() {

        return email;
    }

    public String getGender() {

        return gender;
    }

    public String getPhoneNumber() {

        return phoneNumber;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getYear() {

        return year;
    }

    public String getMonth() {

        return month;
    }

    public String getDay() {

        return day;
    }

    public String getSubject() {

        return subject;
    }

    public String getHobbies() {

        return hobbies;
    }

    public String getHobbies_number() {

        return hobbies_number;
    }

    public String getPicture_path() {
        return picture_path;
    }

    public String getPicture_name() {
        return picture_name;
    }

    public String getAddress() {

        return address;
    }

    public String getState() {

        return state;
    }

    public String getCity() {

        return city;
    }

    public String getTitleThanks() {
        return titleThanks;
    }

    public String getTitleRegistration() {

        return titleRegistration;
    }


}

