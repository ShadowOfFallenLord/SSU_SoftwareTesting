package Test3;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToothbrushesAndAccessoriesPage
{
    private WebDriver driver;
    public ToothbrushesAndAccessoriesPage(WebDriver driver)
    {
        this.driver = driver;
    }

    private WebElement button;

    public void initValues()
    {
        PageFactory.initElements(driver, this);
    }

    public void goToToothbrushesPage()
    {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Зубные щетки")));
        button = driver.findElement(By.partialLinkText("Зубные щетки"));
        button.click();
    }
}
