package TestDevIris;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by zemoso on 10/4/17.
 */
public class AdminDashBoardServiceImp implements AdminDashBoardService {

    private static By programNameElement = By.id("newProgramId");
    private static By programLegalNameElement = By.xpath("//input[@ng-model='newProgram.legalName']");
//    private static By



    public void enterProgramDetailsDuringAddNewProgram(String programName, WebDriver driver) throws InterruptedException {
        driver.findElement(By.linkText("Add New Program")).click();
        driver.findElement(By.id("newProgramId")).clear();
        WebElement programNameInput =  driver.findElement(programNameElement);
        programNameInput.sendKeys(programName);
        WebElement programLegalName = driver.findElement(programLegalNameElement);
        programLegalName.clear();
        programLegalName.sendKeys("prog1dfgd24");

        // Click Service dropdown and select any value from it
        driver.findElement(By.cssSelector("input.k-input")).click();
        driver.findElement(By.xpath("//ul[@id='newServiceId_listbox']/li[2]")).click();
        Thread.sleep(3000);

        // Click Program Location dropdown and select any value from it
        driver.findElement(By.xpath("//ul[@id='editableNewProgDetails']/li[10]/div/div/input")).click();
        driver.findElement(By.xpath("//ul[@id='location_listbox']/li[2]")).click();

    }

    public void addServicesDuringAddNewProgram(WebDriver driver) {
        WebElement addNewServiceButton = driver.findElement(By.linkText("Add New Service"));
        addNewServiceButton.click();
        WebElement serviceNameInput = driver.findElement(By.xpath("//input[@ng-model='serviceDetails.name']"));
        serviceNameInput.clear();
        serviceNameInput.sendKeys("s1");
        // Select for Note
        driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();
        // Make it not required
        new Select(driver.findElement(By.xpath("//div[@id='id_add_new_service']/div[8]/div[2]/div/select"))).selectByVisibleText("No");
        WebElement saveButton = driver.findElement(By.xpath("(//button[@type='button'])[18]"));
        saveButton.click();
    }

    public void viewOverViewByProgramName(String programName) {


    }

    public void editProgramOverview(String programName) {

    }

    public void viewService(String programName) {

    }

    public void editServiceByServiceName(String programName, String serviceName) {

    }

    public void addNewServiceWithNoteComponent(String programName, WebDriver driver, String serviceName) throws InterruptedException {
        driver.findElement(By.linkText(programName)).click();
        driver.findElement(By.xpath("//div/span/button[2]")).click();
        driver.findElement(By.id("addNewServices")).click();
        driver.findElement(By.xpath("//div[@id='id_add_new_service']/div[2]/div/div/input")).clear();
        driver.findElement(By.xpath("//div[@id='id_add_new_service']/div[2]/div/div/input")).sendKeys(serviceName);
        driver.findElement(By.xpath("//input[@ng-model='componentList.note']")).click();
        new Select(driver.findElement(By.xpath("//select[@ng-model='serviceDetails.serviceComponentDetail.serviceComponent.note.componentRequired']"))).selectByVisibleText("No");
        driver.findElement(By.xpath("//button[@ng-click='addAndUpdateService();']")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector("button.close.ng-scope")).click();

    }

    public void viewUsers(String programName) {

    }

    public void authorizeNewUser(String programName) {

    }

    public void editAuthorizedUser(String programName) {

    }

    public void addNewFormByFormNameAndProgramName(String formName, String programName, WebDriver driver) {
        WebElement addNewFormLink = driver.findElement(By.cssSelector("button.small_header_link"));
        addNewFormLink.click();
        WebElement selectProgram = driver.findElement(By.cssSelector("span.k-input.ng-scope"));
        selectProgram.click();
        // select program
//        driver.findElement(By.xpath("//li[@class='k-item ng-scope'][3]")).click();
        driver.findElements(By.xpath("//li[@class='k-item ng-scope']")).size();
        WebElement selectButton = driver.findElement(By.xpath("(//button[@type='button'])[11]"));
        selectButton.click();
        WebElement formNameInputElement = driver.findElement(By.name("formName"));
        formNameInputElement.click();
        formNameInputElement.clear();
        formNameInputElement.sendKeys(formName);
        WebElement formStatusElement = driver.findElement(By.xpath("//div[@id='panel-default']/div[2]/form/div[2]/div/div/select"));
        new Select(formStatusElement).selectByVisibleText("Active");
        //Save form
        driver.findElement(By.cssSelector("option[value=\"ACTIVE\"]")).click();
        WebElement saveButtonElement = driver.findElement(By.xpath("(//label[@type='submit'])[2]"));
        saveButtonElement.click();

    }

    public void copyForm(String fromProgram, String fromForm, String toProgram, String toForm) {

    }

    public void editFormByProgramNameANdFormName(String programName, String formName) {

    }

    public void viewOrgInfo() {

    }

    public void editOrgInfo() {

    }

    public void addNewLocation() {

    }

    public void editLocationDetails() {

    }

    public void addResourcePool() {

    }

    public void editResourcePool() {

    }

    public void toggleEnableOrDisableLocationByLocationName(String locationName) {

    }

    public void editGoal() {

    }

    public void toggleEnableOrDisableGoalByName(String goalName) {

    }

    public void changeRemovalBy() {

    }

    public void toggleEnableOrDisableDocuments() {

    }

    public void configureConsentsByName(String consentName) {

    }

    public void viewCustomization() {

    }

    public void referralDirectory() {

    }

    public void groupDirectory() {

    }

    public void groupDirectoryMessages() {

    }

    public void viewResources() {

    }

    public void printResources() {

    }

    public void viewOrEditUser() {

    }

    public void addNewUser() {

    }
}
