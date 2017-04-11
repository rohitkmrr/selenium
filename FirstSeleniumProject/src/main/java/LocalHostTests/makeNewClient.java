package LocalHostTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.fail;

/**
 * Created by zemoso on 31/3/17.
 */
public class makeNewClient {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();

    @BeforeClass(alwaysRun = true)
    public void setUp() throws Exception {
        String driverPath = "/home/zemoso/geckodriver.exe";
        System.setProperty("webdriver.firefox.marionette", driverPath);
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void testMakeNewClient() throws Exception {
        driver.get("http://localhost:8080/phhs/cwDashboard");
        assertEquals(driver.getTitle(), "Case Manager Dashboard");
        driver.findElement(By.id("newClient")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("dddddddddd");
        driver.findElement(By.xpath("(//input[@id='email'])[2]")).clear();
        driver.findElement(By.xpath("(//input[@id='email'])[2]")).sendKeys("bali");
        new Select(driver.findElement(By.xpath("//div[@id='clientinfo']/div/form/div[3]/select"))).selectByVisibleText("II");
        driver.findElement(By.xpath("(//button[@type='button'])[30]")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[30]")).click();
        driver.findElement(By.id("cert0")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[30]")).click();
        driver.findElement(By.xpath("//div[@id='programSelection']/div/span/span/span")).click();
        driver.findElement(By.xpath("//div[19]/div/ul/li[10]")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[30]")).click();
        new Select(driver.findElement(By.xpath("//div[@id='collapse_2']/div/div[2]/div/div/select"))).selectByVisibleText("Yes");
        driver.findElement(By.xpath("(//option[@value='0'])[6]")).click();
        driver.findElement(By.xpath("(//input[@type='text'])[31]")).clear();
        driver.findElement(By.xpath("(//input[@type='text'])[31]")).sendKeys("999999");
        driver.findElement(By.xpath("(//input[@type='text'])[34]")).clear();
        driver.findElement(By.xpath("(//input[@type='text'])[34]")).sendKeys("88888");
        driver.findElement(By.xpath("(//input[@type='text'])[37]")).clear();
        driver.findElement(By.xpath("(//input[@type='text'])[37]")).sendKeys("777777");
        driver.findElement(By.xpath("(//button[@type='button'])[30]")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[30]")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[30]")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[30]")).click();
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

}
