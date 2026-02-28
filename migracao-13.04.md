# Migracao 13.04 - Utilizando uma Dead Letter Queue (DLQ)

## Diferenca exclusiva desta aula
- Em `temperature-monitoring/infrastructure/rabbitmq/RabbitMQConfig`, a fila de processamento passou a ter configuracao de dead-letter (`x-dead-letter-exchange` e `x-dead-letter-routing-key`) e foi criada a fila `...process-temperature.v1.dlq`.
- Em `temperature-monitoring/domain/service/TemperatureMonitoringService`, o erro proposital do teste de retry foi desativado (comentado).

## Warnings novos
- Nenhum warning novo em relacao a aula anterior.

## Validacao
- `./gradlew build` executado com sucesso no `device-management`
- `./gradlew build` executado com sucesso no `temperature-processing`
- `./gradlew build` executado com sucesso no `temperature-monitoring`
