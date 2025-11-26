Mini-Projeto: Sistema de Pedidos
Funcionalidades Implementadas:
✓ Cadastro de produtos
✓ Registro de pedidos
✓ Múltiplas formas de pagamento
✓ Emissão de comprovante
✓ Aplicação de desconto
✓ Cálculo de frete
Aplicação dos Princípios SOLID:
SRP: Produto, Pedido, ItemPedido - cada classe com uma responsabilidade
OCP: Estratégias de desconto e frete extensíveis
LSP: Métodos de pagamento intercambiáveis
ISP: Interfaces de notificação segregadas
DIP: Gerador de comprovante depende de abstração