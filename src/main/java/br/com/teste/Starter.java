package br.com.teste;

import br.com.teste.util.ViewTeste;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Starter extends Application {

    private static Stage stage;
    private static Parent root;

    public Starter() {
        try {
            root = FXMLLoader.load(getClass().getResource(ViewTeste.FERRAMENTA));
        } catch (Exception e) {
            System.err.println("Erro");
//            MessageBox.addError("Erro", "Ops, ocorreu um erro inesperado.",
//                    "Por favor, contate o administrador da ferramenta para a resolução!\nErro: "
//                            + e.getLocalizedMessage());
            throw new RuntimeException();
        }
    }

    public void start(Stage primaryStage) throws Exception {
        Scene scene = new Scene(root);
        primaryStage.setTitle("Teste");
        primaryStage.setScene(scene);
//        primaryStage.getIcons().add(new Image("img/logoDesk.png"));
        primaryStage.setResizable(false);
        stage = primaryStage;
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
