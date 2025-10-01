package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FavoritesPage extends  Base{


    @FindBy(xpath = "//input[@form = 'addGTFSFavourite']")
    private WebElement favoriteTextBox;

    @FindBy(xpath = "//button[@form = 'addGTFSFavourite']")
    private  WebElement favoriteButton;

    public FavoritesPage(WebDriver driver) {
        super(driver);
    }

    public void enterFavoriteName(String fName)
    {
        waitElementToBeClickable(favoriteTextBox);
        favoriteTextBox.click();
        favoriteTextBox.clear();
        favoriteTextBox.sendKeys(fName);
    }
    public void clickFavoriteButton() {
        waitElementToBeClickable(favoriteButton);
        favoriteButton.click();
    }


}
