package TestDevIris;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by zemoso on 10/4/17.
 */
public class CaseManagementDashboardService {
    private WebDriver driver;

    private static By addNewClientElement = By.id("newClient");
    private static By firstNameElementInAddClient = By.id("email");
    private static By lastNameElementInAddClient = By.xpath("(//input[@id='email'])[2]");
    private static By continueButton = By.xpath("//button[@ng-click='broadCastContinueEvent();']");
    private static By programSelectDropdownElement = By.xpath("//div[@id='programSelection']/div/span/span/span");

    public CaseManagementDashboardService(WebDriver driver){
        this.driver = driver;
    }

    public void addNewClient(String programName, String firstName, String lastName) throws InterruptedException {
        driver.findElement(addNewClientElement).click();
        driver.findElement(firstNameElementInAddClient).clear();
        driver.findElement(firstNameElementInAddClient).sendKeys(firstName);
        driver.findElement(lastNameElementInAddClient).clear();
        driver.findElement(lastNameElementInAddClient).sendKeys(lastName);
        Thread.sleep(3000);
        driver.findElement(continueButton).click();
        Thread.sleep(3000);
        driver.findElement(continueButton).click();
        Thread.sleep(3000);
        driver.findElement(By.id("cert0")).click();
        driver.findElement(continueButton).click();
        Thread.sleep(3000);
        driver.findElement(programSelectDropdownElement).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class='k-animation-container']/div/ul[@class='k-list k-reset']/li[.='"+programName+"']")).click();
        driver.findElement(continueButton).click();
        Thread.sleep(8000);
        driver.findElement(continueButton).click();
        Thread.sleep(8000);
        driver.findElement(continueButton).click();
        Thread.sleep(8000);
        driver.findElement(continueButton).click();
    }

    public void editClientByProgramName(String programName) {

    }

    public void viewAppointment() {

    }

    public void newAppointment() {

    }

    public void viewReferralByProgramName(String programName) {

    }
}
