package com.wonolo.app.Wonolo;

import com.wonolo.app.Wonolo.PageMethods.JungleMethods;
import org.testng.Assert;

import java.io.IOException;
import static org.testng.Assert.*;

public class Assertions {

   public static void jungle_assertTrue(boolean element, String message) throws IOException {
      //Two basic assertions for Wonolo Testing
      try {
         assertTrue(element, message);
      } catch (Throwable e) {
         JungleMethods.Screenshot();
         JungleMethods.log("[ERROR] " + message);
         throw new RuntimeException("[ERROR] " + message);
      }
   }

   public static void jungle_assertEqual(String expected, String actual, String message) throws IOException {
      try {
         assertEquals(expected, actual, message);
      } catch (Throwable e) {
         JungleMethods.Screenshot();
         JungleMethods.log("[ERROR] " + message);
         throw new RuntimeException("[ERROR] " + message);
      }
   }

   public static void jungle_fail(String message) throws IOException {
      JungleMethods.Screenshot();
      JungleMethods.log(message);
      Assert.fail(message);

   }
}
