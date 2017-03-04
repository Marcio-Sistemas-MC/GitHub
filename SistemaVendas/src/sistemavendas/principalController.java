/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistemavendas;

import cadprodutos.CadProdutos;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;
import util.Notificacao;

/**
 *
 * @author Márcio
 */
public class principalController implements Initializable {

    @FXML
    private MenuItem mnProdutos;
    @FXML
    private MenuItem mnMarcas;
    @FXML
    private MenuItem mnGrupos;
    @FXML
    private MenuItem mnSubGrupos;
    @FXML
    private MenuItem mnVendas;
    @FXML
    private MenuItem mnSobre;
    @FXML
    private MenuItem mnAjuda;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void actionMNProdutos(ActionEvent event) throws Exception {
        //new Notificacao("Atenção:","Recurco não implementado!!!", AlertType.INFORMATION).notificar();
        new CadProdutos().start(new Stage());
    }

    @FXML
    private void actionMnMarcas(ActionEvent event) {
        new Notificacao("Atenção:","Recurco não implementado!!!", AlertType.INFORMATION).notificar();
    }

    @FXML
    private void actionMnGrupos(ActionEvent event) {
        new Notificacao("Atenção:","Recurco não implementado!!!", AlertType.INFORMATION).notificar();
    }

    @FXML
    private void actionMnSubGrupos(ActionEvent event) {
        new Notificacao("Atenção:","Recurco não implementado!!!", AlertType.INFORMATION).notificar();
    }

    @FXML
    private void actionMnVendas(ActionEvent event) {
        new Notificacao("Atenção:","Recurco não implementado!!!", AlertType.INFORMATION).notificar();
    }

    @FXML
    private void actionMnSobre(ActionEvent event) {
        new Notificacao("Atenção:","Recurco não implementado!!!", AlertType.INFORMATION).notificar();
    }

    @FXML
    private void actionMnAjuda(ActionEvent event) {
        new Notificacao("Atenção:","Recurco não implementado!!!", AlertType.INFORMATION).notificar();
    }
    
}
