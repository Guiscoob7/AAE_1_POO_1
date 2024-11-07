```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ComboBoxColorSelector {
    public static void main(String[] args) {
        // Criando o JFrame
        JFrame frame = new JFrame("Seletor de Cores");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new FlowLayout());

        // Criando um JLabel
        JLabel label = new JLabel("Escolha uma cor:");

        // Criando o JComboBox com opções de cores
        String[] cores = {"Vermelho", "Verde", "Azul", "Amarelo", "Preto", "Branco"};
        JComboBox<String> comboBox = new JComboBox<>(cores);

        // Botão para confirmar a seleção
        JButton button = new JButton("Selecionar");

        // Ação do botão
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String corSelecionada = (String) comboBox.getSelectedItem();
                JOptionPane.showMessageDialog(frame, "Você selecionou a cor: " + corSelecionada);
            }
        });

        // Adicionando componentes ao frame
        frame.add(label);
        frame.add(comboBox);
        frame.add(button);

        // Exibindo o frame
        frame.setVisible(true);
    }
}
