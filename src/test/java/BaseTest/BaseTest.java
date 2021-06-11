package BaseTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;


public class BaseTest {
    /**
     * //Can be accessed from any class any package within Framework
     */
    protected WebDriver driver;
    //TODO: Integrate Saucelabs
//    @BeforeMethod
//    public void setup(Method method) throws MalformedURLException {
////        String sauceUsername = System.getenv("SAUCE_USERNAME");
////        String sauceAccessKey = System.getenv("SAUCE_ACCESS_KEY");
//        String sauceUsername = "avishekbehera";
//        String sauceAccessKey = "7d90bbcae6464e118f4049754c1a72cb";
//
//        ChromeOptions chromeOpts = new ChromeOptions();
//        chromeOpts.setCapability(CapabilityType.PLATFORM_NAME, "windows 10");
//        chromeOpts.setCapability(CapabilityType.BROWSER_VERSION, "latest");
//
//        MutableCapabilities sauceOpts = new MutableCapabilities();
//        sauceOpts.setCapability("username", sauceUsername);
//        sauceOpts.setCapability("accessKey", sauceAccessKey);
//        sauceOpts.setCapability("name", method.getName());
//        sauceOpts.setCapability("build", "best-practices");
//        sauceOpts.setCapability("tags", "['best-practices', 'best-practices']");
//
//        MutableCapabilities capabilities = new MutableCapabilities();
//        capabilities.setCapability(ChromeOptions.CAPABILITY, chromeOpts);
//        capabilities.setCapability("sauce:options", sauceOpts);
//        // TODO: Get it from properties
//        String sauceUrl = "https://ondemand.saucelabs.com/wd/hub";
//        URL url = new URL(sauceUrl);
//        driver = new RemoteWebDriver(url, capabilities);
//    }

    /**
     * Using  WebDriver Manager
     */
    @BeforeMethod
    public void setup(Method method){
        System.setProperty("webdriver.chrome.silentOutput", "true");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--disable-gpu");
//        options.addArguments("window-size=1920,1080");
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        driver = new ChromeDriver(options);
        System.out.println("Test Method:"+method.getName());
    }

    @AfterMethod
    public void teardown() {
//        ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + (result.equals("testSuccessful") ? "passed" : "failed"));
        driver.quit();
    }
}

