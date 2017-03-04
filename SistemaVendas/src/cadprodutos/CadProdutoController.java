/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadprodutos;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToolBar;

/**
 * FXML Controller class
 *
 * @author Márcio
 */
public class CadProdutoController implements Initializable {

    @FXML
    private TabPane painelPrincipal;
    @FXML
    private Tab tabProdutos;
    @FXML
    private TableColumn<?, ?> colCodigo;
    @FXML
    private TableColumn<?, ?> colDescricao;
    @FXML
    private TableColumn<?, ?> colMarca;
    @FXML
    private TableColumn<?, ?> colSubGrupo;
    @FXML
    private TableColumn<?, ?> ColPrecoVista;
    @FXML
    private TableColumn<?, ?> colPrecoPrazo;
    @FXML
    private Tab tabEditar;
    @FXML
    private ToolBar tbControle;
    @FXML
    private Button btnPrimeiro;
    @FXML
    private Button btnAnterior;
    @FXML
    private Button btnProximo;
    @FXML
    private Button btnUltimo;
    @FXML
    private Button btnNovo;
    @FXML
    private Button btnEditar;
    @FXML
    private Button btnSalvar;
    @FXML
    private Button btnExcluir;
    @FXML
    private Button btnSair;
    @FXML
    private TableView<?> tabelaProdutos;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void actionBtnPrimeiro(ActionEvent event) {
    }

    @FXML
    private void actionBtnAnterior(ActionEvent event) {
    }

    @FXML
    private void actionBtnProximo(ActionEvent event) {
    }

    @FXML
    private void actionBtnUltimo(ActionEvent event) {
    }

    @FXML
    private void actionBtnNovo(ActionEvent event) {
    }

    @FXML
    private void actionBtnEditar(ActionEvent event) {
    }

    @FXML
    private void actionBtnSalvar(ActionEvent event) {
    }

    @FXML
    private void actionBtnExcluir(ActionEvent event) {
    }

    @FXML
    private void actionBtnSair(ActionEvent event) {
    }
    
}
