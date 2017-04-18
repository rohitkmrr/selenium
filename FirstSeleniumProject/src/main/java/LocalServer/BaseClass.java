package LocalServer;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

/**
 * Created by zemoso on 6/4/17.
 */
public class BaseClass {
    public String baseUrl = "http://192.168.86.24:8080/phhs";
    private StringBuffer verificationErrors = new StringBuffer();
    String driverPath = "/home/zemoso/geckodriver.exe";
    protected static WebDriver driver;

    public static WebDriver getDriverInstance() {
        return driver;
    }


    @BeforeSuite
    public void setUp() {
        //// TODO: 18/4/17 to get firefox browser
        System.out.println("launching firefox browser");
        // launch firefox
        System.setProperty("webdriver.firefox.marionette", driverPath);
        driver = DriverFactory.createDriver();
        driver.get(baseUrl);

        // login username and password
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("sreekanth");
        WebElement password = driver.findElement(By.id("pWord"));
        password.sendKeys("sreekanth12");
        WebElement loginButton = driver.findElement(By.id("buttonLogin"));
        loginButton.click();

        /*// if already logged In
        if(driver.findElements(By.xpath("//h4[@id=\"modal_already-logged-in_label\"]/strong")).size() >0){
            System.out.println("Continuing to already login");
            driver.findElement(By.xpath("//div[@id=\"modal_already-logged-in\"]/div/div/div[@class=\"modal-footer\"]/button[@class=\"btn btn-default\"]")).click();
        }*/

        /*if(driver.findElement(By.xpath("//button[@onclick='alreadyLoggedIn_cancel()']")).isDisplayed()){
            System.out.println("Continuing to already login");
            driver.findElement(By.xpath("//button[@onclick='alreadyLoggedIn_submit()']")).click();
        }*/

        if(isElementPresent(By.xpath("//button[@onclick='alreadyLoggedIn_cancel()']"))) {
            System.out.println("Continuing to already login");
            driver.findElement(By.xpath("//button[@onclick='alreadyLoggedIn_submit()']")).click();
        }

        // if verify your identity modal appear
//        driver.findElement(By.xpath("//div[@class=\"modal-footer\"]/button[@id=\"pin-process_submit\"]")).click();
        driver.findElement(By.id("pin-process_submit")).click();

        // enter random pin
        driver.findElement(By.id("pin-verify_pin")).clear();
        driver.findElement(By.id("pin-verify_pin")).sendKeys("1234");
        driver.findElement(By.id("pin-verify_submit")).click();
        driver.findElement(By.xpath("//div[@class=\"dropdown\"]/div/button")).click();
        driver.findElement(By.linkText("Administration")).click();
    }

    public  void createEncounter() {
        driver.findElement(By.xpath("//div[@class=\"dropdown open hover\"]/div/button")).click();
        //goto case manager
        driver.findElement(By.linkText("Case Management")).click();
        assertEquals(driver.getTitle(), "Case Manager Dashboard");
        // select program and client
        driver.findElement(By.cssSelector("span.k-input.ng-scope")).click();
        driver.findElement(By.xpath("//ul[@id='programFilterId_listbox']/li[7]")).click();
        driver.findElement(By.cssSelector("a[title=\"client, social  \"] > span > span.ng-binding")).click();
        // make new encounter
        driver.findElement(By.linkText("New Encounter")).click();
        new Select(driver.findElement(By.xpath("//div[@id='encounterMainDiv']/div/div/div[2]/div/div/select"))).selectByVisibleText("Food Coupons");
        new Select(driver.findElement(By.xpath("//div[@id='encounterMainDiv']/div/div/div[2]/div[2]/div/select"))).selectByVisibleText("s9");
        driver.findElement(By.xpath("//div[@id='encounterMainDiv']/div/div/div[5]/div[2]/spin-edit/div/input")).clear();
        driver.findElement(By.xpath("//div[@id='encounterMainDiv']/div/div/div[5]/div[2]/spin-edit/div/input")).sendKeys("1");
        driver.findElement(By.xpath("(//button[@class='btn btn-default ar pull-right'])")).click();
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
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
