/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excecoes;

/**
 * Exceção lançada quando não foi inserido o nome.
 * 
 * Esta exceção deve ser utilizada para sinalizar situações em que deve-se inserir o nome para finalizar o processo.
 * 
 * @author Vitor
 */
public class FaltouColocarNomeException extends Exception {
    
    public FaltouColocarNomeException(){
        super("Erro! Você esqueceu de colocar o nome");
    }
}
