package Tests;

import Configs.RuleOnFail;
import Configs.TestsConfiguration;
import Pages.IndexPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test_1_Login
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

    private String login = "dfhrhfan12@yandex.ru";
    private String password = "159875321";
    private String expectedName = "Алексей";

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
        indexPage.openLoginContainer();
        indexPage.initValues();
        indexPage.inputLogin(login);
        indexPage.initValues();
        indexPage.inputPass(password);

        // Requires manual input of captcha on the site
        Thread.sleep(10000);

        indexPage.submitLoginAndPassowrd();
        Thread.sleep(1);

        indexPage.initValues();
        Thread.sleep(1);
        String name = indexPage.getAccountName();
        Thread.sleep(1);
        Assert.assertEquals(expectedName, name);
    }

    @After
    public void Logout()
    {
        indexPage.initValues();
        indexPage.logoutAccount();
    }
}
