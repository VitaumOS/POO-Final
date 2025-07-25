package util;

import java.io.*;

/**
 * Classe utilitária para manipulação de arquivos CSV
 * @author Caioba
 */
public class UtilsCSV {
    
    private static final String DEFAULT_SEPARATOR = ";";
    
    /**
     * Converte uma linha CSV em array de strings
     * @param linha linha CSV a ser convertida
     * @param separador separador usado no CSV
     * @return array com valores separados
     */
    public static String[] parseLinha(String linha, String separador) {
        if (linha == null || linha.isEmpty()) {
            return new String[0];
        }
        return linha.split(separador);
    }
    
    /**
     * Converte uma linha CSV em array de strings usando o separador padrão
     * @param linha linha CSV a ser convertida
     * @return array com valores separados
     */
    public static String[] parseLinha(String linha) {
        return parseLinha(linha, DEFAULT_SEPARATOR);
    }
    
    /**
     * Formata um array de strings como uma linha CSV
     * @param valores valores a serem formatados
     * @param separador separador a ser usado
     * @return linha CSV formatada
     */
    public static String formatarLinha(String[] valores, String separador) {
        if (valores == null || valores.length == 0) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < valores.length; i++) {
            // Escapar aspas duplas se necessário
            String valor = valores[i] == null ? "" : valores[i];
            if (valor.contains(separador) || valor.contains("\"")) {
                valor = "\"" + valor.replace("\"", "\"\"") + "\"";
            }
            
            sb.append(valor);
            
            if (i < valores.length - 1) {
                sb.append(separador);
            }
        }
        
        return sb.toString();
    }
    
    /**
     * Formata um array de strings como uma linha CSV usando o separador padrão
     * @param valores valores a serem formatados
     * @return linha CSV formatada
     */
    public static String formatarLinha(String[] valores) {
        return formatarLinha(valores, DEFAULT_SEPARATOR);
    }
    
    /**
     * Verifica se um arquivo CSV existe e se possui o cabeçalho esperado
     * @param arquivo caminho do arquivo
     * @param cabecalhoEsperado cabeçalho esperado
     * @param separador separador usado no CSV
     * @return true se o arquivo existe e tem o cabeçalho esperado, false caso contrário
     */
    public static boolean verificarCabecalho(String arquivo, String[] cabecalhoEsperado, String separador) {
        File file = new File(arquivo);
        if (!file.exists()) {
            return false;
        }
        
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String primeiraLinha = reader.readLine();
            if (primeiraLinha == null) {
                return false;
            }
            
            String[] cabecalhoAtual = parseLinha(primeiraLinha, separador);
            if (cabecalhoAtual.length != cabecalhoEsperado.length) {
                return false;
            }
            
            for (int i = 0; i < cabecalhoEsperado.length; i++) {
                if (!cabecalhoEsperado[i].equals(cabecalhoAtual[i])) {
                    return false;
                }
            }
            
            return true;
        } catch (IOException e) {
            return false;
        }
    }
    
    /**
     * Cria um arquivo CSV com o cabeçalho especificado
     * @param arquivo caminho do arquivo
     * @param cabecalho cabeçalho a ser escrito
     * @param separador separador a ser usado
     * @return true se o arquivo foi criado com sucesso, false caso contrário
     */
    public static boolean criarArquivoComCabecalho(String arquivo, String[] cabecalho, String separador) {
        File file = new File(arquivo);
        File parent = file.getParentFile();
        if (parent != null && !parent.exists()) {
            if (!parent.mkdirs()) {
                return false;
            }
        }
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo))) {
            writer.write(formatarLinha(cabecalho, separador));
            writer.newLine();
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
