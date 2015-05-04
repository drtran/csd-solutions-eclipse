package com.bemach.labguide.pages;

import com.bemach.labguide.common.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by ktran on 4/25/2015.
 */
public class PuppiesMainPage {

    private final Browser browser;
    private String url;

    public PuppiesMainPage(WebDriver driver) {
        this.browser = new Browser(driver);
    }

    public void setPageUrl(String url) {
        this.url = url;
        browser.get(url);
    }

    private String getPuppyListTitle() {
        WebElement webElement = browser.findByElement(By.xpath("//*[@id='content']/h1"));
        return webElement.getText();
    }

    public ViewDetailsPage getViewDetailsPage(String petName) {
        List<WebElement> names = browser.findByElements(By.xpath("//div[@class='name']"));
        List<WebElement> values = browser.findByElements(By.xpath("//input[@value='View Details']"));
        int index = 0;

        for (WebElement name: names) {
            if (petName.equals(name.getText())) {
                values.get(index).click();
                break;
            }
            index++;
        }

        return PageFactory.initElements(browser.getDriver(), ViewDetailsPage.class);
    }

    public boolean locationIsVerified() {
        return "Puppy List".equals(getPuppyListTitle());
    }
}
