FROM eclipse-temurin:25-jdk-noble AS base

WORKDIR /app

ARG TAILWIND_VERSION=4.3.4

RUN apt-get update \
    && apt-get install -y --no-install-recommends curl ca-certificates \
    && rm -rf /var/lib/apt/lists/* \
    && case "$(dpkg --print-architecture)" in \
        amd64) ARCH=x64 ;; \
        arm64) ARCH=arm64 ;; \
        *) exit 1 ;; \
    esac \
    && curl -fL --retry 3 \
        "https://github.com/tailwindlabs/tailwindcss/releases/download/v${TAILWIND_VERSION}/tailwindcss-linux-${ARCH}" \
        -o /usr/local/bin/tailwindcss \
    && chmod +x /usr/local/bin/tailwindcss


FROM base AS dev

COPY . .
RUN chmod +x gradlew

ENV JAVA_TOOL_OPTIONS="-Dio.ktor.development=true"

EXPOSE 8080

CMD ["sh", "-c", "\
    tailwindcss \
      -i src/main/resources/static/css/input.css \
      -o src/main/resources/static/css/output.css \
      --watch --poll & \
    ./gradlew classes --continuous & \
    ./gradlew run \
"]


FROM base AS build

COPY . .
RUN chmod +x gradlew

RUN tailwindcss \
    -i src/main/resources/static/css/input.css \
    -o src/main/resources/static/css/output.css \
    --minify

RUN ./gradlew buildFatJar --no-daemon


FROM eclipse-temurin:25-jre-alpine AS prod

WORKDIR /app

COPY --from=build /app/build/libs/*-all.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
