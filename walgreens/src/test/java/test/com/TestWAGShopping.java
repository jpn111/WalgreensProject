/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.com;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/**
 *
 * @author jnellith
 */
public class TestWAGShopping {

    private WebDriver driver;
    private String baseUrl;
    private SoftAssert s_assert;
    private Actions act;

    public TestWAGShopping() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test(description = "Validate Walgreens Online Shopping")
    public void shopWAG() throws InterruptedException {
        driver.findElement(By.id("ntt-placeholder")).click();
        driver.findElement(By.id("ntt-placeholder")).clear();
        driver.findElement(By.id("ntt-placeholder")).sendKeys("Tylenol");
        driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Skip to main content'])[1]/following::span[3]")).click();
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
        System.setProperty("webdriver.chrome.driver", "C:\\data\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.walgreens.com/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(baseUrl);

    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        driver.close();
    }
}
