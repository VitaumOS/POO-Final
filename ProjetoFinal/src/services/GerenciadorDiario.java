package services;

import dao.DiarioPizzariaDAO;
import java.io.IOException;
import java.util.ArrayList;
import modelo.Pedido;

/**
 * Classe responsável por gerenciar o diário da pizzaria
 * @author Caioba
 */
public class GerenciadorDiario {
    private final DiarioPizzariaDAO diarioDAO;
    private ArrayList<Pedido> pedidosDiarios;
    
    /**
     * Construtor que inicializa o DAO e a lista de pedidos
     * @param caminhoArquivo caminho do arquivo CSV do diário
     */
    public GerenciadorDiario(String caminhoArquivo) {
        this.diarioDAO = new DiarioPizzariaDAO(caminhoArquivo);
        this.pedidosDiarios = new ArrayList<>();
    }
    
    /**
     * Registra um novo pedido no diário
     * @param pedido o pedido a ser registrado
     * @return true se registrou com sucesso, false caso contrário
     */
    public boolean registrarPedido(Pedido pedido) {
        try {
            // Adiciona o pedido à lista
            pedidosDiarios.add(pedido);
            
            // Salva apenas o novo pedido (modo append)
            ArrayList<Pedido> novoPedido = new ArrayList<>();
            novoPedido.add(pedido);
            diarioDAO.salvar(novoPedido);
            
            return true;
        } catch (IOException e) {
            System.err.println("Erro ao registrar pedido: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Carrega todos os pedidos do diário
     * @return true se carregou com sucesso, false caso contrário
     */
    public boolean carregarHistorico() {
        try {
            pedidosDiarios = diarioDAO.carregar();
            return true;
        } catch (IOException e) {
            System.err.println("Erro ao carregar histórico: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Retorna a lista de pedidos carregada
     * @return lista de pedidos
     */
    public ArrayList<Pedido> getPedidosDiarios() {
        return pedidosDiarios;
    }
}