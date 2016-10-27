#micro-crm

###Тестовое задание

Дано:

    Сущность «Client», которая имеет связь многие ко многим на саму себя.

Требуется:

    1. спроектировать контракт RESTFul сервиса имеющего операции CRUD сущности Client в нотации Swagger(OpenAPI)

    2. реализовать этот сервис

Что сделано:

    1. Создана спека для API с помощью http://editor.swagger.io/#/

    2. Сгенерирован JAX-RS server

    3. Дописаны контроллеры эмулирующие логику


    В системе везде Customer это "Client" из ТЗ.

    Почти вся работа проделана в классах:

        domain.CustomerModel,

        domain.CustomerService и

        io.swagger.api.impl.CustomersApiServiceImpl

    Структура сгенерированного проекта не менялась


Возможные улучшения:

    1. Более изящная и информативная схема ответов и эксепшнов


Запускать:

    mvn clean package jetty:run

Читать спеку по API:

    http://localhost:8080/api/v1/swagger.json

