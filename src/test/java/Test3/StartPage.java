package Test3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

    private WebElement button;

    public void initValues()
    {
        PageFactory.initElements(driver, this);
    }

    public void goToBeautyAndHealthPage()
    {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Красота и здоровье")));
        button = driver.findElement(By.partialLinkText("Красота и здоровье"));
        button.click();
    }
}
