import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SearchTest {

    private WebDriver driver;

    @BeforeMethod
    public void setUp() {
        initializeWebDriver();
        openDemoStoreHomePage();
    }

    private void initializeWebDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver");
        driver = new ChromeDriver();
    }

    private void openDemoStoreHomePage() {
        driver.get("http://demo-store.seleniumacademy.com/");
    }

    private WebElement findElement(By by) {
        return driver.findElement(by);
    }

    private void waitForElementToBeClickable(By by) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    @Test
    public void testAddProductToCart() {
        checkCartIsEmpty();
        searchAndNavigateToProductDetails();
        addProductToCart();
        assertThat(getCartItemCount()).isEqualTo("1");
    }

    private void checkCartIsEmpty() {
        WebElement cartItems = findElement(By.cssSelector("div.header-minicart span.count"));
        assertThat(cartItems.getText()).isEqualTo("");
    }

    private void searchAndNavigateToProductDetails() {
        WebElement searchBox = findElement(By.name("q"));
        searchBox.sendKeys("bag");
        WebElement searchButton = findElement(By.className("search-button"));
        searchButton.click();
        waitForElementToBeClickable(By.cssSelector("div.actions a.button"));
        WebElement detailsButton = findElement(By.cssSelector("div.actions a.button"));
        detailsButton.click();
    }

    private void addProductToCart() {
        waitForElementToBeClickable(By.className("swatch-label"));
        WebElement color = findElement(By.cssSelector("span.swatch-label img"));
        color.click();
        Select dropdown = new Select(findElement(By.id("attribute190")));
        dropdown.selectByIndex(1);
        waitForElementToBeClickable(By.cssSelector("div.add-to-cart-buttons button"));
        WebElement addToCartBtn = findElement(By.cssSelector("div.add-to-cart-buttons button"));
        addToCartBtn.click();
    }

    private String getCartItemCount() {
        WebElement cartItems = findElement(By.cssSelector("div.header-minicart span.count"));
        return cartItems.getText();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
