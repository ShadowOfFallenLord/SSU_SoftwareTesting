package Tests;

import Configs.TestsConfiguration;
import Pages.IndexPage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_1_Login
{
    public static IndexPage indexPage;
    public static WebDriver driver;

    private static String login = "dfhrhfan12@yandex.ru";
    private static String password = "159875321";

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
        driver.quit();
    }

    @Test
    public void Test() throws InterruptedException
    {
        indexPage.initValues();
        indexPage.openOldSiteVersion();

        indexPage.initValues();
        indexPage.openLoginContainer();
        indexPage.inputLogin(login);
        indexPage.inputPass(password);

        WebElement captcha_elem = driver.findElement(By.id("captcha_popup-login"));
        captcha_elem.click();
        // Requires manual input of captcha on the site
        Thread.sleep(10000);

        indexPage.submitLoginAndPassowrd();
        Thread.sleep(1);

        indexPage.initValues();
        Thread.sleep(1);
        String name = indexPage.getAccountName();
        Thread.sleep(1);
        Assert.assertEquals("Алексей", name);

        indexPage.logoutAccount();
    }
}
