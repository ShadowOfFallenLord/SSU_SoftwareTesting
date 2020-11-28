package Pages;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.File;

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

//    public void makeScreenshot()
//    {
//        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//        String path = "./target/screenshots/" + screenshot.getName();
//        FileUtils.copyFile(screenshot, new File(path));
//    }
}
