package com.bemach.labguide.basic;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TestPuppiesWebSite {
	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver", "C:/csd2015/bin/browser-drivers/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:3000");
		
		System.out.println("Getting web elements ..");
		List<WebElement> names = driver.findElements(By.xpath("//div[@class='name']"));
		List<WebElement> values = driver.findElements(By.xpath("//input[@value='View Details']"));
		
		int index = 0;
		for (WebElement name: names) {
			if (name.getText().equals("Brook")) {
				values.get(index).click();
				break;
			}
			index++;
		}

		WebElement adoptMe = driver.findElement(By.xpath("//input[@value='Adopt Me!']"));
		adoptMe.click();
		
		WebElement completeTheAdoption = driver.findElement(By.xpath("//input[@value='Complete the Adoption']"));
		completeTheAdoption.click();

		WebElement orderName = driver.findElement(By.xpath("//input[@id='order_name']"));
		orderName.sendKeys("Cheezy");
		 
		WebElement orderAddr = driver.findElement(By.xpath("//textarea[@id='order_address']"));
		orderAddr.sendKeys("123 Main Street");

		WebElement orderEmail = driver.findElement(By.xpath("//input[@id='order_email']"));
		orderEmail.sendKeys("cheezy@example.com");

		WebElement select = driver.findElement(By.xpath("//select[@id='order_pay_type']"));
		Select dropDown = new Select(select);
		List<WebElement> options = dropDown.getOptions();
		for (WebElement option: options) {
			if (option.getText().equals("Check")) {
				option.click();
				break;
			}
		}
		
		WebElement commit = driver.findElement(By.xpath("//input[@name='commit']"));
		commit.click();
		
		WebElement thankYouNote = driver.findElement(By.xpath("//p[@id='notice']"));
		if ("Thank you for adopting a puppy!".equals(thankYouNote.getText())) {
			System.out.println("Test was a SUCCESS!");
		} else {
			System.out.println("Test was a FAILURE!");
		}
			
		driver.close();
		
		System.out.println("Closed and exit ..");
	}
}
