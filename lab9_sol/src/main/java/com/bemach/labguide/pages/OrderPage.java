package com.bemach.labguide.pages;

import com.bemach.labguide.common.Browser;
import com.bemach.labguide.common.PaymentInfo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

/**
 * Created by ktran on 4/25/2015.
 */
public class OrderPage {

    private final Browser browser;

    public OrderPage(WebDriver driver) {
        this.browser = new Browser(driver);
    }

    public boolean locationIsVerified() {
        WebElement webElement = browser.findByElement(By.xpath("//input[@name='commit']"));
        return "Place Order".equals(webElement.getAttribute("value"));
    }

    public void completeOrder(PaymentInfo paymentInfo) {
        WebElement webElement = browser.findByElement(By.xpath("//input[@id='order_name']"));
        webElement.sendKeys(paymentInfo.orderName);
        webElement = browser.findByElement(By.xpath("//textarea[@id='order_address']"));
        webElement.sendKeys(paymentInfo.orderAddress);
        webElement = browser.findByElement(By.xpath("//input[@id='order_email']"));
        webElement.sendKeys(paymentInfo.orderEmail);
        WebElement select = browser.findByElement(By.xpath("//select[@id='order_pay_type']"));

        Select dropDown = new Select(select);
        List<WebElement> options = dropDown.getOptions();
        for (WebElement option : options) {
            if (option.getText().equals(paymentInfo.orderPaymentType)) {
                option.click();
                break;
            }
        }

        WebElement commit = browser.findByElement(By.xpath("//input[@name='commit']"));
        commit.click();
    }

    public boolean lastOrderWasSuccessful() {
        WebElement thankYouNote = browser.findByElement(By.xpath("//p[@id='notice']"));
        return "Thank you for adopting a puppy!".equals(thankYouNote.getText());
    }
}
