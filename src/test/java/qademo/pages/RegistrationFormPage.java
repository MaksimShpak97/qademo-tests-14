package qademo.pages;

import org.junit.jupiter.api.DisplayName;
import qademo.pages.components.CalendarComponent;
import qademo.pages.components.ResultModal;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {
    CalendarComponent calendarComponent = new CalendarComponent();
    ResultModal resultModal = new ResultModal();
    TestData testData = new TestData();

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(byTagAndText("h5", testData.getTitleRegistration())).shouldHave(text(testData.getTitleRegistration()));

        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        $("#firstName").setValue(value);

        return this;
    }

    public RegistrationFormPage clearFirstName() {
        $("#firstName").clear();

        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        $("#lastName").setValue(value);

        return this;
    }

    public RegistrationFormPage setEmail(String value) {
        $("#userEmail").setValue(value);

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


    public RegistrationFormPage setBirthYear(String year) {
        $("#dateOfBirthInput").click();
        calendarComponent.setYear(year);

        return this;
    }

    public RegistrationFormPage setBirthMonth(String month) {
        $("#dateOfBirthInput").click();
        calendarComponent.setMonth(month);

        return this;
    }

    public RegistrationFormPage setBirthDay(String day) {
        $("#dateOfBirthInput").click();
        calendarComponent.setDay(day);

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
        $("#uploadPicture").uploadFromClasspath(value);

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
    public void removeBanner() {
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
    }

    public RegistrationFormPage inputTestDate(TestData testData) {
        setFirstName(testData.getFirstName())
                .setLastName(testData.getLastName())
                .setEmail(testData.getEmail())
                .setGender(testData.getGender())
                .setNumber(testData.getPhoneNumber())
                .setBirthYear(testData.getYear())
                .setBirthMonth(testData.getMonth())
                .setBirthDay(testData.getDay())
                .setSubject(testData.getSubject())
                .setHobbies(testData.getHobbies_number())
                .addPicture(testData.getPicture_path())
                .setAddress(testData.getAddress())
                .selectState(testData.getState())
                .selectCity(testData.getCity())
                .submit();

        return this;

    }
    @DisplayName("Checking the completion of the results")

    public void testCheckResultOnTableMethods(TestData testData) {
        cheсkResult("Student Name", testData.getFirstName() + " " + testData.getLastName())
                .cheсkResult("Student Email", testData.getEmail())
                .cheсkResult("Gender", testData.getGender())
                .cheсkResult("Mobile", testData.getPhoneNumber())
                .cheсkResult("Date of Birth", testData.getBirthDate())
                .cheсkResult("Subjects", testData.getSubject())
                .cheсkResult("Hobbies", testData.getHobbies())
                .cheсkResult("Picture", testData.getPicture_name())
                .cheсkResult("Address", testData.getAddress())
                .cheсkResult("State and City", testData.getState() + " " + testData.getCity());

    }
}
