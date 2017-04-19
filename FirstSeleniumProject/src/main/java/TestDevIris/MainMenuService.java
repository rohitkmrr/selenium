package TestDevIris;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by zemoso on 19/4/17.
 */
public class MainMenuService {
    public static By mainMenuDropDownButtonElement = By.xpath("//div[@class=\"dropdown open hover\"]/div/button");
    public static By adminDashboardLink = By.linkText("Administration");
    public static By cwDashboardElement = By.linkText("Case Management");
    public static By serviceDeliveryLink = By.linkText("Service Delivery");


    public void gotoAdminDashBoard(WebDriver driver) {
        driver.findElement(mainMenuDropDownButtonElement).click();
        driver.findElement(adminDashboardLink).click();
    }

    public void gotoCaseManagerDashBoard(WebDriver driver) {
        driver.findElement(mainMenuDropDownButtonElement).click();
        driver.findElement(cwDashboardElement).click();
    }

    public void gotoServiceDeliveryDashBoard(WebDriver driver) {
        driver.findElement(mainMenuDropDownButtonElement).click();
        driver.findElement(serviceDeliveryLink).click();
    }
}
