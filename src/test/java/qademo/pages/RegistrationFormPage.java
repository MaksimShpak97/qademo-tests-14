package qademo.pages;

import com.codeborne.selenide.SelenideElement;
import qademo.pages.components.CalendarComponent;
import qademo.pages.components.ResultModal;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationFormPage {

    private static final String TITLE_TEXT = "Student Registration Form";
    CalendarComponent calendarComponent = new CalendarComponent();
    ResultModal resultModal = new ResultModal();
    private SelenideElement
            firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            emailInput = $("#userEmail");


    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(byTagAndText("h5", TITLE_TEXT)).shouldHave(text(TITLE_TEXT));

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage clearFirstName() {
        firstNameInput.clear();

        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        emailInput.setValue(value);

        return this;
    }

    public RegistrationFormPage setNumber(String value) {
        $("#userNumber").setValue(value);

        return this;
    }

    public RegistrationFormPage setGender(String value) {
        $("#genterWrapper").$(byText(value)).click();

        return this;
    }

    public RegistrationFormPage setBirthDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDate(day, month, year);

        return this;
    }

    public RegistrationFormPage setSubject(String value) {
        $("#subjectsInput").setValue(value).pressEnter();

        return this;
    }

    public RegistrationFormPage setHobbies(String value) {
        $("[for = hobbies-checkbox-" + value + "]").click();

        return this;
    }

    public RegistrationFormPage addPicture(String value) {
        $("#uploadPicture").uploadFile(new File(value));

        return this;
    }

    public RegistrationFormPage setAddress(String value) {
        $("[placeholder='Current Address']").setValue(value);
        $(".css-1wa3eu0-placeholder").click();

        return this;
    }

    public RegistrationFormPage selectState(String state) {
        $("#stateCity-wrapper").$(byText(state)).click();


        return this;
    }

    public RegistrationFormPage selectCity(String city) {
        $("#city").click();
        $("#stateCity-wrapper").$(byText(city)).click();

        return this;

    }

    public RegistrationFormPage submit() {
        $("[type = 'submit']").click();

        return this;
    }

    public RegistrationFormPage checkResultTableVisible() {
        resultModal.checkVisible();

        return this;
    }

    public RegistrationFormPage cheсkResult(String key, String value) {
        resultModal.checkResult(key, value);

        return this;
    }
}
