package TestUsingCookies;

/**
 * Created by zemoso on 20/4/17.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.TimeUnit;

public class SaveCookies
{
    static WebDriver driver;

    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver","/OnlineShopping/InputData/chromedriver.exe");
        driver=new ChromeDriver();
        driver.get("http://demo.avactis.com/4.7.9/");

        driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div/ul/li[1]/span/a")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Input Emial id and Password If you are already Register
        driver.findElement(By.xpath(".//*[@id='account_sign_in_form_email_id']")).sendKeys("<<UserName>>");
        driver.findElement(By.xpath(".//*[@id='account_sign_in_form_passwd_id']")).sendKeys("<< Password>>");
        driver.findElement(By.name("SignInbtn")).click();

        // create file named Cookies to store Login Information
        File file = new File("Cookies.data");
        try
        {
            // Delete old file if exists
            file.delete();
            file.createNewFile();
            FileWriter fileWrite = new FileWriter(file);
            BufferedWriter Bwrite = new BufferedWriter(fileWrite);
            // loop for getting the cookie information
            for(Cookie ck : driver.manage().getCookies())
            {
                Bwrite.write((ck.getName()+";"+ck.getValue()+";"+ck.getDomain()+";"+ck.getPath()+";"+ck.getExpiry()+";"+ck.isSecure()));
                Bwrite.newLine();
            }
            Bwrite.flush();
            Bwrite.close();
            fileWrite.close();
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}
