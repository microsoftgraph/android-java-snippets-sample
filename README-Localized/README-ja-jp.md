# Microsoft Graph SDK を使った Android 用 スニペットのサンプル

[![Bビルドの状態](https://travis-ci.org/microsoftgraph/android-java-snippets-sample.svg?branch=master)](https://travis-ci.org/microsoftgraph/android-java-snippets-sample)

**目次**

* [デバイス要件](#デバイス要件)
* [前提条件](#前提条件)
* [Azure クライアント アプリケーションの登録](#azure-クライアント-アプリケーションの登録)
* [プロジェクトを構成する](#プロジェクトを構成する)
* [プロジェクトを実行する](#プロジェクトを実行する)
* [サンプルによるテナント データへの影響](#サンプルによるテナント-データへの影響)
* [コードを理解する](#コードを理解する)
* [質問とコメント](#質問とコメント)
* [その他のリソース](#その他のリソース)

ユーザーが Office 365 のデータを操作できるようにする優れたアプリを構築しようとする場合。 このスニペットのサンプルを使用して、Microsoft Graph SDK を探索、学習、理解します。 このサンプルでは、Android アプリケーションで Microsoft Graph SDK への呼び出しを実行して、Microsoft Azure Active Directory と Office 365 などの複数のリソースにアクセスする方法を示します。

Microsoft Graph での次の操作を参照することができます:

**自分**

* [サインインしているユーザーに関する情報を取得する。](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L44)
* [ユーザーの責任を取得する。](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L67)
* [ユーザーの上司を取得する。](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L94)
* [ユーザーの直属の部下を取得する。](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L117)
* [ユーザーのグループ メンバーシップを取得する。](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L140)
* [ユーザーの写真を取得する。](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L164)

**ユーザー**

* [テナントのディレクトリからユーザーを取得する。](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L49)
* [テナントのディレクトリの抽出条件でフィルター処理されたユーザーを取得する。](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L80)
* [新しいユーザーを作成する](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L113)

**イベント**

* [サインインしているユーザーのイベントを取得する。](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L51)
* [ユーザーの新しいイベントを作成する。](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L83)
* [ユーザーのイベントを更新する。](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L118)
* [ユーザーのイベントを削除する。](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L170)

**メッセージ**

* [ユーザーのメッセージを取得する。](app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java#L51)
* [ユーザーのメールボックスからメッセージを送信する。](app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java#L82)

**グループ**

* [テナントのディレクトリ内のすべてのグループを取得する。](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L184)
* [新しいグループを作成する](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L214)
* [テナント内の特定のグループに関する情報を取得する。](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L45)
* [グループを削除する。](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L248)
* [グループのメンバーを取得する。](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L90)
* [グループの所有者を取得する。](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L137)

**ドライブ**

* [サインインしているユーザーのドライブを取得する。](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L51)
* [ユーザーのルート フォルダー内のすべてのファイルを取得する。](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L83)
* [ユーザーのルート フォルダー内に新しいファイルを作成する。](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L118)
* [ユーザーのルート フォルダーからファイルをダウンロードする。](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L160)
* [ユーザーのルート フォルダー内のファイルのコンテンツを更新する。](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L223)
* [ユーザーのルート フォルダー内のファイルを削除する。](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L284)
* [ユーザーのルート フォルダー内のファイの名前を変更する。](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L337)
* [ユーザーのルート フォルダーの下にフォルダーを作成する。](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L395)

##デバイス要件
スニペットのプロジェクトを実行するには、デバイスが次の要件を満たしている必要があります:
* Android の API レベルが 16 以上

###前提条件
Microsoft Graph SDK のスニペット プロジェクトを使用するには、次のことが必要です:
* [Android Studio](http://developer.android.com/sdk/index.html) の最新バージョン。
* [Gradle](http://www.gradle.org) ビルド自動化システム。
* Office 365 アカウント。 Office 365 アプリの構築を開始するために必要なリソースを含む、[Office 365 Developer サブスクリプション](https://portal.office.com/Signup/Signup.aspx?OfferId=C69E7747-2566-4897-8CBA-B998ED3BAB88&DL=DEVELOPERPACK&ali=1#0)にサインアップできます。
* [Java 開発キット (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html)。
* クライアント ID とリダイレクト URI の各値を使用して登録された Azure アプリケーション。 適切なアクセス許可を作成する方法の詳細については、「[Azure のスニペット アプリケーションにアクセス許可を付与する](../../../android-java-snippets-rest-sample/wiki/Grant-permissions-for-the-Snippet-application-in-Azure)」を参照してください。

##Azure クライアント アプリケーションの登録
1. Azure AD 資格情報を使用して、[Azure 管理ポータル](https://manage.windowsazure.com)にサインインします。
2.  左側のメニューで **[Active Directory]** をクリックしてから、Office 365 テナントのディレクトリを選択します。
3.  上部のメニューで、**[アプリケーション]** をクリックします。
4.  下部のメニューから、**[追加]** をクリックします。
5.  **[何を行いますか] ページ**で、**[所属組織が開発しているアプリケーションの追加]** をクリックします。
6.  **[アプリケーションについてお聞かせください]** ページで、アプリケーション名に「**Android スニペット サンプル**」を指定し、種類に **[ネイティブ クライアント アプリケーション]** を選択します。
7.  ページの右下隅にある矢印ボタンをクリックします。
8.  **[アプリケーション情報]** ページで、**リダイレクト URI** を指定します。この例では `http://localhost/androidsnippets` を指定します。続いて、ページの右下隅にあるチェック ボックスを選びます。
9.  アプリケーションが正常に追加されたら、アプリケーションの **[クイック スタート]** ページに移動します。 ここから、上部のメニューにある **[構成]** を選択します。
10. 「他のアプリケーションへのアクセス許可」セクションで、Microsoft Graph アプリケーションを追加します。
11. Microsoft Graph アプリケーションには、次のアクセス許可を追加します:
   * サインインおよびユーザー プロファイルの読み取り
   * ユーザーがアクセスできるすべてのファイルへのフル アクセス
   * ユーザーの予定表へのフル アクセス
   * ユーザーのメールの読み取りと書き込みアクセス 
   * ユーザーとしてメールを送信
   * ユーザーのメールの読み取り
   * ディレクトリ データの読み取りおよび書き込み
   * すべてのユーザーの基本的なプロファイルの読み取り
   * すべてのグループの閲覧および書き込み
13. 下部のメニューで、**[保存]** をクリックします。
14. **[構成]** ページで、**[クライアント ID]** に指定された値をメモします。 後ほど、プロジェクトを構成するときに必要になります。

##プロジェクトを構成する

1. [スニペットのサンプル](../../)をダウンロードするか、クローンを作成します。
2. Android Studio を起動します。
3. **[Android Studio へようこそ]** ダイアログ ボックスから、**[プロジェクトをインポートする (Eclipse ADT、Gradle など)]** を選択します。
4. **android-java-snippets-sample** フォルダーで **settings.gradle** ファイルを選択して、**[OK]** をクリックします。
5. Gradle ラッパーを使用するには、[OK] ボタンをクリックして、ダイアログ ボックス ("Gradle の同期: このプロジェクトの Gradle 設定がまだ構成されていません。 プロジェクトで Gradle ラッパーを使用するようにしますか ?") に応答します。 
6. com.microsoft.graph.snippets パッケージの ServiceConstants.java ファイルを開きます。
7. [`CLIENT_ID`](app/src/main/java/com/microsoft/graph/snippets/ServiceConstants.java#L11) 文字列を検索して、Azure に登録したクライアント ID にその値を設定します。
8. [`REDIRECT_URI`](app/src/main/java/com/microsoft/graph/snippets/ServiceConstants.java#L10) 文字列を検索して、Azure に登録したリダイレクト URI にその値を設定します。

##プロジェクトを実行する
プロジェクトを作成したら、エミュレーターまたはデバイス上で実行できます。

1. プロジェクトを実行します。
2. **[Microsoft Graph へ接続する]** ボタンをクリックして、サインインします。
3. 資格情報を入力します。
4. アプリによって要求されたアクセス許可の適用範囲を確認して、承諾します。
4. メインのアクティビティ内の操作をクリックして、操作の詳細を表示します。
5. **[実行]** ボタンをクリックして、操作を開始し、操作が終了するまで待ちます。
6. **[未加工のオブジェクト]** テキスト ボックスをクリックして、ボックスのコンテンツをエミュレーターとデバイスのクリップボードにコピーします。
7. ツールバーの [戻る] ボタンをクリックして、操作一覧に戻ります。
8. (オプション) [切断] メニュー オプションを使用するには、オーバーフロー メニューをクリックします。

##サンプルによるテナント データへの影響
このサンプルでは、データを作成、読み取り、更新、または削除するコマンドを実行します。 データを削除、または編集するコマンドを実行すると、サンプルでは偽のエンティティが作成されます。 偽のエンティティは、実際のテナント データに影響がないように、削除または編集されます。 サンプルでは、偽のエンティティが削除されずにテナントに残ります。

##コードを理解する
スニペット プロジェクトでは、これらのクラスを使用して、Microsoft Graph との対話式操作を管理します:

###サンプルのプロジェクト組織
スニペット プロジェクトは、2 つのモジュールで構成されています。 モジュラーは、アプリにモジュールをインポートすることで、このサンプルに基づいて新しいアプリを構築できるように設計されています。 モジュールをインポートした後、他のサンプル モジュールでメソッドを呼び出す方法のサンプルとして、スニペットの[アプリ](/app) モジュールのコードを使用します。

###スニペット プロジェクト内のモジュール
* [`o365-Auth`](/o365-auth). このモジュールには、Microsoft Graph を使用してユーザーを認証するためのライブラリの呼び出しが含まれています。
* [`app`](/app). UI とビジネス ロジックのモジュール。 SDK 操作は、このモジュールのスニペット クラスで開始されます。

###スニペット クラス
スニペットは操作を 1 回実行し、結果を返します。 スニペットは、[アプリ](/app) モジュール内にあります。 スニペットは、以下に示す Microsoft Graph サービス クラスでの呼び出しを実行するために必要な状態を設定します。
* [`AbstractSnippet`](/app/src/main/java/com/microsoft/graph/snippets/snippet/AbstractSnippet.java)
* [`DrivesSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java)
* [`EventsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java)
* [`GroupsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java)
* [`MeSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java)
* [`MessageSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java)
* [`UsersSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java)

###認証クラス
認証クラスは、[o365 認証](/o365-auth) モジュール内にあります。 これらのクラスは、[Android 版 Microsoft Azure Active Directory ライブラリ (ADAL)](https://github.com/AzureAD/azure-activedirectory-library-for-android) を使用して、Microsoft Graph に接続します。 

* [`AuthenticationManager`](/o365-auth/src/main/java/com/microsoft/graph/auth/AuthenticationManager.java). Azure アプリ承認だけでなく、ユーザー接続と切断のロジックをカプセル化します。
* [`AzureADModule`](/o365-auth/src/main/java/com/microsoft/graph/auth/AzureADModule.java). 認証ヘルパーのクラス。 
* [`AzureAppCompatActivity`](/o365-auth/src/main/java/com/microsoft/graph/auth/AzureAppCompatActivity.java). 依存関係挿入ヘルパー。
 
<a name="contributing"></a>
## 投稿 ##

このサンプルに投稿する場合は、[CONTRIBUTING.MD](/CONTRIBUTING.md) を参照してください。

このプロジェクトでは、[Microsoft Open Source Code of Conduct](https://opensource.microsoft.com/codeofconduct/) が採用されています。詳細については、「[規範に関する FAQ](https://opensource.microsoft.com/codeofconduct/faq/)」を参照してください。または、その他の質問やコメントがあれば、[opencode@microsoft.com](mailto:opencode@microsoft.com) までにお問い合わせください。

## 質問とコメント
Android 用 Microsoft Graph SDK スニペットのサンプルに関するフィードバックをお寄せください。 このリポジトリの「[問題](../../issues)」セクションでフィードバックを送信できます。 <br/>
Microsoft Graph 開発に関する一般的な質問は、「[スタック オーバーフロー](http://stackoverflow.com/questions/tagged/microsoftgraph)」に投稿してください。 質問には、必ず [microsoftgraph] のタグを付けてください。

## その他のリソース

* [Microsoft Graph が提供する Office 365 API の使用を開始する](http://dev.office.com/getting-started/office365apis)
* [Microsoft Graph の概要](http://graph.microsoft.io)
* [Microsoft Graph SDK for Android](../../../msgraph-sdk-android)
* [Microsoft Graph SDK を使用した Android 用 Connect サンプル](../../../android-java-connect-sample)

Copyright (c) 2015 Microsoft. All rights reserved.