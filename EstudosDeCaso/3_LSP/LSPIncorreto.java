// Problema: Pato de Borracha não pode voar, mas herda de Pato
class Pato {
    protected String nome;
    
    public Pato(String nome) {
        this.nome = nome;
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

class PatoSelvagem extends Pato {
    public PatoSelvagem(String nome) {
        super(nome);
    }
}

class PatoDomestico extends Pato {
    public PatoDomestico(String nome) {
        super(nome);
    }
}

// PROBLEMA: PatoDeBorracha NÃO pode voar!
class PatoDeBorracha extends Pato {
    public PatoDeBorracha(String nome) {
        super(nome);
    }
    
    public void voar() {
        // Viola o LSP!
        throw new UnsupportedOperationException(
            "Pato de borracha não pode voar!");
    }
    
    public void emitirSom() {
        System.out.println(nome + " faz: Squeak! (som de borracha)");
    }
}

// Classe que usa patos de forma polimórfica
class SimuladorPatinhos {
    public void simular(Pato pato) {
        System.out.println("\n--- Simulando comportamento ---");
        pato.nadar();
        pato.voar();  // PROBLEMA: Pode lançar exceção!
        pato.emitirSom();
    }
}

// Classe principal para testar
public class LSPIncorreto {
    public static void main(String[] args) {
        System.out.println("=== EXEMPLO INCORRETO - VIOLANDO LSP ===\n");
        
        SimuladorPatinhos simulador = new SimuladorPatinhos();
        
        Pato pato1 = new PatoSelvagem("Donald");
        simulador.simular(pato1);
        
        Pato pato2 = new PatoDomestico("Daisy");
        simulador.simular(pato2);
        
        System.out.println("\nAgora com PatoDeBorracha:");
        try {
            Pato pato3 = new PatoDeBorracha("Patinho Amarelo");
            simulador.simular(pato3); // Vai lançar exceção!
        } catch (UnsupportedOperationException e) {
            System.out.println("ERRO: " + e.getMessage());
        }
        
        System.out.println("\n=== PROBLEMAS DESTA ABORDAGEM ===");
        System.out.println("1. PatoDeBorracha não pode substituir Pato");
        System.out.println("2. Viola o contrato da classe base");
        System.out.println("3. Lança exceção em método herdado");
        System.out.println("4. Quebra o polimorfismo");
        System.out.println("5. Viola o princípio de Liskov");
    }
}