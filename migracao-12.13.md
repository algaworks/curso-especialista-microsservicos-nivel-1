# Migracao 12.13 - Adicionando Cabecalhos na Mensagem

## Diferenca exclusiva desta aula
- Em `temperature-processing`, o `TemperatureProcessingController` passou a publicar a mensagem com header `sensorId` via `MessagePostProcessor`.

## Warnings novos
- Nenhum warning novo em relacao a aula anterior.

## Validacao
- `./gradlew build` executado com sucesso no `device-management`
- `./gradlew build` executado com sucesso no `temperature-processing`
- `./gradlew build` executado com sucesso no `temperature-monitoring`
