# cadastro-usuario-java

Vamos detalhar a explicação da lógica de validação, o uso do HashMap e as
modificações feitas no código para a interface Swing.

1. Lógica de Validação:

A validação é crucial para garantir a integridade dos dados. 
No nosso sistema, a validação ocorre na classe Usuario:

validarEmail(): Este método usa uma expressão regular (regex) 
para verificar se o email fornecido tem um formato válido. 
A expressão regular ^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$ é uma verificação básica. 
Expressões regulares mais robustas podem ser usadas para uma validação mais completa, 
mas esta atende ao propósito do exemplo. O método retorna true se o email for válido e false caso contrário. 
importância de usar expressões regulares para validação de email.
validarSenha(int tamanhoMinimo): Este método verifica se a senha tem um comprimento mínimo especificado.
Ele recebe o tamanhoMinimo como parâmetro, permitindo flexibilidade. 
O método retorna true se a senha atender ao critério de comprimento mínimo e false caso contrário. 
Importância de validar o tamanho da senha como uma medida de segurança básica.
No método cadastrarUsuario (tanto na versão de linha de comando quanto na Swing), 
as funções de validação são chamadas antes de adicionar o usuário ao HashMap. 
Se qualquer uma das validações falhar, uma mensagem de erro apropriada é exibida, e o usuário não é cadastrado.
Essa abordagem garante a consistência dos dados armazenados.

2. Uso do HashMap:

O HashMap é uma estrutura de dados que armazena pares chave-valor. 
No nosso código, usamos o HashMap para armazenar os usuários cadastrados.
Chave: A chave do HashMap é o email do usuário (String). Usamos o email como chave porque é, 
geralmente, único e serve como um bom identificador para cada usuário.

Valor: O valor é um objeto da classe Usuario que contém todas as informações do usuário 
(nome, email e senha).

O HashMap oferece acesso rápido aos usuários com base em seus emails. Para acessar um usuário 
específico, basta usar o email como chave no HashMap. 
Vantagens de usar um HashMap em vez de outras estruturas de dados, como arrays, em termos de 
desempenho de busca.

2. Compile o código:
Abra um terminal ou prompt de comando e navegue até o diretório onde você salvou os arquivos. 
Em seguida, compile os arquivos usando o compilador Java (javac):
javac Usuario.java CadastroUsuarios.java


Se não houver erros de compilação, você verá dois arquivos .class gerados 
( Usuario.class e CadastroUsuarios.class).
3. Execute o código:
Após a compilação bem-sucedida, execute o programa usando o interpretador Java (java):
java CadastroUsuarios


3. Modificações para a Interface Swing:

A versão Swing introduz uma interface gráfica usando componentes Swing. As principais mudanças 
foram:

Componentes Swing: Criamos JTextField para o nome e email, JPasswordField para a senha 
(para ocultar a senha), JButton para cadastrar, e JLabel para exibir mensagens. A organização 
foi feita usando GridLayout.

Tratamento de Eventos: Um ActionListener foi adicionado ao botão "Cadastrar" 
para lidar com o evento de clique. Quando o botão é clicado, o método cadastrarUsuario() é chamado.

Exibição de Mensagens: O JLabel chamado mensagemLabel serve para exibir 
mensagens de erro ou sucesso ao usuário.

new String(senhaField.getPassword()): Note que para obter a senha de um JPasswordField, 
você precisa usar new String(senhaField.getPassword()) para convertê-la em uma String.

/-------/------------/---------------/-----------------/-----------------/---------------/------------/


