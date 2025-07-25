package dao;

import interfaces.ArquivoDAO;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import modelo.Pedido;

/**
 * Classe responsável por persistir o histórico de pedidos no diário da pizzaria
 * @author Caioba
 */
public class DiarioPizzariaDAO implements ArquivoDAO<Pedido> {
    private static final String SEPARADOR_CSV = ",";
    private final String caminhoArquivo;
    private static final SimpleDateFormat FORMAT = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
    
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
    public void salvar(ArrayList<Pedido> pedidos) throws IOException {
        // Verifica se o arquivo já existe para decidir se escreve o cabeçalho
        boolean arquivoExiste = new File(caminhoArquivo).exists();
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo, arquivoExiste))) {
            // Escreve o cabeçalho apenas se o arquivo não existir
            if (!arquivoExiste) {
                writer.write("id,data,cliente,pizza,borda,acompanhamento1,acompanhamento2,acompanhamento3,observacao,valor_total");
                writer.newLine();
            }
            
            // Adiciona data e hora atual ao registrar o pedido
            String dataHoraAtual = FORMAT.format(new Date());
            
            // Escreve os pedidos
            for (Pedido pedido : pedidos) {
                StringBuilder linha = new StringBuilder();
                linha.append(pedido.getId()).append(SEPARADOR_CSV);
                linha.append(dataHoraAtual).append(SEPARADOR_CSV);
                linha.append(pedido.getNomeCliente()).append(SEPARADOR_CSV);
                linha.append(pedido.getPizza()).append(SEPARADOR_CSV);
                linha.append(pedido.getBorda()).append(SEPARADOR_CSV);
                
                // Adiciona os acompanhamentos (pode ser "Nenhum")
                String[] acomps = pedido.getAcompanhamentos();
                for (String acomp : acomps) {
                    linha.append(acomp).append(SEPARADOR_CSV);
                }
                
                // Adiciona observação e valor total
                linha.append(pedido.getObs()).append(SEPARADOR_CSV);
                linha.append(pedido.getValorTotal());
                
                writer.write(linha.toString());
                writer.newLine();
            }
        }
    }
    
    @Override
    public ArrayList<Pedido> carregar() throws IOException {
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
                    pedido.setNomeCliente(dados[2].trim());
                    
                    //TODO: Aqui precisaria implementar os outros setters no Pedido
                    //TODO: Isso depende da implementação completa da classe Pedido
                    
                    pedidos.add(pedido);
                }
            }
        }
        
        return pedidos;
    }
}
