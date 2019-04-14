package tests;

import static org.junit.Assert.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class desafio1Test {
    @Test
    public void testDesafio1 (){
        // abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maureen Souza\\driver\\chromedriver.exe");
        WebDriver navegador = new ChromeDriver();
        navegador.manage().window().maximize(); // maximiza a janela que abre do chrome
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //navegando para a página do 4all!
        navegador.get("https://shopcart-challenge.4all.com");

        //clicar no botão *selecione a categoria* id="open-categories-btn"
        WebElement btnCategoria = navegador.findElement(By.id("open-categories-btn"));
        btnCategoria.click();

        //selecionar a categoria *doces* id="category-1">Doces<
        navegador.findElement(By.id("category-1")).click();

        //clicar no botão *adicionar ao carrinho* de brigadeiro id="add-product-4-btn"
        navegador.findElement(By.id("add-product-4-btn")).click();

        //clicar no botão *adicionar ao carrinho* de alfajor id="add-product-5-btn"
        navegador.findElement(By.id("add-product-5-btn")).click();

        //validar que no carrinho tem 2 produtos pelo id="cart-products-qtd" é 2
        navegador.findElement(By.id("cart-products-qtd")).equals(2);

        //clicar no botão *selecione a categoria* id="open-categories-btn"
        btnCategoria.click();

        //selecionar a categoria *Todos* id="category-all">Todos<
        navegador.findElement(By.id("category-all")).click();

        //acessar o carrinho id="cart-btn"
        navegador.findElement(By.id("cart-btn")).click();

        //aumentar a quantidade de brigadeiro em 4, clicar 4x em adicionar id="add-product-4-qtd"
        navegador.findElement(By.id("add-product-4-qtd")).click();
        navegador.findElement(By.id("add-product-4-qtd")).click();
        navegador.findElement(By.id("add-product-4-qtd")).click();
        navegador.findElement(By.id("add-product-4-qtd")).click();

        //clicar em finalizar compra id="finish-checkout-button"
        navegador.findElement(By.id("finish-checkout-button")).click();

        //validar a mensagem *pedido realizado com sucesso* class="sc-dNLxif jyncPa"
        WebElement mensagem = navegador.findElement(By.className("sc-dNLxif"));
        String textoNoElementoMensagem = mensagem.getText();
        assertEquals("Pedido realizado com sucesso!" , textoNoElementoMensagem); //validação memo

        // clicar no botão fechar class="close-modal sc-jqCOkK ippulb" Fechar
        navegador.findElement(By.className("close-modal")).click();

        //fechar navegador
        navegador.quit();

        //validando a saida
        //assertEquals( 1, 1);
    }

}
