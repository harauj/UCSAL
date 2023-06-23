package ucsal.ed.lista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListaLigadaGUI extends JFrame {
    private ListaLigada lista;
    private JTextField inputUsuario;
    private JTextArea campoDaLista;

    public ListaLigadaGUI() {
        lista = new ListaLigada();

        setTitle("Lista Ligada GUI");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        inputUsuario = new JTextField();
        panel.add(inputUsuario, BorderLayout.NORTH);

        campoDaLista = new JTextArea();
        panel.add(new JScrollPane(campoDaLista), BorderLayout.CENTER);

        JButton bAdicionarNoFim = new JButton("Adicionar ao Fim");
        JButton bAdicionarNoComeco = new JButton("Adicionar ao Começo");
        JButton bRemoverDoFim = new JButton("Remover do Fim");
        JButton bRemoverDoComeco = new JButton("Remover do Começo");

        bAdicionarNoFim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputUsuario.getText();
                try {
                    lista.adicionarNoFim(Integer.parseInt(input));
                    atualizarTexto();
                    inputUsuario.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(ListaLigadaGUI.this, "Digite um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        bAdicionarNoComeco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputUsuario.getText();
                try {
                    lista.adicionarNoComeco(Integer.parseInt(input));
                    atualizarTexto();
                    inputUsuario.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(ListaLigadaGUI.this, "Digite um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        bRemoverDoFim.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lista.removerDoFim();
                atualizarTexto();
                inputUsuario.setText("");
            }
        });

        bRemoverDoComeco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lista.removerDoComeco();
                atualizarTexto();
                inputUsuario.setText("");
            }
        });

        JPanel buttonsPanel = new JPanel(new GridLayout(2, 2));
        buttonsPanel.add(bAdicionarNoFim);
        buttonsPanel.add(bAdicionarNoComeco);
        buttonsPanel.add(bRemoverDoFim);
        buttonsPanel.add(bRemoverDoComeco);

        panel.add(buttonsPanel, BorderLayout.SOUTH);
        add(panel);
    }

    private void atualizarTexto() {
        campoDaLista.setText("");
        Celula celulaAtual = lista.getPrimeira();
        while (celulaAtual != null) {
            campoDaLista.append(String.valueOf(celulaAtual.getElemento()) + "\n");
            celulaAtual = celulaAtual.getProximo();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ListaLigadaGUI listaLigadaGUI = new ListaLigadaGUI();
                listaLigadaGUI.setVisible(true);
            }
        });
    }
}
