package LocalHostTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by zemoso on 4/4/17.
 */
public class Test1 extends CommonClass{

    @BeforeClass
    public void gotoCaseManagement() {
        WebDriver driver = getDriverInstance();
        driver.findElement(By.xpath("//div[@class=\"dropdown open hover\"]/div/button")).click();
        driver.findElement(By.linkText("Case Management")).click();
        assertEquals(driver.getTitle(), "Case Manager Dashboard");
    }

    @Test
    public void testCaseManagerEncounter1() throws Exception {
        driver.findElement(By.cssSelector("span > span.ng-binding")).click();
        driver.findElement(By.linkText("New Encounter")).click();
        new Select(driver.findElement(By.xpath("//div[@id='encounterMainDiv']/div/div/div[2]/div/div/select"))).selectByVisibleText("7124 test");
        new Select(driver.findElement(By.xpath("//div[@id=\"encounterMainDiv\"]/div/div/div[2]/div[2]/div/select"))).selectByVisibleText("service");
        driver.findElement(By.xpath("//div[@id=\"encounterMainDiv\"]/div/div/div[5]/div[2]/spin-edit/div/input")).clear();
        driver.findElement(By.xpath("//div[@id=\"encounterMainDiv\"]/div/div/div[5]/div[2]/spin-edit/div/input")).sendKeys("23");
        driver.findElement(By.xpath("//div[@id=\"encounterMainDiv\"]/div/div/div[6]/div/div/textarea")).clear();
        driver.findElement(By.xpath("//div[@id=\"encounterMainDiv\"]/div/div/div[6]/div/div/textarea")).sendKeys("DFGFGJ");
        driver.findElement(By.xpath("//div[@class=\"encModalFooter modal-footer  encFooter ng-scope\"]/button[3]")).click();
    }

    @AfterClass
    public void returnToCaseManagement() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class=\"dropdown open hover\"]/div/button")).click();
        driver.findElement(By.linkText("Case Management")).click();
    }

}
