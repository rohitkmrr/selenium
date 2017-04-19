package TestFiles;

import LocalServer.BaseClass;
import TestDevIris.AdminDashBoardServiceImp;
import TestDevIris.CaseManagementDashboardImp;
import TestDevIris.ClientDetailPageServiceImp;
import TestDevIris.MainMenuPage;
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
    CaseManagementDashboardImp caseManagementDashboardImp =  new CaseManagementDashboardImp();

   /* @Autowired
    MainMenuPage mainMenuPage;

    @Autowired
    CaseManagementDashboardImp caseManagementDashboardImp;*/


    public static By saveButtonEncounterElement = By.xpath("(//button[@class='btn btn-default ar pull-right'])");
    public static By printEncounterElement = By.id("printEncNotes");
    public static By noteTextInPDF = By.xpath("//div/div[23]");



    private String programName = "7124 test";
    private String serviceName = "newServices134";
    private String firstName ="Rohit106";
    private String lastName ="Kumar106";


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
