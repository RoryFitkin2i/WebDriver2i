package poms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePOM {
    //field to work with webdriver instance
    WebDriver driver;

    //constructor to accept driver from test and run pagefactory
    public HomePOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //locators
    @FindBy(linkText = "Login To Restricted Area")
    WebElement loginLink;

    @FindBy(linkText = "Access Basic Examples Area")
    WebElement basicLink;

    public void goLogin(){
        loginLink.click();
    }

    public void goBasic(){
        basicLink.click();
    }

}
