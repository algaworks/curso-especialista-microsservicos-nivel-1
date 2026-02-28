# Migracao 12.14 - Consumindo Mensagens

## Ajustes adicionais desta migracao
- Em `temperature-monitoring/api/config/jackson/StringToTSIDDeserializer`, foi necessario migrar `com.fasterxml.jackson.*` para `tools.jackson.*` (`ValueDeserializer`) para compilar com Jackson 3.
- Em `temperature-monitoring/infrastructure/rabbitmq/RabbitMQConfig`, foi necessario trocar `Jackson2JsonMessageConverter` por `JacksonJsonMessageConverter` e `ObjectMapper` por `JsonMapper`.
- Houve um `reject` incremental em `TSIDJacksonConfig` (conflito de contexto da aula); a assinatura do bean foi ajustada para `JacksonModule`.

## Warnings novos
- Nenhum warning novo em relacao a aula anterior.

## Validacao
- `./gradlew build` executado com sucesso no `device-management`
- `./gradlew build` executado com sucesso no `temperature-processing`
- `./gradlew build` executado com sucesso no `temperature-monitoring`
