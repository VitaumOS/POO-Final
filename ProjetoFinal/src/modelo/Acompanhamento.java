/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Classe que representa um acompanhamento que pode ser adicionado a um pedido.
 * Herda de Produto, fornecendo funcionalidades básicas de nome e preço.
 * Acompanhamentos são itens opcionais que complementam a pizza principal.
 * 
 * @author Vitor
 */
public class Acompanhamento extends Produto {
   
    /**
     * Construtor da classe Acompanhamento.
     * Cria um novo acompanhamento com nome e preço especificados.
     * 
     * @param nome Nome do acompanhamento
     * @param preco Preço do acompanhamento
     */
    public Acompanhamento(String nome, double preco) {

        super(preco, nome);
    }
    
}
