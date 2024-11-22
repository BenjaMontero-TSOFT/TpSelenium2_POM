package POM;

import Utills.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NotFoundPage extends BaseClass {

    @FindBy(xpath = "//P[@class='mw-search-nonefound']")
    private WebElement notFoundElementsOfSearch;

    public NotFoundPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getNotFoundElementsOfSearch(){
        return this.getTextByElement(this.notFoundElementsOfSearch);
    }




}
