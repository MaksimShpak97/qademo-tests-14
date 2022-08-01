package qademo;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FormRegistration {
    @BeforeAll
    static void configure(){
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }
    @Test
    void fillFormTests(){
        open("/automation-practice-form");
        $("#firstName").setValue("Alexander");
        $("#lastName").setValue("Pushkin");
        $("#userEmail").setValue("Pushkin@mail.ru");
        $(".custom-control-label").click();
        $("#userNumber").setValue("9125986312");
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").sendKeys("1799");
        $(".react-datepicker__month-select").sendKeys("june");
        $(".react-datepicker__day react-datepicker__day--006 react-datepicker__day--weekend").click();

    }

}
