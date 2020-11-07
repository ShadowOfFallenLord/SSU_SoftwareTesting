package Test1;


import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginTest
{
    public static LoginPage loginPage;
    public static ProfilePage profilePage;
    public static WebDriver driver;

    @BeforeClass
    public static void InitValues()
    {
        System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.citilink.ru/");
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
    }

    @AfterClass
    public static void Exit()
    {
        driver.quit();
    }

    @Test
    public void Test() throws InterruptedException
    {
        loginPage.initValues();
        loginPage.openContainer();
        Thread.sleep(1);
        loginPage.inputLogin("dfhrhfan12@yandex.ru");
        Thread.sleep(1);
        loginPage.inputPass("159875321");
        Thread.sleep(1);

        WebElement captcha_elem = driver.findElement(By.id("captcha_popup-login"));
        captcha_elem.click();
        // Requires manual input of captcha on the site
        Thread.sleep(10000);

        loginPage.submit();
        Thread.sleep(1);

        profilePage.initValues();
        Thread.sleep(1);
        String name = profilePage.getName();
        Thread.sleep(1);
        Assert.assertEquals("Алексей", name);

        profilePage.logout();
    }
}
