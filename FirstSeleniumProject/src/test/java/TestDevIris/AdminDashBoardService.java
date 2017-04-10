package TestDevIris;

/**
 * Created by zemoso on 10/4/17.
 */
public interface AdminDashBoardService {
    // just click on Add New Program
    void addNewProgramByName(String programName);

    void editProgramByName(String programName);
    void addNewFormByFormNameAndProgramName(String formName, String programName);
    void copyForm(String fromProgram, String fromForm, String toProgram, String toForm);
    void editFormByProgramNameANdFormName(String programName, String formName);
    void configureOrgInfo();
    void configureLocationsAndResources();
    void configureGoals();
    void configureDocuments();
    void configureConsentsByName(String consentName);
    void viewCustomization();
    void referralDirectory();
    void groupDirectory();
    void groupDirectoryMessages();
    void viewResources();
    void viewOrEditUser();
    void addNewUser();

}
