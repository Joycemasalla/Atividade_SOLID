// Problema: Para adicionar um novo tipo de desconto, 
// precisamos modificar a classe CalculadoraDesconto

class CalculadoraDesconto {
    
    // Cada vez que um novo tipo de desconto for criado,
    // precisamos adicionar um novo IF aqui (MODIFICAÇÃO)
    public double calcular(String tipoDesconto, double valor) {
        double desconto = 0;
        
        if (tipoDesconto.equals("CLIENTE_NOVO")) {
            desconto = valor * 0.10;
            System.out.println("Desconto Cliente Novo: R$ " + desconto);
            
        } else if (tipoDesconto.equals("CLIENTE_VIP")) {
            desconto = valor * 0.20;
            System.out.println("Desconto Cliente VIP: R$ " + desconto);
            
        } else if (tipoDesconto.equals("BLACK_FRIDAY")) {
            desconto = valor * 0.30;
            System.out.println("Desconto Black Friday: R$ " + desconto);
            
        } else if (tipoDesconto.equals("NATAL")) {
            desconto = valor * 0.15;
            System.out.println("Desconto Natal: R$ " + desconto);
            
        } else {
            System.out.println("Tipo de desconto não reconhecido!");
        }
        
        return desconto;
    }
}

// Classe principal para testar
public class OCPIncorreto {
    public static void main(String[] args) {
        System.out.println("=== EXEMPLO INCORRETO - VIOLANDO OCP ===\n");
        
        CalculadoraDesconto calculadora = new CalculadoraDesconto();
        double valorCompra = 1000.0;
        
        System.out.println("Valor da compra: R$ " + valorCompra);
        System.out.println();
        
        double desconto1 = calculadora.calcular("CLIENTE_NOVO", valorCompra);
        System.out.println("Valor final: R$ " + (valorCompra - desconto1));
        System.out.println();
        
        double desconto2 = calculadora.calcular("BLACK_FRIDAY", valorCompra);
        System.out.println("Valor final: R$ " + (valorCompra - desconto2));
        
        System.out.println("\n=== PROBLEMAS DESTA ABORDAGEM ===");
        System.out.println("1. Para adicionar novo desconto, precisamos MODIFICAR a classe");
        System.out.println("2. A classe não está FECHADA para modificação");
        System.out.println("3. Risco de introduzir bugs em descontos existentes");
        System.out.println("4. Código fica cada vez mais complexo com muitos IFs");
        System.out.println("5. Viola o princípio Open/Closed");
    }
}