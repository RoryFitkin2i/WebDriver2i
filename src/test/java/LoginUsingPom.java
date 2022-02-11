import Base.TestBase;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import poms.HomePOM;
import poms.LoginPOM;

public class LoginUsingPom extends TestBase {
    @DisplayName("Reads from a CSV using JUnit5")
    @ParameterizedTest
    @CsvFileSource(files ="test-data.csv", useHeadersInDisplayName = true)
    void Login(String username, String password) throws InterruptedException{
        driver.get("https://www.edgewordstraining.co.uk/webdriver2/");
        HomePOM homepage = new HomePOM(driver);
        homepage.goLogin();

        LoginPOM loginPage = new LoginPOM(driver);

        //loginPage.loginExpectSuccess("edgewords", "edgewords123");
        Assert.assertTrue(loginPage.loginExpectSuccess(username, password));
        Thread.sleep(3000);
    }
}
