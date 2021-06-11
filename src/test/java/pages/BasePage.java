package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    /**
     * Can be accessed from any class any package within Framework
     * Can not be modified, a constant
     */
    public final WebDriver driver;

    public String baseUrl;
    public WebDriverWait pageWait;

    /**
     * Creating constructor and passing WebDriver
     * The passed WebDriver will be assigned to Class member WebDriver
     * Same Class member WebDriver can be used throughout the class
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        pageWait = new WebDriverWait(this.driver, 10);
        baseUrl = "https://www.saucedemo.com";
    }
}
