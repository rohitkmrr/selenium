package TestDevIris;

import org.openqa.selenium.WebDriver;

/**
 * Created by zemoso on 10/4/17.
 */
public interface CaseManagementDashboard {
    void addNewClient(WebDriver driver, String programName) throws InterruptedException;
    void editClientByProgramName(String programName);
    void viewAppointment();
    void newAppointment();
    void viewReferralByProgramName(String programName);

}
