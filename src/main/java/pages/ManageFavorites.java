package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageFavorites extends  Base{


    @FindBy(xpath = "//a[@class='verticallyCenteredItem']")
    private WebElement manageFavorites;

    public ManageFavorites(WebDriver driver) {
        super(driver);
    }

    public String getFavoriteText()
    {
        waitForPageLoad();
        return  manageFavorites.getText();
    }

}
