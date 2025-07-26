package dao;

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
        // Removida a criação automática de diretório
    }
    
    @Override
    public void salvar(ArrayList<Map.Entry<Ingrediente, Integer>> objetos){
        File arquivo = new File(caminhoArquivo);
        if (!arquivo.exists()) {
            System.err.println("Arquivo de ingredientes não existe e não será criado: " + caminhoArquivo);
            javax.swing.JOptionPane.showMessageDialog(
                null,
                "Arquivo de ingredientes não encontrado: " + caminhoArquivo,
                "Erro de arquivo",
                javax.swing.JOptionPane.ERROR_MESSAGE
            );
            return;
        }
        
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
            System.err.println("Erro ao criar diretório para o arquivo.");
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<Map.Entry<Ingrediente, Integer>> carregar() {
        ArrayList<Map.Entry<Ingrediente, Integer>> resultado = new ArrayList<>();
        File arquivo = new File(caminhoArquivo);
        
        if (!arquivo.exists()) {
            System.err.println("Arquivo não encontrado: " + caminhoArquivo);
            javax.swing.JOptionPane.showMessageDialog(
                null,
                "Arquivo de ingredientes não encontrado: " + caminhoArquivo,
                "Erro de arquivo",
                javax.swing.JOptionPane.ERROR_MESSAGE
            );
            return resultado;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            reader.readLine();

            String linha;
            int contadorLinhas = 0;
            while ((linha = reader.readLine()) != null) {
                contadorLinhas++;
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
        } catch(IOException e) {
            System.err.println("Erro de IO: " + e.getMessage());
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(
                null,
                "Erro ao ler o arquivo de ingredientes:\n" + e.getMessage(),
                "Erro de leitura",
                javax.swing.JOptionPane.ERROR_MESSAGE
            );
        } catch(Exception e) {
            System.err.println("Exceção geral: " + e.getMessage());
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(
                null, 
                "Erro inesperado: " + e.getMessage(),
                "Erro de processamento",
                javax.swing.JOptionPane.ERROR_MESSAGE
            );
        }
        return resultado;
    }
}
