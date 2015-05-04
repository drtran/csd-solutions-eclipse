package com.bemach.labguide;

import com.bemach.labguide.common.Hook;
import com.bemach.labguide.pages.GoogeSearchPage;
import com.bemach.labguide.pages.SearchResultPage;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ktran on 5/3/2015.
 */
public class GoogleSearchPageTest {
    private WebDriver driver;
    private GoogeSearchPage googleSearchPage;

    @Before
    public void setUp() {
        driver = Hook.getWebDriver(ChromeDriver.class);
        googleSearchPage = PageFactory.initElements(driver, GoogeSearchPage.class);
        googleSearchPage.setPageUrl("http://google.com");
    }

    @Test
    public void shouldGetToSearchPage() {
        assertTrue("Not at Google Search Page!", googleSearchPage.locationIsVerified());
    }

    @Test
    public void shouldGetSearchResultPage() {
        SearchResultPage resultPage = googleSearchPage.search("agile");
        assertNotNull("Not a Google Search Result Page!", resultPage);
    }

    @Test
    public void shouldGetSearchResults() {
        SearchResultPage resultPage = googleSearchPage.search("agile");
        List<String> results = resultPage.getResults();
        assertTrue("Result not found!", isFound(results, "Manifesto for Agile Software Development"));
    }

    private boolean isFound(List<String> results, String text) {
        for (String result: results) {
            if (text.equals(result)) {
                return true;
            }
        }
        return false;
    }
}
