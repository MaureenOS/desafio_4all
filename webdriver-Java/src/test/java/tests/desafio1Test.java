package tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import suporte.Generator;
import suporte.ScreenShot;

import java.util.concurrent.TimeUnit;

public class desafio1Test {
    private WebDriver navegador;

    @Before
    public void setUp(){
        // abrindo o navegador
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Maureen Souza\\driver\\chromedriver.exe");
        navegador = new ChromeDriver();
        navegador.manage().window().maximize(); // maximiza a janela que abre do chrome
        navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        //navegando para a página do 4all!
        navegador.get("https://shopcart-challenge.4all.com");
    }

    @Test
    public void testDesafio1 (){
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
        ScreenShot.captura(navegador, "C:\\Users\\Maureen Souza\\4all\\ScreenShots\\Desafio1\\" + Generator.dataHoraParaArquivo() + "carrinho.png");

        //clicar no botão *selecione a categoria* id="open-categories-btn"
        btnCategoria.click();

        //selecionar a categoria *Todos* id="category-all">Todos<
        navegador.findElement(By.id("category-all")).click();

        //acessar o carrinho id="cart-btn"
        navegador.findElement(By.id("cart-btn")).click();

        //aumentar a quantidade de brigadeiro em 4, clicar 4x em adicionar id="add-product-4-qtd
        for (int count=1 ; count <5 ; count++){
            navegador.findElement(By.id("add-product-4-qtd")).click();
        }
        ScreenShot.captura(navegador, "C:\\Users\\Maureen Souza\\4all\\ScreenShots\\Desafio1\\" + Generator.dataHoraParaArquivo() + "brigadeiros.png");

        //clicar em finalizar compra id="finish-checkout-button"
        navegador.findElement(By.id("finish-checkout-button")).click();
        ScreenShot.captura(navegador, "C:\\Users\\Maureen Souza\\4all\\ScreenShots\\Desafio1\\" + Generator.dataHoraParaArquivo() + "mensagemDeSucesso.png");

        //validar a mensagem *pedido realizado com sucesso* class="sc-dNLxif jyncPa"
        WebElement mensagem = navegador.findElement(By.className("sc-dNLxif"));
        String textoNoElementoMensagem = mensagem.getText();
        assertEquals("Pedido realizado com sucesso!" , textoNoElementoMensagem); //validação mesmo

        // clicar no botão fechar class="close-modal sc-jqCOkK ippulb" Fechar
        navegador.findElement(By.className("close-modal")).click();
    }

    @After
    public void tearDown(){
        //fechar navegador
        navegador.quit();
    }
}
