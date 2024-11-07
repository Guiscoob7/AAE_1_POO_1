```java
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InterfaceExemplo extends JFrame {

    public InterfaceExemplo() {
        // JFrame
        super("Exemplo de Interface");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout());
        JButton button1 = new JButton("Botão 1");
        JButton button2 = new JButton("Botão 2");
        buttonsPanel.add(button1);
        buttonsPanel.add(button2);
        tabbedPane.addTab("Botões", buttonsPanel);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        
        JTextField textField = new JTextField(10);
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Campo de Texto:"), gbc);
        gbc.gridx = 1;
        formPanel.add(textField, gbc);
        
        JComboBox<String> comboBox = new JComboBox<>(new String[] {"Opção 1", "Opção 2", "Opção 3"});
        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("ComboBox:"), gbc);
        gbc.gridx = 1;
        formPanel.add(comboBox, gbc);
        
        tabbedPane.addTab("Formulário", formPanel);

        add(tabbedPane, BorderLayout.CENTER);

        // janela
        setSize(400, 300);
        setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("Botão 1 clicado");
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText("Botão 2 clicado");
            }
        });

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Item selecionado: " + comboBox.getSelectedItem());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new InterfaceExemplo());
    }
}
