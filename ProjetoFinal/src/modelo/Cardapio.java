/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 * Representa o cardápio de uma pizzaria, contendo pizzas, acompanhamentos e bordas.
 *
 * @author Vitor
 */
public class Cardapio {
    /** Lista de pizzas disponíveis no cardápio. */
    private ArrayList<Pizza> cardapioPizzas;
    /** Lista de acompanhamentos disponíveis no cardápio. */
    private ArrayList<Acompanhamento> acompanhamentos;
    /** Lista de bordas de pizza disponíveis no cardápio. */
    private ArrayList<BordaPizza> bordas;
    
    /**
     * Construtor padrão. Inicializa as listas de pizzas, acompanhamentos e bordas.
     */
    public Cardapio(){
        cardapioPizzas = new ArrayList<>();
        acompanhamentos = new ArrayList<>();
        bordas = new ArrayList<>();
    }
    
    /**
     * Construtor que copia os itens de outro cardápio e adiciona ingredientes às pizzas.
     * @param cardapio Cardápio a ser copiado.
     */
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
    
    /**
     * Adiciona uma pizza ao cardápio.
     * @param p Pizza a ser adicionada.
     */
    public void addPizza(Pizza p){
        cardapioPizzas.add(p);
    }
    
    /**
     * Adiciona um acompanhamento ao cardápio.
     * @param a Acompanhamento a ser adicionada.
     */
    public void addAcompanhamento(Acompanhamento a){
        acompanhamentos.add(a);
    }
    
    /**
     * Adiciona uma borda de pizza ao cardápio.
     * @param b Borda de pizza a ser adicionada.
     */
    public void addBorda(BordaPizza b){
        bordas.add(b);
    }
    
    /**
     * Retorna a pizza do cardápio pelo índice.
     * @param index Índice da pizza.
     * @return Pizza correspondente ao índice.
     */
    public Pizza getCardapio_pizzas(int index) {
        return cardapioPizzas.get(index);
    }

    /**
     * Retorna a quantidade de pizzas no cardápio.
     * @return Quantidade de pizzas.
     */
    public int getQuantPizza(){
        return cardapioPizzas.size();
    }
    
    /**
     * Retorna o acompanhamento pelo índice.
     * @param index Índice do acompanhamento.
     * @return Acompanhamento correspondente ao índice ou null se índice for -1.
     */
    public Acompanhamento getAcompanhamentos(int index){
        if(index==-1)
            return null;
        return acompanhamentos.get(index);
    }
    
    /**
     * Retorna a quantidade de acompanhamentos no cardápio.
     * @return Quantidade de acompanhamentos.
     */
    public int getQuantAcompanhamentos(){
        return acompanhamentos.size();
    }

    /**
     * Retorna a borda de pizza pelo índice.
     * @param index Índice da borda.
     * @return Borda de pizza correspondente ao índice.
     */
    public BordaPizza getBordaPizza(int index){
        return bordas.get(index);
    }

    /**
     * Retorna a quantidade de bordas de pizza no cardápio.
     * @return Quantidade de bordas de pizza.
     */
    public int getQuantBordaPizza(){
        return bordas.size();
    }
}
