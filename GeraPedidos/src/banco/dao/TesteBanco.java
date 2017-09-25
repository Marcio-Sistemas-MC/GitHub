/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco.dao;

import banco.novo.Clientes;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Paulo
 */
public class TesteBanco {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("geraPedidosPU");
        ClientesJpaController daoCliente = new ClientesJpaController(emf);
        Clientes c = daoCliente.findClientes(3);
        System.out.println("Nome: " + c.getCpf());
    }

}
