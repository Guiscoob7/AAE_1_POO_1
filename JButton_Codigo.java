import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Main extends JFrame implements ActionListener {
    private JButton b1, b2, b3;
    
    public Main() {
        // 🖼️ Inicialização dos ícones para os botões
        ImageIcon leftButtonIcon = createImageIcon("images/right.gif");
        ImageIcon middleButtonIcon = createImageIcon("images/middle.gif");
        ImageIcon rightButtonIcon = createImageIcon("images/left.gif");

        // 🔴 Configuração do botão 'Desabilitar botão do meio'
        b1 = new JButton("Desativar o botão do meio", leftButtonIcon);
        b1.setVerticalTextPosition(AbstractButton.CENTER);
        b1.setHorizontalTextPosition(AbstractButton.LEADING); // 🔄 Alinhamento à esquerda
        b1.setMnemonic(KeyEvent.VK_D); // ⌨️ Atalho de teclado Alt + D
        b1.setActionCommand("disable"); // 🛠️ Comando de ação "disable"

        // ⚪ Configuração do botão do meio
        b2 = new JButton("Botão do meio", middleButtonIcon);
        b2.setVerticalTextPosition(AbstractButton.BOTTOM);
        b2.setHorizontalTextPosition(AbstractButton.CENTER);
        b2.setMnemonic(KeyEvent.VK_M); // ⌨️ Atalho de teclado Alt + M

        // 🟢 Configuração do botão 'Habilitar botão do meio'
        b3 = new JButton("Ativar o botão do meio", rightButtonIcon);
        b3.setMnemonic(KeyEvent.VK_E); // ⌨️ Atalho de teclado Alt + E
        b3.setActionCommand("enable"); // 🛠️ Comando de ação "enable"
        b3.setEnabled(false); // 🔒 Começa desabilitado

        // 🎧 Adiciona os listeners aos botões
        b1.addActionListener(this);
        b3.addActionListener(this);

        // 📝 Define as dicas de ferramenta (Tooltips) divertidas
        b1.setToolTipText("⚡ Clique aqui para dar um descanso ao botão do meio!");
        b2.setToolTipText("😴 Este botão está de férias e não faz nada!");
        b3.setToolTipText("🚀 Clique aqui para devolver o poder ao botão do meio!");

        // 🖥️ Adiciona os botões ao painel
        JPanel panel = new JPanel();
        panel.add(b1);
        panel.add(b2);
        panel.add(b3);

        // 🏠 Configuração da janela principal
        add(panel);
        setTitle("Exemplo de Button Demo Divertido 🎉");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // 📍 Centraliza a janela
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // 🕹️ Define as ações dos botões com base no comando de ação
        if ("disable".equals(e.getActionCommand())) {
            b2.setEnabled(false); // ❌ Desabilita o botão do meio
            b1.setEnabled(false); // ❌ Desabilita o botão 1
            b3.setEnabled(true);  // ✅ Habilita o botão 3
        } else if ("enable".equals(e.getActionCommand())) {
            b2.setEnabled(true);  // ✅ Habilita o botão do meio
            b1.setEnabled(true);  // ✅ Habilita o botão 1
            b3.setEnabled(false); // ❌ Desabilita o botão 3
        }
    }

    // 🖼️ Método para criar um ImageIcon a partir de um caminho
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = Main.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("🚫 Caminho da imagem não encontrado: " + path);
            return null;
        }
    }

    // 🚀 Método principal para iniciar a aplicação
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Main demo = new Main();
            demo.setVisible(true); // 🖥️ Torna a janela visível
        });
    }
}
```
