package POM;

import Utills.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchedPage extends BaseClass {

    @FindBy(xpath = "//SPAN[@class='mw-page-title-main']")
    private WebElement mainTittle;
    @FindBy(id = "p-lang-btn")
    private WebElement btnLanguage;
    @FindBy(xpath = "//A[@class='autonym'][text()='English']")
    private WebElement languageEnglish;
    @FindBy(xpath = "//div[@data-pinnable-element-id='vector-main-menu']/button[text()='ocultar']")
    private WebElement btnHideMenu;
    @FindBy(xpath = "//INPUT[@aria-label='Cambiar a la tabla de contenidos']")
    private WebElement btnMenuHamburguer;
    @FindBy(xpath = "//H2[@class='vector-pinnable-header-label']")
    private WebElement titleOfAsideLeft;
    @FindBy(xpath = "//th[@class='cabecera persona']")
    private WebElement headerOfSearched;
    @FindBy(xpath = "//label[contains(text(), 'Grande')]")
    private WebElement largeFontSizeOption;


    public SearchedPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void changeLanguageToEnglish(){
        this.clickToElementClickable(this.btnLanguage);
        this.clickToElementClickable(this.languageEnglish);
    }

    public String getMainTitle(){
        return this.getTextByElement(this.mainTittle);
    }

    public String getTitleOfAsideLeft(){
        return this.getTextByElement(this.titleOfAsideLeft);
    }

    public void hideMenu(){
        this.clickElementByJavaScript(this.btnHideMenu);
    }

    public Double getFontSizeOfHeaderSearched(){
        String size = this.getFontSize(this.headerOfSearched);
        size = size.replace("px", "");
        return Double.parseDouble(size);
    }

    public void updateFontSize(){
        this.clickToElementClickable(this.largeFontSizeOption);
    }

    public Boolean isPrensentMenuHamburguer(){
        return this.isPresentElement(this.btnMenuHamburguer);
    }

}
