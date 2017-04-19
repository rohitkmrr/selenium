package TestFiles;

import LocalServer.BaseClass;
import TestDevIris.MainMenuPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by zemoso on 18/4/17.
 */
public class CheckIncrement extends BaseClass{
    MainMenuPage mainMenuPage = new MainMenuPage();

    public static By addServiceButton = By.xpath("(//button[@type='button'])[7]");
    public static By programName1 = By.xpath("//div[@id='serviceDelivery']/div/div/div[2]/div[3]/div/select");
    public static By serviceName1 = By.xpath("//div[@id='serviceDelivery']/div/div/div[2]/div[3]/div[2]/select");
    public static By programName2 = By.xpath("//div[@id='serviceDelivery']/div/div/div[2]/div[4]/div/select");
    public static By serviceName2 = By.xpath("//div[@id='serviceDelivery']/div/div/div[2]/div[4]/div[2]/select");
    public static By batchPreselectionCount = By.xpath("//div[@id='serviceDelivery']/div/div/div");


    // 1. goto ServiceDelivery
    @BeforeClass
    public void gotoAdminDashBoard() {
        WebDriver driver = getDriverInstance();
        mainMenuPage.gotoServiceDeliveryDashBoard(driver);
    }


    @Test
    public void checkIncrement() {
        String programName = "7124 test";
        String serviceName = "newServices12145";

        // 2. Use a program and a service to select
        new Select(driver.findElement(programName1)).selectByVisibleText(programName);
        new Select(driver.findElement(serviceName1)).selectByVisibleText(serviceName);
        driver.findElement(addServiceButton).click();
        new Select(driver.findElement(programName2)).selectByVisibleText(programName);
        new Select(driver.findElement(serviceName2)).selectByVisibleText(serviceName);

        // 3. check increment
        assertEquals("Batch Preselection: 1", driver.findElement(batchPreselectionCount).getText());
    }

}
