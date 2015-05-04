package com.bemach.labguide.pages;

import com.bemach.labguide.common.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by ktran on 5/3/2015.
 */
public class GoogeSearchPage {
    private final Browser browser;
    private String pageUrl;

    public GoogeSearchPage (WebDriver driver) {
        this.browser = new Browser(driver);
    }

    public void setPageUrl(String pageUrl) {
        this.pageUrl = pageUrl;
        browser.get(pageUrl);
    }

    public boolean locationIsVerified() {
        List<WebElement> webElements = browser.findByElements(By.xpath("//input[@value='Google Search']"));
        return !webElements.isEmpty() ;
    }

    public SearchResultPage search(String text) {
        List<WebElement> webElements = browser.findByElements(By.xpath("//input[@title='Search']"));
        webElements.get(0).sendKeys(text);
        webElements = browser.findByElements(By.xpath("//button[@value='Search']/span"));
        webElements.get(0).click();
        return PageFactory.initElements(browser.getDriver(), SearchResultPage.class);
    }
}
