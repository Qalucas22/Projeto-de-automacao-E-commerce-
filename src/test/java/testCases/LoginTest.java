package testCases;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.internal.MethodSorter;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import pages.LoginPo;
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


    @Test
    public void validarTituloDoSite(){
        Assert.assertEquals("QAZANDO Shop E-Commerce" , uteis.validarTitulo());
    }

}
