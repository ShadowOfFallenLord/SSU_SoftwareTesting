package Test3;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BeautyAndHealthPage
{
    private WebDriver driver;
    public BeautyAndHealthPage(WebDriver driver)
    {
        this.driver = driver;
    }

    private WebElement button;

    public void initValues()
    {
        PageFactory.initElements(driver, this);
    }

    public void goToToothbrushesAndAccessoriesPage()
    {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Зубные щетки и аксессуары")));
        button = driver.findElement(By.partialLinkText("Зубные щетки и аксессуары"));
        button.click();
    }
}
