package POM;

import Utills.BaseClass;
import Utills.Propertiesdriven;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BaseClass {

    @FindBy(xpath = "//INPUT[@class='cdx-text-input__input']")
    private WebElement inputSearch;
    @FindBy(xpath = "//BUTTON[text()='Buscar']")
    private WebElement btnSearch;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void openPage(){
        this.driver.get(Propertiesdriven.getProperty("url"));
    }

    public void search(String value){
        this.sendKeysToElementVisible(inputSearch, value);
    }

    public void sendSearch()  {
        this.clickToElementClickable(this.btnSearch);
    }

}
