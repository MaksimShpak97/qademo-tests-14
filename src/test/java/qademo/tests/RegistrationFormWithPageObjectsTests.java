package qademo.tests;

import org.junit.jupiter.api.Test;
import qademo.pages.RegistrationFormPage;
import qademo.pages.components.BaseTest;

public class RegistrationFormWithPageObjectsTests extends BaseTest {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @Test
    void fillFormTests() {
        registrationFormPage
                .openPage()
                .inputTestdate()
                .checkResultTableVisible()
                .testCheckResultOnTableMethods();
    }
}

