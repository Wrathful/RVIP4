import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AfterAuthPage extends BasePage {

    @FindBy(id = "adminmainlogoutbutton-btnIconEl")
    private WebElement _afterLoginField;

    AfterAuthPage(WebDriver driver){
        super(driver);
    }

    public boolean getAfterLoginText(){
        wait.until(x -> x.findElements(By.id("adminmainlogoutbutton-btnIconEl")).size() > 0);
        return getElement(_afterLoginField);
    }
}
