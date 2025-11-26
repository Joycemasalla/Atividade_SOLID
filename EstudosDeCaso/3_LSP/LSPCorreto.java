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

// Classe principal para testar
public class LSPCorreto {
    public static void main(String[] args) {
        System.out.println("=== EXEMPLO CORRETO - APLICANDO LSP ===\n");
        
        SimuladorPatinhos simulador = new SimuladorPatinhos();
        
        Pato pato1 = new PatoSelvagem("Donald");
        simulador.simularComportamentoBasico(pato1);
        
        Pato pato2 = new PatoDomestico("Daisy");
        simulador.simularComportamentoBasico(pato2);
        
        Pato pato3 = new PatoDeBorracha("Patinho Amarelo");
        simulador.simularComportamentoBasico(pato3);
        
        System.out.println("\n--- Testando capacidade de voo ---");
        
        if (pato1 instanceof PatoVoador) {
            simulador.simularVoo((PatoVoador) pato1);
        }
        
        if (pato3 instanceof PatoVoador) {
            simulador.simularVoo((PatoVoador) pato3);
        } else {
            System.out.println("\n" + pato3.getNome() + 
                " não pode voar (não implementa PatoVoador)");
        }
        
        System.out.println("\n=== MELHORIAS OBTIDAS ===");
        System.out.println("1. Hierarquia de classes bem projetada");
        System.out.println("2. Subtipos podem substituir tipos base sem problemas");
        System.out.println("3. Não há lançamento de exceções inesperadas");
        System.out.println("4. Polimorfismo funciona corretamente");
        System.out.println("5. Aplica corretamente o princípio de Liskov");
    }
}