import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

/**
 * Created by rohit on 30/3/17.
 */
public class TestingIrisLogin {
    public String baseUrl = "http://localhost:8080/phhs";
    String driverPath = "/home/zemoso/geckodriver.exe";
    public WebDriver driver ;

    @Test(priority = 0)
    public void adminPage() throws InterruptedException {
        //login
        loggingIn();

        // select Administration from dropdown
        driver.findElement(By.xpath("//div[@class=\"dropdown\"]/div/button")).click();
        driver.findElement(By.xpath("//ul[@id=\"accountsMenu\"]/li[4]/a")).click();
        Thread.sleep(1000);

        // TODO: 30/3/17 test cases for forms here 

        //logout
        logout();

        //close the browser
        driver.close();
        driver.quit();
    }

    public void loggingIn() throws InterruptedException {
        System.out.println("launching firefox browser");
        // launch firefox
        System.setProperty("webdriver.firefox.marionette", driverPath);
        driver = new FirefoxDriver();
        driver.get(baseUrl);

        // login username and password
        WebElement userName = driver.findElement(By.id("username"));
        userName.sendKeys("sudhir");
        WebElement password = driver.findElement(By.id("pWord"));
        password.sendKeys("sudhir12");
        WebElement loginButton = driver.findElement(By.id("buttonLogin"));
        loginButton.click();

        // if already logged In
        Thread.sleep(1000);
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

    public void logout() throws InterruptedException {
        System.out.println("Logging out");
        driver.findElement(By.xpath("//div[@class=\"dropdown open hover\"]/div/button")).click();
        driver.findElement(By.xpath("//ul[@id=\"accountsMenu\"]/li[8]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//div[@id=\"modalLogoutConfirmation\"]/div/div/div[@class=\"modal-footer\"]/button")).click();

    }
}
