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
    private String pizza;//TODO: String nome_pizza e String borda pizza
    private String borda;
    private String[] acompanhamentos; //TODO: String acompanhamento
    private String obs;
    private Random rd;
    private double valor_total;

    public Pedido() {
        
        rd = new Random();
        id = rd.nextInt(99999); //gera um ID aleatório
        
        valor_total = 0.0;
        acompanhamentos = new String[3];
    }
    
    
    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }


    
    public void fazerPedido(String nome_cliente, Pizza pizza, Acompanhamento acomp1, Acompanhamento acomp2, Acompanhamento acomp3, String obs){
        this.nome_cliente = nome_cliente;
        this.pizza = pizza.getNome();
        this.borda = pizza.getBorda().getNome();
        acompanhamentos[0] = "Nenhum";
        acompanhamentos[1] = "Nenhum";
        acompanhamentos[2] = "Nenhum";
        this.obs = obs;
        
        
        valor_total+=pizza.getPreco();
        if(!pizza.getBorda().getNome().equals("Sem Recheio")){
            valor_total+=10.0;
        }
        if(acomp1!=null){
            acompanhamentos[0] = acomp1.getNome();
            valor_total+=acomp1.getPreco();
        }
        if(acomp2!=null){
            acompanhamentos[1] = acomp2.getNome();
            valor_total+=acomp2.getPreco();
        }
        if(acomp3!=null){
            acompanhamentos[2] = acomp3.getNome();
            valor_total+=acomp3.getPreco();
        }
        
        
    }
    
    
}
