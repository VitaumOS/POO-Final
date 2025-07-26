/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import dao.CardapioDAO;
import services.GerenciadorDiario;
import services.GerenciadorEstoque;

/**
 * Classe que representa a pizzaria.
 * Interage com as demais classes para criar o sistema
 *  
 * @author Vitor
 */
public class Pizzaria {
    

    Cardapio cardapio;
    private HistoricoPedido historicopedido;
    private EstoqueIngredientes estoque;
    private GerenciadorEstoque gerenciadorEstoque;
    private GerenciadorDiario gerenciadorDiario;

    /**
     * Construtor da classe Pizzaria.
     * Inicializa todos os componentes necessários
     * - Carrega o cardápio através do CardapioDAO
     * - Cria o histórico de pedidos
     * - Configura os gerenciadores de estoque e diário
     */
    public Pizzaria() {
        String caminhoIngredientes = obterCaminhoArquivo("ingredientes.csv");
        String caminhoDiario = obterCaminhoArquivo("diarioPizzaria.csv");

        CardapioDAO cardapioDAO = new CardapioDAO();
        cardapio = new Cardapio(cardapioDAO.carregar());
  
        // Inicializa o estoque sem ingredientes primeiro
        estoque = new EstoqueIngredientes();

        historicopedido = new HistoricoPedido();

        // Configura o gerenciador que carregará os ingredientes
        this.gerenciadorEstoque = new GerenciadorEstoque(caminhoIngredientes, estoque);
        this.gerenciadorDiario = new GerenciadorDiario(caminhoDiario);

        // Agora carrega os ingredientes usando o gerenciador
        gerenciadorEstoque.carregarEstoque();
        gerenciadorDiario.carregarHistorico();
    }

    private String obterCaminhoArquivo(String nomeArquivo) {
        String[] possiveisCaminhos = {
            "src/resources/" + nomeArquivo,
            "src\\resources\\" + nomeArquivo,
            "./src/resources/" + nomeArquivo,
            "ProjetoFinal/src/resources/" + nomeArquivo,
            System.getProperty("user.dir") + "/src/resources/" + nomeArquivo,
            System.getProperty("user.dir") + "\\src\\resources\\" + nomeArquivo
        };
        
        for (String caminho : possiveisCaminhos) {
            java.io.File arquivo = new java.io.File(caminho);
            if (arquivo.exists()) {
                return caminho;
            }
        }
        
        // Se não encontrou, usa o caminho padrão
        String caminhoDefault = "src/resources/" + nomeArquivo;
        return caminhoDefault;
    }

    public Cardapio getCardapio(){
        return cardapio;
    }
    public EstoqueIngredientes getEstoque() {
        return estoque;
    }
    public void adicionarPedidoAoHistorico(Pedido pedido) {
        historicopedido.adicionarPedido(pedido);
    }
    
    public HistoricoPedido getHistoricoPedido() {
        return historicopedido;
    }
    
    public String converteDoubleReais(double valor){
        return "R$"+valor+"0";
    }

    public GerenciadorEstoque getGerenciadorEstoque() {
        return gerenciadorEstoque;
    }

    public GerenciadorDiario getGerenciadorDiario() {
        return gerenciadorDiario;
    }

    public boolean salvarEstoque() {
        return gerenciadorEstoque.salvarEstoque();
    }

    public boolean registrarPedidoDiario(Pedido pedido) {
        return gerenciadorDiario.registrarPedido(pedido);
    }
}
