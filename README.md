# LogParse-MMT

This project uses the projectlombok,So please install the Lombok jar using Below URL
https://projectlombok.org/setup/intellij

or 
https://projectlombok.org/setup/eclipse


It a SpringBoot Maven Project you can build it using 

mvn package or mvn install

To Run Application ,run the below command in the base directory of project

java -jar targer/Logparser-1.0.0.jar


Project is having Swagger-Ui also which can be access using Below url

http://localhost:8081/MmtLogParser/swagger-ui.html#/



This Project uses the Spring Boot 2.3.1 version So We can dockerized the Application using mvn spring-boot:build-image