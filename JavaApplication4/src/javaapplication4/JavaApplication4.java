/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 *
 * @author nabil.ouerhani
 */
public class JavaApplication4 {

    static WebDriver driver;

    public static void main(String[] args) throws InterruptedException {
        // TODO code application logic here

        // Chrome drivers under: http://chromedriver.storage.googleapis.com/index.html?path=2.8/
        System.setProperty("webdriver.chrome.driver", "c:/temp/chromedriver.exe");

        driver = new ChromeDriver();
        driver.get("http://seleniumhq.org/");
        Thread.sleep(3000);

        driver.findElement(By.linkText("Download")).click();
        
        Thread.sleep(2000);            //delay
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.quit();
        

    }
}
