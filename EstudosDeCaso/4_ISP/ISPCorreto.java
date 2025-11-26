// Interface base - métodos comuns
interface Trabalhador {
    void trabalhar();
    void comer();
    void receberSalario();
}

// Interfaces específicas segregadas
interface Programador {
    void programar();
}

interface AtendimentoCliente {
    void atenderCliente();
}

interface Motorizado {
    void dirigir();
}

// Desenvolvedor implementa apenas o que precisa
class Desenvolvedor implements Trabalhador, Programador {
    private String nome;
    
    public Desenvolvedor(String nome) {
        this.nome = nome;
    }
    
    public void trabalhar() {
        System.out.println(nome + " está trabalhando...");
    }
    
    public void comer() {
        System.out.println(nome + " está almoçando...");
    }
    
    public void receberSalario() {
        System.out.println(nome + " recebeu o salário!");
    }
    
    public void programar() {
        System.out.println(nome + " está programando em Java...");
    }
}

// Atendente implementa apenas o que precisa
class Atendente implements Trabalhador, AtendimentoCliente {
    private String nome;
    
    public Atendente(String nome) {
        this.nome = nome;
    }
    
    public void trabalhar() {
        System.out.println(nome + " está trabalhando...");
    }
    
    public void comer() {
        System.out.println(nome + " está almoçando...");
    }
    
    public void receberSalario() {
        System.out.println(nome + " recebeu o salário!");
    }
    
    public void atenderCliente() {
        System.out.println(nome + " está atendendo cliente...");
    }
}

// Motorista implementa apenas o que precisa
class Motorista implements Trabalhador, Motorizado {
    private String nome;
    
    public Motorista(String nome) {
        this.nome = nome;
    }
    
    public void trabalhar() {
        System.out.println(nome + " está trabalhando...");
    }
    
    public void comer() {
        System.out.println(nome + " está almoçando...");
    }
    
    public void receberSalario() {
        System.out.println(nome + " recebeu o salário!");
    }
    
    public void dirigir() {
        System.out.println(nome + " está dirigindo o veículo...");
    }
}

// Exemplo: Trabalhador multifuncional
class GerenteAtendimento implements Trabalhador, AtendimentoCliente, Motorizado {
    private String nome;
    
    public GerenteAtendimento(String nome) {
        this.nome = nome;
    }
    
    public void trabalhar() {
        System.out.println(nome + " está gerenciando...");
    }
    
    public void comer() {
        System.out.println(nome + " está almoçando...");
    }
    
    public void receberSalario() {
        System.out.println(nome + " recebeu o salário!");
    }
    
    public void atenderCliente() {
        System.out.println(nome + " está atendendo cliente VIP...");
    }
    
    public void dirigir() {
        System.out.println(nome + " está fazendo entrega especial...");
    }
}

// Classe principal para testar
public class ISPCorreto {
    public static void main(String[] args) {
        System.out.println("=== EXEMPLO CORRETO - APLICANDO ISP ===\n");
        
        System.out.println("--- Desenvolvedor ---");
        Desenvolvedor dev = new Desenvolvedor("Carlos");
        dev.trabalhar();
        dev.comer();
        dev.programar();
        
        System.out.println("\n--- Atendente ---");
        Atendente atendente = new Atendente("Ana");
        atendente.trabalhar();
        atendente.comer();
        atendente.atenderCliente();
        
        System.out.println("\n--- Motorista ---");
        Motorista motorista = new Motorista("José");
        motorista.trabalhar();
        motorista.comer();
        motorista.dirigir();
        
        System.out.println("\n--- Gerente Multifuncional ---");
        GerenteAtendimento gerente = new GerenteAtendimento("Paula");
        gerente.trabalhar();
        gerente.atenderCliente();
        gerente.dirigir();
        
        System.out.println("\n=== MELHORIAS OBTIDAS ===");
        System.out.println("1. Interfaces pequenas e específicas");
        System.out.println("2. Classes implementam apenas o necessário");
        System.out.println("3. Sem exceções ou implementações vazias");
        System.out.println("4. Baixo acoplamento e alta coesão");
        System.out.println("5. Flexibilidade para combinar interfaces");
        System.out.println("6. Aplica corretamente o princípio ISP");
    }
}