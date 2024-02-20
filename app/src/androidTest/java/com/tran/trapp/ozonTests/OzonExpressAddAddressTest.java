package com.tran.trapp.ozonTests;

import androidx.test.uiautomator.UiObjectNotFoundException;
import static com.tran.trapp.ozonSteps.OzonExpressAddAddressSteps.addAddressOzonExpress;
import static io.qameta.allure.SeverityLevel.CRITICAL;

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
public class OzonExpressAddAddressTest extends OzonSetUp {
    @Before
    public void beforeOzon() throws UiObjectNotFoundException {
        openOzon();
    }
    @Test
    @DisplayName("Geo location test")
    @Description("Searching current geo location and assert it by saved address")
    @Severity(CRITICAL)
    @Owner("Ang")
    public void testOzonExpressAddAddress() {
        addAddressOzonExpress();
    }

    @After
    public void afterOzon() throws Exception {
        closeOzon();
    }
}
