// Problema: Interface "gorda" com muitos métodos não relacionados
interface Trabalhador {
    void trabalhar();
    void comer();
    void receberSalario();
    void programar();
    void atenderCliente();
    void dirigir();
}

// Desenvolvedor é forçado a implementar métodos que não usa
class Desenvolvedor implements Trabalhador {
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
    
    // PROBLEMA: Forçado a implementar
    public void atenderCliente() {
        throw new UnsupportedOperationException(
            "Desenvolvedor não atende cliente!");
    }
    
    // PROBLEMA: Forçado a implementar
    public void dirigir() {
        throw new UnsupportedOperationException(
            "Desenvolvedor não dirige!");
    }
}

// Atendente é forçado a implementar métodos que não usa
class Atendente implements Trabalhador {
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
    
    // PROBLEMA: Forçado a implementar
    public void programar() {
        throw new UnsupportedOperationException(
            "Atendente não programa!");
    }
    
    // PROBLEMA: Forçado a implementar
    public void dirigir() {
        throw new UnsupportedOperationException(
            "Atendente não dirige!");
    }
}

// Motorista é forçado a implementar métodos que não usa
class Motorista implements Trabalhador {
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
    
    // PROBLEMA: Forçado a implementar
    public void programar() {
        throw new UnsupportedOperationException(
            "Motorista não programa!");
    }
    
    // PROBLEMA: Forçado a implementar
    public void atenderCliente() {
        throw new UnsupportedOperationException(
            "Motorista não atende cliente!");
    }
}


        
        // == PROBLEMAS DESTA ABORDAGEM ===
        // Interface 'gorda' com métodos não relacionados
        // Classes forçadas a implementar métodos desnecessários
        // Implementações que lançam exceções
        // Alto acoplamento e baixa coesão
        // Viola o princípio ISP