Windows:
1.	Baixar e instalar o JDK: Baixe o JDK (Java Development Kit) da página oficial da Oracle 
(ou outra distribuição como a AdoptOpenJDK/Temurin, que é uma alternativa gratuita e de código aberto).
Certifique-se de baixar a versão correta para o seu sistema operacional (Windows x64 ou x86).
2.	Instalar o JDK: Execute o instalador e siga as instruções. Anote o diretório de instalação 
(geralmente algo como C:\Program Files\Java\jdk-17).
3.	Configurar a variável de ambiente PATH:
o	Abra o menu Iniciar e procure por "variáveis de ambiente".
o	Clique em "Editar as variáveis de ambiente do sistema".
o	Na janela "Propriedades do Sistema", clique em "Variáveis de ambiente...".
o	Na seção "Variáveis do sistema", encontre a variável Path (ou PATH) e selecione-a. 
Clique em "Editar...".
o	Clique em "Novo" e adicione o caminho para o diretório bin do seu JDK. Por exemplo, se o 
seu JDK estiver em C:\Program Files\Java\jdk-17, você adicionaria 
C:\Program Files\Java\jdk-17\bin. Importante: Certifique-se de que você adicione o 
caminho para a pasta bin e não para a pasta jdk!
o	Clique em "OK" em todas as janelas abertas para salvar as alterações.
4.	Reinicie o terminal ou prompt de comando: Para que as alterações no PATH surtam efeito, 
você precisa fechar e reabrir o terminal ou prompt de comando.
5.	Verifique se funcionou: Tente novamente o comando javac Usuario.java CadastroUsuarios.java. 
Se tudo estiver correto, a compilação deverá funcionar.
macOS/Linux:
Em sistemas macOS e Linux, a instalação e configuração do JDK variam um pouco dependendo do seu gerenciador de pacotes 
(Homebrew, apt, yum, etc.). Aqui estão as etapas gerais:
1.	Instalação do JDK: Use o gerenciador de pacotes do seu sistema para instalar o JDK. 
Por exemplo:
o	Homebrew (macOS): brew install java (verifique se você tem o Homebrew instalado)
o	apt (Debian/Ubuntu): sudo apt update && sudo apt install default-jdk
o	yum (Fedora/CentOS/RHEL): sudo yum install java-17-openjdk-devel (substitua 17 pela versão 
desejada se necessário)
2.	Verificar instalação: Após a instalação, verifique a versão do Java instalada: java -version e javac -version. Se ambos os comandos retornarem uma versão, o JDK está instalado corretamente.
3.	Configuração do PATH (opcional, em alguns casos): Em alguns casos, o PATH pode não ser 
configurado automaticamente. Se os comandos javac e java não funcionam após a instalação, 
você pode precisar adicionar o diretório bin do JDK ao seu PATH. A maneira de fazer isso varia 
dependendo da sua distribuição Linux, mas geralmente envolve editar um arquivo de configuração 
do shell (como .bashrc ou .zshrc).

--*********************************************-*******************************************--


Vamos considerar as duas abordagens: linha de comando e Swing, para o seu sistema de cadastro 
de usuários.
1. Interface de Linha de Comando (Console):
Esta é a abordagem mais simples. O código que já desenvolvemos anteriormente usa interface de 
linha de comando. Você apenas precisa executar o CadastroUsuarios.java via terminal. Ele irá
 interagir com o usuário através da entrada e saída do console.
Vantagens:
•	Simples: Fácil de implementar e entender.
•	Rápido: Não requer bibliotecas adicionais para interfaces gráficas.
•	Ideal para entrevistas: Para demonstrações em entrevistas, a simplicidade e clareza são 
muito importantes. O foco é na lógica do programa, e não nos detalhes da interface gráfica.
Desvantagens:
•	Interface menos amigável: A interface é menos intuitiva do que uma GUI.
2. Interface Gráfica com Swing:
Swing é uma biblioteca Java para criar interfaces gráficas. É mais complexo, mas proporciona 
uma experiência de usuário melhor. Para um cadastro de usuários, você precisaria de campos de 
texto para o nome, email e senha, um botão para cadastrar e possivelmente mensagens de erro ou 
sucesso.

Para executar o código Swing:
1.	Certifique-se de ter o JDK instalado e configurado (conforme explicado anteriormente).
2.	Salve o código acima como CadastroUsuariosSwing.java.
3.	Compile usando javac CadastroUsuariosSwing.java Usuario.java (você precisa compilar ambos 
os arquivos)
4.	Execute usando java CadastroUsuariosSwing
