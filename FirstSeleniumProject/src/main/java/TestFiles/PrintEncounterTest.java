package TestFiles;

import DevIris.DevBaseClass;
import TestDevIris.AdminDashBoardService;
import TestDevIris.AdminDashBoardServiceImp;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by zemoso on 11/4/17.
 */
public class PrintEncounterTest extends DevBaseClass{

    @Autowired
    AdminDashBoardService adminDashBoardService;


    @BeforeClass
    public void gotoAdminDashBoard() {
        WebDriver driver = getDriverInstance();
        driver.findElement(By.xpath("//div[@class=\"dropdown open hover\"]/div/button")).click();
        driver.findElement(By.linkText("Administration")).click();
        assertEquals(driver.getTitle(), "Admin Dashboard");
    }

    @Test
    public void printEncounterTest() throws InterruptedException {
        // make new service with Note field as not required
        String programName = "Food Coupon";
        String serviceName = "newService3";
//        adminDashBoardService.addNewServiceWithNoteComponent(programName, driver, serviceName);
        AdminDashBoardServiceImp adminDashBoardServiceImp = new AdminDashBoardServiceImp();
        adminDashBoardServiceImp.addNewServiceWithNoteComponent(programName, driver, serviceName);

        //Store location from Overview to select it from Location & Resources
        Thread.sleep(3000);
        driver.findElement(By.linkText(programName)).click();

        String locationName = driver.findElement(By.xpath("//li/span[ text()=' Program Location:']/following-sibling::span/ul[1]/li")).getText();
        driver.findElement(By.xpath("//h4[@id='myModalLabel']/button[@class='close ng-scope']")).click();

        //Goto CaseManager, make a new client Select that program and select any Client
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button.dropdown_button")).click();
        driver.findElement(By.linkText("Case Management")).click();
        driver.findElement(By.cssSelector("span.k-input.ng-scope")).click();
        driver.findElement(By.xpath("//ul[@id='programFilterId_listbox']/li[text()='"+programName+"']")).click();
        driver.findElement(By.xpath("//table[@id='clientListTable']/tbody/tr/td/a/span/span[3]")).click();

        //Make a new encounter for the newly made service
        driver.findElement(By.linkText("New Encounter")).click();
        new Select(driver.findElement(By.xpath("//div[@id='encounterMainDiv']/div/div/div[2]/div/div/select"))).selectByVisibleText(programName);
        new Select(driver.findElement(By.xpath("//div[@id='encounterMainDiv']/div/div/div[2]/div[2]/div/select"))).selectByVisibleText(serviceName);
        driver.findElement(By.xpath("//div/label[text()='Note']/following-sibling::div/textarea")).clear();
        driver.findElement(By.xpath("//div/label[text()='Note']/following-sibling::div/textarea")).sendKeys("1");
        driver.findElement(By.xpath("(//button[@class='btn btn-default ar pull-right'])")).click();

        //print that service
        String winHandleBefore = driver.getWindowHandle();
        Thread.sleep(2000);
        driver.findElement(By.id("printEncNotes")).click();
        for(String winHandle : driver.getWindowHandles()){
            driver.switchTo().window(winHandle);
        }

    }


}
