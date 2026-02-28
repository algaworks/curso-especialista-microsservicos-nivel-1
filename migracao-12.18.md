# Migracao 12.18 - Implementando Service para os Alertas

## Diferenca exclusiva desta aula
- Foi adicionado `temperature-monitoring/domain/service/SensorAlertService.java` para centralizar a regra de alerta com base na configuracao de min/max do sensor.
- Em `temperature-monitoring/infrastructure/rabbitmq/RabbitMQListener`, o fluxo de alertas passou a delegar para `sensorAlertService.handleAlert(...)`.

## Warnings novos
- Nenhum warning novo em relacao a aula anterior.

## Validacao
- `./gradlew build` executado com sucesso no `device-management`
- `./gradlew build` executado com sucesso no `temperature-processing`
- `./gradlew build` executado com sucesso no `temperature-monitoring`
