package TestFiles;

import DevIris.DevBaseClass;
import TestDevIris.AdminDashBoardService;
import TestDevIris.AdminDashBoardServiceImp;
import TestDevIris.CaseManagementDashboardImp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

/**
 * Created by zemoso on 11/4/17.
 */
public class PrintEncounterTest extends DevBaseClass{

    @Autowired
    AdminDashBoardService adminDashBoardService;

    private static By mainMenuDropDownButtonElement = By.xpath("//div[@class=\"dropdown open hover\"]/div/button");
    private static By adminDashboardLink = By.linkText("Administration");
    private static By closeButtonForToastElement = By.xpath("//button[@ng-click='closeClick(toasty)']");
    private static By menuDropDownElement = By.cssSelector("button.dropdown_button");
    private static By cwDashboardElement = By.linkText("Case Management");
    private static By newEncounterLink = By.linkText("New Encounter");
    private static By programNameInEncounterElement = By.xpath("//div[@id='encounterMainDiv']/div/div/div[2]/div/div/select");
    private static By serviceNameInEncounterElement = By.xpath("//div[@id='encounterMainDiv']/div/div/div[2]/div[2]/div/select");
    private static By saveButtonEncounterElement = By.xpath("(//button[@class='btn btn-default ar pull-right'])");
    private static By printEncounterElement = By.id("printEncNotes");
    private static By noteTextInPDF = By.xpath("//div/div[23]");


    @BeforeClass
    public void gotoAdminDashBoard() {
        WebDriver driver = getDriverInstance();
        driver.findElement(mainMenuDropDownButtonElement).click();
        driver.findElement(adminDashboardLink).click();
        assertEquals(driver.getTitle(), "Admin Dashboard");
    }

    @Test
    public void printEncounterTest() throws InterruptedException {

        // make new service with Note field as not required
        String programName = "Food Coupon";
        String serviceName = "newServices12";

        AdminDashBoardServiceImp adminDashBoardServiceImp = new AdminDashBoardServiceImp();
        adminDashBoardServiceImp.addNewServiceWithNoteComponent(programName, driver, serviceName);

        //Goto CaseManager, make a new client
        driver.findElement(closeButtonForToastElement).click();
        /*WebDriverWait wait=new WebDriverWait(driver, 20);
        WebElement dropdownButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.dropdown_button")));
        dropdownButton.click();*/
        Thread.sleep(3000);
        driver.findElement(menuDropDownElement).click();
        driver.findElement(cwDashboardElement).click();
        CaseManagementDashboardImp caseManagementDashboardImp =  new CaseManagementDashboardImp();
        caseManagementDashboardImp.addNewClient(driver, programName);

        //Make a new encounter for the newly made service
        Thread.sleep(2000);
        driver.findElement(newEncounterLink).click();
        new Select(driver.findElement(programNameInEncounterElement)).selectByVisibleText(programName);
        new Select(driver.findElement(serviceNameInEncounterElement)).selectByVisibleText(serviceName);
        driver.findElement(saveButtonEncounterElement).click();

        //print that service
        String winHandleBefore = driver.getWindowHandle();
        Thread.sleep(2000);
        driver.findElement(printEncounterElement).click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

        String note = driver.findElement(noteTextInPDF).getText();
        assertNotEquals("Note: null", note);
        driver.close();

        // Switch back to original browser (first window)
        driver.switchTo().window(winHandleBefore);

    }


}
