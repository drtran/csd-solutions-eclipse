package com.bemach.labguide.pages;

import com.bemach.labguide.common.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by ktran on 4/25/2015.
 */
public class ViewDetailsPage {
    private final Browser browser;

    public ViewDetailsPage (WebDriver driver) {
        this.browser = new Browser(driver);
    }

    public boolean locationIsVerified() {
        WebElement webElement = browser.findByElement(By.xpath("//input[@value='Adopt Me!']"));
        return "Adopt Me!".equals(webElement.getAttribute("value"));
    }

    public AdoptMePage adoptMe() {
        WebElement webElement = browser.findByElement(By.xpath("//input[@value='Adopt Me!']"));
        webElement.click();
        return PageFactory.initElements(browser.getDriver(), AdoptMePage.class);
    }


}
