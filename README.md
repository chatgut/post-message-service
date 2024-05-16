# Postservice 
The microservice acts as a platform for efficiently storing and managing messages with the support of MongoDB, RabbitMQ, and Redis.

## Running the Application with Docker
This application runs on port 8000.  <br>
To run the application using Docker pull the Docker Image:
```bash
docker pull hacee/post-message-service:v1.0.0
```

## Docker image requirements
- MongoDB running on port 27017
- Redis running on port 6379
- RabbitMQ running on port 5672 for operation and port 15672 for accessing the management interface.

## Environment variables
**The following environment variables are required to run RabbitMQ management interface:** <br>

```
SPRING_RABBITMQ_USERNAME="guest"
SPRING_RABBITMQ_PASSWORD="guest"
```

## API Reference
**Get all messages** <br>
Retrieve all stored messages.

```
  http://localhost:8000/posts
```
**Get message by ID** <br>
Retrieve a message by its unique identifier.
```
  http://localhost:8000/posts/{id}
```
**Create message** <br>
Create a new message.
```
  http://localhost:8000/posts
```
**Delete message by ID** <br>
Delete a message by its unique identifier.
```
  http://localhost:8000/posts/{id}
```
