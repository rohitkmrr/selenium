package TestFiles;

import LocalServer.BaseClass;
import TestDevIris.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;

/**
 * Created by zemoso on 11/4/17.
 */
public class PrintEncounterTest extends BaseClass{

    @Autowired
    AdminDashBoardService adminDashBoardService;
    MainMenuPage mainMenuPage = new MainMenuPage();
    CaseManagementDashboardImp caseManagementDashboardImp =  new CaseManagementDashboardImp();

    public static By saveButtonEncounterElement = By.xpath("(//button[@class='btn btn-default ar pull-right'])");
    public static By printEncounterElement = By.id("printEncNotes");
    public static By noteTextInPDF = By.xpath("//div/div[23]");



    private String programName = "7124 test";
    private String serviceName = "newServicesA13";
    private String firstName ="Rohit102";
    private String lastName ="Kumar102";


    @BeforeClass
    public void gotoAdminDashBoard() {
        WebDriver driver = getDriverInstance();
        mainMenuPage.gotoAdminDashBoard(driver);
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
        mainMenuPage.gotoCaseManagerDashBoard(driver);
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
