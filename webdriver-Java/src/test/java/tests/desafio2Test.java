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

public class desafio2Test {
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

    @Test //se comentar essa linha desabilita esse teste
    public void testDesafio2 (){

        //clicar no botão *selecione a categoria* id="open-categories-btn"
        WebElement btnCategoria = navegador.findElement(By.id("open-categories-btn"));
        btnCategoria.click();

        //selecionar a categoria *Bebidas* id="category-1">Bebidas<
        navegador.findElement(By.id("category-0")).click();

        //clicar no botão *adicionar ao carrinho* de coca id="add-product-0-btn"
        navegador.findElement(By.id("add-product-0-btn")).click();

        //clicar no botão *adicionar ao carrinho* de fanta id="add-product-1-btn"
        navegador.findElement(By.id("add-product-1-btn")).click();

        //clicar no botão *adicionar ao carrinho* de agua id="add-product-2-btn"
        navegador.findElement(By.id("add-product-2-btn")).click();

        //validar que no carrinho tem 3 produtos pelo id="cart-products-qtd" é 3
        navegador.findElement(By.id("cart-products-qtd")).equals(3);

        //clicar no botão *selecione a categoria* id="open-categories-btn"
        btnCategoria.click();

        //selecionar a categoria *Todos* id="category-all">Todos<
        navegador.findElement(By.id("category-all")).click();

        //clicar no botão *adicionar ao carrinho* de rissole id="add-product-3-btn"
        navegador.findElement(By.id("add-product-3-btn")).click();

        //validar que no carrinho tem 4 produtos pelo id="cart-products-qtd" é 4
        navegador.findElement(By.id("cart-products-qtd")).equals(4);

        //acessar o carrinho id="cart-btn"
        navegador.findElement(By.id("cart-btn")).click();

        //aumentar a quantidade de rissole em 9, clicar 9x em adicionar id="add-product-3-qtd"
        for (int count=1 ; count <10 ; count++){
            navegador.findElement(By.id("add-product-3-qtd")).click();
        }
        ScreenShot.captura(navegador, "C:\\Users\\Maureen Souza\\4all\\ScreenShots\\Desafio2\\" + Generator.dataHoraParaArquivo() + "rissole.png");

        //diminuir a quantidade de rissole em 5, clicar 9x em adicionar id="add-product-3-qtd"
        for (int count=10 ; count >5 ; count--){
            navegador.findElement(By.id("remove-product-3-qtd")).click();
        }
        ScreenShot.captura(navegador, "C:\\Users\\Maureen Souza\\4all\\ScreenShots\\Desafio2\\" + Generator.dataHoraParaArquivo() + "rissole2.png");

        //validar o valor total do carrinho
        //pega o valor unitario de cada item
        WebElement valorCoca = navegador.findElement(By.id("product-0-price"));
        String strValorCoca = valorCoca.getText();
        String strValorCocaNew = strValorCoca.replace("R$ ", "");
        String strValorCocaNew2 = strValorCocaNew.replace(",", ".");
        Double doubleValorCoca = Double.parseDouble(strValorCocaNew2);

        //Fanta
        WebElement valorFanta = navegador.findElement(By.id("product-1-price"));
        String strValorFanta = valorFanta.getText();
        String strValorFantaNew = strValorFanta.replace("R$ ", "");
        String strValorFantaNew2 = strValorFantaNew.replace(",", ".");
        Double doubleValorFanta = Double.parseDouble(strValorFantaNew2);

        //Agua
        WebElement valorAgua = navegador.findElement(By.id("product-2-price"));
        String strValorAgua = valorAgua.getText();
        String strValorAguaNew = strValorAgua.replace("R$ ", "");
        String strValorAguaNew2 = strValorAguaNew.replace(",", ".");
        Double doubleValorAgua = Double.parseDouble(strValorAguaNew2);

        //Rissole
        WebElement valorRissole = navegador.findElement(By.id("product-3-price"));
        String strValorRissole = valorRissole.getText();
        String strValorRissoleNew = strValorRissole.replace("R$ ", "");
        String strValorRissoleNew2 = strValorRissoleNew.replace(",", ".");
        Double doubleValorRissole = Double.parseDouble(strValorRissoleNew2);

        //pegar a qtdade de cada item
        WebElement qtdCoca = navegador.findElement(By.id("product-0-qtd"));
        String strQtdCoca = qtdCoca.getText();
        Double doubleQtdCoca = Double.parseDouble(strQtdCoca);

        //Fanta
        WebElement qtdFanta = navegador.findElement(By.id("product-1-qtd"));
        String strQtdFanta = qtdFanta.getText();
        Double doubleQtdFanta = Double.parseDouble(strQtdFanta);

        //Agua
        WebElement qtdAgua = navegador.findElement(By.id("product-2-qtd"));
        String strQtdAgua = qtdAgua.getText();
        Double doubleQtdAgua = Double.parseDouble(strQtdAgua);

        //Rissole
        WebElement qtdRissole = navegador.findElement(By.id("product-3-qtd"));
        String strQtdRissole = qtdRissole.getText();
        Double doubleQtdRissole = Double.parseDouble(strQtdRissole);

        //multiplicar as qtds pelo valo0r unitario de cada item
        Double valorTotalCoca = doubleValorCoca * doubleQtdCoca;

        //Fanta
        Double valorTotalFanta = doubleValorFanta * doubleQtdFanta;

        //Agua
        Double valorTotalAgua = doubleValorAgua * doubleQtdAgua;

        //Rissole
        Double valorTotalRissole = doubleValorRissole * doubleQtdRissole;

        //Calcula valorTotal
        Double valorTotal = valorTotalAgua + valorTotalCoca + valorTotalFanta + valorTotalRissole;

        //compara soma com o subtotal da tela
        WebElement valorTotalCart = navegador.findElement(By.id("price-total-checkout"));
        String strValorTotal = valorTotalCart.getText();
        String strValorTotalNew = strValorTotal.replace("R$ ", "");
        String strValorTotalNew2 = strValorTotalNew.replace(",", ".");
        Double doubleValorTotal = Double.parseDouble(strValorTotalNew2);

        int testeValorTotal = Double.compare(doubleValorTotal, valorTotal);

        if(testeValorTotal > 0) {
            System.out.println("O valor da tela é maior do que a soma que o sistema calculou");
        } else if(testeValorTotal < 0) {
            System.out.println("O valor da soma que o sistema calculou é maior do que o valor da tela");
        } else {
            System.out.println("A soma calculada pelo sistema e o valor na tela são iguais");
        }

        //clicar em finalizar compra id="finish-checkout-button"
        navegador.findElement(By.id("finish-checkout-button")).click();
        ScreenShot.captura(navegador, "C:\\Users\\Maureen Souza\\4all\\ScreenShots\\Desafio2\\" + Generator.dataHoraParaArquivo() + "checkout.png");

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