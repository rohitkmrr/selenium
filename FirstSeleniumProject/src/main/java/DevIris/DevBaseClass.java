package DevIris;

import TestDevIris.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static org.testng.Assert.fail;

/**
 * Created by zemoso on 7/4/17.
 */
public class DevBaseClass {
    public String baseUrl = "https://10.103.20.117/mdha/";
    private StringBuffer verificationErrors = new StringBuffer();
    String driverPath = "/home/zemoso/geckodriver.exe";
    protected static WebDriver driver;

    public static WebDriver getDriverInstance() {
        return driver;
    }
    private static By userNameElement = By.id("username");
    private static By passwordElement = By.id("pWord");
    private static By loginButtonElement = By.id("buttonLogin");
    private static By verifyByEmail = By.id("pin-process_email");
    private static By submitButtonOnVerifyMethod =By.xpath("//div[@class=\"modal-footer\"]/button[@id=\"pin-process_submit\"]");
    private static By submitPin =By.id("pin-verify_submit");
    private static By mainMenuDropdown =By.xpath("//div[@class=\"dropdown\"]/div/button");
    private static By adminDashboardLink =By.linkText("Administration");


    @BeforeSuite
    public void setUp() throws InterruptedException {
        System.out.println("launching firefox browser");

        // launch firefox
        System.setProperty("webdriver.firefox.marionette", driverPath);
        driver = DriverFactory.createDriver();
        driver.get(baseUrl);

        // login username and password
        WebElement userName = driver.findElement(userNameElement);
        userName.sendKeys("rohit");
        WebElement password = driver.findElement(passwordElement);
        password.sendKeys("Rkumar17094!!");
        WebElement loginButton = driver.findElement(loginButtonElement);
        loginButton.click();

        // if already logged In
//        if(driver.findElements(By.xpath("//h4[@id=\"modal_already-logged-in_label\"]/strong")).size() >0){
        if(driver.findElements(By.xpath("//button[@onclick='alreadyLoggedIn_cancel()']")).size() >0){
            System.out.println("Continuing to already login");
            driver.findElement(By.xpath("//button[@onclick='alreadyLoggedIn_submit()']")).click();
        }

        // if verify your identity modal appear
        driver.findElement(verifyByEmail).click();
        driver.findElement(submitButtonOnVerifyMethod).click();

        // enter random pin.
        Thread.sleep(30000);
        driver.findElement(submitPin).click();
        driver.findElement(mainMenuDropdown).click();
        driver.findElement(adminDashboardLink).click();
    }

    @AfterSuite
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }
}
