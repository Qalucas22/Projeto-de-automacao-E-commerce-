package testCases;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import pages.CadastroPO;
import pages.LoginPo;
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

    @Test
    public void TC001_cadastrarUsuarioComSucesso(){
        cadastroPage.acessarTelaCadastro();
        cadastroPage.cadastrarUsuario(cadastroPage.nomeValido, uteis.emailRandom(), cadastroPage.senhaValida);
        cadastroPage.validarCadastroRealizado();
    }

    @Test
    public void TC002_validarCadastroEmailInvalido(){
        cadastroPage.acessarTelaCadastro();
        cadastroPage.cadastrarUsuario(cadastroPage.nomeValido, cadastroPage.emailInvalido, cadastroPage.senhaValida);
        cadastroPage.validarCadastroComErroDeEmailCadastrado();
    }

    @Test
    public void TC003_validarCampoNomeObrigatorioNoCadastro(){
        cadastroPage.acessarTelaCadastro();
        cadastroPage.cadastrarUsuario("", cadastroPage.emailValido, cadastroPage.senhaValida);
        cadastroPage.validarCadastroCampoNomeObrigatorio();
    }

    @Test
    public void TC004_validarCampoSenhaObrigatorioNoCadastro(){
        cadastroPage.acessarTelaCadastro();
        cadastroPage.cadastrarUsuario(cadastroPage.nomeValido, cadastroPage.emailValido, "");
        cadastroPage.validarCampoSenhaObrigatorio();
    }


}
