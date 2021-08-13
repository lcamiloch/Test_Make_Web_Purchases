package com.rosengroup.qa.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class DriverConfig {

    WebDriver driver;

    public WebDriver selectNavigator(){
        switch (PropertiesConfig.getParameter("Browser")){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
            default:
                System.out.println(" !!! Browser not found !!! ");
        }
        driver.manage().timeouts().implicitlyWait(Long.parseLong(PropertiesConfig
                .getParameter("ImplicitlyWait")), TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(Long.parseLong(PropertiesConfig
                .getParameter("PageLoadTimeout")), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        return driver;
    }
}