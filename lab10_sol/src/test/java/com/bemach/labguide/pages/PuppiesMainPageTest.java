package com.bemach.labguide.pages;

import com.bemach.labguide.common.Hook;
import com.bemach.labguide.pages.PuppiesMainPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

/**
 * Created by ktran on 4/25/2015.
 * Testing the Main Page of Puppies website.
 */
public class PuppiesMainPageTest {
    private PuppiesMainPage main;
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = Hook.getWebDriver(ChromeDriver.class);
        main = PageFactory.initElements(driver, PuppiesMainPage.class);
        main.setPageUrl("http://puppies.herokuapp.com");
    }

    @Test
    public void shouldCreatePageObject() {
        assertNotNull(main);
    }

    @Test
    public void shouldBeAtHomePage() {
        assertTrue("Not at Puppy Adoption Home Page!", main.locationIsVerified());
    }

}
