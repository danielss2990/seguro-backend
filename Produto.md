## ProdutoController

Esta classe é responsável por controlar as operações relacionadas à entidade Produto.

### Dependências

- [ProdutoService](link-para-a-classe-ProdutoService)

### Endpoints

#### Buscar Produto por ID

- Método: `GET`
- Endpoint: `/produtos/{id}`
- Parâmetros:
  - `id` (obrigatório) - ID do Produto a ser buscado.
- Resposta: `200 OK`
  - Corpo da resposta: [ProdutoDTO](link-para-a-classe-ProdutoDTO)

#### Buscar todos os Produtos

- Método: `GET`
- Endpoint: `/produtos`
- Resposta: `200 OK`
  - Corpo da resposta: Lista de [ProdutoDTO](link-para-a-classe-ProdutoDTO)

#### Inserir Produto

- Método: `POST`
- Endpoint: `/produtos`
- Corpo da requisição: [ProdutoDTO](link-para-a-classe-ProdutoDTO) (JSON)
- Resposta: `201 Created`
  - Cabeçalho de resposta: `Location` com o link para o Produto criado.

#### Atualizar Produto por ID

- Método: `PUT`
- Endpoint: `/produtos/{id}`
- Parâmetros:
  - `id` (obrigatório) - ID do Produto a ser atualizado.
- Corpo da requisição: [ProdutoDTO](link-para-a-classe-ProdutoDTO) (JSON)
- Resposta: `200 OK`
  - Corpo da resposta: [ProdutoDTO](link-para-a-classe-ProdutoDTO) atualizado.

#### Deletar Produto por ID

- Método: `DELETE`
- Endpoint: `/produtos/{id}`
- Parâmetros:
  - `id` (obrigatório) - ID do Produto a ser deletado.
- Resposta: `204 No Content`

## ProdutoDTO

Esta classe representa o objeto de transferência de dados (DTO) para a entidade Produto.

### Atributos

- `id` (Long): ID do Produto.
- `nome` (String): Nome do Produto.
- `valor` (Double): Valor do Produto.
- `estoqueMinimo` (Integer): Estoque mínimo do Produto.
- `estoqueMaximo` (Integer): Estoque máximo do Produto.
- `saldoEstoque` (Integer): Saldo em estoque do Produto.
- `fornecedor` (String): Nome do fornecedor do Produto.
- `garantia` (Boolean): Indica se o Produto possui garantia.
- `garantias` (List<GarantiaDTO>): Lista de garantias relacionadas ao Produto.

### Construtores

- `ProdutoDTO()`: Construtor vazio.
- `ProdutoDTO(Produto entity)`: Construtor que recebe uma entidade Produto e preenche os atributos do DTO, incluindo as garantias relacionadas.

### Métodos

- `getId()`: Retorna o ID do Produto.
- `setId(Long id)`: Define o ID do Produto.
- `getNome()`: Retorna o nome do Produto.
- `setNome(String nome)`: Define o nome do Produto.
- `getValor()`: Retorna o valor do Produto.
- `setValor(Double valor)`: Define o valor do Produto.
- `getEstoqueMinimo()`: Retorna o estoque mínimo do Produto.
- `setEstoqueMinimo(Integer estoqueMinimo)`: Define o estoque mínimo do Produto.
- `getEstoqueMaximo()`: Retorna o estoque máximo do Produto.
- `setEstoqueMaximo(Integer estoqueMaximo)`: Define o estoque máximo do Produto.
- `getSaldoEstoque()`: Retorna o saldo em estoque do Produto.
- `setSaldoEstoque(Integer saldoEstoque)`: Define o saldo em estoque do Produto.
- `getFornecedor()`: Retorna o nome do fornecedor do Produto.
- `setFornecedor(String fornecedor)`: Define o nome do fornecedor do Produto.
- `getGarantia()`: Retorna se o Produto possui garantia.
- `setGarantia(Boolean garantia)`: Define se o Produto possui garantia.
- `getGarantias()`: Retorna a lista de garantias relacionadas ao Produto.
- `setGarantias(List<GarantiaDTO> garantias)`: Define a lista de garantias relacionadas ao Produto.

