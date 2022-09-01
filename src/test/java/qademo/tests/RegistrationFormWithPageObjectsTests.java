package qademo.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import qademo.pages.RegistrationFormPage;

import qademo.pages.TestData;
import qademo.pages.components.BaseTest;

import static io.qameta.allure.Allure.step;

public class RegistrationFormWithPageObjectsTests extends BaseTest {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    TestData testData = new TestData();

    @Feature("Registration test")
    @Owner("ShpakMa")
    @Severity(SeverityLevel.CRITICAL)
    @Link(value = "Testing", url = "https://demoqa.com/automation-practice-form")
    @DisplayName("Checking the registration form")
    @Test
    void fillFormTests() {
        step("Open registration page", ()-> {
            registrationFormPage.openPage().removeBanner();
        });
        step( "Filling out the registration form", ()-> {
            registrationFormPage.inputTestDate(testData);
        });
        step( "Checking table visibility", ()-> {
            registrationFormPage.checkResultTableVisible();
        });
        step( "Checking data in a table with filled fields", ()-> {
            registrationFormPage.testCheckResultOnTableMethods(testData);
        });
        }
    }


