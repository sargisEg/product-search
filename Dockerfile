FROM eclipse-temurin:17-jdk-alpine

COPY ["build/libs/product-search-0.0.1-SNAPSHOT.jar", "/product-search.jar"]
ENTRYPOINT ["java", "-jar", "/product-search.jar"]