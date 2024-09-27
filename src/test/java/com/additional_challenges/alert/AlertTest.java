package com.additional_challenges.alert;

import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.additional_challenges.common.Urls;
import com.additional_challenges.alert.helpers.AlertXpathDefinitions;

public class AlertTest {

    WebDriver driver;

    @BeforeEach
    public void RunBeforeEach() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
    public void TestAcceptAndCloseAlert() {
        
        // * ARRANGE
        driver.get(Urls.alertPage);

        // * ACT
        WebElement buttonAlertTrigger = driver.findElement(By.xpath(AlertXpathDefinitions.buttonAlertTrigger));
        buttonAlertTrigger.click();
        
        try { Thread.sleep(1234); }
        catch (InterruptedException e) { e.printStackTrace(); }
        driver.switchTo().alert().accept();
    }
    
    @AfterEach
    public void RunAfterEach() {
        try { Thread.sleep(1234); }
        catch (InterruptedException e) { e.printStackTrace(); }
        driver.quit();
    }
}