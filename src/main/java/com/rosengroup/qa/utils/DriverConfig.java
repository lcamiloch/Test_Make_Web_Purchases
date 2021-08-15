package com.rosengroup.qa.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import sun.security.jca.GetInstance;

import java.time.Duration;

/**
 * @autor: Camilo Chaparro
 * @version: 1.0.0
 * @since: 1.0.0
 */
public class DriverConfig {

    private static WebDriverWait wait;
    private static WebDriver driver;

    public static WebDriver getDriver() {
        return driver;
    }

    public static WebDriverWait getWait() {
        return wait;
    }

    public static void initializeDriver(){
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
        driver.manage().window().maximize();
        driver.navigate().to(PropertiesConfig.getParameter("web"));
    }

    public static void disconnectDriver(){
        driver.close();
        driver.quit();
    }

    public static void waitDriver(){
        wait = new WebDriverWait(
                DriverConfig.driver, Duration.ofSeconds(Long.parseLong(
                        PropertiesConfig.getParameter("ExpectedWaitingTime"))));
    }

}