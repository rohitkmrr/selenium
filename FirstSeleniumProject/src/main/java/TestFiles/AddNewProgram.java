package TestFiles;

import LocalServer.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


/**
 * Created by zemoso on 10/4/17.
 */
public class AddNewProgram extends BaseClass {
    @BeforeClass
    public void gotoAdminDashBoard() {
        WebDriver driver = BaseClass.getDriverInstance();
        driver.findElement(By.xpath("//div[@class=\"dropdown open hover\"]/div/button")).click();
        driver.findElement(By.linkText("Administration")).click();
        assertEquals(driver.getTitle(), "Admin Dashboard");
    }

    @Test
    public void testCheckbox() throws InterruptedException {
//        AdminDashBoardServiceImp adminDashBoardServiceImp = new AdminDashBoardServiceImp();
//        adminDashBoardServiceImp.enterProgramDetailsDuringAddNewProgram("ProgTemp1", BaseClass.driver);
//        adminDashBoardServiceImp.addServicesDuringAddNewProgram(BaseClass.driver);
    }

    @AfterClass
    public void returnToCaseManagement() throws InterruptedException {
        Thread.sleep(2000);
        BaseClass.driver.findElement(By.xpath("(//button[@type='button'])[15]")).click();
        BaseClass.driver.findElement(By.cssSelector("button.close.ng-scope")).click();
    }
}
