/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 * Classe responsável por armazenar os pedidos do dia.
 * Permite adicionar, acessar e modificar a lista de pedidos realizados.
 * 
 * @author Vitor
 */
public class HistoricoPedido {
    
    /** Lista de pedidos realizados no dia. */
    private ArrayList<Pedido> pedidos; 
    
    /**
     * Construtor padrão. Inicializa a lista de pedidos.
     */
    public HistoricoPedido() {
        this.pedidos = new ArrayList<>();
    }
    
    /**
     * Adiciona um pedido ao histórico.
     * @param pedido Pedido a ser adicionado.
     */
    public void adicionarPedido(Pedido pedido) {
        if (pedido != null) {
            pedidos.add(pedido);
        }
    }
    
    /**
     * Retorna o pedido pelo índice.
     * @param index Índice do pedido.
     * @return Pedido correspondente ao índice.
     */
    public Pedido getPedidos(int index) {
        return pedidos.get(index);
    }

    /**
     * Define a lista de pedidos.
     * @param pedidos Nova lista de pedidos.
     */
    public void setPedidos(ArrayList<Pedido> pedidos) {
        this.pedidos = pedidos;
    }
    
    /**
     * Retorna a quantidade de pedidos realizados.
     * @return Quantidade de pedidos.
     */
    public int getQuantPedidos(){
        return pedidos.size();
    }
    
}
