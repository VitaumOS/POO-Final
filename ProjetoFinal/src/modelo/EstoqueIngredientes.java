/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.HashMap;

/**
 *
 * @author Vitor
 */
public class EstoqueIngredientes {
    
    private HashMap<Ingrediente, Integer> ingredientes;
    
    public EstoqueIngredientes(){
        ingredientes = new HashMap<>();
    }
    
    public void setIngrediente(Ingrediente ing, int quant){
        
        ingredientes.put(ing, quant);     
    }
    
    public int getQuantidade(Ingrediente ing){
        
        return ingredientes.get(ing).intValue();
    }
    
    public void pegarIngrediente(Ingrediente ing){
        if(ingredientes.get(ing).equals(0)){
            //LANÇAR EXCEÇÃO
        }
        else{
           Integer aux = ingredientes.get(ing)-1;
           ingredientes.put(ing, aux);
        }
    }
    
    
}
