package com.bemach.labguide.common;

/**
 * Created by ktran on 4/25/2015.
 */

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Hook {

    private static final String IE_DRIVER_IDENTIFIER = "internetexplorer";
    private static final String FIREFOX_DRIVER_IDENTIFIER = "firefox";
    private static final String CHROME_DRIVER_IDENTIFIER = "chrome";

    private static WebDriver webDriver;

    public static WebDriver getWebDriver(Class<?> driverTypeDontCare) {
        if (webDriver == null) {
            String driverType = System.getProperty("webDriver");
            if (CHROME_DRIVER_IDENTIFIER.equalsIgnoreCase(driverType)) {
                webDriver = new ChromeDriver();
            } else if (FIREFOX_DRIVER_IDENTIFIER.equalsIgnoreCase(driverType)) {
                webDriver = new FirefoxDriver();
            } else if (IE_DRIVER_IDENTIFIER.equalsIgnoreCase(driverType)) {
                webDriver = new InternetExplorerDriver();
            } else {
                webDriver = new ChromeDriver();
            }

            Runtime.getRuntime().addShutdownHook(new Thread() {
                @Override
                public void run() {
                    if (webDriver != null) {
                        webDriver.manage().deleteCookieNamed("KEY");
                        webDriver.close();
                        webDriver.quit();
                    }
                }
            });
        }
        return webDriver;
    }
}
