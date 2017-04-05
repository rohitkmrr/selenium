import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by zemoso on 4/4/17.
 */
public class Test2 extends CommonClass {
    @BeforeClass
    public void gotoCaseManagement() throws InterruptedException {
        WebDriver driver = getDriverInstance();
        driver.findElement(By.xpath("//div[@class=\"dropdown open hover\"]/div/button")).click();
        driver.findElement(By.linkText("Case Management")).click();
        assertEquals(driver.getTitle(), "Case Manager Dashboard");
    }

    @Test
    public void testCaseManagerEncounter2() throws Exception {
        driver.findElement(By.cssSelector("span > span.ng-binding")).click();
        driver.findElement(By.linkText("New Encounter")).click();
    }

    @AfterClass
    public void returnToCaseManagement() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class=\"encModalFooter modal-footer  encFooter ng-scope\"]/button[3]")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class=\"dropdown open hover\"]/div/button")).click();
        driver.findElement(By.linkText("Case Management")).click();
    }
}
