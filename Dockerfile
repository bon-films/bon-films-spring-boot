FROM openjdk:11
ADD ./target/bon-films-spring-boot-0.0.1-SNAPSHOT.jar ./bon-films-spring-boot-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "bon-films-spring-boot-0.0.1-SNAPSHOT.jar"]