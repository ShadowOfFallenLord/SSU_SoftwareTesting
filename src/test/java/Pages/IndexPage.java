package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class IndexPage extends PageBaseClass
{
    public IndexPage(WebDriver diver)
    {
        super(diver);
    }

    //region NewToOldSiteVersion
    @FindBy(className = "SiteVersionSwitcher__button")
    private WebElement old_site_version_button;

    public void openOldSiteVersion()
    {
        try
        {
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("SiteVersionSwitcher__button")));
            old_site_version_button.click();
            Thread.sleep(100);
        }
        catch (Exception e)
        {
            //
        }
    }
    //endregion

    //region Test_1
    //region Login
    @FindBy(id = "login_form_show_js")
    private WebElement login_container;

    @FindBy(id = "login")
    private WebElement login_element;

    @FindBy(id = "pass")
    private WebElement pass_element;

    public void openLoginContainer()
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

    public void submitLoginAndPassowrd()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("pass")));
        pass_element.submit();
    }
    //endregion

    //region AccountLogout
    @FindBy(className = "auth-user-popup__text")
    private WebElement account_name_element;

    @FindBy(className = "auth-user-popup__exit-line")
    private WebElement out_element;

    public String getAccountName()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("auth-user-popup__text")));
        String userName = account_name_element.getText();
        return userName;
    }

    public void logoutAccount()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("auth-user-popup__text")));
        account_name_element.click();
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("auth-user-popup__exit-line")));
        out_element.click();
    }
    //endregion
    //endregion

    //region Test_2
    @FindBy(css = ".pseudo_dashed")
    private WebElement choose_city_button;

    private WebElement current_city;

    public void clickChouseCityButton()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pseudo_dashed")));
        choose_city_button.click();
    }

    public String getChouseCityButtonText()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pseudo_dashed")));
        return choose_city_button.getText();
    }

    public void clickCityButton(String city_name)
    {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(city_name)));
        current_city = driver.findElement(By.partialLinkText(city_name));
        current_city.click();
    }
    //endregion

    //region Test_3
    @FindBy(partialLinkText = "Красота и здоровье")
    private WebElement beautyAndHealthButton;

    public void goToBeautyAndHealthPage()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Красота и здоровье")));
        beautyAndHealthButton.click();
    }
    //endregion
}
