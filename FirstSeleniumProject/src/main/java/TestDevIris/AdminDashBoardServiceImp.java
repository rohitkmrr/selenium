package TestDevIris;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by zemoso on 10/4/17.
 */
public class AdminDashBoardServiceImp implements AdminDashBoardService {

    public static By programNameElement = By.id("newProgramId");
    public static By programLegalNameElement = By.xpath("//input[@ng-model='newProgram.legalName']");
    public static By serviceLinkElement = By.xpath("//div/span/button[2]");
    public static By addNewServiceLinkInService = By.id("addNewServices");
    public static By serviceNameInputElement = By.xpath("//div[@id='id_add_new_service']/div[2]/div/div/input");
    public static By noteCheckboxElement = By.xpath("//input[@ng-model='componentList.note']");
    public static By noForRequired = By.xpath("//select[@ng-model='serviceDetails.serviceComponentDetail.serviceComponent.note.componentRequired']");
    public static By serviceSaveButton = By.xpath("//button[@ng-click='addAndUpdateService();']");
    public static By closeServiceButton = By.cssSelector("button.close.ng-scope");
    public static By addNewServiceLink = By.linkText("Add New Service");
    public static By serviceNameInputField = By.xpath("//input[@ng-model='serviceDetails.name']");
    public static By checkboxForNote = By.xpath("(//input[@type='checkbox'])[2]");
    public static By noForRequiredElement = By.xpath("//div[@id='id_add_new_service']/div[8]/div[2]/div/select");
    public static By saveService = By.xpath("(//button[@type='button'])[18]");
    public static By addNewFormLinkElement = By.cssSelector("button.small_header_link");
    public static By selectProgramElement = By.cssSelector("span.k-input.ng-scope");
    public static By formNameInputField = By.name("formName");
    public static By selectFormStatus  = By.xpath("//div[@id='panel-default']/div[2]/form/div[2]/div/div/select");
    public static By selectActive  = By.cssSelector("option[value=\"ACTIVE\"]");
    public static By saveFormButton  = By.xpath("(//label[@type='submit'])[2]");
    public static By addNewProgramLink  = By.linkText("Add New Program");
    public static By serviceDropdownInAddProgram  =By.cssSelector("input.k-input");
    public static By selectServiceFromDropdownInAddProgram  =By.xpath("//ul[@id='newServiceId_listbox']/li[2]");
    public static By selectLocationField  =By.xpath("//ul[@id='editableNewProgDetails']/li[10]/div/div/input");
    public static By selectParticularLocation  =By.xpath("//ul[@id='location_listbox']/li[2]");
    public static By closeButtonForToastElement = By.xpath("//button[@ng-click='closeClick(toasty)']");



    public void enterProgramDetailsDuringAddNewProgram(String programName, WebDriver driver) throws InterruptedException {
        driver.findElement(addNewProgramLink).click();
        driver.findElement(programNameElement).clear();
        WebElement programNameInput =  driver.findElement(programNameElement);
        programNameInput.sendKeys(programName);
        WebElement programLegalName = driver.findElement(programLegalNameElement);
        programLegalName.clear();
        programLegalName.sendKeys("prog1dfgd24");

        // Click Service dropdown and select any value from it
        driver.findElement(serviceDropdownInAddProgram).click();
        driver.findElement(selectServiceFromDropdownInAddProgram).click();
        Thread.sleep(3000);

        // Click Program Location dropdown and select any value from it
        driver.findElement(selectLocationField).click();
        driver.findElement(selectParticularLocation).click();

    }



    public void addServicesDuringAddNewProgram(WebDriver driver) {
        WebElement addNewServiceButton = driver.findElement(addNewServiceLink);
        addNewServiceButton.click();
        WebElement serviceNameInput = driver.findElement(serviceNameInputField);
        serviceNameInput.clear();
        serviceNameInput.sendKeys("s1");
        // Select for Note
        driver.findElement(checkboxForNote).click();
        // Make it not required
        new Select(driver.findElement(noForRequiredElement)).selectByVisibleText("No");
        WebElement saveButton = driver.findElement(saveService);
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

    public String findLocationOfProgram(WebDriver driver, String programName) {
        driver.findElement(By.linkText(programName)).click();
        String location = driver.findElement(By.xpath("//li/span[text()=' Program Location:']/following-sibling::span/ul/li")).getText();
        driver.findElement(By.xpath("//button[@class='close ng-scope']")).click();
        return location;
    }

    public void addNewResourcePool(WebDriver driver, String resourceType, String resourcePoolName ) {
        driver.findElement(By.xpath("//strong[text()='Add Resource Pool']")).click();
        new Select(driver.findElement(By.xpath("//label[text()='Resource Type']/following-sibling::div/select"))).selectByVisibleText(resourceType);
        driver.findElement(By.xpath("//label[text()='Resource Pool Name']/following-sibling::div/input")).clear();
        driver.findElement(By.xpath("//label[text()='Resource Pool Name']/following-sibling::div/input")).sendKeys(resourcePoolName);
        driver.findElement(By.xpath("//button[@ng-click='saveResourcePool()']")).click();
    }

    public void addNewService(String programName, WebDriver driver, String serviceName) {
        driver.findElement(By.linkText(programName)).click();
        driver.findElement(serviceLinkElement).click();
        driver.findElement(addNewServiceLinkInService).click();
        driver.findElement(serviceNameInputElement).clear();
        driver.findElement(serviceNameInputElement).sendKeys(serviceName);
    }

    public void saveNewService(WebDriver driver) {
        WebDriverWait wait=new WebDriverWait(driver, 20);
        driver.findElement(serviceSaveButton).click();
        driver.findElement(closeButtonForToastElement).click();
        WebElement closeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(closeServiceButton));
        closeButton.click();
    }

    public void addNewServiceWithNoteComponent(String programName, WebDriver driver, String serviceName) throws InterruptedException {
        addNewService(programName, driver, serviceName);
        driver.findElement(noteCheckboxElement).click();
        new Select(driver.findElement(noForRequired)).selectByVisibleText("No");
//        saveNewService(driver);
        WebDriverWait wait=new WebDriverWait(driver, 20);
        driver.findElement(serviceSaveButton).click();
        driver.findElement(closeButtonForToastElement).click();
        WebElement closeButton = wait.until(ExpectedConditions.visibilityOfElementLocated(closeServiceButton));
        closeButton.click();

    }

    public void viewUsers(String programName) {

    }

    public void authorizeNewUser(String programName) {

    }

    public void editAuthorizedUser(String programName) {

    }

    public void addNewFormByFormNameAndProgramName(String formName, String programName, WebDriver driver) {
        WebElement addNewFormLink = driver.findElement(addNewFormLinkElement);
        addNewFormLink.click();
        WebElement selectProgram = driver.findElement(selectProgramElement);
        selectProgram.click();
        // select program
//        driver.findElements(By.xpath("//li[@class='k-item ng-scope']")).size();
        // TODO: 11/4/17  Select program using programName variable
        WebElement selectButton = driver.findElement(By.xpath("(//button[@type='button'])[11]"));
        selectButton.click();
        WebElement formNameInputElement = driver.findElement(formNameInputField);
        formNameInputElement.click();
        formNameInputElement.clear();
        formNameInputElement.sendKeys(formName);
        WebElement formStatusElement = driver.findElement(selectFormStatus);
        new Select(formStatusElement).selectByVisibleText("Active");
        //Save form
        driver.findElement(selectActive).click();
        WebElement saveButtonElement = driver.findElement(saveFormButton);
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
