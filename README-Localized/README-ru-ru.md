# Пример фрагментов кода для Android, использующих пакет SDK Microsoft Graph
**Версия 1.5**

[![Состояние сборки](https://travis-ci.org/microsoftgraph/android-java-snippets-sample.svg?branch=master)](https://travis-ci.org/microsoftgraph/android-java-snippets-sample)

**Содержание**

* [Требование к устройству](#device-requirement)
* [Предварительные требования](#prerequisites)
* [Регистрация приложения в клиенте Azure](#azure-client-application-registration)
* [Настройка проекта](#configure-the-project)
* [Запуск проекта](#run-the-project)
* [Влияние примера на данные клиента](#how-the-sample-affects-your-tenant-data)
* [Разбор кода](#understand-the-code)
* [Вопросы и комментарии](#questions-and-comments)
* [Дополнительные ресурсы](#additional-resources)
* [Журнал версий](#version-history)

Хотите создавать классные приложения, облегчающие пользователям работу с данными Office 365? Подробно изучите пакет SDK Microsoft Graph с помощью этого примера фрагментов кода. В этом примере показано, как получить доступ к нескольким ресурсам, в том числе Microsoft Azure Active Directory и Office 365, совершая вызовы в пакет SDK Microsoft Graph в приложении Android.

В Microsoft Graph можно изучить перечисленные ниже операции.

**Я**

* [Получение сведений о пользователе, который вошел в систему.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L44)
* [Получение сведений об обязанностях пользователя.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L67)
* [Получение сведений о руководителе пользователя.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L94)
* [Получение сведений о подчиненных пользователя.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L117)
* [Получение сведений об участии пользователя в группах.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L140)
* [Получение фотографии пользователя.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L164)

**Пользователи**

* [Получение пользователей из каталога клиента.](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L49)
* [Получение пользователей, отфильтрованных по критериям, из каталога клиента.](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L80)
* [Создание пользователя.](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L113)

**События**

* [Получение событий пользователя, который вошел в систему.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L51)
* [Создание события для пользователя.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L83)
* [Обновление события пользователя.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L118)
* [Удаление события пользователя.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L170)

**Сообщения**

* [Получение сообщений пользователя.](app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java#L51)
* [Отправка сообщения из почтового ящика пользователя.](app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java#L82)

**Группы**

* [Получение всех групп в каталоге клиента.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L184)
* [Создание группы.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L191)
* [Получение сведений об определенной группе клиента.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L45)
* [Удаление группы.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L248)
* [Получение участников группы.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L90)
* [Получение владельцев группы.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L137)

**Диски**

* [Получение диска пользователя, который вошел в систему.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L51)
* [Получение всех файлов в корневой папке пользователя.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L83)
* [Создание файла в корневой папке пользователя.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L118)
* [Скачивание файла из корневой папки пользователя.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L160)
* [Обновление содержимого файла в корневой папке пользователя.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L223)
* [Удаление файла из корневой папки пользователя.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L284)
* [Переименование файла в корневой папке пользователя.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L337)
* [Создание папки в корневой папке пользователя.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L395)

## Требования к устройству
Для выполнения проекта фрагментов кода устройство должно соответствовать следующему требованию: * API Android уровня 21 или более высокого

## Требования к Android Studio
* Инструменты сборки Android для Gradle 3.1 или более поздней версии

> **Примечание.** Android Studio может предложить установить репозиторий поддержки Android 47.0.0 или более поздней версии. Для создания зависимостей модуля в логике файла build.gradle модуля проекта вместо более раннего метода `compile` используется метод `implementation`. Эти новые методы сборки зависят от репозитория поддержки Android версии 47.0.0 или более поздней.


### Предварительные требования
Чтобы использовать проект фрагментов кода для пакета SDK Microsoft Graph, вам потребуются перечисленные ниже компоненты. * Последняя версия [Android Studio](http://developer.android.com/sdk/index.html). * Система автоматизации сборки [Gradle](http://www.gradle.org). * Учетная запись Office 365. Вы можете [подписаться на план Office 365 для разработчиков](https://portal.office.com/Signup/Signup.aspx?OfferId=C69E7747-2566-4897-8CBA-B998ED3BAB88&DL=DEVELOPERPACK&ali=1#0), который включает ресурсы, необходимые для создания приложений Office 365\. * [Java Development Kit (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html). * Зарегистрированное приложение Azure с идентификатором клиента и значением универсального кода ресурса (URI) перенаправления. Чтобы узнать, как создать правильные разрешения, см. статью [Предоставление разрешений приложению Snippets в Azure](../../../android-java-snippets-rest-sample/wiki/Grant-permissions-for-the-Snippet-application-in-Azure).

## Регистрация приложения в клиенте Azure

1. Перейдите на страницу [регистрации приложений портала Azure](https://go.microsoft.com/fwlink/?linkid=2083908). 
1. Выберите **Новая регистрация**. 
1. После появления страницы **Регистрация приложения** введите сведения для регистрации приложения: 
    - В разделе **Имя** введите понятное имя приложения, которое будет отображаться пользователям приложения, например `Пример фрагментов кода Java для Android`. 
    - В разделе **Поддерживаемые типы учетных записей** выберите **Учетные записи в любом каталоге организации**. 
1. Выберите **Зарегистрировать**, чтобы создать приложение. 
1. На странице **Обзор** приложения найдите значение **Идентификатор приложения (клиент)** и запишите его для последующего использования. Для этого проекта вам потребуется настроить файл конфигурации Visual Studio. 
1. В списке страниц приложения выберите **Манифест** и: 
    - В редакторе манифеста присвойте свойству ``allowPublicClient`` значение **true**. 
    - Нажмите **Сохранить** в панели над редактором манифеста. 
1. В списке страниц приложения выберите **Разрешения API** 
    - Нажмите кнопку **Добавить разрешение** и 
    - Убедитесь, что выбрана вкладка **Интерфейсы API Microsoft** 
    - В разделе *Часто используемые интерфейсы API Microsoft* щелкните **Microsoft Graph** 
    - Убедитесь, что в разделе **Делегированные разрешения** выбраны правильные разрешения. При необходимости используйте поле поиска.
    - **User.Read**, **Mail.Send**, **Mail.ReadWrite**, **Files.ReadWrite**, **User.ReadBasic.All**, **Calendars.ReadWrite**, **Group.Read.All**  
    - Нажмите кнопку **Добавить разрешения** 

> **Примечание.** В разделе [Настройка проекта](#configure-the-project) вам потребуется скопировать отдельные строки, созданные порталом регистрации приложений. Не покидайте страницу регистрации приложения, пока настраиваете проект. Скопированные при регистрации приложения строки будут добавлены в исходный код проекта.

## Настройка проекта

1. Скачайте или клонируйте [пример фрагментов кода](../../).
2. Запустите Android Studio.
3. В диалоговом окне **Добро пожаловать в Android Studio** выберите пункт **Импорт проекта (Eclipse ADT, Gradle и т. д.)**.
4. Выберите файл **settings.gradle** в папке **android-java-snippets-sample** и нажмите кнопку **OK**.
5. Ответьте на запрос в диалоговом окне ("Синхронизация Gradle: параметры Gradle для этого проекта еще не настроены. Использовать в проекте программу-оболочку Gradle?"), нажав кнопку **OK**, чтобы использовать программу-оболочку Gradle. 
4. На странице регистрации приложений, которую вы только что открыли, скопируйте в буфер обмена пользовательский URI перенаправления (`msal{application id as GUID}`). **Не копируйте часть `://auth`**
   <br/>Например: скопируйте `msal0575d7fe-8ec7-4925-9ce2-87074778a039` без части `://auth`.
4. Вставьте скопированные данные из буфера обмена в строку 41 файла **app/src/main/AndroidManifest.xml**, заменив `ENTER_YOUR_CLIENT_ID`.
4. Скопируйте часть пользовательского URI перенаправления с **кодом GUID** и вставьте в строку 49 файла **app/src/main/AndroidManifest.xml**, заменив `ENTER_YOUR_CLIENT_ID`.

## Запуск проекта
После сборки проект можно запустить в эмуляторе или на устройстве.

1. Запустите проект.
2. Для входа нажмите кнопку **Подключить к Microsoft Graph**.
3. Введите учетные данные.
4. Просмотрите и примите области разрешений, запрашиваемых приложением.
4. Щелкните операцию в пределах основного действия, чтобы отобразить сведения о ней.
5. Нажмите кнопку **ВЫПОЛНИТЬ**, чтобы начать операцию, и дождитесь ее завершения.
6. Щелкните в текстовом поле **Необработанный объект**, чтобы скопировать содержимое поля в буфер обмена эмулятора или устройства.
7. Нажмите кнопку "Назад" на панели инструментов, чтобы вернуться к списку операций.
8. (Необязательно.) Выберите меню переполнения, чтобы открыть параметр меню "Отключить".

## Влияние примера на данные клиента
В этом примере выполняются команды по созданию, чтению, обновлению и удалению данных. При выполнении команд по удалению или изменению данных пример создает фиктивные сущности. Фиктивные сущности удаляются или изменяются, не затрагивая фактические данные клиента. Пример проигнорирует фиктивные сущности в клиенте.

## Разбор кода
В проекте фрагментов кода для управления взаимодействием с Microsoft Graph используются приведенные ниже классы.

### Пример организации проекта
Проект приложения фрагментов кода состоит из двух модулей. Модульная структура позволяет создать приложение на основе этого примера путем импорта модулей в приложение. После импорта модулей используйте код в модуле [app](/app) фрагментов кода в качестве примера, как вызывать методы в другие примеры модулей.

### Модули в проекте приложения фрагментов кода
* [`app`](/app). Пользовательский интерфейс и модуль бизнес-логики. Операции пакета SDK запускаются в классах фрагментов кода в этом модуле.

### Классы фрагментов кода
Фрагмент кода выполняет одну операцию и возвращает результаты. Фрагменты кода находятся в модуле [app](/app). Фрагменты кода задают состояние, необходимое для вызова описанных ниже классов службы Microsoft Graph.
* [`AbstractSnippet`](/app/src/main/java/com/microsoft/graph/snippets/snippet/AbstractSnippet.java)
* [`DrivesSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java)
* [`EventsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java)
* [`GroupsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java)
* [`MeSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java)
* [`MessageSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java)
* [`UsersSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java)

### Классы проверки подлинности
Методы проверки подлинности можно найти в классе [`AuthenticationManager`](/app/src/main/java/com/microsoft/graph/snippets/AuthenticationManager.java). Эти методы используют библиотеку [Microsoft Authentication Library (MSAL) для Android](https://github.com/AzureAD/microsoft-authentication-library-for-android) для подключения к Microsoft Graph. 

* [`AuthenticationManager`](/app/src/main/java/com/microsoft/graph/snippets/AuthenticationManager.java). Содержит логику подключения и отключения пользователей в дополнение к авторизации приложения.
 
<a name="contributing"></a>
## Участие ##

Если вы хотите добавить код в этот пример, просмотрите статью [CONTRIBUTING.MD](/CONTRIBUTING.md).

Этот проект соответствует [правилам поведения Майкрософт, касающимся обращения с открытым кодом](https://opensource.microsoft.com/codeofconduct/). Дополнительные сведения см. в разделе [вопросов и ответов о правилах поведения](https://opensource.microsoft.com/codeofconduct/faq/). Если у вас возникли вопросы или замечания, напишите нам по адресу [opencode@microsoft.com](mailto:opencode@microsoft.com).

## Вопросы и комментарии
Мы будем рады получить ваши отзывы о примере фрагментов кода для пакета SDK Microsoft Graph для Android. Своими мыслями можете поделиться на вкладке [Issues](../../issues) (Проблемы) этого репозитория. <br/>
Общие вопросы относительно разработки решений для Microsoft Graph следует задавать на сайте [Stack Overflow](http://stackoverflow.com/questions/tagged/microsoftgraph). Помечайте свои вопросы тегами \[microsoftgraph].

## Дополнительные ресурсы

* [Начало работы с интерфейсами API Office 365 на платформе Microsoft Graph](http://dev.office.com/getting-started/office365apis)
* [Общие сведения о Microsoft Graph](http://graph.microsoft.io)
* [Пакет SDK Microsoft Graph для Android](../../../msgraph-sdk-android)
* [Приложение Connect для Android, использующее Microsoft Graph SDK](../../../android-java-connect-sample)

## Журнал версий

|Версия|Изменения|
|:---|:----|
|1.0|Исходный выпуск|
|1.5|- Библиотека проверки подлинности MSAL заменяет библиотеку проверки подлинности ADAL <br/> - Пакет SDK Microsoft Graph версии 1.5|

(c) Корпорация Майкрософт (Microsoft Corporation), 2019. Все права защищены.
