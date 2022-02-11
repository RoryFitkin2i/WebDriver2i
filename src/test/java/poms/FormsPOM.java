package poms;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FormsPOM {

    WebDriver driver;

    public FormsPOM(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    //Locators
    @FindBy(id = "textInput")
    WebElement requiredField;

    @FindBy(id = "textArea")
    WebElement areaField;

    @FindBy(id = "textArea")
    WebElement twoButton;

    @FindBy(linkText = "Submit")
    WebElement submitButton;

    public void setText(String required){
        requiredField.clear();
        requiredField.sendKeys(required);
    }

    public void setArea(String area){
        areaField.clear();
        areaField.sendKeys(area);
    }

    public void twoForm(){
        twoButton.click();
    }

    public void submitForm(){
        submitButton.click();
    }

    public boolean formExpectSuccess(String required,String area) throws InterruptedException {
        setText(required);
        setArea(area);
        twoForm();
        submitForm();
        Thread.sleep(3000);
        String bodyText = driver.findElement(By.id("textInputValue")).getText();
        boolean formSubmitted = bodyText.contains(required);
        return formSubmitted;

    }
}
