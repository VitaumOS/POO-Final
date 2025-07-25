/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.Random;

/**
 *
 * @author Vitor
 */
public class Pedido {
    
    private String nomeCliente;
    private int id;
    private String pizza;//TODO: String nome_pizza e String borda pizza
    private String borda;
    private String[] acompanhamentos; //TODO: String acompanhamento
    private String obs;
    private Random rd;
    private double valorTotal;

    public Pedido() {
        
        rd = new Random();
        id = rd.nextInt(99999); //gera um ID aleatório
        
        valorTotal = 0.0;
        acompanhamentos = new String[3];
    }
    
    public void fazerPedido(String nome_cliente, Pizza pizza, Acompanhamento acomp1, Acompanhamento acomp2, Acompanhamento acomp3, String obs){
        this.nomeCliente = nome_cliente;
        this.pizza = pizza.getNome();
        this.borda = pizza.getBorda().getNome();
        acompanhamentos[0] = "Nenhum";
        acompanhamentos[1] = "Nenhum";
        acompanhamentos[2] = "Nenhum";
        this.obs = obs;
        
        
        valorTotal+=pizza.getPreco();
        if(!pizza.getBorda().getNome().equals("Sem Recheio")){
            valorTotal+=10.0;
        }
        if(acomp1!=null){
            acompanhamentos[0] = acomp1.getNome();
            valorTotal+=acomp1.getPreco();
        }
        if(acomp2!=null){
            acompanhamentos[1] = acomp2.getNome();
            valorTotal+=acomp2.getPreco();
        }
        if(acomp3!=null){
            acompanhamentos[2] = acomp3.getNome();
            valorTotal+=acomp3.getPreco();
        }
        
        
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    
    public int getId() {
        return id;
    }

    public String getPizza() {
        return pizza;
    }

    public String getBorda() {
        return borda;
    }

    public String getAcompanhamentos(int index) {
        return acompanhamentos[index];
    }

    public String getObs() {
        return obs;
    }

    
    public double getValorTotal() {
        return valorTotal;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

}



    