# Codeausschnittbeispiel für Android unter Verwendung des Microsoft Graph-SDK
**Version 1.5**

[![Buildstatus](https://travis-ci.org/microsoftgraph/android-java-snippets-sample.svg?branch=master)](https://travis-ci.org/microsoftgraph/android-java-snippets-sample)

**Inhalt**

* [Geräteanforderung](#device-requirement)
* [Voraussetzungen](#prerequisites)
* [Registrierung der Azure-Clientanwendung](#azure-client-application-registration)
* [Konfigurieren des Projekts](#configure-the-project)
* [Ausführen des Projekts](#run-the-project)
* [Wie sich das Beispiel auf Ihre Mandantendaten auswirkt](#how-the-sample-affects-your-tenant-data)
* [Grundlegendes zum Code](#understand-the-code)
* [Fragen und Kommentare](#questions-and-comments)
* [Zusätzliche Ressourcen](#additional-resources)
* [Versionsverlauf](#version-history)

Sie möchten coole Apps entwickeln, die das Arbeiten mit Office 365-Daten erleichtern? Durchsuchen, erforschen und lernen Sie das Microsoft Graph-SDK mithilfe dieses Codeausschnittsbeispiels kennen. In diesem Beispiel wird gezeigt, wie Sie auf mehrere Ressourcen, einschließlich Microsoft Azure Active Directory (AD) und Office 365, zugreifen, indem Sie Aufrufe des Microsoft Graph-SDKs in einer Android-Anwendung ausführen.

Machen Sie sich mit den folgenden Vorgängen in Microsoft Graph vertraut:

**Me**

* [Informationen zum angemeldeten Benutzer abrufen.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L44)
* [Die Zuständigkeiten des Benutzers abrufen.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L67)
* [Den Vorgesetzten des Benutzers abrufen.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L94)
* [Den direkten Vorgesetzten des Benutzers abrufen.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L117)
* [Die Gruppenmitgliedschaft des Benutzers abrufen.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L140)
* [Das Foto des Benutzers abrufen.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L164)

**Benutzer**

* [Benutzer aus dem Verzeichnis Ihres Mandanten abrufen.](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L49)
* [Nach Kriterien gefilterte Benutzer aus dem Mandantenverzeichnis abrufen.](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L80)
* [Einen neuen Benutzer erstellen.](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L113)

**Ereignisse**

* [Die Ereignisse des angemeldeten Benutzers abrufen.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L51)
* [Ein neues Postfach für den Benutzer erstellen.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L83)
* [Ein Ereignis eines Benutzers aktualisieren.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L118)
* [Ein Ereignis eines Benutzers löschen.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L170)

**Nachrichten**

* [Nachrichten eines Benutzers abrufen.](app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java#L51)
* [Eine Nachricht über das Benutzerpostfach senden.](app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java#L82)

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

## Geräteanforderungen
Um das Codeausschnittprojekt auszuführen, muss Ihr Gerät die folgende Anforderung erfüllen: * Android-API-Ebene 21 oder höher

## Android Studio-Anforderungen
* Android-Buildtools für Gradle 3.1 oder höher

> **Hinweis:** Android Studio fordert Sie möglicherweise dazu auf, das Android Support Repository 47.0.0 oder höher zu installieren. Die Logik der Projektmoduldatei "build.gradle" verwendet die `implementation`-Methode anstelle der älteren `compile`-Methode, um die Modulabhängigkeiten zu erstellen. Diese neuen Buildmethoden hängen mit dem Android Support Repository 47.0.0 oder höher zusammen.


### Voraussetzungen
Sie benötigen Folgendes, um das Codeausschnittprojekt für das Microsoft Graph-SDK zu verwenden: * Die aktuelle Version von [Android Studio](http://developer.android.com/sdk/index.html). * Das Buildautomatisierungssystem [Gradle](http://www.gradle.org). * Ein Office 365-Konto. Sie können sich für ein [Office 365-Entwicklerabonnement](https://portal.office.com/Signup/Signup.aspx?OfferId=C69E7747-2566-4897-8CBA-B998ED3BAB88&DL=DEVELOPERPACK&ali=1#0) registrieren. Dieses umfasst die Ressourcen, die Sie zum Erstellen von Office 365-Apps benötigen. * [Java Development Kit (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html). * Eine in Azure registrierte Anwendung mit einem Wert für die Client-ID und den Umleitungs-URI. Unter [Gewähren von Berechtigungen für die Snippets-Anwendung in Azure](../../../android-java-snippets-rest-sample/wiki/Grant-permissions-for-the-Snippet-application-in-Azure) finden Sie ausführliche Informationen zum Erstellen der erforderlichen Berechtigungen.

## Registrierung der Azure-Clientanwendung

1. Navigieren Sie zur Seite [Azure-Portal – App-Registrierungen](https://go.microsoft.com/fwlink/?linkid=2083908). 
1. Wählen Sie **Neue Registrierungen** aus. 
1. Geben Sie auf der daraufhin angezeigten Seite **Registrieren einer Anwendung** die Registrierungsinformationen für Ihre Anwendung ein: 
    - Geben Sie im Abschnitt **Name** einen aussagekräftigen Anwendungsnamen ein, der den Benutzern der App angezeigt wird (beispielsweise `Codeausschnittbeispiel für Android Java)`. 
    - Wählen Sie im Abschnitt **Unterstützte Kontotypen** die Option **Konten in allen Organisationsverzeichnissen** aus. 
1. Wählen Sie **Registrieren** aus, um die Anwendung zu erstellen. 
1. Auf der Seite **Übersicht** der App können Sie den **Anwendungs-ID (Client-ID)**-Wert finden und für später notieren. Sie benötigen diesen zum Konfigurieren der Visual Studio-Konfigurationsdatei für dieses Projekt. 
1. Wählen Sie in der Liste mit den Seiten für die App die Option **Manifest** aus, und: 
    - Legen Sie im Manifest-Editor die Eigenschaft ``allowPublicClient`` auf **true** fest. 
    - Wählen Sie in der Leiste oberhalb des Manifest-Editors **Speichern** aus. 
1. Wählen Sie in der Liste mit den Seiten für die App die Option **API-Berechtigungen** aus. 
    - Klicken Sie auf die Schaltfläche **Berechtigung hinzufügen** und dann 
    - Stellen Sie sicher, dass die Registerkarte **Microsoft-APIs** ausgewählt ist. 
    - Klicken Sie im Abschnitt *Häufig verwendete Microsoft-APIs* auf **Microsoft Graph**. 
    - Vergewissern Sie sich, dass im Abschnitt **Delegierte Berechtigungen** die richtigen Berechtigungen aktiviert sind. Verwenden Sie bei Bedarf das Suchfeld.
    - **User.Read**, **Mail.Send**, **Mail.ReadWrite**, **Files.ReadWrite**, **User.ReadBasic.All**, **Calendars.ReadWrite**, **Group.Read.All**  
    - Wählen Sie die Schaltfläche **Berechtigung hinzufügen** aus. 

> **Hinweis:** Unter [Konfigurieren des Projekts](#configure-the-project) werden Sie aufgefordert, einige Zeichenfolgen zu kopieren, die vom Anwendungsregistrierungsportal generiert werden. Verlassen Sie die Seite für die Anwendungsregistrierung nicht, solange das Projekt konfiguriert wird. Die Zeichenfolgen, die Sie aus der Anwendungsregistrierung kopieren, werden in den Quellcode des Projekts eingefügt.

## Konfigurieren des Projekts

1. Laden Sie das [Codeausschnittbeispiel](../../) herunter, oder klonen Sie es.
2. Starten Sie Android Studio.
3. Wählen Sie im Dialogfeld **Willkommen bei Android Studio** die Option **Projekt importieren (Eclipse ADT, Gradle usw.)** aus.
4. Wählen Sie die Datei **settings.gradle** im Ordner **android-java-snippets-sample** aus, und klicken Sie dann auf **OK**.
5. Reagieren Sie auf das Dialogfeld ("Gradle-Synchronisierung: Gradle-Einstellungen für dieses Projekt sind noch nicht konfiguriert. Soll das Projekt den Gradle-Wrapper verwenden?"), indem Sie auf die Schaltfläche **OK** klicken, um den Gradle-Wrapper zu verwenden. 
4. Kopieren Sie von der Seite für die Anwendungsregistrierung, die Sie soeben besucht haben, den benutzerdefinierten Umleitungs-URI (`msal{application id as GUID}`) in die Zwischenablage. **Achten Sie darauf, dass Sie nicht `://auth` kopieren.**
   <br/>Beispiel: `msal0575d7fe-8ec7-4925-9ce2-87074778a039` wird kopiert, und `://auth` wird ignoriert.
4. Fügen Sie den Inhalt der Zwischenablage in Zeile 41 der Datei **app/src/main/AndroidManifest.xml** ein, um `ENTER_YOUR_CLIENT_ID` durch den Inhalt der Zwischenablage zu ersetzen.
4. Fügen Sie den **GUID-Teil** des benutzerdefinierten Umleitungs-URI in Zeile 49 der Datei **app/src/main/AndroidManifest.xml** ein, um `ENTER_YOUR_CLIENT_ID` durch den Inhalt der Zwischenablage zu ersetzen.

## Ausführen des Projekts
Nach dem Erstellen des Projekts können Sie es auf einem Emulator oder Gerät ausführen.

1. Führen Sie das Projekt aus.
2. Klicken Sie für die Anmeldung auf die Schaltfläche **Verbindung mit Microsoft Graph herstellen**.
3. Geben Sie Ihre Anmeldeinformationen ein.
4. Überprüfen und akzeptieren Sie die von der App angeforderten Berechtigungsbereiche.
4. Klicken Sie auf einen Vorgang in der Hauptaktivität, um Vorgangsdetails anzuzeigen.
5. Klicken Sie auf die Schaltfläche **AUSFÜHREN**, um den Vorgang zu starten, und warten Sie, bis der Vorgang abgeschlossen ist.
6. Klicken Sie in das Textfeld für das **Rohobjekt**, um den Inhalt des Felds in die Zwischenablage des Emulators/Geräts zu kopieren.
7. Klicken Sie auf der Symbolleiste auf die Schaltfläche "Zurück", um zur Vorgangsliste zurückzukehren.
8. (Optional) Klicken Sie auf das Überlaufmenü, um die Menüoption zum Trennen aufzurufen.

## Wie sich das Beispiel auf Ihre Mandantendaten auswirkt
In diesem Beispiel werden Befehle ausgeführt, mit denen Daten erstellt, aktualisiert oder gelöscht werden. Wenn Sie Befehle ausführen, die Daten löschen oder bearbeiten, erstellt das Beispiel gefälschte Entitäten. Die gefälschten Entitäten werden gelöscht oder bearbeitet, sodass Ihre tatsächlichen Mandantendaten nicht beeinträchtigt werden. In dem Beispiel werden einige dieser gefälschten Entitäten auf Ihrem Mandanten hinterlassen.

## Grundlegendes zum Code
Das Codeausschnittprojekt verwendet diese Klassen, um Interaktionen mit Microsoft Graph zu verwalten:

### Organisation des Beispielprojekts
Das Codeausschnittprojekt besteht aus zwei Modulen. Dank des modularen Designs können Sie eine neue Anwendung auf Grundlage dieses Beispiels erstellen, indem Sie die Module in die App importieren. Nachdem Sie die Module importiert haben, verwenden Sie den Code im [app](/app)-Modul als ein Beispiel dafür, wie Methoden in den anderen Beispielmodulen aufgerufen werden.

### Module im Codeausschnittprojekt
* [`app`](/app). Die Benutzeroberfläche und das Geschäftslogikmodul. SDK-Vorgänge werden in den Codeausschnittklassen in diesem Modul gestartet.

### Codeausschnittklassen
Ein Codeausschnitt wird in einem einzelnen Vorgang ausgeführt und gibt die Ergebnisse zurück. Codeausschnitte befinden sich im [app](/app)-Modul. Codeausschnitte legen den erforderlichen Status fest, um die Aufrufe in den nachstehend beschriebenen Microsoft Graph-Dienstklassen auszuführen. 
* [`AbstractSnippet`](/app/src/main/java/com/microsoft/graph/snippets/snippet/AbstractSnippet.java)
* [`DrivesSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java)
* [`EventsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java)
* [`GroupsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java)
* [`MeSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java)
* [`MessageSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java)
* [`UsersSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java)

### Authentifizierungsklassen
Die Authentifizierungsmethoden befinden sich in der [`AuthenticationManager`](/app/src/main/java/com/microsoft/graph/snippets/AuthenticationManager.java)-Klasse. Diese Methoden verwenden [Microsoft Authentication Library (MSAL) für Android](https://github.com/AzureAD/microsoft-authentication-library-for-android), um eine Verbindung zu Microsoft Graph herzustellen. 

* [`AuthenticationManager`](/app/src/main/java/com/microsoft/graph/snippets/AuthenticationManager.java). Kapselt neben der App-Autorisierung die Logik für die Benutzerverbindung und -trennung.
 
<a name="contributing"></a>
## Mitwirkung ##

Wenn Sie einen Beitrag zu diesem Beispiel leisten möchten, finden Sie unter [CONTRIBUTING.MD](/CONTRIBUTING.md) weitere Informationen.

In diesem Projekt wurden die [Microsoft Open Source-Verhaltensregeln](https://opensource.microsoft.com/codeofconduct/) übernommen. Weitere Informationen finden Sie unter [Häufig gestellte Fragen zu Verhaltensregeln](https://opensource.microsoft.com/codeofconduct/faq/), oder richten Sie Ihre Fragen oder Kommentare an [opencode@microsoft.com](mailto:opencode@microsoft.com).

## Fragen und Kommentare
Wir schätzen Ihr Feedback hinsichtlich des Codeausschnittbeispiels für das Microsoft Graph-SDK für Android. Sie können uns Ihr Feedback über den Abschnitt [Probleme](../../issues) dieses Repositorys senden. <br/>
Allgemeine Fragen zur Microsoft Graph-Entwicklung sollten in [Stack Overflow](http://stackoverflow.com/questions/tagged/microsoftgraph) gestellt werden. Stellen Sie sicher, dass Ihre Fragen mit \[microsoftgraph] markiert sind.

## Zusätzliche Ressourcen

* [Erste Schritte mit Office 365-APIs, unterstützt von Microsoft Graph](http://dev.office.com/getting-started/office365apis)
* [Microsoft Graph-Übersicht](http://graph.microsoft.io)
* [Microsoft Graph-SDK für Android](../../../msgraph-sdk-android)
* [Connect-Beispiel für Android unter Verwendung des Microsoft Graph-SDK](../../../android-java-connect-sample)

## Versionsverlauf

|Version|Änderungen|
|:---|:----|
|1.0|Erstveröffentlichung|
|1.5|– MSAL-Authentifizierungsbibliothek wurde durch ADAL-Authentifizierungsbibliothek ersetzt <br/> – Microsoft Graph SDK Version 1.5|

Copyright (c) 2019 Microsoft. Alle Rechte vorbehalten.
