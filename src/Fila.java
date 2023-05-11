public class Fila {
    private int[] fila;
    private int frente;
    private int fundo;
    private int tamMax;
    private int tam;

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
        fundo = (fundo + 1) % tamMax;
        fila[fundo] = item;
        tam++;
        System.out.println(item + " adicionado a fila");
    }

    public int remover() {
        if (isVazio()) {
            System.out.println("Fila vazia");
            return -1;
        }
        int item = fila[frente];
        frente = (frente + 1) % tamMax;
        tam--;
        System.out.println(item + " removido da fila");
        return item;
    }

    public int print() {
        if (isVazio()) {
            System.out.println("Fila vazia");
            return -1;
        }
        int item = fila[frente];
        System.out.println(item);
        return item;
    }

    public static void main(String[] args) {
        Fila qms = new Fila(5);
        qms.adicionar(1);
        qms.adicionar(2);
        qms.adicionar(3);
        qms.adicionar(4);
        qms.adicionar(5);
        qms.adicionar(6);
        qms.print();
        qms.remover();
        qms.print();
        qms.remover();
        qms.print();
        qms.remover();
        qms.print();
        qms.remover();
        qms.print();
        qms.remover();
        qms.print();
        qms.remover();
    }
}
