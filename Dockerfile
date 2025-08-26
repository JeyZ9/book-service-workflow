FROM maven:3.9.6  AS builder

WORKDIR /app

COPY . .

RUN mvn clean -DskipTests install 

FROM openjdk:17-oracle

WORKDIR /books-service/app

ENV PGSQL_HOST "dpg-d2miuf8gjchc73cmnr2g-a.singapore-postgres.render.com"
ENV PGSQL_PORT 5432
ENV PGSQL_USERNAME "book_db_bsab_user"
ENV PGSQL_PASSWORD "486FcARpUrxCFixuEL8A26CmmQ9T8qJ7"

COPY --from=builder /app/target/books-service-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]