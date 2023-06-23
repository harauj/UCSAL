package ucsal.ed.lista;

public class Celula {
    private Object elemento;
    private Celula anterior;
    private Celula proximo;

    public Celula(Object elemento) {
        this(null, elemento);
    }

    public Celula(Celula proximo, Object elemento) {
        this.proximo = proximo;
        this.elemento = elemento;
    }

    public Celula getAnterior() {
        return anterior;
    }

    public void setAnterior(Celula anterior) {
        this.anterior = anterior;
    }

    public Celula getProximo() {
        return this.proximo;
    }

    public Object getElemento() {
        return elemento;
    }

    public void setElemento(Object elemento) {
        this.elemento = elemento;
    }

    public void setProximo(Celula proximo) {
        this.proximo = proximo;
    }

}