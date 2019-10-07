import Utility.Utility;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.awt .*;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Nopcom_Regestration {

        private WebDriver driver;
        private Utility util;

        @Before
        public void setup()
        {
            String baseurl = "https://demo.nopcommerce.com/";
            System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
            driver = new ChromeDriver();

            driver.get(baseurl);
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            util = new Utility(driver);
        }

        @Test
        public void NavigateToRegisterPageSuccessfully()
        {
            util.ClickOnElement(By.linkText("Register"));
            Assert.assertEquals("nopCommerce demo store. Register",driver.getTitle());
        }

        @Test
        public void FillUpRegistrarionForm()
        {
            util.ClickOnElement(By.linkText("Register"));

            util.ClickOnElement(By.xpath("//span[@class='male']"));
            util.SendTextToElement(By.id("FirstName"),"Aishwairya");
            util.SendTextToElement(By.id("LastName"),"Patel");


            util.DropDownMenuSelectByValue(By.xpath("//select[@name='DateOfBirthDay']"),"23");
            util.DropDownMenuSelectByIndex(By.xpath("//select[@name='DateOfBirthMonth']"),8);
            util.DropDownMenuSelectByText(By.xpath("//select[@name='DateOfBirthYear']"),"1985");

            String emailId =  "Aishwairya" + ((Math.random() * Integer.MAX_VALUE)) + "@gmail.com";

            util.SendTextToElement(By.id("Email"),emailId);
            System.out.println("Email ID  = " +emailId);

            util.SendTextToElement(By.id("Company"),"UPSoftware Ltd");
            util.SendTextToElement(By.id("Password"),"raja1234");
            util.SendTextToElement(By.id("ConfirmPassword"),"raja1234");

            util.ClickOnElement(By.xpath("//input[@id='register-button']"));
            String expectedText = "Your registration completed";
            String actualText  = driver.findElement(By.xpath("//div[@class='result']")).getText();

            Assert.assertEquals(expectedText,actualText);

        }

        @After
        public void closingdown() throws InterruptedException {
            util.sleep_browser(3);
            driver.quit();
        }
    }