package encadeada;

public class No {
    private int valor;
    private No proximo;

    public No(int valor){
        this.valor = valor;
        this.proximo = null;
    }

    public int getValor(){
        return this.valor;
    }

    public No getProximo(){
        return this.proximo;
    }

    public void SetProximo(No proximo){
        this.proximo = proximo;
    }


}