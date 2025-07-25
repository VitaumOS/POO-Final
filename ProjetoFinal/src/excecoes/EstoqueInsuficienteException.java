/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excecoes;

/**
 * Exceção lançada quando não há quantidade suficiente de um ingrediente no estoque.
 * 
 * Esta exceção deve ser utilizada para sinalizar situações em que uma operação
 * requer mais unidades de um ingrediente do que o disponível.
 * 
 * @author Vitor
 * @see Exception
 */
public class EstoqueInsuficienteException extends Exception{
    
    public EstoqueInsuficienteException(String ingrediente){
        
        super(ingrediente + " insuficiente!");
    }
}
