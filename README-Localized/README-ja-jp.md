# Microsoft Graph SDK を使用した Android 用スニペットのサンプル
**バージョン 1.5**

[![ビルドの状態](https://travis-ci.org/microsoftgraph/android-java-snippets-sample.svg?branch=master)](https://travis-ci.org/microsoftgraph/android-java-snippets-sample)

**目次**

* [デバイス要件](#device-requirement)
* [前提条件](#prerequisites)
* [Azure クライアント アプリケーションの登録](#azure-client-application-registration)
* [プロジェクトを構成する](#configure-the-project)
* [プロジェクトを実行する](#run-the-project)
* [サンプルによるテナント データへの影響](#how-the-sample-affects-your-tenant-data)
* [コードを理解する](#understand-the-code)
* [質問とコメント](#questions-and-comments)
* [その他の技術情報](#additional-resources)
* [バージョン履歴](#version-history)

Office 365 のデータを操作するための優れたアプリを構築する場合。このスニペットのサンプルを使用して、Microsoft Graph SDK を探索、学習、理解します。このサンプルでは、Android アプリケーションで Microsoft Graph SDK への呼び出しを実行して、Microsoft Azure Active Directory と Office 365 などの複数のリソースにアクセスする方法を示します。

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
* [新しいユーザーを作成する。](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L113)

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
* [新しいグループを作成する](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L191)
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
* [ユーザーのルート フォルダー内のファイルの名前を変更する。](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L337)
* [ユーザーのルート フォルダーの下にフォルダーを作成する。](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L395)

## デバイスの要件
スニペットのプロジェクトを実行するには、デバイスが次の要件を満たしている必要があります: * Android の API レベルが 21 以上

## Android Studio の要件
* Gradle 3.1+ 向けのAndroid ビルド ツール

> **注:** Android Studio では、Android Support Repository 47.0.0+ をインストールするように求めるメッセージが表示される場合があります。プロジェクトのモジュールの build.gradle ファイルのロジックでは、従来の `compile` メソッドではなく `implementation` メソッドを使用してモジュールの依存関係を構築します。これらの新しいビルド メソッドには、Android Support Repository 47.0.0 以降が必要です。


### 前提条件
Microsoft Graph SDK のスニペット プロジェクトを使用するには、次のことが必要です: * [Android Studio](http://developer.android.com/sdk/index.html) の最新バージョン。 * [Gradle](http://www.gradle.org) ビルド自動化システム。 * Office 365 アカウント。Office 365 アプリの構築を開始するために必要なリソースを含む、[Office 365 Developer サブスクリプション](https://portal.office.com/Signup/Signup.aspx?OfferId=C69E7747-2566-4897-8CBA-B998ED3BAB88&DL=DEVELOPERPACK&ali=1#0)にサインアップできます。 * [Java 開発キット (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html)。 * クライアント ID とリダイレクト URI の各値を使用して登録された Azure アプリケーション。適切なアクセス許可を作成する方法の詳細については、「[Azure のスニペット アプリケーションにアクセス許可を付与する](../../../android-java-snippets-rest-sample/wiki/Grant-permissions-for-the-Snippet-application-in-Azure)」を参照してください。

## Azure クライアント アプリケーションの登録

1. [Azure portal の \[アプリの登録]](https://go.microsoft.com/fwlink/?linkid=2083908) に移動します。 
1. \[**新規登録**] を選択します。 
1. \[**アプリケーションの登録ページ**] が表示されたら、以下のアプリケーションの登録情報を入力します。 
    - \[**名前**] セクションに、アプリのユーザーに表示されるわかりやすいアプリケーション名を入力します (例: `Android Java Snippets Sample`)。 
    - \[**サポートされているアカウントの種類**] セクションで、\[**任意の組織のディレクトリ内のアカウント**] を選択します。 
1. \[**登録**] を選択して、アプリケーションを作成します。 
1. アプリの \[**概要**] ページで、\[**Application (client) ID**] (アプリケーション (クライアント) ID) の値を確認し、後で使用するために記録します。この情報は、このプロジェクトで Visual Studio 構成ファイルを設定するのに必要になります。 
1. アプリのページの一覧から \[**マニフェスト**] を選択します。 
    - マニフェスト エディターで ``allowPublicClient`` プロパティを **true** に設定します。 
    - マニフェスト エディターの上のバーの \[**保存**] を選択します。 
1. アプリのページの一覧から \[**API のアクセス許可**] を選択します。 
    - \[**アクセス許可の追加]**] ボタンをクリックします 
    - \[**Microsoft API**] タブが選択されていることを確認します 
    - \[*一般的に使用される Microsoft API*] セクションで、\[**Microsoft Graph**] をクリックします 
    - \[**委任されたアクセス許可**] セクションで、適切なアクセス許可がチェックされていることを確認します。必要に応じて検索ボックスを使用します。
    - **User.Read**、**Mail.Send**、**Mail.ReadWrite**、**Files.ReadWrite**、**User.ReadBasic.All**、**Calendars.ReadWrite**、**Group.Read.All**  
    - \[**アクセス許可の追加**] ボタンを選択します 

> **注:** \[[プロジェクトの構成](#configure-the-project)] では、アプリケーション登録ポータルで生成されるいくつかの文字列をコピーするよう求められます。プロジェクトを構成する間、アプリケーション登録ページにとどまる必要があります。アプリケーション登録からコピーした文字列を、プロジェクトのソース コードに貼り付けます。

## プロジェクトを構成する

1. [スニペットのサンプル](../../)をダウンロードするか、クローンを作成します。
2. Android Studio を起動します。
3. \[**Android Studio へようこそ**] ダイアログ ボックスから、\[**プロジェクトをインポートする (Eclipse ADT、Gradle など)**] を選択します。
4. **android-java-snippets-sample** フォルダーで **settings.gradle** ファイルを選択して、\[**OK**] をクリックします。
5. ダイアログ ボックス ("Gradle の同期: このプロジェクトの Gradle 設定がまだ構成されていません。プロジェクトで Gradle ラッパーを使用するようにしますか?") に対し、\[**OK**] ボタンをクリックすると、Gradle ラッパーが使用できるようになります。 
4. 直前にアクセスしたアプリケーション登録ページで、カスタム リダイレクト URI (`msal{application id as GUID}`) をクリップボードにコピーします。**`://auth` はコピーしないでください**
   <br/>例: `msal0575d7fe-8ec7-4925-9ce2-87074778a039` をコピーし、`://auth` をコピーしません。
4. クリップボードの内容を **app/src/main/AndroidManifest.xml**、第 41 行に貼り付けて、`ENTER_YOUR_CLIENT_ID` をクリップボードの内容に置換します。
4. カスタム リダイレクト URI の **GUID portion** を **app/src/main/AndroidManifest.xml**、第 49 行にコピーして、`ENTER_YOUR_CLIENT_ID` をクリップボードの内容に置換します。

## プロジェクトを実行する
プロジェクトを作成したら、エミュレーターまたはデバイス上で実行できます。

1. プロジェクトを実行します。
2. \[**Microsoft Graph へ接続する**] ボタンをクリックして、サインインします。
3. 資格情報を入力します。
4. アプリによって要求されたアクセス許可の適用範囲を確認して、承諾します。
4. メインのアクティビティ内の操作をクリックして、操作の詳細を表示します。
5. \[**実行**] ボタンをクリックして、操作を開始し、操作が終了するまで待ちます。
6. \[**未加工のオブジェクト**] テキスト ボックスをクリックして、ボックスのコンテンツをエミュレーターとデバイスのクリップボードにコピーします。
7. ツールバーの \[戻る] ボタンをクリックして、操作一覧に戻ります。
8. (オプション) \[切断] メニュー オプションを使用するには、オーバーフロー メニューをクリックします。

## サンプルによるテナント データへの影響
このサンプルでは、データを作成、読み取り、更新、または削除するコマンドを実行します。データを削除、または編集するコマンドを実行すると、サンプルでは偽のエンティティが作成されます。偽のエンティティは、実際のテナント データに影響がないように、削除または編集されます。サンプルでは、偽のエンティティが削除されずにテナントに残ります。

## コードを理解する
スニペット プロジェクトでは、これらのクラスを使用して、Microsoft Graph との対話式操作を管理します:

### サンプルのプロジェクト組織
スニペット プロジェクトは、2 つのモジュールで構成されています。モジュラーは、アプリにモジュールをインポートすることで、このサンプルに基づいて新しいアプリを構築できるように設計されています。モジュールをインポートした後、他のサンプル モジュールでメソッドを呼び出す方法のサンプルとして、スニペットの[アプリ](/app) モジュールのコードを使用します。

### スニペット プロジェクト内のモジュール
* [`app`](/app)。UI とビジネス ロジックのモジュール。SDK 操作は、このモジュールのスニペット クラスで開始されます。

### スニペット クラス
スニペットは操作を 1 回実行し、結果を返します。スニペットは、[アプリ](/app) モジュール内にあります。スニペットは、以下に示す Microsoft Graph サービス クラスでの呼び出しを実行するために必要な状態を設定します。
* [`AbstractSnippet`](/app/src/main/java/com/microsoft/graph/snippets/snippet/AbstractSnippet.java)
* [`DrivesSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java)
* [`EventsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java)
* [`GroupsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java)
* [`MeSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java)
* [`MessageSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java)
* [`UsersSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java)

### 認証クラス
認証方法は [`AuthenticationManager`](/app/src/main/java/com/microsoft/graph/snippets/AuthenticationManager.java) クラスにあります。これらのメソッドでは、[Android 用 Microsoft 認証ライブラリ (MSAL)](https://github.com/AzureAD/microsoft-authentication-library-for-android) を使用して、Microsoft Graph に接続します。 

* [`AuthenticationManager`](/app/src/main/java/com/microsoft/graph/snippets/AuthenticationManager.java)。アプリ承認だけでなく、ユーザー接続と切断のロジックをカプセル化します。
 
<a name="contributing"></a>
## 投稿 ##

このサンプルに投稿する場合は、[CONTRIBUTING.MD](/CONTRIBUTING.md) を参照してください。

このプロジェクトでは、[Microsoft Open Source Code of Conduct](https://opensource.microsoft.com/codeofconduct/) が採用されています。詳細については、「[Code of Conduct の FAQ](https://opensource.microsoft.com/codeofconduct/faq/)」を参照してください。また、その他の質問やコメントがあれば、[opencode@microsoft.com](mailto:opencode@microsoft.com) までお問い合わせください。

## 質問とコメント
Android 用 Microsoft Graph SDK スニペットのサンプルに関するフィードバックをお寄せください。このリポジトリの「[問題](../../issues)」セクションでフィードバックを送信できます。<br/>
Microsoft Graph 開発に関する一般的な質問は、「[スタック オーバーフロー](http://stackoverflow.com/questions/tagged/microsoftgraph)」に投稿してください。質問には、必ず \[microsoftgraph] のタグを付けてください。

## その他の技術情報

* [Microsoft Graph が提供する Office 365 API の使用を開始する](http://dev.office.com/getting-started/office365apis)
* [Microsoft Graph の概要](http://graph.microsoft.io)
* [Microsoft Graph SDK for Android](../../../msgraph-sdk-android)
* [Microsoft Graph SDK を使用した Android 用 Connect サンプル](../../../android-java-connect-sample)

## バージョン履歴

|バージョン|変更|
|:---|:----|
|1.0|初期リリース|
|1.5 |- ADAL 認証ライブラリを MSAL 認証ライブラリに置換 <br/> \- Microsoft Graph SDK バージョン 1.5|

Copyright (c) 2019 Microsoft.All rights reserved.
