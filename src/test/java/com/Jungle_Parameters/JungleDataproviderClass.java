package com.Jungle_Parameters;

import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;

public class JungleDataproviderClass {
   @DataProvider(name = "JungleProvider")
   public static Object[][] getDataFromJRIPostJobDataprovider(Method m) {
         return new Object[][]{
                 {"happy_path","California","20","10","1","10","665.00", 0.08},
                 {"None ordered","California","0","0","0","0","0.00",0.08},
                 {"Max ordered","California","23","12","2","15","864.00",0.08},
                 {"Too many ordered","California","24","13","3","16","949.00",0.08},
                 {"happy_path","New York","20","10","1","10","665.00", 0.06},
                 {"None ordered","New York","0","0","0","0","0.00",0.06},
                 {"Max ordered","New York","23","12","2","15","864.00",0.06},
                 {"Too many ordered","New York","24","13","3","16","949.00",0.06},
                 {"happy_path","Minnesota","20","10","1","10","665.00", 0.00},
                 {"None ordered","Minnesota","0","0","0","0","0.00",0.00},
                 {"Max ordered","Minnesota","23","12","2","15","864.00",0.00},
                 {"Too many ordered","Minnesota","24","13","3","16","949.00",0.00},
                 {"happy_path","Kansas","20","10","1","10","665.00",0.05},
                 {"None ordered","Kansas","0","0","0","0","0.00",0.05},
                 {"Max ordered","Kansas","23","12","2","15","864.00",0.05},
                 {"Too many ordered","Kansas","24","13","3","16","949.00",0.05}
         };
   }
}

