package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import modelo.Pedido;

/**
 * Classe responsável por persistir o histórico de pedidos no diário da pizzaria
 * @author Caioba
 */
public class DiarioPizzariaDAO implements ArquivoDAO<Pedido> {
    private static final String SEPARADOR_CSV = ";";
    private final String caminhoArquivo;
    
    /**
     * Construtor que define o caminho do arquivo do diário
     * @param caminhoArquivo caminho onde o arquivo será salvo/lido
     */
    public DiarioPizzariaDAO(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
        // Garante que o diretório exista
        File arquivo = new File(caminhoArquivo);
        File diretorio = arquivo.getParentFile();
        if (diretorio != null && !diretorio.exists()) {
            diretorio.mkdirs();
        }
    }
    
    @Override
    public void salvar(ArrayList<Pedido> pedidos) {
        // Verifica se o arquivo já existe para decidir se escreve o cabeçalho
        boolean arquivoExiste = new File(caminhoArquivo).exists();
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo, arquivoExiste))) {
            // Escreve o cabeçalho apenas se o arquivo não existir
            if (!arquivoExiste) {
                writer.write("id" + SEPARADOR_CSV + "dia" + SEPARADOR_CSV + "mes" + SEPARADOR_CSV + "cliente" 
                             + SEPARADOR_CSV + "pizza" + SEPARADOR_CSV + "borda" + SEPARADOR_CSV + 
                             "acompanhamento1" + SEPARADOR_CSV + "acompanhamento2" + SEPARADOR_CSV + 
                             "acompanhamento3" + SEPARADOR_CSV + "observacao" + SEPARADOR_CSV + "valor_total");
                writer.newLine();
            }
            
            // Escreve os pedidos
            for (Pedido pedido : pedidos) {
                StringBuilder linha = new StringBuilder();
                linha.append(pedido.getId()).append(SEPARADOR_CSV);
                linha.append(pedido.getNomeCliente()).append(SEPARADOR_CSV);
                linha.append(pedido.getPizza()).append(SEPARADOR_CSV);
                linha.append(pedido.getBorda()).append(SEPARADOR_CSV);
                
                // Adiciona os acompanhamentos (pode ser "Nenhum")

                for (int i = 0; i < 3; i++) {

                    linha.append(pedido.getAcompanhamentos(i)).append(SEPARADOR_CSV);
                }
                
                // Adiciona observação e valor total
                linha.append(pedido.getObs()).append(SEPARADOR_CSV);
                linha.append(pedido.getValorTotal());
                
                writer.write(linha.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Erro ao criar diretório para o arquivo.");
            e.printStackTrace();
        }
    }
    
    @Override
    public ArrayList<Pedido> carregar() {
        ArrayList<Pedido> pedidos = new ArrayList<>();
        File arquivo = new File(caminhoArquivo);
        
        if (!arquivo.exists()) {
            return pedidos; // Retorna lista vazia se o arquivo não existir
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            // Pula a primeira linha (cabeçalho)
            reader.readLine();
            
            while ((linha = reader.readLine()) != null) {
                String[] dados = linha.split(SEPARADOR_CSV);
                if (dados.length >= 10) {
                    // Cria um novo pedido com os dados do arquivo
                    Pedido pedido = new Pedido();
                    
                    // Configurar os dados do pedido
                    pedido.setId(Integer.parseInt(dados[0].trim()));
                    pedido.setNomeCliente(dados[3].trim());
                    pedido.setPizza(dados[4].trim());
                    pedido.setBorda(dados[5].trim());
                    pedido.setAcompanhamentos(dados[6].trim(),0);
                    pedido.setAcompanhamentos(dados[7].trim(),1);
                    pedido.setAcompanhamentos(dados[8].trim(),2);
                    pedido.setValorTotal(Double.parseDouble(dados[10].trim()));
                    
                    pedidos.add(pedido);
                }
            }
        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo.");
            e.printStackTrace();
        }
        
        return pedidos;
    }
}
