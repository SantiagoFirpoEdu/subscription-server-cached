# Nomes: Lucas Wolschick, Paola Lopes, Santiago Firpo e Vitor Jacom

Coisas para fazer

- [X] Subir Kafka
- [X] Debugar Docker Compose
- [X] Registrar serviços no discovery service
- [X] Rotear requests para o subscription-service
- [X] Rotear requests para o subscription-status-cache
- [X] Receber updates do RabbitMQ
- [X] Notificar RabbitMQ
- [X] Testar endpoints do subscription-service containerizado
- [X] Testar endpoints do subscription-status_cache containerizado
- [X] Testar endpoints do subscription-service local
- [X] Testar endpoints do subscription-status_cache local

Todos os endpoints podem ser testados no IntelliJ, por meio do arquivo ```subscription_service/src/main/resources/generated-requests.http```.

O fluxo de pagamento e revalidação de uma assinatura pode ser testado no IntelliJ, por meio do arquivo ```subscription_service/src/main/resources/cache-requests.http```.

O sistema pode ser executado localmente rodando apenas o container do rabbitmq, e o resto das aplicações executando localmente.

O sistema também pode ser executado no Docker, rodando o comando ```docker compose up``` no diretório root do projeto.

O projeto foi desenvolvido em conjunto de forma colaborativa em sessões de live coding, tanto durante as aulas quanto em outros momentos.
