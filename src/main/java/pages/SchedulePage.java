package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SchedulePage extends Base {

    @FindBy(id = "find-schedule-searchbox")
    private  WebElement searchTransitTextBox;
    @FindBy(xpath = "//button[@form = 'searchAPI']")
    private WebElement findScheduleButton;

    @FindBy(xpath = "//article[@class = 'SearchResultItem']//a")
    private List<WebElement> searchResultOutput;


    public SchedulePage(WebDriver driver) {
        super(driver);
    }

    public void enterBusSearchDetails(String busDetails)
    {
        waitForPageLoad();
        waitElementToBeClickable(searchTransitTextBox);
        searchTransitTextBox.click();
        searchTransitTextBox.sendKeys(busDetails);
    }
    public void clickFindSchedule()
    {
        waitElementToBeClickable(findScheduleButton);
        findScheduleButton.click();
    }

    public void searchResults(String result) throws InterruptedException {
        waitForVisibilityOfAllElementToBeClickable(searchResultOutput);
        WebElement selectedElement  = searchAndScrollElement(result,searchResultOutput);
        waitElementToBeClickable(selectedElement);
        selectedElement.click();

    }


}
