package TestFiles;

import TestDevIris.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by zemoso on 10/4/17.
 */
public class MakeNewForm extends LoginPage {
    @BeforeClass
    public void gotoAdminDashBoard() {
        WebDriver driver = getDriverInstance();
        driver.findElement(By.xpath("//div[@class=\"dropdown open hover\"]/div/button")).click();
        driver.findElement(By.linkText("Administration")).click();
        assertEquals(driver.getTitle(), "Admin Dashboard");
    }

    @Test
    public void testCheckbox() throws InterruptedException {
//        AdminDashBoardService adminDashBoardServiceImp = new AdminDashBoardService();
//        adminDashBoardServiceImp.addNewFormByFormNameAndProgramName("myForm1", "ProgTemp1", LoginPage.driver);
    }

}
