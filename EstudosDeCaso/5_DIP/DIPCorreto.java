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


        // == MELHORIAS OBTIDAS ===
        // ServicoUsuario depende de abstração
        // Baixo acoplamento entre classes
        // Fácil trocar implementação
        // Fácil de testar (pode usar mocks)
        // Aplica corretamente o princípio DIP
        // Sistema flexível e extensível
  