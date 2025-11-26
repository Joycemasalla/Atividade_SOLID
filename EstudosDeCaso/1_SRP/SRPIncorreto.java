// Problema: Esta classe tem múltiplas responsabilidades
class Usuario {
    private String nome;
    private String email;
    private String senha;
    
    public Usuario(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }
    
    // Responsabilidade 1: Validação de email
    public boolean validarEmail() {
        if (email == null || !email.contains("@")) {
            System.out.println("Email inválido!");
            return false;
        }
        return true;
    }
    
    // Responsabilidade 2: Persistência no banco de dados
    public void salvarNoBanco() {
        if (!validarEmail()) {
            return;
        }
        
        System.out.println("Conectando ao banco de dados...");
        System.out.println("INSERT INTO usuarios VALUES ('" + nome + "', '" + email + "', '" + senha + "')");
        System.out.println("Usuário salvo no banco de dados!");
    }
    
    // Responsabilidade 3: Envio de email
    public void enviarEmailBoasVindas() {
        System.out.println("Conectando ao servidor SMTP...");
        System.out.println("Enviando email para: " + email);
        System.out.println("Assunto: Bem-vindo!");
        System.out.println("Corpo: Olá " + nome + ", seja bem-vindo!");
        System.out.println("Email enviado com sucesso!");
    }
    
    // Responsabilidade 4: Registro completo do usuário
    public void registrar() {
        salvarNoBanco();
        enviarEmailBoasVindas();
    }
    
    public String getNome() {
        return nome;
    }
    
    public String getEmail() {
        return email;
    }
}

// Classe principal para testar
public class SRPIncorreto {
    public static void main(String[] args) {
        System.out.println("=== EXEMPLO INCORRETO - VIOLANDO SRP ===\n");
        
        Usuario usuario = new Usuario("João Silva", "joao@email.com", "senha123");
        usuario.registrar();
        
        System.out.println("\n=== PROBLEMAS DESTA ABORDAGEM ===");
        System.out.println("1. A classe Usuario tem 4 responsabilidades diferentes");
        System.out.println("2. Mudanças no envio de email afetam a classe Usuario");
        System.out.println("3. Mudanças no banco de dados afetam a classe Usuario");
        System.out.println("4. Difícil de testar cada funcionalidade isoladamente");
        System.out.println("5. Alto acoplamento e baixa coesão");
    }
}