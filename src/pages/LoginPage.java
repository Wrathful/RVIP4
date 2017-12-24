import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "loginfield-inputEl")
    private WebElement _loginTextField;

    @FindBy(id = "passwordfield-inputEl")
    private WebElement _passwordTextField;

    @FindBy(id = "submitlogin-btnInnerEl")
    private WebElement _loginButton;

    LoginPage(WebDriver driver){
        super(driver);
    }

    public AfterAuthPage authWithCorrectData(User user){
        auth(user);
        return new AfterAuthPage(_driver);
    }

    public ErrorLoginPage authWithIncorrectData(User user){
        auth(user);
        return new ErrorLoginPage(_driver);
    }

    private void auth(User user){
        setTextIntoElement(_loginTextField, user.getLogin());
        setTextIntoElement(_passwordTextField, user.getPassword());
        _loginButton.click();
    }
}
