import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

class BasePage {

    WebDriver _driver;
    public WebDriverWait wait;
    BasePage(WebDriver driver){
        _driver = driver;
        PageFactory.initElements(_driver, this);
        wait = new WebDriverWait(_driver, 10);
    }

    void setTextIntoElement(WebElement element, String text){
        element.click();
        element.sendKeys(text);
    }

    String getTextFromElement(WebElement element){
        return element.getText();
    }

    boolean getElement(WebElement element){
        return element.isDisplayed();
    }
}
