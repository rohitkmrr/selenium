package TestDevIris;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

/**
 * Created by zemoso on 19/4/17.
 */
public class MainMenuPage {
    public static By mainMenuDropDownButtonElement = By.xpath("//div[@class=\"dropdown open hover\"]/div/button");
    public static By adminDashboardLink = By.linkText("Administration");
    public static By cwDashboardElement = By.linkText("Case Management");
    public static By serviceDeliveryLink = By.linkText("Service Delivery");


    public void gotoAdminDashBoard(WebDriver driver) {
        driver.findElement(mainMenuDropDownButtonElement).click();
        driver.findElement(adminDashboardLink).click();
        assertEquals(driver.getTitle(), "Admin Dashboard");
    }

    public void gotoCaseManagerDashBoard(WebDriver driver) {
        driver.findElement(mainMenuDropDownButtonElement).click();
        driver.findElement(cwDashboardElement).click();
//        assertEquals(driver.getTitle(), "Admin Dashboard");
    }

    public void gotoServiceDeliveryDashBoard(WebDriver driver) {
        driver.findElement(mainMenuDropDownButtonElement).click();
        driver.findElement(serviceDeliveryLink).click();
        assertEquals(driver.getTitle(), "Service Delivery Dashboard");
    }
}
