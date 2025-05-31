package stepdefinations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Point;
import pages.FirstPage;
import utilities.WebDriverUtils;

import static utilities.WebDriverUtils.waitForElementToBeClickable;

public class MyStepdefs {
   FirstPage categoryPage = new FirstPage();

    @Then("the All menu button should be visible")
    public void theAllMenuButtonShouldBeVisible() {
        Assert.assertTrue("The All menu button is not displayed!", categoryPage.allMenuButton.isDisplayed());
    }


    @Then("the All menu button should be displayed at the top-left corner")
    public void theAllMenuButtonShouldBeDisplayedAtTheTopLeftCorner() {
        Point location = categoryPage.allMenuButton.getLocation();
        int x = location.getX();
        int y = location.getY();

        // Sol üst köşe için makul sınırlar (x ve y sıfıra yakın olmalı)
        Assert.assertTrue("The All menu button is not at the top-left corner! X:" + x + " Y:" + y,
                x < 100 && y < 150);
    }

    @Then("the All menu button should be clickable")
    public void theAllMenuButtonShouldBeClickable() {
        // Butonun tıklanabilir olduğuna dair assertion
        boolean isButtonClickable = waitForElementToBeClickable(categoryPage.allMenuButton,5) != null;
        Assert.assertTrue("All menu button should be clikable", isButtonClickable);
    }


    @When("Click All menu button")
    public void clickAllMenuButton() {
        categoryPage.allMenuButton.click();
        //TODO --> change with explicit wait
        WebDriverUtils.wait(5);
    }


    @Then("The main menu heading {string} should be displayed")
    public void theMainMenuHeadingShouldBeDisplayed(String mainMenuHeading) {
        Assert.assertTrue(categoryPage.mainMenuHeadings(mainMenuHeading).isDisplayed());
    }


    @Then("Digital Content & Devices {string} should be displayed")
    public void digitalContentDevicesShouldBeDisplayed(String subcategory) {
        Assert.assertTrue(categoryPage.digitalContentDevicesSubCategories(subcategory).isDisplayed());
    }


    @Then("Shop by Department {string} should be displayed")
    public void shopByDepartmentShouldBeDisplayed(String visibleSubcategory) {
        Assert.assertTrue(categoryPage.shopByDepartmentVisibleSubCategories(visibleSubcategory).isDisplayed());
    }


    @Then("Programs and Features {string} should be displayed")
    public void programsAndFeaturesShouldBeDisplayed(String visibleSubCategory) {
        Assert.assertTrue(categoryPage.programAndFeatureVisibleSubCategories(visibleSubCategory).isDisplayed());
    }


    @Then("Help and Settings {string} should be displayed")
    public void helpAndSettingsShouldBeDisplayed(String subCategory) {
        Assert.assertTrue(categoryPage.helpAndSettingSubCategories(subCategory).isDisplayed());  
    }


    @Then("Shop By Department's See all button should displayed")
    public void shopByDepartmentSSeeAllButtonShouldDisplayed() {
        Assert.assertTrue(categoryPage.seeAllButtons(0).isDisplayed());
    }


    @Then("Programs & Feature's See all button should displayed")
    public void programsFeatureSSeeAllButtonShouldDisplayed() {
        Assert.assertTrue(categoryPage.seeAllButtons(1).isDisplayed());
    }


    @When("Click {string}")
    public void click(String categoryName) {
        categoryPage.digitalContentDevicesSubCategoriesClick(categoryName);
    }


    @Then("Prime Video {string} should be displayed")
    public void primeVideoShouldBeDisplayed(String subcategories) {
        Assert.assertTrue(categoryPage.primeVideoSubCategories(subcategories).isDisplayed());
    }

    @Then("Amazon Music {string} should be displayed")
    public void amazonMusicShouldBeDisplayed(String subcategories) {
        Assert.assertTrue(categoryPage.amazonMusicSubCategories(subcategories).isDisplayed());
    }


    @Then("Kindle E-readers & Books {string} should be displayed")
    public void kindleEReadersBooksShouldBeDisplayed(String subheader) {
        Assert.assertTrue(categoryPage.kindleEreadersBooksHeadings(subheader).isDisplayed());
    }


    @Then("Kindle E-readers & Books {string} and {string} should be displayed")
    public void kindleEReadersBooksAndShouldBeDisplayed(String subheader, String subcategory) {
        Assert.assertTrue(categoryPage.deneme(subheader,subcategory).isDisplayed());
    }

    @Then("Amazon Appstore {string} should be displayed")
    public void amazonAppstoreShouldBeDisplayed(String subcategory) {
        Assert.assertTrue(categoryPage.amazonAppstoreSubcategory(subcategory).isDisplayed());
    }
}
