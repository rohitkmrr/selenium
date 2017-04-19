package TestFiles;

import LocalServer.BaseClass;
import TestDevIris.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.test.context.ContextConfiguration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotEquals;

/**
 * Created by zemoso on 11/4/17.
 */

// JIRA 7891
@ContextConfiguration(locations = {"/applicationContext.xml"})
public class PrintEncounterTest extends BaseClass{

    MainMenuPage mainMenuPage = new MainMenuPage();

   /* @Autowired
    MainMenuPage mainMenuPage;

    @Autowired
    CaseManagementDashboardImp caseManagementDashboardImp;*/


    public static By saveButtonEncounterElement = By.xpath("(//button[@class='btn btn-default ar pull-right'])");
    public static By printEncounterElement = By.id("printEncNotes");
    public static By noteTextInPDF = By.xpath("//div/div[23]");



    private String programName = "7124 test";
    private String serviceName = "newServices137";
    private String firstName ="Rohit110";
    private String lastName ="Kumar110";


    @BeforeClass
    public void gotoAdminDashBoard() {
        WebDriver driver = getDriverInstance();
        mainMenuPage.gotoAdminDashBoard(driver);
    }

    @Test
    public void printEncounterTest() throws InterruptedException {
        AdminDashBoardServiceImp adminDashBoardServiceImp = new AdminDashBoardServiceImp(driver);
        CaseManagementDashboardImp caseManagementDashboardImp =  new CaseManagementDashboardImp(driver);
        ClientDetailPageServiceImp clientDetailPageServiceImp = new ClientDetailPageServiceImp(driver);

        // make new service with Note field as not required
        adminDashBoardServiceImp.addNewServiceWithNoteComponent(programName, serviceName);

        //Goto CaseManager, make a new client
        Thread.sleep(3000);
        mainMenuPage.gotoCaseManagerDashBoard(driver);
        caseManagementDashboardImp.addNewClient(programName, firstName, lastName);

        //Make a new encounter for the newly made service
        Thread.sleep(2000);
        clientDetailPageServiceImp.createNewEncounter(programName, serviceName);
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
