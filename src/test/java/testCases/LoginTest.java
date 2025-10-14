package testCases;

import org.junit.*;
import org.junit.internal.MethodSorter;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import pages.LoginPo;
import ultis.ScreenshotHelper;
import ultis.Uteis;

import java.lang.reflect.Method;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginTest extends BaseTeste{
    private static LoginPo loginPage ;
    private static  Uteis uteis ;

    @Before
    public void prepararTeste(){
        loginPage = new LoginPo(BaseTeste.driver);
        uteis = new Uteis();
    }

    @After
    public void tirarScreenshotAposTeste() {
        String nomeDoTeste = this.getClass().getSimpleName(); // Ex: CadastroTest
        ScreenshotHelper.tirarPrint(driver, nomeDoTeste, "final");
    }


    @Test
    public void validarTituloDoSite()throws InterruptedException {
        String nomeDoTeste = "TC001_validarTituloDoSite";
        Assert.assertEquals("QAZANDO Shop E-Commerce" , uteis.validarTitulo());
        Thread.sleep(2000);
        ScreenshotHelper.tirarPrint(driver, nomeDoTeste, "01_validartituloDaPagina");
    }

}
