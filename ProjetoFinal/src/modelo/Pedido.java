/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Vitor
 */
public class Pedido {
    
    private String nome_cliente;
    private int id;
    private Pizza pizza;
    private ArrayList<Acompanhamento> acompanhamentos;
    private Random rd;

    public Pedido() {
        
        rd = new Random();
        id = rd.nextInt(99999); //gera um ID aleatório
        
        acompanhamentos = new ArrayList<>();
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }
    
    public int getSizeAcompanhamentos(){
        return acompanhamentos.size();
    }
    
    public Acompanhamento getAcompanhamentos(int i){
        return acompanhamentos.get(id);
    }
    
    
    
    
}
