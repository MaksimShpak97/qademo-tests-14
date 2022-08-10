package qademo.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import qademo.pages.RegistrationFormPage;
import qademo.pages.components.BaseTest;

public class RegistrationFormWithPageObjectsTests extends BaseTest {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

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
