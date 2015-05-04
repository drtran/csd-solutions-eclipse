package com.bemach.labguide.common;

/**
 * Created by ktran on 4/25/2015.
 */

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public class Browser {
    private static Logger logger = Logger.getLogger(Browser.class.toString());
    public static final int DEFAULT_WAIT_TIME = 30;

    private WebDriver driver;
    public Browser(WebDriver driver) {
        this.driver = driver;
    }
    public void get(String url) {
        driver.get(url);
    }
    public String getPageTitle() {
        return driver.getTitle();
    }
    public WebDriver getDriver() {
        return driver;
    }
    public static int getDefaultWaitTime() {
        return DEFAULT_WAIT_TIME;
    }

    public void sleep(long miliseconds) {
        try {
            logger.info("sleep for :" + miliseconds + " miliseconds");
            Thread.sleep(miliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForPageLoad(long timeout) {
        driver.manage().timeouts().pageLoadTimeout(timeout, TimeUnit.SECONDS);
    }

    public WebElement waitFor(By by, long waitTime) {
        WebDriverWait wait = getWaitDriver(waitTime);
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public WebElement waitFor(By by) {
        return waitFor(by, DEFAULT_WAIT_TIME);
    }

    public List<WebElement> waitForList(By by, long waitTime) {
        WebDriverWait wait = getWaitDriver(waitTime);
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
    }

    public List<WebElement> waitForList(By by) {
        return waitForList(by, DEFAULT_WAIT_TIME);
    }

    public List<WebElement> waitForVisibleList(By by, long waitTime) {
        WebDriverWait wait = getWaitDriver(waitTime);
        try {
            return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        }
        catch (StaleElementReferenceException ex) {
            return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
        }
    }

    public List<WebElement> waitForVisibleList(By by) {
        return waitForVisibleList(by, DEFAULT_WAIT_TIME);
    }

    public WebElement waitForVisible(By by, long waitTime) {
        WebDriverWait wait = getWaitDriver(waitTime);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
    }

    public WebElement waitForVisible(By by) {
        return waitForVisible(by, DEFAULT_WAIT_TIME);
    }

    public WebElement waitForElementToBeClickable(By by, long waitTime) {
        WebDriverWait wait = getWaitDriver(waitTime);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement waitForElementToBeClickable(By by) {
        return waitForElementToBeClickable(by, DEFAULT_WAIT_TIME);
    }

    private WebDriverWait getWaitDriver(long waitTime) {
        return new WebDriverWait(driver, waitTime);
    }

    public WebElement findByElement(By by) {
        WebElement webElement = driver.findElement(by);
        return webElement;
    }

    public List<WebElement> findByElements(By by) {
        List<WebElement> webElements = driver.findElements(by);
        return webElements;
    }

    public static List<WebElement> getWebElementList(WebDriver driver, String elementXPath) {
        List<WebElement> elements = (new WebDriverWait(driver, DEFAULT_WAIT_TIME)).
                until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(elementXPath)));
        return elements;
    }

    public static WebElement getWebElement(WebDriver driver, String elementXPath) {
        WebElement element = (new WebDriverWait(driver, DEFAULT_WAIT_TIME)).
                until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elementXPath)));
        return element;
    }

    public void selectByValue(By by, String selectOption) {
        Select selectBox = new Select(waitFor(by));
        selectBox.selectByValue(selectOption);
    }

    public WebElement waitForClickable(By by, long waitTime) {
        WebDriverWait wait = new WebDriverWait(driver, waitTime);
        return wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public WebElement waitForClickable(By by) {
        return waitFor(by, DEFAULT_WAIT_TIME);
    }

    public void switchHandleToWindow(String windowTitle) {
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
            if ( driver.getTitle().equalsIgnoreCase(windowTitle) ) {
                break;
            }
        }
    }

    public void clickOnVisible(By by) {
        WebElement element = waitForVisible(by);
        element.click();
    }

    public void clickOn(By by) {
        WebElement element = waitForClickable(by);
        element.click();
    }

    public void doubleClick(By by) {
        Actions actions = new Actions(driver);
        WebElement event = driver.findElement(by);
        actions.moveToElement(event);
        actions.doubleClick().build().perform();
    }

    public void populateInputField(String fieldValue, By by, boolean pressTabKey) {
        WebElement inputField = waitForVisible(by);
        inputField.sendKeys(Keys.chord(Keys.CONTROL, "a"), fieldValue);
        if (pressTabKey) {
            inputField.sendKeys("\t");
        }
    }

    public void typeOn(By by, String inputText) {
        WebElement inputField = waitForVisible(by);
        inputField.sendKeys(inputText);
    }

    public boolean verifyElementExists(String elementName) {
        String source = driver.getPageSource();
        return source.contains(elementName);
    }

    public boolean verifyElementExists(By by) {
        WebElement element = waitFor(by);
        return element.isDisplayed();
    }

    public boolean verifyElementDoesNotExist(String elementName) {
        String source = driver.getPageSource();
        return !source.contains(elementName);
    }
//
//    public void waitForAjax()	{
//        while (true) {
//            JavascriptExecutor ex = (JavascriptExecutor)driver;
//            if ((boolean)ex.executeScript("return jQuery.active == 0"))
//                break;
//            sleep(100);
//        }
//    }

    public boolean verifyEnabledStatus(By by) {
        WebElement element = waitFor(by);
        return element.isEnabled();
    }

    public boolean verifyDisabledStatus(By by) {
        WebElement element = waitFor(by);
        return !element.isEnabled();
    }

    public boolean closePopUpWindow(String windowName) {
        boolean hasToCloseThePopUpWindow = false;
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
            if ( driver.getWindowHandle().equals(windowName) ) {
                driver.close();
                hasToCloseThePopUpWindow = true;
            }
        }
        return hasToCloseThePopUpWindow;
    }

    public WebElement findStaleElement(By by) throws StaleElementReferenceException {
        try {
            return driver.findElement(by);
        } catch (StaleElementReferenceException e) {
            logger.info("Stale Element: '" + by + "' on page " + driver.getCurrentUrl());
            throw e;
        }
    }

    private WebElement findElement(By by) {
        try {
            return driver.findElement(by);
        } catch (NoSuchElementException e) {
            logger.info("Could not find - '" + by + "' on page " + driver.getCurrentUrl());
            throw e;
        }
    }

    public WebElement findElementAndWaitElementToPresent(By by, int timeoutInSeconds) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeoutInSeconds);
            wait.until(ExpectedConditions.presenceOfElementLocated(by));
            return findElement(by);
        } catch (TimeoutException e) {
            logger.info("Element is not present: " + by + " on page " + driver.getCurrentUrl());
            throw e;
        }
    }

    public boolean verifyElementExist(By by) {
        try {
            WebElement element = waitFor(by, 3);
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public void clickOnDropDown(By by) {
        WebElement dropDown = waitForClickable(by);
        dropDown.click();
    }

    public void selectFromDropDownByDataLabelAttribute(By by, String dataLabelAttributeValue) {
        List<WebElement> dropDownListValues = waitForVisibleList(by);
        for (WebElement dropDownListValue : dropDownListValues) {
            if (dataLabelAttributeValue.equals(dropDownListValue.getAttribute("data-label").trim())) {
                dropDownListValue.click();
                break;
            }
        }
    }

    public void selectFromMultiSelectionListByText(By by, String textValue) {
        List<WebElement> multiSelectionValues = waitForVisibleList(by);
        for (WebElement multiSelectionValue : multiSelectionValues) {
            if (textValue.equals(multiSelectionValue.getText())) {
                multiSelectionValue.click();
                break;
            }
        }
    }

    protected void takeScreenshot() {
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = System.getProperty("screenshotPath");

        if (!screenshotPath.isEmpty()) {
            try {
                FileUtils.copyFile(scrFile, new File(screenshotPath), true);
            }
            catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error saving screenshot into file.");
            }
        }
    }

    public void clearField(By by) {
        driver.findElement(by).clear();
    }
}
