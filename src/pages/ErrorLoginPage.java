import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class ErrorLoginPage extends LoginPage {

    @FindBy(className = "x-message-box")
    private WebElement _errorTextField;

    ErrorLoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isExist(){
        wait.until(x -> x.findElements(By.className("x-message-box")).size() > 0);
        return getElement(_errorTextField);
    }

    public String getErrorText(){
        return getTextFromElement(_errorTextField);
    }

}
