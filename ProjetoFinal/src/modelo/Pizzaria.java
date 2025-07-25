/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import dao.CardapioDAO;
import dao.IngredienteDAO;
import java.util.ArrayList;
import services.GerenciadorDiario;
import services.GerenciadorEstoque;

/**
 *
 * @author Vitor
 */
public class Pizzaria {
    
    Cardapio cardapio;
    private HistoricoPedido historicopedido;
    private EstoqueIngredientes estoque;

    private GerenciadorEstoque gerenciadorEstoque;
    private GerenciadorDiario gerenciadorDiario;

    public Pizzaria(){
        CardapioDAO cardapioDAO = new CardapioDAO();
        cardapio = new Cardapio(cardapioDAO.carregar());
  
        IngredienteDAO ingDAO = new IngredienteDAO("src\\resources\\ingredientes.csv");
        estoque = new EstoqueIngredientes(ingDAO.carregar());

        historicopedido = new HistoricoPedido();
        
        
        estoque = new EstoqueIngredientes();

        String caminhoIngredientes = "src\\resources\\ingredientes.csv";
        String caminhoDiario = "src\\resources\\diarioPizzaria.csv";

        this.gerenciadorEstoque = new GerenciadorEstoque(caminhoIngredientes, estoque);
        this.gerenciadorDiario = new GerenciadorDiario(caminhoDiario);

        gerenciadorEstoque.carregarEstoque();
        gerenciadorDiario.carregarHistorico();
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

    public GerenciadorEstoque getGerenciadorEstoque() {
        return gerenciadorEstoque;
    }

    public GerenciadorDiario getGerenciadorDiario() {
        return gerenciadorDiario;
    }

    public boolean salvarEstoque() {
        return gerenciadorEstoque.salvarEstoque();
    }

    public boolean registrarPedidoDiario(Pedido pedido) {
        return gerenciadorDiario.registrarPedido(pedido);
    }
}
