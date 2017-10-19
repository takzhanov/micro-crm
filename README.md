#Тестовое задание Micro-CRM

Дано:
    
* Сущность _Customer_, которая имеет связь многие ко многим на саму себя.

Требуется:
1) спроектировать контракт RESTFul сервиса, имеющего операции CRUD для сущности _Customer_ 
в нотации Swagger(OpenAPI)
2) реализовать этот сервис

Что сделано:
1) Создана спека для API с помощью http://editor.swagger.io/#/
2) Сгенерирован JAX-RS server
3) Дописаны контроллеры, эмулирующие логику


Почти вся работа проделана в классах:
* domain.CustomerModel
* domain.CustomerService
* io.swagger.api.impl.CustomersApiServiceImpl

Структура сгенерированного проекта не менялась

Возможные улучшения:
* Более изящная и информативная схема ответов и эксепшнов

Запускать:
> mvn clean package jetty:run

Читать спеку по API:
> [http://localhost:8080/api/v1/swagger.json](http://localhost:8080/api/v1/swagger.json)

