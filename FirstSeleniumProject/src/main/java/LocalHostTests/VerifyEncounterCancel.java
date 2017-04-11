package LocalHostTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by zemoso on 5/4/17.
 */
public class VerifyEncounterCancel extends CommonClass {
    @BeforeClass
    public void gotoCaseManagement() {
        WebDriver driver = getDriverInstance();
        driver.findElement(By.xpath("//div[@class=\"dropdown open hover\"]/div/button")).click();
        driver.findElement(By.linkText("Case Management")).click();
        assertEquals(driver.getTitle(), "Case Manager Dashboard");
    }

    @Test
    public void testVerifyEncounter() throws Exception {
        driver.findElement(By.xpath("//table[@id='clientListTable']/tbody/tr/td/a/span/span[3]")).click();
        driver.findElement(By.linkText("New Encounter")).click();
        new Select(driver.findElement(By.xpath("//div[@id='encounterMainDiv']/div/div/div[2]/div/div/select"))).selectByVisibleText("7124 test");
        new Select(driver.findElement(By.xpath("//div[@id='encounterMainDiv']/div/div/div[2]/div[2]/div/select"))).selectByVisibleText("S2");
        Thread.sleep(2000);
        assertEquals(driver.findElement(By.xpath("//div[@id='encounterMainDiv']/div/div/div[2]/div[4]/div/span/span/input")).getAttribute("value"), "04/05/2017");
        Thread.sleep(2000);
        assertEquals(driver.findElement(By.cssSelector("input.customSpin")).getAttribute("value"), "01");
        driver.findElement(By.xpath("//div[@id='encounterMainDiv']/div/div/div[6]/div/div/textarea")).clear();
        driver.findElement(By.xpath("//div[@id='encounterMainDiv']/div/div/div[6]/div/div/textarea")).sendKeys("qweet");
        driver.findElement(By.xpath("//button[@class='btn cancelbutton pull-right']")).click();

    }

    @AfterClass
    public void returnToCaseManagement() throws InterruptedException {
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class=\"dropdown open hover\"]/div/button")).click();
        driver.findElement(By.linkText("Case Management")).click();
    }
}
