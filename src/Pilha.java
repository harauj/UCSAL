public class Pilha {
    private int[] pilha;
    private int frente;
    private int tamMax;

    public Pilha(int tamanho) {
        this.tamMax = tamanho;
        this.pilha = new int[tamanho];
        this.frente = -1;
    }

    public boolean isVazio() {
        return (frente == -1);
    }

    public boolean isCheio() {
        return (frente == tamMax - 1);
    }

    public int print() {
        if (isVazio()) {
            System.out.println("Pilha cheia");
            return -1;
        }
        return pilha[frente];
    }

    public void adicionar(int item) {
        if (isCheio()) {
            System.out.println("Pilha vazia");
            return;
        }
        frente++;
        pilha[frente] = item;
        System.out.println(item + " adicionado");
    }

    public int remover() {
        if (isVazio()) {
            System.out.println("Pilha vazia");
            return -1;
        }
        int poppedItem = pilha[frente];
        frente--;
        System.out.println(poppedItem + " removido");
        return poppedItem;
    }

    public static void main(String[] args) {
        Pilha p1 = new Pilha(5);
        p1.adicionar(1);
        p1.adicionar(2);
        p1.adicionar(3);
        p1.adicionar(4);
        p1.adicionar(5);
        p1.adicionar(6);
        p1.print();
        p1.remover();
        p1.print();
        p1.remover();
        p1.print();
        p1.remover();
        p1.print();
        p1.remover();
        p1.print();
        p1.remover();
        p1.print();
        p1.remover();
    }
}
