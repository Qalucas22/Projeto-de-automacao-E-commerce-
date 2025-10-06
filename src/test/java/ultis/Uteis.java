package ultis;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import testCases.BaseTeste;

import java.util.Random;

public class Uteis extends BaseTeste {

    public String validarTitulo(){
        return driver.getTitle();
    }
    /** Metodo para obter o texto de um elemento com qualquer tipo de localizador */
    public String obterTexto(By by){
        return driver.findElement(by).getText();
    }
    /** Metodo para da scrool até elemento
     * o executeScript() espera um WebElement, não um By
     * */
    public void scrollTo(By by) throws InterruptedException {
        WebElement element = driver.findElement(by);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        //Esperar Elemento
        Thread.sleep(2000);
    }

    /** Validar que elemento está visisvel na tela */
    public void ValidarElementoNaTela(By by){
        Assert.assertEquals(true,driver.findElement(by).isDisplayed());
    }

    /** Metodo que aguardar elemento ficar presente, assim que validar elemento segui para o proximo passo. Nao esperar a quantidade de tempo
     * estimada*/
    public void esperarElementoEstaPresente(By element, int tempo){
        WebDriverWait wait = new WebDriverWait(driver, tempo);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /** Metodo para validar esperar por um titulo da pagina */
    public void esperarTitulo(String tituloEsperado){
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.titleIs(tituloEsperado));
    }

    public  String emailRandom(){
        String email_inicio = "QaJL";
        String email_final = "@teste.com";

        Random random = new Random();
        int minimo = 1 ;
        int maximo = 999999;
        int resultado = random.nextInt(maximo - minimo) + minimo;
        return email_inicio + resultado + email_final;
    }
}
