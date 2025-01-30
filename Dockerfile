# Fase 1: Construcción de la aplicación
FROM maven:3.8.5-openjdk-17 AS build

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar los archivos del proyecto al contenedor
COPY . .

# Construir el archivo JAR
RUN mvn clean package -DskipTests

# Fase 2: Ejecución del JAR en una imagen más liviana
FROM openjdk:17-jdk-slim

# Establecer el directorio de trabajo
WORKDIR /app

# Copiar el JAR desde la fase de construcción
COPY --from=build /app/target/empleados-0.0.1-SNAPSHOT.jar empleados.jar

# Exponer el puerto en el que la aplicación Spring Boot escucha
EXPOSE 8080

# Ejecutar el archivo JAR al iniciar el contenedor
ENTRYPOINT ["java", "-jar", "empleados.jar"]