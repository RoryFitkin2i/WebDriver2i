package poms;

import com.github.dockerjava.api.model.Link;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasicPOM {
    //field to work with webdriver instance
    WebDriver driver;

    //constructor to accept driver from test and run pagefactory
    public BasicPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(linkText = "Forms")
    WebElement formsLink;

    public void goForms(){
        formsLink.click();
    }


}
