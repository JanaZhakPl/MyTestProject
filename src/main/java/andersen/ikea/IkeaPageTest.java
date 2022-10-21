package andersen.ikea;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static java.lang.Thread.sleep;

public class IkeaPageTest {

    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        Initialization.setUp();
    }

    @AfterClass
    static public void tearDown() {
        driver.close();
    }

    @Test
    public void search() {

        driver.findElement(By.name("q")).sendKeys("regał");
        driver.findElement(By.id("search-box__searchbutton")).click();
        Assert.assertTrue(driver.findElement(By.className("search-summary__message")).isDisplayed());
    }

    @Test
    public void choose() {

        driver.navigate().to("https://www.ikea.com/pl/pl/cat/lozka-i-materace-bm001/");
        driver.findElement(By.partialLinkText("NEIDEN")).click();
        Assert.assertEquals(driver.getTitle(), "NEIDEN Rama łóżka, sosna, 90x200 cm - IKEA");
        // driver.close();
    }

    @Test
    public void add() throws InterruptedException {
        driver.navigate().to("https://www.ikea.com/pl/pl/cat/lozka-i-materace-bm001/");
        driver.findElement(By.partialLinkText("NEIDEN")).click();
        driver.findElement(By.xpath("//div[@class='pip-buy-module__buttons--left']//span[text()='Dodaj do koszyka']")).click();
        // driver.findElement(By.class
        sleep(2000);
        WebElement cartButton = driver.findElement(By.cssSelector("a[href*=shoppingcart]"));
    }
}


