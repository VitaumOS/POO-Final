/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import modelo.Acompanhamento;
import modelo.BordaPizza;
import modelo.Cardapio;
import modelo.Pizza;

/**
 * Classe responsável por persistir o cardápio
 * @author Vitor
 */
public class CardapioDAO {
        
    /**
     * Tenta diferentes possibilidades de caminho
     * 
     */
    private String obterCaminhoArquivo() {
        String[] possiveisCaminhos = {
            "src/resources/cardapio.csv",
            "src\\resources\\cardapio.csv",
            "./src/resources/cardapio.csv",
            "ProjetoFinal/src/resources/cardapio.csv",
            System.getProperty("user.dir") + "/src/resources/cardapio.csv",
            System.getProperty("user.dir") + "\\src\\resources\\cardapio.csv"
        };
        
        for (String caminho : possiveisCaminhos) {
            java.io.File arquivo = new java.io.File(caminho);
            if (arquivo.exists()) {
                return caminho;
            }
        }
        
        // Se não encontrou, usa o caminho padrão
        String caminhoDefault = "src/resources/cardapio.csv";
        return caminhoDefault;
    }
    
    /**
     * Salva um objeto Cardapio em arquivo
     * @param cardapio objeto a ser salvo
     */
    public void salvar(Cardapio cardapio) {
        String caminhoArquivo = obterCaminhoArquivo();
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(caminhoArquivo))) {
            writer.write("[TIPO];[NOME];[PREÇO]");
            writer.newLine();

            for (int i = 0; i < cardapio.getQuantPizza(); i++) {
                Pizza p = cardapio.getCardapio_pizzas(i);
                writer.write("Pizza;" + p.getNome() + ";" + p.getPreco());
                writer.newLine();
            }

            for (int i = 0; i < cardapio.getQuantAcompanhamentos(); i++) {
                Acompanhamento a = cardapio.getAcompanhamentos(i);
                writer.write("Acompanhamento;" + a.getNome() + ";" + a.getPreco());
                writer.newLine();
            }

            for (int i = 0; i < cardapio.getQuantBordaPizza(); i++) {
                BordaPizza b = cardapio.getBordaPizza(i);
                writer.write("Borda;" + b.getNome() + ";");
                writer.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Carrega objeto cardapio a partir de um arquivo
     * @return cardapio carregado
     */
    public Cardapio carregar() {
        Cardapio cardapio = new Cardapio();
        String caminhoArquivo = obterCaminhoArquivo();

        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;

            while ((linha = reader.readLine()) != null) {
                if (linha.startsWith("[TIPO]") || linha.trim().isEmpty()) continue;

                String[] partes = linha.split(";");
                String tipo = partes[0];
                String nome = partes[1];
                String precoStr = (partes.length > 2) ? partes[2] : "";

                switch (tipo) {
                    case "Pizza":
                        cardapio.addPizza(new Pizza(nome, Double.parseDouble(precoStr)));
                        break;
                    case "Acompanhamento":
                        cardapio.addAcompanhamento(new Acompanhamento(nome, Double.parseDouble(precoStr)));
                        break;
                    case "Borda":
                        cardapio.addBorda(new BordaPizza(nome));
                        break;
                    default:
                        // ignora linha desconhecida
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cardapio;
    }
}
