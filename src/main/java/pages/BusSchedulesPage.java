package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;
import java.util.List;

public class BusSchedulesPage extends Base {
    @FindBy(id = "schedulestimefilter-startdate")
    private  WebElement dateTextBox;
    @FindBy(id = "schedulestimefilter-starttime")
    private  WebElement startTimeTextBox;
    @FindBy(id = "schedulestimefilter-endtime")
    private  WebElement endTimeTextBox;
    @FindBy(xpath = "//button[@form = 'SchedulesTimeFilter']")
    private  WebElement searchButton;


    @FindBy(xpath ="//tr[@role = 'row']//a")
    private List<WebElement> searchResults;


    public BusSchedulesPage(WebDriver driver) {
        super(driver);
    }
    public void setDate() throws InterruptedException {
        waitForPageLoad();
        waitElementToBeClickable(dateTextBox);
       dateTextBox.click();
        dateTextBox.clear();
      dateTextBox.sendKeys((LocalDate.now().plusDays(1)).toString());

    }
    public void setTime(String startTime, String endTime) throws InterruptedException {

        waitElementToBeClickable(startTimeTextBox);
        startTimeTextBox.click();
     startTimeTextBox.clear();
      startTimeTextBox.sendKeys(startTime);
      waitElementToBeClickable(endTimeTextBox);
        endTimeTextBox.click();
        endTimeTextBox.clear();
       endTimeTextBox.sendKeys(endTime);


    }
    public  void search()
    {waitElementToBeClickable(searchButton);
      searchButton.click();
    }

    public void selectStop(String text) throws InterruptedException {
        waitForVisibilityOfAllElementToBeClickable(searchResults);
        searchAndScrollElement(text,searchResults).click();
    }



}
