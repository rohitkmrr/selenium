import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by zemoso on 27/3/17.
 */
public class MyFirstTest {

    public String baseUrl = "http://newtours.demoaut.com/";
    String driverPath = "C:\\geckodriver.exe";
    public WebDriver driver;

    @Test
    public void startWebDriver() {
        System.out.println("launching firefox browser");
        System.setProperty("webdriver.firefox.marionette", driverPath);
        driver = new FirefoxDriver();
        driver.get(baseUrl);
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
        driver.close();
    }


}
