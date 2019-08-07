# Exemple d’extraits de code pour Android utilisant le Kit de développement logiciel (SDK) Microsoft Graph
**Version 1.5**

[![État de création](https://travis-ci.org/microsoftgraph/android-java-snippets-sample.svg?branch=master)](https://travis-ci.org/microsoftgraph/android-java-snippets-sample)

**Sommaire**

* [Configuration requise de l’appareil](#device-requirement)
* [Conditions préalables](#prerequisites)
* [Inscription de l’application cliente Azure](#azure-client-application-registration)
* [Configurer le projet](#configure-the-project)
* [Exécuter le projet](#run-the-project)
* [Impact de l’exemple sur vos données client](#how-the-sample-affects-your-tenant-data)
* [Comprendre le code](#understand-the-code)
* [Questions et commentaires](#questions-and-comments)
* [Ressources supplémentaires](#additional-resources)
* [Historique des versions](#version-history)

Vous souhaitez créer des applications originales qui aident les utilisateurs à exploiter leurs données Office 365 ? Explorez, découvrez et comprenez le kit de développement Microsoft Graph à l’aide de cet exemple d’extraits de code. Cet exemple vous montre comment accéder à plusieurs ressources, notamment Microsoft Azure Active Directory et Office 365, en effectuant des appels vers le kit de développement Microsoft Graph dans une application Android.

Vous pouvez explorer les opérations suivantes dans Microsoft Graph :

**Moi**

* [Obtenir des informations sur l’utilisateur connecté.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L44)
* [Obtenir les responsabilités de l’utilisateur.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L67)
* [Connaître le responsable de l’utilisateur.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L94)
* [Connaître les collaborateurs directs de l’utilisateur.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L117)
* [Connaître l’appartenance au groupe de l’utilisateur.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L140)
* [Obtenir la photo de l’utilisateur.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L164)

**Utilisateurs**

* [Extraire les utilisateurs du répertoire de votre client.](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L49)
* [Filtrer les utilisateurs en fonction des critères du répertoire de votre client.](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L80)
* [Créer un utilisateur.](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L113)

**Événements**

* [Obtenir les événements de l’utilisateur connecté.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L51)
* [Créer un événement pour l’utilisateur.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L83)
* [Mettre à jour l’événement d’un utilisateur.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L118)
* [Supprimer l’événement d’un utilisateur.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L170)

**Messages**

* [Obtenir les messages de l’utilisateur.](app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java#L51)
* [Envoyer un message à partir de la boîte aux lettres de l’utilisateur.](app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java#L82)

**Groupes**

* [Obtenir tous les groupes du répertoire de votre client.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L184)
* [Créer un groupe.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L191)
* [Obtenir des informations relatives à un groupe spécifique dans le client.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L45)
* [Supprimer un groupe.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L248)
* [Connaître les membres d’un groupe.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L90)
* [Connaître les propriétaires d’un groupe.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L137)

**Lecteurs**

* [Obtenir le lecteur de l’utilisateur connecté.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L51)
* [Obtenir tous les fichiers dans le dossier racine de l’utilisateur.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L83)
* [Créer un fichier dans le dossier racine de l’utilisateur.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L118)
* [Télécharger un fichier à partir du dossier racine de l’utilisateur.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L160)
* [Mettre à jour le contenu d’un fichier dans le dossier racine de l’utilisateur.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L223)
* [Supprimer un fichier dans le dossier racine de l’utilisateur.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L284)
* [Renommer un fichier dans le dossier racine de l’utilisateur.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L337)
* [Créer un dossier sous le dossier racine de l’utilisateur.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L395)

## Configuration requise de l’appareil
Pour exécuter le projet d’extraits de code, votre appareil doit remplir les conditions suivantes : * API Android de niveau 21 ou supérieur

## Configuration requise pour Android Studio
* Outils de build Android pour Gradle 3.1 ou version ultérieure

> **Remarque :** Il se peut que Android Studio vous invite à installer le référentiel de support Android 47.0.0 ou version ultérieure. La logique du fichier build.gradle du module de projet utilise la méthode `implémentation` au lieu de l’ancienne méthode `compilation` pour générer les dépendances de module. Ces nouvelles méthodes de génération dépendent du référentiel de support Android 47.0.0 ou version ultérieure.


### Conditions préalables
Pour utiliser le projet d’extraits de code SDK Microsoft Graph, vous devez disposer des éléments suivants : * la dernière version de [Studio Android](http://developer.android.com/sdk/index.html). * le système d’automatisation de la création [Gradle](http://www.gradle.org). * un compte Office 365. Vous pouvez prendre un [abonnement Office 365 Développeur](https://portal.office.com/Signup/Signup.aspx?OfferId=C69E7747-2566-4897-8CBA-B998ED3BAB88&DL=DEVELOPERPACK&ali=1#0) qui inclut les ressources nécessaires pour créer des applications Office 365\. * [Kit de développement Java (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html). * application Azure ouverte avec un ID client et valeur URI de redirection. Voir [Accorder des autorisations à l’application d’extraits de code dans Azure](../../../android-java-snippets-rest-sample/wiki/Grant-permissions-for-the-Snippet-application-in-Azure) pour plus d’informations sur la création des autorisations correctes.

## Inscription de l’application cliente Azure

1. Accédez à la page [portail Azure – Inscriptions d’applications](https://go.microsoft.com/fwlink/?linkid=2083908). 
1. Sélectionnez **Nouvelle inscription**. 
1. Lorsque **la page Inscrire une application** s’affiche, saisissez les informations d’inscription de votre application : 
    - Dans la section **Nom**, saisissez un nom d’application cohérent qui s’affichera pour les utilisateurs de l’application, par exemple `Echantillon d’extraits de code Java Android`. 
    - Dans la section **Types de comptes pris en charge**, sélectionnez **Comptes dans un annuaire organisationnel**. 
1. Sélectionnez **S’inscrire** pour créer l’application. 
1. Sur la page de l’application **Vue d’ensemble**, notez la **valeur ID d’application (client)** et gardez la pour plus tard. Vous en aurez besoin pour paramétrer le fichier de configuration de Visual Studio pour ce projet. 
1. Dans la liste des pages de l’application, sélectionnez **Manifeste**, puis : 
    - Dans l’éditeur de manifeste, attribuez la valeur **Vrai** à la propriété ``allowPublicClient`` 
    - Sélectionnez **Enregistrer** dans la barre au-dessus de l’éditeur de manifeste. 
1. Dans la liste des pages de l’application, sélectionnez **Permissions API**. 
    - Cliquez sur le bouton **Ajouter une autorisation** puis, 
    - Vérifiez que l'onglet **API Microsoft** est sélectionné 
    - Dans la section *API Microsoft couramment utilisées*, cliquez sur **Microsoft Graph** 
    - Dans la section **Autorisations déléguées**, assurez-vous que les autorisations appropriées sont vérifiées. Utilisez la zone de recherche, le cas échéant.
    - **User.Read**, **Mail.Send**, **Mail.ReadWrite**, **Files.ReadWrite**, **User.ReadBasic.All**, **Calendars.ReadWrite**, **Group.Read.All**  
    - Cliquez sur le bouton **Ajouter des autorisations** 

> **Remarque :** Dans [Configurer le projet](#configure-the-project), vous êtes invité à copier des chaînes générées par le portail d’inscription des applications. Veillez à rester sur la page d’inscription des applications pendant que vous configurez le projet. Les chaînes que vous copiez à partir du portail d’inscription des applications sont collées dans le code source du projet.

## Configurer le projet

1. Téléchargez ou clonez [l’exemple d’extraits de code](../../).
2. Démarrez Android Studio.
3. Dans la boîte de dialogue **Bienvenue dans Android Studio**, choisissez **Importer un projet (Eclipse ADT, Gradle, etc.)**.
4. Sélectionnez le fichier **settings.gradle** dans le dossier **android-java-snippets-sample**, puis cliquez sur **OK**.
5. Répondre à la boîte de dialogue (« Synchronisation Gradle : les paramètres de Gradle pour ce projet ne sont pas encore configurés. Voulez-vous que le projet utilise le wrapper Gradle ? ») en cliquant sur le bouton **OK** pour utiliser le wrapper Gradle. 
4. Sur la page d’inscription des applications, copiez l’URI de redirection personnalisé (`msal{application id as GUID}`) dans le presse-papiers. **Veillez à ne pas copier `://auth`**
   <br/>Par exemple : `msal0575d7fe-8ec7-4925-9ce2-87074778a039` est copié et `://auth` est ignoré.
4. Collez le contenu du presse-papiers sur la ligne 41 du fichier **app/src/main/AndroidManifest.xml**, pour remplacer `ENTER_YOUR_CLIENT_ID`.
4. Copiez la **partie GUID** de l’URI de redirection personnalisé sur la ligne 49 du fichier **app/src/main/AndroidManifest.xml** pour remplacer `ENTER_YOUR_CLIENT_ID` par le contenu du presse-papiers.

## Exécuter le projet
Une fois le projet créé, vous pouvez l’exécuter sur un émulateur ou sur un appareil.

1. Exécuter le projet.
2. Cliquez sur le bouton **Connexion à Microsoft Graph** pour vous connecter.
3. Entrez vos informations d’identification.
4. Lisez et acceptez les étendues d’autorisations requises par l’application.
4. Cliquez sur une opération dans l’activité principale pour afficher les détails de l’opération.
5. Cliquez sur le bouton **EXÉCUTER** pour démarrer l’opération et attendez qu’elle se termine.
6. Cliquez dans la zone de texte **Objet brut** pour copier le contenu d’une zone dans le presse-papiers de l’émulateur/appareil.
7. Cliquez sur le bouton Précédent dans la barre d’outils pour revenir à la liste des opérations.
8. (Facultatif) Cliquez sur le menu de dépassement de capacité pour obtenir l’option de menu Déconnecter.

## Impact de l’exemple sur vos données client
Cet exemple exécute des commandes qui permettent de créer, lire, mettre à jour ou supprimer des données. Lorsque vous exécutez des commandes qui suppriment ou modifient des données, l’exemple crée des entités fictives. Les entités fictives sont supprimées ou modifiées de façon à ce que vos données client réelles restent intactes. L’exemple épargne les entités fictives sur votre client.

## Comprendre le code
Le projet d’extraits de code utilise les classes suivantes pour gérer les interactions avec Microsoft Graph :

### Organisation de l’exemple de projet
Le projet d’extraits de code se compose de deux modules. La conception modulaire vous permet de créer une application en fonction de cet exemple en important les modules dans votre application. Une fois que vous avez importé les modules, utilisez le code dans le module [application](/app) des extraits comme un exemple d’appel de méthodes dans d’autres exemples de modules.

### Modules du projet d’extraits
* [`Application`](/app). L’interface utilisateur et le module de logique métier. Les opérations du SDK sont démarrées dans les classes d’extrait de code de ce module.

### Classes d’extrait de code
Un extrait de code exécute une seule opération et renvoie les résultats. Les extraits de code se trouvent dans le module [application](/app). Les extraits de code définissent l’état nécessaire pour effectuer les appels sur les classes de service Microsoft Graph décrites ci-dessous.
* [`AbstractSnippet`](/app/src/main/java/com/microsoft/graph/snippets/snippet/AbstractSnippet.java)
* [`DrivesSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java)
* [`EventsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java)
* [`GroupsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java)
* [`MeSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java)
* [`MessageSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java)
* [`UsersSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java)

### Classes d’authentification
Les méthodes d’authentification se trouvent dans la classe [`AuthenticationManager`](/app/src/main/java/com/microsoft/graph/snippets/AuthenticationManager.java). Ces méthodes utilisent la [bibliothèque d’authentification Microsoft (MSAL) pour Android](https://github.com/AzureAD/microsoft-authentication-library-for-android) pour la connexion à Microsoft Graph. 

* [`AuthenticationManager`](/app/src/main/java/com/microsoft/graph/snippets/AuthenticationManager.java). Encapsule la logique de connexion et de déconnexion utilisateur en plus de l’autorisation de l’application.
 
<a name="contributing"></a>
## Contribution ##

Si vous souhaitez contribuer à cet exemple, voir [CONTRIBUTING.MD](/CONTRIBUTING.md).

Ce projet a adopté le [code de conduite Open Source de Microsoft](https://opensource.microsoft.com/codeofconduct/). Pour en savoir plus, reportez-vous à la [FAQ relative au code de conduite](https://opensource.microsoft.com/codeofconduct/faq/) ou contactez [opencode@microsoft.com](mailto:opencode@microsoft.com) pour toute question ou tout commentaire.

## Questions et commentaires
Nous serions ravis de connaître votre opinion sur l’exemple d’extraits du kit de développement logiciel Microsoft Graph pour Android. Vous pouvez nous envoyer vos commentaires via la section [Problèmes](../../issues) de ce référentiel. <br/>
Les questions générales sur le développement de Microsoft Graph doivent être publiées sur [Stack Overflow](http://stackoverflow.com/questions/tagged/microsoftgraph). Veillez à poser vos questions avec la balise \[microsoftgraph].

## Ressources supplémentaires

* [Prise en main des API Office 365 fournies par Microsoft Graph](http://dev.office.com/getting-started/office365apis)
* [Présentation de Microsoft Graph](http://graph.microsoft.io)
* [Kit de développement logiciel (SDK) Microsoft Graph pour Android](../../../msgraph-sdk-android)
* [Exemple de connexion d’Android à l’aide du kit de développement Microsoft Graph](../../../android-java-connect-sample)

## Historique des versions

| Version | Modifications |
|:---|:----|
| 1.0 | Publication initiale |
| 1.5 | –La bibliothèque d’authentification MSAL a remplacé la bibliothèque d’authentification ADAL <br/> – Kit de développement logiciel (SDK) Microsoft Graph version 1.5|

Copyright (c) 2019 Microsoft. Tous droits réservés.
