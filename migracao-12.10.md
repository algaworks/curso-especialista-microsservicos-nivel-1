# Migracao 12.10 - Criando uma Exchange com Spring

## Diferencas em relacao a aula 12.09
- A aula adiciona no `temperature-processing`:
  - `infrastructure/rabbitmq/RabbitMQConfig.java`
  - `infrastructure/rabbitmq/RabbitMQInitializer.java`

## Ajuste adicional necessario na migracao
- Foi necessario ajustar `TemperatureProcessingApplicationTests` para mockar `RabbitAdmin` com `@MockitoBean`.
- Motivo: com Spring Boot 4, o `RabbitMQInitializer` tenta inicializar o broker no `contextLoads()` e o teste falha quando nao existe RabbitMQ local ativo.
- Esse ajuste afeta apenas o ambiente de teste e nao altera o comportamento de runtime da aula.

## Warnings novos
- Nenhum warning novo em relacao a aula anterior.

## Validacao
- `./gradlew build` executado com sucesso no `device-management`
- `./gradlew build` executado com sucesso no `temperature-processing`
- `./gradlew build` executado com sucesso no `temperature-monitoring`
