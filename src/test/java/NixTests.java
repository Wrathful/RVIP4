import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import static org.testng.Assert.*;

public class NixTests {

    private WebDriver _driver;
    private WebDriverWait wait;
    Random rnd=new Random();
    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver\\chromedriver.exe");
        _driver = new ChromeDriver();
        _driver.manage().window().maximize();
        _driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(_driver, 10);
    }

    @Test(priority = 2)
    public void correctAuth(){
        _driver.get("http://localhost:5000");
        LoginPage loginPage = new LoginPage(_driver);
        User user = new User("admin", "123456");
        AfterAuthPage homeForumPage = loginPage.authWithCorrectData(user);
        assertTrue(homeForumPage.getAfterLoginText());
    }

    @Test(priority = 0)
    public void authWithIncorrectLogin() {
        _driver.get("http://localhost:5000");
        LoginPage loginPage = new LoginPage(_driver);
        User user = new User("admindsfs", "123456");
        ErrorLoginPage errorLoginPage = loginPage.authWithIncorrectData(user);
        assertTrue( errorLoginPage.isExist());
    }

    @Test(priority = 1)
    public void authWithIncorrectPassword() {
        _driver.get("http://localhost:5000");
        LoginPage loginPage = new LoginPage(_driver);
        User user = new User("admin", "adsa");
        ErrorLoginPage errorLoginPage = loginPage.authWithIncorrectData(user);
        assertTrue(errorLoginPage.isExist());
    }

    @Test(priority = 3)
    public void addFaculty() {
        _driver.get("http://localhost:5000/#faculty");
        FacultyPage facyltyPage = new FacultyPage(_driver);
        assertTrue(facyltyPage.setText(String.valueOf(rnd.nextLong()),String.valueOf(rnd.nextLong())));
    }

    @Test(priority = 4)
    public void deleteFaculty() {
        _driver.get("http://localhost:5000/#faculty");
        FacultyPage facyltyPage = new FacultyPage(_driver);
        assertTrue(facyltyPage.delete());
    }

    @Test(priority = 5)
    public void editFaculty() {
        _driver.get("http://localhost:5000/#faculty");
        FacultyPage facyltyPage = new FacultyPage(_driver);
        assertTrue(facyltyPage.edit(String.valueOf(rnd.nextLong())));
    }


    @AfterTest
    public void quit() {
        _driver.quit();
    }
}