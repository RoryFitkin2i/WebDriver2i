import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OwnTest {
    WebDriver driver;
    @BeforeEach
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

    }
    @AfterEach
    void tearDown(){
        driver.quit();
    }

    @Test
    void firstTest(){
        driver.get("https://www.edgewordstraining.co.uk/webdriver2/");
        driver.findElement(By.linkText("Access Basic Examples Area")).click();
        driver.findElement(By.cssSelector("#menu > ul > li.last > a")).click();
        Assert.assertEquals(driver.getTitle(), ("Automated Tools Test Site"));
        String floatText = driver.findElement(By.xpath("//div[@id='floater']")).getText();
        assertThat(floatText, containsString("float right"));
        driver.findElement(By.id("floater")).click();
        floatText = driver.findElement(By.xpath("//div[@id='floater']")).getText();
        assertThat(floatText, containsString("float left"));
        driver.findElement(By.id("floater")).click();
        floatText = driver.findElement(By.xpath("//div[@id='floater']")).getText();
        assertThat(floatText, containsString("float right"));

    }
}
