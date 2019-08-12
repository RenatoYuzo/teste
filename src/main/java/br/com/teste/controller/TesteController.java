package br.com.teste.controller;

import br.com.teste.interfaces.Controller;
import br.com.teste.model.DadosIniciais;
import br.com.teste.util.JsonUtil;
import br.com.teste.util.MessageBox;
import com.google.gson.Gson;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;
import java.util.ResourceBundle;

public class TesteController implements Controller {

    private DadosIniciais dadosIniciais;
    private static WebDriverWait wait;
    private static WebDriver driver;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        try {
            String str = JsonUtil.lerJsonFile();

            Gson gson = new Gson();
            dadosIniciais = gson.fromJson(str, DadosIniciais.class);

            System.out.println(dadosIniciais.toString());

            inputUsuario.setText(dadosIniciais.getLogin());
            inputPassword.setText(dadosIniciais.getSenha());
            cbSalvarSenha.setSelected(dadosIniciais.isSalvarSenha());
        } catch (Exception e) {
            MessageBox.addError("Erro", "Erro ao carregar o usuário!");
            System.err.println("Erro ao carregar o usuário: " + e.getLocalizedMessage());
        }
    }

    @FXML
    Button btnIniciar;
    @FXML
    TextField inputUsuario;
    @FXML
    PasswordField inputPassword;
    @FXML
    CheckBox cbSalvarSenha;

    public void actionIniciar() {

        if (cbSalvarSenha.isSelected()) {
            dadosIniciais.setLogin(inputUsuario.getText());
            dadosIniciais.setSenha(inputPassword.getText());
            JsonUtil.writeJsonFile(dadosIniciais);
        }

        try {
            if (inputUsuario.getText().trim().equals("") || inputUsuario.getText() == null) {
                MessageBox.addInfo("Usuário não preenchido!", "Por favor, confira o campo \"usuário\" e " +
                        "certifique-se que o mesmo foi preenchido corretamente.");
            } else if (inputPassword.getText().trim().equals("") || inputPassword.getText() == null) {
                MessageBox.addInfo("Senha não preenchida!", "Por favor, confira o campo \"senha\" e " +
                        "certifique-se que o mesmo foi preenchido corretamente.");
            } else {
                btnIniciar.setDisable(true);
                this.executeRobot();
            }

        } catch (Exception e) {
            btnIniciar.setDisable(false);
            System.err.println(e.getMessage());
        } finally {
//            driver.quit();
        }
    }

    private void executeRobot() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(dadosIniciais.getSite());
        wait = new WebDriverWait(driver, 25000);

        try {
            WebElement inputLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_username")));
            inputLogin.clear();
            inputLogin.sendKeys(inputUsuario.getText());

            WebElement inputSenha = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("login_password")));
            inputSenha.clear();
            inputSenha.sendKeys(inputPassword.getText());

            WebElement btnAcessar = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login\"]/div[4]/input")));
            btnAcessar.click();

            WebElement btnMateria = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"label_3_16\"]")));
            btnMateria.click();

            WebElement btnAbrirDoc = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"module-27357\"]/div/div/div[2]/div/a/span")));
            btnAbrirDoc.click();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
//            driver.quit();
        }
    }
}
