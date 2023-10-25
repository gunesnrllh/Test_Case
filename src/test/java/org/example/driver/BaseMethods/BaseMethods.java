package org.example.driver.BaseMethods;

import org.example.Constants.Elements;
import org.example.driver.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;


public class BaseMethods extends BaseTest {
    WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
    Elements el = new Elements();


    protected WebElement findElement(String by) {
        WebElement element= null;
        try
        {
            element = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(el.getBy(by)));
        }
        catch (TimeoutException e)
        {
            logger.error("Element belirlenen süre icinde bulunamadi");
        }
        return element;

    }
    protected void clickElement(String by) {
        findElement(by).click();
        logger.info(by+" Elementine tiklandi");
    }
    protected void isDisplayedBy(String by)

    {
        if (findElement(by).isDisplayed())
        {
            logger.info(by+" Elementi goruntulendi");
            Assertions.assertTrue(true,"Element goruntulenemedi");
        }
        else
        {
            Assertions.fail("Element gorulmedi");
        }
    }

    protected void sendKeys(String by, String s) {
        findElement(by).sendKeys(s);
        logger.info(by+ "elementine"+s+" texti yazildi");
    }


}
