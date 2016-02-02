package com.wonolo.app.Tests;

import com.Jungle_Parameters.JungleDataproviderClass;
import com.wonolo.app.Wonolo.PageMethods.JungleMethods;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.text.DecimalFormat;

import static com.wonolo.app.Wonolo.Assertions.jungle_assertEqual;
import static com.wonolo.app.Wonolo.Assertions.jungle_assertTrue;


public class Jungle_Test extends JungleMethods {

   //add any step here that is necessary to all test prior to executing test steps
   @BeforeMethod(groups={"jungleorder"})
   public void setup() throws Exception {
      try {
         driver = driver();
         // Go to the Jungle homepage
         driver.get(jungle_url);
         }
      catch (Exception e) {
         logError("jungleorder_setup", e);
         }
   }

   //teardown is used to clean up things common to all tests
   @AfterMethod(groups={"jungleorder"})
   public void teardown() throws Exception {
      //cleanup/delete event after test
      driver.close();
   }

    //Post a new Job
   @Test(groups = {"jungleorder"}, dataProvider="JungleProvider", dataProviderClass= JungleDataproviderClass.class)
   public void Jungle_Socks_Order_Test(String testName, String state, String zebra_amount, String lion_amount, String elephant_amount, String giraffe_amount, String subtotal, double rate) throws Exception {
      try {
          log(testName + " state:  " + state);
          elementSendKeys(By.cssSelector(zebra_quantity),zebra_amount);
          elementSendKeys(By.cssSelector(lion_quantity),lion_amount);
          elementSendKeys(By.cssSelector(elephant_quantity), elephant_amount);
          elementSendKeys(By.cssSelector(giraffe_quantity), giraffe_amount);
          Select dropdown = new Select(driver.findElement(By.name("state")));
          dropdown.selectByVisibleText(state);
          driver.findElement(By.cssSelector(checkout)).click();
          String actual_subtotal = getText(By.id("subtotal"));
          String actual_taxes = getText(By.id("taxes"));
          String actual_total = getText(By.id("total"));
          log(actual_subtotal);
          jungle_assertEqual(subtotal, actual_subtotal.substring(1), "Expected subtotal price not found for " + testName + " state:  " + state);
      } catch (Exception e) {
         logError("Jungle_Socks_Order_Test", e);
      }
      //Finally - used to clean up test data specific to a test
      finally {
          log("done");
         }
      }

   private String getText(By by) throws IOException {
      log("[INFO] Get text from Element " + by.toString());
      return driver.findElement(by).getText();
   }

   private void elementSendKeys(By by, String text) throws Exception {
      log("[INFO] Entering text '" + text + "' " + by.toString());
      try {
         driver.findElement(by).sendKeys(text);
      } catch (Exception e) {
         logError("Can't send keys to element " + by.toString(), e);
      }
   }
}
