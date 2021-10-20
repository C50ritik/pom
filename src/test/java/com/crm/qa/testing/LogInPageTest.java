package com.crm.qa.testing;

import com.crm.qa.base.BaseClass;
import com.crm.qa.pages.LogInPage;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;

public class LogInPageTest extends BaseClass{
    LogInPage loginPage;
    static Logger log= Logger.getLogger(LogInPageTest.class);

    // ScreeShot Method
    public static void toTakeScreenShot(String fileName) throws IOException {
        TakesScreenshot takesScreenshot= (TakesScreenshot) driver;
        File srcFile=takesScreenshot.getScreenshotAs(OutputType.FILE);
        log.info(properties.getProperty("pathOfSs")+fileName+".jpg");
        log.info("C:\\Users\\rchaur1\\Practice\\pom\\screenshot");
        File destFile=new File(properties.getProperty("pathOfSs")+fileName+".jpg");
        FileUtils.copyFile(srcFile,destFile);
        log.info("Screenshot Captured");
    }
    @BeforeClass
    public void setUp(){
        log.info("Initiiation");
        intialization();
        loginPage = new LogInPage();
    }

    @Test(priority=1)
    public void loginPageTitleTest(){
        String title = loginPage.validateLogInPageTitle();
        Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
    }

    @Test(priority=2)
    public void crmLogoImageTest(){
        boolean flag = loginPage.validateCrmImg();
        Assert.assertTrue(flag);
    }

    @Test(priority=3)
    public void loginTest() throws IOException {
        toTakeScreenShot("LogInPage");
        loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }
}
