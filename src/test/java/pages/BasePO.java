package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePO {
    // Driver base que será usado pelas pages
    protected WebDriver driver;

    //Construor base para criação da fabrica de elementos
    // @param driver da pagina atual.
    public BasePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    /* Metodo que retornar o titulo da pagina Atual*/
    public String obterTituloDaPagina() {
        return driver.getTitle();
    }
}
