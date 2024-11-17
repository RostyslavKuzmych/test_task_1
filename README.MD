# Amazon Sales and Traffic Analytics API

## Опис проекту

Цей проект — RESTful API, розроблений за допомогою Spring Boot, який забезпечує роботу зі статистикою продажів та трафіку Amazon, зберігаючи та оновлюючи дані в базі MongoDB. API також кешує відповіді на часті запити для оптимізації швидкості доступу. Основна функціональність включає можливість фільтрації даних за датами або за конкретними ASIN, а також періодичне оновлення інформації з файлу `test_report.json`.

### Технології
- **Spring Boot**
- **MongoDB** для зберігання статистики
- **Spring Security** з підтримкою JWT токенів для авторизації
- **Redis** для кешування даних та оптимізації відповіді
- **Swagger** для документування API, доступний на `/swagger-ui.html`

---

## Деталі

1. **Оновлення бази даних:**
    - Дані в базі MongoDB оновлюються автоматично кожні **30 хвилин** із файлу `test_report.json`.
    - Це забезпечує актуальність статистики та автоматизацію процесу оновлення.

2. **Кешування:**
    - Відповіді на часті запити кешуються в Redis на **5 хвилин**.
    - Після закінчення часу кеш оновлюється, гарантуючи актуальність інформації для клієнтів.

3. **Робота кешу:**
    - Після кожного оновлення бази даних кеш очищується та перевизначається для відповідності новим даним.
    - Це дозволяє уникнути розбіжностей між базою даних і кешованими значеннями.

## Вимоги до проекту

1. **База даних:** MongoDB
2. **Авторизація:** Spring Security (JWT для безпеки)
3. **Кешування:** Redis
4. **Файл початкових даних:** `test_report.json` — використовується для ініціалізації бази даних і періодичного оновлення статистики.
5. **Документація:** Swagger для перегляду та тестування ендпоінтів (після запуску проекту).

### Основні функції

1. Реєстрація нового користувача.
2. Авторизація користувача для отримання JWT токену.
3. Виведення статистики по вказаній даті або за проміжком дат (із кешуванням відповіді).
4. Виведення статистики по вказаному ASIN або списку ASINs (із кешуванням).
5. Виведення сумарної статистики по всім датам (із кешуванням).
6. Виведення сумарної статистики по всім ASINs (із кешуванням).
7. Оновлення всієї статистики через певні проміжки часу з файлу `test_report.json`.

> ⚠️ *Всі функції, окрім реєстрації та авторизації, доступні тільки для авторизованих користувачів.*

---