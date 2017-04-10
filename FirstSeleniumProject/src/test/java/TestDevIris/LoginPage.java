package TestDevIris;

import LocalServer.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Created by zemoso on 10/4/17.
 */
public class LoginPage {
    public String baseUrl = "https://10.103.20.117/mdha/";
    String driverPath = "/home/zemoso/geckodriver.exe";
    public static WebDriver driver;
    private static By userNameInput = By.id("username");
    private static By userPasswordInput = By.id("pWord");
    private static By loginButton = By.id("buttonLogin");


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
        WebElement userName = driver.findElement(userNameInput);
        userName.sendKeys("rohit");
        WebElement password = driver.findElement(userPasswordInput);
        password.sendKeys("Rkumar17094!!");
        WebElement logInButton = driver.findElement(loginButton);
        logInButton.click();

       /* // if already logged In
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

        // enter pin.
        Thread.sleep(30000);
        driver.findElement(By.id("pin-verify_submit")).click();
        driver.findElement(By.xpath("//div[@class=\"dropdown\"]/div/button")).click();
        driver.findElement(By.linkText("Administration")).click();
    }

    /*public  void createEncounter() {
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
    }*/

    @AfterSuite
    public void tearDown() throws Exception {
        driver.quit();
    }
}
