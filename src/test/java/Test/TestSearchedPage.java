package Test;

import POM.HomePage;
import POM.NotFoundPage;
import POM.SearchedPage;
import org.junit.jupiter.api.*;

public class TestSearchedPage extends BaseTest{


    //verificar que encuentra bien una busqueda
    @Test
    @DisplayName("CP_01")
    @Order(1)
    public void searchOK(){
        this.homePage.openPage();
        this.homePage.search(dataSet.get(1));
        this.homePage.sendSearch();
        Assertions.assertEquals(dataSet.get(2), this.searchPage.getMainTitle());
    }

    //verificar cambio de idioma
    @Test
    @DisplayName("CP_02")
    @Order(2)
    public void changeLanguage() throws InterruptedException {
        this.homePage.openPage();
        this.homePage.search(dataSet.get(1));
        this.homePage.sendSearch();
        this.searchPage.changeLanguageToEnglish();
        Assertions.assertEquals(dataSet.get(2), this.searchPage.getTitleOfAsideLeft());
    }

    //valor de busqueda incorrecto
    @Test
    @DisplayName("CP_03")
    @Order(3)
    public void searchNoOk(){
        this.homePage.openPage();
        this.homePage.search(dataSet.get(1));
        this.homePage.sendSearch();
        String value = this.notFoundPage.getNotFoundElementsOfSearch().toLowerCase();
        boolean isNotFoundElementes = value.startsWith(dataSet.get(2).toLowerCase());
        Assertions.assertEquals(true, isNotFoundElementes);
    }

    //verificar cambio de fuente
    @Test
    @DisplayName("CP_04")
    @Order(4)
    public void upperFontSize(){
        this.homePage.openPage();
        this.homePage.search(dataSet.get(1));
        this.homePage.sendSearch();
        Double fontSize = this.searchPage.getFontSizeOfHeaderSearched();
        this.searchPage.updateFontSize();
        Double newFontSize = this.searchPage.getFontSizeOfHeaderSearched();
        Assertions.assertTrue(fontSize < newFontSize);
    }

    //ocultar aside menu left
    @Test
    @DisplayName("CP_05")
    @Order(5)
    public void hideAsideMenuOk() throws InterruptedException {
        this.homePage.openPage();
        this.homePage.search(dataSet.get(1));
        this.homePage.sendSearch();
        this.searchPage.hideMenu();
        this.searchPage.hideMenu();
        Thread.sleep(5000);
        boolean isPresentMenu = this.searchPage.isPrensentMenuHamburguer();
        Assertions.assertEquals(true, isPresentMenu);
    }
}
