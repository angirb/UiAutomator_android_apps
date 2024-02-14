package com.tran.trapp.ozonTests;

import static com.tran.trapp.ozonSteps.AddToCartSteps.addToCart;
import static com.tran.trapp.ozonSteps.AddToCartSteps.addToCartFromSearch;
import static com.tran.trapp.ozonSteps.SearchItemSteps.searchItem;

import androidx.test.uiautomator.UiObjectNotFoundException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


@RunWith(JUnit4.class)
public class AddToCartTest extends OzonSetUp {

    @Before
    public void beforeOzon() throws UiObjectNotFoundException {
        openOzon();
    }

    @Test
//    @Description("Testing adding a product to a cart")
    public void testAddToCart() throws UiObjectNotFoundException, InterruptedException {
        addToCart();
    }

    @Test
//    @Description("Testing search item from search bar")
    public void testSearchItemFromSearch() throws InterruptedException, UiObjectNotFoundException {
        searchItem();
    }
//    @Description("Adding a product to a cart through searching a product")
    @Test
    public void testAddToCartFromSearch() throws UiObjectNotFoundException, InterruptedException {
        addToCartFromSearch();
    }
    @After
    public void afterOzon() throws Exception {
        closeOzon();
    }
}
