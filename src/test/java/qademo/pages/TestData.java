package qademo.pages;

import com.github.javafaker.Faker;
import qademo.utils.RandomUtils;

import java.util.Locale;

import static qademo.utils.RandomUtils.*;

public class TestData {
    static Faker faker = new Faker(new Locale("en-US"));


    private String
            firstName = faker.name().firstName(),
            lastName = faker.name().lastName(),
            email = faker.internet().emailAddress(),
            gender = "Male",
            phoneNumber = getRandomPhoneNumber(),
            birthDate = "06 June,1997",
            day = "06",
            month = "5",
            year = "1997",
            subject = "History",
            hobbies = "Reading",
            hobbies_number = "2",
            picture_path = "src\\test\\resources\\scrooge.png",
            picture_name = "scrooge.png",
            address = faker.address().fullAddress(),
            state = "Haryana",
            city = "Panipat",
            title_thanks = "Thanks for submitting the form",
            title_registration = "Student Registration Form";

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

    public String getTitle_thanks() {
        return title_thanks;
    }

    public String getTitle_registration() {

        return title_registration;
    }


}

