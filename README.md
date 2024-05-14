# Postservice 
The microservice acts as a platform for efficiently storing and managing messages with the support of MongoDB, RabbitMQ, and Redis.

## Running the Application with Docker
This application runs on port 8000
To run the application using Docker pull the Docker Image:
"docker pull hacee/post-message-service:latest"

## Docker image requries
MongoDB on port 27017
Redis on port 6379
RabbitMQ on port 5672 to run and port 15672 to access management interface

## Enviourment variables 
rabbitmq_host=localhost
rabbitmq_port=5672
rabbitmq_username=guest
rabbitmq_password=guest

## API Reference
**Gett all messages**
```
  GET http://localhost:8000/posts
```
**Get message**
```
  GET http://localhost:8000/posts/{id}
```
**Create message**
```
  POST http://localhost:8000/posts
```
**Delete message**
```
  DELETE http://localhost:8000/posts/{id}
```
