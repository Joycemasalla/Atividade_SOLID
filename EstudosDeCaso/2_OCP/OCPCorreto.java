// Interface abstrata para descontos (ABSTRAÇÃO)
interface Desconto {
    double calcular(double valor);
    String getDescricao();
}

// Cada tipo de desconto é uma classe que ESTENDE o comportamento
class DescontoClienteNovo implements Desconto {
    public double calcular(double valor) {
        return valor * 0.10;
    }
    
    public String getDescricao() {
        return "Desconto Cliente Novo (10%)";
    }
}

class DescontoClienteVIP implements Desconto {
    public double calcular(double valor) {
        return valor * 0.20;
    }
    
    public String getDescricao() {
        return "Desconto Cliente VIP (20%)";
    }
}

class DescontoBlackFriday implements Desconto {
    public double calcular(double valor) {
        return valor * 0.30;
    }
    
    public String getDescricao() {
        return "Desconto Black Friday (30%)";
    }
}

class DescontoNatal implements Desconto {
    public double calcular(double valor) {
        return valor * 0.15;
    }
    
    public String getDescricao() {
        return "Desconto Natal (15%)";
    }
}

// NOVA FUNCIONALIDADE: Adicionar novo desconto SEM modificar código existente
class DescontoDiaDosPais implements Desconto {
    public double calcular(double valor) {
        return valor * 0.12;
    }
    
    public String getDescricao() {
        return "Desconto Dia dos Pais (12%)";
    }
}

// Calculadora agora está FECHADA para modificação e ABERTA para extensão
class CalculadoraDesconto {
    public double aplicarDesconto(Desconto desconto, double valor) {
        double valorDesconto = desconto.calcular(valor);
        System.out.println(desconto.getDescricao() + ": R$ " + 
            String.format("%.2f", valorDesconto));
        return valorDesconto;
    }
}

// Classe principal para testar
public class OCPCorreto {
    public static void main(String[] args) {
        System.out.println("=== EXEMPLO CORRETO - APLICANDO OCP ===\n");
        
        CalculadoraDesconto calculadora = new CalculadoraDesconto();
        double valorCompra = 1000.0;
        
        System.out.println("Valor da compra: R$ " + valorCompra);
        System.out.println();
        
        Desconto desconto1 = new DescontoClienteNovo();
        double valor1 = calculadora.aplicarDesconto(desconto1, valorCompra);
        System.out.println("Valor final: R$ " + (valorCompra - valor1));
        System.out.println();
        
        Desconto desconto2 = new DescontoBlackFriday();
        double valor2 = calculadora.aplicarDesconto(desconto2, valorCompra);
        System.out.println("Valor final: R$ " + (valorCompra - valor2));
        System.out.println();
        
        Desconto desconto3 = new DescontoDiaDosPais();
        double valor3 = calculadora.aplicarDesconto(desconto3, valorCompra);
        System.out.println("Valor final: R$ " + (valorCompra - valor3));
        
        System.out.println("\n=== MELHORIAS OBTIDAS ===");
        System.out.println("1. Para adicionar novo desconto, apenas criamos nova classe");
        System.out.println("2. CalculadoraDesconto está FECHADA para modificação");
        System.out.println("3. Sistema está ABERTO para extensão");
        System.out.println("4. Não há risco de afetar descontos existentes");
        System.out.println("5. Código limpo sem IFs complexos");
    }
}