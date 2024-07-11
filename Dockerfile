FROM openjdk:17-jdk-slim as builder
WORKDIR /app

COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src

RUN ./gradlew build #--no-daemon
# 멀티 스테이지 빌드 사용

FROM openjdk:17-jdk-slim
LABEL maintainer="leesy010504"
EXPOSE 8080
WORKDIR /app

# 빌드 단계에서 생성된 JAR 파일 복사
COPY --from=builder /app/build/libs/*.jar /first-docker-spring.jar

# 애플리케이션 실행
ENTRYPOINT ["java", "-jar", "/first-docker-spring.jar"]
