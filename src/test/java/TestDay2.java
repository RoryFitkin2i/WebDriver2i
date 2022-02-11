import Base.TestBase;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static Helpers.waitHelper.*;

import java.time.Duration;

public class TestDay2 extends TestBase{

    @Test
    void loginlogout() throws InterruptedException{
        driver.get("https://www.edgewordstraining.co.uk/webdriver2/");
        driver.findElement(By.linkText("Login To Restricted Area")).click();
        driver.findElement(By.id("username")).sendKeys("edgewords");
        driver.findElement(By.id("password")).sendKeys("edgewords123");
        driver.findElement(By.linkText("Submit")).click();
        driver.findElement(By.linkText("Log Out")).click();
        driver.switchTo().alert().accept();
        //Thread.sleep(5000);
        //WebDriverWait mywait = new WebDriverWait(driver , Duration.ofSeconds(10));
        //mywait.until(ExpectedConditions.elementToBeClickable((By.id("username"))));
        waitHelper1(By.id("username"), 10, driver);
        driver.findElement(By.id("username")).sendKeys("finished");


    }


}
