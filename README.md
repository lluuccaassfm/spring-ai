# spring-ai

- Projeto com objetivo realizar integração do Spring com OpenAi
- Utiliza duas dependências principais:

  - OpenAI (para integração com a OpenAI)
  - Spring Web (para criação das rotas)

### Rotas

- **GET /bookstore/informations?message={ALGUMA_PERGUNTA}**

    Chat aberto para informações de livro.


- **GET /bookstore/chat/informations?message={ALGUMA_PERGUNTA}**

    Chat aberto que retorna um tipo específico (ChatResponse), com dados mais detalhados do prompt.


- **GET /bookstore/reviews?book={NOME_LIVRO}**

    Chat que usa PromptTemplate para integração com a OpenAI, recebe o nome de um livro e retorna um resumo do livro e 
    informações sobre o autor.


- **GET /soccer-team/chat?message={ALGUMA_PERGUNTA}**

    Chat aberto para informações de times de futebol.


- **GET /soccer-team/story?team={NOME_TIME}**

    Chat que usa PromptTemplate para integração com a OpenAI, recebe o nome de algum time de futebol e retorna um resumo 
    da história do time e quais os seus principais títulos.

### Configuração

No _application.properties_ é preciso adicionar a property "spring.ai.openai.api-key" com a api-key 
gerada na sua conta da OpenAI. 
    
    


