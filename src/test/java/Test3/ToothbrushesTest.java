package Test3;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ToothbrushesTest
{
    public static StartPage startPage;
    public static BeautyAndHealthPage beautyAndHealthPage;
    public static ToothbrushesAndAccessoriesPage toothbrushesAndAccessoriesPage;
    public static ToothbrushesPage toothbrushesPage;
    public static WebDriver driver;

    @BeforeClass
    public static void InitValues()
    {
        System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.citilink.ru/");
        startPage = new StartPage(driver);
        beautyAndHealthPage = new BeautyAndHealthPage(driver);
        toothbrushesAndAccessoriesPage = new ToothbrushesAndAccessoriesPage(driver);
        toothbrushesPage = new ToothbrushesPage(driver);
    }

    @AfterClass
    public static void Exit()
    {
        driver.quit();
    }

    @Test
    public void Test() throws InterruptedException
    {
        Assert.assertTrue(startPage.goToBeautyAndHealthPage());
        Assert.assertTrue(beautyAndHealthPage.goToToothbrushesAndAccessoriesPage());
        Assert.assertTrue(toothbrushesAndAccessoriesPage.goToToothbrushesPage());
        toothbrushesPage.initValues();
        toothbrushesPage.clickAttToCart();

        Thread.sleep(1000);

        //Assert.assertEquals("Киров", "Киров");
    }
}
