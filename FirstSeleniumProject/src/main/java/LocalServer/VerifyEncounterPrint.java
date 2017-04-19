package LocalServer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;

/**
 * Created by zemoso on 6/4/17.
 */
public class VerifyEncounterPrint extends BaseClass {
    @BeforeClass
    public void gotoCaseManagement() throws InterruptedException {
        WebDriver driver = getDriverInstance();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class=\"dropdown open hover\"]/div/button")).click();
        driver.findElement(By.linkText("Case Management")).click();
    }

    @Test
    public void testPrintEncounter() throws Exception {
//        driver.findElement(By.xpath("//table[@id='clientListTable']/tbody/tr[2]/td/a/span/span")).click();
//        createEncounter();
        String winHandleBefore = driver.getWindowHandle();
        Thread.sleep(2000);
        driver.findElement(By.id("printEncNotes")).click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }
        String note = driver.findElement(By.xpath("//div/div[31]")).getText();
        assertNotEquals("Note: null", note);
        System.out.println("Element text is " + note);
        driver.close();

        // Switch back to original browser (first window)
        driver.switchTo().window(winHandleBefore);

    }

    @AfterClass
    public void returnToCaseManagement() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class=\"dropdown open hover\"]/div/button")).click();
        driver.findElement(By.linkText("Case Management")).click();
    }
}
