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


        
        // == PROBLEMAS DESTA ABORDAGEM ===
        // Para adicionar novo desconto, precisamos MODIFICAR a classe
        // A classe não está FECHADA para modificação
        // Risco de introduzir bugs em descontos existentes
        // Código fica cada vez mais complexo com muitos IFs
        // Viola o princípio Open/Closed
    