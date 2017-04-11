package LocalServer;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by zemoso on 6/4/17.
 */
public class TestCheckBox extends BaseClass {
    @BeforeClass
    public void gotoCaseManagement() {
        WebDriver driver = getDriverInstance();
        driver.findElement(By.xpath("//div[@class=\"dropdown open hover\"]/div/button")).click();
        driver.findElement(By.linkText("Administration")).click();
        assertEquals(driver.getTitle(), "Admin Dashboard");
    }

    @Test
    public void testCheckbox() throws Exception {
        driver.findElement(By.linkText("Locations and Resources")).click();
        driver.findElement(By.linkText("Ortho Paedics")).click();
        driver.findElement(By.xpath("//div[@id='location0']/ng-form/div[5]/table/tbody/tr[3]/td")).click();
        driver.findElement(By.linkText("Edit")).click();
        driver.findElement(By.xpath("(//input[@type='checkbox'])[4]")).click();
        driver.findElement(By.cssSelector("div.pull-right > button.btn")).click();
        assertEquals(false, driver.findElement(By.xpath("//div[@id='addResourcePool']/div/div/div/div/input")).isSelected());


    }


    @AfterClass
    public void returnToCaseManagement() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//h4[@class='panel-title section-title']/span[text()='Resource Pool Detail']/following-sibling::button[@class='close']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//h4[@id='myModalLabel']/button[@class='close configure_facility']")).click();
    }

}
