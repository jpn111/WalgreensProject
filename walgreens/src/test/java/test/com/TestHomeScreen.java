/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test.com;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
public class TestHomeScreen {

    private WebDriver driver;
    private String baseUrl;
    private SoftAssert s_assert;
    private Actions act;

    public TestHomeScreen() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
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
        driver.get(baseUrl);
        driver.manage().window().maximize();
    }

    @Test(description = "Validate Content Of Walgreens Home Screen")
    public void validateHomePage() {
        s_assert = new SoftAssert();
        s_assert.assertEquals(driver.getTitle(), "Walgreens. Trusted Since 1901.");
        s_assert.assertTrue(driver.findElement(By.xpath("//*[@id=\'wagHeaderLogo\']/a/span")).isDisplayed());
        s_assert.assertAll();

    }

    @Test(description = "Validate List Items of RxRefill")
    public void validateRxRefills() throws InterruptedException {
        s_assert = new SoftAssert();
        s_assert.assertEquals(driver.findElement(By.linkText("Rx Refills")).getText(), "Rx Refills");
        act = new Actions(driver);
        act.moveToElement(driver.findElement(By.linkText("Rx Refills"))).perform();
        Thread.sleep(1000);
        s_assert.assertEquals("Refill Prescriptions", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Rx Refills'])[1]/following::span[1]")).getText());
        s_assert.assertEquals("Rx Status", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Refill Prescriptions'])[2]/following::span[1]")).getText());
        s_assert.assertEquals("Auto Refill", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Rx Status'])[1]/following::span[1]")).getText());
        s_assert.assertEquals("Request New Rx", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Auto Refill'])[1]/following::span[1]")).getText());
        s_assert.assertEquals("Transfer Rx", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Request New Rx'])[1]/following::span[1]")).getText());
        s_assert.assertEquals("Rx Settings", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Transfer Rx'])[1]/following::span[1]")).getText());
        s_assert.assertEquals("Print Rx Records", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Rx Settings'])[1]/following::span[1]")).getText());
        s_assert.assertEquals("Drug Information", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Print Rx Records'])[1]/following::span[1]")).getText());
        s_assert.assertEquals("More Pharmacy Services ›", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Drug Information'])[1]/following::span[1]")).getText());
        s_assert.assertAll();
    }

    @Test(description = "Validate List Items of Health Info")
    public void validateHealthInfo() throws InterruptedException {
        s_assert = new SoftAssert();
        s_assert.assertEquals("Health Info & Services", driver.findElement(By.linkText("Health Info & Services")).getText());
        act = new Actions(driver);
        act.moveToElement(driver.findElement(By.linkText("Health Info & Services"))).perform();
        Thread.sleep(1000);
        s_assert.assertEquals("Find Care", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Health Info & Services'])[1]/following::span[1]")).getText());
        s_assert.assertEquals("Walgreens Care Connect", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Find Care'])[1]/following::span[1]")).getText());
        s_assert.assertEquals("Appointment Scheduler", driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Walgreens Care Connect'])[1]/following::span[1]")).getText());
        s_assert.assertAll();
    }

    @Test(description = "Validate List Items of Contact Lenses")
    public void validateContactLenses() throws InterruptedException {
        s_assert = new SoftAssert();
        s_assert.assertEquals("Contact Lenses", driver.findElement(By.linkText("Contact Lenses")).getText());
        act = new Actions(driver);
        act.moveToElement(driver.findElement(By.linkText("Contact Lenses"))).perform();
        Thread.sleep(1000);
        s_assert.assertEquals("Reorder Contact Lenses", driver.findElement(By.linkText("Reorder Contact Lenses")).getText());
        s_assert.assertEquals("Shop All Contact Lenses", driver.findElement(By.linkText("Shop All Contact Lenses")).getText());
        s_assert.assertAll();
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
        driver.close();
    }

    private void IsTrue(WebElement findElement) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
