package dao;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import interfaces.ArquivoDAO;
import modelo.Ingrediente;

/**
 * Classe responsável por persistir os ingredientes
 * @author Caioba
 */
public class IngredienteDAO implements ArquivoDAO {
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
    public void salvar(ArrayList<Map.Entry<Ingrediente, Integer>> ingredientes) throws IOException {
        try (BufferedWriter wr = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            // Escreve o cabeçalho
            wr.write("nome" + SEPARADOR_CSV + "quantidade");
            wr.newLine();

            // Escreve os ingredientes
            for (Map.Entry<Ingrediente, Integer> ingrediente : ingredientes) {
                wr.write(ingrediente.getKey().getNome() + SEPARADOR_CSV + ingrediente.getValue());
            }
        }
    }
}
