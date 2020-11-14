package Tests;

import Configs.TestsConfiguration;
import Pages.*;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_3_Toothbrushes
{
    public static WebDriver driver;
    public static IndexPage indexPage;
    public static BeautyAndHealthPage beautyAndHealthPage;
    public static ToothbrushesAndAccessoriesPage toothbrushesAndAccessoriesPage;
    public static ToothbrushesPage toothbrushesPage;
    public static CartPage cartPage;

    @BeforeClass
    public static void InitValues()
    {
        System.setProperty(TestsConfiguration.driverName, TestsConfiguration.driverPath);
        driver = new ChromeDriver();
        driver.get(TestsConfiguration.testSiteUrl);
        indexPage = new IndexPage(driver);
        beautyAndHealthPage = new BeautyAndHealthPage(driver);
        toothbrushesAndAccessoriesPage = new ToothbrushesAndAccessoriesPage(driver);
        toothbrushesPage = new ToothbrushesPage(driver);
        cartPage = new CartPage(driver);
    }

    @AfterClass
    public static void Exit() throws InterruptedException
    {
        toothbrushesPage.openCartPage();
        cartPage.initValues();
        cartPage.clearCart();

        driver.quit();
    }

    @Test
    public void Test() throws InterruptedException
    {
        indexPage.initValues();
        indexPage.openOldSiteVersion();

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
}
