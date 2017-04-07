import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by zemoso on 5/4/17.
 */
public class PrintEncounter extends CommonClass {

    @BeforeClass
    public void gotoCaseManagement() {
        WebDriver driver = getDriverInstance();
        driver.findElement(By.xpath("//div[@class=\"dropdown open hover\"]/div/button")).click();
        driver.findElement(By.linkText("Case Management")).click();
        assertEquals(driver.getTitle(), "Case Manager Dashboard");

        // make a new encounter
    }

    @Test
    public void testPrintEncounter() throws Exception {
        driver.findElement(By.xpath("//table[@id='clientListTable']/tbody/tr/td/a/span/span[3]")).click();
        driver.findElement(By.id("printEncNotes")).click();
    }

    @AfterClass
    public void returnToCaseManagement() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class=\"dropdown open hover\"]/div/button")).click();
        driver.findElement(By.linkText("Case Management")).click();
    }
}
