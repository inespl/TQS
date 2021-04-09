import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import static org.junit.jupiter.api.Assertions.*;

class SampleTest {

    WebDriver browser;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        System.setProperty("geckodriver", "/usr/local/bin");
        browser = new FirefoxDriver();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        browser.close();
    }

    @Test
    void sampleTest(){
        browser.get("https://www.saucelabs.com");
        WebElement href = browser.findElement(By.xpath("//a[@href='https://accounts.saucelabs.com/']"));
        assertTrue((href.isDisplayed()));
    }

    @Test
    void blazeDemoTest(){
    }
}
