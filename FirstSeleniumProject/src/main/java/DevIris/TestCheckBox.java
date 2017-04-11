package DevIris;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by zemoso on 7/4/17.
 */
public class TestCheckBox extends DevBaseClass {
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
        driver.findElement(By.linkText("Dallas")).click();
        driver.findElement(By.cssSelector("tr.resourceRow.ng-scope > td.ng-binding")).click();
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
