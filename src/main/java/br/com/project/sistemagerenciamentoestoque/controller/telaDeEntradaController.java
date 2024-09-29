package br.com.project.sistemagerenciamentoestoque.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.stage.Stage;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class telaDeEntradaController implements Initializable {

    @FXML
    private Hyperlink hyperlinkDesenvolvido;
    @FXML
    private Button btnEntrar;
    @FXML
    private Button btnSair;
    @FXML
    private TextField textFieldUsuario;
    @FXML
    private TextField textFieldSenha;

    private Scene scene;
    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void showCadastroUserDialog() throws SQLException, IOException {
        loginController cadastro = new loginController();
        cadastro.setStage(stage);
        cadastro.showCadastroUserDialog();
    }

    @FXML
    public void hyperlinkDesenvolvido() throws URISyntaxException, IOException {
        String[] urls = {
            "https://github.com/CassioVSouza",
            "https://github.com/gustavorieg",
            "https://github.com/Tobias-Fermiano"
        };

        for (String url : urls){
            Desktop.getDesktop().browse(new URI(url));
        }
    }

    @FXML
    protected void entrarTelaPrincipal(ActionEvent event) throws IOException {
        URL url = new File("src/main/java/br/com/project/sistemagerenciamentoestoque/view/telaPrincipal.fxml").toURI().toURL();
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage newStage = new Stage();
        newStage.setScene(scene);
        newStage.setTitle("Gerenciamento de Estoque");
        newStage.setResizable(false);
        newStage.setScene(scene);

        telaPrincipalController controller = loader.getController();
        controller.setStage(newStage);

        newStage.show();
        stage.close();
    }

    @FXML
    public void sairTelaDeEntrada(){
        if(stage != null){
            this.stage.close();
        }
    }

}
