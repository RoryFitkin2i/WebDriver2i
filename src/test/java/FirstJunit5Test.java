import Base.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class FirstJunit5Test extends TestBase {

    @Test
    void firstTest(){
        driver.get("https://www.edgewordstraining.co.uk/webdriver2/");
        driver.findElement(By.linkText("Login To Restricted Area")).click();

    }

    @Test
    void secondTest(){
        // Test name: FormIDEDemo
        // Step # | name | target | value
        // 1 | open | /webdriver2/ |
        driver.get("https://www.edgewordstraining.co.uk/webdriver2/");
        // 2 | setWindowSize | 974x1040 |
        driver.manage().window().setSize(new Dimension(974, 1040));
        // 3 | click | css=.last span |
        driver.findElement(By.cssSelector(".last span")).click();
        // 4 | click | linkText=Forms |
        driver.findElement(By.linkText("Forms")).click();
        // 5 | click | id=textInput |
        driver.findElement(By.id("textInput")).click();
        // 6 | type | id=textInput | hello world
        driver.findElement(By.id("textInput")).sendKeys("hello world");
        // 7 | click | id=textArea |
        driver.findElement(By.id("textArea")).click();
        // 8 | type | id=textArea | was here
        driver.findElement(By.id("textArea")).sendKeys("was here");
        // 9 | click | linkText=Submit |
        driver.findElement(By.linkText("Submit")).click();
        // 10 | click | id=textInputValue |
        driver.findElement(By.id("textInputValue")).click();
        // 11 | assertText | id=textInputValue | hello world
        assertThat(driver.findElement(By.id("textInputValue")).getText(), is("hello world"));
        // 12 | click | css=tr:nth-child(3) > td:nth-child(3) |
        driver.findElement(By.cssSelector("tr:nth-child(3) > td:nth-child(3)")).click();
        // 13 | verifyText | id=textAreaValue | was here
        try{
            assertThat(driver.findElement(By.id("textAreaValue")).getText(), is("was1 here"));
        } catch(AssertionError e){
            verificationErrors.append(e.toString());
            //System.out.println(e.toString());
        }

        // 14 | click | linkText=CSS/XPath |
        driver.findElement(By.linkText("CSS/XPath")).click();
        // 15 | mouseDownAt | css=.ui-slider-handle | -41.71875,5.453125
        {
            WebElement element = driver.findElement(By.cssSelector(".ui-slider-handle"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).clickAndHold().perform();
        }
        // 16 | mouseMoveAt | id=slider-holder | 212,24.5
        {
            WebElement element = driver.findElement(By.id("slider-holder"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).perform();
        }
        // 17 | mouseUpAt | id=slider-holder | 212,24.5
        {
            WebElement element = driver.findElement(By.id("slider-holder"));
            Actions builder = new Actions(driver);
            builder.moveToElement(element).release().perform();
        }
        // 18 | click | css=.ui-slider-handle |
        driver.findElement(By.cssSelector(".ui-slider-handle")).click();
        // 19 | click | linkText=Home |
        driver.findElement(By.linkText("Home")).click();
    }
}
