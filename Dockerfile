FROM eclipse-temurin:17-jdk-alpine
LABEL authors="HP"

WORKDIR /app
COPY produit/target/produit.jar ./produit.jar
EXPOSE 8082
CMD ["java", "-jar","produit.jar"]