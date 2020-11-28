package Tests;

import Configs.RuleOnFail;
import Configs.TestsConfiguration;
import Pages.IndexPage;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class Test_2_City
{
    //region Driver
    public static WebDriver driver;

    @BeforeClass
    public static void InitProperties()
    {
        System.setProperty(TestsConfiguration.driverName, TestsConfiguration.driverPath);
        driver = new ChromeDriver();
    }

    @AfterClass
    public static void ExitDriver()
    {
        driver.quit();
    }
    //endregion

    public IndexPage indexPage = new IndexPage(driver);

    @Rule
    public RuleOnFail watchman= new RuleOnFail(driver);

    private String baseCity = "Саратов";
    private String city;

    public Test_2_City(String city)
    {
        this.city = city;
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

    @Before
    public void InitValues()
    {
        driver.get(TestsConfiguration.testSiteUrl);
        indexPage.initValues();
        indexPage.openOldSiteVersion();
    }

    @Test
    public void Test()
    {
        indexPage.initValues();
        indexPage.clickChouseCityButton();
        indexPage.clickCityButton(city);

        String current_city = indexPage.getChouseCityButtonText();
        Assert.assertEquals(city, current_city);
    }

    @After
    public void ResetCity()
    {
        indexPage.clickChouseCityButton();
        indexPage.clickCityButton(baseCity);
    }
}
