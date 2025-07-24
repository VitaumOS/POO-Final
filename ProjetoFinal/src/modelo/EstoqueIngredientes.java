/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import excecoes.EstoqueInsuficienteException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Vitor
 */
public class EstoqueIngredientes {
    
    private HashMap<String, Integer> ingredientes;
    private ArrayList<Ingrediente> tipo_ingrediente;
    
    public EstoqueIngredientes(){
        ingredientes = new HashMap<>();
        tipo_ingrediente = new ArrayList<>();
    }
    
    public void addIngrediente(Ingrediente ing, int quant){
        Integer aux = quant;
        ingredientes.put(ing.getNome(), aux); 
        tipo_ingrediente.add(ing);
    }
    
    public int getQuantidade(String ing){
        
        return ingredientes.get(ing).intValue();
    }
    
    public void pegarIngrediente(Ingrediente ing) throws EstoqueInsuficienteException{
        String nome = ing.getNome();
        Integer quant = ingredientes.get(nome);
        
        if(quant == 0){
            throw new EstoqueInsuficienteException(nome);
        }
        else{
           ingredientes.put(nome, quant - 1);
        }
    }
    
    public int getQuantIngredientes(){
        return ingredientes.size();
    }
    
    public String pegarNomeIngredientes(int index){
        return tipo_ingrediente.get(index).getNome();
    }

    public void reporEstoqueIngredientes(Ingrediente ingrediente, int quantidade){
        addIngrediente(ingrediente, quantidade);
    }
    
}
