import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

/**
 * Created by zemoso on 30/3/17.
 */
public class ContinueFromAWebpage {
    public String baseUrl = "http://localhost:8080/phhs";
    String driverPath = "C:\\geckodriver.exe";
    public WebDriver driver ;

    @Test
    public void goToLogin234() throws InterruptedException {
        System.out.println("launching firefox browser");
        // launch firefox
       /* WebDriver WebDriver = null;

        try
        {
            System.Uri uri = new System.Uri("http://localhost:7055/hub");
            WebDriver = new RemoteWebDriver(uri, DesiredCapabilities.Firefox());

        }

        catch (Exception)
        {

            WebDriver = new FirefoxDriver(firefoxProfile);

        }*/

        Thread.sleep(5000);


    }
}
