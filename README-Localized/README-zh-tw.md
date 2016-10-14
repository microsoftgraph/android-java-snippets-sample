# 使用 Microsoft Graph SDK 的程式碼片段範例 (適用於 Android)

[![B組建狀態](https://travis-ci.org/microsoftgraph/android-java-snippets-sample.svg?branch=master)](https://travis-ci.org/microsoftgraph/android-java-snippets-sample)

**目錄**

* [裝置需求](#裝置需求)
* [必要條件](#必要條件)
* [Azure 用戶端應用程式註冊](#azure-用戶端應用程式註冊)
* [設定專案](#設定專案)
* [執行專案](#執行專案)
* [範例如何影響租用戶資料](#範例如何影響租用戶資料)
* [瞭解程式碼](#瞭解程式碼)
* [問題和建議](#問題和建議)
* [其他資源](#其他資源)

希望建置很酷的應用程式，協助使用者使用他們的 Office 365 資料？ 使用這個程式碼片段範例，探索、學習並了解 Microsoft Graph SDK。 這個範例會示範如何存取多個資源，包括 Microsoft Azure Active Directory 和 Office 365，方法是在 Android 應用程式中呼叫 Microsoft Graph SDK。

您可以在 Microsoft Graph 中探索下列作業︰

**我**

* [取得登入使用者的相關資訊。](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L44)
* [取得使用者的責任。](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L67)
* [取得使用者的管理員。](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L94)
* [取得使用者的直屬員工。](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L117)
* [取得使用者的群組成員資格](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L140)
* [取得使用者的相片。](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L164)

**使用者**

* [從您的租用戶目錄中取得使用者。](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L49)
* [從您的租用戶目錄中根據準則篩選使用者。](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L80)
* [建立新的使用者。](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L113)

**事件**

* [取得登入使用者的事件。](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L51)
* [為使用者建立新的事件。](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L83)
* [更新使用者的事件。](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L118)
* [刪除使用者的事件。](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L170)

**訊息**

* [取得使用者的訊息。](app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java#L51)
* [從使用者信箱傳送訊息。](app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java#L82)

**群組**

* [從您的租用戶目錄中取得所有群組。](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L184)
* [建立新的群組。](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L214)
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

##裝置需求
若要執行程式碼片段專案，您的裝置必須符合下列需求：
* Android API 層級 16 或更高層級

###必要條件
若要使用 Microsoft Graph SDK 程式碼片段專案，您需要下列項目︰
* 最新版本的 [Android Studio](http://developer.android.com/sdk/index.html)。
* [Gradle](http://www.gradle.org) 建置自動化系統。
* Office 365 帳戶。 您可以註冊 [Office 365 開發人員訂用帳戶](https://portal.office.com/Signup/Signup.aspx?OfferId=C69E7747-2566-4897-8CBA-B998ED3BAB88&DL=DEVELOPERPACK&ali=1#0)，其中包含開始建置 Office 365 應用程式所需的資源。
* [JAVA 開發套件 (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html)。
* 註冊的 Azure 應用程式，具有用戶端識別碼和重新導向 URI 值。 請參閱[授與權限給 Azure 中的程式碼片段應用程式](../../../android-java-snippets-rest-sample/wiki/Grant-permissions-for-the-Snippet-application-in-Azure)，以取得如何建立正確的權限的詳細資料。

##Azure 用戶端應用程式註冊
1. 使用 Azure AD 認證登入 [Azure 管理入口網站](https://manage.windowsazure.com)。
2.  按一下左邊功能表上的 [Active Directory]，然後選取您的 Office 365 租用戶的目錄。
3.  按一下頂端功能表上的 [應用程式]。
4.  按一下底部功能表中的 [新增]。
5.  在 [您想要做什麼] 頁面上，按一下 [新增我的組織正在開發的應用程式]。
6.  在 [告訴我們您的應用程式] 頁面上，為應用程式名稱指定 [Android 程式碼片段範例]，並且為類型選取 [原生用戶端應用程式]。
7.  按一下頁面右下角的箭號按鈕。
8.  在 [應用程式的資訊] 頁面上，指定**重新導向 URI**，例如 `http://localhost/androidsnippets`然後選取頁面右下角的核取方塊。
9.  成功新增應用程式之後，您就會進入應用程式的 [快速入門] 頁面。 從這裡選取頂端功能表中的 [設定]。
10. 在 [其他應用程式的權限] 區段中，新增 Microsoft Graph 應用程式。
11. 對於 Microsoft Graph 應用程式，新增下列權限︰
   * 登入並讀取使用者設定檔
   * 具有使用者可以存取的所有檔案的完整存取權
   * 具有使用者行事曆的完整存取權
   * 使用者郵件的讀取和寫入存取權 
   * 以使用者的身分傳送郵件
   * 讀取使用者郵件
   * 讀取和寫入目錄資料
   * 讀取所有使用者的基本設定檔
   * 讀取和寫入所有群組
13. 按一下底端功能表的 [儲存]。
14. 請記下 [設定] 頁面上針對**用戶端識別碼** 您在稍後設定專案時需要這些值。

##設定專案

1. 下載或複製[程式碼片段範例](../../)。
2. 啟動 Android Studio。
3. 從 [歡迎使用 Android Studio] 對話方塊中，選擇 [匯入專案 (Eclipse ADT、Gradle 等等)]。
4. 在 **android-java-snippets-sample** 資料夾中選取 **settings.gradle** 檔案，然後按一下 [確定]。
5. 回應對話方塊 ("Gradle Sync:此專案的 Gradle 設定尚未設定。 您是否要讓專案使用 Gradle 包裝函式？ ")，方法是按一下 [確定] 按鈕以使用 Gradle 包裝函式。 
6. 開啟 com.microsoft.graph.snippets 封裝中的 ServiceConstants.java 檔案。
7. 尋找 [`CLIENT_ID`](app/src/main/java/com/microsoft/graph/snippets/ServiceConstants.java#L11) 字串，並將其值設定為您在 Azure 中註冊的用戶端識別碼。
8. 尋找 [`REDIRECT_URI`](app/src/main/java/com/microsoft/graph/snippets/ServiceConstants.java#L10) 字串，並將其值設定為您在 Azure 中註冊的重新導向 URI。

##執行專案
建置專案之後，您可以在模擬器或裝置上執行它。

1. 執行專案。
2. 按一下 [連接至 Microsoft Graph] 按鈕以登入。
3. 輸入您的認證。
4. 檢閱並接受應用程式要求的權限範圍。
4. 按一下主要活動的作業，以顯示作業詳細資料。
5. 按一下 [執行] 按鈕來啟動作業，並等候該作業完成。
6. 按一下 [原始物件] 文字方塊，將方塊內容複製到模擬器/裝置剪貼簿。
7. 按一下工具列上的返回按鈕以返回作業清單。
8. (選擇性) 按一下溢位功能表以取得中斷連線功能表選項。

##範例如何影響租用戶資料
這個範例會執行命令，該命令會建立、讀取、更新或刪除資料。 當執行刪除或編輯資料的命令時，範例會建立假的實體。 假的實體已被刪除或編輯，您的實際租用戶資料不會受到影響。 這個範例會在您的租用戶上留下假的實體。

##瞭解程式碼
程式碼片段專案會使用這些類別來管理與 Microsoft Graph 之間的互動︰

###範例專案組織
程式碼片段專案是由兩個模組所組成。 模組化的設計可讓您根據此範例建置新的應用程式，方法是將模組匯入您的應用程式。 匯入模組之後，使用程式碼片段[應用程式](/app)模組中的程式碼，做為如何在其他的範例模組中呼叫方法的範例。

###程式碼片段專案中的模組
* [`o365-Auth`](/o365-auth). 此模組包含程式庫呼叫，來驗證使用者與 Microsoft Graph。
* [`app`](/app). UI 和商務邏輯模組。 SDK 作業是在此模組中的程式碼片段類別啟動。

###程式碼片段類別
程式碼片段會執行單一作業，並傳回結果。 程式碼片段位於[應用程式](/app)模組。 程式碼片段會設定必要狀態，在如下所述的 Microsoft Graph 服務類別上進行呼叫。
* [`AbstractSnippet`](/app/src/main/java/com/microsoft/graph/snippets/snippet/AbstractSnippet.java)
* [`DrivesSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java)
* [`EventsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java)
* [`GroupsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java)
* [`MeSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java)
* [`MessageSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java)
* [`UsersSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java)

###驗證類別
驗證類別位於 [o365-Auth](/o365-auth) 模組。 這些類別使用 [Microsoft Azure Active Directory Library (ADAL) for Android](https://github.com/AzureAD/azure-activedirectory-library-for-android) 以連接至 Microsoft Graph。 

* [`AuthenticationManager`](/o365-auth/src/main/java/com/microsoft/graph/auth/AuthenticationManager.java). 除了 Azure 應用程式授權之外，封裝使用者連線和中斷連線邏輯。
* [`AzureADModule`](/o365-auth/src/main/java/com/microsoft/graph/auth/AzureADModule.java). 驗證協助程式類別。 
* [`AzureAppCompatActivity`](/o365-auth/src/main/java/com/microsoft/graph/auth/AzureAppCompatActivity.java). 相依性插入協助程式。
 
<a name="contributing"></a>
## 參與 ##

如果您想要參與這個範例，請參閱 [CONTRIBUTING.MD](/CONTRIBUTING.md)。

此專案已採用 [Microsoft 開放原始碼執行](https://opensource.microsoft.com/codeofconduct/)。如需詳細資訊，請參閱[程式碼執行常見問題集](https://opensource.microsoft.com/codeofconduct/faq/)，如果有其他問題或意見，請連絡 [opencode@microsoft.com](mailto:opencode@microsoft.com)。

## 問題和建議
我們很樂於收到您對於適用於 Android 的 Microsoft Graph SDK 程式碼片段範例的意見反應。 您可以在此儲存機制的[問題](../../issues)區段中，將您的意見反應傳送給我們。 <br/>
請在 [Stack Overflow](http://stackoverflow.com/questions/tagged/microsoftgraph)提出有關 Microsoft Graph 開發的一般問題。 務必以 [microsoftgraph] 標記您的問題。

## 其他資源

* [開始使用 Microsoft Graph 提供的 Office 365 API](http://dev.office.com/getting-started/office365apis)
* [Microsoft Graph 概觀](http://graph.microsoft.io)
* [Microsoft Graph SDK for Android](../../../msgraph-sdk-android)
* [使用 Microsoft Graph SDK 的 Connect 範例 (適用於 Android)](../../../android-java-connect-sample)

Copyright (c) 2015 Microsoft. 著作權所有，並保留一切權利。