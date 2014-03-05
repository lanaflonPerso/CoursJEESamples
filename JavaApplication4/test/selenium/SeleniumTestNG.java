/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium;

import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.Test;

/**
 *
 * @author nabil.ouerhani
 */
public class SeleniumTestNG {

    static WebDriver driver;

    public SeleniumTestNG() {
    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void seleniumTestNG() throws InterruptedException {

        Thread.sleep(3000);

        driver.findElement(By.linkText("Download")).click();

        Thread.sleep(2000);            //delay
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();

        Thread.sleep(2000);

    }

    @BeforeMethod
    public void setUpMethod() throws Exception {

        System.setProperty("webdriver.chrome.driver", "c:/temp/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("http://seleniumhq.org/");

    }

    @AfterMethod
    public void tearDownMethod() throws Exception {

        driver.quit();
    }
}