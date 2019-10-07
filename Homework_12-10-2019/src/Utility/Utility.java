package Utility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utility {

    WebDriver driver;

    public Utility(WebDriver driver) {
        this.driver = driver;
    }

    // Method to click on any element by name/id/xpath/link text etc..
    public void ClickOnElement(By by){
        driver.findElement(by).click();
    }

    // Method to send text to any element by name/id/xpath/link text etc..
    public void SendTextToElement(By by, String str)
    {
        driver.findElement(by).sendKeys(str);
    }

    // Method to select drop-down menu by given value
    public void DropDownMenuSelectByValue(By by, String str)
    {
        WebElement element = driver.findElement(by);
        Select sel = new Select(element);
        sel.selectByValue(str);
    }

    // Method to select drop-down menu by given text
    public void DropDownMenuSelectByText(By by, String str)
    {
        WebElement element = driver.findElement(by);
        Select sel = new Select(element);
        sel.selectByVisibleText(str);
    }

    // Method to select drop-down menu by given index number
    public void DropDownMenuSelectByIndex(By by, int index)
    {
        WebElement element = driver.findElement(by);
        Select sel = new Select(element);
        sel.selectByIndex(index);
    }

    // Method to sleep (Pause) the browser for given seconds
    public void sleep_browser(int seconds) throws InterruptedException {
        Thread.sleep(seconds*1000);
    }

}
