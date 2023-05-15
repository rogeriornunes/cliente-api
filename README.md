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
