import Base.TestBase;
import org.junit.Assert;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import poms.HomePOM;
import poms.LoginPOM;
import poms.BasicPOM;
import poms.FormsPOM;

public class MyOwnPomTest extends TestBase{

    @DisplayName("Adds Form and checks it's added")
    @ParameterizedTest
    @CsvFileSource(files ="form-test-data.csv", useHeadersInDisplayName = true)
    //@Test
    void addForm(String required, String area) throws InterruptedException{
        driver.get("https://www.edgewordstraining.co.uk/webdriver2/");
        HomePOM homepage = new HomePOM(driver);
        homepage.goBasic();

        BasicPOM basicPage = new BasicPOM(driver);
        basicPage.goForms();

        FormsPOM formsPage = new FormsPOM(driver);

        Assert.assertTrue(formsPage.formExpectSuccess(required, area));
        Thread.sleep(3000);
    }

}
