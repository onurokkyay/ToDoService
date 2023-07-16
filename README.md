# ToDoService
Restful ToDo Service with Spring Boot &amp; MySQL

## Docker MySQL

docker run 

--detach 

--env MYSQL_ROOT_PASSWORD=dummypassword 

--env MYSQL_USER=todos-user 

--env MYSQL_PASSWORD=dummytodos 

--env MYSQL_DATABASE=todos 

--name mysql 

--publish 3306:3306 mysql:8-oracle

