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



        // == MELHORIAS OBTIDAS ===
        // Para adicionar novo desconto, apenas criamos nova classe
        // CalculadoraDesconto está FECHADA para modificação
        // Sistema está ABERTO para extensão
        // Não há risco de afetar descontos existentes
        // Código limpo sem IFs complexos
  