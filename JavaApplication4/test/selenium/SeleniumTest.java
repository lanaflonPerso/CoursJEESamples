/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package selenium;

import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 *
 * @author nabil.ouerhani
 */
public class SeleniumTest {

    static WebDriver driver;

    public SeleniumTest() {
    }

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "c:/temp/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("http://seleniumhq.org/");
        
        System.out.println("Browser started");
         }

    @After
    public void tearDown() {
        driver.quit();

    }
    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //

    @Test
    public void selText() throws InterruptedException {


        //   Thread.sleep(3000);

        driver.findElement(By.linkText("Download")).click();

       // Thread.sleep(2000);            //delay
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        
        driver.get("http://www.google.com");
        
        WebElement webEl = driver.findElement(By.xpath("//*[@id=\"gbqfq\"]"));
        System.out.println("Id of Search area = "+ webEl.getAttribute("id"));
        
        webEl = driver.findElement(By.id("gbqfq"));
        
        System.out.println("Xpath of Search area = "+ webEl.getAttribute("id"));
               
        webEl.sendKeys("my search");

        Thread.sleep(4000); 
              

    } 
    
     @Test
    public void selText2() throws InterruptedException {


        //   Thread.sleep(3000);

        driver.findElement(By.linkText("Download")).click();

       // Thread.sleep(2000);            //delay
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        
        driver.get("http://www.google.com");
        
        WebElement webEl = driver.findElement(By.xpath("//*[@id=\"gbqfq\"]"));
        
        System.out.println("Id of Search area = "+ webEl.getAttribute("id"));
        
        webEl = driver.findElement(By.id("gbqfq"));
        
        System.out.println("Xpath of Search area = "+ webEl.getAttribute("id"));
               
        webEl.sendKeys("my search");

        Thread.sleep(4000); 
          
        

    } 
}