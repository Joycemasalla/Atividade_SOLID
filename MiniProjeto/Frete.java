package MiniProjeto;

// Aplica OCP: ABERTO para extensão, FECHADO para modificação

// Classe base para frete
class Frete {
    public double calcular() {
        return 0;
    }

    public String getTipo() {
        return "Retirada na loja";
    }
}

// Frete normal
class FreteNormal extends Frete {
    public double calcular() {
        return 15.00;
    }

    public String getTipo() {
        return "Frete normal (R$ 15,00)";
    }
}

// Frete expresso
class FreteExpresso extends Frete {
    public double calcular() {
        return 30.00;
    }

    public String getTipo() {
        return "Frete expresso (R$ 30,00)";
    }
}