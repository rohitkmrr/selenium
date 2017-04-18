package TestFiles;

import LocalServer.BaseClass;
import TestDevIris.AdminDashBoardServiceImp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by zemoso on 18/4/17.
 */
public class CheckTextBox extends BaseClass{
    PrintEncounterTest printEncounterTest = new PrintEncounterTest();
    public String location ="";
    public static By locationAndResourcesLink = By.linkText("Locations and Resources");
    public static By editResourcePool = By.linkText("Edit");
    public static By discardSavingResourcePool = By.xpath("//button[text()='Cancel']");
    public static By checkBoxForProgramEdit = By.xpath("//div/label[text()='Restrictions']/following-sibling::div/div/input[@ng-model='restrictions.program']");
    public static By checkBoxForProgram = By.xpath("//input[@ng-model='restrictionsObj.program']");
    public static By closeResourcePoolEdit = By.xpath("//span[text()='Resource Pool Detail']/following-sibling::button[@class='close']");
    public static By closeLocationAndResourceModal = By.xpath("//button[@class='close configure_facility']");

    //1. goto AdminDashBoard
    @BeforeClass
    public void gotoAdminDashBoard() {
        WebDriver driver = getDriverInstance();
        driver.findElement(printEncounterTest.mainMenuDropDownButtonElement).click();
        driver.findElement(printEncounterTest.adminDashboardLink).click();
        assertEquals(driver.getTitle(), "Admin Dashboard");
    }

    @Test
    public void testCheckBox() throws InterruptedException {
        AdminDashBoardServiceImp adminDashBoardServiceImp = new AdminDashBoardServiceImp();

        //2. For a program, check its location and store it in a variable
        String programName = "7124 test";
        String resourceType = "Bed";
        String resourcePoolName = "bed19";

        location = adminDashBoardServiceImp.findLocationOfProgram(driver, programName);
        //3. click on Location and Resources
        Thread.sleep(3000);
        driver.findElement(locationAndResourcesLink).click();

        //4. click on stored location
        driver.findElement(By.linkText(location)).click();

        //5. add new resource pool without restriction
        adminDashBoardServiceImp.addNewResourcePool(driver, resourceType, resourcePoolName);

        //6, click on that particular resources.
        Thread.sleep(3000);
        driver.findElement(By.linkText(location)).click();

        //7. edit it
        driver.findElement(By.xpath("//tr/td[text() = '"+resourcePoolName+"']")).click();
        driver.findElement(editResourcePool).click();
        driver.findElement(checkBoxForProgramEdit).click();
        driver.findElement(discardSavingResourcePool).click();

        //9. assert for the checkbox( should be unchecked)
        assertEquals(false, driver.findElement(checkBoxForProgram).isSelected());

        //10. Close Location & Resources Modal
        Thread.sleep(2000);
        driver.findElement(closeResourcePoolEdit).click();
        Thread.sleep(2000);
        driver.findElement(closeLocationAndResourceModal).click();

    }


}
