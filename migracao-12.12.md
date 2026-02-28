# Migracao 12.12 - Publicando Mensagens

## Diferencas em relacao a aula 12.11
- A aula adiciona no `temperature-processing`:
  - `api/config/jackson/TSIDJacksonConfig.java`
  - `api/config/jackson/TSIDToStringSerializer.java`

## Ajustes adicionais necessarios na migracao
- Foi necessario adicionar `spring-boot-starter-json` no `temperature-processing`.
- As novas classes Jackson do `temperature-processing` foram migradas de Jackson 2.x para 3.x (`tools.jackson.*`, `JacksonModule`, `ValueSerializer`).
- Em `infrastructure/rabbitmq/RabbitMQConfig`, foi necessario trocar `Jackson2JsonMessageConverter` por `JacksonJsonMessageConverter` e usar `JsonMapper` (Jackson 3), pois o conversor antigo depende de `com.fasterxml.jackson` e nao compila no setup da migracao.

## Warnings novos
- Surgiu warning de deprecacao/remocao do `Jackson2JsonMessageConverter` ao compilar com Spring AMQP 4; foi resolvido com a migracao para `JacksonJsonMessageConverter`.

## Validacao
- `./gradlew build` executado com sucesso no `device-management`
- `./gradlew build` executado com sucesso no `temperature-processing`
- `./gradlew build` executado com sucesso no `temperature-monitoring`
