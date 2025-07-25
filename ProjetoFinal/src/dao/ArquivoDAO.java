package dao;

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
     */
    void salvar(ArrayList<T> objetos);

    /**
     * Carrega objetos a partir de um arquivo
     * @return arraylist de objetos carregados
     */
    ArrayList<T> carregar();
}
