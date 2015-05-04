package com.bemach.labguide.pages;

import com.bemach.labguide.common.Hook;
import com.bemach.labguide.common.PaymentInfo;
import com.bemach.labguide.pages.AdoptMePage;
import com.bemach.labguide.pages.OrderPage;
import com.bemach.labguide.pages.PuppiesMainPage;
import com.bemach.labguide.pages.ViewDetailsPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by ktran on 4/25/2015.
 */
public class OrderPageTest {
    private WebDriver driver;
    private PuppiesMainPage main;
    private ViewDetailsPage viewDetails;
    private AdoptMePage adoptMe;
    private OrderPage order;

    @Before
    public void setUp() {
        driver = Hook.getWebDriver(ChromeDriver.class);
        main = PageFactory.initElements(driver, PuppiesMainPage.class);
        main.setPageUrl("http://puppies.herokuapp.com");
        viewDetails = main.getViewDetailsPage("Brook");
        adoptMe = viewDetails.adoptMe();
        order = adoptMe.completeTheAdoption();
    }

    @Test
    public void shouldBeAtOrderPage() {
        Assert.assertTrue("Not at Page Order Page!", order.locationIsVerified());
    }

    @Test
    public void shouldCompleteTheOrder() {
        PaymentInfo paymentInfo = new PaymentInfo();
        order.completeOrder(paymentInfo);
        Assert.assertTrue("Thank you for adopting a puppy!", order.lastOrderWasSuccessful());
    }
}
