/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 *
 * @author Marcio
 *
 */
public class Notificacao {
    private String titulo;
    private String mensagem;
    private AlertType tipo;

    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public Notificacao(String titulo, String mensagem, AlertType tipo) {
        this.titulo = titulo;
        this.mensagem = mensagem;
        this.tipo = tipo;
    }
    
    public void notificar() {
        Alert a = new Alert(tipo);
        a.setContentText(mensagem);
        a.setHeaderText(titulo);
        a.showAndWait();
    }

    public AlertType getTipo() {
        return tipo;
    }

    public void setTipo(AlertType tipo) {
        this.tipo = tipo;
    }
    
    
    
}
