# Snippets Sample for Android Using the Microsoft Graph SDK

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
* [Create a new group.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L214)
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

##Device requirement
To run snippets project, your device must meet the following requirement:
* Android API level 16 or newer

###Prerequisites
To use the Microsoft Graph SDK snippets project, you need the following:
* The latest version of [Android Studio](http://developer.android.com/sdk/index.html).
* The [Gradle](http://www.gradle.org) build automation system.
* An Office 365 account. You can sign up for [an Office 365 Developer subscription](https://portal.office.com/Signup/Signup.aspx?OfferId=C69E7747-2566-4897-8CBA-B998ED3BAB88&DL=DEVELOPERPACK&ali=1#0) that includes the resources you need to start building Office 365 apps.
* [Java Development Kit (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html).
* A registered Azure application with a client id and redirect URI value. See [Grant permissions to the Snippets application in Azure](../../../android-java-snippets-rest-sample/wiki/Grant-permissions-for-the-Snippet-application-in-Azure) for details about how to create the correct permissions.

##Azure client application registration
1. Sign in to the [Azure Management Portal](https://manage.windowsazure.com), using your Azure AD credentials.
2.	Click **Active Directory** on the left menu, then select the directory for your Office 365 tenant.
3.	On the top menu, click **Applications**.
4.	Click **Add** from the bottom menu.
5.	On the **What do you want to do page**, click **Add an application my organization is developing**.
6.	On the **Tell us about your application page**, specify **Android Snippet Sample** for the application name and select **NATIVE CLIENT APPLICATION** for type.
7.	Click the arrow button on the bottom-right corner of the page.
8.	On the **Application information** page, specify a **Redirect URI** for example `http://localhost/androidsnippets`, and then select the check box in the lower-right corner of the page.
9.	After the application has been successfully added, you will be taken to the **Quick Start** page for the application. From there, select **Configure** in the top menu.
10. In the permissions to other applications section, add the Microsoft Graph application.
11. For the Microsoft Graph application, add the following permissions:
   * Sign in and read user profile
   * Have full access to all files user can access
   * Have full access to user calendars
   * Read and write access to user mail 
   * Send mail as a user
   * Read user mail
   * Read and write directory data
   * Read all users' basic profiles
   * Read and write all groups
13. Click **Save** in the bottom menu.
14. Note the values specified for **Client ID** on the **Configure** page. You will need these later when you configure the project.

##Configure the project

1. Download or clone the [snippets sample](../../).
2. Start Android Studio.
3. From the **Welcome to Android Studio** dialog box, choose **Import project (Eclipse ADT, Gradle, etc)**.
4. Select the **settings.gradle** file in the **android-java-snippets-sample** folder, and then click **OK**.
5. Respond to the dialog box ("Gradle Sync: Gradle settings for this project are not configured yet. Would you like the project to use the Gradle wrapper? ") by clicking the **OK** button to use the Gradle wrapper. 
6. Open the ServiceConstants.java file in the com.microsoft.graph.snippets package.
7. Find the [`CLIENT_ID`](app/src/main/java/com/microsoft/graph/snippets/ServiceConstants.java#L11) string and set its value to the client id you registered in Azure.
8. Find the [`REDIRECT_URI`](app/src/main/java/com/microsoft/graph/snippets/ServiceConstants.java#L10) string and set its value to the redirect URI you registered in Azure.

##Run the project
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

##How the sample affects your tenant data
This sample runs commands that create, read, update, or delete data. When running commands that delete or edit data, the sample creates fake entities. The fake entities are deleted or edited so that your actual tenant data is unaffected. The sample will leave behind fake entities on your tenant.

##Understand the code
The snippets project uses these classes to manage interactions with Microsoft Graph:

###Sample project organization
The snippets project is comprised of two modules. The modular design enables you to build a new app based on this sample by importing the modules into your app. After you've imported the modules, use the code in the snippets [app](/app) module as an example of how to call methods in the other sample modules.

###Modules in the snippets project
* [`o365-Auth`](/o365-auth). This module contains the library calls to authenticate a user with Microsoft Graph.
* [`app`](/app). The UI and business logic module. SDK operations are started in the snippet classes in this module.

###Snippet classes
A snippet runs a single operation and returns the results. Snippets are found in the [app](/app) module. Snippets set the state required to make the calls on the Microsoft Graph service classes described below.
* [`AbstractSnippet`](/app/src/main/java/com/microsoft/graph/snippets/snippet/AbstractSnippet.java)
* [`DrivesSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java)
* [`EventsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java)
* [`GroupsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java)
* [`MeSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java)
* [`MessageSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java)
* [`UsersSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java)

###Authentication classes
The authentication classes are found in the [o365-Auth](/o365-auth) module. These classes use the [Microsoft Azure Active Directory Library (ADAL) for Android](https://github.com/AzureAD/azure-activedirectory-library-for-android) to connect to Microsoft Graph. 

* [`AuthenticationManager`](/o365-auth/src/main/java/com/microsoft/graph/auth/AuthenticationManager.java). Encapsulates user connect and disconnect logic in addition to Azure app authorization.
* [`AzureADModule`](/o365-auth/src/main/java/com/microsoft/graph/auth/AzureADModule.java). Authentication helper class. 
* [`AzureAppCompatActivity`](/o365-auth/src/main/java/com/microsoft/graph/auth/AzureAppCompatActivity.java). Dependency injection helper.

## Questions and comments
We'd love to get your feedback about the Microsoft Graph SDK Snippets sample for Android. You can send your feedback to us in the [Issues](../../issues) section of this repository. <br/>
General questions about Microsoft Graph development should be posted to [Stack Overflow](http://stackoverflow.com/questions/tagged/microsoftgraph). Make sure that your questions are tagged with [microsoftgraph].

## Additional resources

* [Get started with Office 365 APIs powered by Microsoft Graph](http://dev.office.com/getting-started/office365apis)
* [Microsoft Graph overview](http://graph.microsoft.io)
* [Microsoft Graph SDK for Android](../../../msgraph-sdk-android)
* [Connect Sample for Android Using the Microsoft Graph SDK](../../../android-java-connect-sample)

Copyright (c) 2015 Microsoft. All rights reserved.

