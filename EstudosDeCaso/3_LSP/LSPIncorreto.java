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


        
    //    === PROBLEMAS DESTA ABORDAGEM ===
    //     PatoDeBorracha não pode substituir Pato
    //     Viola o contrato da classe base
    //     Lança exceção em método herdado
    //     Quebra o polimorfismo
    //     Viola o princípio de Liskov
    