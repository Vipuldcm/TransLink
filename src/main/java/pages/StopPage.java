package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class StopPage extends Base
 {
     @FindBy(xpath =  " //button[normalize-space()='Add to favourites']")
     private  WebElement addToFavoritesButton;


     @FindBy(xpath = "//a[normalize-space()='Manage my favourites']")
     private  WebElement manageFavoritesButton;

     public StopPage(WebDriver driver) {
         super(driver);
     }

     public void clickFavorites() throws InterruptedException {
         waitForPageLoad();
        waitElementToBeClickable(addToFavoritesButton);
         addToFavoritesButton.click();
     }
     public void clickManageFavorites() throws InterruptedException {
         waitElementToBeClickable( manageFavoritesButton);
         manageFavoritesButton.click();
     }
 }
