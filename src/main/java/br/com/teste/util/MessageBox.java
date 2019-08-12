package br.com.teste.util;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Optional;

public class MessageBox {

    /**
     * Diálogo de confirmação.
     *
     * @param title  Titulo do diálogo.
     * @param header Cabeçalho do diálogo.
     * @param msg    Mensagem interna do diálogo.
     * @since 24 de Junho de 2016
     */
    public static Boolean addConfirm(String title, String header, String msg) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(msg);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    /**
     * Diálogo de confirmação.
     *
     * @param title  Titulo do diálogo.
     * @param header Mensagem interna do diálogo.
     * @since 07 de Julho de 2016
     */
    public static Boolean addConfirm(String title, String header) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);

        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            return Boolean.TRUE;
        } else {
            return Boolean.FALSE;
        }
    }

    /**
     * Diálogo de informação.
     *
     * @param title Titulo do diálogo.
     * @param msg   Mensagem interna do diálogo.
     * @since 24 de Junho de 2016
     */
    public static void addInfo(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);

        alert.showAndWait();
    }

    /**
     * Diálogo de informação com detalhes.
     *
     * @param title  Titulo do diálogo.
     * @param header Cabeçalho do diálogo.
     * @param msg    Mensagem interna do diálogo.
     * @since 24 de Junho de 2016
     */
    public static void addInfo(String title, String header, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(msg);

        alert.showAndWait();
    }

    /**
     * Diálogo de perigo.
     *
     * @param title Titulo do diálogo.
     * @param msg   Mensagem interna do diálogo.
     * @since 24 de Junho de 2016
     */
    public static void addWarm(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);

        alert.showAndWait();
    }

    /**
     * Diálogo de perigo com detalhes.
     *
     * @param title  Titulo do diálogo.
     * @param header Cabeçalho do diálogo.
     * @param msg    Mensagem interna do diálogo.
     * @since 24 de Junho de 2016
     */
    public static void addWarm(String title, String header, String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(msg);

        alert.showAndWait();
    }

    /**
     * Diálogo de erro.
     *
     * @param title Titulo do diálogo.
     * @param msg   Mensagem interna do diálogo.
     * @since 24 de Junho de 2016
     */
    public static void addError(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(msg);

        alert.showAndWait();
    }

    /**
     * Diálogo de erro com detalhes.
     *
     * @param title  Titulo do diálogo.
     * @param header Cabeçalho do diálogo.
     * @param msg    Mensagem interna do diálogo.
     * @since 24 de Junho de 2016
     */
    public static void addError(String title, String header, String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(msg);

        alert.showAndWait();
    }

    /**
     * Diálogo de erro com exceção.
     *
     * @param ex     Exceção gerada por uma classe concreta.
     * @param title  Titulo do diálogo.
     * @param header Cabeçalho do diálogo.
     * @param msg    Mensagem interna do diálogo.
     * @since 24 de Junho de 2016
     */
    public static void addError(Exception ex, String title, String header, String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(header);
        alert.setContentText(msg);

        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        ex.printStackTrace(pw);
        String exceptionText = sw.toString();

        Label label = new Label("O erro é:");

        TextArea textArea = new TextArea(exceptionText);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);

        alert.getDialogPane().setExpandableContent(expContent);
        alert.showAndWait();
    }
}
