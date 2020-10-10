package Test3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ToothbrushesAndAccessoriesPage
{
    private WebDriver driver;
    public ToothbrushesAndAccessoriesPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void initValues()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean goToToothbrushesPage()
    {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        for(int i = 0; i < links.size(); i++)
        {
            WebElement t = links.get(i);
            if(t.getText().equals("Зубные щетки"))
            {
                System.out.print(i);
                t.click();
                return true;
            }
        }
        return false;
    }
}
