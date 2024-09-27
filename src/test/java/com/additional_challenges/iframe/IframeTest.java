package com.additional_challenges.iframe;

import java.time.Duration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.additional_challenges.common.Urls;
import com.additional_challenges.iframe.helpers.IframeXpathDefinitions;

public class IframeTest {

    WebDriver driver;

    @BeforeEach
    public void RunBeforeEach(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
    public void TestNavigateIframe() {

        // * ARRANGE
        driver.get(Urls.iframePage);

        // * ACT
        WebElement iframe = driver.findElement(By.xpath(IframeXpathDefinitions.iframe));
        driver.switchTo().frame(iframe);

        WebElement burgerMenuIframe = driver.findElement(By.xpath(IframeXpathDefinitions.burgerMenuIframe));
        burgerMenuIframe.click();
        burgerMenuIframe.click();
        
        WebElement anchorAccordionIframe = driver.findElement(By.xpath(IframeXpathDefinitions.anchorAccordionIframe));
        anchorAccordionIframe.click();
        driver.switchTo().defaultContent();

        WebElement burgerMenuMain = driver.findElement(By.xpath(IframeXpathDefinitions.burgerMenuMain));
        WebElement menuMain = driver.findElement(By.xpath(IframeXpathDefinitions.menuMain));
        burgerMenuMain.click();

        // * ASSERT
        assert menuMain.getAttribute("class").contains("inactive");
    }
    
    @AfterEach
    public void RunAfterEach() {
        try { Thread.sleep(1234); }
        catch (InterruptedException e) { e.printStackTrace(); }
        driver.quit();
    }
    
}
