package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPo extends BasePO{

    public  LoginPo(WebDriver driver) {
        super(driver);
    }

    //    private String URL = "http://automationpratice.com.br/";
//    private By botaoAcessarLogin = By.cssSelector(".right_list_fix > li > a > .fa-user");
    private By campoEmail = By.id("user");
    private By campoSenha = By.id("password");
    private By botaoFazerLogin = By.id("btnLogin");
    private By botaoAcessarCadastro = By.linkText(" Cadastro");
    private By botaoAcessarLogin = By.linkText(" Login");
    private By inputCheckout = By.id("materialUnchecked");
    private By msgNaoTemConta = By.linkText("Ainda não tem conta?");
    private By abaHome = By.id("menuHome");
    private By abaShop = By.linkText("Shop");
    private By abaPages = By.linkText("Pages");
    private By abaEletronics = By.linkText("Electronics");


}
