package com.bemach.labguide;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import com.bemach.labguide.common.Hook;
import com.bemach.labguide.pages.PuppiesMainPage;
import com.bemach.labguide.pages.SearchResultPage;

public class YahooMainPageTest {
	private YahooMainPage main;
	private WebDriver driver;
	private YahooResultPage yahooResultPage;
	@Before
    public void setUp() {
        driver = Hook.getWebDriver(ChromeDriver.class);
        main = PageFactory.initElements(driver, YahooMainPage.class);
        main.setPageUrl("http://www.yahoo.com");
    }
	@Test
    public void shouldCreatePageObject() {
        assertNotNull(main);
    }
	
	@Test
    public void shouldBeAtHomePage() {
        assertTrue("Not at Yahoo Home Page!", main.locationIsVerified());
    }

	@Test
	public void shouldFindSearchInput() {
		assertTrue("Search input field not found!", main.searchInputIsFound());
	}
	
	@Test
	public void shouldFindSearchButton() {
		assertTrue("Search button not found!", main.searchButtonIsFound());
	}
	
	@Test
	public void shouldReceiveListOfResultsAfterSearch() {
		SearchResultPage resultPage = yahooResultPage.search("agile");
        assertNotNull("Not a Google Search Result Page!", resultPage);	}
}
