package TestFiles;

import LocalServer.BaseClass;
import TestDevIris.AdminDashBoardService;
import TestDevIris.AdminDashBoardServiceImp;
import TestDevIris.CaseManagementDashboardImp;
import TestDevIris.ClientDetailPageServiceImp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotEquals;

/**
 * Created by zemoso on 11/4/17.
 */
public class PrintEncounterTest extends BaseClass{

    @Autowired
    AdminDashBoardService adminDashBoardService;

    public static By mainMenuDropDownButtonElement = By.xpath("//div[@class=\"dropdown open hover\"]/div/button");
    public static By adminDashboardLink = By.linkText("Administration");
    public static By menuDropDownElement = By.cssSelector("button.dropdown_button");
    public static By cwDashboardElement = By.linkText("Case Management");

    public static By saveButtonEncounterElement = By.xpath("(//button[@class='btn btn-default ar pull-right'])");
    public static By printEncounterElement = By.id("printEncNotes");
    public static By noteTextInPDF = By.xpath("//div/div[23]");



    private String programName = "7124 test";
    private String serviceName = "newServicesF";
    private String firstName ="RohitAA";
    private String lastName ="kumarAA";


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

        AdminDashBoardServiceImp adminDashBoardServiceImp = new AdminDashBoardServiceImp();
        ClientDetailPageServiceImp clientDetailPageServiceImp = new ClientDetailPageServiceImp();
        adminDashBoardServiceImp.addNewServiceWithNoteComponent(programName, driver, serviceName);

        //Goto CaseManager, make a new client

        /*WebDriverWait wait=new WebDriverWait(driver, 20);
        WebElement dropdownButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button.dropdown_button")));
        dropdownButton.click();*/
        Thread.sleep(3000);
        driver.findElement(menuDropDownElement).click();
        driver.findElement(cwDashboardElement).click();
        CaseManagementDashboardImp caseManagementDashboardImp =  new CaseManagementDashboardImp();
        caseManagementDashboardImp.addNewClient(driver, programName, firstName, lastName);

        //Make a new encounter for the newly made service
        Thread.sleep(2000);
        clientDetailPageServiceImp.createNewEncounter(driver, programName, serviceName);
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
