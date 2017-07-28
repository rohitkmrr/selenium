package TestDevIris;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.fail;

/**
 * Created by zemoso on 6/4/17.
 */
public class LoginPage {
    public String baseUrl = "http://192.168.86.24:8080/phhs";
    private StringBuffer verificationErrors = new StringBuffer();
    String driverPath = "/home/zemoso/geckodriver.exe";
    protected static WebDriver driver;

    public static WebDriver getDriverInstance() {
        return driver;
    }
    private static By userNameElement = By.id("username");
    private static By passwordElement = By.id("pWord");
    private static By loginButtonElement = By.id("buttonLogin");
    private static By verifyByEmail = By.id("pin-process_submit");
    private static By submitPin =By.id("pin-verify_submit");
    private static By inputPin =By.id("pin-verify_pin");
    private static By mainMenuDropdown =By.xpath("//div[@class=\"dropdown\"]/div/button");
    private static By adminDashboardLink =By.linkText("Administration");
    private static By alreadyLoginCancel =By.xpath("//button[@onclick='alreadyLoggedIn_cancel()']");
    private static By alreadyLoginSubmit = By.xpath("//button[@onclick='alreadyLoggedIn_submit()']");
    private static By privacyPolicyRadioButton = By.id("privacyPolicy");
    private static By privacyPolicyOkButton = By.xpath("//button[text()='Ok']");


    @BeforeSuite
    public void setUp() throws InterruptedException{
        System.out.println("launching firefox browser");
        // launch firefox
        System.setProperty("webdriver.firefox.marionette", driverPath);
        driver = DriverFactory.createDriver();
        driver.get(baseUrl);

        // Confirm Privacy abd Confidentiality Policy
        Thread.sleep(2000);
        WebElement radioBtn = driver.findElement(privacyPolicyRadioButton);
        radioBtn.click();
        driver.findElement(privacyPolicyOkButton).click();


        // login username and password
        WebElement userName = driver.findElement(userNameElement);
        userName.sendKeys("sreekanth");
        WebElement password = driver.findElement(passwordElement);
        password.sendKeys("sreekanth12");
        WebElement loginButton = driver.findElement(loginButtonElement);
        Thread.sleep( 1000 );
        loginButton.click();

        // if already logged In
        turnOffImplicitWaits();
        if(isElementPresent(alreadyLoginCancel)) {
            turnOnImplicitWaits();
            System.out.println("Continuing to already login");
            driver.findElement(alreadyLoginSubmit).click();
        }
        else
            turnOnImplicitWaits();

        // if verify your identity modal appear
        driver.findElement(verifyByEmail).click();

        // enter random pin
        driver.findElement(inputPin).clear();
        driver.findElement(inputPin).sendKeys("1234");
        driver.findElement(submitPin).click();
        driver.findElement(mainMenuDropdown).click();
        driver.findElement(adminDashboardLink).click();
    }


    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public static void turnOffImplicitWaits() {
        driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
    }

    public static void turnOnImplicitWaits() {
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
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
