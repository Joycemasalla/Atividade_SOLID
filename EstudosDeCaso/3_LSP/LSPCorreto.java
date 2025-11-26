// Interface base - todo pato pode nadar e emitir som
interface Pato {
    void nadar();
    void emitirSom();
    String getNome();
}

// Interface separada para patos que podem voar
interface PatoVoador extends Pato {
    void voar();
}

// Classe base para patos reais (que podem voar)
class PatoReal implements PatoVoador {
    protected String nome;
    
    public PatoReal(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void nadar() {
        System.out.println(nome + " está nadando...");
    }
    
    public void voar() {
        System.out.println(nome + " está voando...");
    }
    
    public void emitirSom() {
        System.out.println(nome + " faz: Quack! Quack!");
    }
}

class PatoSelvagem extends PatoReal {
    public PatoSelvagem(String nome) {
        super(nome);
    }
}

class PatoDomestico extends PatoReal {
    public PatoDomestico(String nome) {
        super(nome);
    }
}

// PatoDeBorracha implementa apenas Pato, não PatoVoador
class PatoDeBorracha implements Pato {
    private String nome;
    
    public PatoDeBorracha(String nome) {
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }
    
    public void nadar() {
        System.out.println(nome + " está boiando na água...");
    }
    
    public void emitirSom() {
        System.out.println(nome + " faz: Squeak! (som de borracha)");
    }
}

// Simulador trabalha apenas com comportamentos que todos têm
class SimuladorPatinhos {
    public void simularComportamentoBasico(Pato pato) {
        System.out.println("\n--- Simulando comportamento básico ---");
        pato.nadar();
        pato.emitirSom();
    }
    
    public void simularVoo(PatoVoador pato) {
        System.out.println("\n--- Simulando voo ---");
        pato.voar();
    }
}


        
        // == MELHORIAS OBTIDAS ===
        // Hierarquia de classes bem projetada
        // Subtipos podem substituir tipos base sem problemas
        // Não há lançamento de exceções inesperadas
        // Polimorfismo funciona corretamente
        // Aplica corretamente o princípio de Liskov
  