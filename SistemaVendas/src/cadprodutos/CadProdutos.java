/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cadprodutos;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Márcio
 */
public class CadProdutos extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("cadproduto.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("Cadastro de Produtos");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    
}
