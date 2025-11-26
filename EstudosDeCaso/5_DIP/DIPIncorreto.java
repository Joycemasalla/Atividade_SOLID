// Classe de baixo nível - implementação concreta
class MySQLBancoDados {
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

// PROBLEMA: Classe de alto nível depende diretamente da implementação MySQL
class ServicoUsuario {
    // Dependência direta de classe concreta
    private MySQLBancoDados bancoDados;
    
    public ServicoUsuario() {
        // Criação direta da dependência - ALTO ACOPLAMENTO
        this.bancoDados = new MySQLBancoDados();
    }
    
    public void registrarUsuario(String nome, String email) {
        System.out.println("Iniciando registro de usuário...");
        bancoDados.conectar();
        bancoDados.salvarUsuario(nome, email);
        bancoDados.desconectar();
        System.out.println("Registro finalizado!");
    }
}

// Se quisermos usar outro banco, precisamos modificar ServicoUsuario
class PostgreSQLBancoDados {
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


        // == PROBLEMAS DESTA ABORDAGEM ===
        // ServicoUsuario depende diretamente de MySQLBancoDados
        // Alto acoplamento entre classes
        // Para trocar o BD, precisa modificar ServicoUsuario
        // Difícil de testar (não pode usar mock)
        // Viola o princípio DIP
        // Sistema rígido e pouco flexível
 