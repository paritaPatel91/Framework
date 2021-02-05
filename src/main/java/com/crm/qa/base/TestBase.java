package com.crm.qa.base;

import com.crm.qa.util.TestUtil;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Time;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {

   public static WebDriver driver;
   public static Properties prop;

   public TestBase(){

      try {
      prop = new Properties();
         FileInputStream ip = new FileInputStream("C:\\FirstFramework\\practiseframeworkproject\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
          prop.load(ip);
      } catch (FileNotFoundException e) {
         e.printStackTrace();
      } catch (IOException exception) {
         exception.printStackTrace();
      }
   }

   public static void intialization(){
      String browserName = prop.getProperty("browser");
      if (browserName.equals("chrome")){
         System.setProperty("webdriver.chrome.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\chromedriver.exe");
         driver = new ChromeDriver();

      }else if (browserName.equals("FF")){
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\Parita Patel\\Desktop\\WebDrivers\\geckodriver.exe");
            driver = new FirefoxDriver();

         }
      driver.manage().window().maximize();
      driver.manage().deleteAllCookies();
      driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);

      driver.get(prop.getProperty("url"));
      }

   }

