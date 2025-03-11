 
 
				IoT Device Management API with Kafka Integration
 
 Setup instructions
 
 MySQL DB
 ========
 
 1) Download and install MySQL Database (version 8.x or higher) into the local system. This should include Workbench also
 
 2) Open MySQL workbench and Create a MySQL connection with userid and password provided (normally for testing purpose , userid : root can be used)
 
 3) Once connection is successful, create Database 
 
 CREATE DATABASE iot_devices_db
 
 4) Create table as follows
 
 CREATE TABLE `iot_devices_db`.`iot_devices` (
  `id` BINARY(16) NOT NULL,
  `name` VARCHAR(100) NULL,
  `status` ENUM('ONLINE', 'OFFLINE', 'ERROR') NULL,
  `last_seen` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `metadata` JSON NULL,
  PRIMARY KEY (`id`))
COMMENT = 'table holding iot devices information';
 
 Application setup and launch
 ============================
 
 1) Download / Checkout the project iotdevicemanagment from Github
 
 2) Import / Open this in any IDE like IntelliJ Idea or Eclipse
 
 3) Modify the application.properties with the db paramenters like userid and password accordingly 
 
 4) Start the application by running the Spring boot bootstrap/main class
 
 5) The output console shows application launched and started.
 
 Note: Currently, getter and setter not working properly in my IntelliJ IDE so getter and setter methods added to the Entity class explicitily to make the application running and working.
 
 Testing REST API Endpoints
 ==========================
 
 1) Download , Install and setup Postman tool in the system
 
 2) Test the REST API endpoints as shown in the screenshot for POST, PUT, GET, DELETE. Screenshots attached for reference
 
 Note: As of now, except POST , other API requests showing some incompatible type error with respect to @PathVariable in the request method
 
 
 Apache Kafka Integration
 =======================
 
 1) Code for Kafka producer and consumer configuration and service class have been implemented. But not tested locally.
 
 2) To test this, download and install and setup Zookeeper and Kafka in local Windows or Unix machine
 
 3) Once it is installed successfully, we can run the zookeeper and kafka respectively as a service as follows
 
 .\bin\windows\zookeeper-server-start.bat .\config\zookeeper.properties
 
 .\bin\windows\kafka-server-start.bat .\config\server.properties

3) Publishing to a Kafka Topic. The code for publishing during Device Registration and also sending a Device command with a POST command is completed , but not tested locally

4) Consuming from a Kafka topic is implemented in the KafkaConsumerService class,  but not tested locally

To test both publish and consume the following commands need to be run and tested.
 

For Windows 
 First create the topic (replace with the required topic name mentioned in the project requirement) with the below command

 .\bin\windows\kafka-topics.bat –create –zookeeper localhost:2181 –replication-factor 1 –partitions 1 –topic TOPIC_NAME
 

 To see the messages on the Kafka server in the real-time, use the command below
 
 .\bin\windows\kafka-console-consumer.bat –bootstrap-server localhost:9092 –topic TOPIC_NAME –from-beginning
 
 To run Kafka producer console, use the command below
 
 .\bin\windows\Kafka-console-producer.bat –broker-list localhost:9092 –topic TOPIC_NAME
 
 Run the application , send POST request in PostMan  and type message on Kafka producer as above and press enter.
 
 
 Features not implemented
 =========================
 
 1) Spring Boot Actuator 
 
 This can be implmented by adding the spring boot actuator starter dependencies in pom.xml and 
 adding necessary management endpoints expose or hide in application.properties or .yaml file of the project
 
 2) Application Logging
 
 This can be added by adding necessary logging framework starter dependencies in pom.xml and necessary logback or log configuration file and also logging levels in application.properties file
 
 3)  unit tests using JUnit & Mockito
 
 To test Controllers and Service classes, we can use mockMvc and Mockito 
 
 

