package com.additional_challenges.tab;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.additional_challenges.common.Urls;
import com.additional_challenges.tab.helpers.TabValues;
import com.additional_challenges.tab.helpers.TabXpathDefinitions;

public class TabTest {

    WebDriver driver;

    @BeforeEach
    public void RunBeforeEach() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void TestSwitchToTab() {

        // * ARRANGE
        driver.get(Urls.tabPage);

        // * ACT
        WebElement inputTabOpener = driver.findElement(By.xpath(TabXpathDefinitions.inputTabOpener));
        inputTabOpener.click();
        
        driver.switchTo().window(driver.getWindowHandles().toArray()[1].toString());
        WebElement textareaSearchBox = driver.findElement(By.xpath(TabXpathDefinitions.textareaSearchBox));
        textareaSearchBox.sendKeys(TabValues.searchTopic);
        textareaSearchBox.submit();
    }

    @AfterEach
    public void RunAfterEach() {
        try { Thread.sleep(1234); }
        catch (InterruptedException e) { e.printStackTrace(); }
        driver.quit();
    }
}