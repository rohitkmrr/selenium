package TestDevIris;

/**
 * Created by zemoso on 10/4/17.
 */
public interface ClientDetailPage {
    void editClientDetails();
    void printClientDetails();
    void printScanCard();
    void removeClient();
    void editClientConsent();
    void viewConsistencyCheck();
    void viewFamilyInfo();
    void addFamilyMember();
    void linkFamilyMember();
    void editFamilyInfo();
    void goToFamilyMember();
    void viewAlerts();
    void editAlert();

    //Aobut Enrollments
    void viewAllEnrollments();
    void newEnrollment();
    void exitEnrollmentByCaseManager(String caseManagerName);
    void viewEnrollment();

    // About Goals
    void viewGoals();
    void addGoal();
    void editGoal();

    // About Activities
    void viewActivities();


    //About Encounters
    void viewEncounters();
    void addEncounter();


}
