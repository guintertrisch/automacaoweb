package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.PesquisarLista;

import java.util.List;

public class CheckoutLocators {
    private WebDriver driver;
    private WebDriverWait wait;
    private String idAddDoceBrigadeiro = "add-product-4-qtd";
    private String idRemoveDoceBrigadeiro = "remove-product-4-qtd";
    private String idAddRisoleMedio = "add-product-3-qtd";
    private String idRemoveRisoleMedio = "remove-product-3-qtd";

    public CheckoutLocators(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 20);
    }

    public void aumentarQuantidadeDeProdutoNoCarrinho(String produto, int unidades) {
        switch (produto) {
            case "Brigadeiro":
                for (int i = 1; i < unidades; i++) {
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idAddDoceBrigadeiro))).click();
                }
                break;
            case "Rissole médio":
                for (int i = 1; i < unidades; i++) {
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idAddRisoleMedio))).click();
                }
                break;

        }

    }

    public void diminuirQuantidadeDeProdutoNoCarrinho(String produto, int unidades) {
        switch (produto) {
            case "Brigadeiro":
                for (int i = 1; i < unidades; i++) {
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idRemoveDoceBrigadeiro))).click();
                }
            case "Rissole médio":
                for (int i = 1; i < unidades; i++) {
                    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(idRemoveRisoleMedio))).click();
                }

        }


    }

    public void finalizarCompra() {

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("finish-checkout-button"))).click();
    }

    public void validaMensagemPedidoRealizadoComSucesso() {
        Assert.assertEquals(wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[3]/div/div/div/h2"))).getText(), "Pedido realizado com sucesso!");
    }

    public void fecharCheckout() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"root\"]/div[3]/div/div/div/button"))).click();

    }
}
