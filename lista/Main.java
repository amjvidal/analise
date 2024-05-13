import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import encadeada.ListaLigada;

public class Main{
    public static void main(String[] args){
        ListaLigada lista = new ListaLigada();
        String path = "C:\\Users\\anton\\OneDrive\\Documentos\\VCS\\teste\\rsc\\arqnovo.txt";
        
        try {
            //lendo o arquivo
            BufferedReader reader = new BufferedReader(new FileReader(path));
            String linha;
            int contagemLinhas = 0;
            System.out.println("Arquivo sendo Lido");
            while ((linha = reader.readLine()) != null) {
                contagemLinhas++;
                if (contagemLinhas == 1) { 
                    String[] valores = linha.split(" ");
                    for (String valor : valores) {
                        lista.adicionar(Integer.parseInt(valor)); 
                    }
                } else if (contagemLinhas >= 3) { 
                    String[] partes = linha.split(" ");
                    char acao = partes[0].charAt(0);
                    if (acao == 'P') {
                       System.out.println("Lista: " + lista.toString()); 
                        break; 
                    } else if (acao == 'A') {
                        int numero = Integer.parseInt(partes[1]);
                        int posicao = Integer.parseInt(partes[2]);
                        lista.inserePosicao(numero, posicao); 
                    } else if (acao == 'R'){
                        int posicao = Integer.parseInt(partes[1]);
                        lista.remove(posicao); 
                    }                       
                }
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
}