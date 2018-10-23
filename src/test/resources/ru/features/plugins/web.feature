#language:ru
@web-plugin
Функционал: Пример использования web-plugin

  @web
  Сценарий: Пример использования web-plugin
    * пользователь находится на странице "Test Automation Gears"
    * пользователь заполняет поле "Search repositories..." "page-factory-2-example"
    * пользователь кликает по ссылке "page-factory-2-example"
    * пользователь находится на странице "Page-factory-2 example"
    * пользователь (выбирает ветку) "for-example"
    * пользователь кликает по ссылке "example.txt"
    * пользователь находится на странице "Example"
    * пользователь проверяет что в поле "Text" значение "Тестовый текст для примера"