# <a name="snippets-sample-for-android-using-the-microsoft-graph-sdk"></a>Exemplo de trechos de código para Android usando o SDK do Microsoft Graph
**Versão 1.5**

[![Status do build](https://travis-ci.org/microsoftgraph/android-java-snippets-sample.svg?branch=master)](https://travis-ci.org/microsoftgraph/android-java-snippets-sample)

**Sumário**

* [Requisito do dispositivo](#device-requirement)
* [Pré-requisitos](#prerequisites)
* [Registro de aplicativo cliente do Azure](#azure-client-application-registration)
* [Configurar o projeto](#configure-the-project)
* [Executar o projeto](#run-the-project)
* [Como o exemplo afeta os dados do locatário](#how-the-sample-affects-your-tenant-data)
* [Compreender o código](#understand-the-code)
* [Perguntas e comentários](#questions-and-comments)
* [Recursos adicionais](#additional-resources)
* [Histórico de versão](#version-history)

Deseja desenvolver aplicativos interessantes que ajudam as pessoas a trabalhar com os dados do Office 365 deles? Explore, aprenda e entenda o SDK do Microsoft Graph usando este exemplo de Trechos de Código. Este exemplo mostra como acessar vários recursos, incluindo o Microsoft Azure Active Directory e o Office 365, fazendo chamadas para o SDK do Microsoft Graph em um aplicativo Android.

Você pode explorar as seguintes operações no Microsoft Graph:

**Eu**

* [Obtenha informações sobre o usuário conectado.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L44)
* [Obtenha as responsabilidades do usuário.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L67)
* [Obtenha o gerente do usuário.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L94)
* [Obtenha relatórios diretos do usuário.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L117)
* [Obtenha a associação de grupo do usuário](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L140)
* [Obtenha a foto do usuário.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L164)

**Usuários**

* [Obtenha os usuários do diretório do locatário.](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L49)
* [Obtenha usuários filtrados por critérios do diretório do locatário.](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L80)
* [Crie um novo usuário.](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L113)

**Eventos**

* [Obtenha eventos do usuário conectado.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L51)
* [Crie um novo evento para o usuário.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L83)
* [Atualize o evento de um usuário.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L118)
* [Exclua o evento de um usuário.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L170)

**Mensagens**

* [Obtenha mensagens do usuário.](app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java#L51)
* [Envie uma mensagem da caixa de correio do usuário.](app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java#L82)

**Grupos**

* [Obtenha todos os grupos no diretório do locatário.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L184)
* [Crie um novo grupo.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L191)
* [Obtenha informações sobre um grupo específico no locatário.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L45)
* [Exclua um grupo.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L248)
* [Obtenha membros de um grupo.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L90)
* [Obtenha proprietários de um grupo.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L137)

**Unidades**

* [Obtém a unidade do usuário conectado.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L51)
* [Obtém todos os arquivos na pasta raiz do usuário.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L83)
* [Cria um novo arquivo na pasta raiz do usuário.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L118)
* [Baixa um arquivo da pasta raiz do usuário.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L160)
* [Atualiza os conteúdos de um arquivo na pasta raiz do usuário.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L223)
* [Exclui um arquivo na pasta raiz do usuário.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L284)
* [Renomeia um arquivo na pasta raiz de um usuário.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L337)
* [Cria uma pasta na pasta raiz do usuário.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L395)

## <a name="device-requirements"></a>Requisitos do dispositivo
Para executar o projeto de trechos de código, seu dispositivo deve atender aos seguintes requisitos:
* API Android nível 21 ou mais recente

## <a name="android-studio-requirements"></a>Requisitos do Android Studio
* Ferramentas de compilação do Android para Gradle 3.1+

> **Observação:** o Android Studio pode solicitar que você instale o Repositório de suporte do Android 47.0.0+. A lógica do arquivo build.gradle do módulo do projeto usa o método `implementation` em vez do método `compile` mais antigo para compilar as dependências do módulo. Esses novos métodos de build dependem do Repositório de suporte do Android 47.0.0 ou mais recente.


### <a name="prerequisites"></a>Pré-requisitos
Para usar o projeto de trechos de código do SDK do Microsoft Graph, você precisa do seguinte:
* A versão mais recente do [Android Studio](http://developer.android.com/sdk/index.html).
* O sistema de automação da compilação do [Gradle](http://www.gradle.org).
* Uma conta do Office 365. Inscreva-se em uma [Assinatura do Office 365 para Desenvolvedor](https://portal.office.com/Signup/Signup.aspx?OfferId=C69E7747-2566-4897-8CBA-B998ED3BAB88&DL=DEVELOPERPACK&ali=1#0) que inclua os recursos necessários para você começar a criar aplicativos do Office 365.
* [JDK (Java Development Kit) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html).
* Um aplicativo registrado no Azure com valores da ID de cliente e do URI de redirecionamento. Consulte [Conceder permissões para o aplicativo de Trechos de Código no Azure](../../../android-java-snippets-rest-sample/wiki/Grant-permissions-for-the-Snippet-application-in-Azure) para saber detalhes sobre como criar as permissões corretas.

## <a name="azure-client-application-registration"></a>Registro de aplicativo cliente do Azure


1. Entre no [Portal de Registro do Aplicativo](https://apps.dev.microsoft.com).
3. Clique no botão **Adicionar um aplicativo** à direita da página.
4. Dê um nome ao aplicativo.
4. _Des_marque **Deixe-nos ajudá-lo a começar** na seção **Configuração Guiada**
4. Clique no botão azul **Criar** para criar o registro.
5. Clique no botão **Adicionar Plataforma** na seção **Plataformas** e escolha **Aplicativo Nativo**.
8. Configurar Permissões para seu aplicativo – em **Permissões do Microsoft Graph** clique no botão azul **Adicionar** ao lado de **Permissões Delegadas**
9. Adicione as permissões delegadas a seguir:
   * Entrar e ler o perfil do usuário
   * Ter acesso total a todos os arquivos que o usuário pode acessar
   * Ter acesso total aos calendários do usuário
   * Acesso de leitura e gravação aos emails do usuário 
   * Enviar email como um usuário
   * Ler emails do usuário
   * Ler e gravar dados de diretório
   * Ler os perfis básicos de todos usuários
   * Ler e gravar todos os grupos
13. Clique em **Salvar** no menu inferior.

> **Observação:** em [Configurar o projeto](#configure-the-project), você será solicitado a copiar algumas cadeias de caracteres geradas pelo portal de registro do aplicativo. Permaneça na página de registro do aplicativo enquanto configura o projeto. As cadeias de caracteres que você copia do registro do aplicativo serão coladas no código-fonte do projeto.

## <a name="configure-the-project"></a>Configurar o projeto

1. Baixe ou clone o [exemplo de trechos](../../).
2. Inicie o Android Studio.
3. A partir da caixa de diálogo **Bem-vindo ao Android Studio**, escolha **Importar projeto (Eclipse ADT, Gradle etc.)**.
4. Escolha o arquivo **settings.gradle** na pasta **android-java-snippets-sample** e clique em **OK**.
5. Responda na caixa de diálogo ("Sincronização do Gradle: as configurações do Gradle para este projeto ainda não estão definidas. Você gostaria que o projeto usasse o wrapper do Gradle?") clicando no botão **OK** para usar o wrapper do Gradle. 
4. Na página de registro do aplicativo que você acabou de visitar, copie o URI de redirecionamento personalizado (`msal{application id as GUID}`) para a área de transferência. **Não copie `://auth`**
   <br/>Por exemplo: `msal0575d7fe-8ec7-4925-9ce2-87074778a039` é copiado, `://auth` é ignorado.
4. Cole o conteúdo da área de transferência em **app/src/main/AndroidManifest.xml**, linha 42, para substituir `ENTER_YOUR_CLIENT_ID` pelo conteúdo da área de transferência.
4. Copie a **parte do GUID** do URI de redirecionamento personalizado em **app/src/main/AndroidManifest.xml**, linha 51, para substituir `ENTER_YOUR_CLIENT_ID` pelo conteúdo da área de transferência.

## <a name="run-the-project"></a>Executar o projeto
Após criar o projeto, você poderá executá-lo em um emulador ou dispositivo.

1. Execute o projeto.
2. Clique no botão **Conectar-se ao Microsoft Graph** para entrar.
3. Insira suas credenciais.
4. Analise e aceite os escopos de permissão solicitados pelo aplicativo.
4. Clique em uma operação na atividade principal para mostrar os detalhes da operação.
5. Clique no botão **EXECUTAR** para iniciar a operação e aguarde até que a operação seja concluída.
6. Clique na caixa de texto **Objeto Bruto** para copiar o conteúdo da caixa para a área de transferência do emulador/dispositivo.
7. Clique o botão Voltar na barra de ferramentas para retornar à lista de operações.
8. (Opcional) Clique no menu de estouro de capacidade para obter a opção de menu Desconectar.

## <a name="how-the-sample-affects-your-tenant-data"></a>Como o exemplo afeta os dados do locatário
Este exemplo executa comandos que criam, leem, atualizam ou excluem dados. Durante a execução de comandos que excluem ou editam dados, o exemplo cria entidades falsas. As entidades falsas são excluídas ou editadas para que os dados reais do locatário não sejam afetados. O exemplo deixará entidades falsas em seu locatário.

## <a name="understand-the-code"></a>Compreender o código
O projeto de trechos de código usa essas classes para gerenciar as interações com o Microsoft Graph:

### <a name="sample-project-organization"></a>Organização do projeto de exemplo
O projeto de trechos de código é composto por dois módulos. O design modular permite que você crie um novo aplicativo baseado nesse exemplo, importando os módulos para seu aplicativo. Após importar os módulos, use o código no módulo do [aplicativo](/app) de trechos de código como um exemplo de como chamar métodos em outros módulos do exemplo.

### <a name="modules-in-the-snippets-project"></a>Módulos no projeto de trechos de código
* [`app`](/app). Módulo de lógica de negócios e interface de usuário. Operações de SDK são iniciadas nas classes de trecho de código neste módulo.

### <a name="snippet-classes"></a>Classes de trecho de código
Um trecho de código executa uma única operação e retorna os resultados. Os trechos de código são encontrados no módulo do [aplicativo](/app). Os trechos de código definem o estado necessário para fazer as chamadas nas classes do serviço do Microsoft Graph descritas abaixo.
* [`AbstractSnippet`](/app/src/main/java/com/microsoft/graph/snippets/snippet/AbstractSnippet.java)
* [`DrivesSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java)
* [`EventsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java)
* [`GroupsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java)
* [`MeSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java)
* [`MessageSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java)
* [`UsersSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java)

### <a name="authentication-classes"></a>Classes de autenticação
Os métodos de autenticação são encontrados na classe [`AuthenticationManager`](/app/src/main/java/com/microsoft/graph/snippets/AuthenticationManager.java). Esses métodos usam a [Biblioteca de Autenticação da Microsoft (MSAL) para Android](https://github.com/AzureAD/microsoft-authentication-library-for-android) para se conectar ao Microsoft Graph. 

* [`AuthenticationManager`](/app/src/main/java/com/microsoft/graph/snippets/AuthenticationManager.java). Encapsula a lógica de conexão e desconexão do usuário e a autorização do aplicativo.
 
<a name="contributing"></a>
## <a name="contributing"></a>Colaboração ##

Se quiser contribuir para esse exemplo, confira [CONTRIBUTING.MD](/CONTRIBUTING.md).

Este projeto adotou o [Código de Conduta do Código Aberto da Microsoft](https://opensource.microsoft.com/codeofconduct/). Para saber mais, confira as [Perguntas frequentes do Código de Conduta](https://opensource.microsoft.com/codeofconduct/faq/) ou contate [opencode@microsoft.com](mailto:opencode@microsoft.com) se tiver outras dúvidas ou comentários.

## <a name="questions-and-comments"></a>Perguntas e comentários
Adoraríamos receber seus comentários sobre o exemplo de Trechos de Código do SDK do Microsoft Graph SDK para Android. Você pode nos enviar comentários na seção [Problemas](../../issues) deste repositório. <br/>As perguntas gerais sobre o desenvolvimento do Microsoft Graph devem ser postadas no [Stack Overflow](http://stackoverflow.com/questions/tagged/microsoftgraph). Marque as perguntas com [microsoftgraph].

## <a name="additional-resources"></a>Recursos adicionais

* [Começar a usar as APIs do Office 365 da plataforma Microsoft Graph](http://dev.office.com/getting-started/office365apis)
* [Visão geral do Microsoft Graph](http://graph.microsoft.io)
* [SDK do Microsoft Graph para Android](../../../msgraph-sdk-android)
* [Exemplo de conexão para Android usando o SDK do Microsoft Graph](../../../android-java-connect-sample)

## <a name="version-history"></a>Histórico de versão

|Versão|Altera|
|:---|:----|
|1.0|Versão inicial|
|1.5|– A biblioteca de autenticação MSAL substituiu a biblioteca de autenticação ADAL <br/> – SDK do Microsoft Graph versão 1.5|

Copyright © 2015 Microsoft. Todos os direitos reservados.
