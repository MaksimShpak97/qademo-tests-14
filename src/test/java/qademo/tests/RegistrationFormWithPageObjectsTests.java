package qademo.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import qademo.pages.RegistrationFormPage;

public class RegistrationFormWithPageObjectsTests {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    public static void configuration() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTests() {
        registrationFormPage
                .openPage()
                .setFirstName("Alexander")
                .setLastName("Pushkin")
                .setEmail("Pushkin@mail.ru")
                .setGender("Male")
                .setNumber("9125986312")
                .setBirthDate("06", "5", "1997")
                .setSubject("History")
                .setHobbies("2")
                .addPicture("src\\test\\resources\\scrooge.png")
                .setAddress("Pushkin street")
                .selectState("Haryana")
                .selectCity("Panipat")
                .submit();

        registrationFormPage.checkResultTableVisible()
                .cheсkResult("Student Name", "Alexander Pushkin");

    }

}
