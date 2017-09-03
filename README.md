# ArticleManagement-Service (CRUD)
Spring REST service for ArticleManagement-GUI

---------------------REST Apis---------------------------

 1. /article/artilces (GET) -- Displays all the articles in the database
 2. /article (POST) -- Setup body with Article object -- Adds the article object to the database
 3. /article (PUT) -- Setup the body with Article object --USed for Update operation
 4. /article (DELETE) -- provide the article id along with the requestbody -- Deletes the article corresponding to the ID 

Technology stack:
* Java
* REST WebService
* Spring-boot, Spring Data (JPA)
* Maven
* HIbernate
* MySQL DB

ArticleManagement-Service is a CRUD based REST webservice for the ArticleManagement-GUI
1. Provides actions for 
  - Add new article
  - Edit article
  - View all articles
  - Delete an article

2. Its a SpringBoot application using Spring Data, MySQL DB
3. Pre-requisites
  - Java should be installed
  - Maven
  - have a MySQL db
 
 4. Clone the gitcode as provided in the repository URL
 
 ---------(Below are to be executed from Command line)---------------
 
 5. Run Mavne install using command
     - mvn clean install
 6. Convert to jar package (Required for Spring boot)
     - mvn clean package
 7. Start the spring boot application using,
     - mvn spring-boot:run
  
 8. The tables will be automatically created by Hibernate when the -mvn spring-boot:run is executed, 
 The data for the tables can be inserted into table by the MySQL commandLine or you can do a POST request to the WebService to add.
 
 9. server will be locally started with url: http://localhost:8080/
 
 
