# Getting Started

## Run it as an API

```bash
java -Dspring.profiles.active=api -jar target/batch-api-mix-0.0.1-SNAPSHOT.jar 
```

You could then reach it with this command:

```bash
http :8080/api
```



## Run it as an BATCH

```bash
java -Dspring.profiles.active=batch -jar target/batch-api-mix-0.0.1-SNAPSHOT.jar 
```

You could then see ``Hello World!` in the logs.
