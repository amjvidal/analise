package encadeada;

public class ListaLigada{

    private No cabeca;

    public ListaLigada(){
        cabeca = null;
    }

    public void print(){
        No n = cabeca;
        while(n != null){
            System.out.println(n.getValor() + " ");
            n = n.getProximo();
        }
    }

    public void adicionar(int valor){
        No n = new No(valor);

        if (cabeca == null){
            cabeca = n;
            return;
        }

        No ultimo = cabeca;

        while(ultimo.getProximo() != null){
            ultimo = ultimo.getProximo();
        }

        ultimo.SetProximo(n);
    }

    public void inserePosicao (int valor, int indice){
        No n = new No(valor);
        No memoria = this.cabeca;
        int cont = 0;
        if (indice == 0){
            n.SetProximo(this.cabeca);
            this.cabeca = n;
        }
        while(memoria.getProximo()!= null){
            if(cont == indice){
                n.SetProximo(memoria.getProximo());
                memoria.SetProximo(n);
                break;
            }
            else{
                cont++;
                memoria = memoria.getProximo();
            }
        }
    }

    public void remove (int valor) {
        No n = this.cabeca;
        No anterior = null;
        while (n!=null){
            if(n.getValor() == valor){
                anterior.SetProximo(n.getProximo());
                return;
            }
            else{
                anterior = n;
                n = n.getProximo();
            }
        }
    }

}