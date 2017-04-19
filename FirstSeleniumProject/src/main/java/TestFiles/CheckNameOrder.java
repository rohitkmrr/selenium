package TestFiles;

import LocalServer.BaseClass;
import TestDevIris.AdminDashBoardServiceImp;
import TestDevIris.CaseManagementDashboardImp;
import TestDevIris.ClientDetailPageServiceImp;
import TestDevIris.MainMenuPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by zemoso on 18/4/17.
 */
public class CheckNameOrder extends BaseClass{
    PrintEncounterTest printEncounterTest = new PrintEncounterTest();
    AdminDashBoardServiceImp adminDashBoardServiceImp = new AdminDashBoardServiceImp();
    CaseManagementDashboardImp caseManagementDashboardImp = new CaseManagementDashboardImp();
    ClientDetailPageServiceImp clientDetailPageServiceImp = new ClientDetailPageServiceImp();
    CheckTextBox checkTextBox = new CheckTextBox();
    MainMenuPage mainMenuPage = new MainMenuPage();

    public static By resourceAssignmentInService = By.xpath("//input[@ng-model='componentList.resourceAssignment']");
    public static By resourceTypeInService = By.xpath("//label[text()='Resource Type']/following-sibling::div/select");
    public static By locationAndResourceLink = By.linkText("Locations and Resources");
    public static By addResourcePoolLink =By.xpath("//strong[text()='Add Resource Pool']");
    public static By resourceTypeInput = By.xpath("//label[text()='Resource Type']/following-sibling::div/select");
    public static By resourcePoolNameInput = By.xpath("//label[text()='Resource Pool Name']/following-sibling::div/input");
    public static By saveResourcePoolButton = By.xpath("//button[@ng-click='saveResourcePool()']");
    public static By closeLocationAndResources = By.xpath("//button[@class='close configure_facility']");
    public static By resourceLocationInEncounter = By.xpath("//label[text()='Resource Location']/following-sibling::div/select");
    public static By resourcePoolNameInEncounter = By.xpath("//label[text()='Resource Pool']/following-sibling::div/select");
    public static By viewResourceLink = By.linkText("View Resources");
    public static By locationInViewResources = By.xpath("//select");
    public static By resourceTypeInViewResources = By.xpath("//div[2]/select");
    public static By closeViewResourcesModal = By.xpath("//span[text()='View Resources']/following-sibling::button");

    private String serviceName = "newServiceA11";
    private String resourceType = "Bed";
    private String programName = "7124 test";
    private String firstName ="RohitA7";
    private String lastName ="KumarA7";
    private String resourcePoolName ="myPoolA9";
    private String location1 = "Ortho Paedics";

    @BeforeClass
    public void gotoAdminDashBoard() throws InterruptedException {
        Thread.sleep(3000);
        WebDriver driver = getDriverInstance();
        mainMenuPage.gotoAdminDashBoard(driver);
    }

    @Test
    public  void testNameOrder() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver, 20);

        //1. make new service with Resource Assignment as Bed
        adminDashBoardServiceImp.addNewService(programName, driver, serviceName);
        driver.findElement(resourceAssignmentInService).click();
        new Select(driver.findElement(resourceTypeInService)).selectByVisibleText(resourceType);
        adminDashBoardServiceImp.saveNewService(driver);

        // Create new resource pool
        //3. click on Location and Resources
        Thread.sleep(2000);
        driver.findElement(locationAndResourceLink).click();

        //4. click on stored location
        //// TODO: 19/4/17 change it for location
//        driver.findElement(By.linkText(checkTextBox.location)).click();
        driver.findElement(By.linkText(location1)).click();

        //5. add new resource pool without restriction
        driver.findElement(addResourcePoolLink).click();
        new Select(driver.findElement(resourceTypeInput)).selectByVisibleText(resourceType);
        driver.findElement(resourcePoolNameInput).clear();
        driver.findElement(resourcePoolNameInput).sendKeys(resourcePoolName);
        driver.findElement(saveResourcePoolButton).click();

        // close location and resources
        Thread.sleep(1000);
        driver.findElement(closeLocationAndResources).click();

        Thread.sleep(3000);
        mainMenuPage.gotoCaseManagerDashBoard(driver);
        // add new client
        caseManagementDashboardImp.addNewClient(driver, programName, firstName, lastName);

        // create new Encounter
        clientDetailPageServiceImp.createNewEncounter(driver, programName, serviceName);
        //// TODO: 19/4/17 change it for Location
//        new Select(driver.findElement(By.xpath("//label[text()='Resource Location']/following-sibling::div/select"))).selectByVisibleText(checkTextBox.location);
        new Select(driver.findElement(resourceLocationInEncounter)).selectByVisibleText(location1);
        new Select(driver.findElement(resourcePoolNameInEncounter)).selectByVisibleText(resourcePoolName);
        driver.findElement(By.xpath("//a[text()='Check-in Now']")).click();
        driver.findElement(printEncounterTest.saveButtonEncounterElement).click();

        //4. goto View Resources on AdminDashboard
        Thread.sleep(6000);
        printEncounterTest.gotoAdminDashBoard();
        driver.findElement(viewResourceLink).click();

        //5. Select Location abd ResourceType "Bed"
        new Select(driver.findElement(locationInViewResources)).selectByVisibleText("Ortho Paedics");
        new Select(driver.findElement(resourceTypeInViewResources)).selectByVisibleText("Bed");

        //6. for particular resource pool, see name corresponding to it
        String actualNameOrder = driver.findElement(By.xpath("//span[@href='#"+resourcePoolName+"']/../../following-sibling::div/div/form/div/div/div/div[2]")).getText();
        String expectedNameOrder = lastName+", "+firstName;
        assertEquals(actualNameOrder, expectedNameOrder);

        //7. Close View Resources Modal
        driver.findElement(closeViewResourcesModal);
    }
}
