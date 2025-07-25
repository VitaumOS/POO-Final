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
public class Cardapio {
    private ArrayList<Pizza> cardapioPizzas;
    private ArrayList<Acompanhamento> acompanhamentos;
    private ArrayList<BordaPizza> bordas;
    
    public Cardapio(){
        cardapioPizzas = new ArrayList<>();
        acompanhamentos = new ArrayList<>();
        bordas = new ArrayList<>();
    }
    
    public Cardapio(Cardapio cardapio){
        this.cardapioPizzas = cardapio.cardapioPizzas;
        this.acompanhamentos = cardapio.acompanhamentos;
        this.bordas = cardapio.bordas;
        
        Ingrediente ing1 = new Ingrediente("Calabresa");
        Ingrediente ing2 = new Ingrediente("Mussarela");
        Ingrediente ing3 = new Ingrediente("Frango");
        Ingrediente ing4 = new Ingrediente("Catupiry");
        Ingrediente ing5 = new Ingrediente("Presunto");
        Ingrediente ing6 = new Ingrediente("Ovo");
        Ingrediente ing7 = new Ingrediente("Cebola");
        Ingrediente ing8 = new Ingrediente("Azeitona");
        Ingrediente ing9 = new Ingrediente("Parmesão");
        Ingrediente ing10 = new Ingrediente("Provolone");
        Ingrediente ing11 = new Ingrediente("Gorgonzola");
        Ingrediente ing12 = new Ingrediente("Tomate");
        Ingrediente ing13 = new Ingrediente("Pimentão");
        Ingrediente ing14 = new Ingrediente("Milho");
        Ingrediente ing15 = new Ingrediente("Orégano");
        
        cardapioPizzas.get(0).setIngrediente(ing1); 
        cardapioPizzas.get(0).setIngrediente(ing2); 
        cardapioPizzas.get(0).setIngrediente(ing7); 
        cardapioPizzas.get(0).setIngrediente(ing8);  
        cardapioPizzas.get(0).setIngrediente(ing15); 

        cardapioPizzas.get(1).setIngrediente(ing2);  
        cardapioPizzas.get(1).setIngrediente(ing12); 
        cardapioPizzas.get(1).setIngrediente(ing15); 

        cardapioPizzas.get(2).setIngrediente(ing3); 
        cardapioPizzas.get(2).setIngrediente(ing4); 
        cardapioPizzas.get(2).setIngrediente(ing14); 
        cardapioPizzas.get(2).setIngrediente(ing2);  
        cardapioPizzas.get(2).setIngrediente(ing15); 

        cardapioPizzas.get(3).setIngrediente(ing5);  
        cardapioPizzas.get(3).setIngrediente(ing6);  
        cardapioPizzas.get(3).setIngrediente(ing7);  
        cardapioPizzas.get(3).setIngrediente(ing8);  
        cardapioPizzas.get(3).setIngrediente(ing2);  
        cardapioPizzas.get(3).setIngrediente(ing15); 

        cardapioPizzas.get(4).setIngrediente(ing2);  
        cardapioPizzas.get(4).setIngrediente(ing9);  
        cardapioPizzas.get(4).setIngrediente(ing10); 
        cardapioPizzas.get(4).setIngrediente(ing11); 
        cardapioPizzas.get(4).setIngrediente(ing15); 
  
        cardapioPizzas.get(5).setIngrediente(ing12); 
        cardapioPizzas.get(5).setIngrediente(ing7); 
        cardapioPizzas.get(5).setIngrediente(ing13); 
        cardapioPizzas.get(5).setIngrediente(ing14); 
        cardapioPizzas.get(5).setIngrediente(ing8);  
        cardapioPizzas.get(5).setIngrediente(ing15);
    }
    
    public void addPizza(Pizza p){
        cardapioPizzas.add(p);
    }
    
    public void addAcompanhamento(Acompanhamento a){
        acompanhamentos.add(a);
    }
    
    public void addBorda(BordaPizza b){
        bordas.add(b);
    }
    
    public Pizza getCardapio_pizzas(int index) {
        return cardapioPizzas.get(index);
    }
    public int getQuantPizza(){
        
        return cardapioPizzas.size();
    }
    
    public Acompanhamento getAcompanhamentos(int index){
        if(index==-1)
            return null;
        return acompanhamentos.get(index);
    }
    
    public int getQuantAcompanhamentos(){
        return acompanhamentos.size();
    }
    public BordaPizza getBordaPizza(int index){
        return bordas.get(index);
    }
    public int getQuantBordaPizza(){
        return bordas.size();
    }
}
