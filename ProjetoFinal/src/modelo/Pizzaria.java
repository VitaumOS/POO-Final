/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import dao.CardapioDAO;
import dao.IngredienteDAO;
import java.util.ArrayList;

/**
 *
 * @author Vitor
 */
public class Pizzaria {
    
    Cardapio cardapio;
    private HistoricoPedido historicopedido;
    private EstoqueIngredientes estoque;
    
    public Pizzaria(){
        CardapioDAO cardapioDAO = new CardapioDAO();
        cardapio = new Cardapio(cardapioDAO.carregar());
  
        IngredienteDAO ingDAO = new IngredienteDAO("src\\resources\\ingredientes.csv");
        estoque = new EstoqueIngredientes(ingDAO.carregar());

        historicopedido = new HistoricoPedido();

    }


    public Cardapio getCardapio(){
        return cardapio;
    }
    public EstoqueIngredientes getEstoque() {
        return estoque;
    }
    public void adicionarPedidoAoHistorico(Pedido pedido) {
        historicopedido.adicionarPedido(pedido);
    }
    
    public HistoricoPedido getHistoricoPedido() {
        return historicopedido;
    }
    
    public String converteDoubleReais(double valor){
        return "R$"+valor+"0";
    }
}
