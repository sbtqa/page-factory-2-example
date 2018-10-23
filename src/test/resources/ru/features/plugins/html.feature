#language:ru
@html-plugin
Функционал: Пример использования html-plugin

  @html
  Сценарий: Пример использования html-plugin
    * пользователь находится на странице "Test Automation Gears HTML"
    * пользователь в блоке "List of repos" (ищет репозиторий) с параметром "page-factory-2-example"
    * пользователь нажимает кнопку "page-factory-2-example"
    * пользователь находится на странице "Page-factory-2 example HTML"
    * пользователь в блоке "List of branches" (выбирает тестовую ветку)
    * пользователь нажимает кнопку "example.txt"
    * пользователь находится на странице "Example HTML"
    * пользователь проверяет что в поле "Text" значение "Тестовый текст для примера"