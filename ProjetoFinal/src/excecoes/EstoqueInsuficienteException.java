/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excecoes;

/**
 *
 * @author Vitor
 */
public class EstoqueInsuficienteException extends Exception{
    
    public EstoqueInsuficienteException(String ingrediente){
        
        super(ingrediente + " insuficiente!");
    }
}
