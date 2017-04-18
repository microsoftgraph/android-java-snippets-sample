# <a name="snippets-sample-for-android-using-the-microsoft-graph-sdk"></a>Пример фрагментов кода для Android, использующих пакет SDK Microsoft Graph

[![Состояние сборки](https://travis-ci.org/microsoftgraph/android-java-snippets-sample.svg?branch=master)](https://travis-ci.org/microsoftgraph/android-java-snippets-sample)

**Содержание**

* [Требование к устройству](#device-requirement)
* [Необходимые компоненты](#prerequisites)
* [Регистрация клиентского приложения в Azure](#azure-client-application-registration)
* [Настройка проекта](#configure-the-project)
* [Запуск проекта](#run-the-project)
* [Влияние примера на данные клиента](#how-the-sample-affects-your-tenant-data)
* [Разбор кода](#understand-the-code)
* [Вопросы и комментарии](#questions-and-comments)
* [Дополнительные ресурсы](#additional-resources)

Хотите создавать классные приложения, облегчающие пользователям работу с данными Office 365? Подробно изучите пакет SDK Microsoft Graph с помощью этого примера фрагментов кода. В этом примере показано, как получить доступ к нескольким ресурсам, в том числе Microsoft Azure Active Directory и Office 365, совершая вызовы в пакет SDK Microsoft Graph в приложении Android.

В Microsoft Graph можно изучить перечисленные ниже операции.

**Пользователь**

* [Получение сведений о пользователе, который вошел в систему.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L44)
* [Получение сведений об обязанностях пользователя.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L67)
* [Получение сведений о руководителе пользователя.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L94)
* [Получение сведений о подчиненных пользователя.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L117)
* [Получение сведений о членстве пользователя в группах.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L140)
* [Получение фотографии пользователя.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L164)

**Пользователи**

* [Получение списка пользователей из каталога клиента.](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L49)
* [Получение списка пользователей, отфильтрованных по критериям, из каталога клиента.](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L80)
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
* [Получение списка членов группы.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L90)
* [Получение сведений о владельцах группы.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L137)

**Диски**

* [Получение диска пользователя, который вошел в систему.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L51)
* [Получение всех файлов в корневой папке пользователя.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L83)
* [Создание файла в корневой папке пользователя.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L118)
* [Скачивание файла из корневой папки пользователя.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L160)
* [Обновление содержимого файла в корневой папке пользователя.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L223)
* [Удаление файла в корневой папке пользователя.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L284)
* [Переименование файла в корневой папке пользователя.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L337)
* [Создание папки в корневой папке пользователя.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L395)

##<a name="device-requirement"></a>Требование к устройству
Для выполнения проекта фрагментов кода устройство должно соответствовать следующему требованию:
* API Android уровня 16 или более высокого

###<a name="prerequisites"></a>Необходимые компоненты
Чтобы использовать проект фрагментов кода для пакета SDK Microsoft Graph, вам потребуются перечисленные ниже компоненты.
* Последняя версия [Android Studio](http://developer.android.com/sdk/index.html).
* Система автоматизации сборки [Gradle](http://www.gradle.org).
* Учетная запись Office 365. Вы можете [подписаться на план Office 365 для разработчиков](https://portal.office.com/Signup/Signup.aspx?OfferId=C69E7747-2566-4897-8CBA-B998ED3BAB88&DL=DEVELOPERPACK&ali=1#0), который включает ресурсы, необходимые для создания приложений Office 365.
* [Java Development Kit (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html).
* Зарегистрированное приложение Azure с идентификатором клиента и значением универсального кода ресурса (URI) перенаправления. Чтобы узнать, как создать правильные разрешения, см. статью [Предоставление разрешений приложению Snippets в Azure](../../../android-java-snippets-rest-sample/wiki/Grant-permissions-for-the-Snippet-application-in-Azure).

##<a name="azure-client-application-registration"></a>Регистрация приложения в клиенте Azure
1. Войдите на [портал управления Azure](https://manage.windowsazure.com) с помощью учетных данных Azure AD.
2.    Щелкните **Active Directory** в левом меню, а затем выберите каталог для клиента Office 365.
3.    В верхнем меню щелкните **Приложения**.
4.    Нажмите кнопку **Добавить** в нижнем меню.
5.    На странице **Что вы хотите сделать?** щелкните **Добавить приложение, разрабатываемое моей организацией**.
6.    На странице **Расскажите о своем приложении** укажите имя приложения **Android Snippet Sample** и выберите тип **СОБСТВЕННОЕ КЛИЕНТСКОЕ ПРИЛОЖЕНИЕ**.
7.    Щелкните кнопку со стрелкой в правом нижнем углу страницы.
8.    На странице **Сведения о приложении** укажите **универсальный код ресурса (URI) перенаправления** (например, `http://localhost/androidsnippets`), а затем установите флажок в правом нижнем углу страницы.
9.    После успешного добавления приложения откроется страница **Быстрый запуск**. Здесь выберите пункт **Настройка** в верхнем меню.
10. В разделе разрешений для других приложений добавьте приложение Microsoft Graph.
11. Добавьте перечисленные ниже разрешения для приложения Microsoft Graph.
   * Вход и чтение профиля пользователя
   * Полный доступ ко всем файлам, к которым может получать доступ пользователь
   * Полный доступ к календарям пользователя
   * Чтение и запись почты пользователя 
   * Отправка почты от имени пользователя
   * Чтение почты пользователя
   * Чтение и запись данных каталога
   * Чтение базовых профилей всех пользователей
   * Чтение и запись всех групп
13. В нижнем меню нажмите кнопку **Сохранить**.
14. Обратите внимание на значения, указанные для **идентификатора клиента** на странице **Настройка**. Они потребуются позже для настройки проекта.

##<a name="configure-the-project"></a>Настройка проекта

1. Скачайте или клонируйте [пример фрагментов кода](../../).
2. Запустите Android Studio.
3. В диалоговом окне **Добро пожаловать в Android Studio** выберите пункт **Импорт проекта (Eclipse ADT, Gradle и т. д.)**.
4. Выберите файл **settings.gradle** в папке **android-java-snippets-sample**, а затем нажмите кнопку **OK**.
5. Ответьте на запрос в диалоговом окне ("Синхронизация Gradle: параметры Gradle для этого проекта еще не настроены. Использовать в проекте программу оболочку Gradle?"), нажав кнопку **ОК**, чтобы использовать программу-оболочку Gradle. 
6. Откройте файл ServiceConstants.java в пакете com.microsoft.graph.snippets.
7. Найдите строку [`CLIENT_ID`](app/src/main/java/com/microsoft/graph/snippets/ServiceConstants.java#L11), а затем в качестве ее значения задайте идентификатор клиента, зарегистрированный в Azure.
8. Найдите строку [`REDIRECT_URI`](app/src/main/java/com/microsoft/graph/snippets/ServiceConstants.java#L10), а затем в качестве ее значения задайте универсальный код ресурса (URI) перенаправления, зарегистрированный в Azure.

##<a name="run-the-project"></a>Запуск проекта
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

##<a name="how-the-sample-affects-your-tenant-data"></a>Влияние примера на данные клиента
В этом примере выполняются команды по созданию, чтению, обновлению и удалению данных. При выполнении команд по удалению или изменению данных пример создает фиктивные сущности. Фиктивные сущности удаляются или изменяются, не затрагивая фактические данные клиента. Пример проигнорирует фиктивные сущности в клиенте.

##<a name="understand-the-code"></a>Разбор кода
В проекте фрагментов кода для управления взаимодействием с Microsoft Graph используются приведенные ниже классы.

###<a name="sample-project-organization"></a>Пример организации проекта
Проект приложения фрагментов кода состоит из двух модулей. Модульная структура позволяет создать приложение на основе этого примера путем импорта модулей в приложение. После импорта модулей используйте код в модуле [app](/app) фрагментов кода в качестве примера того, как вызывать методы в другие примеры модулей.

###<a name="modules-in-the-snippets-project"></a>Модули в проекте приложения фрагментов кода
* [`o365-Auth`](/o365-auth). Этот модуль содержит вызовы библиотеки для проверки подлинности пользователя с помощью Microsoft Graph.
* [`app`](/app). Пользовательский интерфейс и модуль бизнес-логики. Операции пакета SDK запускаются в классах фрагментов кода в этом модуле.

###<a name="snippet-classes"></a>Классы фрагментов кода
Фрагмент кода выполняет одну операцию и возвращает результаты. Фрагменты кода находятся в модуле [app](/app). Фрагменты кода задают состояние, необходимое для вызова описанных ниже классов службы Microsoft Graph.
* [`AbstractSnippet`](/app/src/main/java/com/microsoft/graph/snippets/snippet/AbstractSnippet.java)
* [`DrivesSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java)
* [`EventsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java)
* [`GroupsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java)
* [`MeSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java)
* [`MessageSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java)
* [`UsersSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java)

###<a name="authentication-classes"></a>Классы проверки подлинности
Классы проверки подлинности находятся в модуле [o365-Auth](/o365-auth). В этих классах для подключения к Microsoft Graph используется [библиотека Microsoft Azure Active Directory Library (ADAL) для Android](https://github.com/AzureAD/azure-activedirectory-library-for-android). 

* [`AuthenticationManager`](/o365-auth/src/main/java/com/microsoft/graph/auth/AuthenticationManager.java). Содержит логику подключения и отключения пользователей в дополнение к авторизации приложения Azure.
* [`AzureADModule`](/o365-auth/src/main/java/com/microsoft/graph/auth/AzureADModule.java). Вспомогательный класс проверки подлинности. 
* [`AzureAppCompatActivity`](/o365-auth/src/main/java/com/microsoft/graph/auth/AzureAppCompatActivity.java). Вспомогательное приложения для внедрения зависимостей.
 
<a name="contributing"></a>
## <a name="contributing"></a>Участие ##

Если вы хотите добавить код в этот пример, просмотрите статью [CONTRIBUTING.MD](/CONTRIBUTING.md).

Этот проект соответствует [правилам поведения Майкрософт, касающимся обращения с открытым кодом](https://opensource.microsoft.com/codeofconduct/). Читайте дополнительные сведения в [разделе вопросов и ответов по правилам поведения](https://opensource.microsoft.com/codeofconduct/faq/) или отправляйте новые вопросы и замечания по адресу [opencode@microsoft.com](mailto:opencode@microsoft.com).

## <a name="questions-and-comments"></a>Вопросы и комментарии
Мы будем рады получить ваши отзывы о примере фрагментов кода для пакета SDK Microsoft Graph для Android. Своими мыслями можете поделиться на вкладке [Issues](../../issues) (Проблемы) этого репозитория. <br/> Общие вопросы относительно разработки решений для Microsoft Graph следует задавать на сайте [Stack Overflow](http://stackoverflow.com/questions/tagged/microsoftgraph). Помечайте свои вопросы тегами [microsoftgraph].

## <a name="additional-resources"></a>Дополнительные ресурсы

* [Начало работы с интерфейсами API Office 365 на платформе Microsoft Graph](http://dev.office.com/getting-started/office365apis)
* [Общие сведения о Microsoft Graph](http://graph.microsoft.io)
* [Пакет SDK Microsoft Graph для Android](../../../msgraph-sdk-android)
* [Приложение Connect для Android, использующее Microsoft Graph SDK](../../../android-java-connect-sample)

(c) Корпорация Майкрософт (Microsoft Corporation), 2015. Все права защищены.
