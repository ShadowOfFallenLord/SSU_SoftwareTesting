package Tests;

import Configs.TestsConfiguration;
import Pages.*;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_3_Toothbrushes
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
    public BeautyAndHealthPage beautyAndHealthPage = new BeautyAndHealthPage(driver);
    public ToothbrushesAndAccessoriesPage toothbrushesAndAccessoriesPage = new ToothbrushesAndAccessoriesPage(driver);
    public ToothbrushesPage toothbrushesPage = new ToothbrushesPage(driver);
    public CartPage cartPage = new CartPage(driver);

    @Before
    public void InitValues()
    {
        driver.get(TestsConfiguration.testSiteUrl);
        indexPage.initValues();
        indexPage.openOldSiteVersion();
    }

    @Test
    public void Test() throws InterruptedException
    {
        indexPage.initValues();
        indexPage.goToBeautyAndHealthPage();
        beautyAndHealthPage.initValues();
        beautyAndHealthPage.goToToothbrushesAndAccessoriesPage();
        toothbrushesAndAccessoriesPage.initValues();
        toothbrushesAndAccessoriesPage.goToToothbrushesPage();

        //driver.get("https://www.citilink.ru/catalog/beauty_and_health/toothbrushes_and_aks/toothbrushes/");

        toothbrushesPage.initValues();
        toothbrushesPage.setMinPrice(999);
        Thread.sleep(1);
        toothbrushesPage.setMaxPrice(1999);

        Thread.sleep(1000);

        toothbrushesPage.initValues();
        Integer expected = toothbrushesPage.getRecordPrice() * 2;

        toothbrushesPage.setProductCount(2);
        toothbrushesPage.clickAddToCart();
        toothbrushesPage.initValues();
        toothbrushesPage.closeSwimmingWindow();

        toothbrushesPage.initValues();
        Integer actual = toothbrushesPage.getCartPrice();

        Assert.assertEquals(expected, actual);
    }

    @After
    public void Exit()
    {
        toothbrushesPage.openCartPage();
        cartPage.initValues();
        cartPage.clearCart();
    }
}
