package Test2;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class ChangeCityTest
{
    private static String baseCity = "Саратов";
    private String city;

    public ChangeCityTest(String city)
    {
        this.city = city;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> GetParams()
    {
        return Arrays.asList(new Object[][]{
            { "Киров" },
            { "Сочи" },
            { "Азов" },
            { "Белгород" },
            { "Челябинск" }
        });
    }

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
        startPage.clickCityButton(city);

        String current_city = startPage.getChouseCityButtonText();
        Assert.assertEquals(city, current_city);
    }
}
