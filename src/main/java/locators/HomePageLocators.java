package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.PesquisarLista;

import java.util.List;

public class HomePageLocators {
    private WebDriver driver;
    private WebDriverWait wait;
    private String brigadeiroAddCarinho = "add-product-4-btn";
    private String rissoleMedioAddCarinho = "add-product-3-btn";
    private String alfajorChocolateAddCarinho = "add-product-5-btn";

    public HomePageLocators(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    public void clicarNaListaDeCategorias() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("open-categories-btn"))).click();
    }

    public void selecionarCategoria(String categoria) {
        String xpathListaCategoria = "//*[@id=\"root\"]/div[3]/div/div/div/ul/li";
        PesquisarLista pesquisarLista = new PesquisarLista(driver);
        pesquisarLista.buscarCategoriaNaLista(categoria, xpathListaCategoria).click();

    }

    public void adicionarTodosProdutosNoCarrinho() {
        String xpathListaProdutos = "//*[@id=\"root\"]/div[2]/ul/li/div/button";
        List<WebElement> produtos = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathListaProdutos)));

        for (WebElement produtosCarrinho : produtos) {
            produtosCarrinho.click();
        }
    }

    public void adicionarUmProdutoNoCarrinho(String produto) {
        switch (produto) {
            case "Alfajor de chocolate":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(alfajorChocolateAddCarinho))).click();
                break;
            case "Rissole médio":
                wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(rissoleMedioAddCarinho))).click();
                break;

        }


    }

    public void clicarNoCarrinho() {

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cart-products-qtd"))).click();

    }


}
