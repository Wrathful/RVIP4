import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FacultyPage extends BasePage{

    @FindBy(id = "facultynameeditor-inputEl")
    WebElement firstCell;
    @FindBy(id = "facultyshortnameeditor-inputEl")
    WebElement secondCell;
    @FindBy(id = "addfacultybutton-btnIconEl")
    WebElement button;
    @FindBy(className = "x-btn-inner-default-toolbar-small")
    WebElement buttonSave;
    @FindBy(className = "fa-close")
    WebElement buttonDelete;

    @FindBy(className = "faculty-name-column")
    WebElement editCell;
    @FindBy(id = "facultynameeditor-inputEl")
    WebElement inputCell;

    public WebElement getFirstCell() {
        return firstCell;
    }
    public WebElement getSecondCell() {
        return secondCell;
    }
    public WebElement getButton() {
        return button;
    }

    public boolean setText(String firstCellText,String secondCellText){
        button.click();
        wait.until(x -> x.findElements(By.id("facultyshortnameeditor-inputEl")).size() > 0);
        setTextIntoElement(firstCell, firstCellText);
        setTextIntoElement(secondCell, secondCellText);
        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        wait.until(x -> x.findElements(By.className("div.x-grid-row-editor-buttons button")).size() > 0);
        buttonSave.click();
        wait.until(x -> !x.findElements(By.className("faculty-id-column")).get(0).getText().equals("-1000000"));
        return !(_driver.findElements(By.className("faculty-id-column")).get(0).getText().equals("-1000000"));
    }
    public boolean edit(String str){
        wait.until(x -> x.findElements(By.className("fa-close")).size() > 0);
        Actions action = new Actions(_driver);
        String bilo=editCell.getText();
        action.moveToElement(editCell).doubleClick().build().perform();
        wait.until(x -> x.findElements(By.id("facultynameeditor-inputEl")).size() > 0);
        inputCell.clear();
        inputCell.sendKeys(str);
        buttonSave.click();
        return !editCell.getText().equals(bilo);
    }
    public boolean delete(){
        wait.until(x -> x.findElements(By.className("fa-close")).size() > 0);
        int bilo=_driver.findElements(By.className("fa-close")).size();
        buttonDelete.click();
        wait.until(x -> x.findElements(By.className("x-btn-inner-default-small")).size() > 0);
        List<WebElement> lst=_driver.findElements(By.className("x-btn-inner-default-small"));
        for(int i=0;i<lst.size();i++){
           if(lst.get(i).getText().equals("Да"))
           {
               lst.get(i).click();
               break;
           }
        }
//        buttonapproveDelete.click();
        _driver.get("http://localhost:5000/#faculty");
        wait.until(x -> x.findElements(By.className("fa-close")).size() > 0);
        int stalo=_driver.findElements(By.className("fa-close")).size();
        return bilo>stalo;
    }

    FacultyPage(WebDriver driver){
        super(driver);
    }
}
