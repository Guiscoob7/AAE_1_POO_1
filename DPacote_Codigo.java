import javax.swing.*;     
import java.awt.*;          
import java.awt.event.*;

public class ExemploDependencias extends JFrame {
    private JTextField textField;
    private JButton button;
    private JLabel label;

    public ExemploDependencias() {
        super("Exemplo de Dependências de Pacotes");

        setLayout(new BorderLayout());   
        textField = new JTextField("Digite algo...");
        textField.setHorizontalAlignment(JTextField.CENTER);
        add(textField, BorderLayout.NORTH);

        button = new JButton("Clique Aqui!");
        add(button, BorderLayout.CENTER);
        label = new JLabel("Saída:", SwingConstants.CENTER);
        add(label, BorderLayout.SOUTH);
        button.addActionListener(new ButtonClickListener());
        textField.addKeyListener(new TextFieldKeyListener());  

        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);  // Centralizar na tela
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String input = textField.getText();
            label.setText("Botão clicado! Você digitou: " + input.toUpperCase());
        }
    }

    private class TextFieldKeyListener implements KeyListener {
        @Override
        public void keyTyped(KeyEvent e) { }

        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                String input = textField.getText(); 
                label.setText("Enter pressionado! Você digitou: " + input);
            }
        }

        @Override
        public void keyReleased(KeyEvent e) { }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ExemploDependencias exemplo = new ExemploDependencias();
            exemplo.setVisible(true);
        });
    }
}
