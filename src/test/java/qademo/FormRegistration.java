package qademo;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.selector.ByText;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class FormRegistration {
    String picture = "src\\test\\resources\\scrooge.png";

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
        $("[for = hobbies-checkbox-1]").click();
        $("#uploadPicture").uploadFile(new File(picture));
        $("[placeholder='Current Address']").setValue("Puchkin street");
        $(".css-1wa3eu0-placeholder").click();
        $(byText("Haryana")).click();
        $("#city").click();
        $(byText("Panipat")).click();
        $("[type = 'submit']").click();


        SelenideElement modalBody = $(".modal-body");
        modalBody.shouldHave(text("Alexander Pushkin"), text("Pushkin@mail.ru"),
                text("Male"), text("9125986312"), text("06 June,1997"), text("History"),
                text("Sports"), text("scrooge.png"), text("Puchkin street"), text("Haryana Panipat"));

    }

}
