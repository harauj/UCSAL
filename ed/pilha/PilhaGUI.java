package ucsal.ed.pilha;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PilhaGUI extends JFrame {
    private Pilha pilha;
    private JTextField inputUsuario;
    private JTextArea compoDaPilha;

    public PilhaGUI(int maxSize) {
        pilha = new Pilha(maxSize);

        setTitle("Pilha GUI");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        inputUsuario = new JTextField();
        panel.add(inputUsuario, BorderLayout.NORTH);

        compoDaPilha = new JTextArea();
        panel.add(new JScrollPane(compoDaPilha), BorderLayout.CENTER);

        JButton bAdicionar = new JButton("Adicionar");
        JButton bRemover = new JButton("Remover");
        bRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pilha.remover();
                atualizarTexto();
                inputUsuario.setText("");
            }
        });
        bAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputUsuario.getText();
                try {
                    pilha.adicionar(Integer.parseInt(input));
                    atualizarTexto();
                    inputUsuario.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(PilhaGUI.this, "Digite um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(bAdicionar, BorderLayout.SOUTH);
        panel.add(bRemover, BorderLayout.EAST);
        add(panel);
    }


    private void atualizarTexto() {
        compoDaPilha.setText("");
        int[] pilhaArray = pilha.getPilha();
        for (int i = pilha.getFrente(); i >= 0; i--) {
            compoDaPilha.append(String.valueOf(pilhaArray[i]) + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PilhaGUI pilhaGUI = new PilhaGUI(5);
                pilhaGUI.setVisible(true);
            }
        });
    }
}
