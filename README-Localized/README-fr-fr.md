# Exemple d’extraits de code pour Android à l’aide du kit de développement Microsoft Graph

[![BÉtat de création](https://travis-ci.org/microsoftgraph/android-java-snippets-sample.svg?branch=master)](https://travis-ci.org/microsoftgraph/android-java-snippets-sample)

**Sommaire**

* [Configuration requise de l’appareil](#configuration-requise-de-lappareil)
* [Conditions préalables](#conditions-préalables)
* [Inscription de l’application cliente Azure](#inscription-de-lapplication-cliente-azure)
* [Configurer le projet](#configurer-le-projet)
* [Exécuter le projet](#exécuter-le-projet)
* [Impact de l’exemple sur vos données client](#impact-de-lexemple-sur-vos-données-client)
* [Comprendre le code](#comprendre-le-code)
* [Questions et commentaires](#questions-et-commentaires)
* [Ressources supplémentaires](#ressources-supplémentaires)

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
* [Créer un groupe.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L214)
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

##Configuration requise de l’appareil
Pour exécuter le projet d’extraits de code, votre appareil doit remplir les conditions suivantes :
* Une API Android de niveau 16 ou supérieur

###Conditions préalables
Pour utiliser le projet d’extraits de code du kit de développement Microsoft Graph, vous devez disposer des éléments suivants :
* La dernière version d’[Android Studio](http://developer.android.com/sdk/index.html).
* Le système d’automatisation de création [Gradle](http://www.gradle.org).
* Un compte Office 365. Vous pouvez vous inscrire à [Office 365 Developer](https://portal.office.com/Signup/Signup.aspx?OfferId=C69E7747-2566-4897-8CBA-B998ED3BAB88&DL=DEVELOPERPACK&ali=1#0) pour accéder aux ressources dont vous avez besoin pour commencer à créer des applications Office 365.
* [Kit de développement Java (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html).
* Une application Azure enregistrée avec un ID client et une valeur URI de redirection. Voir [Accorder des autorisations à l’application d’extraits de code dans Azure](../../../android-java-snippets-rest-sample/wiki/Grant-permissions-for-the-Snippet-application-in-Azure) pour plus d’informations sur la création des autorisations correctes.

##Inscription de l’application cliente Azure
1. Connectez-vous au [Portail de gestion Azure](https://manage.windowsazure.com) à l’aide de vos informations d’identification Azure AD.
2.  Cliquez sur **Active Directory** dans le menu de gauche, puis sélectionnez le répertoire sur votre client Office 365.
3.  Dans le menu supérieur, cliquez sur **Applications**.
4.  Cliquez sur **Ajouter** dans le menu inférieur.
5.  Sur la page **Que souhaitez-vous faire ?**, cliquez sur **Ajouter une application développée par mon entreprise**.
6.  Dans la page **Parlez-nous de votre application**, indiquez **Exemple d’extrait de code Android** pour le nom de l’application et sélectionnez **APPLICATION CLIENT NATIVE** pour le type.
7.  Cliquez sur le bouton fléché en bas à droite de la page.
8.  Sur la page **Informations sur l’application**, indiquez un **URI de redirection** par exemple `http://localhost/androidsnippets`, puis activez la case à cocher dans le coin inférieur droit de la page.
9.  Une fois l’application ajoutée, vous serez redirigé vers la page **Démarrage rapide** de l’application. Maintenant, vous pouvez sélectionner **Configurer** dans le menu supérieur.
10. Dans la section des autorisations accordées à d’autres applications, ajoutez l’application Microsoft Graph.
11. Pour l’application Microsoft Graph, ajoutez les autorisations suivantes :
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
14. Notez les valeurs indiquées pour **ID client** sur la page **Configurer**. Vous en aurez besoin ultérieurement lors de la configuration du projet.

##Configurer le projet

1. Téléchargez ou clonez l’[exemple d’extraits de code](../../).
2. Démarrez Android Studio.
3. Dans la boîte de dialogue **Bienvenue dans Android Studio**, choisissez **Importer un projet (Eclipse ADT, Gradle, etc.)**.
4. Sélectionnez le fichier **settings.gradle** dans le dossier **android-java-snippets-sample**, puis cliquez sur **OK**.
5. Répondre à la boîte de dialogue (« Synchronisation Gradle : les paramètres de Gradle pour ce projet ne sont pas encore configurés. Voulez-vous que le projet utilise le wrapper Gradle ? » ) en cliquant sur le bouton **OK** pour utiliser le wrapper Gradle. 
6. Ouvrez le fichier ServiceConstants.java dans le package com.microsoft.graph.snippets.
7. Recherchez la chaîne [`CLIENT_ID`](app/src/main/java/com/microsoft/graph/snippets/ServiceConstants.java#L11) et définissez sa valeur sur l’ID client que vous avez enregistré dans Azure.
8. Recherchez la chaîne [`REDIRECT_URI`](app/src/main/java/com/microsoft/graph/snippets/ServiceConstants.java#L10) et définissez sa valeur sur l’URI de redirection que vous avez enregistré dans Azure.

##Exécuter le projet
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

##Impact de l’exemple sur vos données client
Cet exemple exécute des commandes qui permettent de créer, lire, mettre à jour ou supprimer des données. Lorsque vous exécutez des commandes qui suppriment ou modifient des données, l’exemple crée des entités fictives. Les entités fictives sont supprimées ou modifiées de façon à ce que vos données client réelles restent intactes. L’exemple épargne les entités fictives sur votre client.

##Comprendre le code
Le projet d’extraits de code utilise les classes suivantes pour gérer les interactions avec Microsoft Graph :

###Organisation de l’exemple de projet
Le projet d’extraits de code se compose de deux modules. La conception modulaire vous permet de créer une application en fonction de cet exemple en important les modules dans votre application. Une fois que vous avez importé les modules, utilisez le code dans les module [application](/app) des extraits comme un exemple d’appel de méthodes dans d’autres exemples de modules.

###Modules du projet d’extraits
* [`o365-Auth`](/o365-auth). Ce module contient les appels de bibliothèque permettant d’authentifier un utilisateur avec Microsoft Graph.
* [`app`](/app). L’interface utilisateur et le module de logique métier. Les opérations du SDK sont démarrées dans les classes d’extrait de code de ce module.

###Classes d’extrait de code
Un extrait de code exécute une seule opération et renvoie les résultats. Les extraits de code se trouvent dans le module [application](/app). Les extraits définissent l’état requis pour appeler les classes de service Microsoft Graph décrites ci-dessous.
* [`AbstractSnippet`](/app/src/main/java/com/microsoft/graph/snippets/snippet/AbstractSnippet.java)
* [`DrivesSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java)
* [`EventsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java)
* [`GroupsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java)
* [`MeSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java)
* [`MessageSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java)
* [`UsersSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java)

###Classes d’authentification
Les classes d’authentification se trouvent dans le module [o365-Auth](/o365-auth). Ces classes utilisent la bibliothèque [Microsoft Azure Active Directory Library (ADAL) pour Android](https://github.com/AzureAD/azure-activedirectory-library-for-android) pour se connecter à Microsoft Graph. 

* [`AuthenticationManager`](/o365-auth/src/main/java/com/microsoft/graph/auth/AuthenticationManager.java). Encapsule la logique de connexion et de déconnexion utilisateur en plus de l’autorisation de l’application Azure.
* [`AzureADModule`](/o365-auth/src/main/java/com/microsoft/graph/auth/AzureADModule.java). Classe d’assistance de l’authentification. 
* [`AzureAppCompatActivity`](/o365-auth/src/main/java/com/microsoft/graph/auth/AzureAppCompatActivity.java). Assistance de l’injection de dépendance.
 
<a name="contributing"></a>
## Contribution ##

Si vous souhaitez contribuer à cet exemple, voir [CONTRIBUTING.MD](/CONTRIBUTING.md).

Ce projet a adopté le [code de conduite Microsoft Open Source](https://opensource.microsoft.com/codeofconduct/). Pour plus d’informations, reportez-vous à la [FAQ relative au code de conduite](https://opensource.microsoft.com/codeofconduct/faq/) ou contactez [opencode@microsoft.com](mailto:opencode@microsoft.com) pour toute question ou tout commentaire.

## Questions et commentaires
Nous serions ravis de connaître votre opinion sur l’exemple d’extraits du kit de développement logiciel Microsoft Graph pour Android. Vous pouvez nous envoyer vos commentaires via la section [Problèmes](../../issues) de ce référentiel. <br/>
Les questions générales sur le développement de Microsoft Graph doivent être publiées sur [Stack Overflow](http://stackoverflow.com/questions/tagged/microsoftgraph). Veillez à poser vos questions avec la balise [microsoftgraph].

## Ressources supplémentaires

* [Prise en main des API Office 365 fournies par Microsoft Graph](http://dev.office.com/getting-started/office365apis)
* [Présentation de Microsoft Graph](http://graph.microsoft.io)
* [Kit de développement logiciel (SDK) Microsoft Graph pour Android](../../../msgraph-sdk-android)
* [Exemple de connexion d’Android à l’aide du kit de développement Microsoft Graph](../../../android-java-connect-sample)

Copyright (c) 2015 Microsoft. Tous droits réservés.