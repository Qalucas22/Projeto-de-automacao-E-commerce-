package testCases;

import org.junit.*;
import org.junit.internal.MethodSorter;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import pages.LoginPo;
import ultis.ScreenshotHelper;
import ultis.TestData;
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
    public void TC_001validarTituloDoSite()throws InterruptedException {
        String nomeDoTeste = "TC001_validarTituloDoSite";
        Assert.assertEquals("QAZANDO Shop E-Commerce" , uteis.validarTitulo());
        Thread.sleep(2000);
        ScreenshotHelper.tirarPrint(driver, nomeDoTeste, "01_validartituloDaPagina");
    }

    @Test
    public void TC_002LoginValido() throws InterruptedException {
        String nomeDoTeste = "TC_002LoginValido";
        loginPage.inserirDadosDeLogin(TestData.TEST_EMAIL,TestData.TEST_PASSWORD);
        ScreenshotHelper.tirarPrint(driver, nomeDoTeste, "01_validarDadosDeLogin");
        loginPage.confirmarBtnLogin();
        loginPage.confirmarLogin();
        Thread.sleep(1000);

    }

    @Test
    public void TC_003loginInvalidoCamposEmBranco() {
        String nomeTeste = "TC_003loginInvalidoCamposEmBranco";
        loginPage.inserirDadosDeLogin("","");
        ScreenshotHelper.tirarPrint(driver, nomeTeste, "01_validarDadosDeLogin");
        loginPage.confirmarBtnLogin();
        loginPage.validarCampoEmailInvalido();

    }

    @Test
    public void TC_004loginInvalidoCampoSenhaEmBanco(){
        String nomeTeste = "TC_004loginInvalidoCamposEmBranco";
        loginPage.inserirDadosDeLogin(TestData.TEST_EMAIL,"");
        ScreenshotHelper.tirarPrint(driver, nomeTeste, "01_validarDadosDeLogin");
        loginPage.confirmarBtnLogin();
        loginPage.validarCampoSenhaObrigatorio();
    }

    @Test
    public  void TC_005loginInvalidoCampoEmailEmBanco(){
        String nomeTeste = "TC_005loginInvalidoCampoEmailEmBanco";
        loginPage.inserirDadosDeLogin("",TestData.TEST_PASSWORD);
        ScreenshotHelper.tirarPrint(driver, nomeTeste, "01_validarDadosDeLogin");
        loginPage.confirmarBtnLogin();
        loginPage.validarCampoEmailInvalido();

    }

    @Test
    public  void TC_006loginDadosInvalidos(){
        String nomeTeste = "TC_006loginDadosInvalidos";
        loginPage.inserirDadosDeLogin("dasdsad","sdsadsadasd");
        ScreenshotHelper.tirarPrint(driver, nomeTeste, "01_validarDadosDeLogin");
        loginPage.confirmarBtnLogin();
        loginPage.validarCampoEmailInvalido();

    }

}
