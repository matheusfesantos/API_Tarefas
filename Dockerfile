# Usa a imagem oficial do Ubuntu mais recente
FROM ubuntu:latest

# Define o autor da imagem
LABEL authors="Lenovo"

# Instala o Java 17 (necessário para rodar Spring Boot)
RUN apt update && apt install -y openjdk-17-jdk

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o JAR da aplicação para dentro do container
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# Expõe a porta 8080 (padrão do Spring Boot)
EXPOSE 8080

# Comando para rodar a aplicação ao iniciar o container
ENTRYPOINT ["java", "-jar", "app.jar"]