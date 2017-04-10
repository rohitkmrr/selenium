package LocalHostTests;

import net.jsourcerer.webdriver.jserrorcollector.JavaScriptError;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by zemoso on 31/3/17.
 */
public class makeNewClient2 {
    public String baseUrl = "http://localhost:8080/phhs";
    String driverPath = "/home/zemoso/geckodriver.exe";
    public WebDriver driver ;

    public void loggingIn() throws InterruptedException, IOException {
        System.out.println("launching firefox browser");

        // launch firefox
        System.setProperty("webdriver.firefox.marionette", driverPath);
        FirefoxProfile ffProfile = new FirefoxProfile();
        JavaScriptError.addExtension(ffProfile);
        driver = new FirefoxDriver(ffProfile);

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS) ;
        driver.get(baseUrl);

        // login username and password
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("sudhir");
        WebElement password = driver.findElement(By.id("pWord"));
        password.sendKeys("sudhir12");
        WebElement loginButton = driver.findElement(By.id("buttonLogin"));
        loginButton.click();
        List<JavaScriptError> jsErrors = JavaScriptError.readErrors(driver);
        printErrors(jsErrors);

        // if already logged In
        // // TODO: 31/3/17
        Thread.sleep(2000);
        if(driver.findElements(By.xpath("//h4[@id=\"modal_already-logged-in_label\"]/strong")).size() >0){
            System.out.println("Continuing to already login");
            driver.findElement(By.xpath("//div[@id=\"modal_already-logged-in\"]/div/div/div[@class=\"modal-footer\"]/button[@class=\"btn btn-default\"]")).click();
        }

        // if verify your identity modal appear
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@class=\"modal-footer\"]/button[@id=\"pin-process_submit\"]")).click();

        // enter random pin
        Thread.sleep(1000);
        driver.findElement(By.id("pin-verify_pin")).sendKeys("12345");
        Thread.sleep(500);
        driver.findElement(By.id("pin-verify_submit")).click();
        Thread.sleep(1000);

    }


    @Test(priority = 0)
    public void adminPage() throws InterruptedException, IOException {
        //login
        loggingIn();

        // select Case Management from dropdown
        driver.findElement(By.xpath("//div[@class=\"dropdown\"]/div/button")).click();
        driver.findElement(By.xpath("//ul[@id=\"accountsMenu\"]/li[2]/a")).click();
        Thread.sleep(1000);

        // TODO:  test cases for forms here
        driver.findElement(By.id("newClient")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("dddddddddd");
        driver.findElement(By.xpath("(//input[@id='email'])[2]")).clear();
        driver.findElement(By.xpath("(//input[@id='email'])[2]")).sendKeys("bali");
        new Select(driver.findElement(By.xpath("//div[@id='clientinfo']/div/form/div[3]/select"))).selectByVisibleText("II");
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//button[@type='button'])[30]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//button[@type='button'])[30]")).click();

        driver.findElement(By.id("cert0")).click();
        driver.findElement(By.xpath("(//button[@type='button'])[30]")).click();
        driver.findElement(By.xpath("//div[@id='programSelection']/div/span/span/span")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[19]/div/ul/li[10]")).click();
        List<JavaScriptError> jsErrors = JavaScriptError.readErrors(driver);
        printErrors(jsErrors);
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
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//button[@type='button'])[30]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("(//button[@type='button'])[30]")).click();
        Thread.sleep(3000);
        List<JavaScriptError> jsErrors2 = JavaScriptError.readErrors(driver);
        printErrors(jsErrors2);
        //logout
        logout();
        List<JavaScriptError> jsErrors1 = JavaScriptError.readErrors(driver);
        printErrors(jsErrors1);

        //close the browser
        driver.close();
        driver.quit();
    }


    public void logout() throws InterruptedException {
        System.out.println("Logging out");
        driver.findElement(By.xpath("//div[@class=\"dropdown open hover\"]/div/button")).click();
        driver.findElement(By.xpath("//ul[@id=\"accountsMenu\"]/li[8]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id=\"modalLogoutConfirmation\"]/div/div/div[@class=\"modal-footer\"]/button")).click();

    }

    public void printErrors(List<JavaScriptError> jsErrors) {
        System.out.println("Errors are " + jsErrors.size());
        for(int i=0; i<jsErrors.size();i++) {
            System.out.println(jsErrors.get(i).getErrorMessage());
            System.out.println("Error Line: "+ jsErrors.get(i).getLineNumber());
            System.out.println(jsErrors.get(i).getSourceName());
            System.out.println("\n");
        }
    }

}

