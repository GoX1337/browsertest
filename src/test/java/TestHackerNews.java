import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@TestInstance(Lifecycle.PER_CLASS)
public class TestHackerNews {

    WebDriver driver;

    @BeforeAll
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", ".\\src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void findElementbyXpath() throws InterruptedException {
        driver.get("https://news.ycombinator.com");
        driver.findElement(By.xpath("//a[@href='ask']")).click();
        assertNotEquals(driver.findElements(By.className("storylink")).size(), 0);
        List<WebElement> elements = driver.findElements(By.className("storylink"));
        for (WebElement e : elements){
            System.out.println(e .getText());
        }
        Thread.sleep(3000);
    }

    @AfterAll
    public void doThis(){
        driver.quit();
    }
}