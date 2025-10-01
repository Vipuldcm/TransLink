package tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import utils.DriverFactory;

public class TestBus {
WebDriver driver;
HomePage homePage;
SchedulePage schedulePage;
BusSchedulesPage busSchedulesPage;
StopPage stopPage;
FavoritesPage favoritesPage;
ManageFavorites favorites;

    @BeforeClass
    public void setup()
    {
driver = DriverFactory.setUp();
driver.get("https://www.translink.ca");
homePage = new HomePage(driver);
schedulePage = new SchedulePage(driver);
busSchedulesPage = new BusSchedulesPage(driver);
stopPage  = new StopPage(driver);
favoritesPage = new FavoritesPage(driver);
favorites = new ManageFavorites(driver);



    }
//    driver.quit();
    @Test
    public  void testNavigateBus() throws InterruptedException {
        homePage.navigateToBus();
        schedulePage.enterBusSearchDetails("99");
        schedulePage.clickFindSchedule();
        schedulePage.searchResults("#99 – UBC B-Line");
        busSchedulesPage.setDate();
        busSchedulesPage.setTime("7:30AM", "8:30AM");
        busSchedulesPage.search();
        busSchedulesPage.selectStop("#50913");
        stopPage.clickFavorites();
        favoritesPage.enterFavoriteName("99 UBC B-Line – Morning Schedule");
        favoritesPage.clickFavoriteButton();
       stopPage.clickManageFavorites();
       Assert.assertEquals(favorites.getFavoriteText(),"99 UBC B-Line – Morning Schedule"); ;

    }

    @AfterTest
    public void cleanUp()
    {
        driver.quit();
    }

}
