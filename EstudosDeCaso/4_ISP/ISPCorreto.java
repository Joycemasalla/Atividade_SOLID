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


        
        // == MELHORIAS OBTIDAS ===
        // Interfaces pequenas e específicas
        // Classes implementam apenas o necessário
        // Sem exceções ou implementações vazias
        // Baixo acoplamento e alta coesão
        // Flexibilidade para combinar interfaces
        // Aplica corretamente o princípio ISP
  