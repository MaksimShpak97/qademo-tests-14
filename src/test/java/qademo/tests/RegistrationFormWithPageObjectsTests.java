package qademo.tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import qademo.pages.RegistrationFormPage;

public class RegistrationFormWithPageObjectsTests {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    String picture = "src\\test\\resources\\scrooge.png";

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
                .addPicture(picture)
                .setAddress("Pushkin street")
                .selectState("Haryana")
                .selectCity("Panipat")
                .submit();
        registrationFormPage.checkResultTableVisible()
                .cheсkResult("Student Name", "Alexander Pushkin");

//        registrationFormPage.check("Student Name", "Alexander Pushkin");


//        $("[type = 'submit']").click();

//        $("div.modal-content").should(appear);
//        $("div.modal-header").$(byText("Thanks for submitting the form")).shouldHave(text("Thanks for submitting the form"));
//        SelenideElement modalBody = $(".modal-body");
//        modalBody.shouldHave(text("Alexander Pushkin"), text("Pushkin@mail.ru"),
//                text("Male"), text("9125986312"), text("06 June,1997"), text("History"),
//                text("Sports"), text("scrooge.png"), text("Puchkin street"), text("Haryana Panipat"));
//

    }

}
