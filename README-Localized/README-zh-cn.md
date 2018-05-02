# <a name="snippets-sample-for-android-using-the-microsoft-graph-sdk"></a>使用 Microsoft Graph SDK 的 Android 代码片段示例
**版本 1.5**

[![生成状态](https://travis-ci.org/microsoftgraph/android-java-snippets-sample.svg?branch=master)](https://travis-ci.org/microsoftgraph/android-java-snippets-sample)

**目录**

* [设备要求](#device-requirement)
* [先决条件](#prerequisites)
* [Azure 客户端应用程序注册](#azure-client-application-registration)
* [配置项目](#configure-the-project)
* [运行项目](#run-the-project)
* [示例如何影响租户数据](#how-the-sample-affects-your-tenant-data)
* [了解代码](#understand-the-code)
* [问题和意见](#questions-and-comments)
* [其他资源](#additional-resources)
* [版本历史记录](#version-history)

希望生成可帮助用户处理其 Office 365 数据的非常酷的应用？通过使用此代码段示例探索、学习和了解 Microsoft Graph SDK。本示例介绍如何通过在 Android 应用程序中对 Microsoft Graph SDK 进行调用来访问包括 Microsoft Azure Active Directory 和 Office 365 在内的多个资源。

可以在 Microsoft Graph 中探索以下操作：

**我**

* [获取已登录用户的相关信息。](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L44)
* [获取用户的职责。](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L67)
* [获取用户的经理。](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L94)
* [获取用户的直接下属。](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L117)
* [获取用户的组成员身份](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L140)
* [获取用户的照片。](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L164)

**用户**

* [从租户的目录中获取用户。](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L49)
* [获取按照租户目录中的条件筛选出来的用户。](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L80)
* [新建用户。](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L113)

**事件**

* [获取已登录用户的事件。](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L51)
* [为该用户创建一个新事件。](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L83)
* [更新用户的事件。](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L118)
* [删除用户的事件。](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L170)

**邮件**

* [获取用户的邮件。](app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java#L51)
* [从用户邮箱发送邮件。](app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java#L82)

**组**

* [获取租户目录中的所有组。](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L184)
* [创建新组。](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L191)
* [获取租户中特定组的相关信息。](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L45)
* [删除组。](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L248)
* [获取组的成员。](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L90)
* [获取组的所有者。](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L137)

**驱动器**

* [获取已登录用户的驱动器。](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L51)
* [获取用户的根文件夹中的所有文件。](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L83)
* [在用户的根文件夹中创建一个新文件。](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L118)
* [从用户的根文件夹下载文件。](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L160)
* [更新用户的根文件夹中的文件的内容。](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L223)
* [删除用户的根文件夹中的文件。](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L284)
* [重命名用户的根文件夹中的文件。](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L337)
* [在用户的根文件夹下创建文件夹。](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L395)

## <a name="device-requirements"></a>设备要求
若要运行代码片段项目，设备必须满足以下要求：
* Android API 级别 21 或更高级别

## <a name="android-studio-requirements"></a>Android Studio 要求
* 适用于 Gradle 3.1+ 的 Android 生成工具

> **注意：**Android Studio 可能会提示安装 Android Support Repository 47.0.0+。 项目的 module build.gradle 文件逻辑使用 `implementation` 方法（而不是旧 `compile` 方法）生成模块依赖项。 这些新生成方法依赖 Android Support Repository 47.0.0 或更高版本。


### <a name="prerequisites"></a>先决条件
若要使用 Microsoft Graph SDK 代码段项目，你需要以下各项：
* 最新版本的 [Android Studio](http://developer.android.com/sdk/index.html)。
* [Gradle](http://www.gradle.org) 生成自动化系统。
* Office 365 帐户。可以注册 [Office 365 开发人员订阅](https://portal.office.com/Signup/Signup.aspx?OfferId=C69E7747-2566-4897-8CBA-B998ED3BAB88&DL=DEVELOPERPACK&ali=1#0)，其中包含你开始构建 Office 365 应用所需的资源。
* [Java 开发工具包 (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html)。
* 带有客户端 ID 和重定向 URI 值的已注册 Azure 应用程序。请参阅 [向 Azure 中的代码段应用程序授予权限](../../../android-java-snippets-rest-sample/wiki/Grant-permissions-for-the-Snippet-application-in-Azure)，了解有关如何创建正确权限的详细信息。

## <a name="azure-client-application-registration"></a>Azure 客户端应用程序注册


1. 登录[应用程序注册门户](https://apps.dev.microsoft.com)。
3. 单击页面右侧的蓝色按钮“添加应用程序”****。
4. 命名应用程序。
4. _取消_选中“设置向导”**** 部分下的“让我们帮助你入门”****
4. 单击蓝色的“创建”**** 按钮，以创建注册。
5. 单击“平台”**** 部分下的“添加平台”****，再选择“本机应用程序”****。
8. 配置应用程序权限 - 在“Microsoft Graph 权限”**** 下，单击“委派权限”**** 旁边的蓝色按钮“添加”****
9. 添加以下委派权限：
   * 登录和读取用户配置文件
   * 具有对所有文件的完整访问权限的用户可以访问
   * 具有对用户日历的完整访问权限
   * 对用户邮件的读写权限 
   * 以用户身份发送邮件
   * 读取用户邮件
   * 读取和写入目录数据
   * 读取所有用户的基本个人资料
   * 读取和写入所有组
13. 单击底部菜单中的“保存”****。

> **注意：**在[配置项目](#configure-the-project)中，系统会要求复制应用程序注册门户生成的一些字符串。 配置项目期间，切勿离开应用程序注册页。 从应用程序注册门户复制的字符串会被粘贴到项目的源代码中。

## <a name="configure-the-project"></a>配置项目

1. 下载或克隆 [代码段示例](../../)。
2. 启动 Android Studio。
3. 从“**欢迎使用 Android Studio**”对话框中，选择“**导入项目(Eclipse ADT、Gradle 等)**”。
4. 选择“android-java-snippets-sample”**** 文件夹中的“settings.gradle”**** 文件，再单击“确定”****。
5. 单击“确定”**** 按钮，响应对话框（“Gradle 同步:尚未配置此项目的 Gradle 设置。是否希望项目使用 Gradle 包装器?”），以使用 Gradle 包装器。 
4. 在刚刚访问过的应用程序注册页中，将自定义重定向 URI (`msal{application id as GUID}`) 复制到剪贴板。 **请勿复制 `://auth`**
   <br/>例如，复制 `msal0575d7fe-8ec7-4925-9ce2-87074778a039`，但忽略 `://auth`。
4. 在 **app/src/main/AndroidManifest.xml** 的第 42 行粘贴剪贴板内容，以将 `ENTER_YOUR_CLIENT_ID` 替换为剪贴板内容。
4. 在 **app/src/main/AndroidManifest.xml** 的第 51 行粘贴自定义重定向 URI 的 **GUID 部分**，以将 `ENTER_YOUR_CLIENT_ID` 替换为剪贴板内容。

## <a name="run-the-project"></a>运行项目
生成项目后，你可以在仿真器或设备中运行。

1. 运行项目。
2. 单击“**连接到 Microsoft Graph**”按钮进行登录。
3. 输入你的凭据。
4. 查看并接受应用请求的权限范围。
4. 单击主要活动中的操作以显示操作详细信息。
5. 单击“**运行**”按钮以启动操作，并等待该操作完成。
6. 单击“**原始对象**”文本框以将文本框内容复制到仿真器或设备剪贴板。
7. 单击工具栏上的“后退”按钮返回到操作列表。
8. （可选）单击溢出菜单，以获取“断开连接”菜单选项。

## <a name="how-the-sample-affects-your-tenant-data"></a>示例如何影响你的租户数据
此示例运行创建、读取、更新或删除数据的命令。运行删除或编辑数据的命令时，示例创建虚设实体。删除或编辑虚设实体，以便实际租户数据不受影响。示例将在你的租户上保留这些虚设实体。

## <a name="understand-the-code"></a>了解代码
代码段项目使用这些类来管理与 Microsoft Graph 的交互：

### <a name="sample-project-organization"></a>示例项目组织结构
代码段项目由两个模块组成。模块化的设计使你能够通过将模块导入应用来生成基于此示例的新应用。导入模块后，使用代码段 [app](/app) 模块中的代码作为说明如何在其他示例模块中调用方法的示例。

### <a name="modules-in-the-snippets-project"></a>代码片段项目中的模块
* [`app`](/app)：UI 和业务逻辑模块。SDK 操作在此模块的代码片段类中启动。

### <a name="snippet-classes"></a>代码片段类
代码段运行单个操作并返回结果。可在 [app](/app) 模块中找到代码段。代码段设置在如下所述的 Microsoft Graph 服务类上进行调用所需的状态。
* [`AbstractSnippet`](/app/src/main/java/com/microsoft/graph/snippets/snippet/AbstractSnippet.java)
* [`DrivesSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java)
* [`EventsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java)
* [`GroupsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java)
* [`MeSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java)
* [`MessageSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java)
* [`UsersSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java)

### <a name="authentication-classes"></a>身份验证类
身份验证方法位于 [`AuthenticationManager`](/app/src/main/java/com/microsoft/graph/snippets/AuthenticationManager.java) 类中。这些方法使用[适用于 Android 的 Microsoft 身份验证库 (MSAL)](https://github.com/AzureAD/microsoft-authentication-library-for-android) 连接到 Microsoft Graph。 

* [`AuthenticationManager`](/app/src/main/java/com/microsoft/graph/snippets/AuthenticationManager.java)：除应用程序授权外，还封装用户连接逻辑和断开连接逻辑。
 
<a name="contributing"></a>
## <a name="contributing"></a>参与 ##

如果想要参与本示例，请参阅 [CONTRIBUTING.MD](/CONTRIBUTING.md)。

此项目采用 [Microsoft 开源行为准则](https://opensource.microsoft.com/codeofconduct/)。有关详细信息，请参阅 [Code of Conduct FAQ](https://opensource.microsoft.com/codeofconduct/faq/)（行为准则常见问题解答），有任何其他问题或意见，也可联系 [opencode@microsoft.com](mailto:opencode@microsoft.com)。

## <a name="questions-and-comments"></a>问题和意见
我们乐意倾听你有关适用于 Android 的 Microsoft Graph SDK 代码段示例的反馈。你可以在该存储库中的“[问题](../../issues)”部分将反馈发送给我们。 <br/>与 Microsoft Graph 开发相关的一般问题应发布到 [Stack Overflow](http://stackoverflow.com/questions/tagged/microsoftgraph)。请确保问题标记有 [microsoftgraph]。

## <a name="additional-resources"></a>其他资源

* [由 Microsoft Graph 提供支持的 Office 365 API 入门](http://dev.office.com/getting-started/office365apis)
* [Microsoft Graph 概述](http://graph.microsoft.io)
* [适用于 Android 的 Microsoft Graph SDK](../../../msgraph-sdk-android)
* [在 Android 中使用 Microsoft Graph SDK 的 Connect 示例](../../../android-java-connect-sample)

## <a name="version-history"></a>版本历史记录

|版本|更改内容|
|:---|:----|
|1.0|首版|
|1.5|- MSAL 身份验证库取代了 ADAL 身份验证库 <br/> - Microsoft Graph SDK 版本 1.5|

版权所有 (c) 2015 Microsoft。保留所有权利。
