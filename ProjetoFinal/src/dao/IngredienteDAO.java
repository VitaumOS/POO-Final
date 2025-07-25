package dao;

import interfaces.ArquivoDAO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import modelo.Ingrediente;

/**
 * Classe responsável por persistir os ingredientes
 * @author Caioba
 */
public class IngredienteDAO implements ArquivoDAO<Map.Entry<Ingrediente, Integer>> {
    private static final String SEPARADOR_CSV = ";";
    private final String caminhoArquivo;

    /**
     * Construtor que define o caminho do arquivo de ingredientes
     * @param caminhoArquivo caminho onde o arquivo será salvo/lido
     */
    public IngredienteDAO(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
        // Garante que o diretório exista
        File arquivo = new File(caminhoArquivo);
        File diretorio = arquivo.getParentFile();
        if (diretorio != null && !diretorio.exists()) {
            diretorio.mkdir();
        }
    }
    
    @Override
    public void salvar(ArrayList<Map.Entry<Ingrediente, Integer>> objetos){
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            // Escreve o cabeçalho
            wr.write("nome" + SEPARADOR_CSV + "quantidade");
            wr.newLine();

            // Escreve os ingredientes
            for (Map.Entry<Ingrediente, Integer> ingrediente : objetos) {
                wr.write(ingrediente.getKey().getNome() + SEPARADOR_CSV + ingrediente.getValue());
                wr.newLine();
            }
        }
        catch(IOException e){
            
        }
    }

    @Override
    public ArrayList<Map.Entry<Ingrediente, Integer>> carregar() {
        ArrayList<Map.Entry<Ingrediente, Integer>> resultado = new ArrayList<>();
        File arquivo = new File(caminhoArquivo);
        
        if (!arquivo.exists()) {
            return resultado; // Retorna lista vazia se o arquivo não existir
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            // Pula a primeira linha (cabeçalho)
            reader.readLine();
            
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(SEPARADOR_CSV);
                if (dados.length >= 2) {
                    String nome = dados[0].trim();
                    int quantidade = Integer.parseInt(dados[1].trim());
                    
                    // Cria um ingrediente e adiciona na lista com sua quantidade
                    Ingrediente ingrediente = new Ingrediente(nome);
                    Map<Ingrediente, Integer> map = new HashMap<>();
                    map.put(ingrediente, quantidade);
                    
                    resultado.add(map.entrySet().iterator().next());
                }
            }
        }
        catch(IOException e){
        }
        return resultado;
    }
}
