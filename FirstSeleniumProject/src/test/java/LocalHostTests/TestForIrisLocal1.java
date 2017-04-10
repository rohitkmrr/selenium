package LocalHostTests; /**
 * Created by zemoso on 4/4/17.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

public class TestForIrisLocal1 {
    public String baseUrl = "http://localhost:8080/phhs";
//    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    String driverPath = "/home/zemoso/geckodriver.exe";
    private WebDriver driver ;


    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        System.out.println("launching firefox browser");
        // launch firefox
        System.setProperty("webdriver.firefox.marionette", driverPath);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
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
    }

    @Test(priority = 0)
    public void testCaseManagerEncounter1() throws Exception {
        driver.findElement(By.xpath("//div[@class=\"dropdown\"]/div/button")).click();
        driver.findElement(By.linkText("Case Management")).click();
        assertEquals(driver.getTitle(), "Case Manager Dashboard");
        driver.findElement(By.cssSelector("span > span.ng-binding")).click();
        driver.findElement(By.linkText("New Encounter")).click();
        new Select(driver.findElement(By.xpath("//div[@id=\"encounterMainDiv\"]/div/div/div[2]/div[2]/div/select"))).selectByVisibleText("service");
        driver.findElement(By.xpath("//div[@id=\"encounterMainDiv\"]/div/div/div[5]/div[2]/spin-edit/div/input")).clear();
        driver.findElement(By.xpath("//div[@id=\"encounterMainDiv\"]/div/div/div[5]/div[2]/spin-edit/div/input")).sendKeys("23");
        driver.findElement(By.xpath("//div[@id=\"encounterMainDiv\"]/div/div/div[6]/div/div/textarea")).clear();
        driver.findElement(By.xpath("//div[@id=\"encounterMainDiv\"]/div/div/div[6]/div/div/textarea")).sendKeys("DFGFGJ");
        driver.findElement(By.xpath("//div[@class=\"encModalFooter modal-footer  encFooter ng-scope\"]/button[3]")).click();
    }

    @Test(priority = 1)
    public void testCaseManagerEncounter2() throws Exception {
        driver.findElement(By.xpath("//div[@class=\"dropdown\"]/div/button")).click();
        driver.findElement(By.linkText("Case Management")).click();
        assertEquals(driver.getTitle(), "Case Manager Dashboard");
        driver.findElement(By.cssSelector("span > span.ng-binding")).click();
        driver.findElement(By.linkText("New Encounter")).click();
       /* new Select(driver.findElement(By.xpath("//div[@id=\"encounterMainDiv\"]/div/div/div[2]/div[2]/div/select"))).selectByVisibleText("service");
        driver.findElement(By.xpath("//div[@id=\"encounterMainDiv\"]/div/div/div[5]/div[2]/spin-edit/div/input")).clear();
        driver.findElement(By.xpath("//div[@id=\"encounterMainDiv\"]/div/div/div[5]/div[2]/spin-edit/div/input")).sendKeys("23");
        driver.findElement(By.xpath("//div[@id=\"encounterMainDiv\"]/div/div/div[6]/div/div/textarea")).clear();
        driver.findElement(By.xpath("//div[@id=\"encounterMainDiv\"]/div/div/div[6]/div/div/textarea")).sendKeys("DFGFGJ");
        driver.findElement(By.xpath("//div[@class=\"encModalFooter modal-footer  encFooter ng-scope\"]/button[3]")).click();*/
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    /*private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }*/

    /*private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }*/

    /*private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }*/

}