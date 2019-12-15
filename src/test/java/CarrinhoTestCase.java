import locators.CheckoutLocators;
import locators.HomePageLocators;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({utils.Listeners.class})
public class CarrinhoTestCase extends BaseTest {


    @Test
    public void desafio1() {

        home.clicarNaListaDeCategorias();
        home.selecionarCategoria("Doces");
        home.adicionarTodosProdutosNoCarrinho();
        home.clicarNaListaDeCategorias();
        home.selecionarCategoria("Todos");
        home.clicarNoCarrinho();
        checkout.aumentarQuantidadeDeProdutoNoCarrinho("Brigadeiro", 4);
        checkout.finalizarCompra();
        checkout.validaMensagemPedidoRealizadoComSucesso();
        checkout.fecharCheckout();

    }

    @Test
    public void desafio2() {

        home.clicarNaListaDeCategorias();
        home.selecionarCategoria("Bebidas");
        home.adicionarTodosProdutosNoCarrinho();
        home.clicarNaListaDeCategorias();
        home.selecionarCategoria("Todos");
        home.adicionarUmProdutoNoCarrinho("Rissole médio");
        home.clicarNoCarrinho();
        checkout.aumentarQuantidadeDeProdutoNoCarrinho("Rissole médio", 9);
        checkout.diminuirQuantidadeDeProdutoNoCarrinho("Rissole médio", 5);
        checkout.finalizarCompra();
        checkout.validaMensagemPedidoRealizadoComSucesso();
        checkout.fecharCheckout();

    }

    @AfterClass
    public void browserQuit(){
        driver.quit();
    }

}
