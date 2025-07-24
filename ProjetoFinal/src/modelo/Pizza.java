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
    private BordaPizza borda;
    
    public Pizza(String nome, double preco){
        
        super(preco, nome);
        ingredientes = new ArrayList<>();
        borda = new BordaPizza("Sem Recheio");
    }
    
    public boolean temBordaRecheada(){
        
        return borda.getNome().equals("Sem Recheio");
    }
    
    public void setIngrediente(Ingrediente ing){
        ingredientes.add(ing);
    }
    
    public Ingrediente getIngrediente(int ind){
        return ingredientes.get(ind);
    }

    public BordaPizza getBorda() {
        return borda;
    }

    public void setBorda_recheada(BordaPizza borda_recheada) {
        this.borda = borda_recheada;
    }
    
    public int getQuantIngredientes(){
        
        return ingredientes.size();
    }
    
    
    
    
    
    
}
