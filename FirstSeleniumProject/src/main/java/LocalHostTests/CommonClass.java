package LocalHostTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static org.testng.Assert.fail;

/**
 * Created by zemoso on 4/4/17.
 */
public class CommonClass {
    public String baseUrl = "http://localhost:8080/phhs";
    private StringBuffer verificationErrors = new StringBuffer();
    String driverPath = "/home/zemoso/geckodriver.exe";
    public static WebDriver driver;

    public static WebDriver getDriverInstance() {
        return driver;
    }


    @BeforeSuite
    public void setUp() {
        System.out.println("launching firefox browser");
        // launch firefox
        System.setProperty("webdriver.firefox.marionette", driverPath);
        driver = DriverFactory.createDriver();
        driver.get(baseUrl);

        // login username and password
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("sudhir");
        WebElement password = driver.findElement(By.id("pWord"));
        password.sendKeys("sudhir12");
        WebElement loginButton = driver.findElement(By.id("buttonLogin"));
        loginButton.click();

        // if already logged In
        if(driver.findElements(By.xpath("//h4[@id=\"modal_already-logged-in_label\"]/strong")).size() >0){
            System.out.println("Continuing to already login");
            driver.findElement(By.xpath("//div[@id=\"modal_already-logged-in\"]/div/div/div[@class=\"modal-footer\"]/button[@class=\"btn btn-default\"]")).click();
        }

        // if verify your identity modal appear
        driver.findElement(By.xpath("//div[@class=\"modal-footer\"]/button[@id=\"pin-process_submit\"]")).click();

        // enter random pin
        driver.findElement(By.id("pin-verify_pin")).sendKeys("12345");
        driver.findElement(By.id("pin-verify_submit")).click();
        driver.findElement(By.xpath("//div[@class=\"dropdown\"]/div/button")).click();
        driver.findElement(By.linkText("Case Management")).click();
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
