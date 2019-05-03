# Snippets Sample for Android Using the Microsoft Graph SDK
**Version 1.5**

[![Build Status](https://travis-ci.org/microsoftgraph/android-java-snippets-sample.svg?branch=master)](https://travis-ci.org/microsoftgraph/android-java-snippets-sample)

**Table of contents**

* [Device requirement](#device-requirement)
* [Prerequisites](#prerequisites)
* [Azure client application registration](#azure-client-application-registration)
* [Configure the project](#configure-the-project)
* [Run the project](#run-the-project)
* [How the sample affects your tenant data](#how-the-sample-affects-your-tenant-data)
* [Understand the code](#understand-the-code)
* [Questions and comments](#questions-and-comments)
* [Additional resources](#additional-resources)
* [Version history](#version-history)

Looking to build cool apps that help people work with their Office 365 data? Explore, learn, and understand the Microsoft Graph SDK by using this Snippets sample. This sample shows you how to access multiple resources, including Microsoft Azure Active Directory and Office 365, by making calls to the Microsoft Graph SDK in an Android application.

You can explore the following operations in Microsoft Graph:

**Me**

* [Get information about the signed in user.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L44)
* [Get the user's responsibilities.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L67)
* [Get the user's manager.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L94)
* [Get the user's direct reports.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L117)
* [Get the user's group membership](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L140)
* [Get the user's photo.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L164)

**Users**

* [Get users from your tenant's directory.](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L49)
* [Get users filtered by criteria from your tenant's directory.](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L80)
* [Create a new user.](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L113)

**Events**

* [Get the signed-in user's events.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L51)
* [Create a new event for the user.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L83)
* [Update a user's event.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L118)
* [Delete a user's event.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L170)

**Messages**

* [Get user's messages.](app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java#L51)
* [Send a message from the user mailbox.](app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java#L82)

**Groups**

* [Get all groups in your tenant's directory.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L184)
* [Create a new group.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L191)
* [Get information about a specific group in the tenant.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L45)
* [Delete a group.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L248)
* [Get a group's members.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L90)
* [Get a group's owners.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L137)

**Drives**

* [Gets the signed-in user's drive.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L51)
* [Gets all of the files in the user's root folder.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L83)
* [Creates a new file in the user's root folder.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L118)
* [Downloads a file from the user's root folder.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L160)
* [Updates the contents of a file in the user's root folder.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L223)
* [Deletes a file in the user's root folder.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L284)
* [Renames a file in the user's root folder.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L337)
* [Creates a folder under the user's root folder.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L395)

## Device requirements
To run snippets project, your device must meet the following requirement:
* Android API level 21 or newer

## Android Studio requirements
* Android build tools for Gradle 3.1+

> **Note:**
> Android Studio may prompt you to install the Android Support Repository 47.0.0+. The project's module build.gradle file logic uses the `implementation` method instead of the older `compile` method to build the module dependencies. These new build methods depend on the Android Support Repository 47.0.0 or newer.


### Prerequisites
To use the Microsoft Graph SDK snippets project, you need the following:
* The latest version of [Android Studio](http://developer.android.com/sdk/index.html).
* The [Gradle](http://www.gradle.org) build automation system.
* An Office 365 account. You can sign up for [an Office 365 Developer subscription](https://portal.office.com/Signup/Signup.aspx?OfferId=C69E7747-2566-4897-8CBA-B998ED3BAB88&DL=DEVELOPERPACK&ali=1#0) that includes the resources you need to start building Office 365 apps.
* [Java Development Kit (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html).
* A registered Azure application with a client id and redirect URI value. See [Grant permissions to the Snippets application in Azure](../../../android-java-snippets-rest-sample/wiki/Grant-permissions-for-the-Snippet-application-in-Azure) for details about how to create the correct permissions.

## Azure client application registration

1. Navigate to the [Azure portal - App registrations](https://go.microsoft.com/fwlink/?linkid=2083908) page. 
1. Select **New registration**. 
1. When the **Register an application page** appears, enter your application's registration information: 
    - In the **Name** section, enter a meaningful application name that will be displayed to users of the app, for example `Android Java Snippets Sample`. 
    - In the **Supported account types** section, select **Accounts in any organizational directory**. 
1. Select **Register** to create the application. 
1. On the app **Overview** page, find the **Application (client) ID** value and record it for later. You'll need it to configure the Visual Studio configuration file for this project. 
1. In the list of pages for the app, select **Manifest**, and: 
    - In the manifest editor, set the ``allowPublicClient`` property to **true** 
    - Select **Save** in the bar above the manifest editor. 
1. In the list of pages for the app, select **API permissions** 
    - Click the **Add a permission** button and then, 
    - Ensure that the **Microsoft APIs** tab is selected 
    - In the *Commonly used Microsoft APIs* section, click on **Microsoft Graph** 
    - In the **Delegated permissions** section, ensure that the right permissions are checked. Use the search box if necessary.
    - **User.Read**, **Mail.Send**, **Mail.ReadWrite**, **Files.ReadWrite**, **User.ReadBasic.All**, **Calendars.ReadWrite**, **Group.Read.All**  
    - Select the **Add permissions** button 

> **Note:**
> In [Configure the project](#configure-the-project), you'll be asked to copy some strings that are generated by the application registration portal. Be sure to stay on application registration page while you configure the project. The strings that you copy from the application registration will be pasted into the source code of the project.

## Configure the project

1. Download or clone the [snippets sample](../../).
2. Start Android Studio.
3. From the **Welcome to Android Studio** dialog box, choose **Import project (Eclipse ADT, Gradle, etc)**.
4. Select the **settings.gradle** file in the **android-java-snippets-sample** folder, and then click **OK**.
5. Respond to the dialog box ("Gradle Sync: Gradle settings for this project are not configured yet. Would you like the project to use the Gradle wrapper? ") by clicking the **OK** button to use the Gradle wrapper. 
4. In the application registration page that you just visited, copy the custom redirect URI (`msal{application id as GUID}`) to the clipboard. **Be sure you don't copy `://auth`**
   <br/>For example: `msal0575d7fe-8ec7-4925-9ce2-87074778a039` is copied and `://auth` is ignored.
4. Paste the clipboard contents in **app/src/main/AndroidManifest.xml**, line 41 to replace `ENTER_YOUR_CLIENT_ID` with the clipboard contents.
4. Copy the **GUID portion** of the custom redirect URI into **app/src/main/AndroidManifest.xml**, line 49 to replace `ENTER_YOUR_CLIENT_ID` with the clipboard contents.

## Run the project
After you've built the project you can run it on an emulator or device.

1. Run the project.
2. Click the **Connect to Microsoft Graph** button to sign in.
3. Enter your credentials.
4. Review and accept the permission scopes requested by the app.
4. Click an operation in the main activity to show operation details.
5. Click the **RUN** button to start the operation and wait for the operation to finish.
6. Click in the **Raw Object** text box to copy the box contents to the emulator/device clipboard.
7. Click the back button on the toolbar to return to the operation list.
8. (Optional) Click the overflow menu to get the Disconnect menu option.

## How the sample affects your tenant data
This sample runs commands that create, read, update, or delete data. When running commands that delete or edit data, the sample creates fake entities. The fake entities are deleted or edited so that your actual tenant data is unaffected. The sample will leave behind fake entities on your tenant.

## Understand the code
The snippets project uses these classes to manage interactions with Microsoft Graph:

### Sample project organization
The snippets project is comprised of two modules. The modular design enables you to build a new app based on this sample by importing the modules into your app. After you've imported the modules, use the code in the snippets [app](/app) module as an example of how to call methods in the other sample modules.

### Modules in the snippets project
* [`app`](/app). The UI and business logic module. SDK operations are started in the snippet classes in this module.

### Snippet classes
A snippet runs a single operation and returns the results. Snippets are found in the [app](/app) module. Snippets set the state required to make the calls on the Microsoft Graph service classes described below.
* [`AbstractSnippet`](/app/src/main/java/com/microsoft/graph/snippets/snippet/AbstractSnippet.java)
* [`DrivesSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java)
* [`EventsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java)
* [`GroupsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java)
* [`MeSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java)
* [`MessageSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java)
* [`UsersSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java)

### Authentication classes
The authentication methods are found in the [`AuthenticationManager`](/app/src/main/java/com/microsoft/graph/snippets/AuthenticationManager.java) class. These methods use the [Microsoft Authentication Library (MSAL) for Android](https://github.com/AzureAD/microsoft-authentication-library-for-android) to connect to Microsoft Graph. 

* [`AuthenticationManager`](/app/src/main/java/com/microsoft/graph/snippets/AuthenticationManager.java). Encapsulates user connect and disconnect logic in addition to app authorization.
 
<a name="contributing"></a>
## Contributing ##

If you'd like to contribute to this sample, see [CONTRIBUTING.MD](/CONTRIBUTING.md).

This project has adopted the [Microsoft Open Source Code of Conduct](https://opensource.microsoft.com/codeofconduct/). For more information see the [Code of Conduct FAQ](https://opensource.microsoft.com/codeofconduct/faq/) or contact [opencode@microsoft.com](mailto:opencode@microsoft.com) with any additional questions or comments.

## Questions and comments
We'd love to get your feedback about the Microsoft Graph SDK Snippets sample for Android. You can send your feedback to us in the [Issues](../../issues) section of this repository. <br/>
General questions about Microsoft Graph development should be posted to [Stack Overflow](http://stackoverflow.com/questions/tagged/microsoftgraph). Make sure that your questions are tagged with [microsoftgraph].

## Additional resources

* [Get started with Office 365 APIs powered by Microsoft Graph](http://dev.office.com/getting-started/office365apis)
* [Microsoft Graph overview](http://graph.microsoft.io)
* [Microsoft Graph SDK for Android](../../../msgraph-sdk-android)
* [Connect Sample for Android Using the Microsoft Graph SDK](../../../android-java-connect-sample)

## Version history

|Version|Changes|
|:---|:----|
|1.0|Initial release|
|1.5|- MSAL authentication library replaced ADAL authentication library <br/> - Microsoft Graph SDK version 1.5|

Copyright (c) 2019 Microsoft. All rights reserved.
