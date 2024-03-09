FROM eclipse-temurin:17
WORKDIR /home
COPY ./target/Guitar-Management-0.0.1-SNAPSHOT.jar gim.jar
ENTRYPOINT ["java", "-jar", "gim.jar"]
