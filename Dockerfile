FROM ubuntu:latest AS build

RUN apt-get update && apt-get install -y wget

# Baixar e instalar OpenJDK 22 manualmente
RUN wget https://download.java.net/java/GA/jdk22/latest/binaries/openjdk-22_linux-x64_bin.tar.gz \
    && tar -xvf openjdk-22_linux-x64_bin.tar.gz \
    && mv jdk-22 /usr/local/

ENV JAVA_HOME=/usr/local/jdk-22
ENV PATH=$JAVA_HOME/bin:$PATH

COPY . .

RUN apt-get install -y maven
RUN mvn clean install

FROM ubuntu:latest

# Copiar o JDK 22 para a nova imagem
COPY --from=build /usr/local/jdk-22 /usr/local/jdk-22

ENV JAVA_HOME=/usr/local/jdk-22
ENV PATH=$JAVA_HOME/bin:$PATH

EXPOSE 8080

COPY --from=build /target/movies-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT [ "java", "-jar", "app.jar" ]
