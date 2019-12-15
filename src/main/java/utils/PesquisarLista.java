package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class PesquisarLista {
    private WebDriver driver;
    private WebDriverWait wait;

    public PesquisarLista(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);

    }

    public WebElement buscarCategoriaNaLista(String categoria, String xpath) {
        WebElement categoriaEncontrada = null;
        Boolean achou = false;
        List<WebElement> nomesCategorias = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpath)));

        for (WebElement cat : nomesCategorias) {
            if (cat.getText().equalsIgnoreCase(categoria)) {
                categoriaEncontrada = cat;
                achou = true;
                break;
            }
        }
        if (!achou) {
            Assert.assertTrue(achou, "Categoria não encontrada: " + categoria);
        } else {
            return categoriaEncontrada;
        }
        return null;
    }

}
