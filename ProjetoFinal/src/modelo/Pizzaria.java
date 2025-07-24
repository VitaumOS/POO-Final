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
    private ArrayList<Acompanhamento> acompanhamentos;
    private ArrayList<BordaPizza> bordas;
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
        
        est_ing.addIngrediente(ing1, 40);
        est_ing.addIngrediente(ing2, 100);
        est_ing.addIngrediente(ing3, 35);
        est_ing.addIngrediente(ing4, 30);
        est_ing.addIngrediente(ing5, 25);
        est_ing.addIngrediente(ing6, 20);
        est_ing.addIngrediente(ing7, 40);
        est_ing.addIngrediente(ing8, 40);
        est_ing.addIngrediente(ing9, 15);
        est_ing.addIngrediente(ing10, 15);
        est_ing.addIngrediente(ing11, 15);
        est_ing.addIngrediente(ing12, 30);
        est_ing.addIngrediente(ing13, 25);
        est_ing.addIngrediente(ing14, 35);
        est_ing.addIngrediente(ing15, 100);

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

        Acompanhamento acomp1 = new Acompanhamento("Coca-Cola", 10.0);
        Acompanhamento acomp2 = new Acompanhamento("Guaraná", 9.0);
        Acompanhamento acomp3 = new Acompanhamento("Fanta Laranja", 9.0);
        Acompanhamento acomp4 = new Acompanhamento("Água Mineral", 5.0);
        Acompanhamento acomp5 = new Acompanhamento("Suco de Laranja", 8.0);
        Acompanhamento acomp6 = new Acompanhamento("Suco de Uva", 8.5);
        Acompanhamento acomp7 = new Acompanhamento("Refrigerante 2L", 12.0);
        Acompanhamento acomp8 = new Acompanhamento("Batata Frita", 15.0);
        Acompanhamento acomp9 = new Acompanhamento("Nuggets", 14.0);

        acompanhamentos = new ArrayList<>();
        
        acompanhamentos.add(acomp1);
        acompanhamentos.add(acomp2);
        acompanhamentos.add(acomp3);
        acompanhamentos.add(acomp4);
        acompanhamentos.add(acomp5);
        acompanhamentos.add(acomp6);
        acompanhamentos.add(acomp7);
        acompanhamentos.add(acomp8);
        acompanhamentos.add(acomp9);
        
        BordaPizza b1 = new BordaPizza("Recheada com Cheddar");
        BordaPizza b2 = new BordaPizza("Recheada com Catupiry");
        BordaPizza b3 = new BordaPizza("Recheada com Chocolate");
        BordaPizza b4 = new BordaPizza("Recheada com Cream Cheese");
        BordaPizza b5 = new BordaPizza("Borda Crocante com Alho");
        
        bordas = new ArrayList<>();
        
        bordas.add(b1);
        bordas.add(b2);
        bordas.add(b3);
        bordas.add(b4);
        bordas.add(b5);



    }

    public Pizza getCardapio_pizzas(int index) {
        return cardapio_pizzas.get(index);
    }

    public EstoqueIngredientes getEstoqueIngredientes() {
        return est_ing;
    }
    
    public int getQuantPizza(){
        
        return cardapio_pizzas.size();
    }
    
    public Acompanhamento getAcompanhamentos(int index){
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
