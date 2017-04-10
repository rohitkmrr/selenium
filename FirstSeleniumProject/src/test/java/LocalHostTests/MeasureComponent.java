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
public class MeasureComponent extends CommonClass{

    @BeforeClass
    public void gotoCaseManagement() {
        WebDriver driver = getDriverInstance();
        driver.findElement(By.xpath("//div[@class=\"dropdown open hover\"]/div/button")).click();
        driver.findElement(By.linkText("Case Management")).click();
        assertEquals(driver.getTitle(), "Case Manager Dashboard");
    }

    @Test
    public void testMeasureComponent() throws Exception {
        driver.findElement(By.xpath("//table[@id='clientListTable']/tbody/tr/td/a/span/span[3]")).click();
        driver.findElement(By.linkText("New Encounter")).click();
        new Select(driver.findElement(By.xpath("//div[@id='encounterMainDiv']/div/div/div[2]/div/div/select"))).selectByVisibleText("7124 test");
        new Select(driver.findElement(By.xpath("//div[@id='encounterMainDiv']/div/div/div[2]/div[2]/div/select"))).selectByVisibleText("S2");
        Thread.sleep(2000);
        assertEquals(driver.findElement(By.xpath("//div[@id='encounterMainDiv']/div/div/div[5]/div[2]/spin-edit/div/input")).getAttribute("value"), "01");
    }

    @AfterClass
    public void returnToCaseManagement() throws InterruptedException {
        driver.findElement(By.xpath("//div[3]/button[3]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class=\"dropdown open hover\"]/div/button")).click();
        driver.findElement(By.linkText("Case Management")).click();
    }


}
