package ChromeLogin;

import TestDevIris.LoginPage;

/**
 * Created by zemoso on 14/6/17.
 *
 * Assumption: This test case assume that the client name you are providing is not restricted.
 *
 * This test case will restrict the particular client from a program(specified by user) and
 * from All Services(default) from a startDate to endDate (both are specified by user).
 *
 */
public class RestrictClientTest extends LoginPage{
   /* MainMenuService mainMenuService = new MainMenuService();
    public static By clientDetailDropdown = By.id("id_client_detail_options");
    public static By restrictClientLink = By.linkText("Restrict Client");
    public static By addNewRestrictionButton = By.linkText("Add New");
    public static By selectProgramButton = By.xpath("//span[text() = 'Select Program']");
    public static By startDateButton = By.xpath("//label[text() = 'Start Date']/following-sibling::span/span/span/span");
    public static By endDateButton = By.xpath("//label[text() = 'End Date']/following-sibling::span/span/span/span");
    public static By reasonTextArea = By.xpath("//label[text() = 'Reason']/following-sibling::textarea");
    public static By doneAddRestriction = By.xpath("//a[@ng-click = 'addNewRestriction(newRestriction)']");
    public static By closeButtonForRestriction = By.xpath("//h4[contains(text(),'Client Restrictions')]/button[@class = 'close']");



    @BeforeClass
    public void gotoCaseManagerDashBoard() {
        WebDriver driver = getDriverInstance();
        mainMenuService.gotoCaseManagerDashBoard (driver);
    }

    @Test
    public void ClientRestriction() throws InterruptedException{
        //Select a client name which is not restricted
        String firstName = "Ftvgy";
        String secondName = "Ygvbuh";
        //select program name
        String programName = "All programs";
        //select startDate and endDate
        String startDate = "16";
        String endDate = "19";
        // select a client
        driver.findElement(By.xpath("//a[@title = '"+secondName+", "+firstName+"  ']")).click();
        driver.findElement(clientDetailDropdown).click();
        driver.findElement(restrictClientLink).click();
        driver.findElement(addNewRestrictionButton).click();
        driver.findElement(selectProgramButton).click();
        Thread.sleep( 1000 );
        driver.findElement(By.xpath("//li[text() = '"+programName+"']")).click();
        driver.findElement(startDateButton).click();
        Thread.sleep( 1000 );
        //Select a from date
        driver.findElement(By.xpath("//a[contains(text(),'"+startDate+"')]")).click();
        driver.findElement(endDateButton).click();
        Thread.sleep( 1000 );
        //Select a end date
        driver.findElement(By.xpath("(//a[contains(text(),'"+endDate+"')])[2]")).click();
        //Enter text in Reason text area
        driver.findElement(reasonTextArea).clear();
        driver.findElement(reasonTextArea).sendKeys("rt");
        //Done
        driver.findElement(doneAddRestriction).click();
        driver.findElement(closeButtonForRestriction).click();
    }*/

}
