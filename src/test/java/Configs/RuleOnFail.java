package Configs;

import io.qameta.allure.Attachment;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class RuleOnFail extends TestWatcher
{
    public static WebDriver driver;

    public RuleOnFail(WebDriver driver)
    {
        this.driver = driver;
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    protected byte[] saveAllureScreenshot()
    {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    protected void failed(Throwable e, Description description) {
        System.out.print("Test fails: ");
        System.out.println(description);

        saveAllureScreenshot();
    }
}
