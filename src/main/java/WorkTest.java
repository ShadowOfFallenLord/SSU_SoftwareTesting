import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkTest
{
    public static void main(String[] args)
    {
        System.setProperty("webdriver.chrome.driver",
                "src\\test\\resources\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();


        driver.get("https://www.google.com/");

        WebElement search_string = driver.findElement(By.cssSelector(".gLFyf"));
        search_string.sendKeys("How to test web pages with Selenium?");
        search_string.submit();


        driver.quit();
    }
}
