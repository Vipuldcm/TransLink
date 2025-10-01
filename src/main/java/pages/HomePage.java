package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class HomePage extends Base{
    @FindBy(xpath = "//button[@aria-label = 'Subpages for Schedules and Maps page']")
    private WebElement scheduleDropdown;

    @FindBy(xpath = "//a[text() = 'Bus']")
    private WebElement busLocator;


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void navigateToBus() throws InterruptedException {
//    waitElementToBeVisible(driver,scheduleDropdown);
        waitForPageLoad();
    waitElementToBeClickable(scheduleDropdown);
      hoverAction(driver, scheduleDropdown);
      busLocator.click();
    }

}
