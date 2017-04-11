package LocalServer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

/**
 * Created by zemoso on 7/4/17.
 */
class Encounter extends BaseClass{

    public void createEncounter1() {
        WebDriver driver = getDriverInstance();
        driver.findElement(By.xpath("//div[@class=\"dropdown open hover\"]/div/button")).click();
        driver.findElement(By.linkText("Service Delivery")).click();
        assertEquals(driver.getTitle(), "Service Delivery Dashboard");
    }




}
