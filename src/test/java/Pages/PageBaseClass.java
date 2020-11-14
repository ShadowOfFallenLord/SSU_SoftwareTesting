package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageBaseClass
{
    protected WebDriver driver;
    public PageBaseClass(WebDriver diver)
    {
        this.driver = diver;
    }

    public void initValues()
    {
        PageFactory.initElements(driver, this);
    }
}
