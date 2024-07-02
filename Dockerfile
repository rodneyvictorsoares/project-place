# Use uma imagem base do OpenJDK 17
FROM openjdk:17-jdk-slim

# Defina o diretório de trabalho dentro do contêiner
WORKDIR /app

# Copie o arquivo JAR gerado para o diretório de trabalho no contêiner
COPY target/project-place-0.0.1-SNAPSHOT.jar app.jar

# Exponha a porta que a aplicação Spring Boot usará
EXPOSE 8080

# Defina o comando para executar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]
