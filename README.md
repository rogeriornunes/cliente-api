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
    
    ## Possíveis problemas

1. Banco de dados não iniciado
```
2023-05-15 15:02:12 The last packet sent successfully to the server was 0 milliseconds ago. The driver has not received any packets from the server.
2023-05-15 15:02:12     at com.mysql.cj.jdbc.exceptions.SQLError.createCommunicationsException(SQLError.java:174) ~[mysql-connector-java-8.0.25.jar!/:8.0.25]
2023-05-15 15:02:12     at com.mysql.cj.jdbc.exceptions.SQLExceptionsMapping.translateException(SQLExceptionsMapping.java:64) ~[mysql-connector-java-8.0.25.jar!/:8.0.25]
2023-05-15 15:02:12     at com.mysql.cj.jdbc.ConnectionImpl.createNewIO(ConnectionImpl.java:833) ~[mysql-connector-java-8.0.25.jar!/:8.0.25]
2023-05-15 15:02:12     at com.mysql.cj.jdbc.ConnectionImpl.<init>(ConnectionImpl.java:453) ~[mysql-connector-java-8.0.25.jar!/:8.0.25]
2023-05-15 15:02:12     at com.mysql.cj.jdbc.ConnectionImpl.getInstance(ConnectionImpl.java:246) ~[mysql-connector-java-8.0.25.jar!/:8.0.25]
2023-05-15 15:02:12     at com.mysql.cj.jdbc.NonRegisteringDriver.connect(NonRegisteringDriver.java:198) ~[mysql-connector-java-8.0.25.jar!/:8.0.25]
2023-05-15 15:02:12     at com.zaxxer.hikari.util.DriverDataSource.getConnection(DriverDataSource.java:138) ~[HikariCP-4.0.3.jar!/:na]
2023-05-15 15:02:12     at com.zaxxer.hikari.pool.PoolBase.newConnection(PoolBase.java:364) ~[HikariCP-4.0.3.jar!/:na]
2023-05-15 15:02:12     at com.zaxxer.hikari.pool.PoolBase.newPoolEntry(PoolBase.java:206) ~[HikariCP-4.0.3.jar!/:na]
2023-05-15 15:02:12     at com.zaxxer.hikari.pool.HikariPool.createPoolEntry(HikariPool.java:476) ~[HikariCP-4.0.3.jar!/:na]
2023-05-15 15:02:12     at com.zaxxer.hikari.pool.HikariPool.checkFailFast(HikariPool.java:561) ~[HikariCP-4.0.3.jar!/:na]
2023-05-15 15:02:12     at com.zaxxer.hikari.pool.HikariPool.<init>(HikariPool.java:115) ~[HikariCP-4.0.3.jar!/:na]
2023-05-15 15:02:12     at com.zaxxer.hikari.HikariDataSource.getConnection(HikariDataSource.java:112) ~[HikariCP-4.0.3.jar!/:na]
2023-05-15 15:02:12     at org.hibernate.engine.jdbc.connections.internal.DatasourceConnectionProviderImpl.getConnection(DatasourceConnectionProviderImpl.java:122) ~[hibernate-core-5.6.15.Final.jar!/:5.6.15.Final]
2023-05-15 15:02:12     at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator$ConnectionProviderJdbcConnectionAccess.obtainConnection(JdbcEnvironmentInitiator.java:181) ~[hibernate-core-5.6.15.Final.jar!/:5.6.15.Final]
2023-05-15 15:02:12     at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator.initiateService(JdbcEnvironmentInitiator.java:68) ~[hibernate-core-5.6.15.Final.jar!/:5.6.15.Final]
2023-05-15 15:02:12     at org.hibernate.engine.jdbc.env.internal.JdbcEnvironmentInitiator.initiateService(JdbcEnvironmentInitiator.java:35) ~[hibernate-core-5.6.15.Final.jar!/:5.6.15.Final]
2023-05-15 15:02:12     at org.hibernate.boot.registry.internal.StandardServiceRegistryImpl.initiateService(StandardServiceRegistryImpl.java:101) ~[hibernate-core-5.6.15.Final.jar!/:5.6.15.Final]
2023-05-15 15:02:12     at org.hibernate.service.internal.AbstractServiceRegistryImpl.createService(AbstractServiceRegistryImpl.java:272) ~[hibernate-core-5.6.15.Final.jar!/:5.6.15.Final]
2023-05-15 15:02:12     at org.hibernate.service.internal.AbstractServiceRegistryImpl.initializeService(AbstractServiceRegistryImpl.java:246) ~[hibernate-core-5.6.15.Final.jar!/:5.6.15.Final]
2023-05-15 15:02:12     at org.hibernate.service.internal.AbstractServiceRegistryImpl.getService(AbstractServiceRegistryImpl.java:223) ~[hibernate-core-5.6.15.Final.jar!/:5.6.15.Final]
2023-05-15 15:02:12     at org.hibernate.id.factory.internal.DefaultIdentifierGeneratorFactory.injectServices(DefaultIdentifierGeneratorFactory.java:175) ~[hibernate-core-5.6.15.Final.jar!/:5.6.15.Final]
2023-05-15 15:02:12     at org.hibernate.service.internal.AbstractServiceRegistryImpl.injectDependencies(AbstractServiceRegistryImpl.java:295) ~[hibernate-core-5.6.15.Final.jar!/:5.6.15.Final]
2023-05-15 15:02:12     at org.hibernate.service.internal.AbstractServiceRegistryImpl.initializeService(AbstractServiceRegistryImpl.java:252) ~[hibernate-core-5.6.15.Final.jar!/:5.6.15.Final]
2023-05-15 15:02:12     at org.hibernate.service.internal.AbstractServiceRegistryImpl.getService(AbstractServiceRegistryImpl.java:223) ~[hibernate-core-5.6.15.Final.jar!/:5.6.15.Final]
2023-05-15 15:02:12     at org.hibernate.boot.internal.InFlightMetadataCollectorImpl.<init>(InFlightMetadataCollectorImpl.java:173) ~[hibernate-core-5.6.15.Final.jar!/:5.6.15.Final]
2023-05-15 15:02:12     at org.hibernate.boot.model.process.spi.MetadataBuildingProcess.complete(MetadataBuildingProcess.java:127) ~[hibernate-core-5.6.15.Final.jar!/:5.6.15.Final]
2023-05-15 15:02:12     at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.metadata(EntityManagerFactoryBuilderImpl.java:1460) ~[hibernate-core-5.6.15.Final.jar!/:5.6.15.Final]
2023-05-15 15:02:12     at org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl.build(EntityManagerFactoryBuilderImpl.java:1494) ~[hibernate-core-5.6.15.Final.jar!/:5.6.15.Final]
2023-05-15 15:02:12     at org.springframework.orm.jpa.vendor.SpringHibernateJpaPersistenceProvider.createContainerEntityManagerFactory(SpringHibernateJpaPersistenceProvider.java:58) ~[spring-orm-5.3.27.jar!/:5.3.27]
2023-05-15 15:02:12     at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.createNativeEntityManagerFactory(LocalContainerEntityManagerFactoryBean.java:365) ~[spring-orm-5.3.27.jar!/:5.3.27]
2023-05-15 15:02:12     at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.buildNativeEntityManagerFactory(AbstractEntityManagerFactoryBean.java:409) ~[spring-orm-5.3.27.jar!/:5.3.27]
2023-05-15 15:02:12     at org.springframework.orm.jpa.AbstractEntityManagerFactoryBean.afterPropertiesSet(AbstractEntityManagerFactoryBean.java:396) ~[spring-orm-5.3.27.jar!/:5.3.27]
2023-05-15 15:02:12     at org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean.afterPropertiesSet(LocalContainerEntityManagerFactoryBean.java:341) ~[spring-orm-5.3.27.jar!/:5.3.27]
2023-05-15 15:02:12     at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.invokeInitMethods(AbstractAutowireCapableBeanFactory.java:1863) ~[spring-beans-5.3.27.jar!/:5.3.27]
2023-05-15 15:02:12     at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.initializeBean(AbstractAutowireCapableBeanFactory.java:1800) ~[spring-beans-5.3.27.jar!/:5.3.27]
2023-05-15 15:02:12     at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.doCreateBean(AbstractAutowireCapableBeanFactory.java:620) ~[spring-beans-5.3.27.jar!/:5.3.27]
2023-05-15 15:02:12     at org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory.createBean(AbstractAutowireCapableBeanFactory.java:542) ~[spring-beans-5.3.27.jar!/:5.3.27]
2023-05-15 15:02:12     at org.springframework.beans.factory.support.AbstractBeanFactory.lambda$doGetBean$0(AbstractBeanFactory.java:335) ~[spring-beans-5.3.27.jar!/:5.3.27]
2023-05-15 15:02:12     at org.springframework.beans.factory.support.DefaultSingletonBeanRegistry.getSingleton(DefaultSingletonBeanRegistry.java:234) ~[spring-beans-5.3.27.jar!/:5.3.27]
2023-05-15 15:02:12     at org.springframework.beans.factory.support.AbstractBeanFactory.doGetBean(AbstractBeanFactory.java:333) ~[spring-beans-5.3.27.jar!/:5.3.27]
2023-05-15 15:02:12     at org.springframework.beans.factory.support.AbstractBeanFactory.getBean(AbstractBeanFactory.java:208) ~[spring-beans-5.3.27.jar!/:5.3.27]
2023-05-15 15:02:12     at org.springframework.context.support.AbstractApplicationContext.getBean(AbstractApplicationContext.java:1156) ~[spring-context-5.3.27.jar!/:5.3.27]
2023-05-15 15:02:12     at org.springframework.context.support.AbstractApplicationContext.finishBeanFactoryInitialization(AbstractApplicationContext.java:910) ~[spring-context-5.3.27.jar!/:5.3.27]
2023-05-15 15:02:12     at org.springframework.context.support.AbstractApplicationContext.refresh(AbstractApplicationContext.java:583) ~[spring-context-5.3.27.jar!/:5.3.27]
2023-05-15 15:02:12     at org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext.refresh(ServletWebServerApplicationContext.java:147) ~[spring-boot-2.7.11.jar!/:2.7.11]
2023-05-15 15:02:12     at org.springframework.boot.SpringApplication.refresh(SpringApplication.java:731) ~[spring-boot-2.7.11.jar!/:2.7.11]
2023-05-15 15:02:12     at org.springframework.boot.SpringApplication.refreshContext(SpringApplication.java:408) ~[spring-boot-2.7.11.jar!/:2.7.11]
2023-05-15 15:02:12     at org.springframework.boot.SpringApplication.run(SpringApplication.java:307) ~[spring-boot-2.7.11.jar!/:2.7.11]
2023-05-15 15:02:12     at org.springframework.boot.SpringApplication.run(SpringApplication.java:1303) ~[spring-boot-2.7.11.jar!/:2.7.11]
2023-05-15 15:02:12     at org.springframework.boot.SpringApplication.run(SpringApplication.java:1292) ~[spring-boot-2.7.11.jar!/:2.7.11]
2023-05-15 15:02:12     at br.com.softnunes.clienteapi.ClienteApiApplication.main(ClienteApiApplication.java:17) ~[classes!/:0.0.1-SNAPSHOT]
2023-05-15 15:02:12     at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
2023-05-15 15:02:12     at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:na]
2023-05-15 15:02:12     at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
2023-05-15 15:02:12     at java.base/java.lang.reflect.Method.invoke(Method.java:566) ~[na:na]
2023-05-15 15:02:12     at org.springframework.boot.loader.MainMethodRunner.run(MainMethodRunner.java:49) ~[app.jar:0.0.1-SNAPSHOT]
2023-05-15 15:02:12     at org.springframework.boot.loader.Launcher.launch(Launcher.java:108) ~[app.jar:0.0.1-SNAPSHOT]
2023-05-15 15:02:12     at org.springframework.boot.loader.Launcher.launch(Launcher.java:58) ~[app.jar:0.0.1-SNAPSHOT]
2023-05-15 15:02:12     at org.springframework.boot.loader.JarLauncher.main(JarLauncher.java:65) ~[app.jar:0.0.1-SNAPSHOT]
2023-05-15 15:02:12 Caused by: com.mysql.cj.exceptions.CJCommunicationsException: Communications link failure
```

Solução:    
   - Veja o tópico `Configurar banco de dados MySQL` acima.
