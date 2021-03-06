package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ConfirmationPage extends BasePage {
    public ConfirmationPage(WebDriver driver) {
        super(driver);
    }

    //TODO the back part of the URL is being duplicated and can probably be extracted into
    //a property that keeps track of checkout-step-two.html
    public void visit() {
        driver.navigate().to(baseUrl + "/checkout-step-two.html");
    }

    public void setPageState() {
        //TODO what are you going to do with the JS executor duplication
        ((JavascriptExecutor) driver).executeScript("window.sessionStorage.setItem('standard-username', 'standard-user')");
        ((JavascriptExecutor) driver).executeScript("window.sessionStorage.setItem('cart-contents', '[4,1]')");
        driver.navigate().refresh();
    }

    public Boolean hasItems() {
        String cartBadge = "shopping_cart_badge";
        return Integer.parseInt(driver.findElement(By.className(cartBadge)).getText()) > 0;
    }

    public CheckoutCompletePage finishCheckout() {
        String finishedCheckoutLocator = ".btn_action.cart_button";
        WebElement finishButton = driver.findElement(By.cssSelector(finishedCheckoutLocator));
        finishButton.click();
        return new CheckoutCompletePage(driver);
    }

    public boolean isLoaded() {
        return pageWait.until(ExpectedConditions.urlContains("checkout-step-two.html"));
    }
}
