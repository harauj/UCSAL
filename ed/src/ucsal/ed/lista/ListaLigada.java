package ucsal.ed.lista;


public class ListaLigada {
    private Celula primeira = null;
    private Celula ultima = null;
    private int totalElementos = 0;

    public Celula getPrimeira() {
        return primeira;
    }

    public Celula getUltima() {
        return ultima;
    }

    public int getTotalElementos() {
        return totalElementos;
    }

    public void adicionarNoComeco(Object elemento) {
        Celula nova = new Celula(elemento);
        nova.setProximo(this.primeira);

        if (this.totalElementos == 0) {
            this.ultima = nova;
        } else {
            this.primeira.setAnterior(nova);
        }
        System.out.println(elemento + " adicionado ao começo");
        this.primeira = nova;
        this.totalElementos++;
    }

    public void adicionarNoFim(Object elemento) {
        if (this.totalElementos == 0) {
            this.adicionarNoComeco(elemento);
        } else {
            Celula nova = new Celula(elemento);
            nova.setAnterior(this.ultima);
            this.ultima.setProximo(nova);
            this.ultima = nova;
            this.totalElementos++;
        }
        System.out.println(elemento + " adicionado ao fim");
    }

/*    public void remover() {
        if (this.totalElementos == 0) {
            System.out.println("A lista está vazia. Não é possível remover elementos.");
        }

        if (this.totalElementos == 1) {
            this.primeira = null;
            this.ultima = null;
        } else {
            Celula proxima = this.primeira.getProximo();
            proxima.setAnterior(null);
            this.primeira = proxima;
        }

        this.totalElementos--;
    }*/

    public void removerDoComeco() {
        if (this.totalElementos == 0) {
            throw new IllegalStateException("A lista está vazia. Não é possível remover elementos.");
        }

        if (this.totalElementos == 1) {
            this.primeira = null;
            this.ultima = null;
        } else {
            Celula proxima = this.primeira.getProximo();
            proxima.setAnterior(null);
            this.primeira = proxima;
        }

        this.totalElementos--;
    }

    public void removerDoFim() {
        if (this.totalElementos == 0) {
            throw new IllegalStateException("A lista está vazia. Não é possível remover elementos.");
        }

        if (this.totalElementos == 1) {
            this.primeira = null;
            this.ultima = null;
        } else {
            Celula anterior = this.ultima.getAnterior();
            anterior.setProximo(null);
            this.ultima = anterior;
        }

        this.totalElementos--;
    }

    public void imprimir() {
        Celula celulaAtual = primeira;
        while (celulaAtual != null) {
            System.out.println(celulaAtual.getElemento());
            celulaAtual = celulaAtual.getProximo();
        }
    }

    private boolean posicaoOcupada(int posicao) {
        return posicao >= 0 && posicao <= this.totalElementos;
    }

    public static void main(String[] args) {
        ListaLigada lista = new ListaLigada();
        lista.adicionarNoComeco(1);
        lista.adicionarNoComeco(2);
        lista.adicionarNoFim(3);
        lista.imprimir();
    }
}
