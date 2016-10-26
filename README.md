# micro-crm

Тестовое задание.

Дано:
  Сущность «Client», которая имеет связь многие ко многим на саму себя.
Требуется:
    1. спроектировать контракт RESTFul сервиса имеющего операции CRUD сущности Client в нотации Swagger(OpenAPI)
    2. реализовать этот сервис

Что сделано:
    1. Создана спека для API здесь http://editor.swagger.io/#/
    2. Сгенерирован JAX-RS server
    3. Дописаны контроллеры эмулирующие логику
Запускать:
    mvn clean package jetty:run
Читать спеку по API:
    http://localhost:8080/api/v1/swagger.json
