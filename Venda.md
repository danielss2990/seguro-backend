## VendaController

Esta classe é responsável por controlar as operações relacionadas à entidade Venda.

### Dependências

- [VendaService](link-para-a-classe-VendaService)
- [VendaDTO](link-para-a-classe-VendaDTO)
- [VendaProjecaoDTO](link-para-a-classe-VendaProjecaoDTO)
- [VendaProjecaoCadastroDTO](link-para-a-classe-VendaProjecaoCadastroDTO)
- [ListInsertVendaDTO](link-para-a-classe-ListInsertVendaDTO)
- [InsertVendaDTO](link-para-a-classe-InsertVendaDTO)

### Endpoints

#### Buscar Venda por ID

- Método: `GET`
- Endpoint: `/vendas/{id}`
- Parâmetros:
  - `id` (obrigatório) - ID da Venda a ser buscada.
- Resposta: `200 OK`
  - Corpo da resposta: [VendaDTO](link-para-a-classe-VendaDTO)

#### Buscar Vendas por Jogo

- Método: `GET`
- Endpoint: `/vendas`
- Resposta: `200 OK`
  - Corpo da resposta: Mapa que relaciona o ID do Jogo com uma lista de [VendaProjecaoDTO](link-para-a-classe-VendaProjecaoDTO) contendo informações das vendas relacionadas ao jogo.

#### Inserir Venda

- Método: `POST`
- Endpoint: `/vendas/inserir`
- Corpo da requisição: [ListInsertVendaDTO](link-para-a-classe-ListInsertVendaDTO) (JSON)
- Resposta: `201 Created`
  - Cabeçalho de resposta: `Location` com o link para a Venda criada.
  - Corpo da resposta: [VendaProjecaoCadastroDTO](link-para-a-classe-VendaProjecaoCadastroDTO) contendo informações da Venda cadastrada e seus itens vendidos.

#### Deletar Venda por ID

- Método: `DELETE`
- Endpoint: `/vendas/deletar/{id}`
- Parâmetros:
  - `id` (obrigatório) - ID da Venda a ser deletada.
- Resposta: `204 No Content`

