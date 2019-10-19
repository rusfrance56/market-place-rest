# market-place-rest
рест ядро магазина. 


Недоработки, которые хотелось бы устранить, но лень:

1. Можно было разбить всё это дело на микро сервисы. К примеру, отдельно сервер безопасности, отдельно crud-репозиторий с бизнес логикой.
2. Вместо Rest api, можно использовать GraphQL. Или как-то их совместить. 
3. Почему-то я не использовал dto/pojo классы для представления данных. Решил всё делать в сущностях Jpa,
думаю это небезопасно, да и неудобно.
4. Я попрежнему считаю, что в больших проектах очень странно использовать голые sql запросы, особенно автогенерируемые спрингом/хибернейтом,так-как намного сложнее отлаживать взаимодействие приложения и бд. А найти проблему в случае возникновения ошиюки становится сильно сложнее. Не решена проблема n+1 запросов.
5. jpa сущности должны быть всё-таки без геттеров и сеттеров. В них не должно быть намешано ничего постароннего (джексон, использовался как dto/pojo объект).
6. Интеграционные тесты лучше проводить не с помощью Junit. В этом проекте было решено использовать junit с синхронным вызовом помеченных аннотацией методовю.
7. Для данного проекта не самая лучшая идея в принципе использовать jwt токены. В качестве альтернативы можно было использовать аутентификацию по сертификатам.
8. Возможно не лучший плагин был выбран для исключения модульных тестов из фазы сборки проекта. Возможно не лучшая идея была модульные тесты из проекта отключать. Но это можно регулировать добавлением новых фаз и профилей. Плагин surefire подпортил ситуацию с курилицей в проекте.
9. Планировалось добавить MongoDB или какую-нибудь другую noSql бд для хранения изображений товаров, но зачем? Слишком много гемора.
10. Тема работы со временем не раскрыта. Хотелось хранить время в uts-0 в юникс-тайме, без всяких свистоперделок. Неопределился, так наверно тоже нормально.
11. Встроенная бд может забивать оперативную память и процессорное время. Иногда во время разработки можно заметить огромное количество процессов postgresql и ахнуть.
