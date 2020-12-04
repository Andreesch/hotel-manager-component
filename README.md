# Desafio

Elaborar um componente reutilizavel da seguinte problematica:

Carol Stefany ficou duas noites no West Country Vista Hotel. O valor da estadia era de R$125 por noite. Carol fez uma ligação telefonica que custou R$ 4,50 e pediu uma refeição no apartamento por R$ 66,00. As contas de hotel incluem um imposto estadual de 5% sobre os serviços.

Foco ---> Criar Componente Reutilizavel!!

Principios norteadores ---> S.O.L.I.D.

Entregaveis:

Criar um projeto publico em repositorio (fornecer o link de acesso ao repositorio).
Codigo fonte do componente reutilizavel no repositorio.
No repositorio indicar como é realizada a integração/reuso do componente.
No dia de aula apresentar funcionando o componente reutilizavel.
Arquivo pdf  somente com o link do repositorio para posterior acesso.

## Instruções de execução e uso da aplicação

- Para utilizar esse componente, basta seguir esses passos:

1) Gerar o arquivo .jar do componente, que é possível navegando até a pasta raiz do projeto e executando o comando abaixo:

```
mvn clean package install
```

2) Realizar o import do módulo dentro do arquivo pom.xml do seu projeto

```
<dependency>
	<groupId>org.andreschneider</groupId>
	<artifactId>hotel-manager-component</artifactId>
	<version>1.0-SNAPSHOT</version>
	<scope>compile</scope>
</dependency>

```

3) Instanciar uma classe do tipo "HotelStay"

```
HotelStay hotelStay = new HotelStay()
                .setNights(2()) // número de noites
                .setCostPerNight(120) // custo por noite
                .setGuestExpensesList(Arrays.asList(4.50, 66)) // lista de despesas;
```

3) Instanciar a classe "HotelManager" e chamar o método "calculateStay" passando como parâmetro o objeto "HotelStay" criado anteriormente.

```
HotelManager hotelManager = new HotelManager();
hotelManager.calculateStay(hotelStay);

```

- O cálculo utiliza o tipo BigDecimal para lidar com arredondamentos;
- O componente é Java nativo, ou seja, não possui nenhum framework acoplado;
- Unica biblioteca utilizada foi o jUnit para testes unitários;

### Usando o demo

Dentro da pasta raiz do repositório, existe uma pasta com o nome "demo" onde você poderá encontrar um projeto criado para utilizar este componente usando o framework Spring Boot.

- Para utilizar esse projeto, basta seguir esses passos:

1) Gerar o arquivo .jar do projeto, que é possível navegando até a pasta raiz e executando o comando abaixo:

```
mvn clean package install
```

2) Rodar o arquivo .jar do projeto

```
mvn spring-boot:run

```

3) Acessar a URL do swagger (OPCIONAL)

```
http://localhost:5000/swagger-ui.html

```

### Endpoints


#### Calcular Estadia

``POST http://localhost:5000/api/v1/stay``

Calculo de uma estadia.

* nights: Quantidade de noites.
* costPerNight: Custo por noite.
* guestExpensesList: Despesas do hospede.

JSON de criação:
`{
  "costPerNight": 125,
  "guestExpensesList": [
    4.50,66
  ],
  "nights": 2
}`

JSON de resposta:
`{
  "paymentValue": 336.53
}`