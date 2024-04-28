Запити:

```
POST http://localhost:8080/rental/create
Content-Type: application/json

{
"customerId": "30713ed6-20f8-49fb-99cf-390ed0532169",
"movieId": "30713ed6-20f8-49fb-99cf-390ed0532164",
"start": "2024-04-20",
"finish": "2024-04-25"
}
```
``
GET http://localhost:8080/rental/customer/statement/30713ed6-20f8-49fb-99cf-390ed0532169
``

Результат виконання createRental ![img_1.png](img_1.png)
Результат виконання getStatement![img.png](img.png)

Схема бази даних
![img_2.png](img_2.png)