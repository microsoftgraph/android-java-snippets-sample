# Ejemplo de fragmentos de código para Android con SDK de Microsoft Graph
**Versión 1.5**

[![Estado de compilación](https://travis-ci.org/microsoftgraph/android-java-snippets-sample.svg?branch=master)](https://travis-ci.org/microsoftgraph/android-java-snippets-sample)

**Tabla de contenido**

* [Requisito del dispositivo](#device-requirement)
* [Requisitos previos](#prerequisites)
* [Registro de aplicación de cliente de Azure](#azure-client-application-registration)
* [Configurar el proyecto](#configure-the-project)
* [Ejecutar el proyecto](#run-the-project)
* [Repercusión del ejemplo en los datos del inquilino](#how-the-sample-affects-your-tenant-data)
* [Entender el código](#understand-the-code)
* [Preguntas y comentarios](#questions-and-comments)
* [Recursos adicionales](#additional-resources)
* [Historial de versiones](#version-history)

¿Quiere crear aplicaciones interesantes que ayuden a los usuarios a trabajar con sus datos de Office 365? Explore, aprenda y comprenda el SDK de Microsoft Graph mediante el uso de este ejemplo de fragmentos de código. Este ejemplo muestra cómo acceder a varios recursos, incluido Microsoft Azure Active Directory (AD) y Office 365, realizando llamadas al SDK de Microsoft Graph en una aplicación de Android.

Puede explorar las siguientes operaciones de Microsoft Graph:

**Me**

* [Obtener información sobre el usuario con sesión iniciada.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L44)
* [Obtener las responsabilidades del usuario.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L67)
* [Obtener el administrador del usuario.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L94)
* [Obtener informes directos del usuario.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L117)
* [Obtener la pertenencia a grupos del usuario.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L140)
* [Obtener la foto del usuario.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L164)

**Users**

* [Obtener usuarios del directorio de inquilino.](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L49)
* [Obtener los usuarios filtrados mediante los criterios del directorio del inquilino.](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L80)
* [Crear un usuario.](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L113)

**Events**

* [Obtener los eventos del usuario con sesión iniciada.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L51)
* [Crear un nuevo evento para el usuario.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L83)
* [Actualizar el evento de un usuario.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L118)
* [Eliminar el evento de un usuario.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L170)

**Messages**

* [Obtener mensajes de usuario.](app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java#L51)
* [Enviar un mensaje desde el buzón del usuario.](app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java#L82)

**Groups**

* [Obtener todos los grupos en el directorio del inquilino.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L184)
* [Crear un grupo.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L191)
* [Obtener información sobre un grupo específico en el inquilino.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L45)
* [Eliminar un grupo.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L248)
* [Obtener los miembros de un grupo.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L90)
* [Obtener los propietarios de un grupo.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L137)

**Drives**

* [Obtener la unidad del usuario con sesión iniciada.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L51)
* [Obtener todos los archivos en la carpeta raíz del usuario.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L83)
* [Crear un nuevo archivo en la carpeta raíz del usuario.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L118)
* [Descargar un archivo desde la carpeta raíz del usuario.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L160)
* [Actualizar el contenido de un archivo en la carpeta raíz del usuario.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L223)
* [Eliminar un archivo en la carpeta raíz del usuario.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L284)
* [Cambiar el nombre de un archivo en la carpeta raíz del usuario.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L337)
* [Crear una carpeta en la carpeta raíz del usuario.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L395)

## Requisitos del dispositivo
Para ejecutar el proyecto de fragmentos de código, el dispositivo debe cumplir los siguientes requisitos: \*Nivel 21 de la API de Android o posterior

## Requisitos de Android Studio
* Herramientas de compilación de Android para Gradle 3.1 +

> **Nota:** Android Studio puede pedirle que instale el repositorio de soporte de Android 47.0.0+. La lógica del archivo build.gradle del módulo del proyecto usa el método `implementation` en lugar del método antiguo `compile` para crear las dependencias de módulo. Estos nuevos métodos de compilación dependen del repositorio de soporte de Android 47.0.0 o posterior.


### Requisitos previos
Para usar el proyecto de fragmentos de código del SDK de Microsoft Graph, necesita lo siguiente: * La última versión de [Android Studio](http://developer.android.com/sdk/index.html). * El sistema de automatización de compilación [Gradle](http://www.gradle.org). * Una cuenta de Office 365. Puede realizar [una suscripción a Office 365 Developer](https://portal.office.com/Signup/Signup.aspx?OfferId=C69E7747-2566-4897-8CBA-B998ED3BAB88&DL=DEVELOPERPACK&ali=1#0) que incluye los recursos que necesita para empezar a crear aplicaciones de Office 365\. * [El kit de desarrollo de Java (JDK) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html). * Una aplicación de Azure registrada con un Id. de cliente y el valor URI de redireccionamiento. Vea [Conceder permisos a la aplicación de fragmentos de código en Azure](../../../android-java-snippets-rest-sample/wiki/Grant-permissions-for-the-Snippet-application-in-Azure) para obtener más información sobre cómo crear los permisos correctos.

## Registro de aplicación de cliente de Azure

1. Vaya a la página [Azure Portal: registros de aplicaciones](https://go.microsoft.com/fwlink/?linkid=2083908). 
1. Seleccione **Nuevo registro**. 
1. Cuando aparezca la **página Registrar una aplicación**, escriba la información de registro de la aplicación: 
    - En la sección **Nombre**, escriba un nombre significativo para la aplicación, que se mostrará a los usuarios de la aplicación, por ejemplo, `Ejemplo de fragmentos de código de Java para Android`. 
    - En la sección **Tipos de cuentas compatibles**, seleccione **Cuentas en cualquier directorio de la organización**. 
1. Seleccione **Registrar** para crear la aplicación. 
1. En la página **Información general** de la aplicación, busque el valor **Id. de la aplicación (cliente)** y guárdelo para más tarde. Lo necesitará para configurar el archivo de configuración de Visual Studio para este proyecto. 
1. En la lista de páginas de la aplicación, seleccione **Manifiesto** y haga lo siguiente: 
    - En el editor de manifiestos, establezca la propiedad ``allowPublicClient`` como **true**. 
    - Seleccione **Guardar** en la barra sobre el editor de manifiestos. 
1. En la lista de páginas de la aplicación, seleccione **Permisos de API**. 
    - Haga clic en el botón **Agregar un permiso**. 
    - Asegúrese de que la pestaña de las **API de Microsoft** está seleccionada. 
    - En la sección *API de Microsoft más usadas*, haga clic en **Microsoft Graph**. 
    - En la sección **Permisos delegados**, asegúrese de que los permisos adecuados estén marcados. Si es necesario, use el cuadro de búsqueda.
    - **User.Read**, **Mail.Send**, **Mail.ReadWrite**, **Files.ReadWrite**, **User.ReadBasic.All**, **Calendars.ReadWrite**, **Group.Read.All**  
    - Seleccione el botón **Agregar permisos**. 

> **Nota:** En [Configurar el proyecto](#configure-the-project), se le pedirá copiar algunas cadenas generadas por el portal de registro de la aplicación. Asegúrese de estar en la página de registro de la aplicación mientras configure el proyecto. Las cadenas que copia desde el registro de la aplicación se pegarán en el código fuente del proyecto.

## Configurar el proyecto

1. Descargue o clone el [ejemplo de los fragmentos de código](../../).
2. Inicie Android Studio.
3. Desde el cuadro de diálogo **Bienvenido a Android Studio**, seleccione **Importar proyecto (Eclipse ADT, Gradle, etc)**.
4. Seleccione el archivo **settings.gradle** en la carpeta **android-java-snippets-sample** y haga clic en **Aceptar**.
5. Responda al cuadro de diálogo ("Sincronización de Gradle: La configuración de Gradle para este proyecto no se ha realizado todavía. ¿Quiere que el proyecto utilice el contenedor de Gradle? ") haciendo clic en el botón **Aceptar** para utilizar el contenedor de Gradle. 
4. En la página de registro de la aplicación que acaba de visitar, copie el URI de redirección personalizado (`msal{application id as GUID}`) en el portapapeles. **Asegúrese de no copiar `://auth`**
   <br/>Por ejemplo: se copia `msal0575d7fe-8ec7-4925-9ce2-87074778a039` y se ignora `://auth`.
4. Pegue el contenido del portapapeles en **app/src/main/AndroidManifest.xml**, línea 41 para reemplazar `ESCRIBIR_ID_CLIENTE` con el contenido del portapapeles.
4. Copie la **porción GUID** del URI de redirección personalizado en **app/src/main/AndroidManifest.xml**, línea 49 para reemplazar `ESCRIBIR_ID_CLIENTE` con el contenido del portapapeles.

## Ejecutar el proyecto
Una vez creado el proyecto, puede ejecutarlo en un emulador o en un dispositivo.

1. Ejecute el proyecto.
2. Haga clic en el botón **Conectarse a Microsoft Graph** para iniciar sesión.
3. Escriba sus credenciales.
4. Revise y acepte los ámbitos de permiso solicitados por la aplicación.
4. Haga clic en una operación en la actividad principal para mostrar los detalles de la operación.
5. Haga clic en el botón **EJECUTAR** para iniciar la operación y esperar a que termine.
6. Haga clic en el cuadro de texto **Objeto sin procesar** para copiar el contenido del cuadro en el portapapeles del dispositivo o emulador.
7. Haga clic en el botón Atrás en la barra de herramientas para volver a la lista de operaciones.
8. (Opcional) Haga clic en el menú de desbordamiento para obtener la opción de menú Desconectar.

## Repercusión de la muestra en los datos del inquilino
Este ejemplo ejecuta comandos que crean, leen, actualizan o eliminan datos. Cuando ejecuta comandos que eliminan o modifican datos, el ejemplo crea entidades falsas. Las entidades falsas se eliminan o editan, por lo que los datos reales de inquilinos no se ven afectados. El ejemplo dejará atrás algunas de entidades falsas de su inquilino.

## Entender el código
El proyecto de fragmentos de código usa estas clases para administrar interacciones con Microsoft Graph:

### Organización del proyecto del ejemplo
El proyecto de fragmentos de código se compone de dos módulos. El diseño modular permite crear una nueva aplicación basada en este ejemplo importando los módulos a su aplicación. Una vez haya importado los módulos, use el código en el módulo de la [aplicación](/app) de fragmentos de código como un ejemplo de cómo llamar métodos en los otros módulos de ejemplo.

### Módulos del proyecto de fragmentos de código
* [`Aplicación`](/app). La IU y el módulo de lógica empresarial. Las operaciones de SDK se inician en las clases de fragmentos de código en este módulo.

### Clases de fragmento de código
Un fragmento de código ejecuta una única operación y devuelve los resultados. Los fragmentos de código se encuentran en el módulo de la [aplicación](/app). Los fragmentos de código configuran el estado necesario para realizar las llamadas en las clases de servicio de Microsoft Graph que se describen a continuación.
* [`AbstractSnippet`](/app/src/main/java/com/microsoft/graph/snippets/snippet/AbstractSnippet.java)
* [`DrivesSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java)
* [`EventsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java)
* [`GroupsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java)
* [`MeSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java)
* [`MessageSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java)
* [`UsersSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java)

### Clases de autenticación
Los métodos de autenticación se encuentran en la clase [`AuthenticationManager`](/app/src/main/java/com/microsoft/graph/snippets/AuthenticationManager.java). Estos métodos usan la [biblioteca de autenticación de Microsoft (MSAL) para Android](https://github.com/AzureAD/microsoft-authentication-library-for-android) para conectarse a Microsoft Graph. 

* [`AuthenticationManager`](/app/src/main/java/com/microsoft/graph/snippets/AuthenticationManager.java). Encapsula la lógica de conexión y desconexión del usuario, además de la autorización de la aplicación.
 
<a name="contributing"></a>
## Colaboradores ##

Si le gustaría contribuir a este ejemplo, vea [CONTRIBUTING.MD](/CONTRIBUTING.md).

Este proyecto ha adoptado el [Código de conducta de código abierto de Microsoft](https://opensource.microsoft.com/codeofconduct/). Para obtener más información, vea [Preguntas frecuentes sobre el código de conducta](https://opensource.microsoft.com/codeofconduct/faq/) o póngase en contacto con [opencode@microsoft.com](mailto:opencode@microsoft.com) si tiene otras preguntas o comentarios.

## Preguntas y comentarios
Nos encantaría recibir sus comentarios sobre el ejemplo de fragmentos de código del SDK de Microsoft Graph para Android. Puede enviarnos comentarios a través de la sección [Problemas](../../issues) de este repositorio. <br/>
Las preguntas generales sobre el desarrollo de Microsoft Graph deben publicarse en [Stack Overflow](http://stackoverflow.com/questions/tagged/microsoftgraph). Asegúrese de que sus preguntas se etiquetan con \[microsoftgraph].

## Recursos adicionales

* [Introducción a las API de Office 365 con tecnología de Microsoft Graph](http://dev.office.com/getting-started/office365apis)
* [Información general de Microsoft Graph](http://graph.microsoft.io)
* [SDK de Microsoft Graph para Android](../../../msgraph-sdk-android)
* [Ejemplo de Connect para Android con SDK de Microsoft Graph](../../../android-java-connect-sample)

## Historial de versiones

| Versión | Cambios |
|:---|:----|
| 1.0 | Lanzamiento inicial |
| 1.5 |- La biblioteca de autenticación MSAL reemplazó a la biblioteca de autenticación ADAL <br/> \- Versión 1.5 del SDK de Microsoft Graph

Copyright (c) 2019 Microsoft. Todos los derechos reservados.
