package Tests;

import Configs.TestsConfiguration;
import Pages.IndexPage;
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
public class Test_2_City
{
    public static IndexPage indexPage;
    public static WebDriver driver;

    private static String baseCity = "Саратов";
    private String city;

    public Test_2_City(String city)
    {
        this.city = city;
    }

    @BeforeClass
    public static void InitValues()
    {
        System.setProperty(TestsConfiguration.driverName, TestsConfiguration.driverPath);
        driver = new ChromeDriver();
        driver.get(TestsConfiguration.testSiteUrl);
        indexPage = new IndexPage(driver);
    }

    @AfterClass
    public static void Exit()
    {
        indexPage.clickChouseCityButton();
        indexPage.clickCityButton(baseCity);
        driver.quit();
    }

    @Parameterized.Parameters
    public static Collection<Object[]> GetParams()
    {
        return Arrays.asList(new Object[][]{
                { "Киров" },
//                { "Сочи" },
//                { "Азов" },
//                { "Белгород" },
//                { "Челябинск" }
        });
    }

    @Test
    public void Test()
    {
        indexPage.initValues();
        indexPage.openOldSiteVersion();

        indexPage.initValues();
        indexPage.clickChouseCityButton();
        indexPage.clickCityButton(city);

        String current_city = indexPage.getChouseCityButtonText();
        Assert.assertEquals(city, current_city);
    }
}
