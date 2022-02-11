import Base.TestBase;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import poms.HomePOM;
import poms.LoginPOM;

import javax.swing.text.Element;
import java.text.DecimalFormat;
import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;


public class DropDownTest extends TestBase {
    DecimalFormat df = new DecimalFormat("0.00");
    @Test
    void Login() throws InterruptedException{
        driver.get("https://www.edgewordstraining.co.uk/demo-site/my-account/");

        driver.findElement(By.id("username")).sendKeys("rory.fitkin@2itesting.com");
        driver.findElement(By.id("password")).sendKeys("2iTesting2i");
        driver.findElement(By.cssSelector(".woocommerce-Button.button")).click();
        driver.findElement(By.linkText("Shop")).click();
        driver.findElement(By.xpath("//*[@id=\"main\"]/ul/li[3]/a[1]")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector(".single_add_to_cart_button.button.alt")).click();
        Thread.sleep(3000);
        WebElement elementToHover = driver.findElement(By.cssSelector(".cart-contents"));
        WebElement elementToClick = driver.findElement(By.cssSelector(".button.wc-forward"));
        Actions action = new Actions(driver);
        action.moveToElement(elementToHover).click(elementToClick).build().perform();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#coupon_code")).sendKeys("edgewords");
        Double current = Double.parseDouble(driver.findElement(By.cssSelector(".woocommerce-Price-amount.amount")).getText().substring(1));
        current = current * 0.9;
        Double shipping = Double.parseDouble(driver.findElement(By.cssSelector("#post-5 > div > div > div.cart-collaterals > div > table > tbody > tr.shipping > td > span")).getText().substring(1));
        current += shipping;
        driver.findElement(By.name("apply_coupon")).click();
        Thread.sleep(3000);
        Double newcurrent = Double.parseDouble(driver.findElement(By.cssSelector("#post-5 > div > div > div.cart-collaterals > div > table > tbody > tr.order-total > td > strong > span")).getText().substring(1));
        Assert.assertEquals(df.format(current),df.format(newcurrent));

        driver.findElement(By.cssSelector(".woocommerce-store-notice__dismiss-link")).click();
        driver.findElement(By.xpath("//*[@id=\"post-5\"]/div/div/div/div/div/a")).click();
        Thread.sleep(3000);

        driver.findElement(By.id("billing_first_name")).clear();
        driver.findElement(By.id("billing_last_name")).clear();
        driver.findElement(By.id("billing_address_1")).clear();
        driver.findElement(By.id("billing_city")).clear();
        driver.findElement(By.id("billing_postcode")).clear();

        driver.findElement(By.id("billing_first_name")).sendKeys("Rory");
        driver.findElement(By.id("billing_last_name")).sendKeys("Fitkin");
        driver.findElement(By.id("billing_address_1")).sendKeys("90 kenamre road");
        driver.findElement(By.id("billing_city")).sendKeys("Liverpool");
        driver.findElement(By.id("billing_postcode")).sendKeys("L15 3HQ");

        driver.findElement(By.id("billing_phone")).sendKeys("01234567890");

        try {
            WebElement date = driver.findElement(By.id("place_order"));
            date.click();
        }
        catch(org.openqa.selenium.StaleElementReferenceException ex)
        {
            WebElement date = driver.findElement(By.id("place_order"));
            date.click();
        }


        Thread.sleep(3000);
        WebElement orderNumber = driver.findElement(By.tagName("strong"));
        String outputNum = orderNumber.getText();
        System.out.println(outputNum);

        driver.findElement(By.linkText("My account")).click();
        driver.findElement(By.linkText("Orders")).click();
        String help = driver.findElement(By.cssSelector("#post-7 > div > div > div > table > tbody > tr:nth-child(1) > td.woocommerce-orders-table__cell.woocommerce-orders-table__cell-order-number > a")).getText().substring(1);

        Assert.assertEquals(help, outputNum);
        driver.findElement(By.linkText("Logout")).click();

    }
}
