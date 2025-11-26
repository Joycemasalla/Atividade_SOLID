package MiniProjeto;

// Aplica DIP: Depende de abstração (Impressora)

// Classe abstrata (DIP - abstração)
class Impressora {
    public void imprimir(String texto) {
        System.out.println(texto);
    }
}

class ImpressoraSimples extends Impressora {
    public void imprimir(String texto) {
        System.out.println(texto);
    }
}

class ImpressoraFormatada extends Impressora {
    public void imprimir(String texto) {
        System.out.println("\n========================================");
        System.out.println(texto);
        System.out.println("========================================");
    }
}

// Emissor que DEPENDE DA ABSTRAÇÃO (DIP)
class Comprovante {
    private Impressora impressora;

    // Recebe a abstração (DIP)
    public Comprovante(Impressora impressora) {
        this.impressora = impressora;
    }

    public void emitir(Pedido pedido, double desconto, double frete, double total, String pagamento) {
        String texto = "\n*** COMPROVANTE ***\n\n";
        texto = texto + "Cliente: " + pedido.getCliente() + "\n";
        texto = texto + "Produtos:\n";

        for (int i = 0; i < pedido.getTotalProdutos(); i++) {
            Produto p = pedido.getProdutos()[i];
            texto = texto + "  - " + p.getNome() + " - R$ " + p.getPreco() + "\n";
        }

        texto = texto + "\nSubtotal: R$ " + pedido.calcularTotal() + "\n";
        texto = texto + "Desconto: -R$ " + desconto + "\n";
        texto = texto + "Frete: +R$ " + frete + "\n";
        texto = texto + "TOTAL: R$ " + total + "\n";
        texto = texto + "Pagamento: " + pagamento + "\n";
        texto = texto + "\nObrigado!";

        impressora.imprimir(texto);
    }
}

// Aplica ISP: Interface simples para notificação
class Notificador {
    private String email;

    public Notificador(String email) {
        this.email = email;
    }

    public void enviar(String mensagem) {
        System.out.println("\nEmail para: " + email);
        System.out.println("Mensagem: " + mensagem);
    }
}