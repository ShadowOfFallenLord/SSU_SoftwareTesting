package Test3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BeautyAndHealthPage
{
    private WebDriver driver;
    public BeautyAndHealthPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void initValues()
    {
        PageFactory.initElements(driver, this);
    }

    public boolean goToToothbrushesAndAccessoriesPage()
    {
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
    }
}
