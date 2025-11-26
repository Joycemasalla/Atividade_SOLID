// ABSTRAÇÃO - ambos alto e baixo nível dependem disso
interface BancoDados {
    void conectar();
    void salvarUsuario(String nome, String email);
    void desconectar();
}

// Implementação concreta 1 - depende da abstração
class MySQLBancoDados implements BancoDados {
    public void conectar() {
        System.out.println("Conectando ao MySQL...");
    }
    
    public void salvarUsuario(String nome, String email) {
        System.out.println("MySQL: INSERT INTO usuarios (nome, email) VALUES ('" + 
            nome + "', '" + email + "')");
        System.out.println("Usuário salvo no MySQL!");
    }
    
    public void desconectar() {
        System.out.println("Desconectando do MySQL...");
    }
}

// Implementação concreta 2 - depende da abstração
class PostgreSQLBancoDados implements BancoDados {
    public void conectar() {
        System.out.println("Conectando ao PostgreSQL...");
    }
    
    public void salvarUsuario(String nome, String email) {
        System.out.println("PostgreSQL: INSERT INTO usuarios (nome, email) VALUES ('" + 
            nome + "', '" + email + "')");
        System.out.println("Usuário salvo no PostgreSQL!");
    }
    
    public void desconectar() {
        System.out.println("Desconectando do PostgreSQL...");
    }
}

// Implementação concreta 3 - para testes
class BancoDadosMemoria implements BancoDados {
    public void conectar() {
        System.out.println("Conectando ao banco em memória (teste)...");
    }
    
    public void salvarUsuario(String nome, String email) {
        System.out.println("Memória: Usuário salvo em cache temporário");
        System.out.println("Nome: " + nome + ", Email: " + email);
    }
    
    public void desconectar() {
        System.out.println("Limpando cache...");
    }
}

// Classe de alto nível - depende da ABSTRAÇÃO
class ServicoUsuario {
    // Depende da interface, não da implementação concreta
    private BancoDados bancoDados;
    
    // Injeção de dependência via construtor
    public ServicoUsuario(BancoDados bancoDados) {
        this.bancoDados = bancoDados;
    }
    
    public void registrarUsuario(String nome, String email) {
        System.out.println("Iniciando registro de usuário...");
        bancoDados.conectar();
        bancoDados.salvarUsuario(nome, email);
        bancoDados.desconectar();
        System.out.println("Registro finalizado!");
    }
}

// Classe principal para testar
public class DIPCorreto {
    public static void main(String[] args) {
        System.out.println("=== EXEMPLO CORRETO - APLICANDO DIP ===\n");
        
        // Usando MySQL
        System.out.println("--- Teste com MySQL ---");
        BancoDados mysql = new MySQLBancoDados();
        ServicoUsuario servico1 = new ServicoUsuario(mysql);
        servico1.registrarUsuario("João Silva", "joao@email.com");
        
        System.out.println("\n--- Teste com PostgreSQL ---");
        // Trocando para PostgreSQL SEM modificar ServicoUsuario!
        BancoDados postgres = new PostgreSQLBancoDados();
        ServicoUsuario servico2 = new ServicoUsuario(postgres);
        servico2.registrarUsuario("Maria Santos", "maria@email.com");
        
        System.out.println("\n--- Teste com Banco em Memória (Mock) ---");
        // Usando mock para testes
        BancoDados memoria = new BancoDadosMemoria();
        ServicoUsuario servico3 = new ServicoUsuario(memoria);
        servico3.registrarUsuario("Pedro Costa", "pedro@email.com");
        
        System.out.println("\n=== MELHORIAS OBTIDAS ===");
        System.out.println("1. ServicoUsuario depende de abstração");
        System.out.println("2. Baixo acoplamento entre classes");
        System.out.println("3. Fácil trocar implementação");
        System.out.println("4. Fácil de testar (pode usar mocks)");
        System.out.println("5. Aplica corretamente o princípio DIP");
        System.out.println("6. Sistema flexível e extensível");
    }
}