package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class Base {
    protected WebDriver driver;
    protected  WebDriverWait wait;

    public Base(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver,
                Duration.of(20, ChronoUnit.SECONDS));
        PageFactory.initElements(driver, this);
    }

    public void waitElementToBeVisible( WebElement visible) {
        wait.until(ExpectedConditions.visibilityOf(visible));
    }
    public void waitForPageLoad(){
        wait.until(webDriver -> ((JavascriptExecutor)webDriver).executeScript("return document.readyState").equals("complete"));
    }

    public void waitElementToBeClickable( WebElement clickable) {
        wait.until(ExpectedConditions.elementToBeClickable(clickable));
    }
    public void waitForVisibilityOfAllElementToBeClickable( List<WebElement> clickable) {
        wait.until(ExpectedConditions.visibilityOfAllElements(clickable));
    }

    public static void hoverAction(WebDriver driver, WebElement source) {
        Actions act = new Actions(driver);
        act.moveToElement(source).perform();

    }

    public WebElement searchAndScrollElement(String text, List<WebElement> elements) throws InterruptedException {
        for (WebElement el : elements) {

            if (el.getText().replaceAll("[^a-bA-Z0-9]", "").contains(text.replaceAll("[^a-bA-Z0-9]", ""))){
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", el);
                Thread.sleep(2000);
                waitElementToBeClickable(el);
                return el;
            }
        }
        return null;
    }
}