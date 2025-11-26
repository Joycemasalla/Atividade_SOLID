package MiniProjeto;

// Aplica OCP: ABERTO para extensão, FECHADO para modificação

// Classe base para descontos
class Desconto {
    public double calcular(double valor) {
        return 0;
    }

    public String getTipo() {
        return "Sem desconto";
    }
}

// Desconto de 10%
class Desconto10 extends Desconto {
    public double calcular(double valor) {
        return valor * 0.10;
    }

    public String getTipo() {
        return "Desconto de 10%";
    }
}

// Desconto VIP de 20%
class DescontoVIP extends Desconto {
    public double calcular(double valor) {
        return valor * 0.20;
    }

    public String getTipo() {
        return "Desconto VIP (20%)";
    }
}