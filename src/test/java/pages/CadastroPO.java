package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ultis.Uteis;

public class CadastroPO extends BasePO {
    public CadastroPO(WebDriver driver) {
        super(driver);
        uteis = new Uteis();
    }
    private  Uteis uteis;


    // ======= ELEMENTOS =======
    private By iptNome = By.id("user");
    private By iptEmail = By.id("email");
    private By iptSenha = By.id("password");
    public By btnCadstrar = By.xpath("//*[contains(@href, '/register')]");
    private By txtCadastrarUsuario = By.xpath("//*[contains(text(),'Cadastro de usuário')]");
    private By txtCampoNomeObrigatorio = By.id("errorMessageFirstName");
    private By txtCampoEmailObrigatorio = By.xpath("//*[contains(text(),'O campo e-mail deve ser prenchido corretamente')]");
    private By txtCampoSenhaObrigatorio = By.xpath("//*[contains(text(),'O campo senha deve ter pelo menos 6 dígitos')]");
    public By btnConfirmarCadastro = By.id("btnRegister");
    public By txtCadastroRealizado = By.xpath("//*[contains(text(),'Cadastro realizado!')]");
    public By imgSucesso = By.xpath("//*[contains(@class,'swal2-success-ring')]");
    // ======= DADOS PADRÃO OU VARIÁVEIS INTERNAS =======


    // ======= MÉTODOS =======
    public void acessarTelaCadastro(){
        uteis.esperarElementoEstaPresente(btnCadstrar,2);
        driver.findElement(btnCadstrar).click();
        uteis.esperarElementoEstaPresente(txtCadastrarUsuario,2);
        uteis.ValidarElementoNaTela(txtCadastrarUsuario);
    }


    public void inserirDadosDeCadastro(String nome, String email, String senha){
        driver.findElement(iptNome).sendKeys(nome);
        driver.findElement(iptEmail).sendKeys(email);
        driver.findElement(iptSenha).sendKeys(senha);
    }

    public void confirmarDados(){
        driver.findElement(btnConfirmarCadastro).click();
    }

    public void validarCadastroCampoNomeObrigatorio(){
        String txtNomeObrigatorio = driver.findElement(txtCampoNomeObrigatorio).getText();
        Assert.assertEquals(txtNomeObrigatorio,"O campo nome deve ser prenchido");
    }
    public void validarCadastroComErroDeEmailCadastrado(){
        String txtCampoDeveSerPreenchidoCorretamente = driver.findElement(txtCampoEmailObrigatorio).getText();
        Assert.assertEquals(txtCampoDeveSerPreenchidoCorretamente,"O campo e-mail deve ser prenchido corretamente");
    }
    public void validarCadastroRealizado(){
        String cadastroRealizado = driver.findElement(txtCadastroRealizado).getText();
        Assert.assertEquals(cadastroRealizado,"Cadastro realizado!");
    }

    public void validarCampoSenhaObrigatorio(){
        String txtSenhaObrigatorio = driver.findElement(txtCampoSenhaObrigatorio).getText();
        Assert.assertEquals(txtSenhaObrigatorio,"O campo senha deve ter pelo menos 6 dígitos");
    }

}
