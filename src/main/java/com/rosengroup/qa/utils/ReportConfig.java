package com.rosengroup.qa.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ReportConfig {

    Random numRand;
    File screenshot;
    ExtentTest report;
    ExtentReports extent;
    ExtentHtmlReporter htmlReporter;

    public void flowName(String flowName) {
        extent = new ExtentReports();
        htmlReporter = new ExtentHtmlReporter(
                "target/reports/Report.html");
        htmlReporter.setAppendExisting(true);
        extent.attachReporter(htmlReporter);
        report = extent.createTest(flowName);
        report.assignAuthor(System.getProperty("user.name"));
        report.assignAuthor(System.getProperty("os.name"));
    }

    public void screenshot(WebDriver driver, String msg, String status, By locator) {
        JavascriptExecutor je = (JavascriptExecutor) driver;
        je.executeScript("arguments[0].style.border='5px solid green'", driver.findElement(locator));
        screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String name = pictureName();
        try {
            FileUtils.copyFile(screenshot, new File(System.getProperty("user.dir") + "\\target\\reports\\pictures\\" + name + ".png"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        switch (status) {
            case "pass":
                try {
                    report.pass(msg, MediaEntityBuilder.createScreenCaptureFromPath("pictures\\" + name + ".png").build());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "info":
                try {

                    report.info(msg, MediaEntityBuilder.createScreenCaptureFromPath("pictures\\" + name + ".png").build());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case "fail":
                try {
                    report.fail(msg, MediaEntityBuilder.createScreenCaptureFromPath("pictures\\" + name + ".png").build());
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            default:
                System.out.println(" !! Status not such !!");
        }
        je.executeScript("arguments[0].style.border=''", driver.findElement(locator));
    }

    public void logReport(String log, String status) {
        switch (status) {
            case "pass":
                report.log(Status.PASS, log);
                break;
            case "info":
                report.log(Status.INFO, log);
                break;
            case "fail":
                report.log(Status.FAIL, log);
                break;
            default:
                System.out.println(" !! Status not such !!");
        }
    }

    public void createReport() {
        extent.flush();
    }

    public String pictureName() {
        String lexicon = "ABCDEFGHIJKLMNOPQRSTUVWXYZ12345674890";
        String namePicture = "";
        numRand = new Random();
        char[] letter = lexicon.toCharArray();
        String letterOne = String.valueOf(letter[numRand.nextInt(lexicon.length())]);
        String letterTwo = String.valueOf(letter[numRand.nextInt(lexicon.length())]);
        String letterThree = String.valueOf(letter[numRand.nextInt(lexicon.length())]);
        String letterFour = String.valueOf(letter[numRand.nextInt(lexicon.length())]);
        namePicture = letterOne + letterTwo + letterThree + letterFour;
        return namePicture;
    }
}
