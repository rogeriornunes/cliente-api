# ClienteAPI

API para gerenciar os dados de Clientes. É possível fazer a inclusão, alteração, consulta, listagem e exclusão de clientes. 

## Pré-requisitos

1. [Java 11](https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html)
2. [Maven](https://maven.apache.org/download.cgi)
3. IDE [Intellij](https://www.jetbrains.com/idea/download/#section=windows) ou [Eclipse](https://www.eclipse.org/downloads/packages/)
4. [MySQL](https://dev.mysql.com/downloads/installer/)
5. [Postman](https://www.postman.com/downloads/)

## Configurar banco de dados MySQL

  Utilizamos o Docker para executar o MySQL neste exemplo.

 Acesse a pasta docker e execute o comando:
    
    docker-compose up

 Se não quiser utilizar o Docker você precisa ter o MySQL instalado no seu computador e precisará criar um banco de dados 
com o nome `clientedb`. Atualize o usuário e senha no arquivo `application.properties` para os dados do seu banco de dados

    spring.datasource.username=root
    spring.datasource.password=softnunes


## Iniciar a aplicação

  Existem algumas formas de iniciar esta API

    java -jar target/cliente-api.jar

ou utilizando o maven

    mvn spring-boot:run
    
 
## Criação de tabela (cliente) no clientedb

Tabela cliente  será criada ao inciar aplicação pelo hibernate
![image](https://github.com/rogeriornunes/cliente-api/assets/80980856/df50a51b-4553-4a75-8832-c21b4a7616ea)


## Acessando o Adminer 4.8.1

Caso sobe a imagem docker será possivel acessar o Adminer 4.8.1 via browser http://localhost:8081

Dados de acesso:
Sistema	: MySQL
Servidor: mysql-db	
Usuário: root
Senha: softnunes	
Base de dados: clientedb

![image](https://github.com/rogeriornunes/cliente-api/assets/80980856/bd8385aa-47ee-4ea2-96ab-a14d404caf0e)


## Criando a imagem Docker da API

    docker build -t rogerioricardonunes/cliente-api:V1  .

    docker push rogerioricardonunes/cliente-api:V1
    

## Creação de tabela (Script)

    create table cliente (id bigint not null,
    cnpj varchar(255),
    cpf varchar(255),
    data_cadastro datetime,
    ie varchar(255),
    nome varchar(255),
    rg varchar(255),
    status bit,
    telefone_alternativo varchar(255),
    telefone_principal varchar(255),
    tipo varchar(255),
    ultima_atualizacao datetime,
    primary key (id)) engine = InnoDB


## Aplicação cliente-api e cliente-ui publicada no Heroku

    [cliente-ui](https://cliente-ui.herokuapp.com/)  

