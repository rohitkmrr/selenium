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
public class ViewResources extends BaseClass {
    @BeforeClass
    public void gotoAdminDashboard() {
        WebDriver driver = getDriverInstance();
        driver.findElement(By.xpath("//div[@class=\"dropdown open hover\"]/div/button")).click();
        driver.findElement(By.linkText("Administration")).click();
        assertEquals(driver.getTitle(), "Admin Dashboard");
    }


    @Test
    public void nameOrder() throws Exception {
        String firstName = "social";
        String lastName = "client";
        String nameStringExpected = lastName + ", " + firstName;
        driver.findElement(By.linkText("View Resources")).click();
        new Select(driver.findElement(By.xpath("//select"))).selectByVisibleText("Ortho Paedics");
        new Select(driver.findElement(By.xpath("//div[2]/select"))).selectByVisibleText("Bed");
        String nameStringActual = driver.findElement(By.xpath("//form[@id='form1']/div/div/div/div[2]/span")).getText();
        assertEquals(nameStringExpected, nameStringActual);
    }

    @AfterClass
    public void returnToAdminDashboard() throws InterruptedException {
        driver.findElement(By.xpath("//h4[@class='panel-title section-title']/span[text()='View Resources']/following-sibling::button[@class='close']")).click();
    }

}
