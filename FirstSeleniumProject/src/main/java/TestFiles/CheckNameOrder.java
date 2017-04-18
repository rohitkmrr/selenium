package TestFiles;

import LocalServer.BaseClass;
import TestDevIris.AdminDashBoardServiceImp;
import TestDevIris.CaseManagementDashboardImp;
import TestDevIris.ClientDetailPageServiceImp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Created by zemoso on 18/4/17.
 */
public class CheckNameOrder extends BaseClass{
    PrintEncounterTest printEncounterTest = new PrintEncounterTest();
    AdminDashBoardServiceImp adminDashBoardServiceImp = new AdminDashBoardServiceImp();
    CaseManagementDashboardImp caseManagementDashboardImp = new CaseManagementDashboardImp();
    CheckTextBox checkTextBox = new CheckTextBox();
    private String serviceName = "newService1";
    private String resourceType = "Bed";
    private String programName = "7124 test";
    private String firstName ="Rohit113";
    private String lastName ="kumar1113";
    private String resourcePoolName ="myPool1";


    @Test
    public  void testNameOrder() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver, 20);
        printEncounterTest.gotoAdminDashBoard();
        //1. make new service with Resource Assignment as Bed
        driver.findElement(By.linkText(programName)).click();
        driver.findElement(adminDashBoardServiceImp.serviceLinkElement).click();
        driver.findElement(adminDashBoardServiceImp.addNewServiceLinkInService).click();
        driver.findElement(adminDashBoardServiceImp.serviceNameInputElement).clear();
        driver.findElement(adminDashBoardServiceImp.serviceNameInputElement).sendKeys(serviceName);

        driver.findElement(By.xpath("//div[@id='id_add_new_service']/div[2]/div/div/input")).clear();
        driver.findElement(By.xpath("//div[@id='id_add_new_service']/div[2]/div/div/input")).sendKeys(serviceName);
        driver.findElement(By.xpath("//input[@ng-model='componentList.resourceAssignment']")).click();
        new Select(driver.findElement(By.xpath("//label[text()='Resource Type']/following-sibling::div/select"))).selectByVisibleText(resourceType);

        driver.findElement(adminDashBoardServiceImp.serviceSaveButton).click();
        WebElement closeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(adminDashBoardServiceImp.closeServiceButton));
        closeButton.click();

        // Create new resource pool
        //3. click on Location and Resources
        driver.findElement(By.linkText("Locations and Resources")).click();

        //4. click on stored location
        driver.findElement(By.linkText(checkTextBox.location)).click();

        //5. add new resource pool without restriction
        driver.findElement(By.xpath("//strong[text()='Add Resource Pool']")).click();
        new Select(driver.findElement(By.xpath("//label[text()='Resource Type']/following-sibling::div/select"))).selectByVisibleText(resourceType);
        driver.findElement(By.xpath("//label[text()='Resource Pool Name']/following-sibling::div/input")).clear();
        driver.findElement(By.xpath("//label[text()='Resource Pool Name']/following-sibling::div/input")).sendKeys(resourcePoolName);
        driver.findElement(By.xpath("//button[@ng-click='saveResourcePool()']")).click();


        //2. make new client with that program
        caseManagementDashboardImp.addNewClient(driver, programName, firstName, lastName);

        //3. make new encounter and allocate a bed to that client (from printEncounter)
        new Select(driver.findElement(ClientDetailPageServiceImp.programNameInEncounterElement)).selectByVisibleText(programName);
        new Select(driver.findElement(ClientDetailPageServiceImp.serviceNameInEncounterElement)).selectByVisibleText(serviceName);

        new Select(driver.findElement(By.xpath("//label[text()='Resource Location']/following-sibling::div/select"))).selectByVisibleText(checkTextBox.location);
//        driver.findElement(By.xpath("(//option[@value='0'])[7]")).click();
//        driver.findElement(By.xpath("//div[@id='encounterMainDiv']/div/div/div[3]/div/div/select")).click();
        new Select(driver.findElement(By.xpath("//label[text()='Resource Pool']/following-sibling::div/select"))).selectByVisibleText(resourcePoolName);
        driver.findElement(By.xpath("//a[text()='Check-in Now']")).click();

        driver.findElement(printEncounterTest.saveButtonEncounterElement).click();


        //4. goto View Resources on AdminDashboard
        printEncounterTest.gotoAdminDashBoard();


        List<WebElement> webElementList= driver.findElements(By.xpath("//span[@ng-click='accordionKey[key] = !accordionKey[key]']"));
        for(WebElement webElement: webElementList) {
            if(webElement.getText().equals(resourcePoolName)) {

            }
        }

        //5. Select Location abd ResourceType "Bed"

        //6. for particular resource pool, see name corresponding to it
    }
}
