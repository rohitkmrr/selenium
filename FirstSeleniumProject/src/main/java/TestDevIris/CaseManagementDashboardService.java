package TestDevIris;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by zemoso on 10/4/17.
 */
public class CaseManagementDashboardService {
    private WebDriver driver;
    MainMenuService mainMenuService = new MainMenuService();

    public static By addNewClientElement = By.id("newClient");
    public static By firstNameElementInAddClient = By.id("email");
    public static By lastNameElementInAddClient = By.xpath("(//input[@id='email'])[2]");
    public static By continueButton = By.xpath("//button[@ng-click='broadCastContinueEvent();']");
    public static By programSelectDropdownElement = By.xpath("//div[@id='programSelection']/div/span/span/span");

    public CaseManagementDashboardService(WebDriver driver){
        this.driver = driver;
    }

    public void addNewClient(String programName, String firstName, String lastName) throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver, 20);
        driver.findElement(addNewClientElement).click();
        driver.findElement(firstNameElementInAddClient).clear();
        driver.findElement(firstNameElementInAddClient).sendKeys(firstName);
        driver.findElement(lastNameElementInAddClient).clear();
        driver.findElement(lastNameElementInAddClient).sendKeys(lastName);
//        Thread.sleep(1000);
        driver.findElement(continueButton).click();
//        LoginPage.turnOffImplicitWaits();
        Boolean clientInformation = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h4[contains(text(),'Client Information')]")));
//        LoginPage.turnOnImplicitWaits();
        driver.findElement(continueButton).click();
//        LoginPage.turnOffImplicitWaits();
        Boolean duplicateCheck = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h4[contains(text(),'Duplicate Check')]")));
//        LoginPage.turnOnImplicitWaits();
        driver.findElement(By.id("cert0")).click();
        driver.findElement(continueButton).click();
//        LoginPage.turnOffImplicitWaits();
        Boolean clientConsent = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h4[contains(text(),'Client Consent')]")));
//        LoginPage.turnOnImplicitWaits();
        driver.findElement(programSelectDropdownElement).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='k-animation-container']/div/ul[@class='k-list k-reset']/li[.='"+programName+"']")));
        driver.findElement(By.xpath("//div[@class='k-animation-container']/div/ul[@class='k-list k-reset']/li[.='"+programName+"']")).click();
        driver.findElement(continueButton).click();
//        LoginPage.turnOffImplicitWaits();
        Boolean programSelection = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//li[@class='tab active']/span[text()='Program Selection']")));
//        LoginPage.turnOnImplicitWaits();
//        driver.findElement(continueButton).click();
//        LoginPage.turnOffImplicitWaits();
//        WebElement formSelection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='tab active']/span[contains(text(),'Document Upload')]")));
//        Thread.sleep(8000);
//        LoginPage.turnOnImplicitWaits();
    }

    public void addNewClientNew(String programName, String firstName, String lastName, String formName) throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver, 20);
        driver.findElement(addNewClientElement).click();
        driver.findElement(firstNameElementInAddClient).clear();
        driver.findElement(firstNameElementInAddClient).sendKeys(firstName);
        driver.findElement(lastNameElementInAddClient).clear();
        driver.findElement(lastNameElementInAddClient).sendKeys(lastName);
//        Thread.sleep(1000);
        driver.findElement(continueButton).click();
//        LoginPage.turnOffImplicitWaits();
        Boolean clientInformation = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h4[contains(text(),'Client Information')]")));
//        LoginPage.turnOnImplicitWaits();
        driver.findElement(continueButton).click();
//        LoginPage.turnOffImplicitWaits();
        Boolean duplicateCheck = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h4[contains(text(),'Duplicate Check')]")));
//        LoginPage.turnOnImplicitWaits();
        driver.findElement(By.id("cert0")).click();
        driver.findElement(continueButton).click();
//        LoginPage.turnOffImplicitWaits();
        Boolean clientConsent = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//h4[contains(text(),'Client Consent')]")));
//        LoginPage.turnOnImplicitWaits();
        driver.findElement(programSelectDropdownElement).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='k-animation-container']/div/ul[@class='k-list k-reset']/li[.='"+programName+"']")));
        driver.findElement(By.xpath("//div[@class='k-animation-container']/div/ul[@class='k-list k-reset']/li[.='"+programName+"']")).click();
        driver.findElement(continueButton).click();
//        LoginPage.turnOffImplicitWaits();
        Boolean programSelection = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//li[@ng-repeat='field_item in programFormList']/span[contains(text(),'"+formName+"')]")));

    }


    public void saveEnrollment() throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver, 20);
        driver.findElement(continueButton).click();
        WebElement formSelection = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//li[@class='tab active']/span[contains(text(),'Document Upload')]")));
        driver.findElement(continueButton).click();
        Boolean documentUpload = wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//li[@class='tab']/span[contains(text(),'Document Upload')]")));
//        Thread.sleep(8000);
        driver.findElement(continueButton).click();
//        LoginPage.turnOffImplicitWaits();
        WebElement summary = wait.until(ExpectedConditions.visibilityOfElementLocated(mainMenuService.mainMenuDropDownButtonElement));
//        LoginPage.turnOnImplicitWaits();
//        Thread.sleep(8000);
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
