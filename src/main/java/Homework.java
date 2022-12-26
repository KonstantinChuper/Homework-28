
import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;
public class Homework {
    private WebDriver driver;
    String url = "https://www.saucedemo.com/";
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void sauce1() {
        driver.get(url);
        driver.manage().window().setSize(new Dimension(1536, 842));
        driver.findElement(By.cssSelector("*[data-test=\"username\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys("standard_user");
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).click();
        driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("secret_sauce");
        driver.findElement(By.cssSelector("*[data-test=\"login-button\"]")).click();
        driver.findElement(By.id("react-burger-menu-btn")).click();
        WebDriverWait mywait =new WebDriverWait(driver,40);
        WebElement ele=mywait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"logout_sidebar_link\"]")));
        ele.click();
        assertEquals(driver.getCurrentUrl(), url);

    }

        @Test
        public void sauce2(){
            driver.get(url);
            driver.manage().window().setSize(new Dimension(1536, 842));
            driver.findElement(By.cssSelector("*[data-test=\"username\"]")).sendKeys("standard_user");
            driver.findElement(By.cssSelector("*[data-test=\"password\"]")).sendKeys("secret_sauce");
            driver.findElement(By.cssSelector("*[data-test=\"login-button\"]")).click();
            driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
            driver.findElement(By.className("shopping_cart_link")).click();
            driver.findElement(By.id("checkout")).click();
            driver.findElement(By.id("first-name")).sendKeys("Ivan");
            driver.findElement(By.id("last-name")).sendKeys("Ivanov");
            driver.findElement(By.id("postal-code")).sendKeys("61080");
            driver.findElement(By.id("continue")).click();
            driver.findElement(By.id("finish")).click();
            assertEquals(driver.findElement(By.className("complete-header")).getText(), "THANK YOU FOR YOUR ORDER");
            assertEquals(driver.findElement(By.className("complete-text")).getText(), "Your order has been dispatched, and will arrive just as fast as the pony can get there!");
    }
    }


