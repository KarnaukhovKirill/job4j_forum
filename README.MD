# job4j_forum

## О проекте

Веб приложение, реализующее функционал интернет форума. Позволяет создавать темы для обсуждения, 
объявления. Приложение доступно только зарегистрированным пользователям.

Технологии:

![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Postgres](https://img.shields.io/badge/postgres-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![Hibernate](https://img.shields.io/badge/Hibernate-59666C?style=for-the-badge&logo=Hibernate&logoColor=white)
![GitHub Actions](https://img.shields.io/badge/github%20actions-%232671E5.svg?style=for-the-badge&logo=githubactions&logoColor=white)
![Heroku](https://img.shields.io/badge/heroku-%23430098.svg?style=for-the-badge&logo=heroku&logoColor=white)

## Запуск приложения
1. Скачайте исходные файлы
2. Создайте в Postgres базу данных todo
3. В файле src/main/resources/application.properties измените username, password вашей базы данных. 
4. Из корневой папки вызовите команду
````
mvn install
````
5. Файл target/forum-1.war поместите в контейнер сервлетов (Apache Tomcat, например)

## Как пользоваться
После запуска веб приложение будет доступно по адресу http://localhost:8080

При переходе по адресу необходимо зарегистрироваться или пройти авторизацию, если есть логин и пароль

![alt text](https://github.com/KarnaukhovKirill/job4j_forum/blob/main/img/Reg.png)

![alt text](https://github.com/KarnaukhovKirill/job4j_forum/blob/main/img/Login.png)

Главная страница представляет собой список тем

![alt text](https://github.com/KarnaukhovKirill/job4j_forum/blob/main/img/Main.png)

Чтобы создать новую тему, нажимаем "Создать тему"

![alt text](https://github.com/KarnaukhovKirill/job4j_forum/blob/main/img/Create_topic.png)

После этого тема окажется на главной странице. Удалять и редактировать темы может либо администратор, либо
создатель темы

![alt text](https://github.com/KarnaukhovKirill/job4j_forum/blob/main/img/Created_topic.png)

## TODO
- [ ] Добавить вывод сообщений темы с необходимой информацией
- [x] Сделать редактирование темы
- [ ] Сделать личный кабинет пользователя


## Контакты
Есть вопросы по проекту? Свяжитесь со мной в [![alt text](https://badges.aleen42.com/src/telegram.svg)](https://t.me/Tur_Boyama)

Или пишите на почту: karnaukhov.kirill23@gmail.com

[![Java CI with Maven](https://github.com/KarnaukhovKirill/job4j_forum/actions/workflows/github-actions-demo.yml/badge.svg)](https://github.com/KarnaukhovKirill/job4j_forum/actions/workflows/github-actions-demo.yml)