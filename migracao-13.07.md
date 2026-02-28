# Migracao 13.07 - Desafio Comunicacao de Microsservicos com Mensageria

## Ajustes adicionais desta migracao
- Esta aula usa um projeto diferente (`algaposts`, com `post-service` e `text-processor-service`), sem a estrutura incremental de `algasensors`; por isso a migracao foi aplicada diretamente nos dois servicos.
- Em ambos os servicos, foi necessario atualizar para Spring Boot 4.0.1, Gradle 9.2.1 e Java 25.
- Em ambos os `RabbitConfig`, foi necessario migrar `Jackson2JsonMessageConverter`/`ObjectMapper` para `JacksonJsonMessageConverter`/`JsonMapper` (Jackson 3).

## Warnings novos
- Nenhum warning novo em relacao a aula anterior.

## Validacao
- `./gradlew build` executado com sucesso no `post-service`
- `./gradlew build` executado com sucesso no `text-processor-service`
