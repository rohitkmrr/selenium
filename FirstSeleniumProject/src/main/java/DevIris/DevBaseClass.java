package DevIris;

import LocalServer.DriverFactory;
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


    @BeforeSuite
    public void setUp() throws InterruptedException {
        System.out.println("launching firefox browser");
        // launch firefox
        System.setProperty("webdriver.firefox.marionette", driverPath);
        driver = DriverFactory.createDriver();
        driver.get(baseUrl);

        // login username and password
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("rohit");
        WebElement password = driver.findElement(By.id("pWord"));
        password.sendKeys("Rkumar17094!!");
        WebElement loginButton = driver.findElement(By.id("buttonLogin"));
        loginButton.click();

      /*  // if already logged In
        if(driver.findElements(By.xpath("//h4[@id=\"modal_already-logged-in_label\"]/strong")).size() >0){
            System.out.println("Continuing to already login");
            driver.findElement(By.xpath("//div[@id=\"modal_already-logged-in\"]/div/div/div[@class=\"modal-footer\"]/button[@class=\"btn btn-default\"]")).click();
        }*/

        // if verify your identity modal appear
        driver.findElement(By.id("pin-process_email")).click();
        driver.findElement(By.xpath("//div[@class=\"modal-footer\"]/button[@id=\"pin-process_submit\"]")).click();

        /*(new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.findElement(By.id("pin-verify_pin")).getText().length() != 0;
            }
        });*/

        // enter random pin.
        Thread.sleep(30000);
        driver.findElement(By.id("pin-verify_submit")).click();
        driver.findElement(By.xpath("//div[@class=\"dropdown\"]/div/button")).click();
        driver.findElement(By.linkText("Administration")).click();
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
