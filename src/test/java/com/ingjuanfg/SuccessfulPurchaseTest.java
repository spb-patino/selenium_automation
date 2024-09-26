package com.ingjuanfg;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
        driver.get("https://www.saucedemo.com/");

        // Act
        WebElement inputUser = driver.findElement(By.xpath("//div[@class='login_wrapper-inner']//input[@data-test='username']"));
        WebElement inputPassword = driver.findElement(By.xpath("//div[@class='login_wrapper-inner']//input[@data-test='password']"));
        WebElement buttonLogin = driver.findElement(By.xpath("//div[@class='login_wrapper-inner']//input[@data-test='login-button']"));
        inputUser.sendKeys("standard_user");
        inputPassword.sendKeys("secret_sauce");
        buttonLogin.click();

        WebElement buttonFirstProduct = driver.findElement(By.xpath(
                "//div[@data-test='inventory-item-description']//div[@data-test='inventory-item-name' and text()='Sauce Labs Backpack']/ancestor::div[@data-test='inventory-item-description']//button[@data-test='add-to-cart-sauce-labs-backpack']"));
        buttonFirstProduct.click();

        WebElement buttonSecondProduct = driver.findElement(By.xpath(
                "//div[@data-test='inventory-item-description']//div[@data-test='inventory-item-name' and text()='Sauce Labs Bike Light']/ancestor::div[@data-test='inventory-item-description']//button[@data-test='add-to-cart-sauce-labs-bike-light']"));
        buttonSecondProduct.click();

        WebElement buttonShoppingCart = driver
                .findElement(By.xpath("//div[@data-test='primary-header']//a[@data-test='shopping-cart-link']"));
        buttonShoppingCart.click();

        WebElement buttonCheckout = driver
                .findElement(By.xpath("//div[@class='cart_footer']//button[@data-test='checkout']"));
        buttonCheckout.click();

        WebElement inputFirstName = driver
                .findElement(By.xpath("//div[@class='checkout_info']//input[@data-test='firstName']"));
        WebElement inputLastName = driver
                .findElement(By.xpath("//div[@class='checkout_info']//input[@data-test='lastName']"));
        WebElement inputPostalCode = driver
                .findElement(By.xpath("//div[@class='checkout_info']//input[@data-test='postalCode']"));

        inputFirstName.sendKeys("John");
        inputLastName.sendKeys("Doe");
        inputPostalCode.sendKeys("12345");

        WebElement buttonCheckoutContinue = driver
                .findElement(By.xpath("//div[@class='checkout_buttons']//input[@data-test='continue']"));
        buttonCheckoutContinue.click();

        WebElement textFirstProductPrice = driver.findElement(By.xpath(
                "//div[@data-test='inventory-item']//div[@data-test='inventory-item-name' and text()='Sauce Labs Backpack']/ancestor::div[@data-test='inventory-item']//div[@data-test='inventory-item-price']"));
        float firstProductPrice = Float.parseFloat(textFirstProductPrice.getText().replace("$", ""));
        System.out.println(firstProductPrice);

        WebElement textSecondProductPrice = driver.findElement(By.xpath(
                "//div[@data-test='inventory-item']//div[@data-test='inventory-item-name' and text()='Sauce Labs Bike Light']/ancestor::div[@data-test='inventory-item']//div[@data-test='inventory-item-price']"));
        float secondProductPrice = Float.parseFloat(textSecondProductPrice.getText().replace("$", ""));
        System.out.println(secondProductPrice);

        float itemTotal = firstProductPrice + secondProductPrice;

        WebElement textItemTotal = driver
                .findElement(By.xpath("//div[@class='summary_info']//div[@data-test='subtotal-label']"));
        float itemTotalFromPage = Float.parseFloat(textItemTotal.getText().replace("Item total: $", ""));

        WebElement textTatalTax = driver
                .findElement(By.xpath("//div[@class='summary_info']//div[@data-test='tax-label']"));
        float totalTax = Float.parseFloat(textTatalTax.getText().replace("Tax: $", ""));

        WebElement textTotal = driver
                .findElement(By.xpath("//div[@class='summary_info']//div[@data-test='total-label']"));
        float total = Float.parseFloat(textTotal.getText().replace("Total: $", ""));

        float grandTotal = itemTotal + totalTax;

        WebElement buttonFinishCheckout = driver
                .findElement(By.xpath("//div[@class='cart_footer']//button[@data-test='finish']"));
        buttonFinishCheckout.click();

        WebElement imgComplete = driver.findElement(
                By.xpath("//div[@data-test='checkout-complete-container']//img[@data-test='pony-express']"));
        String complete = imgComplete.getAttribute("alt");
        String completeText = "Pony Express";

        // Assert
        assertEquals(itemTotal, itemTotalFromPage);
        assertEquals(grandTotal, total);
        assertEquals(complete, completeText);

    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }
}
