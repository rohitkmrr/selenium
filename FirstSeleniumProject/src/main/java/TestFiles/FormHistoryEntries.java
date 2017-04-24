package TestFiles;

import TestDevIris.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.Map;

import static org.testng.Assert.assertEquals;

/**
 * Created by zemoso on 20/4/17.
 */
public class FormHistoryEntries extends LoginPage {
    MainMenuService mainMenuService = new MainMenuService();

    //goto AdminDashboard
    @BeforeClass
    public void gotoAdminDashBoard() {
        WebDriver driver = getDriverInstance();
        mainMenuService.gotoAdminDashBoard(driver);
    }

    @Test
    public void testFormHistoryEntries() throws InterruptedException {
        AdminDashBoardService adminDashBoardService = new AdminDashBoardService(driver);
        CaseManagementDashboardService caseManagementDashboardService = new CaseManagementDashboardService(driver);
        ClientDetailPageService clientDetailPageService = new ClientDetailPageService(driver);

        String program = "7124 test";
        String form1 = "form1";
        String form2 = "form2";
        String form3 = "form3";
        String form4 = "form4";
        String form5 = "form5";
        String exitForm = "exit form";
        String firstName = "First02";
        String lastName = "Last02";

        String newProgramForEnrollment = "7258 Test";

        //// TODO: 20/4/17  cannot select intake forms in multiselect
        /*//make 4 forms for a program
        adminDashBoardService.addNewFormByFormNameAndProgramName(form1, program);
        adminDashBoardService.addNewFormByFormNameAndProgramName(form2, program);
        adminDashBoardService.addNewFormByFormNameAndProgramName(form3, program);
        adminDashBoardService.addNewFormByFormNameAndProgramName(form4, program);
        adminDashBoardService.addNewFormByFormNameAndProgramName(form5, program);

        //make these 2 forms as intake forms for that program
        //1. goto program


        //2. select overview and click on edit

        //3. clear all intakes and make form1 and form2 as new Intake forms and click on Done

        //4. close the program details modal
*/
        // make a new client for that program
        mainMenuService.gotoCaseManagerDashBoard(driver);
        caseManagementDashboardService.addNewClient(program, firstName, lastName);
        Thread.sleep(8000);
        driver.findElement(caseManagementDashboardService.continueButton).click();

        //View Fom History [ 2 entries with both as project entries]
        Map<String, Integer> map1 = clientDetailPageService.viewClientHistory(program, form1);
        Map<String, Integer> map2 = clientDetailPageService.viewClientHistory(program, form2);

        assertEquals(Integer.valueOf(map1.get("Project entry")), Integer.valueOf(1));
        assertEquals(Integer.valueOf(map1.get("Project update")), Integer.valueOf(0));
        assertEquals(Integer.valueOf(map1.get("Project exit")), Integer.valueOf(0));
        assertEquals(Integer.valueOf(map2.get("Project update")), Integer.valueOf(0));
        assertEquals(Integer.valueOf(map2.get("Project entry")), Integer.valueOf(1));
        assertEquals(Integer.valueOf(map2.get("Project exit")), Integer.valueOf(0));



        //make multiple new update
        clientDetailPageService.newUpdate(program, form3);

        //View Form History [entries as form update ]
        Map<String, Integer> map3 = clientDetailPageService.viewClientHistory(program, form3);
        assertEquals(Integer.valueOf(map3.get("Project entry")), Integer.valueOf(0));
        assertEquals(Integer.valueOf(map3.get("Project update")), Integer.valueOf(1));
        assertEquals(Integer.valueOf(map3.get("Project exit")), Integer.valueOf(0));


        // make new update
        clientDetailPageService.newUpdate(program, form4);

        //VIew History
        Map<String, Integer> map4 = clientDetailPageService.viewClientHistory(program, form4);
        assertEquals(Integer.valueOf(map4.get("Project entry")), Integer.valueOf(0));
        assertEquals(Integer.valueOf(map4.get("Project update")), Integer.valueOf(1));
        assertEquals(Integer.valueOf(map4.get("Project exit")), Integer.valueOf(0));

        // make new update
        clientDetailPageService.newUpdate(program, form5);

        //VIew History
        Map<String, Integer> map5 = clientDetailPageService.viewClientHistory(program, form5);
        assertEquals(Integer.valueOf(map5.get("Project entry")), Integer.valueOf(0));
        assertEquals(Integer.valueOf(map5.get("Project update")), Integer.valueOf(1));
        assertEquals(Integer.valueOf(map5.get("Project exit")), Integer.valueOf(0));

        // exit from program
        //// close the right panel before click exit
       clientDetailPageService.closeRightSlider();
        Thread.sleep(1000);

        clientDetailPageService.exitFromProgram(program);

        //View History
        Thread.sleep(3000);
        Map<String, Integer> map6 = clientDetailPageService.viewClientHistory(program, exitForm);
        assertEquals(Integer.valueOf(map6.get("Project entry")), Integer.valueOf(0));
        assertEquals(Integer.valueOf(map6.get("Project update")), Integer.valueOf(0));
        assertEquals(Integer.valueOf(map6.get("Project exit")), Integer.valueOf(1));


        // make new enrollment as draft
        ////  close the right panel before click exit
        clientDetailPageService.closeRightSlider();
        Thread.sleep(1000);

        clientDetailPageService.newEnrollmentAsDraft(newProgramForEnrollment);
        
        //View Form History [no new entry for draft ]
        Thread.sleep(3000);
        Map<String, Integer> map7 = clientDetailPageService.viewClientHistory(newProgramForEnrollment, form1);
        assertEquals(Integer.valueOf(map7.get("Project entry")), Integer.valueOf(0));
        assertEquals(Integer.valueOf(map7.get("Project update")), Integer.valueOf(0));
        assertEquals(Integer.valueOf(map7.get("Project exit")), Integer.valueOf(0));


        //save that enrollment( from pending to save enrollment)
        clientDetailPageService.closeRightSlider();
        Thread.sleep(1000);

        clientDetailPageService.savePendingEnrollment(newProgramForEnrollment);

        // view Form history
        Thread.sleep(3000);
        Map<String, Integer> map8 = clientDetailPageService.viewClientHistory(newProgramForEnrollment, form1);
        assertEquals(Integer.valueOf(map8.get("Project entry")), Integer.valueOf(1));
        assertEquals(Integer.valueOf(map8.get("Project update")), Integer.valueOf(0));
        assertEquals(Integer.valueOf(map8.get("Project exit")), Integer.valueOf(0));
    }


}
