# Exemplo de trechos de código para Android usando o SDK do Microsoft Graph
**Versão 1.5**

[![Status da Compilação](https://travis-ci.org/microsoftgraph/android-java-snippets-sample.svg?branch=master)](https://travis-ci.org/microsoftgraph/android-java-snippets-sample)

**Sumário**

* [Requisito do dispositivo](#device-requirement)
* [Pré-requisitos](#prerequisites)
* [Registro de aplicativo do cliente do Azure](#azure-client-application-registration)
* [Configurar o projeto](#configure-the-project)
* [Executar o projeto](#run-the-project)
* [Como o exemplo afeta os dados do locatário](#how-the-sample-affects-your-tenant-data)
* [Compreender o código](#understand-the-code)
* [Perguntas e comentários](#questions-and-comments)
* [Recursos adicionais](#additional-resources)
* [Histórico de versão](#version-history)

Deseja desenvolver aplicativos interessantes que ajudem as pessoas a trabalhar com os seus próprios dados do Office 365? Explore, aprenda e entenda o SDK do Microsoft Graph usando este exemplo de Trechos de Código. Este exemplo mostra como acessar vários recursos, incluindo o Microsoft Azure Active Directory e o Office 365, fazendo chamadas para o SDK do Microsoft Graph em um aplicativo Android.

Você pode explorar as seguintes operações no Microsoft Graph:

**Eu**

* [Obter informações sobre o usuário conectado.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L44)
* [Obter as responsabilidades do usuário.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L67)
* [Obter o gerente de usuário.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L94)
* [Obter relatórios diretos do usuário.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L117)
* [Obter a associação de grupo do usuário](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L140)
* [Obter a foto do usuário.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L164)

**Usuários**

* [Obter os usuários do diretório do locatário.](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L49)
* [Obter usuários filtrados por critérios do diretório do locatário.](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L80)
* [Criar um novo usuário.](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L113)

**Eventos**

* [Obter eventos do usuário conectado.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L51)
* [Criar um novo evento para o usuário.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L83)
* [Atualizar o evento de um usuário.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L118)
* [Excluir o evento de um usuário.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L170)

**Mensagens**

* [Obter mensagens do usuário.](app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java#L51)
* [Enviar uma mensagem da caixa de correio do usuário.](app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java#L82)

**Grupos**

* [Obter todos os grupos no diretório do locatário.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L184)
* [Criar um novo grupo.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L191)
* [Obter informações sobre um grupo específico no locatário.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L45)
* [Excluir um grupo](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L248)
* [Obter membros de um grupo.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L90)
* [Obter proprietários de um grupo.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L137)

**Unidades**

* [Obter a unidade do usuário conectado.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L51)
* [Obter todos os arquivos na pasta raiz do usuário.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L83)
* [Criar um novo arquivo na pasta raiz do usuário.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L118)
* [Baixar um arquivo da pasta raiz do usuário.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L160)
* [Atualizar os conteúdos de um arquivo na pasta raiz do usuário.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L223)
* [Excluir um arquivo na pasta raiz de um usuário.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L284)
* [Renomear um arquivo na pasta raiz de um usuário.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L337)
* [Criar uma pasta na pasta raiz de um usuário.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L395)

## Requisitos do dispositivo
Para executar o projeto de trechos de código, o seu dispositivo deve atender aos seguintes requisitos: * Android API nível 21 ou mais recente

## Requisitos do Android Studio
* Ferramentas de compilação do Android para Gradle 3.1+

> **Observação:** O Android Studio pode solicitar que você instale o Repositório de Suporte do Android 47.0.0+. A lógica do arquivo build.gradle do módulo do projeto usa o método `implementação` em vez do método `compilar` mais antigo para compilar as dependências do módulo. Esses novos métodos de compilação dependem do Repositório de Suporte do Android 47.0.0 ou mais recente.


### Pré-requisitos
Para usar o projeto de trechos de código do SDK do Microsoft Graph, você precisará do seguinte: * A versão mais recente do [Android Studio](http://developer.android.com/sdk/index.html). * O sistema de automação de compilação [Gradle](http://www.gradle.org). * Uma conta do Office 365. Você pode se inscrever para receber uma [assinatura de Desenvolvedor do Office 365](https://portal.office.com/Signup/Signup.aspx?OfferId=C69E7747-2566-4897-8CBA-B998ED3BAB88&DL=DEVELOPERPACK&ali=1#0) que inclui os recursos necessários para começar a criar aplicativos do Office 365\. * [JDK (Kit de Desenvolvimento Java) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html). * Um aplicativo do Azure registrado com uma ID de cliente e um valor de URI de redirecionamento. Consulte [Conceder permissões para o aplicativo de Trechos de Código no Azure](../../../android-java-snippets-rest-sample/wiki/Grant-permissions-for-the-Snippet-application-in-Azure) para obter detalhes sobre como criar as permissões corretas.

## Registro de aplicativo do cliente do Azure

1. Navegue até a página [Portal do Azure - Registros de aplicativo](https://go.microsoft.com/fwlink/?linkid=2083908). 
1. Selecione **Novo registro**. 
1. Quando a página **Registrar um aplicativo** for exibida, insira as informações de registro do aplicativo: 
    - Na seção **Nome**, insira um nome de aplicativo relevante que será exibido aos usuários do aplicativo, por exemplo, `Exemplo de Trechos de Código Java para Android`. 
    - Na seção **Tipos de conta com suporte**, selecione **Contas em qualquer diretório organizacional**. 
1. Selecione **Registrar** para criar o aplicativo. 
1. Na página **Visão geral** do aplicativo, encontre o valor de **ID do aplicativo (cliente)** e registre-o para usar mais tarde. Será necessário configurar o arquivo de configuração do Visual Studio para este projeto. 
1. Na lista de páginas para o aplicativo, selecione **Manifesto** e: 
    - No editor de manifesto, defina a propriedade ``allowPublicClient`` como **true** 
    - Selecione **Salvar** na barra acima do editor de manifesto. 
1. Na lista de páginas para o aplicativo, selecione **Permissões de API**. 
    - Clique no botão **Adicionar uma permissão** e, em seguida, 
    - Certifique-se de que a guia **APIs da Microsoft** esteja selecionada 
    - Na seção *APIs mais usadas da Microsoft*, clique em **Microsoft Graph** 
    - Na seção **Permissões delegadas**, certifique-se de que as permissões corretas estejam marcadas. Use a caixa de pesquisa, se necessário.
    - **User.Read**, **Mail.Send**, **Mail.ReadWrite**, **Files.ReadWrite**, **User.ReadBasic.All**, **Calendars.ReadWrite**, **Group.Read.All**  
    - Selecione o botão **Adicionar permissão** 

> **Observação:** Em [Configurar o projeto](#configure-the-project), você será solicitado a copiar algumas cadeias de caracteres geradas pelo portal de registro do aplicativo. Permaneça na página de registro do aplicativo enquanto configura o projeto. As cadeias de caracteres que você copia do registro do aplicativo serão coladas no código-fonte do projeto.

## Configurar o projeto

1. Baixe ou clone o [exemplo de trechos](../../).
2. Inicie o Android Studio.
3. A partir da caixa de diálogo **Bem-vindo ao Android Studio**, escolha **Importar projeto (Eclipse ADT, Gradle etc.)**.
4. Escolha o arquivo **settings.gradle** na pasta **android-java-snippets-sample** e clique em **OK**.
5. Responda na caixa de diálogo ("Sincronização do Gradle: as configurações do Gradle para este projeto ainda não estão definidas. Você gostaria que o projeto usasse o wrapper do Gradle?") clicando no botão **OK** para usar o wrapper do Gradle. 
4. Na página de registro do aplicativo que você acabou de visitar, copie o URI de redirecionamento personalizado (`msal{ID de aplicativo como GUID}`) para a área de transferência. **Não copie `://auth`**
   <br/>Por exemplo: `msal0575d7fe-8ec7-4925-9ce2-87074778a039` será copiado e `://auth` será ignorado.
4. Cole o conteúdo da área de transferência em **app/src/main/AndroidManifest.xml**, linha 41, para substituir `INSERIR_ID_DO_CLIENTE` pelo conteúdo da área de transferência.
4. Copie a **parte do GUID** do URI de redirecionamento personalizado em **app/src/main/AndroidManifest.xml**, linha 49, para substituir `INSERIR_ID_DO_CLIENTE` pelo conteúdo da área de transferência.

## Executar o projeto
Após criar o projeto, você poderá executá-lo em um emulador ou dispositivo.

1. Execute o projeto.
2. Clique no botão **Conectar-se ao Microsoft Graph** para entrar.
3. Insira suas credenciais.
4. Analise e aceite os escopos de permissão solicitados pelo aplicativo.
4. Clique em uma operação na atividade principal para mostrar os detalhes da operação.
5. Clique no botão **EXECUTAR** para iniciar a operação e aguarde até que a operação seja concluída.
6. Clique na caixa de texto **Objeto Bruto** para copiar o conteúdo da caixa para a área de transferência do emulador/dispositivo.
7. Clique no botão Voltar na barra de ferramentas para retornar à lista de operações.
8. (Opcional) Clique no menu de estouro de capacidade para obter a opção de menu Desconectar.

## Como o exemplo afeta os dados do locatário
Este exemplo executa comandos que criam, leem, atualizam ou excluem dados. Durante a execução de comandos que excluem ou editam dados, o exemplo cria entidades falsas. As entidades falsas são excluídas ou editadas para que os dados reais do locatário não sejam afetados. O exemplo deixará entidades falsas em seu locatário.

## Compreender o código
O projeto de trechos de código usa essas classes para gerenciar as interações com o Microsoft Graph:

### Organização do projeto de exemplo
O projeto de trechos de código é composto por dois módulos. O design modular permite que você crie um novo aplicativo baseado neste exemplo, importando os módulos para o seu aplicativo. Após importar os módulos, use o código no módulo do [aplicativo](/app) de trechos de código como um exemplo de como chamar métodos em outros módulos do exemplo.

### Módulos no projeto de trechos de código
* [`aplicativo`](/app). A interface de usuário e o módulo de lógica empresarial. Operações de SDK são iniciadas nas classes de trecho de código neste módulo.

### Classes de trecho de código
Um trecho de código executa uma única operação e retorna os resultados. Os trechos de código são encontrados no módulo do [aplicativo](/app). Os trechos de código definem o estado necessário para fazer as chamadas nas classes de serviço do Microsoft Graph descritas abaixo.
* [`AbstractSnippet`](/app/src/main/java/com/microsoft/graph/snippets/snippet/AbstractSnippet.java)
* [`DrivesSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java)
* [`EventsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java)
* [`GroupsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java)
* [`MeSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java)
* [`MessageSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java)
* [`UsersSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java)

### Classes de autenticação
Os métodos de autenticação são encontrados na classe [`AuthenticationManager`](/app/src/main/java/com/microsoft/graph/snippets/AuthenticationManager.java). Esses métodos usam a [Biblioteca de Autenticação da Microsoft (MSAL) para Android](https://github.com/AzureAD/microsoft-authentication-library-for-android) para se conectarem ao Microsoft Graph. 

* [`AuthenticationManager`](/app/src/main/java/com/microsoft/graph/snippets/AuthenticationManager.java). Encapsula a lógica de conexão e desconexão do usuário além da autorização do aplicativo.
 
<a name="contributing"></a>
## Colaboração ##

Se quiser contribuir para esse exemplo, confira [CONTRIBUTING.MD](/CONTRIBUTING.md).

Este projeto adotou o [Código de Conduta de Código Aberto da Microsoft](https://opensource.microsoft.com/codeofconduct/).  Para saber mais, confira as [Perguntas frequentes sobre o Código de Conduta](https://opensource.microsoft.com/codeofconduct/faq/) ou entre em contato pelo [opencode@microsoft.com](mailto:opencode@microsoft.com) se tiver outras dúvidas ou comentários.

## Perguntas e comentários
Adoraríamos receber os seus comentários sobre o exemplo de Trechos de Código do SDK do Microsoft Graph para Android. Você pode enviar comentários na seção [Problemas](../../issues) deste repositório. <br/>
Perguntas gerais sobre o desenvolvimento do Microsoft Graph devem ser postadas no [Stack Overflow](http://stackoverflow.com/questions/tagged/microsoftgraph). Não deixe de marcar as perguntas com \[microsoftgraph].

## Recursos adicionais

* [Introdução às APIs do Office 365 fornecidas pelo Microsoft Graph](http://dev.office.com/getting-started/office365apis)
* [Visão geral do Microsoft Graph](http://graph.microsoft.io)
* [SDK do Microsoft Graph para Android](../../../msgraph-sdk-android)
* [Exemplo de conexão para Android usando o SDK do Microsoft Graph](../../../android-java-connect-sample)

## Histórico de versão

|Versão|Alterações|
|:---|:----|
|1.0|Lançamento inicial|
|1.5| – A biblioteca de autenticação MSAL substituiu a biblioteca de autenticação ADAL <br/> – SDK do Microsoft Graph versão 1.5|

Copyright (c) 2019 Microsoft. Todos os direitos reservados.
