// Classe 1: Responsabilidade única - Representar dados do usuário
class Usuario {
    private String nome;
    private String email;
    private String senha;
    
    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getSenha() {
        return senha;
    }
}

// Classe 2: Responsabilidade única - Validar emails
class ValidadorEmail {
    public boolean validar(String email) {
        if (email == null || !email.contains("@")) {
            System.out.println("Email inválido!");
            return false;
        }
        return true;
    }
}

// Classe 3: Responsabilidade única - Persistência de usuários
class RepositorioUsuario {
    public void salvar(Usuario usuario) {
        System.out.println("Conectando ao banco de dados...");
        System.out.println("INSERT INTO usuarios VALUES ('" + 
            usuario.getNome() + "', '" + 
            usuario.getEmail() + "', '" + 
            usuario.getSenha() + "')");
        System.out.println("Usuário salvo no banco de dados!");
    }
}

// Classe 4: Responsabilidade única - Envio de emails
class ServicoEmail {
    public void enviarBoasVindas(Usuario usuario) {
        System.out.println("Conectando ao servidor SMTP...");
        System.out.println("Enviando email para: " + usuario.getEmail());
        System.out.println("Assunto: Bem-vindo!");
        System.out.println("Corpo: Olá " + usuario.getNome() + ", seja bem-vindo!");
        System.out.println("Email enviado com sucesso!");
    }
}

// Classe 5: Responsabilidade única - Coordenar o registro de usuários
class ServicoRegistroUsuario {
    private ValidadorEmail validador;
    private RepositorioUsuario repositorio;
    private ServicoEmail servicoEmail;
    
    public ServicoRegistroUsuario() {
        this.validador = new ValidadorEmail();
        this.repositorio = new RepositorioUsuario();
        this.servicoEmail = new ServicoEmail();
    }
    
    public void registrar(Usuario usuario) {
        if (!validador.validar(usuario.getEmail())) {
            return;
        }
        
        repositorio.salvar(usuario);
        servicoEmail.enviarBoasVindas(usuario);
    }
}

        
        // == MELHORIAS OBTIDAS ===
        // Cada classe tem uma única responsabilidade
        // Mudanças no envio de email afetam apenas ServicoEmail
        // Mudanças no banco afetam apenas RepositorioUsuario
        // Fácil de testar cada funcionalidade isoladamente
        // Alto nível de coesão e baixo acoplamento
        // Fácil de manter e estender
  