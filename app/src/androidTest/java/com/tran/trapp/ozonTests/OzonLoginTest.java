package com.tran.trapp.ozonTests;


import static com.tran.trapp.ozonSteps.OzonLoginSteps.loginOzon;
import androidx.test.uiautomator.UiObjectNotFoundException;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class OzonLoginTest extends OzonSetUp {
    @Before
    public void beforeOzon() throws UiObjectNotFoundException {
        openOzon();
    }

    @Test
    public void testLogin() throws InterruptedException, UiObjectNotFoundException {
        loginOzon();
    }
    @After
    public void afterOzon() throws Exception {
        closeOzon();
    }
}
