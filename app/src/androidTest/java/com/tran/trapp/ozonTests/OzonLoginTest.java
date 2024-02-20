package com.tran.trapp.ozonTests;


import static com.tran.trapp.ozonSteps.OzonLoginSteps.loginOzon;
import static io.qameta.allure.SeverityLevel.CRITICAL;
import androidx.test.uiautomator.UiObjectNotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.junit4.DisplayName;

@RunWith(JUnit4.class)
public class OzonLoginTest extends OzonSetUp {

    @Before
    public void beforeOzon() {
        openOzon();
    }

    @Test
    @DisplayName("Login test")
    @Description("Log in using phone number by getting a code, then confirming account by name and log out after asserting")
    @Severity(CRITICAL)
    @Owner("Ang")
    public void testLogin() throws InterruptedException, UiObjectNotFoundException {
        loginOzon();
    }

    @After
    public void afterOzon() throws Exception {
        closeOzon();
    }
}
