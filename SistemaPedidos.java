// MINI-PROJETO: SISTEMA DE PEDIDOS E PAGAMENTOS
// Arquivo: SistemaPedidos.java
// Classe principal que integra todos os componentes

public class SistemaPedidos {
    
    private CatalogoProdutos catalogo;
    private CalculadoraDesconto calculadoraDesconto;
    private CalculadoraFrete calculadoraFrete;
    private GeradorComprovante geradorComprovante;
    private NotificadorEmail notificador;
    
    public SistemaPedidos() {
        // Inicialização dos componentes do sistema
        this.catalogo = new CatalogoProdutos();
        this.calculadoraDesconto = new CalculadoraDesconto();
        this.calculadoraFrete = new CalculadoraFrete();
        
        // Aplica DIP: Injeta a dependência do formatador
        this.geradorComprovante = new GeradorComprovante(new FormatadorTextoSimples());
        
        // Aplica ISP: Usa apenas a interface necessária
        this.notificador = new ServicoNotificacaoEmail();
    }
    
    public Pedido criarPedido() {
        return new Pedido();
    }
    
    public void adicionarItemAoPedido(Pedido pedido, String codigoProduto, int quantidade) {
        Produto produto = catalogo.buscarProduto(codigoProduto);
        if (produto == null) {
            System.out.println("Produto não encontrado: " + codigoProduto);
            return;
        }
        
        if (produto.getQuantidadeEstoque() < quantidade) {
            System.out.println("Estoque insuficiente para " + produto.getNome());
            return;
        }
        
        ItemPedido item = new ItemPedido(produto, quantidade);
        pedido.adicionarItem(item);
        produto.diminuirEstoque(quantidade);
        
        System.out.println("Item adicionado: " + item);
    }
    
    public boolean finalizarPedido(Pedido pedido, EstrategiaDesconto estrategiaDesconto,
                                   EstrategiaFrete estrategiaFrete, MetodoPagamento metodoPagamento,
                                   String emailCliente) {
        
        System.out.println("\n========================================");
        System.out.println("   FINALIZANDO PEDIDO " + pedido.getNumeroPedido());
        System.out.println("========================================");
        
        // Calcula subtotal
        double subtotal = pedido.calcularSubtotal();
        System.out.println(pedido);
        
        // Aplica OCP: Calcula desconto usando estratégia
        double desconto = calculadoraDesconto.aplicarDesconto(estrategiaDesconto, subtotal);
        System.out.println("\n" + calculadoraDesconto.obterDescricao(estrategiaDesconto) + 
                          ": -R$ " + String.format("%.2f", desconto));
        
        // Aplica OCP: Calcula frete usando estratégia
        double valorComDesconto = subtotal - desconto;
        double frete = calculadoraFrete.calcularFrete(estrategiaFrete, valorComDesconto);
        System.out.println(calculadoraFrete.obterDescricao(estrategiaFrete) + 
                          ": +R$ " + String.format("%.2f", frete));
        
        int diasEntrega = calculadoraFrete.obterDiasEntrega(estrategiaFrete);
        if (diasEntrega > 0) {
            System.out.println("Prazo de entrega: " + diasEntrega + " dias");
        }
        
        // Calcula total
        double total = valorComDesconto + frete;
        System.out.println(String.format("\nVALOR TOTAL: R$ %.2f", total));
        
        // Aplica LSP: Processa pagamento (qualquer subclasse de MetodoPagamento funciona)
        System.out.println("\n--- Processando Pagamento ---");
        boolean pagamentoAprovado = metodoPagamento.processar(total);
        
        if (!pagamentoAprovado) {
            System.out.println("Pedido cancelado - Pagamento não aprovado!");
            return false;
        }
        
        // Atualiza status do pedido
        pedido.setStatus("PAGO");
        
        // Aplica DIP: Gera comprovante usando a abstração
        String comprovante = geradorComprovante.gerar(
            pedido, desconto, frete, total,
            metodoPagamento.getNome(),
            calculadoraDesconto.obterDescricao(estrategiaDesconto),
            calculadoraFrete.obterDescricao(estrategiaFrete)
        );
        
        System.out.println(comprovante);
        
        // Aplica ISP: Envia notificação usando apenas interface necessária
        notificador.enviarEmail(
            emailCliente,
            "Confirmação de Pedido - " + pedido.getNumeroPedido(),
            "Seu pedido foi confirmado com sucesso!\n\n" + comprovante
        );
        
        System.out.println("\n✓ Pedido finalizado com sucesso!");
        return true;
    }
    
