/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Vitor
 */
public class Pizza extends Produto{
    
    private ArrayList<Ingrediente> ingredientes;
    private Ingrediente borda_recheada;
    
    public Pizza(String nome, double preco){
        
        super(preco, nome);
        ingredientes = new ArrayList<>();
        borda_recheada = null;
    }
    
    public boolean temBordaRecheada(){
        
        return borda_recheada != null;
    }
    
    public void setIngrediente(Ingrediente ing){
        ingredientes.add(ing);
    }
    
    public Ingrediente getIngrediente(int ind){
        return ingredientes.get(ind);
    }

    public Ingrediente getBorda_recheada() {
        return borda_recheada;
    }

    public void setBorda_recheada(Ingrediente borda_recheada) {
        this.borda_recheada = borda_recheada;
    }
    
    
    
    
    
    
}
