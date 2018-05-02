# <a name="snippets-sample-for-android-using-the-microsoft-graph-sdk"></a>Exemple d’extraits de code pour Android utilisant le Kit de développement logiciel (SDK) Microsoft Graph
**Version 1.5**

[![État de création](https://travis-ci.org/microsoftgraph/android-java-snippets-sample.svg?branch=master)](https://travis-ci.org/microsoftgraph/android-java-snippets-sample)

**Table des matières**

* [Configuration requise de l’appareil](#device-requirement)
* [Conditions préalables](#prerequisites)
* [Inscription de l’application cliente Azure](#azure-client-application-registration)
* [Configuration du projet](#configure-the-project)
* [Exécution du projet](#run-the-project)
* [Impact de l’exemple sur vos données client](#how-the-sample-affects-your-tenant-data)
* [Présentation du code](#understand-the-code)
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
* [Connaître les groupes auxquels appartient l’utilisateur.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L140)
* [Obtenir la photo de l’utilisateur.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L164)

**Utilisateurs**

* [Extraire les utilisateurs du répertoire de votre client.](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L49)
* [Filtrer les utilisateurs par critères dans le répertoire de votre client.](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L80)
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

* [Obtient le lecteur de l’utilisateur connecté.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L51)
* [Obtient tous les fichiers dans le dossier racine de l’utilisateur.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L83)
* [Crée un fichier dans le dossier racine de l’utilisateur.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L118)
* [Télécharge un fichier à partir du dossier racine de l’utilisateur.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L160)
* [Met à jour le contenu d’un fichier dans le dossier racine de l’utilisateur.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L223)
* [Supprime un fichier dans le dossier racine de l’utilisateur.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L284)
* [Renomme un fichier dans le dossier racine de l’utilisateur.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L337)
* [Crée un dossier sous le dossier racine de l’utilisateur.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L395)

## <a name="device-requirements"></a>Configuration requise de l’appareil
Pour exécuter le projet d’extraits de code, votre appareil doit remplir les conditions suivantes :
* API Android de niveau 21 ou supérieur

## <a name="android-studio-requirements"></a>Configuration requise pour Android Studio
* Outils de build Android pour Gradle 3.1 ou version ultérieure

> **Remarque :** il se peut qu’Android Studio vous invite à installer le référentiel de support Android 47.0.0 ou version ultérieure. La logique du fichier build.gradle du module de projet utilise la méthode `implementation` au lieu de l’ancienne méthode `compile` pour générer les dépendances de module. Ces nouvelles méthodes de génération dépendent du référentiel de support Android 47.0.0 ou version ultérieure.


### <a name="prerequisites"></a>Conditions préalables
Pour utiliser le projet d’extraits de code du kit de développement Microsoft Graph, vous devez disposer des éléments suivants :
* La dernière version d’[Android Studio](http://developer.android.com/sdk/index.html).
* Le système d’automatisation de création [Gradle](http://www.gradle.org).
* Un compte Office 365. Vous pouvez vous inscrire à [Office 365 Developer](https://portal.office.com/Signup/Signup.aspx?OfferId=C69E7747-2566-4897-8CBA-B998ED3BAB88&DL=DEVELOPERPACK&ali=1#0) pour accéder aux ressources dont vous avez besoin pour commencer à créer des applications Office 365.
* [Kit de développement Java (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html).
* Une application Azure enregistrée avec un ID client et une valeur URI de redirection. Voir [Accorder des autorisations à l’application d’extraits de code dans Azure](../../../android-java-snippets-rest-sample/wiki/Grant-permissions-for-the-Snippet-application-in-Azure) pour plus d’informations sur la création des autorisations correctes.

## <a name="azure-client-application-registration"></a>Inscription de l’application cliente Azure


1. Connectez-vous au [portail d’inscription des applications](https://apps.dev.microsoft.com).
3. Cliquez sur le bouton bleu **Ajouter une application** à droite de la page.
4. Attribuez un nom à votre application.
4. _Désactivez_ **Laissez-vous guider pour le démarrage** dans la section **Assistant Installation**.
4. Cliquez sur le bouton bleu **Créer** pour créer l’enregistrement.
5. Cliquez sur le bouton **Ajouter une plateforme**dans la section **Plateformes** et sélectionnez **Application native**.
8. Configurez les autorisations pour votre application : dans la section **Autorisations Microsoft Graph**, cliquez sur le bouton bleu **Ajouter** en regard de **Autorisations déléguées**.
9. Ajoutez les autorisations déléguées suivantes :
   * Activer la connexion et lire le profil utilisateur
   * Disposer d’un accès total à tous les fichiers accessibles par l’utilisateur
   * Avoir un accès total à des calendriers utilisateur
   * Accéder en lecture et en écriture aux courriers électroniques utilisateur 
   * Envoyer un courrier électronique en tant qu’utilisateur
   * Accéder en lecture aux courriers électroniques utilisateur
   * Lire et écrire les données de l’annuaire
   * Lire les profils de base de tous les utilisateurs
   * Lire et écrire tous les groupes
13. Cliquez sur **Enregistrer** dans le menu inférieur.

> **Remarque :** dans [Configurer le projet](#configure-the-project), vous êtes invité à copier des chaînes générées par le portail d’inscription des applications. Veillez à rester sur la page d’inscription des applications pendant que vous configurez le projet. Les chaînes que vous copiez à partir du portail d’inscription des applications sont collées dans le code source du projet.

## <a name="configure-the-project"></a>Configuration du projet

1. Téléchargez ou clonez l’[exemple d’extraits de code](../../).
2. Démarrez Android Studio.
3. Dans la boîte de dialogue **Bienvenue dans Android Studio**, choisissez **Importer un projet (Eclipse ADT, Gradle, etc.)**.
4. Sélectionnez le fichier **settings.gradle** dans le dossier **android-java-snippets-sample**, puis cliquez sur **OK**.
5. Répondre à la boîte de dialogue (« Synchronisation Gradle : les paramètres de Gradle pour ce projet ne sont pas encore configurés. Voulez-vous que le projet utilise le wrapper Gradle ? ») en cliquant sur le bouton **OK** pour utiliser le wrapper Gradle. 
4. Sur la page d’inscription des applications, copiez l’URI de redirection personnalisé (`msal{application id as GUID}`) dans le presse-papiers. **Vérifiez que vous ne copiez pas `://auth`**.
   <br/>Par exemple, `msal0575d7fe-8ec7-4925-9ce2-87074778a039` est copié et `://auth` est ignoré.
4. Collez le contenu du presse-papiers sur la ligne 42 du fichier **app/src/main/AndroidManifest.xml** pour remplacer `ENTER_YOUR_CLIENT_ID`.
4. Copiez la **partie GUID** de l’URI de redirection personnalisé sur la ligne 51 du fichier **app/src/main/AndroidManifest.xml** pour remplacer `ENTER_YOUR_CLIENT_ID`.

## <a name="run-the-project"></a>Exécution du projet
Une fois le projet créé, vous pouvez l’exécuter sur un émulateur ou sur un appareil.

1. Exécutez le projet.
2. Cliquez sur le bouton **Connexion à Microsoft Graph** pour vous connecter.
3. Entrez vos informations d’identification.
4. Lisez et acceptez les étendues d’autorisations requises par l’application.
4. Cliquez sur une opération dans l’activité principale pour afficher les détails de l’opération.
5. Cliquez sur le bouton **EXÉCUTER** pour démarrer l’opération et attendez que l’opération se termine.
6. Cliquez dans la zone de texte **Objet brut** pour copier le contenu d’une zone dans le Presse-papiers de l’émulateur/appareil.
7. Cliquez sur le bouton Précédent dans la barre d’outils pour revenir à la liste des opérations.
8. (Facultatif) Cliquez sur le menu de dépassement de capacité pour obtenir l’option de menu Déconnecter.

## <a name="how-the-sample-affects-your-tenant-data"></a>Impact de l’exemple sur vos données client
Cet exemple exécute des commandes qui permettent de créer, lire, mettre à jour ou supprimer des données. Lorsque vous exécutez des commandes qui suppriment ou modifient des données, l’exemple crée des entités fictives. Les entités fictives sont supprimées ou modifiées de façon à ce que vos données client réelles restent intactes. L’exemple épargne les entités fictives sur votre client.

## <a name="understand-the-code"></a>Comprendre le code
Le projet d’extraits de code utilise les classes suivantes pour gérer les interactions avec Microsoft Graph :

### <a name="sample-project-organization"></a>Organisation de l’exemple de projet
Le projet d’extraits de code se compose de deux modules. La conception modulaire vous permet de créer une application en fonction de cet exemple en important les modules dans votre application. Une fois que vous avez importé les modules, utilisez le code dans les module [application](/app) des extraits comme un exemple d’appel de méthodes dans d’autres exemples de modules.

### <a name="modules-in-the-snippets-project"></a>Modules du projet d’extraits
* [`app`](/app). Interface utilisateur et module de logique métier. Les opérations du Kit de développement logiciel (SDK) sont démarrées dans les classes d’extraits de code de ce module.

### <a name="snippet-classes"></a>Classes d’extraits de code
Un extrait de code exécute une seule opération et renvoie les résultats. Les extraits de code se trouvent dans le module [application](/app). Les extraits définissent l’état requis pour appeler les classes de service Microsoft Graph décrites ci-dessous.
* [`AbstractSnippet`](/app/src/main/java/com/microsoft/graph/snippets/snippet/AbstractSnippet.java)
* [`DrivesSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java)
* [`EventsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java)
* [`GroupsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java)
* [`MeSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java)
* [`MessageSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java)
* [`UsersSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java)

### <a name="authentication-classes"></a>Classes d’authentification
Les méthodes d’authentification se trouvent dans la classe [`AuthenticationManager`](/app/src/main/java/com/microsoft/graph/snippets/AuthenticationManager.java). Ces méthodes utilisent la [bibliothèque d’authentification Microsoft (MSAL) pour Android](https://github.com/AzureAD/microsoft-authentication-library-for-android) pour la connexion à Microsoft Graph. 

* [`AuthenticationManager`](/app/src/main/java/com/microsoft/graph/snippets/AuthenticationManager.java). Encapsule la logique de connexion et de déconnexion utilisateur en plus de l’autorisation de l’application.
 
<a name="contributing"></a>
## <a name="contributing"></a>Contribution ##

Si vous souhaitez contribuer à cet exemple, voir [CONTRIBUTING.MD](/CONTRIBUTING.md).

Ce projet a adopté le [code de conduite Microsoft Open Source](https://opensource.microsoft.com/codeofconduct/). Pour plus d’informations, reportez-vous à la [FAQ relative au code de conduite](https://opensource.microsoft.com/codeofconduct/faq/) ou contactez [opencode@microsoft.com](mailto:opencode@microsoft.com) pour toute question ou tout commentaire.

## <a name="questions-and-comments"></a>Questions et commentaires
Nous serions ravis de connaître votre opinion sur l’exemple d’extraits du kit de développement logiciel Microsoft Graph pour Android. Vous pouvez nous envoyer vos commentaires via la section [Problèmes](../../issues) de ce référentiel. <br/> Les questions générales sur le développement de Microsoft Graph doivent être publiées sur [Stack Overflow](http://stackoverflow.com/questions/tagged/microsoftgraph). Veillez à poser vos questions en utilisant le tag [microsoftgraph].

## <a name="additional-resources"></a>Ressources supplémentaires

* [Prise en main des API Office 365 fournies par Microsoft Graph](http://dev.office.com/getting-started/office365apis)
* [Présentation de Microsoft Graph](http://graph.microsoft.io)
* [Kit de développement logiciel (SDK) Microsoft Graph pour Android](../../../msgraph-sdk-android)
* [Exemple de connexion d’Android à l’aide du Kit de développement logiciel (SDK) Microsoft Graph](../../../android-java-connect-sample)

## <a name="version-history"></a>Historique des versions

|Version|Modifications|
|:---|:----|
|1.0|Version initiale|
|1,5|- La bibliothèque d’authentification MSAL a remplacé la bibliothèque d’authentification ADAL <br/> - Kit de développement logiciel (SDK) Microsoft Graph version 1.5|

Copyright (c) 2015 Microsoft. Tous droits réservés.
