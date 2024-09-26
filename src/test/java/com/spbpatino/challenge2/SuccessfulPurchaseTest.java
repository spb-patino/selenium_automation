package com.spbpatino.challenge2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.spbpatino.challenge2.helpers.FormValues;
import com.spbpatino.challenge2.helpers.PageTexts;
import com.spbpatino.challenge2.helpers.Urls;
import com.spbpatino.challenge2.helpers.UseCaseXpathDefinitions;

public class SuccessfulPurchaseTest {
        WebDriver driver;

        @BeforeEach
        public void configuracionInicial() {
                driver = new ChromeDriver();
                driver.manage().window().maximize();
        }

        @Test
        public void testSuccessfulPurchase() {

                // Arrange
                driver.get(Urls.saucedemo);

                // Act
                WebElement inputUser     = driver.findElement(By.xpath(UseCaseXpathDefinitions.anchorInputUser));
                WebElement inputPassword = driver.findElement(By.xpath(UseCaseXpathDefinitions.anchorInputPassword));
                WebElement buttonLogin   = driver.findElement(By.xpath(UseCaseXpathDefinitions.anchorButtonLogin));
                inputUser.sendKeys(FormValues.username);
                inputPassword.sendKeys(FormValues.password);
                buttonLogin.click();

                WebElement buttonFirstProduct =
                        driver.findElement(By.xpath(UseCaseXpathDefinitions.anchorButtonFirstProduct));
                buttonFirstProduct.click();

                WebElement buttonSecondProduct =
                        driver.findElement(By.xpath(UseCaseXpathDefinitions.anchorButtonSecondProduct));
                buttonSecondProduct.click();

                WebElement buttonShoppingCart = 
                        driver.findElement(By.xpath(UseCaseXpathDefinitions.anchorButtonShoppingCart));
                buttonShoppingCart.click();

                WebElement buttonCheckout = driver.findElement(By.xpath(UseCaseXpathDefinitions.anchorButtonCheckout));
                buttonCheckout.click();

                WebElement inputFirstName  = driver.findElement(By.xpath(UseCaseXpathDefinitions.anchorInputFirstName));
                WebElement inputLastName   = driver.findElement(By.xpath(UseCaseXpathDefinitions.anchorInputLastName));
                WebElement inputPostalCode =
                        driver.findElement(By.xpath(UseCaseXpathDefinitions.anchorInputPostalCode));

                inputFirstName.sendKeys(FormValues.name);
                inputLastName.sendKeys(FormValues.lastName);
                inputPostalCode.sendKeys(FormValues.postalCode);

                WebElement buttonCheckoutContinue =
                        driver.findElement(By.xpath(UseCaseXpathDefinitions.anchorButtonCheckoutContinue));
                buttonCheckoutContinue.click();

                WebElement textFirstProductPrice =
                        driver.findElement(By.xpath(UseCaseXpathDefinitions.anchorTextFirstProductPrice));
                float firstProductPrice = 
                        Float.parseFloat(textFirstProductPrice.getText().replace(PageTexts.moneySimbol, ""));
                System.out.println(firstProductPrice);

                WebElement textSecondProductPrice =
                        driver.findElement(By.xpath(UseCaseXpathDefinitions.anchorTextSecondProductPrice));
                float secondProductPrice = 
                        Float.parseFloat(textSecondProductPrice.getText().replace(PageTexts.moneySimbol, ""));
                System.out.println(secondProductPrice);

                float itemTotal = firstProductPrice + secondProductPrice;

                WebElement textItemTotal = driver.findElement(By.xpath(UseCaseXpathDefinitions.anchorTextItemTotal));
                float itemTotalFromPage =
                        Float.parseFloat(textItemTotal.getText().replace(PageTexts.itemTotalMoneySimbol, ""));

                WebElement textTatalTax = driver.findElement(By.xpath(UseCaseXpathDefinitions.anchorTextTatalTax));
                float      totalTax     = Float.parseFloat(textTatalTax.getText().replace(PageTexts.taxTotalMoneySimbol, ""));

                WebElement textTotal = driver.findElement(By.xpath(UseCaseXpathDefinitions.anchorTextTotal));
                float      total     = Float.parseFloat(textTotal.getText().replace(PageTexts.totalMoneySimbol, ""));

                float grandTotal = itemTotal + totalTax;

                WebElement buttonFinishCheckout =
                        driver.findElement(By.xpath(UseCaseXpathDefinitions.anchorButtonFinishCheckout));
                buttonFinishCheckout.click();

                WebElement imgComplete = driver.findElement(By.xpath(UseCaseXpathDefinitions.anchorImgComplete));
                String     complete    = imgComplete.getAttribute(UseCaseXpathDefinitions.anchorAlt);

                  // Assert
                assertEquals(itemTotal, itemTotalFromPage);
                assertEquals(grandTotal, total);
                assertEquals(complete, PageTexts.completeText);
        }

        @AfterEach
        public void tearDown() {
                driver.quit();
        }
}
