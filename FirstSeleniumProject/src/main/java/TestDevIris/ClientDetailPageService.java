package TestDevIris;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by zemoso on 10/4/17.
 */
public class ClientDetailPageService {
    private WebDriver driver;

    public static By newEncounterLink = By.linkText("New Encounter");
    public static By programNameInEncounterElement = By.xpath("//div[@id='encounterMainDiv']/div/div/div[2]/div/div/select");
    public static By serviceNameInEncounterElement = By.xpath("//div[@id='encounterMainDiv']/div/div/div[2]/div[2]/div/select");

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
