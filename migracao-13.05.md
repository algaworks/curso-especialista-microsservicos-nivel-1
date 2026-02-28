# Migracao 13.05 - O que Fazer com as Mensagens da DLQ

## Diferenca exclusiva desta aula
- Em `algasensors/docker-compose.yml`, foi adicionado volume para mapear `./configs/rabbitmq/enabled_plugins` no container RabbitMQ.
- Foi adicionado `algasensors/configs/rabbitmq/enabled_plugins` para habilitar plugins (`rabbitmq_management`, `rabbitmq_shovel`, `rabbitmq_shovel_management`).

## Warnings novos
- Nenhum warning novo em relacao a aula anterior.

## Validacao
- `./gradlew build` executado com sucesso no `device-management`
- `./gradlew build` executado com sucesso no `temperature-processing`
- `./gradlew build` executado com sucesso no `temperature-monitoring`
