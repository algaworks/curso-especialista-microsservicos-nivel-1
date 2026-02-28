# Migracao 12.16 - Competing Consumers Pattern

## Diferenca exclusiva desta aula
- Em `temperature-monitoring/infrastructure/rabbitmq/RabbitMQListener`, o consumidor passou a usar `@RabbitListener(..., concurrency = "2-3")`.
- Em `temperature-monitoring/src/main/resources/application.yml`, foram adicionados ajustes de consumo (`spring.rabbitmq.listener.simple.prefetch: 4`) e ajustes de ambiente local (`AUTO_SERVER=TRUE`, `show-sql: false`).

## Warnings novos
- Nenhum warning novo em relacao a aula anterior.

## Validacao
- `./gradlew build` executado com sucesso no `device-management`
- `./gradlew build` executado com sucesso no `temperature-processing`
- `./gradlew build` executado com sucesso no `temperature-monitoring`
