package com.wonolo.app.Wonolo.PageMethods;


import com.wonolo.app.Wonolo.PageElements.JungleElements;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;


public class JungleMethods extends JungleElements {
    //Basic Logging
    public static File logFile() {
        new File("logs").mkdirs();
        long timestamp = new Date().getTime();
        String path = "logs/" + timestamp + "_log.txt";
        return new File(path);
    }

    public static File logFile = logFile();

    public static void log(String message) throws IOException {
        System.out.println(message);
        PrintWriter out = new PrintWriter(new FileWriter(logFile, true), true);
        out.write(message + "\n");
        out.close();
    }

    public static void logError(String testName, Exception e) throws Exception {
        Screenshot();
        String[] ss = ExceptionUtils.getRootCauseStackTrace(e);
        log("---------- ERRROR LOG ----------\nFailed test: " + testName);
        log(StringUtils.join(ss, "\n"));
        log("---------- END ERRROR LOG ----------");
        throw new Exception("[ERROR] Failed test: " + testName);
    }

    public static void Screenshot() throws IOException {
        WebDriver driver = new ChromeDriver();
        long timestamp = new Date().getTime();
        String file = timestamp + ".jpg";
        File scrTempFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File scrFile = new File("Screenshots/" + file);
        FileUtils.copyFile(scrTempFile, scrFile);
        if (System.getenv("JENKINS_URL") != null) {
            log("[INFO] Screenshot: " + System.getenv("JENKINS_URL") + "job/"
                    + System.getenv("JOB_NAME").replace(" ", "%20") + "/ws/Screenshots/" + file);
        } else {
            log("[INFO] Screenshot: " + scrFile.getAbsolutePath());
        }
    }

    public static String random(String testNamePrefix) {
        return testNamePrefix + RandomStringUtils.randomAlphabetic(6).toLowerCase();
    }

    public static String randomUpper(String testNamePrefix) {
        return testNamePrefix + RandomStringUtils.randomAlphabetic(6).toUpperCase();
    }
}
