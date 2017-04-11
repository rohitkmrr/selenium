package TestDevIris;

import org.openqa.selenium.WebDriver;

/**
 * Created by zemoso on 10/4/17.
 */
public interface AdminDashBoardService {
    // Add New Program
    void enterProgramDetailsDuringAddNewProgram(String programName, WebDriver driver) throws InterruptedException;
    void addServicesDuringAddNewProgram(WebDriver driver);

    // Edit Program
    void viewOverViewByProgramName(String programName);
    void editProgramOverview(String programName);
    void viewService(String programName);
    void editServiceByServiceName(String programName,String serviceName);
    void addNewServiceWithNoteComponent(String programName, WebDriver driver, String serviceName) throws InterruptedException;
    void viewUsers(String programName);
    void authorizeNewUser(String programName);
    void editAuthorizedUser(String programName);

    //Configure Forms
    void addNewFormByFormNameAndProgramName(String formName, String programName, WebDriver driver);
    void copyForm(String fromProgram, String fromForm, String toProgram, String toForm);
    void editFormByProgramNameANdFormName(String programName, String formName);

    //Configure Organisation Start
    //Configure Org Info.
    void viewOrgInfo();
    void editOrgInfo();

    //Configure Location and Resources
    void addNewLocation();
    void editLocationDetails();
    void addResourcePool();
    void editResourcePool();
    void toggleEnableOrDisableLocationByLocationName(String locationName);

    //Configure Goals
    void editGoal();
    void toggleEnableOrDisableGoalByName(String goalName);

    //Configure Documents
    void changeRemovalBy();
    void toggleEnableOrDisableDocuments();

    //Configure Consents
    void configureConsentsByName(String consentName);

    //View Customization
    void viewCustomization();

    //Referral Directory
    void referralDirectory();

    //Group Directory
    void groupDirectory();
    void groupDirectoryMessages();

    //View Resources
    void viewResources();
    void printResources();

    //Configure users
    void viewOrEditUser();
    void addNewUser();

}
