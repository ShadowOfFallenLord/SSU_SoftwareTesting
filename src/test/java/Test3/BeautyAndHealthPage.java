package Test3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

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
        /*
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for(int i = 0; i < links.size(); i++)
        {
            WebElement t = links.get(i);
            if(t.getText().equals("Зубные щетки и аксессуары"))
            {
                System.out.print(i);
                t.click();
                return true;
            }
        }
        return false;
        */

        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Зубные щетки и аксессуары")));
        button = driver.findElement(By.partialLinkText("Зубные щетки и аксессуары"));
        button.click();
    }
}
