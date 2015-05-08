package com.bemach.labguide;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import com.bemach.labguide.common.Browser;
import com.bemach.labguide.pages.SearchResultPage;

public class YahooMainPage {

	private Browser browser;
	private String url;
	private WebElement searchField;
	private Object searchButton;

	 public YahooMainPage (WebDriver driver) {
	        this.browser = new Browser(driver);
	    }

	    public void setPageUrl(String url) {
	        this.url = url;
	        browser.get(url);
	    }
	    
	public boolean locationIsVerified() {
		return "Yahoo".equals(browser.getPageTitle());
	}

	public boolean searchInputIsFound() {
		searchField = getSearchInputField();
		return searchField != null;
	}

	private WebElement getSearchInputField() {
		List<WebElement> searchFields = browser.findByElements(By.xpath("//*[@title='Search']"));
		return (searchFields.size() == 1) ? searchFields.get(0) : null;
	}

	public boolean searchButtonIsFound() {
		searchButton = getSearchButtonField();
		return searchButton != null;
	}

	private WebElement getSearchButtonField() {
		List<WebElement> searchButtons = browser.findByElements(By.xpath("//*[@value='Search Web']"));
		return (searchButtons.size() == 1) ? searchButtons.get(0) : null;
	}

	public YahooResultPage searchText(String searchText) {
		WebElement searchField = this.getSearchInputField();
		searchField.sendKeys(searchText);
		WebElement searchButton = this.getSearchButtonField();
		searchButton.click();
		
		return PageFactory.initElements(browser.getDriver(), YahooResultPage.class);
	}
}
