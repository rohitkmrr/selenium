package TestFiles;

import TestDevIris.*;
import TestDevIris.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;

/**
 * Created by zemoso on 11/4/17.
 */

// JIRA 7891
public class PrintEncounterTest extends LoginPage {

    MainMenuService mainMenuService = new MainMenuService();

    public static By saveButtonEncounterElement = By.xpath("(//button[@class='btn btn-default ar pull-right'])");
    public static By printEncounterElement = By.id("printEncNotes");
    public static By noteTextInPDF = By.xpath("//div/div[23]");

    private String programName = "7124 test";
    private String serviceName = "newServices141";
    private String firstName ="Rohit114";
    private String lastName ="Kumar114";


    @BeforeClass
    public void gotoAdminDashBoard() {
        WebDriver driver = getDriverInstance();
        mainMenuService.gotoAdminDashBoard(driver);
    }

    @Test
    public void printEncounterTest() throws InterruptedException {
        AdminDashBoardService adminDashBoardService = new AdminDashBoardService(driver);
        CaseManagementDashboardService caseManagementDashboardService =  new CaseManagementDashboardService(driver);
        ClientDetailPageService clientDetailPageService = new ClientDetailPageService(driver);

        // make new service with Note field as not required
        adminDashBoardService.addNewServiceWithNoteComponent(programName, serviceName);

        //Goto CaseManager, make a new client
        Thread.sleep(3000);
        mainMenuService.gotoCaseManagerDashBoard(driver);
        caseManagementDashboardService.addNewClient(programName, firstName, lastName);

        //Make a new encounter for the newly made service
        Thread.sleep(2000);
        clientDetailPageService.createNewEncounter(programName, serviceName);
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
