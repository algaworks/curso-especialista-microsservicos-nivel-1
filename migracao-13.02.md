# Migracao 13.02 - Lidando com Erros em Consumer com Retry Pattern

## Diferenca exclusiva desta aula
- Em `temperature-monitoring/src/main/resources/application.yml`, foi adicionada configuracao de retry do listener AMQP (`enabled`, `initial-interval`, `max-interval`, `multiplier`, `max-attempts`).
- Em `temperature-monitoring/domain/service/TemperatureMonitoringService`, foi inserido erro proposital para teste de retry quando valor da temperatura for `10.5`.
- Em `temperature-monitoring/infrastructure/rabbitmq/RabbitMQListener`, o `sleep` no fluxo de processamento foi comentado para facilitar o teste de retry.

## Warnings novos
- Nenhum warning novo em relacao a aula anterior.

## Validacao
- `./gradlew build` executado com sucesso no `device-management`
- `./gradlew build` executado com sucesso no `temperature-processing`
- `./gradlew build` executado com sucesso no `temperature-monitoring`
