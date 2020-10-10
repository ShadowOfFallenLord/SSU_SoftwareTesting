package Test3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToothbrushesPage
{
    private WebDriver driver;
    public ToothbrushesPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void initValues()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "add_to_cart")
    private WebElement to_cart_button;

    public void clickAttToCart()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("add_to_cart")));

        to_cart_button.click();
    }
}
