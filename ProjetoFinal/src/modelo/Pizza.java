/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Vitor
 */
public class Pizza extends Produto{
    
    private Ingredientes[] ingredientes;
    
    public Pizza(String nome, double preco){
        
        super(preco, nome);
    }
}
