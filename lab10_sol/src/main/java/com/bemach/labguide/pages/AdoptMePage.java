package com.bemach.labguide.pages;

import com.bemach.labguide.common.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by ktran on 4/25/2015.
 */
public class AdoptMePage {
    private final Browser browser;

    public AdoptMePage (WebDriver driver) {
        this.browser = new Browser(driver);
    }

    public OrderPage completeTheAdoption() {
        WebElement webElement = browser.findByElement(By.xpath("//input[@value='Complete the Adoption']"));
        webElement.click();
        return PageFactory.initElements(browser.getDriver(), OrderPage.class);
    }

    public OrderPage adoptAnotherPuppy() {
        WebElement webElement = browser.findByElement(By.xpath("//input[@value='Adopt Another Puppy']"));
        webElement.click();
        return PageFactory.initElements(browser.getDriver(), OrderPage.class);
    }

    public boolean locationIsVerified() {
        WebElement webElement = browser.findByElement(By.xpath("//input[@value='Complete the Adoption']"));
        return "Complete the Adoption".equals(webElement.getAttribute("value"));
    }

    public PuppiesMainPage changeYourMind() {
        WebElement webElement = browser.findByElement(By.xpath("//input[@value='Change your mind']"));
        webElement.click();
        browser.sleep(1000);
        browser.getDriver().switchTo().alert().accept();
        browser.sleep(1000);
        browser.getDriver().switchTo().alert().accept();
        return PageFactory.initElements(browser.getDriver(), PuppiesMainPage.class);
    }
}
