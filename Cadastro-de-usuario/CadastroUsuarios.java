import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CadastroUsuarios {
    private static Map<String, Usuario> usuarios = new HashMap<>();
    private static final int TAMANHO_MINIMO_SENHA = 6; // Define tamanho mínimo da senha

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Cadastrar usuário");
            System.out.println("2. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1:
                    cadastrarUsuario(scanner);
                    break;
                case 2:
                    System.out.println("Saindo...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
        }
    }

    private static void cadastrarUsuario(Scanner scanner) {
        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Senha: ");
        String senha = scanner.nextLine();


        Usuario usuario = new Usuario(nome, email, senha);

        if (!usuario.validarEmail()) {
            System.out.println("Email inválido.");
            return;
        }

        if (!usuario.validarSenha(TAMANHO_MINIMO_SENHA)) {
            System.out.println("Senha inválida.  A senha deve ter pelo menos " + TAMANHO_MINIMO_SENHA + " caracteres.");
            return;
        }

        usuarios.put(email, usuario); // Usando email como chave
        System.out.println("Usuário cadastrado com sucesso!");
        System.out.println(usuario); // Mostra os dados do usuário cadastrado.
    }
}