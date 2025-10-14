package ultis;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;


public class ScreenshotHelper {

    public static void tirarPrint(WebDriver driver, String nomeTeste, String nomeArquivoBase) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String caminho = "screenshots/" + nomeTeste;

        // Cria o diretório se não existir
        File pasta = new File(caminho);
        if (!pasta.exists()) {
            pasta.mkdirs();
        }

        File destino = new File(pasta, nomeArquivoBase + ".png");

        try {
            Files.copy(screenshot.toPath(), destino.toPath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}