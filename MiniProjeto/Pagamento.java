package MiniProjeto;

// Aplica LSP: Todas as formas de pagamento podem substituir a classe base

// Classe base
class Pagamento {
    protected String tipo;

    public Pagamento(String tipo) {
        this.tipo = tipo;
    }

    public void processar(double valor) {
        System.out.println("\n=== PAGAMENTO ===");
        System.out.println("Tipo: " + tipo);
        System.out.println("Valor: R$ " + valor);
        System.out.println(" Pagamento aprovado!");
    }

    public String getTipo() {
        return tipo;
    }
}

// LSP: Dinheiro pode substituir Pagamento
class Dinheiro extends Pagamento {
    private double valorRecebido;

    public Dinheiro(double valorRecebido) {
        super("Dinheiro");
        this.valorRecebido = valorRecebido;
    }

    public void processar(double valor) {
        System.out.println("\n=== PAGAMENTO ===");
        System.out.println("Tipo: " + tipo);
        System.out.println("Valor: R$ " + valor);
        System.out.println("Recebido: R$ " + valorRecebido);
        double troco = valorRecebido - valor;
        if (troco > 0) {
            System.out.println("Troco: R$ " + troco);
        }
        System.out.println(" Pagamento aprovado!");
    }
}

// LSP: Cartão pode substituir Pagamento
class Cartao extends Pagamento {
    public Cartao() {
        super("Cartão");
    }
}

// LSP: PIX pode substituir Pagamento
class PIX extends Pagamento {
    public PIX() {
        super("PIX");
    }
}