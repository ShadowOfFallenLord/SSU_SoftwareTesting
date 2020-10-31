package Test2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class StartPage
{
    private WebDriver driver;
    public StartPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void initValues()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".pseudo_dashed")
    private WebElement chouse_city_button;

    private WebElement city;

    public void clickChouseCityButton()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pseudo_dashed")));
        chouse_city_button.click();
    }

    public String getChouseCityButtonText()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".pseudo_dashed")));
        return chouse_city_button.getText();
    }

    public void clickCityButton(String city_name)
    {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText(city_name)));
        city = driver.findElement(By.partialLinkText(city_name));
        city.click();
    }
}
