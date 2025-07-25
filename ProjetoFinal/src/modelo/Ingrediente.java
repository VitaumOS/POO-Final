/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Representa um ingrediente utilizado em pizzas.
 * @author Vitor
 */
public class Ingrediente {
    
    /** Nome do ingrediente. */
    private String nome;
    
    /**
     * Cria um novo ingrediente com o nome especificado.
     * @param nome Nome do ingrediente.
     */
    public Ingrediente(String nome){
        this.nome = nome;
    }

    /**
     * Retorna o nome do ingrediente.
     * @return nome do ingrediente.
     */
    public String getNome() {
        return nome;
    }
}
