
Запуск проекта: 
* docker build  -t money-transfer:1.0 .
* docker run --name money-transfer-container -p 5500:5500 money-transfer:1.0

Проект запускается на порту 5500

Примеры запросов: 
* POST /transfer - осуществление перевода
* POST /confirmOperation - подтверждение перевода
* GET /logs - просмотреть логи запросов