# tech.challenge.energy.consumption

---
## Este projeto foi feito com base no Tech Challenge da Fase 3 do curso de Arquitetura e Desenvolvimento em Java da FIAP


---
Sessões:
- [Ideia por trás do desafio](#ideia-por-trás-do-desafio)
- [Relatório Técnico](#relatório-técnico)
- [Serviços Disponíveis](#serviços-disponíveis)


---
## Ideia por trás do desafio

O desafio desta fase se baseia no desenvolvimento de uma nova solução para o Parquimetro, equipamento de controle de fluxo de alocações de veículos em lugares públicos. Apesar do simples conceito de implementação CRUD, a real dificuldade se apresenta nas 
palavras chave: Escalabilidade, Alta Disponibilidade e Rápido Processamento. 

Para desenvolver então esse projeto, foram pensadas em Quatro entidades principais: o Parquimetro, o Estacionamento, o Extrato e o Veiculo.

**O Parquimetro**: Possui informações referentes a quantidade total de vagas disponíveis pela cidade, e o preço inicial da alocação.
**O Estacionamento**: Possui informações referentes ao total de vagas alocadas pela cidade em tempo real, total de vagas disponíveis pela cidade em tempo real e total de carros e motos alocados em tempo real.
**O Extrato**: Possui informações referentes ao momento de entrada e saída do veículo do local de estacionamento, tempo de estacionamento contratado e valor a pagar
**O Veiculo**: Possui informações referentes a identificação do veículo e de seu dono.

---
## Relatório Técnico

Se na primeira fase pontuei o **Lombok** e o **Mapstruct** como bibliotecas/ferramentas essenciais para a agilidade no desenvolvimento desta aplicação, o grande destaque da fase 2 do Tech Challenge se mostrou, para mim, ser o uso de **Migrations** com o **Flyway**.
No início sua configuração veio com algumas dificuldades, porém se mostrou muito útil durante o desenvolvimento e essencial para a autonomia da aplicação em seu cenário ideal, isto é, garantir que a mesma seja capaz e responsável de subir seu ambiente de
forma automática, sem a necessidade de configuração manual.
<br>
<br>
Outro destaque no desenvolvimento foi o uso das ferramentas do **Docker** para criação e disponibilização local do banco de dados e aplicação, culminando num docker compose, que com um simples comando é capaz de criar todo o ambiente necessário para que a aplicação
funcione perfeitamente.
<br>
<br>
Um ponto de grande dificuldade nessa segunda fase do desafio foi definir a lógica e relacionamento entre todas as três entidades, acredito que passei por pelo menos 5 versões distintas até chegar na versão final presente nesta entrega. Após muitos desenhos, fluxos,
testes, erros, e mais o mais importante, as aulas de **DDD**, a ideia final foi que a entidade Pessoa seria única e exclusivamente responsável por gerenciar a criação, relacionamento e visualização de Pessoas e Parentes. Já a entidade Eletrodoméstico ficou com a tarefa de gerir os eletrodomésticos a partir de um dono (entidade Pessoa) e calcular a média do consumo mensal de cada produto cadastrado.
Por fim, a entidade Endereço ficou responsabilizada por cuidar de toda gestão de Endereços e Residentes, adição de novos residentes, remoção e visualização.
<br>
<br>
Enquanto a entidade Pessoa se vê independente das outras, um Endereço precisa de uma pessoa para ser criado, mas a mesma pode ser dissociada dele, através do serviço **removeResidente()**. Enquanto isso, um Eletrodoméstico obrigatoriamente precisa ter uma 
pessoa como dona.
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



---
## Serviços Disponíveis

### Entidade Pessoa

![image](https://github.com/henriquemt13/tech.challenge.energy.consumption.api/assets/47531611/053f33e7-3ed2-4d9f-a280-fd1b07983665)


### Entidade Eletrodoméstico
![image](https://github.com/henriquemt13/tech.challenge.energy.consumption.api/assets/47531611/417ba18e-28d2-42ed-b3a3-64722a146225)


### Entidade Endereco
![image](https://github.com/henriquemt13/tech.challenge.energy.consumption.api/assets/47531611/7c12a77c-0f5f-42f4-a641-104bc36d255e)



