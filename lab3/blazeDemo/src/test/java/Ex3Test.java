import io.github.bonigarcia.seljup.SeleniumJupiter;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.firefox.FirefoxDriver;

@ExtendWith(SeleniumJupiter.class)
class Ex3Test {

    FirefoxDriver driver;

    Ex3Test(FirefoxDriver driver){
        this.driver=driver;
    }

    @Test
    void testWithFirefox(FirefoxDriver firefoxDriver) {
        driver.get("https://bonigarcia.github.io/selenium-jupiter/");
        assertThat(driver.getTitle(), containsString("JUnit 5 extension for Selenium"));

    }

}