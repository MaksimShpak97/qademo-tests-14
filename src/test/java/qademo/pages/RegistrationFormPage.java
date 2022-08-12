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
    CalendarComponent calendarComponent = new CalendarComponent();
    ResultModal resultModal = new ResultModal();

    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(byTagAndText("h5", TestDate.getTitle_registration())).shouldHave(text(TestDate.getTitle_registration()));

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

    public RegistrationFormPage inputTestdate() {
        setFirstName(TestDate.getFirstName())
                .setLastName(TestDate.getLastName())
                .setEmail(TestDate.getEmail())
                .setGender(TestDate.getGender())
                .setNumber(TestDate.getPhoneNumber())
                .setBirthYear(TestDate.getYear())
                .setBirthMonth(TestDate.getMonth())
                .setBirthDay(TestDate.getDay())
                .setSubject(TestDate.getSubject())
                .setHobbies(TestDate.getHobbies_number())
                .addPicture(TestDate.getPicture_path())
                .setAddress(TestDate.getAddress())
                .selectState(TestDate.getState())
                .selectCity(TestDate.getCity())
                .submit();

        return this;

    }

    public void testCheckResultOnTableMethods() {
        cheсkResult("Student Name", TestDate.getFirstName() + " " + TestDate.getLastName())
                .cheсkResult("Student Email", TestDate.getEmail())
                .cheсkResult("Gender", TestDate.getGender())
                .cheсkResult("Mobile", TestDate.getPhoneNumber())
                .cheсkResult("Date of Birth", TestDate.getBirthDate())
                .cheсkResult("Subjects", TestDate.getSubject())
                .cheсkResult("Hobbies", TestDate.getHobbies())
                .cheсkResult("Picture", TestDate.getPicture_name())
                .cheсkResult("Address", TestDate.getAddress())
                .cheсkResult("State and City", TestDate.getState() + " " + TestDate.getCity());

    }
}
