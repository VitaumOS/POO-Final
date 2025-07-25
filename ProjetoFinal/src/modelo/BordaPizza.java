/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * Representa uma borda de pizza.
 * Cada borda possui um nome que a identifica.
 *
 * @author Vitor
 */
public class BordaPizza {
    
    /** Nome da borda da pizza. */
    private String nome;

    /**
     * Cria uma nova borda de pizza com o nome especificado.
     * @param nome Nome da borda.
     */
    public BordaPizza(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o nome da borda da pizza.
     * @return nome da borda.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da borda da pizza.
     * @param nome Novo nome da borda.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}
