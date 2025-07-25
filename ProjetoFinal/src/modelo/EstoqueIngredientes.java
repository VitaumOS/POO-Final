package modelo;

import excecoes.EstoqueInsuficienteException;
import java.util.*;

/**
 * Estoque de ingredientes usando ArrayList<Map.Entry<Ingrediente, Integer>>
 * @author Vitor
 */
public class EstoqueIngredientes {


    private final ArrayList<Map.Entry<Ingrediente, Integer>> ingredientes;

    public EstoqueIngredientes() {
        ingredientes = new ArrayList<>();
    }

    
    public EstoqueIngredientes(ArrayList<Map.Entry<Ingrediente,Integer>> ingredientes){
        this.ingredientes = ingredientes;
    }

    public ArrayList<Map.Entry<Ingrediente, Integer>> getListaIngredientes() {
        return ingredientes;
    }

    public void addIngrediente(Ingrediente nome, int quantidade) {
        ingredientes.add(new AbstractMap.SimpleEntry<>(nome, quantidade));
    }

    public void reporIngrediente(Ingrediente ing, int quantidade) {
        for (int i = 0; i < ingredientes.size(); i++) {
            Map.Entry<Ingrediente, Integer> entrada = ingredientes.get(i);
            if (entrada.getKey().getNome().equals(ing.getNome())) {
                ingredientes.set(i, new AbstractMap.SimpleEntry<>(ing, entrada.getValue()+quantidade));
            }
        }
    }

    public void consumirIngrediente(Ingrediente ing) throws EstoqueInsuficienteException {
        for (int i = 0; i < ingredientes.size(); i++) {
            Map.Entry<Ingrediente, Integer> entrada = ingredientes.get(i);
            if (entrada.getKey().getNome().equals(ing.getNome())) {
                if (entrada.getValue() <= 0) {
                    throw new EstoqueInsuficienteException(ing.getNome());
                }
                ingredientes.set(i, new AbstractMap.SimpleEntry<>(ing, entrada.getValue() - 1));
            }
        }
    }

    public int getQuantidade(String nome) {
        for (Map.Entry<Ingrediente, Integer> entrada : ingredientes) {
            if (entrada.getKey().getNome().equalsIgnoreCase(nome)) {
                return entrada.getValue();
            }
        }
        return 0;
    }

    public int getQuantIngredientes() {
        return ingredientes.size();
    }

    public String pegarNomeIngredientes(int index) {
        return ingredientes.get(index).getKey().getNome();
    }
}
