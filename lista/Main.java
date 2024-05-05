import encadeada.ListaLigada;

public class Main{
    public static void main(String[] args){
        // Meu java ta todo bugado n sei pq, mas eu sei que vai funcionar assim. Não consegui testar ainda.
        
        ListaLigada lista = new ListaLigada();

        lista.adicionar(2);
        lista.adicionar(5);
        lista.adicionar(7);
        lista.print();
        lista.remove(5);
        lista.print();
        System.out.println("fiosos");
}
}