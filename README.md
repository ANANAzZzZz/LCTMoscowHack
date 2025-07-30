## Кейс
### С кейсом можно ознакомиться [тут](https://github.com/ANANAzZzZz/LCTMoscowHack/blob/master/Case.pdf)
## Описание решения 
&ensp; Наша серверная часть представляет собой надежную и масштабируемую 
архитектуру, разработанную на основе архитектурного стиля REST. Главная 
цель нашего решения — обеспечение безопасности и удобства использования 
сервиса для различных типов пользователей: сотрудников, администраторов и 
туристов. Система включает функционал авторизации и регистрации с 
использованием JWT токенов для обеспечения безопасности и управления 
доступом пользователей. Мы реализовали следующие роли: сотрудник, 
администратор и турист, каждая из которых имеет свои привилегии и доступ 
к функционалу. 
## Архитектура системы 
&ensp; Архитектура нашего приложения построена на принципах REST, что 
обеспечивает простоту и удобство взаимодействия клиента и сервера. Вся 
коммуникация осуществляется через четко определенные эндпоинты API, что 
позволяет легко масштабировать и модифицировать систему без 
значительных изменений в коде. 
## Используемый стек: 
* Язык программирования: Java 17 
* Фреймворк: Spring Boot 
* Spring Data JPA для работы с базой данных
* Spring Web для создания RESTful сервисов
* База данных: PostgreSQL, развернутая на сервисе Timeweb Cloud
* Развертывание: Nginx, Docker 
* Облачный хостинг: Timeweb Cloud
## Библиотеки и инструменты:
* JSON Web Tokens (JWT) для безопасной передачи и проверки токенов аутентификации
* Apache Commons FileUpload для загрузки и обработки фотографий
* Lombok для упрощения кода и уменьшения шаблонного кода в модели данных
## Эндпоинты API 
&ensp; Наше API включает различные эндпоинты для обеспечения полноценного 
функционала (Для всех эндпоинтов кроме регистрации и авторизации необходим JWT токен для аутентификации пользователя). Ознакомиться со swagger можно по адресу
Swagger: http://localhost:8080/swagger-ui/index.html 

## Итоги
&ensp; По итогам хакатона наша команда заняла 2 место с отставанием в 0.6 балла от первого. 
- [Статья от ГУАП](https://new.guap.ru/pubs/22553) 
- [Презентация нашего решения](https://github.com/ANANAzZzZz/LCTMoscowHack/blob/master/Presentation.pdf)
- [Диплом призера](https://github.com/ANANAzZzZz/LCTMoscowHack/blob/master/%D0%94%D0%B8%D0%BF%D0%BB%D0%BE%D0%BC%20II%20%D1%81%D1%82%D0%B5%D0%BF%D0%B5%D0%BD%D0%B8%2C%20%D0%A1%D1%8B%D0%B2%D0%BE%D1%80%D0%BE%D1%82%D0%BD%D0%B5%D0%B2%D0%92%D1%81%2C%20%D0%A5%D0%B0%D0%BA%D0%B0%D1%82%D0%BE%D0%BD%20%D0%9B%D0%A6%D0%A2.pdf_page-0001.jpg)

---
<p align="center">
  <img src="/screens/Presentation_page-0001.jpg" />
</p>

<p align="center">
  <img src="/screens/Presentation_page-0003.jpg" />
</p>

<p align="center">
  <img src="/screens/Presentation_page-0004.jpg" />
</p>

<p align="center">
  <img src="/screens/Presentation_page-0005.jpg" />
</p>

<p align="center">
  <img src="/screens/Presentation_page-0006.jpg" />
</p>

<p align="center">
  <img src="/screens/Presentation_page-0007.jpg" />
</p>

<p align="center">
  <img src="/screens/Presentation_page-0008.jpg" />
</p>

<p align="center">
  <img src="/screens/Presentation_page-0009.jpg" />
</p>

<p align="center">
  <img src="/screens/Presentation_page-0010.jpg" />
</p>

<p align="center">
  <img src="/screens/Presentation_page-0011.jpg" />
</p>

<p align="center">
  <img src="/screens/Presentation_page-0012.jpg" />
</p>

<p align="center">
  <img src="/screens/Presentation_page-0013.jpg" />
</p>

<p align="center">
  <img src="/screens/Presentation_page-0014.jpg" />
</p>

---
## Case  
### You can review the case [here](https://github.com/ANANAzZzZz/LCTMoscowHack/blob/master/Case.pdf)  

## Solution Description  
&ensp; Our backend represents a reliable and scalable architecture based on the REST architectural style. The main goal of our solution is to ensure the security and usability of the service for different types of users: employees, administrators, and tourists.  
The system includes functionality for authorization and registration using JWT tokens to provide security and access control. We implemented the following roles: employee, administrator, and tourist — each with its own privileges and access to specific features.  

## System Architecture  
&ensp; The architecture of our application is built on REST principles, which ensures simple and convenient interaction between client and server. All communication is carried out through well-defined API endpoints, making it easy to scale and modify the system without major code changes.  

## Technology Stack  
* Programming Language: Java 17  
* Framework: Spring Boot  
* Spring Data JPA for working with the database  
* Spring Web for creating RESTful services  
* Database: PostgreSQL, deployed on Timeweb Cloud
* Deploy: Nginx, Docker
* Cloud Hosting: Timeweb Cloud  

## Libraries and Tools  
* JSON Web Tokens (JWT) for secure transmission and verification of authentication tokens  
* Apache Commons FileUpload for uploading and processing photos  
* Lombok to simplify code and reduce boilerplate in data models  

## API Endpoints  
&ensp; Our API includes various endpoints to provide full functionality (A JWT token is required for all endpoints except registration and login). You can explore the Swagger documentation at:  
Swagger: http://localhost:8080/swagger-ui/index.html  

## Results  
&ensp; As a result of the hackathon, our team took 2nd place, just 0.6 points behind the first.  
- You can read an article about it [here](https://new.guap.ru/pubs/22553)  
- You can view the presentation of our solution [here](https://github.com/ANANAzZzZz/LCTMoscowHack/blob/master/Presentation.pdf)  
- You can see the winner’s diploma [here](https://github.com/ANANAzZzZz/LCTMoscowHack/blob/master/%D0%94%D0%B8%D0%BF%D0%BB%D0%BE%D0%BC%20II%20%D1%81%D1%82%D0%B5%D0%BF%D0%B5%D0%BD%D0%B8%2C%20%D0%A1%D1%8B%D0%B2%D0%BE%D1%80%D0%BE%D1%82%D0%BD%D0%B5%D0%B2%D0%92%D1%81%2C%20%D0%A5%D0%B0%D0%BA%D0%B0%D1%82%D0%BE%D0%BD%20%D0%9B%D0%A6%D0%A2.pdf_page-0001.jpg)

