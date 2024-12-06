import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class CadastroUsuariosSwing extends JFrame {

    private JTextField nomeField;
    private JTextField emailField;
    private JPasswordField senhaField;
    private JLabel mensagemLabel;
    private Map<String, Usuario> usuarios = new HashMap<>();


    public CadastroUsuariosSwing() {
        setTitle("Cadastro de Usuários");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2, 10, 10)); // Grid para organização

        // Labels e Campos de Texto
        add(new JLabel("Nome:"));
        nomeField = new JTextField();
        add(nomeField);

        add(new JLabel("Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("Senha:"));
        senhaField = new JPasswordField();
        add(senhaField);

        // Botão Cadastrar
        JButton cadastrarButton = new JButton("Cadastrar");
        cadastrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastrarUsuario();
            }
        });
        add(cadastrarButton);

        // Mensagem de Sucesso ou Erro
        mensagemLabel = new JLabel("");
        add(mensagemLabel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }


    private void cadastrarUsuario() {
        String nome = nomeField.getText();
        String email = emailField.getText();
        String senha = new String(senhaField.getPassword()); //Importante: pegar senha de JPasswordField

        Usuario usuario = new Usuario(nome, email, senha);

        if (!usuario.validarEmail()) {
            mensagemLabel.setText("Email inválido.");
            return;
        }

        if (!usuario.validarSenha(6)) {
            mensagemLabel.setText("Senha inválida (mínimo 6 caracteres).");
            return;
        }

        usuarios.put(email, usuario);
        mensagemLabel.setText("Usuário cadastrado com sucesso!");

        //Limpa os campos
        nomeField.setText("");
        emailField.setText("");
        senhaField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CadastroUsuariosSwing();
            }
        });
    }
}