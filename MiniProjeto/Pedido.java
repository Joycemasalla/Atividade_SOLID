package MiniProjeto;

// Aplica SRP: Responsável APENAS por registrar pedidos
public class Pedido {
    private String cliente;
    private Produto[] produtos;
    private int totalProdutos;

    public Pedido(String cliente) {
        this.cliente = cliente;
        this.produtos = new Produto[5]; 
        this.totalProdutos = 0;
    }

    public void adicionar(Produto produto) {
        if (totalProdutos < 5) {
            produtos[totalProdutos] = produto;
            totalProdutos++;
            System.out.println(" Adicionado: " + produto.getNome());
        }
    }

    public double calcularTotal() {
        double total = 0;
        for (int i = 0; i < totalProdutos; i++) {
            total = total + produtos[i].getPreco();
        }
        return total;
    }

    public String getCliente() {
        return cliente;
    }

    public Produto[] getProdutos() {
        return produtos;
    }

    public int getTotalProdutos() {
        return totalProdutos;
    }

    public void mostrar() {
        System.out.println("\n--- PEDIDO ---");
        System.out.println("Cliente: " + cliente);
        System.out.println("Produtos:");
        for (int i = 0; i < totalProdutos; i++) {
            System.out.println("  " + produtos[i].getNome() +
                    " - R$ " + produtos[i].getPreco());
        }
        System.out.println("Subtotal: R$ " + calcularTotal());
    }
}