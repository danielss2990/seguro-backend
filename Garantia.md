## GarantiaController

Esta classe é responsável por controlar as operações relacionadas à entidade Garantia.

### Dependências

- [GarantiaService](link-para-a-classe-GarantiaService)

### Endpoints

#### Buscar Garantia por ID

- Método: `GET`
- Endpoint: `/garantias/{id}`
- Parâmetros:
  - `id` (obrigatório) - ID da Garantia a ser buscada.
- Resposta: `200 OK`
  - Corpo da resposta: [GarantiaDTO](link-para-a-classe-GarantiaDTO)

#### Buscar todas as Garantias

- Método: `GET`
- Endpoint: `/garantias`
- Resposta: `200 OK`
  - Corpo da resposta: Lista de [GarantiaDTO](link-para-a-classe-GarantiaDTO)

#### Inserir Garantia

- Método: `POST`
- Endpoint: `/garantias`
- Corpo da requisição: [GarantiaDTO](link-para-a-classe-GarantiaDTO) (JSON)
- Resposta: `201 Created`
  - Cabeçalho de resposta: `Location` com o link para a Garantia criada.

#### Atualizar Garantia por ID

- Método: `PUT`
- Endpoint: `/garantias/{id}`
- Parâmetros:
  - `id` (obrigatório) - ID da Garantia a ser atualizada.
- Corpo da requisição: [GarantiaDTO](link-para-a-classe-GarantiaDTO) (JSON)
- Resposta: `200 OK`
  - Corpo da resposta: [GarantiaDTO](link-para-a-classe-GarantiaDTO) atualizada.

#### Deletar Garantia por ID

- Método: `DELETE`
- Endpoint: `/garantias/{id}`
- Parâmetros:
  - `id` (obrigatório) - ID da Garantia a ser deletada.
- Resposta: `204 No Content`

## GarantiaDTO

Esta classe representa o objeto de transferência de dados (DTO) para a entidade Garantia.

### Atributos

- `id` (Long): ID da Garantia.
- `nome` (String): Nome da Garantia.
- `valor` (Double): Valor da Garantia.
- `prazo` (Integer): Prazo da Garantia em meses.

### Construtores

- `GarantiaDTO()`: Construtor vazio.
- `GarantiaDTO(Garantia entity)`: Construtor que recebe uma entidade Garantia e preenche os atributos do DTO.

### Métodos

- `getId()`: Retorna o ID da Garantia.
- `setId(Long id)`: Define o ID da Garantia.
- `getNome()`: Retorna o nome da Garantia.
- `setNome(String nome)`: Define o nome da Garantia.
- `getValor()`: Retorna o valor da Garantia.
- `setValor(Double valor)`: Define o valor da Garantia.
- `getPrazo()`: Retorna o prazo da Garantia.
- `setPrazo(Integer prazo)`: Define o prazo da Garantia.

