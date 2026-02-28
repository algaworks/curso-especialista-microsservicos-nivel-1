# Migracao 12.09 - Configurando o Spring AMQP no projeto

## Alteracoes realizadas

### build.gradle (3 microservicos)
- Spring Boot: `3.4.3` -> `4.0.1`
- Java: `21` -> `25`
- `spring-boot-starter-web` -> `spring-boot-starter-webmvc`
- `spring-boot-starter-test` -> `spring-boot-starter-data-jpa-test` + `spring-boot-starter-webmvc-test` (device-management e temperature-monitoring)
- `spring-boot-starter-test` -> `spring-boot-starter-webmvc-test` (temperature-processing)
- Adicionado `spring-boot-h2console` (device-management e temperature-monitoring)
- Adicionado `spring-boot-starter-json` (device-management e temperature-monitoring - necessario para Jackson 3.x)
- Adicionado `spring-boot-starter-restclient` (device-management - necessario para RestClient.Builder)
- `commons-lang3`: `3.17.0` -> `3.20.0` (temperature-processing)
- `java-uuid-generator`: `5.1.0` -> `5.2.0` (temperature-processing)

### gradle-wrapper.properties (3 microservicos)
- Gradle: `8.12.1` -> `9.2.1`

### Migracao Jackson 2.x -> 3.x (device-management e temperature-monitoring)
As classes `TSIDJacksonConfig`, `TSIDToStringSerializer` e `StringToTSIDDeserializer` foram ajustadas para Jackson 3.x:

**Imports atualizados:**
- `com.fasterxml.jackson.core.JsonGenerator` -> `tools.jackson.core.JsonGenerator`
- `com.fasterxml.jackson.core.JsonParser` -> `tools.jackson.core.JsonParser`
- `com.fasterxml.jackson.databind.JsonSerializer` -> `tools.jackson.databind.ValueSerializer`
- `com.fasterxml.jackson.databind.JsonDeserializer` -> `tools.jackson.databind.ValueDeserializer`
- `com.fasterxml.jackson.databind.SerializerProvider` -> `tools.jackson.databind.SerializationContext`
- `com.fasterxml.jackson.databind.DeserializationContext` -> `tools.jackson.databind.DeserializationContext`
- `com.fasterxml.jackson.databind.Module` -> `tools.jackson.databind.JacksonModule`
- `com.fasterxml.jackson.databind.module.SimpleModule` -> `tools.jackson.databind.module.SimpleModule`

**Classes renomeadas:**
- `JsonSerializer<T>` -> `ValueSerializer<T>`
- `JsonDeserializer<T>` -> `ValueDeserializer<T>`
- `SerializerProvider` -> `SerializationContext`
- `Module` -> `JacksonModule`

**Outras mudancas:**
- Removido `throws IOException` e `throws IOException, JacksonException` dos metodos `serialize()` e `deserialize()` (Jackson 3.x usa unchecked exceptions)
- Removido imports `java.io.IOException` e `com.fasterxml.jackson.core.JacksonException`

### Novidade desta aula
- O `temperature-processing` e o `temperature-monitoring` passam a incluir `spring-boot-starter-amqp`.
- A configuracao de conexao RabbitMQ em `temperature-processing/src/main/resources/application.yml` (host, port, username e password) foi preservada exatamente como no codigo da aula.
- Durante o `git apply --reject`, houve rejeicoes apenas nos `build.gradle` de `temperature-monitoring` e `temperature-processing` por causa dessas adicoes de AMQP; os ajustes foram aplicados manualmente mantendo as configuracoes da aula.

## Warning conhecido: Lombok + sun.misc.Unsafe
O warning `sun.misc.Unsafe::objectFieldOffset has been called by lombok.permit.Permit` e causado pelo Lombok 1.18.42 usando APIs depreciadas do `sun.misc.Unsafe` no Java 25. E um problema conhecido e ainda sem correcao disponivel no Lombok (issue: https://github.com/projectlombok/lombok/issues/3959). O warning nao impacta o build nem a funcionalidade.

## Validacao
- `./gradlew build` executado com sucesso no `device-management`
- `./gradlew build` executado com sucesso no `temperature-processing`
- `./gradlew build` executado com sucesso no `temperature-monitoring`
