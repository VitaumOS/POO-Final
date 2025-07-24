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
public class Pizzaria {
    
    private ArrayList<Pizza> cardapio_pizzas;
    private EstoqueIngredientes est_ing;
    
    public Pizzaria(){
        
        Pizza pizza1 = new Pizza("Pizza de Calabresa", 30.0);
        Pizza pizza2 = new Pizza("Pizza de Mussarela", 28.0);
        Pizza pizza3 = new Pizza("Pizza de Frango com Catupiry", 32.0);
        Pizza pizza4 = new Pizza("Pizza Portuguesa", 35.0);
        Pizza pizza5 = new Pizza("Pizza Quatro Queijos", 34.0);
        Pizza pizza6 = new Pizza("Pizza Vegetariana", 29.0);
        
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
        
        est_ing = new EstoqueIngredientes();
        
        est_ing.setIngrediente(ing1, 40);
        est_ing.setIngrediente(ing2, 100);
        est_ing.setIngrediente(ing3, 35);
        est_ing.setIngrediente(ing4, 30);
        est_ing.setIngrediente(ing5, 25);
        est_ing.setIngrediente(ing6, 20);
        est_ing.setIngrediente(ing7, 40);
        est_ing.setIngrediente(ing8, 40);
        est_ing.setIngrediente(ing9, 15);
        est_ing.setIngrediente(ing10, 15);
        est_ing.setIngrediente(ing11, 15);
        est_ing.setIngrediente(ing12, 30);
        est_ing.setIngrediente(ing13, 25);
        est_ing.setIngrediente(ing14, 35);
        est_ing.setIngrediente(ing15, 100);

        pizza1.setIngrediente(ing1); 
        pizza1.setIngrediente(ing2); 
        pizza1.setIngrediente(ing7); 
        pizza1.setIngrediente(ing8);  
        pizza1.setIngrediente(ing15); 

        pizza2.setIngrediente(ing2);  
        pizza2.setIngrediente(ing12); 
        pizza2.setIngrediente(ing15); 


        pizza3.setIngrediente(ing3); 
        pizza3.setIngrediente(ing4); 
        pizza3.setIngrediente(ing14); 
        pizza3.setIngrediente(ing2);  
        pizza3.setIngrediente(ing15); 


        pizza4.setIngrediente(ing5);  
        pizza4.setIngrediente(ing6);  
        pizza4.setIngrediente(ing7);  
        pizza4.setIngrediente(ing8);  
        pizza4.setIngrediente(ing2);  
        pizza4.setIngrediente(ing15); 

        pizza5.setIngrediente(ing2);  
        pizza5.setIngrediente(ing9);  
        pizza5.setIngrediente(ing10); 
        pizza5.setIngrediente(ing11); 
        pizza5.setIngrediente(ing15); 
  
        pizza6.setIngrediente(ing12); 
        pizza6.setIngrediente(ing7); 
        pizza6.setIngrediente(ing13); 
        pizza6.setIngrediente(ing14); 
        pizza6.setIngrediente(ing8);  
        pizza6.setIngrediente(ing15); 
        
        cardapio_pizzas = new ArrayList<>();
        cardapio_pizzas.add(pizza1);
        cardapio_pizzas.add(pizza2);
        cardapio_pizzas.add(pizza3);
        cardapio_pizzas.add(pizza4);
        cardapio_pizzas.add(pizza5);
        cardapio_pizzas.add(pizza6);

     }
}
