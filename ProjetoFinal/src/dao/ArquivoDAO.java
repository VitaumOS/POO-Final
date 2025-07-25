package dao;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Interface que define as operações básicas de acesso a dados em arquivos
 * @author Caioba
 * @param <T> tipo de objeto a ser persistido
 */
public interface ArquivoDAO<T> {
    /**
     * Salva um arraylist de objetos em arquivo
     * @param objetos lista de objetos a serem salvos
     * @throws IOException caso ocorra erro de acesso
     */
    void salvar(ArrayList<T> objetos) throws IOException;

    /**
     * Carrega objetos a partir de um arquivo
     * @return arraylist de objetos carregados
     * @throws IOException caso ocorra erro de acesso ao arquivo
     */
    ArrayList<T> carregar() throws IOException;
}
