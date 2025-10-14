package testCases;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTeste {
    /** Driver do navegador da pagina atual*/
    protected static WebDriver driver ;
    /** caminho base da url a ser testado*/
    private static String urlBase = "https://automationpratice.com.br/login#!" ;

    /** Metodo para iniciar o driver do navegador antes de qualquer classe de teste*/
    @Before
    public  void iniciar(){
        driver = new ChromeDriver();
        driver.get(urlBase);
    }
    /** Metodo que finalizar o driver do navegador depois de qualquer classe de teste*/
    @After
    public  void finalizar(){
        driver.quit();
    }


}
