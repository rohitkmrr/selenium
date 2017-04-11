package LocalServer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by zemoso on 6/4/17.
 */
public class CheckIncrement extends BaseClass {
    @BeforeClass
    public void gotoServiceDelivery() throws InterruptedException {
        WebDriver driver = getDriverInstance();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class=\"dropdown open hover\"]/div/button")).click();
        driver.findElement(By.linkText("Service Delivery")).click();
        assertEquals(driver.getTitle(), "Service Delivery Dashboard");
    }

    @Test
    public void checkIncrement() throws Exception {
        new Select(driver.findElement(By.xpath("//div[@id='serviceDelivery']/div/div/div[2]/div[3]/div/select"))).selectByVisibleText("Food Coupons");
        new Select(driver.findElement(By.xpath("//div[@id='serviceDelivery']/div/div/div[2]/div[3]/div[2]/select"))).selectByVisibleText("service11");
        new Select(driver.findElement(By.xpath("//div[@id='serviceDelivery']/div/div/div[2]/div[3]/div[3]/select"))).selectByVisibleText("Ortho Paedics");
        driver.findElement(By.xpath("(//button[@type='button'])[7]")).click();
        new Select(driver.findElement(By.xpath("//div[@id='serviceDelivery']/div/div/div[2]/div[4]/div/select"))).selectByVisibleText("Food Coupons");
        new Select(driver.findElement(By.xpath("//div[@id='serviceDelivery']/div/div/div[2]/div[4]/div[2]/select"))).selectByVisibleText("service11");
        new Select(driver.findElement(By.xpath("//div[@id='serviceDelivery']/div/div/div[2]/div[4]/div[3]/select"))).selectByVisibleText("Select Location");
        assertEquals("Batch Preselection: 1", driver.findElement(By.xpath("//div[@id='serviceDelivery']/div/div/div")).getText());

    }

    @AfterClass
    public void returnToAdminDashboard() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class=\"dropdown open hover\"]/div/button")).click();
        driver.findElement(By.linkText("Administration")).click();
    }


}
