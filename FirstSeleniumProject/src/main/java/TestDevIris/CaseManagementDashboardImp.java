package TestDevIris;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by zemoso on 10/4/17.
 */
public class CaseManagementDashboardImp implements CaseManagementDashboard {
    public void addNewClient(WebDriver driver, String programName) {
        driver.findElement(By.id("newClient")).click();
        driver.findElement(By.id("email")).clear();
        driver.findElement(By.id("email")).sendKeys("Rohit1");
        driver.findElement(By.xpath("(//input[@id='email'])[2]")).clear();
        driver.findElement(By.xpath("(//input[@id='email'])[2]")).sendKeys("Kumar1");
        driver.findElement(By.xpath("//button[@ng-click='broadCastContinueEvent();']")).click();
        driver.findElement(By.xpath("//button[@ng-click='broadCastContinueEvent();']")).click();
        driver.findElement(By.id("cert0")).click();
        driver.findElement(By.xpath("//button[@ng-click='broadCastContinueEvent();']")).click();
        driver.findElement(By.xpath("//div[@id='programSelection']/div/span/span/span")).click();
        driver.findElement(By.xpath("//div[174]/div/ul/li[text()='Food Coupon']")).click();
//        driver.findElement(By.xpath("//div[174]/div/ul/li[text()='"+programName+"']")).click();
        driver.findElement(By.xpath("//button[@ng-click='broadCastContinueEvent();']")).click();
        driver.findElement(By.xpath("//button[@ng-click='broadCastContinueEvent();']")).click();
        driver.findElement(By.xpath("//button[@ng-click='broadCastContinueEvent();']")).click();
        driver.findElement(By.xpath("//button[@ng-click='broadCastContinueEvent();']")).click();
        driver.findElement(By.xpath("//button[@ng-click='broadCastContinueEvent();']")).click();
    }

    public void editClientByProgramName(String programName) {

    }

    public void viewAppointment() {

    }

    public void newAppointment() {

    }

    public void viewReferralByProgramName(String programName) {

    }
}
