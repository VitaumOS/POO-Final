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
    
    private ArrayList<Pizza> cardapioPizzas;
    private ArrayList<Acompanhamento> acompanhamentos;
    private ArrayList<BordaPizza> bordas;
    private HistoricoPedido historicopedido;
    private EstoqueIngredientes estoque;
    
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
        
        estoque = new EstoqueIngredientes();
        
        estoque.addIngrediente(ing1, 40);
        estoque.addIngrediente(ing2, 100);
        estoque.addIngrediente(ing3, 35);
        estoque.addIngrediente(ing4, 30);
        estoque.addIngrediente(ing5, 25);
        estoque.addIngrediente(ing6, 20);
        estoque.addIngrediente(ing7, 40);
        estoque.addIngrediente(ing8, 40);
        estoque.addIngrediente(ing9, 15);
        estoque.addIngrediente(ing10, 15);
        estoque.addIngrediente(ing11, 15);
        estoque.addIngrediente(ing12, 30);
        estoque.addIngrediente(ing13, 25);
        estoque.addIngrediente(ing14, 35);
        estoque.addIngrediente(ing15, 100);

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
        
        cardapioPizzas = new ArrayList<>();
        cardapioPizzas.add(pizza1);
        cardapioPizzas.add(pizza2);
        cardapioPizzas.add(pizza3);
        cardapioPizzas.add(pizza4);
        cardapioPizzas.add(pizza5);
        cardapioPizzas.add(pizza6);

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
        
        historicopedido = new HistoricoPedido();

    }

    public Pizza getCardapio_pizzas(int index) {
        return cardapioPizzas.get(index);
    }

    public EstoqueIngredientes getEstoque() {
        return estoque;
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
    
    public void adicionarPedidoAoHistorico(Pedido pedido) {
        historicopedido.adicionarPedido(pedido);
    }
    
    public HistoricoPedido getHistoricoPedido() {
        return historicopedido;
    }
}
