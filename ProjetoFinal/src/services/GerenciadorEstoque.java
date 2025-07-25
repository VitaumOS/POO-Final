package services;

import dao.IngredienteDAO;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Map;
import modelo.EstoqueIngredientes;
import modelo.Ingrediente;

/**
 * Classe responsável por gerenciar o estoque de ingredientes
 * @author Caioba
 */
public class GerenciadorEstoque {
    private final IngredienteDAO ingredienteDAO;
    private final EstoqueIngredientes estoque;
    
    /**
     * Construtor que inicializa o DAO e o estoque
     * @param caminhoArquivo caminho do arquivo CSV de ingredientes
     * @param estoque referência ao estoque de ingredientes atual
     */
    public GerenciadorEstoque(String caminhoArquivo, EstoqueIngredientes estoque) {
        this.ingredienteDAO = new IngredienteDAO(caminhoArquivo);
        this.estoque = estoque;
    }
    
    /**
     * Salva o estoque atual no arquivo
     * @return true se salvou com sucesso, false caso contrário
     */
    public boolean salvarEstoque() {
        ArrayList<Map.Entry<Ingrediente, Integer>> ingredientes = new ArrayList<>();
        
        // Converte o estoque atual para o formato do DAO
        for (int i = 0; i < estoque.getQuantIngredientes(); i++) {
            String nomeIngrediente = estoque.pegarNomeIngredientes(i);
            Ingrediente ing = new Ingrediente(nomeIngrediente);
            int quantidade = estoque.getQuantidade(nomeIngrediente);
            
            ingredientes.add(new AbstractMap.SimpleEntry<>(ing, quantidade));
        }
        
        ingredienteDAO.salvar(ingredientes);
        return true;
    }
    
    /**
     * Carrega o estoque a partir do arquivo
     * @return true se carregou com sucesso, false caso contrário
     */
    public boolean carregarEstoque() {
        ArrayList<Map.Entry<Ingrediente, Integer>> ingredientes = ingredienteDAO.carregar();
        
        for (Map.Entry<Ingrediente, Integer> entrada : ingredientes) {
            Ingrediente ing = entrada.getKey();
            int quantidade = entrada.getValue();
            
            // Adiciona ao estoque apenas se não existir ainda
            if (estoque.getQuantidade(ing.getNome()) == 0) {
                estoque.addIngrediente(ing, quantidade);
            } else {
                // Se já existir, atualiza a quantidade
                estoque.reporIngrediente(ing, quantidade - estoque.getQuantidade(ing.getNome()));
            }
        }
        
        return true;
    }
    
    /**
     * Adiciona uma quantidade de um ingrediente ao estoque
     * @param nomeIngrediente nome do ingrediente
     * @param quantidade quantidade a ser adicionada
     * @return true se atualizou com sucesso, false caso contrário
     */
    public boolean adicionarQuantidadeIngrediente(String nomeIngrediente, int quantidade) {
        if (quantidade <= 0) {
            return false;
        }
        
        Ingrediente ing = new Ingrediente(nomeIngrediente);
        estoque.reporIngrediente(ing, quantidade);
        return salvarEstoque();
    }
    
    /**
     * Define uma quantidade específica para um ingrediente
     * @param nomeIngrediente nome do ingrediente
     * @param novaQuantidade nova quantidade a ser definida
     * @return true se atualizou com sucesso, false caso contrário
     */
    public boolean definirQuantidadeIngrediente(String nomeIngrediente, int novaQuantidade) {
        if (novaQuantidade < 0) {
            return false;
        }
        
        Ingrediente ing = new Ingrediente(nomeIngrediente);
        int quantidadeAtual = estoque.getQuantidade(nomeIngrediente);
        int diferenca = novaQuantidade - quantidadeAtual;
        
        if (diferenca > 0) {
            estoque.reporIngrediente(ing, diferenca);
        } else if (diferenca < 0) {
            // Remove a quantidade excedente (valor absoluto da diferença)
            for (int i = 0; i < Math.abs(diferenca); i++) {
                try {
                    estoque.consumirIngrediente(ing);
                } catch (Exception e) {
                    // Não deveria acontecer, já que estamos checando a quantidade
                    return false;
                }
            }
        }
        
        return salvarEstoque();
    }
}
