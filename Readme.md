## Migrations
1. Apply

        ./gradlew update


## Start application
1. Build application jar
        
        ./gradlew build -x test
2. Docker compose up

        docker-compose up -d
        
3. Run application. Option 1

       ./gradlew bootRun
         
4. Run application. Option 2
 
       java -jar build/libs/renlife_demo-0.0.1-SNAPSHOT.jar

## Test

1. Run tests
         
        ./gradlew test

### URLs
1. GET  http://localhost:8089/public/v1/factorial/{num}
2. POST http://localhost:8089/api/v1/fact
3. GET  http://localhost:8089/api/v1/products