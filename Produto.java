public class Produto {
    
}
// MINI-PROJETO: SISTEMA DE PEDIDOS E PAGAMENTOS
// Arquivo: Produto.java

// Aplica SRP: Classe responsável APENAS por representar dados de um produto
public class Produto {
    private String codigo;
    private String nome;
    private double preco;
    private int quantidadeEstoque;
    
    public Produto(String codigo, String nome, double preco, int quantidadeEstoque) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
    }
    
    // Getters
    public String getCodigo() {
        return codigo;
    }
    
    public String getNome() {
        return nome;
    }
    
    public double getPreco() {
        return preco;
    }
    
    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }
    
    // Setters
    public void setPreco(double preco) {
        this.preco = preco;
    }
    
    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
    
    public void diminuirEstoque(int quantidade) {
        if (quantidade <= quantidadeEstoque) {
            this.quantidadeEstoque -= quantidade;
        } else {
            throw new IllegalArgumentException("Estoque insuficiente!");
        }
    }
    
    @Override
    public String toString() {
        return String.format("%s - %s: R$ %.2f (Estoque: %d)", 
            codigo, nome, preco, quantidadeEstoque);
    }
}