    public void listarProdutos() {
        catalogo.listarCatalogo();
    }
    
    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║  SISTEMA DE PEDIDOS E PAGAMENTOS - SOLID  ║");
        System.out.println("╚════════════════════════════════════════════╝\n");
        
        SistemaPedidos sistema = new SistemaPedidos();
        
        // Lista produtos disponíveis
        sistema.listarProdutos();
        
        // CENÁRIO 1: Pedido com desconto de primeira compra, frete expresso e cartão
        System.out.println("\n\n");
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║           CENÁRIO 1 - Pedido #1            ║");
        System.out.println("╚════════════════════════════════════════════╝");
        
        Pedido pedido1 = sistema.criarPedido();
        sistema.adicionarItemAoPedido(pedido1, "P001", 1); // Notebook
        sistema.adicionarItemAoPedido(pedido1, "P002", 2); // Mouse
        
        sistema.finalizarPedido(
            pedido1,
            new DescontoPrimeiraCompra(),           // OCP: Estratégia de desconto
            new FreteExpresso(),                     // OCP: Estratégia de frete
            new CartaoCredito("1234-5678-9012-3456", 3),  // LSP: Método de pagamento
            "cliente1@email.com"                     // ISP: Notificação por email
        );
        
        // CENÁRIO 2: Pedido com cliente VIP, frete grátis e PIX
        System.out.println("\n\n");
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║           CENÁRIO 2 - Pedido #2            ║");
        System.out.println("╚════════════════════════════════════════════╝");
        
        Pedido pedido2 = sistema.criarPedido();
        sistema.adicionarItemAoPedido(pedido2, "P003", 1); // Teclado
        sistema.adicionarItemAoPedido(pedido2, "P004", 2); // Monitor
        
        sistema.finalizarPedido(
            pedido2,
            new DescontoClienteVIP(),               // OCP: Outra estratégia
            new FreteGratis(500.0),                 // OCP: Outra estratégia
            new PIX("cliente2@email.com"),          // LSP: Outro método
            "cliente2@email.com"
        );
        
        // CENÁRIO 3: Pedido com cupom, retirada na loja e boleto
        System.out.println("\n\n");
        System.out.println("╔════════════════════════════════════════════╗");
        System.out.println("║           CENÁRIO 3 - Pedido #3            ║");
        System.out.println("╚════════════════════════════════════════════╝");
        
        Pedido pedido3 = sistema.criarPedido();
        sistema.adicionarItemAoPedido(pedido3, "P005", 3); // Webcam
        
        sistema.finalizarPedido(
            pedido3,
            new DescontoCupom("PROMO20", 20),       // OCP: Cupom personalizado
            new FreteRetirada(),                     // OCP: Retirada
            new Boleto(),                            // LSP: Boleto
            "cliente3@email.com"
        );
        
        System.out.println("\n\n╔════════════════════════════════════════════╗");
        System.out.println("║    PRINCÍPIOS SOLID APLICADOS NO SISTEMA  ║");
        System.out.println("╚════════════════════════════════════════════╝");
        System.out.println("✓ SRP: Cada classe tem uma única responsabilidade");
        System.out.println("✓ OCP: Estratégias de desconto/frete são extensíveis");
        System.out.println("✓ LSP: Métodos de pagamento são intercambiáveis");
        System.out.println("✓ ISP: Interfaces segregadas para notificações");
        System.out.println("✓ DIP: Dependências injetadas via abstrações");
    }
}