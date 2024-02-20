package com.tran.trapp.ozonTests;

import static com.tran.trapp.ozonSteps.AddToCartSteps.addToCart;
import static com.tran.trapp.ozonSteps.AddToCartSteps.addToCartFromSearch;
import static com.tran.trapp.ozonSteps.SearchItemSteps.searchItem;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static io.qameta.allure.SeverityLevel.MINOR;

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
public class AddToCartTest extends OzonSetUp {

    @Before
    public void beforeOzon() {
        openOzon();
    }

    @Test
    @DisplayName("Add product to cart")
    @Description("Testing adding a product to a cart and deleting it after asserting")
    @Severity(CRITICAL)
    @Owner("Ang")
    public void testAddToCart() throws UiObjectNotFoundException, InterruptedException {
        addToCart();
    }

    @Test
    @DisplayName("Search item test")
    @Description("Testing search item from search bar")
    @Severity(MINOR)
    @Owner("Ang")
    public void testSearchItemFromSearch() throws InterruptedException, UiObjectNotFoundException {
        searchItem();
    }
    @Test
    @DisplayName("Add product to cart from search bar")
    @Description("Adding a product to a cart through searching a product and then deleting it")
    @Severity(CRITICAL)
    @Owner("Ang")
    public void testAddToCartFromSearch() throws UiObjectNotFoundException, InterruptedException {
        addToCartFromSearch();
    }
    @After
    public void afterOzon() throws Exception {
        closeOzon();
    }
}
