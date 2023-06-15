package ucsal.ed.arvore;

public class Arvore {

    private No root;

    public Arvore() {
        root = null;
    }

    public void inserir(long v) {
        No novo = new No();
        novo.item = v;
        novo.dir = null;
        novo.esq = null;

        if (root == null) {
            root = novo;
        } else {
            No autal = root;
            No anterior;
        }
        while (true) {
            anterior = atual;
            if (v <= atual.item) {
                atual = atual.esq;
                if (atual == null) {
                    anterior.esq = novo;
                    return;
                }
            } else {
                atual = atual.dir;
                if (atual == null) {
                    anterior.dir = novo;
                    return;
                }
            }
        }

    }

    public No buscar(long chave) {
        if (root == null) {
            return null;
        }
        No atual = root;
        while (atual.item != chave) {
            if (chave < atual.item) {
                atual = atual.esq;
            } else {
                atual = atual.dir;
            }
            if (atual == null) {
                return null;
            }
        }
        return atual;
    }

}


