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

            // contagem de linhas

            int contagemLinhas = 1;

            // confirmação de leitura do arquivo

            System.out.println("Arquivo sendo Lido");

            // while que vai percorrer todas as linhas até acabar o arquivo

            while ((linha = reader.readLine()) != null) {

                // adiciona todos os numeros da primeira linhas em um array de strings 
                // e converte de string para int e adiciona os numeros na lista
                
                if (contagemLinhas == 1) { 
                    String[] valores = linha.split(" ");
                    System.out.println("Lista sem alterações: ");
                    for(String valor1 : valores){
                        System.out.print(valor1 + ",");
                        
                    }
                    System.out.println();

                    for (String valor : valores) {
                        if(!valor.isEmpty()){
                            lista.adicionar(Integer.parseInt(valor)); 
                        }
                    }

                    // para todas as linhas apos a primeira o codigo verifica o operador para realizar a operação

                } else if (contagemLinhas > 1) { 
                    String[] partes = linha.split(" ");
                    char operador = partes[0].charAt(0);
                    if (operador == 'P') {
                        System.out.println("Operação: " + linha);
                        lista.print();
                    } else if (operador == 'A') {
                        System.out.println("Operação: " + linha);
                        int numero = Integer.parseInt(partes[1]);
                        int posicao = Integer.parseInt(partes[2]);
                        lista.inserePosicao(numero, posicao); 
                    } else if (operador == 'R'){
                        System.out.println("Operação: " + linha);
                        int posicao = Integer.parseInt(partes[1]);
                        lista.remove(posicao); 
                    }                       
                }
                contagemLinhas++;
            }

            // fechando o leitor de arquivos

            reader.close();
        } catch (IOException e) {
            System.out.println("Erro");
            e.printStackTrace();
        }
        
    }
}