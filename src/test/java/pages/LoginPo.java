package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ultis.ScreenshotHelper;
import ultis.TestData;
import ultis.Uteis;

public class LoginPo extends BasePO{

    public  LoginPo(WebDriver driver) {
        super(driver);
        uteis = new Uteis();
    }
    private  Uteis uteis;

    // ======= ELEMENTOS =======
    private By campoEmail = By.id("user");
    private By campoSenha = By.id("password");
    private By btnFazerLogin = By.id("btnLogin");
    public By txtLoginSucesso = By.xpath("//*[contains(text(),'Login realizado')]");
    private By botaoAcessarLogin = By.linkText(" Login");
    private By inputCheckout = By.id("materialUnchecked");
    private By msgNaoTemConta = By.linkText("Ainda não tem conta?");
    private By abaHome = By.id("menuHome");
    private By abaShop = By.linkText("Shop");
    private By abaPages = By.linkText("Pages");
    private By abaEletronics = By.linkText("Electronics");
    public By txtEmailInvalido= By.xpath("//*[contains(text(),'E-mail inválido.')]");
    public By txtSenhaInvalido= By.xpath("//*[contains(text(),'Senha inválida.')]");
    // ======= DADOS PADRÃO OU VARIÁVEIS INTERNAS =======

    // ======= MÉTODOS =======

    public void inserirDadosDeLogin(String email, String senha){
        uteis.esperarElementoEstaPresente(campoEmail,1);
        driver.findElement(campoEmail).sendKeys(email);
        driver.findElement(campoSenha).sendKeys(senha);
    }

    public void confirmarBtnLogin(){
        driver.findElement(btnFazerLogin).click();
    }

    public void confirmarLogin()throws InterruptedException{
        driver.findElement(txtLoginSucesso).isDisplayed();
        Thread.sleep(1000);
}
    public void validarCampoEmailInvalido(){
        String textoCampoObrigatorio = uteis.obterTexto(txtEmailInvalido);
        Assert.assertEquals(textoCampoObrigatorio, "E-mail inválido.");
    }

    public void validarCampoSenhaObrigatorio(){
        String textoCampoObrigatorio = uteis.obterTexto(txtSenhaInvalido);
        Assert.assertEquals(textoCampoObrigatorio, "Senha inválida.");
    }
}
