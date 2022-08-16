package qademo.tests;

import org.junit.jupiter.api.Test;
import qademo.pages.RegistrationFormPage;

import qademo.pages.TestData;
import qademo.pages.components.BaseTest;

public class RegistrationFormWithPageObjectsTests extends BaseTest {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    TestData testData = new TestData();

    @Test
    void fillFormTests() {
        registrationFormPage
                .openPage()
                .inputTestDate(testData)
                .checkResultTableVisible()
                .testCheckResultOnTableMethods(testData);
    }
}

