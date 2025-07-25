/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excecoes;

/**
 *
 * @author Vitor
 */
public class FaltouColocarNomeException extends Exception {
    
    public FaltouColocarNomeException(){
        super("Erro! Você esqueceu de colocar o nome");
    }
}
