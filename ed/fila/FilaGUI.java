package ucsal.ed.fila;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FilaGUI extends JFrame {
    private Fila fila;
    private JTextField inputUsuario;
    private JTextArea campoDaFila;

    public FilaGUI(int maxSize) {
        fila = new Fila(maxSize);

        setTitle("Fila GUI");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        inputUsuario = new JTextField();
        panel.add(inputUsuario, BorderLayout.NORTH);

        campoDaFila = new JTextArea();
        panel.add(new JScrollPane(campoDaFila), BorderLayout.CENTER);

        JButton bAdicionar = new JButton("Adicionar");
        JButton bRemover = new JButton("Remover");
        bRemover.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fila.remover();
                atualizarTexto();
                inputUsuario.setText("");
            }
        });
        bAdicionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputUsuario.getText();
                try {
                    fila.adicionar(Integer.parseInt(input));
                    atualizarTexto();
                    inputUsuario.setText("");
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(FilaGUI.this, "Digite um número válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        panel.add(bAdicionar, BorderLayout.SOUTH);
        panel.add(bRemover, BorderLayout.EAST);
        add(panel);
    }


    private void atualizarTexto() {
        campoDaFila.setText("");
        for (int i = fila.getFrente(); i <= fila.getFundo(); i++) {
            campoDaFila.append(String.valueOf(fila.getFila()[i]) + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                FilaGUI filaGUI = new FilaGUI(5);
                filaGUI.setVisible(true);
            }
        });
    }
}
