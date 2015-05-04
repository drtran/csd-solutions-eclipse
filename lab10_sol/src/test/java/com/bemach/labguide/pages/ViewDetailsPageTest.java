package com.bemach.labguide.pages;

import com.bemach.labguide.common.Hook;
import com.bemach.labguide.pages.PuppiesMainPage;
import com.bemach.labguide.pages.ViewDetailsPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static junit.framework.Assert.assertTrue;

/**
 * Created by ktran on 4/25/2015.
 */
public class ViewDetailsPageTest {
    private WebDriver driver;
    private PuppiesMainPage main;
    private ViewDetailsPage viewDetails;

    @Before
    public void setUp() {
        driver = Hook.getWebDriver(ChromeDriver.class);
        main = PageFactory.initElements(driver, PuppiesMainPage.class);
        main.setPageUrl("http://puppies.herokuapp.com");
        viewDetails = main.getViewDetailsPage("Brook");
    }

    @Test
    public void shouldBeAtViewDetailsPageWithGivenPetName() {
        assertTrue("Not at View Details Page!", viewDetails.locationIsVerified());
    }
}
