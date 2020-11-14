package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToothbrushesAndAccessoriesPage extends PageBaseClass
{
    public ToothbrushesAndAccessoriesPage(WebDriver diver)
    {
        super(diver);
    }

    @FindBy(partialLinkText = "Зубные щетки")
    private WebElement toothbrushesButton;

    public void goToToothbrushesPage()
    {
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Зубные щетки")));
        toothbrushesButton.click();
    }
}
