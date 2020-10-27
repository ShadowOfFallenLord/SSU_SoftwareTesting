package Test2;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChangeCityTest
{
    private static String baseCity = "Саратов";

    public static StartPage startPage;
    public static WebDriver driver;

    @BeforeClass
    public static void InitValues()
    {
        System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.citilink.ru/");
        startPage = new StartPage(driver);
    }

    @AfterClass
    public static void Exit()
    {
        startPage.clickChouseCityButton();
        startPage.clickCityButton(baseCity);
        driver.quit();
    }

    @Test
    public void Test()
    {
        startPage.initValues();

        startPage.clickChouseCityButton();
        // Хвалынска в списке нет
        startPage.clickCityButton("Киров");

        String city = startPage.getChouseCityButtonText();
        Assert.assertEquals("Киров", city);
    }
}
