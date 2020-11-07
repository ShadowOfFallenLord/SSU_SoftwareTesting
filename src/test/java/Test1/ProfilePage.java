package Test1;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProfilePage
{
    private WebDriver driver;
    public ProfilePage(WebDriver diver)
    {
        this.driver = diver;
    }

    @FindBy(xpath = "/html/body/div[2]/div[1]/header/div/div[2]/div/div[3]/div/span/span")
    private WebElement name_element;

    @FindBy(xpath = "/html/body/div[2]/div[1]/header/div/div[2]/div/div[3]/div/div/div/ul/li[7]/a/span[1]")
    private WebElement out_element;

    public void initValues()
    {
        PageFactory.initElements(driver, this);
    }

    public String getName()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/header/div/div[2]/div/div[3]/div/span/span")));
        String userName = name_element.getText();
        return userName;
    }

    public void logout()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/header/div/div[2]/div/div[3]/div/span/span")));
        name_element.click();
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/header/div/div[2]/div/div[3]/div/div/div/ul/li[7]/a/span[1]")));
        out_element.click();
    }
}
