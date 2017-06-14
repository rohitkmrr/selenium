package TestDevIris;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by zemoso on 10/4/17.
 */
public class ClientDetailPageService {
    private WebDriver driver;

    public static By newEncounterLink = By.linkText("New Encounter");
    public static By programNameInEncounterElement = By.xpath("//div[@id='encounterMainDiv']/div/div/div[2]/div/div/select");
    public static By serviceNameInEncounterElement = By.xpath("//div[@id='encounterMainDiv']/div/div/div[2]/div[2]/div/select");
    public static By rightSliderButton = By.id("btn-slider");
    public static By formsLinkOnSlider = By.xpath("//h4[@href='#ul_collapse_1']");
    public static By newUpdateLink = By.id("newClientform");
    public static By selectProgramInNewUpdate =By.xpath("//span[text()='Select Program']");
    public static By selectFormsInNewUpdate =By.xpath("//span[text()='Select Form']");
    public static By OkButtonInNewUpdate =By.xpath("//button[@ng-click='redirectClientForm(programForm.selectedProgram,programForm.selectedForm, isUpdateForm)']");
    public static By submitFormInNewUpdate =By.xpath("//label[@ng-click='submitForm()']");
    public static By uploadNewDocumentLink =By.id("upload_new_document");
    public static By submitExitFormButton = By.xpath("//label[@ng-click='submitExitForm(clientHOHMap)'][1]");
    public static By newEnrollmentLink = By.id("new_enroll_link");
    public static By selectProgramLinkFromNewEnrollment = By.xpath("//span[text()='My Programs']");
    public static By selectContinueFromNewEnrollment = By.xpath("//button[text()='Continue']");
    public static By saveAsDraftButtonFromNewEnrollment = By.xpath("//button[text()='Save As Draft']");
    public static By saveEnrollmentFromPendingEnrollments = By.xpath("//button[text()='Save Enrollment']");
    public static By doneFromNewEnrollments = By.xpath("//button[text()='Done']");
    public static By closeHistoryButton = By.xpath("(//h4[@id='myModalLabel']/button[@class='close'])[5]");

    public ClientDetailPageService(WebDriver driver){
        this.driver = driver;
    }

    public  void createNewEncounter(String programName, String serviceName) {
        driver.findElement(newEncounterLink).click();
        new Select(driver.findElement(programNameInEncounterElement)).selectByVisibleText(programName);
        new Select(driver.findElement(serviceNameInEncounterElement)).selectByVisibleText(serviceName);

    }
    public void editClientDetails() {

    }

    public void newUpdate(String programName, String formName) throws InterruptedException {
        LoginPage.turnOffImplicitWaits();
        if(!driver.findElement(formsLinkOnSlider).isDisplayed()) {
            LoginPage.turnOnImplicitWaits();
            driver.findElement(rightSliderButton).click();
            driver.findElement(formsLinkOnSlider).click();
        }
        else
            LoginPage.turnOnImplicitWaits();
        Thread.sleep(1000);
        driver.findElement(newUpdateLink).click();
        driver.findElement(selectProgramInNewUpdate).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul[@id='formProgramsNew_listbox']/li[text()='"+programName+"']")).click();
        Thread.sleep(1000);
        driver.findElement(selectFormsInNewUpdate).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//ul[@id='programForm_listbox']/li[text()='"+formName+"']")).click();
        driver.findElement(OkButtonInNewUpdate).click();
        Thread.sleep(3000);
        driver.findElement(submitFormInNewUpdate).click();
        Thread.sleep(3000);
    }

    public void showFormHistory() throws InterruptedException {
        LoginPage.turnOffImplicitWaits();
        if(!driver.findElement(formsLinkOnSlider).isDisplayed()) {
            LoginPage.turnOnImplicitWaits();
            driver.findElement(rightSliderButton).click();
            driver.findElement(formsLinkOnSlider).click();
        }
        else
            LoginPage.turnOnImplicitWaits();
        Thread.sleep(1000);
        driver.findElement(uploadNewDocumentLink).click();

    }

    public void exitFromProgram(String programName) throws InterruptedException {
        driver.findElement(By.xpath("//a[text()='"+programName+" ']/../following-sibling::td[2]/span/a[text()='Exit']")).click();
        Thread.sleep(3000);
        driver.findElement(submitExitFormButton).click();
        Thread.sleep(2000);
    }

    public void newEnrollmentAsDraft(String programName) throws InterruptedException {
        driver.findElement(newEnrollmentLink).click();
        driver.findElement(selectProgramLinkFromNewEnrollment).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//li[text()='"+programName+"']")).click();
        driver.findElement(selectContinueFromNewEnrollment).click();
        Thread.sleep(3000);
        driver.findElement(saveAsDraftButtonFromNewEnrollment).click();
    }

    public void savePendingEnrollment(String programeName) throws InterruptedException {
        driver.findElement(By.xpath("//a[text()='"+programeName+" ']/../../td[1]/a")).click();
        Thread.sleep(3000);
        driver.findElement(saveEnrollmentFromPendingEnrollments).click();
        Thread.sleep(2000);
        driver.findElement(selectContinueFromNewEnrollment).click();
        Thread.sleep(2000);
        driver.findElement(doneFromNewEnrollments).click();
    }

    public Map<String, Integer> viewClientHistory (String programName, String formName) throws InterruptedException {
        showFormHistory();
        Thread.sleep(2000);
        Map<String , Integer> map = new HashMap<String, Integer>();
        LoginPage.turnOffImplicitWaits();
        int projectEntry = driver.findElements(By.xpath("//table[@class='table columnData datapadd']/tbody/tr/td/span[text()='"+programName+"']/../following-sibling::td/div/div/span[text()='"+formName+"']/following-sibling::span[text()='Project entry']")).size();
        int projectUpdate = driver.findElements(By.xpath("//table[@class='table columnData datapadd']/tbody/tr/td/span[text()='"+programName+"']/../following-sibling::td/div/div/span[text()='"+formName+"']/following-sibling::span[text()='Project update']")).size();
        int projectExit = driver.findElements(By.xpath("//table[@class='table columnData datapadd']/tbody/tr/td/span[text()='"+programName+"']/../following-sibling::td/div/div/span[text()='"+formName+"']/following-sibling::span[text()='Project exit']")).size();
        LoginPage.turnOnImplicitWaits();
        map.put("Project entry", projectEntry);
        map.put("Project update", projectUpdate);
        map.put("Project exit", projectExit);

        driver.findElement(closeHistoryButton).click();

        return map;
    }



    public void closeRightSlider() throws InterruptedException {
        Thread.sleep(2000);
        ////  close the right panel before click exit
        if(driver.findElement(formsLinkOnSlider).isDisplayed()) {
            driver.findElement(rightSliderButton).click();
        }
    }

    public void printClientDetails() {

    }

    public void printScanCard() {

    }

    public void removeClient() {

    }

    public void editClientConsent() {

    }

    public void viewConsistencyCheck() {

    }

    public void viewFamilyInfo() {

    }

    public void addFamilyMember() {

    }

    public void linkFamilyMember() {

    }

    public void editFamilyInfo() {

    }

    public void goToFamilyMember() {

    }

    public void viewAlerts() {

    }

    public void editAlert() {

    }

    public void viewAllEnrollments() {

    }

    public void newEnrollment() {

    }

    public void exitEnrollmentByCaseManager(String caseManagerName) {

    }

    public void viewEnrollment() {

    }

    public void viewGoals() {

    }

    public void addGoal() {

    }

    public void editGoal() {

    }

    public void viewActivities() {

    }

    public void viewEncounters() {

    }

    public void addEncounter() {


    }
}
