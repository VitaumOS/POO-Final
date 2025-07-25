/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Classe pai de todos os demais produtos.
 * Define os atributos básicos de um produto: nome e preço.
 *
 * @author Vitor
 */
public abstract class Produto {
    
    /** Nome do produto. */
    protected String nome;
    /** Preço do produto. */
    protected double preco;

    /**
     * Construtor da classe Produto.
     * @param preco Preço do produto.
     * @param nome Nome do produto.
     */
    public Produto(double preco, String nome) {
        this.preco = preco;
        this.nome = nome;
    }

    /**
     * Retorna o preço do produto.
     * @return Preço do produto.
     */
    public double getPreco() {
        return preco;
    }

    /**
     * Define o preço do produto.
     * @param preco Novo preço do produto.
     */
    public void setPreco(double preco) {
        this.preco = preco;
    }

    /**
     * Retorna o nome do produto.
     * @return Nome do produto.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do produto.
     * @param nome Novo nome do produto.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}
