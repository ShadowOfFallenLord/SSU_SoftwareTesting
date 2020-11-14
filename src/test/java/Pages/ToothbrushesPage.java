package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToothbrushesPage extends PageBaseClass
{
    public ToothbrushesPage(WebDriver diver)
    {
        super(diver);
    }

    private void clearInputField(WebElement element)
    {
        element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }

    //region Min_Max_Price
    @FindBy(className = "min-input_js")
    private WebElement min_price_input;

    @FindBy(className = "max-input_js")
    private WebElement max_price_input;

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
    //endregion

    //region Record
    @FindBy(className = "subcategory-product-item__price-num")
    private WebElement record_price;

    @FindBy(className = "product_amount_control")
    private WebElement product_count;

    @FindBy(className = "add_to_cart")
    private WebElement to_cart_button;

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
    //endregion

    //region SwimmingWindow
    @FindBy(className = "js--popup-basket__close-btn")
    private WebElement close_swimming_window;

    public void closeSwimmingWindow()
    {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("js--popup-basket__close-btn")));

        close_swimming_window.click();
    }
    //endregion

    //region Cart
    @FindBy(id = "header_basket_cost")
    private WebElement cart_price;

    @FindBy(className = "cart")
    private WebElement cart;

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
    //endregion
}
