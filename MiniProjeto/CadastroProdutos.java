package MiniProjeto;

// Aplica SRP: Responsável APENAS pelo cadastro de produtos
public class CadastroProdutos {
    private Produto[] produtos;
    private int total;

    public CadastroProdutos() {
        produtos = new Produto[10];
        total = 0;

        cadastrar(new Produto("Notebook", 2500.00));
        cadastrar(new Produto("Mouse", 50.00));
        cadastrar(new Produto("Teclado", 150.00));
        cadastrar(new Produto("Monitor", 800.00));
    }

    public void cadastrar(Produto produto) {
        if (total < 10) {
            produtos[total] = produto;
            total++;
        }
    }

    public void listar() {
        System.out.println("\n=== PRODUTOS DISPONÍVEIS ===");
        for (int i = 0; i < total; i++) {
            System.out.println((i + 1) + ". " + produtos[i].getNome() +
                    " - R$ " + produtos[i].getPreco());
        }
    }

    public Produto buscar(int numero) {
        if (numero > 0 && numero <= total) {
            return produtos[numero - 1];
        }
        return null;
    }
}