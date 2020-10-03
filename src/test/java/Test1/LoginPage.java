package Test1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage
{
    private WebDriver driver;
    public LoginPage(WebDriver diver)
    {
        this.driver = diver;
    }

    @FindBy(id = "login_form_show_js")
    private WebElement login_container;

    @FindBy(id = "login")
    private WebElement login_element;

    @FindBy(id = "pass")
    private WebElement pass_element;

    public void initValues()
    {
        PageFactory.initElements(driver, this);
    }

    public void openContainer()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_form_show_js")));
        login_container.click();
    }

    public void inputLogin(String login)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login")));
        login_element.sendKeys(login);
    }

    public  void inputPass(String pass)
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass")));
        pass_element.sendKeys(pass);
    }

    public void submit()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass")));
        pass_element.submit();
    }
}

