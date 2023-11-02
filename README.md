# tech.challenge.energy.consumption

---
## Este projeto foi feito com base no Tech Challenge da Fase 3 do curso de Arquitetura e Desenvolvimento em Java da FIAP


---
Sessões:
- [Ideia por trás do desafio](#ideia-por-trás-do-desafio)
- [Relatório Técnico](#relatório-técnico)


---
## Ideia por trás do desafio

O desafio desta fase se baseia no desenvolvimento de uma nova solução para o Parquimetro, equipamento de controle de fluxo de alocações de veículos em lugares públicos. Apesar do simples conceito de implementação CRUD, a real dificuldade se apresenta nas 
palavras chave: Escalabilidade, Alta Disponibilidade e Rápido Processamento. 

Para desenvolver então esse projeto, foram pensadas em Quatro entidades principais: o Parquimetro, o Estacionamento, o Extrato e o Veiculo.

**O Parquimetro**: Possui informações referentes a quantidade total de vagas disponíveis pela cidade, e o preço inicial da alocação.
<br>
**O Estacionamento**: Possui informações referentes ao total de vagas alocadas pela cidade em tempo real, total de vagas disponíveis pela cidade em tempo real e total de carros e motos alocados em tempo real.
<br>
**O Extrato**: Possui informações referentes ao momento de entrada e saída do veículo do local de estacionamento, tempo de estacionamento contratado e valor a pagar
<br>
**O Veiculo**: Possui informações referentes a identificação do veículo e de seu dono.

---
## Relatório Técnico

Com o auxílo de migrations através da biblioteca **Flyway**, as entidades foram construídas e refatoradas múltiplas vezes no banco de dados sem nenhuma necessidade de ação manual. Isso combinado com a configuração da aplicação num DockerFile, mais um arquivo **docker-compose.yml**, tornaram a aplicação N vezes mais prática e rápida de ser construída. 
<br>
<br>
Levando em consideração as palavras chave mencionadas na seção anterior, a inovação nessa aplicação se veio pelo uso do RabbitMQ. Com fácil implementação e  ótima compatibilidade com o Spring, essa ferramenta de mensageria foi utilizada para a geração do Extrato a partir das informações de alocação e veículo. O uso dessa ferramenta, poderia, em uma continuação deste projeto por exemplo, executar diversas _features_ de acordo com a necessidade, como por exemplo: Envio de Email com o Extrato para o Dono do Veículo, Pagamento Automático, etc.
<br>
<br>
Neste projeto, as únicas entidade que tiveram um relacionamento direto construído no banco de dados foram o Estacionamento e o Extrato. apesar disso, a Placa do Veículo serve como atributo que une as três entidades. 
<br>
<br>
_Nota: Todos os endpoints "findAll()" possuem suporte para filtro de qualquer um dos campos da entidade requerida, mas se optar por testá-lo sem filtros, é só chamá-lo sem passar nenhum parâmetro!_
<br>
<br>
Para testar a API, decidi utilizar o Insomnia ao invés do Postman apenas pelo costume, sinto que é uma ferramenta mais leve e simples de configurar. A coleção de testes utilizados na aplicação se encontra presente neste repositório, no arquivo **insomnia-collection.json**
<br>
<br>
Para rodar a aplicação localmente, foi criado um docker-compose, que se encontra neste mesmo repositório.
<br>
Ao iniciar a aplicação, acesse o link http://localhost:8080/swagger-ui/index.html#/ para visualizar o Swagger, contendo a documentação dos endpoints desenvolvidos



