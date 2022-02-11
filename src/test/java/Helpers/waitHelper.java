package Helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class waitHelper {
    public static void waitHelper1(By locator, int timeSeconds, WebDriver driver){
        WebDriverWait mywait = new WebDriverWait(driver , Duration.ofSeconds(timeSeconds));
        mywait.until(ExpectedConditions.elementToBeClickable((locator)));
    }

}
