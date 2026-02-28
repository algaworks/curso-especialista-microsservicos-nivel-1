# Migracao 12.17 - Multiplas Queues para um Consumidor

## Diferenca exclusiva desta aula
- Em `temperature-monitoring/infrastructure/rabbitmq/RabbitMQConfig`, a configuracao passou a ter duas filas (`QUEUE_PROCESS_TEMPERATURE` e `QUEUE_ALERTING`) com seus respectivos bindings.
- Em `temperature-monitoring/infrastructure/rabbitmq/RabbitMQListener`, o consumidor foi separado em dois handlers (`handleProcessingTemperature` e `handleAlerting`) com listeners distintos.

## Ajustes adicionais desta migracao
- Houve `reject` incremental em `RabbitMQConfig` (conflito de contexto da aula); o bean de converter foi ajustado manualmente para manter `JacksonJsonMessageConverter`/`JsonMapper` no padrao da migracao.

## Warnings novos
- Nenhum warning novo em relacao a aula anterior.

## Validacao
- `./gradlew build` executado com sucesso no `device-management`
- `./gradlew build` executado com sucesso no `temperature-processing`
- `./gradlew build` executado com sucesso no `temperature-monitoring`
