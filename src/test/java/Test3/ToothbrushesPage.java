package Test3;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToothbrushesPage
{
    private WebDriver driver;
    public ToothbrushesPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void initValues()
    {
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "min-input_js")
    private WebElement min_price_input;

    @FindBy(className = "max-input_js")
    private WebElement max_price_input;

    @FindBy(className = "subcategory-product-item__price-num")
    private WebElement record_price;

    @FindBy(className = "product_amount_control")
    private WebElement product_count;

    @FindBy(className = "add_to_cart")
    private WebElement to_cart_button;

    @FindBy(className = "js--popup-basket__close-btn")
    private WebElement close_swimming_window;

    @FindBy(id = "header_basket_cost")
    private WebElement cart_price;

    @FindBy(className = "cart")
    private WebElement cart;

    private void clearInputField(WebElement element)
    {
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }

    public void setMinPrice(int val) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("min-input_js")));

        clearInputField(min_price_input);
        min_price_input.sendKeys(Integer.toString(val));
    }

    public void setMaxPrice(int val) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("max-input_js")));

        clearInputField(max_price_input);
        max_price_input.sendKeys(Integer.toString(val));
        max_price_input.sendKeys(Keys.ENTER);
    }

    public Integer getRecordPrice()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("subcategory-product-item__price-num")));

        return Integer.parseInt(record_price.getText());
    }

    public void setProductCount(int val) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("product_amount_control")));

        clearInputField(product_count);
        product_count.sendKeys(Integer.toString(val));
    }

    public void clickAddToCart()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("add_to_cart")));

        to_cart_button.click();
    }

    public void closeSwimmingWindow()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("js--popup-basket__close-btn")));

        close_swimming_window.click();
    }

    public Integer getCartPrice()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("header_basket_cost")));

        return Integer.parseInt(cart_price.getText());
    }

    public void openCartPage()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("cart")));

        cart.click();
    }
}
