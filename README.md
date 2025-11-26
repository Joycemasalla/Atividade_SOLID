# Sistema de Pedidos — Mini-Projeto

Breve sistema de pedidos que demonstra a aplicação dos princípios SOLID em um contexto simples de cadastro de produtos, registro de pedidos e emissão de comprovantes.

## Funcionalidades
- ✓ Cadastro de produtos  
- ✓ Registro de pedidos  
- ✓ Múltiplas formas de pagamento  
- ✓ Emissão de comprovante  
- ✓ Aplicação de desconto  
- ✓ Cálculo de frete  

## Estrutura e componentes principais
- Produto — Entidade que representa dados do produto (nome, preço, estoque).
- Pedido — Gerencia itens do pedido, total e estado do pedido.
- ItemPedido — Representa um item dentro de um pedido (quantidade, produto).
- Pagamento — Implementações intercambiáveis para diferentes formas de pagamento.
- Estratégias de Desconto — Permite aplicar descontos conforme regras extensíveis.
- Estratégias de Frete — Cálculo de frete com implementação extensível.
- Gerador de Comprovante — Depende de abstração para gerar comprovantes.
- Notificações — Interfaces segregadas para envio de notificações.

## Aplicação dos princípios SOLID
- SRP (Single Responsibility): Produto, Pedido e ItemPedido, cada um com responsabilidade única.  
- OCP (Open/Closed): Estratégias de desconto e frete podem ser estendidas sem modificar código existente.  
- LSP (Liskov Substitution): Formas de pagamento intercambiáveis com a mesma interface.  
- ISP (Interface Segregation): Interfaces de notificação separadas por responsabilidade.  
- DIP (Dependency Inversion): Gerador de comprovante depende de abstração em vez de implementações concretas.

