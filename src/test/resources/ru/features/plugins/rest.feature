#language:ru
@rest-plugin
Функционал: Тестирование api-сервисов с помощью rest-plugin

  @rest-usual
  Сценарий: Обычная отправка запроса и проверка ответа
    * пользователь отправляет запрос "get description of repo"
    * система возвращает ответ "description"

  @rest-usual-with-params
  Сценарий: Обычная отправка запроса и проверка ответа с параметрами
    * пользователь отправляет запрос "get description of repo with params" с параметрами
      | repo | page-factory-2 |
    * система возвращает "description" с параметрами
      | description | New version of the page-factory framework |

  @rest-fill-from-feature
  Сценарий: Заполнение запроса из фичи и отправка, проверка ответа
    * пользователь заполняет запрос "search repo"
    * пользователь добавляет query параметр с именем "q" и значением "sbtqa/page-factory"
    * пользователь добавляет query параметры
      | sort  | stars |
      | order | asc   |
    * пользователь отправляет запрос
    * пользователь проверяет ответ

  @rest-fill-from-feature-use-other-response
  Сценарий: Заполнение запроса из фичи, когда нужно взять значения из предыдущих запросов, отправка, проверка ответа
    * пользователь отправляет запрос "search this repo on github"
    * пользователь заполняет запрос "search this repo on github через поиск"
    * пользователь добавляет query параметр "q" из ответа на запрос "search this repo on github" путь "full_name" маска "(.*)-example"
    * пользователь отправляет запрос
    * пользователь проверяет ответ