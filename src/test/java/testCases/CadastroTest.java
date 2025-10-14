package testCases;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.CadastroPO;
import pages.LoginPo;
import ultis.ScreenshotHelper;
import ultis.Uteis;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CadastroTest extends BaseTeste{
    private static CadastroPO cadastroPage;
    private static Uteis uteis;

    @Before
    public void prepararTeste(){
        cadastroPage = new CadastroPO(BaseTeste.driver);
        uteis = new Uteis();
    }

    @After
    public void tirarScreenshotAposTeste() {
        String nomeDoTeste = this.getClass().getSimpleName(); // Ex: CadastroTest
        ScreenshotHelper.tirarPrint(driver, nomeDoTeste, "final");
    }

    @Test
    public void TC001_cadastrarUsuarioComSucesso() throws InterruptedException {
        String nomeDoTeste = "TC001_cadastrarUsuarioComSucesso";

        cadastroPage.acessarTelaCadastro();
        ScreenshotHelper.tirarPrint(driver, nomeDoTeste, "01_AcessarTelaDeCadastro");

        cadastroPage.inserirDadosDeCadastro(cadastroPage.nomeValido, uteis.emailRandom(), cadastroPage.senhaValida);
        ScreenshotHelper.tirarPrint(driver, nomeDoTeste, "02_VerificarDados");

        cadastroPage.confirmarDados();

        // Esperar para garantir que o alerta de sucesso esteja totalmente renderizado
        Thread.sleep(2000);

        ScreenshotHelper.tirarPrint(driver, nomeDoTeste, "03_CadastroRealizado");

        cadastroPage.validarCadastroRealizado();
    }

    @Test
    public void TC002_validarCadastroEmailInvalido() {
        String nomeDoTeste = "TC002_validarCadastroEmailInvalido"; // ou this.getClass().getSimpleName()

        cadastroPage.acessarTelaCadastro();
        ScreenshotHelper.tirarPrint(driver, nomeDoTeste, "01_AcessarTelaDeCadastro");

        cadastroPage.inserirDadosDeCadastro(cadastroPage.nomeValido, cadastroPage.emailInvalido, cadastroPage.senhaValida);
        ScreenshotHelper.tirarPrint(driver, nomeDoTeste, "02_VerificarDados");
        cadastroPage.confirmarDados();
        // 🔽 (Opcional) Esperar mensagem de erro se ela demora para aparecer
        // uteis.esperarElementoVisivel(cadastroPage.txtCampoEmailObrigatorio, 5);
        ScreenshotHelper.tirarPrint(driver, nomeDoTeste, "03_ErroEmailInvalido");
        cadastroPage.validarCadastroComErroDeEmailCadastrado();
    }

    @Test
    public void TC003_validarCampoNomeObrigatorioNoCadastro() {
        String nomeDoTeste = "TC003_validarCampoNomeObrigatorioNoCadastro";

        cadastroPage.acessarTelaCadastro();
        ScreenshotHelper.tirarPrint(driver, nomeDoTeste, "01_AcessarTelaDeCadastro");

        cadastroPage.inserirDadosDeCadastro("", cadastroPage.emailValido, cadastroPage.senhaValida);
        ScreenshotHelper.tirarPrint(driver, nomeDoTeste, "02_VerificarDados");

        cadastroPage.confirmarDados();

        // (Opcional) esperar elemento de erro aparecer, se houver atraso
        // uteis.esperarElementoVisivel(cadastroPage.txtCampoNomeObrigatorio, 5);

        ScreenshotHelper.tirarPrint(driver, nomeDoTeste, "03_MensagemErroNome");

        cadastroPage.validarCadastroCampoNomeObrigatorio();
    }

    @Test
    public void TC004_validarCampoSenhaObrigatorioNoCadastro() {
        String nomeDoTeste = "TC004_validarCampoSenhaObrigatorioNoCadastro";

        cadastroPage.acessarTelaCadastro();
        ScreenshotHelper.tirarPrint(driver, nomeDoTeste, "01_AcessarTelaDeCadastro");

        cadastroPage.inserirDadosDeCadastro(cadastroPage.nomeValido, cadastroPage.emailValido, "");
        ScreenshotHelper.tirarPrint(driver, nomeDoTeste, "02_VerificarDados");

        cadastroPage.confirmarDados();

        // (Opcional) esperar elemento de erro aparecer, se houver atraso
        // uteis.esperarElementoVisivel(cadastroPage.txtCampoSenhaObrigatorio, 5);

        ScreenshotHelper.tirarPrint(driver, nomeDoTeste, "03_MensagemErroSenha");

        cadastroPage.validarCampoSenhaObrigatorio();
    }


}
