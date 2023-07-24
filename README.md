# Projeto WEB API (Backend) - Sistema de Gerenciamento de Produtos, Garantias e Vendas

Este projeto consiste em uma aplicação WEB API que oferece três APIs principais para gerenciar Produtos, Garantias e Vendas. A API permitirá a criação, atualização, consulta e exclusão de registros em cada uma dessas entidades.

## API Produto

A API de Produto é responsável por gerenciar os produtos disponíveis no sistema. Cada produto possui os seguintes atributos:

- `Id` (UUID): Identificador único do produto.
- `Nome` (string): Nome do produto.
- `Valor` (decimal): Valor unitário do produto.
- `Estoque mínimo` (int): Quantidade mínima em estoque para alerta de reposição.
- `Estoque máximo` (int): Quantidade máxima em estoque permitida.
- `Saldo em estoque` (int): Quantidade atual em estoque.
- `Fornecedor` (string): Nome do fornecedor do produto.
- `Possui garantia` (booleano): Indica se o produto possui garantia.

### Endpoints da API Produto:

- `POST /api/produto`: Cria um novo produto no sistema.
- `GET /api/produto/{id}`: Retorna os detalhes de um produto específico.
- `PUT /api/produto/{id}`: Atualiza as informações de um produto existente.
- `DELETE /api/produto/{id}`: Remove um produto do sistema.

## API Garantia

A API de Garantia permite o gerenciamento das garantias dos produtos cadastrados. Cada garantia possui os seguintes atributos:

- `Id` (UUID): Identificador único da garantia.
- `Nome` (string): Nome da garantia.
- `Valor` (decimal): Valor da garantia.
- `Prazo` (int): Prazo de validade da garantia em anos.

### Endpoints da API Garantia:

- `POST /api/garantia`: Cria uma nova garantia no sistema.
- `GET /api/garantia/{id}`: Retorna os detalhes de uma garantia específica.
- `PUT /api/garantia/{id}`: Atualiza as informações de uma garantia existente.
- `DELETE /api/garantia/{id}`: Remove uma garantia do sistema.

## API Venda

A API de Venda possibilita o registro de vendas realizadas, incluindo os itens vendidos e informações da garantia associada. Cada venda possui os seguintes atributos:

- `Id` (UUID): Identificador único da venda.
- `Itens da Venda` (array): Lista contendo os produtos vendidos e suas quantidades.
- `Id do produto` (UUID): Identificador único do produto vendido.
- `Quantidade` (int): Quantidade vendida do produto.
- `Valor unitário` (decimal): Valor unitário do produto na venda.
- `Valor total` (decimal): Valor total da venda.
- `Garantia` (item de garantia): Informações da garantia associada à venda.
- `Valor total com garantia` (decimal): Valor total da venda, incluindo o valor da garantia, se houver.

### Endpoints da API Venda:

- `POST /api/venda`: Registra uma nova venda no sistema, incluindo os itens vendidos e informações da garantia.
- `GET /api/venda/{id}`: Retorna os detalhes de uma venda específica.
- `DELETE /api/venda/{id}`: Remove uma venda do sistema.

## Considerações Finais

Este projeto oferece as APIs necessárias para gerenciar Produtos, Garantias e Vendas em um sistema. Para utilizá-lo, você pode realizar as requisições HTTP nos respectivos endpoints para realizar as operações desejadas.

Caso tenha alguma dúvida ou problema com o sistema, não hesite em entrar em contato com o desenvolvedor.

