# Тестовое задание Гринатом
Решение можно запустить с помощью стандартного
```sh
docker compose up --build
```
В решении реализованы такие запросы (с помощью curl):

1) Cоздание файла:
```sh
curl -X POST http://localhost:8080/api/files 
    -H "Content-Type: application/json" 
    -d '{
            "title": "example.txt",
            "creationDate": "2024-08-06T16:50:55",
            "description": "Example file",
            "fileContent": "SGVsbG8gV29ybGQ="
        }'
```
в ответ получаем id файла.

2) Получение файла:
```sh
curl -X GET http://localhost:8080/api/files/2
```

3) Вывод списка всех сохраненных файлов:
```sh
curl -X GET http://localhost:8080/api/files
```
Сервис разделен на два контейнера, т.к. это более логично, хотя и чуть сложнее в настройке.