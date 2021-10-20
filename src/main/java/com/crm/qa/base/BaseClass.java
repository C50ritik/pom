package com.crm.qa.base;

import com.crm.qa.utility.TestUtill;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;
    public static Properties properties;

    public BaseClass() {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir")+ "/src/main/java/com/crm"
                    + "/qa/config/config.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
        e.printStackTrace();
    }
    }

    public void intialization(){
        String browser=properties.getProperty("browser");
        if(browser.equals("chrome")){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        }
        else {
            WebDriverManager.edgedriver().setup();
            driver=new EdgeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtill.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtill.IMPLICIT_WAIT,TimeUnit.MILLISECONDS);
        driver.get(properties.getProperty("url"));
    }
}
