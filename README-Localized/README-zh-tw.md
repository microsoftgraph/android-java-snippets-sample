# 使用 Microsoft Graph SDK 的程式碼片段範例 (適用於 Android)
**版本 1.5**

[![組建狀態](https://travis-ci.org/microsoftgraph/android-java-snippets-sample.svg?branch=master)](https://travis-ci.org/microsoftgraph/android-java-snippets-sample)

**目錄**

* [裝置需求](#device-requirement)
* [必要條件](#prerequisites)
* [Azure 用戶端應用程式註冊](#azure-client-application-registration)
* [設定專案](#configure-the-project)
* [執行專案](#run-the-project)
* [範例如何影響租用戶資料](#how-the-sample-affects-your-tenant-data)
* [了解程式碼](#understand-the-code)
* [問題與意見](#questions-and-comments)
* [其他資源](#additional-resources)
* [版本歷程記錄](#version-history)

希望建置很酷的應用程式，協助使用者使用他們的 Office 365 資料？使用這個程式碼片段範例，探索、學習並了解 Microsoft Graph SDK。這個範例會示範如何存取多個資源，包括 Microsoft Azure Active Directory 和 Office 365，方法是在 Android 應用程式中呼叫 Microsoft Graph SDK。

您可以在 Microsoft Graph 中探索下列作業：

**我**

* [取得登入使用者的相關資訊。](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L44)
* [取得使用者的責任。](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L67)
* [取得使用者的主管。](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L94)
* [取得使用者的直屬員工。](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L117)
* [取得使用者的群組成員資格](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L140)
* [取得使用者的相片。](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L164)

**使用者**

* [從您的租用戶目錄中取得使用者。](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L49)
* [從您的租用戶目錄中根據準則篩選取得使用者。](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L80)
* [建立新的使用者。](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L113)

**事件**

* [取得登入使用者的事件。](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L51)
* [為使用者建立新的事件。](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L83)
* [更新使用者的事件。](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L118)
* [刪除使用者的事件。](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L170)

**郵件**

* [取得使用者的郵件。](app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java#L51)
* [從使用者信箱傳送郵件。](app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java#L82)

**群組**

* [取得您的租用戶目錄中的所有群組。](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L184)
* [建立新的群組。](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L191)
* [取得租用戶中特定群組的相關資訊。](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L45)
* [刪除群組。](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L248)
* [取得群組的成員。](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L90)
* [取得群組的擁有者。](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L137)

**磁碟機**

* [取得登入使用者的磁碟機。](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L51)
* [取得使用者根資料夾中的所有檔案。](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L83)
* [在使用者根資料夾中建立新檔案。](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L118)
* [從使用者根資料夾中下載檔案。](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L160)
* [更新使用者根資料夾中檔案的內容。](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L223)
* [刪除使用者根資料夾中的檔案。](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L284)
* [重新命名使用者根資料夾中的檔案。](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L337)
* [在使用者根資料夾底下建立資料夾。](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L395)

## 裝置需求
若要執行程式碼片段專案，您的裝置必須符合下列需求：* Android API 層級 21 或更高層級

## Android Studio 需求
* Gradle 3.1+ 的 Android 建置工具

> **附註：** Android Studio 可能會提示您安裝 Android 支援儲存機制 47.0.0+。該專案的模組 build.gradle 檔案邏輯使用 `implementation` 方法來建置模組相依性，而不是使用較舊的 `compile` 方法來建立。這些新的建置方法取決於 Android 支援儲存機制 47.0.0 或更新版本。


### 必要條件
若要使用 Microsoft Graph SDK 程式碼片段專案，您需要下列項目：* 最新版本的 [Android Studio](http://developer.android.com/sdk/index.html)。* [Gradle](http://www.gradle.org) 建置自動化系統。* Office 365 帳戶。您可以註冊 [Office 365 Developer 訂用帳戶](https://portal.office.com/Signup/Signup.aspx?OfferId=C69E7747-2566-4897-8CBA-B998ED3BAB88&DL=DEVELOPERPACK&ali=1#0)，其中包含開始建置 Office 365 應用程式所需的資源。* [Java 開發套件 (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html)。* 具有用戶端識別碼和重新導向 URI 值的已註冊 Azure 應用程式。請參閱[授與權限給 Azure 中的程式碼片段應用程式](../../../android-java-snippets-rest-sample/wiki/Grant-permissions-for-the-Snippet-application-in-Azure)，以取得如何建立正確的權限的詳細資料。

## Azure 用戶端應用程式註冊

1. 導覽至 \[Azure 入口網站 - 應用程式註冊][](https://go.microsoft.com/fwlink/?linkid=2083908) 頁面。 
1. 選取 \[新增註冊]****。 
1. 當 \[註冊應用程式]**** 頁面出現時，輸入您應用程式的註冊資訊： 
    - 在 \[名稱]**** 區段中，輸入將對應用程式使用者顯示且有意義的應用程式名稱，例如 `Android Java 程式碼片段範例`。 
    - 在 \[支援的帳戶類型]**** 區段中，選取 \[任何組織目錄中的帳戶]****。 
1. 選取 \[註冊]**** 以建立應用程式。 
1. 在應用程式 \[概觀]**** 頁面上，找到 \[應用程式 (用戶端) 識別碼]**** 值，並將它記下供稍後使用。您需要這個值，才能設定此專案的 Visual Studio 組態檔。 
1. 在應用程式頁面清單中，選取 \[資訊清單]****，並且： 
    - 在資訊清單編輯器中，將 ``allowPublicClient`` 屬性設為 **true** 
    - 在資訊清單編輯器上方列中選取 \[儲存]****。 
1. 在應用程式頁面清單中，選取 \[API 權限]**** 
    - 按一下 \[新增權限]**** 按鈕，然後， 
    - 確定已選取 **Microsoft API** 索引標籤 
    - 在 \[常用的 Microsoft API]** 區段中，按一下 **Microsoft Graph** 
    - 在 \[委派權限]**** 區段中，確定已選取適當的權限。如有需要，請使用搜尋方塊。
    - **User.Read**、**Mail.Send**、**Mail.ReadWrite**、**Files.ReadWrite**、**User.ReadBasic.All**、**Calendars.ReadWrite**、**Group.Read.All**  
    - 選取 \[新增權限]**** 按鈕 

> **附註：** 在 \[設定專案][](#configure-the-project) 中，系統會要求您複製應用程式註冊入口網站所產生的一些字串。當您設定專案時，請務必保持在應用程式註冊頁面上。從應用程式註冊中複製的字串會貼到專案的原始程式碼。

## 設定專案

1. 下載或複製[程式碼片段範例](../../)。
2. 啟動 Android Studio。
3. 從 \[歡迎使用 Android Studio]**** 對話方塊中，選擇 \[匯入專案 (Eclipse ADT、Gradle 等等)]****。
4. 在 **android-java-snippets-sample** 資料夾中選取 **settings.gradle** 檔案，然後按一下 \[確定]****。
5. 回應對話方塊 ("Gradle Sync:此專案的 Gradle 設定尚未設定。您希望專案使用 Gradle 包裝函式嗎？")，按一下 \[確定]**** 按鈕即可使用 Gradle 包裝函式。 
4. 在您剛剛瀏覽的應用程式註冊頁面上，複製自訂重新導向 URI (`msal{application id as GUID}`) 到剪貼簿。**請確定您沒有複製 `://auth`**
   <br/>例如：複製 `msal0575d7fe-8ec7-4925-9ce2-87074778a039`，但略過 `://auth`。
4. 將剪貼簿內容貼在 **app/src/main/AndroidManifest.xml** 的 41 行，以剪貼簿內容取代 `ENTER_YOUR_CLIENT_ID`。
4. 將自訂重新導向 URI 的 **GUID 部分**複製到 **app/src/main/AndroidManifest.xml** 的 49 行，以剪貼簿內容取代 `ENTER_YOUR_CLIENT_ID`。

## 執行專案
建置專案之後，您可以在模擬器或裝置上執行它。

1. 執行專案。
2. 按一下 \[連接至 Microsoft Graph]**** 按鈕以登入。
3. 輸入您的認證。
4. 檢閱並接受應用程式要求的權限範圍。
4. 按一下主要活動的作業，以顯示作業詳細資料。
5. 按一下 \[執行]**** 按鈕來啟動作業，並等候該作業完成。
6. 按一下 \[原始物件]**** 文字方塊，將方塊內容複製到模擬器/裝置剪貼簿。
7. 按一下工具列上的返回按鈕以返回作業清單。
8. (選擇性) 按一下溢位功能表以取得中斷連線功能表選項。

## 範例如何影響租用戶資料
這個範例會執行命令，該命令會建立、讀取、更新或刪除資料。當執行刪除或編輯資料的命令時，範例會建立假的實體。假的實體已被刪除或編輯，您的實際租用戶資料不會受到影響。這個範例會在您的租用戶上留下假的實體。

## 瞭解程式碼
程式碼片段專案會使用這些類別來管理與 Microsoft Graph 之間的互動︰

### 範例專案組織
程式碼片段專案是由兩個模組所組成。模組化的設計可讓您根據此範例建置新的應用程式，方法是將模組匯入您的應用程式。匯入模組之後，使用程式碼片段[應用程式](/app)模組中的程式碼，做為如何在其他的範例模組中呼叫方法的範例。

### 程式碼片段專案中的模組
* [`應用程式`](/app)。UI 和商務邏輯模組。SDK 作業是在此模組中的程式碼片段類別啟動。

### 程式碼片段類別
程式碼片段會執行單一作業，並傳回結果。程式碼片段位於[應用程式](/app)模組。程式碼片段會設定必要的狀態，以在如下所述的 Microsoft Graph 服務類別上進行呼叫。* [`AbstractSnippet`](/app/src/main/java/com/microsoft/graph/snippets/snippet/AbstractSnippet.java) * [`DrivesSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java) * [`EventsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java) * [`GroupsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java) * [`MeSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java) * [`MessageSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java) * [`UsersSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java)

### 驗證類別
驗證方法可在 [`AuthenticationManager`](/app/src/main/java/com/microsoft/graph/snippets/AuthenticationManager.java) 類別中找到。這些方法會使用 [Microsoft Authentication Library (MSAL) for Android](https://github.com/AzureAD/microsoft-authentication-library-for-android) 連線到 Microsoft Graph。 

* [`AuthenticationManager`](/app/src/main/java/com/microsoft/graph/snippets/AuthenticationManager.java)。除了應用程式授權之外，封裝使用者連線和中斷連線邏輯。
 
<a name="contributing"></a>
## 參與 ##

如果您想要參與這個範例，請參閱 [CONTRIBUTING.MD](/CONTRIBUTING.md)。

此專案已採用 [Microsoft 開放原始碼管理辦法](https://opensource.microsoft.com/codeofconduct/)。如需詳細資訊，請參閱[管理辦法常見問題集](https://opensource.microsoft.com/codeofconduct/faq/)，如果有其他問題或意見，請連絡 [opencode@microsoft.com](mailto:opencode@microsoft.com)。

## 問題與意見
我們很樂於收到您對於適用於 Android Microsoft Graph SDK 程式碼片段範例的意見反應。您可以在此儲存機制的 \[問題][](../../issues) 區段中，將您的意見反應傳送給我們。<br/>
請在 [Stack Overflow](http://stackoverflow.com/questions/tagged/microsoftgraph) 提出有關 Microsoft Graph 開發的一般問題。務必以 \[microsoftgraph] 標記您的問題。

## 其他資源

* [開始使用 Microsoft Graph 提供的 Office 365 API](http://dev.office.com/getting-started/office365apis)
* [Microsoft Graph 概觀](http://graph.microsoft.io)
* [Microsoft Graph SDK for Android](../../../msgraph-sdk-android)
* [使用 Microsoft Graph SDK 的 Connect 範例 (適用於 Android)](../../../android-java-connect-sample)

## 版本歷程記錄

|版本|變更|
|:---|:----|
|1.0|初始版本|
|1.5|- MSAL 驗證文件庫取代 ADAL 驗證文件庫 <br/> \- Microsoft Graph SDK 1.5 版|

Copyright (c) 2019 Microsoft.著作權所有，並保留一切權利。
