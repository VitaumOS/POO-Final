/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import excecoes.FaltouColocarNomeException;
import java.util.Random;

/**
 * Classe responsável por registrar o pedido do cliente 
 * @author Vitor
 */
public class Pedido {
    private int id;
    private String nomeCliente;
    private String pizza;
    private String borda;
    private String[] acompanhamentos;
    private String obs;
    private double valorTotal;

    /**
     * Construtor da classe Pedido
     * Cria um número aleatório para ser a identificação do pedido e um array com três posições para selecionar os acompanhamentos
     */
    public Pedido() {
        
        Random rd = new Random();
        id = rd.nextInt(99999); //gera um ID aleatório
        
        valorTotal = 0.0;
        acompanhamentos = new String[3];
    }
    
    /**
     * Registra o pedido realizado e contabiliza cada item selecionado calculando o valor total
     * 
     * @param nome_cliente Nome do cliente que está fazendo o pedido
     * @param pizza Objeto Pizza selecionada pelo cliente
     * @param acomp1 Primeiro acompanhamento (pode ser null)
     * @param acomp2 Segundo acompanhamento (pode ser null)
     * @param acomp3 Terceiro acompanhamento (pode ser null)
     * @param obs Observações especiais do pedido
     */
    public void fazerPedido(String nome_cliente, Pizza pizza, Acompanhamento acomp1, Acompanhamento acomp2, Acompanhamento acomp3, String obs) throws FaltouColocarNomeException{
        if(nome_cliente.isEmpty())
            throw new FaltouColocarNomeException();
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

    public String getNomeCliente() {
        return nomeCliente;
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


    
    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public void setAcompanhamentos(String acompanhamentos, int index) {
        this.acompanhamentos[index] = acompanhamentos;
    }


    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public void setPizza(String pizza) {
        this.pizza = pizza;
    }

    public void setBorda(String borda) {
        this.borda = borda;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }
    
}
