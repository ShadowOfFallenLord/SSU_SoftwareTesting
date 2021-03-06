package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends PageBaseClass
{
    public CartPage(WebDriver diver)
    {
        super(diver);
    }

    @FindBy(className = "remove_all")
    private WebElement remove_button;

    public void clearCart()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("remove_all")));

        remove_button.click();
    }
}
