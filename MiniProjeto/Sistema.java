package MiniProjeto;

public class Sistema {

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("    SISTEMA DE VENDAS - SOLID");
        System.out.println("========================================");

        // 1. CADASTRO DE PRODUTOS (SRP)
        CadastroProdutos cadastro = new CadastroProdutos();
        cadastro.listar();

        System.out.println("\n\n*** CENÁRIO 1 - VENDA COMUM ***");

        // 2. REGISTRO DE PEDIDO (SRP)
        Pedido pedido1 = new Pedido("João Silva");
        pedido1.adicionar(cadastro.buscar(1)); // Notebook
        pedido1.adicionar(cadastro.buscar(2)); // Mouse
        pedido1.mostrar();

        // 3. APLICAÇÃO DE DESCONTO (OCP)
        Desconto desconto1 = new Desconto10();
        double valorDesconto1 = desconto1.calcular(pedido1.calcularTotal());
        System.out.println("\n" + desconto1.getTipo() + ": -R$ " + valorDesconto1);

        // 4. APLICAÇÃO DE FRETE (OCP)
        Frete frete1 = new FreteNormal();
        double valorFrete1 = frete1.calcular();
        System.out.println(frete1.getTipo() + ": +R$ " + valorFrete1);

        double total1 = pedido1.calcularTotal() - valorDesconto1 + valorFrete1;
        System.out.println("\nTOTAL: R$ " + total1);

        // 5. FORMA DE PAGAMENTO (LSP)
        Pagamento pagamento1 = new Cartao();
        pagamento1.processar(total1);

        // 6. EMISSÃO DE COMPROVANTE (DIP)
        Comprovante comprovante1 = new Comprovante(new ImpressoraSimples());
        comprovante1.emitir(pedido1, valorDesconto1, valorFrete1, total1, pagamento1.getTipo());

        // 7. NOTIFICAÇÃO (ISP)
        Notificador notif1 = new Notificador("joao@email.com");
        notif1.enviar("Pedido confirmado! Total: R$ " + total1);

        System.out.println("\n\n*** CENÁRIO 2 - CLIENTE VIP ***");

        Pedido pedido2 = new Pedido("Maria Santos");
        pedido2.adicionar(cadastro.buscar(3)); // Teclado
        pedido2.adicionar(cadastro.buscar(4)); // Monitor
        pedido2.mostrar();

        // DESCONTO VIP (OCP - nova estratégia)
        Desconto desconto2 = new DescontoVIP();
        double valorDesconto2 = desconto2.calcular(pedido2.calcularTotal());
        System.out.println("\n" + desconto2.getTipo() + ": -R$ " + valorDesconto2);

        // SEM FRETE (OCP)
        Frete frete2 = new Frete();
        double valorFrete2 = frete2.calcular();
        System.out.println(frete2.getTipo() + ": +R$ " + valorFrete2);

        double total2 = pedido2.calcularTotal() - valorDesconto2 + valorFrete2;
        System.out.println("\nTOTAL: R$ " + total2);

        // PAGAMENTO PIX (LSP)
        Pagamento pagamento2 = new PIX();
        pagamento2.processar(total2);

        // COMPROVANTE FORMATADO (DIP - troca implementação)
        Comprovante comprovante2 = new Comprovante(new ImpressoraFormatada());
        comprovante2.emitir(pedido2, valorDesconto2, valorFrete2, total2, pagamento2.getTipo());

        // NOTIFICAÇÃO (ISP)
        Notificador notif2 = new Notificador("maria@email.com");
        notif2.enviar("Pedido VIP confirmado! Total: R$ " + total2);

        System.out.println("\n\n*** CENÁRIO 3 - PAGAMENTO DINHEIRO ***");

        Pedido pedido3 = new Pedido("Pedro Costa");
        pedido3.adicionar(cadastro.buscar(2)); // Mouse
        pedido3.mostrar();

        // SEM DESCONTO (OCP)
        Desconto desconto3 = new Desconto();
        double valorDesconto3 = desconto3.calcular(pedido3.calcularTotal());
        System.out.println("\n" + desconto3.getTipo());

        // FRETE EXPRESSO (OCP)
        Frete frete3 = new FreteExpresso();
        double valorFrete3 = frete3.calcular();
        System.out.println(frete3.getTipo() + ": +R$ " + valorFrete3);

        double total3 = pedido3.calcularTotal() - valorDesconto3 + valorFrete3;
        System.out.println("\nTOTAL: R$ " + total3);

        // PAGAMENTO DINHEIRO (LSP)
        Pagamento pagamento3 = new Dinheiro(100.00);
        pagamento3.processar(total3);

        // COMPROVANTE (DIP)
        Comprovante comprovante3 = new Comprovante(new ImpressoraSimples());
        comprovante3.emitir(pedido3, valorDesconto3, valorFrete3, total3, pagamento3.getTipo());

        // NOTIFICAÇÃO (ISP)
        Notificador notif3 = new Notificador("pedro@email.com");
        notif3.enviar("Pedido confirmado!");

        System.out.println("\n\n========================================");
        System.out.println("   PRINCÍPIOS SOLID APLICADOS");
        System.out.println("========================================");
        System.out.println("\n SRP: Produto, CadastroProdutos, Pedido");
        System.out.println(" OCP: Desconto e Frete (extensíveis)");
        System.out.println(" LSP: Pagamento (Dinheiro, Cartão, PIX)");
        System.out.println(" ISP: Notificador (interface simples)");
        System.out.println(" DIP: Comprovante (depende de Impressora)");
        System.out.println("\n Todos os 5 princípios SOLID!");
    }
}