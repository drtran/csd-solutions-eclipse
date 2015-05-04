package com.bemach.labguide.pages;

import com.bemach.labguide.common.Browser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ktran on 5/3/2015.
 */
public class SearchResultPage {
    private final Browser browser;

    public SearchResultPage (WebDriver driver) {
        this.browser = new Browser(driver);
    }

    public List<String> getResults() {
        List<String> results = new ArrayList<String>();
        browser.waitForVisibleList(By.xpath("//*[@id='rso']/div[2]/*"));
        List<WebElement> lis = browser.findByElements(By.xpath("//*[@id='rso']/div[2]/*"));
        for (int index = 1; index <= lis.size(); index++) {
            String xpath = String.format("//*[@id='rso']/div[2]/li[%d]/div/h3/a", index);
            WebElement webElement = browser.findByElement(By.xpath(xpath));
            results.add(webElement.getText());
        }
        return results;
    }
}
