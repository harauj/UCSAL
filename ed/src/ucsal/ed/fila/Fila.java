package ucsal.ed.fila;

//FIFO
public class Fila {
    private int[] fila;
    private int frente;
    private int fundo;
    private int tamMax;
    private int tam;

    public int getFrente() {
        return frente;
    }

    public void setFrente(int frente) {
        this.frente = frente;
    }

    public int getFundo() {
        return fundo;
    }

    public void setFundo(int fundo) {
        this.fundo = fundo;
    }

    public int[] getFila() {
        return fila;
    }

    public void setFila(int[] fila) {
        this.fila = fila;
    }

    public Fila(int maxSize) {
        this.tamMax = maxSize;
        this.fila = new int[maxSize];
        this.frente = 0;
        this.fundo = -1;
        this.tam = 0;
    }

    public boolean isCheio() {
        return (tam == tamMax);
    }

    public boolean isVazio() {
        return (tam == 0);
    }

/*    public int getTam() {
        return tam;
    }*/

    public void adicionar(int item) {
        if (isCheio()) {
            System.out.println("Fila cheia");
            return;
        }
        int proximo = (fundo + 1) == tamMax ? 0 : fundo + 1;
        fila[proximo] = item;
        fundo = proximo;
        tam++;

        System.out.println(item + " adicionado à fila");
    }

    public void remover() {
        if (isVazio()) {
            System.out.println("Fila vazia");
            return;
        }
        int item = fila[frente];
        frente = (frente + 1) == tamMax ? 0 : frente + 1;
        tam--;

        System.out.println(item + " removido da fila");
    }

    public void print() {
        if (isVazio()) {
            System.out.println("Fila vazia");
            return;
        }
        int item = fila[frente];
        System.out.println(item);
    }

    public static void main(String[] args) {
        Fila f1 = new Fila(5);
        f1.adicionar(1);
        f1.adicionar(2);
        f1.adicionar(3);
        f1.adicionar(4);
        f1.adicionar(5);
        f1.adicionar(6);
        f1.print();
        f1.remover();
        f1.print();
        f1.remover();
        f1.print();
        f1.remover();
        f1.print();
        f1.remover();
        f1.print();
        f1.remover();
        f1.print();
        f1.remover();
    }
}
