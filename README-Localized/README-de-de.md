# <a name="snippets-sample-for-android-using-the-microsoft-graph-sdk"></a>Codeausschnittbeispiel für Android unter Verwendung des Microsoft Graph-SDK

[![Buildstatus](https://travis-ci.org/microsoftgraph/android-java-snippets-sample.svg?branch=master)](https://travis-ci.org/microsoftgraph/android-java-snippets-sample)

**Inhaltsverzeichnis**

* [Geräteanforderung](#device-requirement)
* [Voraussetzungen](#prerequisites)
* [Registrierung der Azure-Clientanwendung](#azure-client-application-registration)
* [Konfigurieren des Projekts](#configure-the-project)
* [Ausführen des Projekts](#run-the-project)
* [Wie sich das Beispiel auf Ihre Mandantendaten auswirkt](#how-the-sample-affects-your-tenant-data)
* [Grundlegendes zum Code](#understand-the-code)
* [Fragen und Kommentare](#questions-and-comments)
* [Zusätzliche Ressourcen](#additional-resources)

Sie möchten coole Apps entwickeln, die das Arbeiten mit Office 365-Daten erleichtern? Durchsuchen, erforschen und lernen Sie das Microsoft Graph-SDK mithilfe dieses Codeausschnittsbeispiels kennen. In diesem Beispiel wird gezeigt, wie Sie auf mehrere Ressourcen, einschließlich Microsoft Azure Active Directory (AD) und Office 365, zugreifen, indem Sie Aufrufe des Microsoft Graph-SDKs in einer Android-Anwendung ausführen.

Machen Sie sich mit den folgenden Vorgängen in Microsoft Graph vertraut:

**Ich**

* [Informationen zum angemeldeten Benutzer abrufen.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L44)
* [Die Zuständigkeiten des Benutzers abrufen.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L67)
* [Den Vorgesetzten des Benutzers abrufen.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L94)
* [Die direkt unterstellten Mitarbeiter des Benutzers abrufen.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L117)
* [Die Gruppenmitgliedschaft des Benutzers abrufen.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L140)
* [Das Foto des Benutzers abrufen.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L164)

**Benutzer**

* [Benutzer aus dem Mandantenverzeichnis abrufen.](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L49)
* [Nach Kriterien gefilterte Benutzer aus dem Mandantenverzeichnis abrufen.](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L80)
* [Einen neuen Benutzer erstellen.](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L113)

**Ereignisse**

* [Die Ereignisse des angemeldeten Benutzers abrufen.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L51)
* [Ein neues Ereignis für den Benutzer erstellen.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L83)
* [Ein Ereignis eines Benutzers aktualisieren.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L118)
* [Ein Ereignis eines Benutzers löschen.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L170)

**Nachrichten**

* [Nachrichten eines Benutzers abrufen.](app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java#L51)
* [Eine Nachricht aus dem Benutzerpostfach senden.](app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java#L82)

**Gruppen**

* [Alle Gruppen im Mandantenverzeichnis abrufen.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L184)
* [Eine neue Gruppe erstellen.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L191)
* [Informationen zu einer bestimmten Gruppe im Mandanten abrufen.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L45)
* [Eine Gruppe löschen.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L248)
* [Die Mitglieder einer Gruppe abrufen.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L90)
* [Die Besitzer einer Gruppe abrufen.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L137)

**Laufwerke**

* [Ruft das Laufwerk des angemeldeten Benutzers ab.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L51)
* [Ruft alle Dateien im Stammordner des Benutzers ab.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L83)
* [Erstellt eine neue Datei im Stammordner des Benutzers.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L118)
* [Lädt eine Datei aus dem Stammordner des Benutzers herunter.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L160)
* [Aktualisiert den Inhalt einer Datei im Stammordner des Benutzers.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L223)
* [Löscht eine Datei im Stammordner des Benutzers.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L284)
* [Benennt eine Datei im Stammordner des Benutzers um.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L337)
* [Erstellt einen Ordner unter dem Stammordner des Benutzers.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L395)

##<a name="device-requirement"></a>Geräteanforderung
Um das Codeausschnittprojekt auszuführen, muss Ihr Gerät die folgende Anforderung erfüllen:
* Android-API-Ebene 16 oder höher.

###<a name="prerequisites"></a>Anforderungen
Sie benötigen Folgendes, um das Codeausschnittprojekt für das Microsoft Graph-SDK zu verwenden:
* Die aktuelle Version von [Android Studio](http://developer.android.com/sdk/index.html).
* Das Buildautomatisierungssystem [Gradle](http://www.gradle.org).
* Ein Office 365-Konto. Sie können sich für ein [Office 365-Entwicklerabonnement](https://portal.office.com/Signup/Signup.aspx?OfferId=C69E7747-2566-4897-8CBA-B998ED3BAB88&DL=DEVELOPERPACK&ali=1#0) registrieren. Dieses umfasst die Ressourcen, die Sie zum Erstellen von Office 365-Apps benötigen.
* [Java Development Kit (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html).
* Eine in Azure registrierte Anwendung mit einem Wert für die Client-ID und den Umleitungs-URI. Unter [Gewähren von Berechtigungen für die Snippets-Anwendung in Azure](../../../android-java-snippets-rest-sample/wiki/Grant-permissions-for-the-Snippet-application-in-Azure) finden Sie ausführliche Informationen zum Erstellen der erforderlichen Berechtigungen.

##<a name="azure-client-application-registration"></a>Registrierung der Azure-Clientanwendung
1. Melden Sie sich mithilfe Ihrer Azure AD-Anmeldeinformationen beim [Azure-Verwaltungsportal](https://manage.windowsazure.com) an.
2.    Klicken Sie im linken Menü auf **Active Directory**, und wählen Sie dann das Verzeichnis für Ihren Office 365-Mandanten aus.
3.    Klicken Sie im oberen Menü auf **Anwendungen**.
4.    Klicken Sie im Menü unten auf **Hinzufügen**.
5.    Klicken Sie auf der Seite für die Auswahl der Aktionen**** auf **Eine von meinem Unternehmen entwickelte Anwendung hinzufügen**.
6.    Geben Sie auf der Seite **Erzählen Sie uns von Ihrer Anwendung** die Option für das Android-Codeausschnittbeispiel**** für den Anwendungsnamen an, und wählen Sie **SYSTEMEIGENE CLIENTANWENDUNG** für den Typ aus.
7.    Klicken Sie in der unteren rechten Ecke der Seite auf das Pfeilsymbol.
8.    Geben Sie auf der Seite mit den **Anwendungsinformationen** einen **Umleitungs-URI** an, z. B. `http://localhost/androidsnippets`, und aktivieren Sie dann das Kontrollkästchen in der rechten unteren Ecke der Seite.
9.    Nachdem die Anwendung erfolgreich hinzugefügt wurde, gelangen Sie zur Seite **Schnellstart** für die Anwendung. Wählen Sie dort im oberen Menü **Konfigurieren** aus. 
10. Fügen Sie im Bereich mit Berechtigungen für andere Anwendungen die Microsoft Graph-Anwendung hinzu.
11. Fügen Sie für die Microsoft Graph-Anwendung die folgenden Berechtigungen hinzu:
   * Anmelden und Lesen von Benutzerprofilen
   * Vollzugriff auf alle Dateien, auf die Benutzer zugreifen können
   * Vollzugriff auf Benutzerkalender
   * Schreib-/Lesezugriff auf Benutzer-E-Mails 
   * E-Mails als Benutzer senden
   * Benutzer-E-Mails lesen
   * Schreib-/Lesezugriff auf Verzeichnisdaten
   * Lesezugriff auf grundlegende Profile aller Benutzer
   * Schreib-/Lesezugriff auf alle Gruppen
13. Klicken Sie im Menü unten auf **Speichern**.
14. Notieren Sie die auf der Seite **Konfigurieren** angegebenen Werte für **Client-ID**. Diese benötigen Sie später beim Konfigurieren des Projekts.

##<a name="configure-the-project"></a>Konfigurieren des Projekts

1. Laden Sie das [Codeausschnittbeispiel](../../) herunter, oder klonen Sie es.
2. Starten Sie Android Studio.
3. Wählen Sie im Dialogfeld **Willkommen bei Android Studio** die Option **Projekt importieren (Ellipse ADT, Gradle usw.)** aus.
4. Wählen Sie die Datei **settings.gradle** im Ordner **android-java-snippets-sample** aus, und klicken Sie dann auf **OK**.
5. Reagieren Sie auf das Dialogfeld („Gradle-Synchronisierung: Gradle-Einstellungen für dieses Projekt sind noch nicht konfiguriert. Soll das Projekt den Gradle-Wrapper verwenden?"), indem Sie auf die Schaltfläche **OK** klicken, um den Gradle-Wrapper zu verwenden. 
6. Öffnen Sie die Datei „ServiceConstants.java“ im Paket „com.microsoft.graph.snippets“.
7. Suchen Sie die [`CLIENT_ID`](app/src/main/java/com/microsoft/graph/snippets/ServiceConstants.java#L11)-Textzeichenfolge, und legen Sie ihren Wert auf die in Azure registrierte Client-ID fest.
8. Suchen Sie die [`REDIRECT_URI`](app/src/main/java/com/microsoft/graph/snippets/ServiceConstants.java#L10)-Textzeichenfolge, und legen Sie ihren Wert auf den in Azure registrierten Umleitungs-URI fest.

##<a name="run-the-project"></a>Ausführen des Projekts
Nach dem Erstellen des Projekts können Sie es auf einem Emulator oder Gerät ausführen.

1. Führen Sie das Projekt aus.
2. Klicken Sie für die Anmeldung auf die Schaltfläche **Verbinden mit Microsoft Graph**.
3. Geben Sie Ihre Anmeldeinformationen ein.
4. Überprüfen und akzeptieren Sie die von der App angeforderten Berechtigungsbereiche.
4. Klicken Sie auf einen Vorgang in der Hauptaktivität, um Vorgangsdetails anzuzeigen.
5. Klicken Sie auf die Schaltfläche **AUSFÜHREN**, um den Vorgang zu starten, und warten Sie, bis der Vorgang abgeschlossen ist.
6. Klicken Sie in das Textfeld für das Rohobjekt****, um den Inhalt des Felds in die Zwischenablage des Emulators/Geräts zu kopieren.
7. Klicken Sie auf der Symbolleiste auf die Schaltfläche „Zurück“, um zur Vorgangsliste zurückzukehren.
8. (Optional) Klicken Sie auf das Überlaufmenü, um die Menüoption zum Trennen aufzurufen.

##<a name="how-the-sample-affects-your-tenant-data"></a>Wie sich das Beispiel auf Ihre Mandantendaten auswirkt
In diesem Beispiel werden Befehle ausgeführt, mit denen Daten erstellt, aktualisiert oder gelöscht werden. Wenn Sie Befehle ausführen, die Daten löschen oder bearbeiten, erstellt das Beispiel gefälschte Entitäten. Die gefälschten Entitäten werden gelöscht oder bearbeitet, sodass Ihre tatsächlichen Mandantendaten nicht beeinträchtigt werden. In dem Beispiel werden einige dieser gefälschten Entitäten auf Ihrem Mandanten hinterlassen.

##<a name="understand-the-code"></a>Grundlegendes zum Code
Das Codeausschnittprojekt verwendet diese Klassen, um Interaktionen mit Microsoft Graph zu verwalten:

###<a name="sample-project-organization"></a>Organisation des Beispielprojekts
Das Codeausschnittprojekt besteht aus zwei Modulen. Dank des modularen Designs können Sie eine neue Anwendung auf Grundlage dieses Beispiels erstellen, indem Sie die Module in die App importieren. Nachdem Sie die Module importiert haben, verwenden Sie den Code im [App](/app)-Modul als ein Beispiel dafür, wie Methoden in den anderen Beispielmodulen aufgerufen werden.

###<a name="modules-in-the-snippets-project"></a>Module im Codeausschnittprojekt
* [`o365-Auth`](/o365-auth). Dieses Modul enthält die Bibliotheksaufrufe zur Authentifizierung eines Benutzers bei Microsoft Graph.
* [`app`](/app). Die Benutzeroberfläche und das Geschäftslogikmodul. SDK-Vorgänge werden in den Codeausschnittklassen in diesem Modul gestartet.

###<a name="snippet-classes"></a>Codeausschnittklassen
Ein Codeausschnitt wird in einem einzelnen Vorgang ausgeführt und gibt die Ergebnisse zurück. Codeausschnitte befinden sich im [App](/app)-Modul. Codeausschnitte legen den erforderlichen Status fest, um die Aufrufe in den nachstehend beschriebenen Microsoft Graph-Dienstklassen auszuführen.
* [`AbstractSnippet`](/app/src/main/java/com/microsoft/graph/snippets/snippet/AbstractSnippet.java)
* [`DrivesSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java)
* [`EventsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java)
* [`GroupsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java)
* [`MeSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java)
* [`MessageSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java)
* [`UsersSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java)

###<a name="authentication-classes"></a>Authentifizierungsklassen
Die Authentifizierungsklassen befinden sich im [o365-Auth](/o365-auth)-Modul. Diese Klassen verwenden die [Microsoft Azure Active Directory Library (ADAL) für Android](https://github.com/AzureAD/azure-activedirectory-library-for-android), um eine Verbindung zu Microsoft Graph herzustellen. 

* [`AuthenticationManager`](/o365-auth/src/main/java/com/microsoft/graph/auth/AuthenticationManager.java). Kapselt neben der Azure-App-Autorisierung die Logik für die Benutzerverbindung und -trennung.
* [`AzureADModule`](/o365-auth/src/main/java/com/microsoft/graph/auth/AzureADModule.java). Hilfsklasse der Authentifizierung. 
* [`AzureAppCompatActivity`](/o365-auth/src/main/java/com/microsoft/graph/auth/AzureAppCompatActivity.java). Hilfsprogramm für die Abhängigkeitsinjektion.
 
<a name="contributing"></a>
## <a name="contributing"></a>Mitwirkung ##

Wenn Sie einen Beitrag zu diesem Beispiel leisten möchten, finden Sie unter [CONTRIBUTING.MD](/CONTRIBUTING.md) weitere Informationen.

In diesem Projekt wurden die [Microsoft Open Source-Verhaltensregeln](https://opensource.microsoft.com/codeofconduct/) übernommen. Weitere Informationen finden Sie unter [Häufig gestellte Fragen zu Verhaltensregeln](https://opensource.microsoft.com/codeofconduct/faq/), oder richten Sie Ihre Fragen oder Kommentare an [opencode@microsoft.com](mailto:opencode@microsoft.com).

## <a name="questions-and-comments"></a>Fragen und Kommentare
Wir schätzen Ihr Feedback hinsichtlich des Codeausschnittbeispiels für das Microsoft Graph-SDK für Android. Sie können uns Ihr Feedback über den Abschnitt [Probleme](../../issues) dieses Repositorys senden. <br/> Allgemeine Fragen zur Microsoft Graph-Entwicklung sollten in [Stack Overflow](http://stackoverflow.com/questions/tagged/microsoftgraph) gestellt werden. Stellen Sie sicher, dass Ihre Fragen mit [microsoftgraph] markiert sind.

## <a name="additional-resources"></a>Zusätzliche Ressourcen

* [Erste Schritte mit Office 365-APIs, unterstützt von Microsoft Graph](http://dev.office.com/getting-started/office365apis)
* [Microsoft Graph-Übersicht](http://graph.microsoft.io)
* [Microsoft Graph-SDK für Android](../../../msgraph-sdk-android)
* [Connect-Beispiel für Android unter Verwendung des Microsoft Graph-SDK](../../../android-java-connect-sample)

Copyright (c) 2015 Microsoft. Alle Rechte vorbehalten.
