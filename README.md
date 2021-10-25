# 🚀 Spring Market API <img alt="GitHub stars" src="https://img.shields.io/github/stars/farinas09/portfolio">


<p align="center">
  <kbd>
    <img src="https://github.com/farinas09/spring-market/blob/main/swagger-ui.png"></img>
  </kbd>
</p>

## Features
✔️ Users\
✔️ Roles\
✔️ Products\
✔️ Categories


## Technologies & Dependencies 

- [Spring security](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [MySQL](https://www.mysql.com/)
- [Swagger](https://swagger.io/)
- [JWT](https://jwt.io/)
- [MapStruct](https://mapstruct.org/)

## Get started 

First, open the root project folder and run `database.sql file`. it contains the db schema and example data.

Open the project directory with IntelliJ Idea, then run the application.

The default user is `admin` and the password is `1234`.

In development mode, the api url is `http://localhost:8090/market/api`, you can change it in the `application-dev.properties` file.

You will also see Swagger API documentation at `http://localhost:8090/market/api/swagger-ui.html`.

If you prefer to use postman, import the collection from the file `MarketAPI.postman_collection.json`

### Production mode

Setup your prod environment variables as the example `application-pdn.properties` shows. Then in `application.properties` file, change the `spring.profiles.active` value to `pdn`.

