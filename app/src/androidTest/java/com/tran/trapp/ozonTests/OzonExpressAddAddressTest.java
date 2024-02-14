package com.tran.trapp.ozonTests;

import androidx.test.uiautomator.UiObjectNotFoundException;
import static com.tran.trapp.ozonSteps.OzonExpressAddAddressSteps.addAddressOzonExpress;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class OzonExpressAddAddressTest extends OzonSetUp {
    @Before
    public void beforeOzon() throws UiObjectNotFoundException {
        openOzon();
    }
    @Test
    public void testOzonExpressAddAddress() {
        addAddressOzonExpress();
    }

    @After
    public void afterOzon() throws Exception {
        closeOzon();
    }
}
