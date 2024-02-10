
# Ktor ToDo App

A sample todo app API using Ktor and Kotlin, connecting to MySQL database

## Prerequisites

To run this project, you need to have the following installed:

- Kotlin 1.5.x
- MySQL database
- JDK 1.8 or later
- Gradle 7.x


## Getting Started

1. Clone the repository:

   ```shell
   git clone git@github.com:Israeloyedele/ktor-todo.git

##  Set up the database:

- Create a new MySQL database table inside a database with the name todo.
- Update the database connection details in the DatabaseManager.kt file.
- Build and run the project:
``` shell
cd ktor-todo
./gradlew run
```


## API Reference

#### Get all items

```
  GET /todos
  returns a list of all todos
```

#### Get single todo

```
  GET /todos/{id}
  returns a single todo by id
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Integer` | **Required**. Id of item to fetch |

#### Add a todo

```
  POST /todos
  receives data about a todo, adds it to the database and returns added todo
```
#### Update a todo

```
  POST /todos/{id}
  
  receives data about a todo to be updated and updates the database
```
| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Integer` | **Required**. Id of item to update |

### Delete a todo

```
  GET /todos/{id}
  removes a single todo by id
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `Integer` | **Required**. Id of item to remove |

## Dependencies

The project uses the following dependencies:

- Ktor: A framework for building asynchronous servers and clients
- KTorm: A SQL-centric Kotlin ORM library
- MySQL: A relational database for data storage and persistence

## LinkedIn Profile
* You can connect with me on LinkedIn: https://www.linkedin.com/in/israeloyedele
