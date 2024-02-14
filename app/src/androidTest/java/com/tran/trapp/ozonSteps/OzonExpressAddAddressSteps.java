package com.tran.trapp.ozonSteps;

import androidx.test.uiautomator.UiObjectNotFoundException;
import com.tran.trapp.BaseClass;


public class OzonExpressAddAddressSteps extends BaseClass {

    public static void addAddressOzonExpress() {
        try {
            ozonFreshPage.clickOzonFresh();
            ozonFreshPage.clickShowDestinationOnMap();
            ozonFreshPage.checkCurrentAddress();
            ozonFreshPage.clickContinueBtn();
            ozonFreshPage.clickSaveAddressBtn();
            ozonFreshPage.checkAddressOnExpressPage();
        } catch (UiObjectNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
