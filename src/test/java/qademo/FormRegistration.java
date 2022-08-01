package qademo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.*;

public class FormRegistration {
    @BeforeAll
    public static void configuration() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTests() {
        open("/automation-practice-form");
        $("#firstName").setValue("Alexander");
        $("#lastName").setValue("Pushkin");
        $("#userEmail").setValue("Pushkin@mail.ru");
        $(".custom-control-label").click();
        $("#userNumber").setValue("9125986312");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionByValue("1997");
        $(".react-datepicker__month-select").selectOptionByValue("5");
        $(".react-datepicker__day--006").click();
        $("#subjectsInput").setValue("History").pressEnter();
        sleep(5000);

    }

}
