# Exemplo de trechos de código para Android usando o SDK do Microsoft Graph

[![BStatus da Compilação](https://travis-ci.org/microsoftgraph/android-java-snippets-sample.svg?branch=master)](https://travis-ci.org/microsoftgraph/android-java-snippets-sample)

**Sumário**

* [Requisito de dispositivo](#requisito-de-dispositivo)
* [Pré-requisitos](#pré-requisitos)
* [Registro de aplicativo cliente do Azure](#registro-de-aplicativo-cliente-do-azure)
* [Configurar o projeto](#configurar-o-projeto)
* [Executar o projeto](#executar-o-projeto)
* [Como o exemplo afeta os dados do locatário](#como-o-exemplo-afeta-os-dados-do-locatário)
* [Compreender o código](#compreender-o-código)
* [Perguntas e comentários](#perguntas-e-comentários)
* [Recursos adicionais](#recursos-adicionais)

Deseja desenvolver aplicativos interessantes que ajudam as pessoas a trabalhar com seus dados do Office 365? Explore, aprenda e entenda o SDK do Microsoft Graph usando este exemplo de Trechos de Código. Este exemplo mostra como acessar vários recursos, incluindo o Microsoft Azure Active Directory e o Office 365, fazendo chamadas para o SDK do Microsoft Graph em um aplicativo Android.

Você pode explorar as seguintes operações no Microsoft Graph:

**Eu**

* [Obtenha informações sobre o usuário conectado.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L44)
* [Obtenha as responsabilidades do usuário.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L67)
* [Obtenha o gerente do usuário.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L94)
* [Obtenha relatórios diretos do usuário.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L117)
* [Obtenha a associação de grupo do usuário](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L140)
* [Obtenha a foto do usuário.](app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java#L164)

**Usuários**

* [Obter os usuários do diretório do locatário.](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L49)
* [Obtenha usuários filtrados por critérios do diretório do locatário.](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L80)
* [Crie um novo usuário.](app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java#L113)

**Eventos**

* [Obtenha eventos do usuário conectado.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L51)
* [Crie um novo evento para esse usuário.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L83)
* [Atualize o evento de um usuário.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L118)
* [Exclua o evento de um usuário.](app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java#L170)

**Mensagens**

* [Obtenha mensagens do usuário.](app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java#L51)
* [Envie uma mensagem da caixa de correio do usuário.](app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java#L82)

**Grupos**

* [Obtenha todos os grupos no diretório do locatário.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L184)
* [Crie um novo grupo](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L214)
* [Obtenha informações sobre um grupo específico no locatário.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L45)
* [Exclua um grupo](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L248)
* [Obter membros de um grupo.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L90)
* [Obter proprietários de um grupo.](app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java#L137)

**Unidades**

* [Obtém a unidade do usuário conectado.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L51)
* [Obtém todos os arquivos na pasta raiz do usuário.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L83)
* [Cria um novo arquivo na pasta raiz do usuário.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L118)
* [Baixa um arquivo da pasta raiz do usuário.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L160)
* [Atualiza os conteúdos de um arquivo na pasta raiz do usuário.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L223)
* [Exclui um arquivo na pasta raiz de um usuário.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L284)
* [Renomeia um arquivo na pasta raiz de um usuário.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L337)
* [Cria uma pasta na pasta raiz de um usuário.](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java#L395)

##Requisito de dispositivo
Para executar o projeto de trechos de código, seu dispositivo deve atender aos seguintes requisitos:
* API Android nível 16 ou mais recente

###Pré-requisitos
Para usar o projeto de trechos de código do SDK do Microsoft Graph, você precisa do seguinte:
* A versão mais recente do [Android Studio](http://developer.android.com/sdk/index.html).
* O sistema de automação da compilação do [Gradle](http://www.gradle.org).
* Uma conta do Office 365. Inscreva-se em uma [Assinatura do Office 365 para Desenvolvedor](https://portal.office.com/Signup/Signup.aspx?OfferId=C69E7747-2566-4897-8CBA-B998ED3BAB88&DL=DEVELOPERPACK&ali=1#0) que inclua os recursos necessários para você começar a criar aplicativos do Office 365.
* [JDK (Java Development Kit) 7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html).
* Um aplicativo registrado no Azure com valores da ID de cliente e do URI de redirecionamento. Consulte [Conceder permissões para o aplicativo de Trechos de Código no Azure](../../../android-java-snippets-rest-sample/wiki/Grant-permissions-for-the-Snippet-application-in-Azure) para saber detalhes sobre como criar as permissões corretas.

##Registro de aplicativo cliente do Azure
1. Entre no [Portal de Gerenciamento do Azure](https://manage.windowsazure.com) usando as credenciais do Azure AD.
2.  Clique em **Active Directory** no menu à esquerda e escolha o diretório para o locatário do Office 365.
3.  No menu superior, clique em **Aplicativos**.
4.  Clique em **Adicionar** no menu inferior.
5.  Na página **O que você deseja fazer?**, clique em **Adicionar um aplicativo que minha organização esteja desenvolvendo**.
6.  Na página **Conte-nos sobre seu aplicativo**, especifique **Exemplo de Trecho de Código do Android** como nome do aplicativo e escolha **APLICATIVO CLIENTE NATIVO** como tipo.
7.  Clique no botão de seta no canto inferior direito da página.
8.  Na página de **Informações do aplicativo**, especifique um **URI de redirecionamento** por exemplo `http://localhost/androidsnippets` e marque a caixa de seleção no canto inferior direito da página.
9.  Após adicionar o aplicativo com êxito, você será direcionado para a página **Início Rápido** do aplicativo. A partir desse local, escolha **Configurar** no menu superior.
10. Nas permissões da seção de outros aplicativos, adicione o aplicativo do Microsoft Graph.
11. Para o aplicativo do Microsoft Graph, adicione as seguintes permissões:
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
14. Observe que os valores especificados como **ID do Cliente** na página **Configurar**. Você precisará desses valores posteriormente quando for configura o projeto.

##Configurar o projeto

1. Baixe ou clone o [exemplo de trechos](../../).
2. Inicie o Android Studio.
3. A partir da caixa de diálogo **Bem-vindo ao Android Studio**, escolha **Importar projeto (Eclipse ADT, Gradle etc.)**.
4. Escolha o arquivo **settings.gradle** na pasta **android-java-snippets-sample** e clique em **OK**.
5. Responda na caixa de diálogo ("Sincronização do Gradle: as configurações do Gradle para este projeto ainda não estão definidas. Você gostaria que o projeto usasse o wrapper do Gradle? "), clicando no botão **OK** para usar o wrapper do Gradle. 
6. Abra o arquivo ServiceConstants.java no pacote com.microsoft.graph.snippets.
7. Encontre a cadeia de caracteres [`CLIENT_ID`](app/src/main/java/com/microsoft/graph/snippets/ServiceConstants.java#L11) e defina seu valor com a ID de cliente registrada no Azure.
8. Encontre a cadeia de caracteres [`REDIRECT_URI`](app/src/main/java/com/microsoft/graph/snippets/ServiceConstants.java#L10) e defina seu valor com o URI de redirecionamento registrado no Azure.

##Executar o projeto
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

##Como o exemplo afeta os dados do locatário
Este exemplo executa comandos que criam, leem, atualizam ou excluem dados. Durante a execução de comandos que excluem ou editam dados, o exemplo cria entidades falsas. As entidades falsas são excluídas ou editadas para que os dados reais do locatário não sejam afetados. O exemplo deixará entidades falsas em seu locatário.

##Compreender o código
O projeto de trechos de código usa essas classes para gerenciar as interações com o Microsoft Graph:

###Organização do projeto de exemplo
O projeto de trechos de código é composto por dois módulos. O design modular permite que você crie um novo aplicativo baseado nesse exemplo, importando os módulos para seu aplicativo. Após importar os módulos, use o código no módulo do [aplicativo](/app) de trechos de código como um exemplo de como chamar métodos em outros módulos do exemplo.

###Módulos no projeto de trechos de código
* [`o365-Auth`](/o365-auth). Este módulo contém as chamadas de biblioteca para autenticar um usuário com o Microsoft Graph.
* [`app`](/app). A interface de usuário e módulo de lógica de negócios. Operações de SDK são iniciadas nas classes de trecho de código neste módulo.

###Classes de trecho de código
Um trecho de código executa uma única operação e retorna os resultados. Os trechos de código são encontrados no módulo do [aplicativo](/app). Os trechos de código definem o estado necessário para fazer as chamadas nas classes do serviço do Microsoft Graph descritas abaixo.
* [`AbstractSnippet`](/app/src/main/java/com/microsoft/graph/snippets/snippet/AbstractSnippet.java)
* [`DrivesSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/DrivesSnippets.java)
* [`EventsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/EventsSnippets.java)
* [`GroupsSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/GroupsSnippets.java)
* [`MeSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MeSnippets.java)
* [`MessageSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/MessageSnippets.java)
* [`UsersSnippets`](/app/src/main/java/com/microsoft/graph/snippets/snippet/UsersSnippets.java)

###Classes de autenticação
As classes de autenticação são encontradas no módulo do [o365-Auth](/o365-auth). Essas classes usam a [Biblioteca do Microsoft Azure Active Directory (ADAL) para o Android](https://github.com/AzureAD/azure-activedirectory-library-for-android) para se conectar ao Microsoft Graph. 

* [`AuthenticationManager`](/o365-auth/src/main/java/com/microsoft/graph/auth/AuthenticationManager.java). Encapsula a lógica de conexão e desconexão do usuário e a autorização do aplicativo do Azure.
* [`AzureADModule`](/o365-auth/src/main/java/com/microsoft/graph/auth/AzureADModule.java). Classe do auxiliar de autenticação. 
* [`AzureAppCompatActivity`](/o365-auth/src/main/java/com/microsoft/graph/auth/AzureAppCompatActivity.java). Auxiliar de injeção de dependência.
 
<a name="contributing"></a>
## Colaboração ##

Se quiser contribuir para esse exemplo, confira [CONTRIBUTING.MD](/CONTRIBUTING.md).

Este projeto adotou o [Código de Conduta do Código Aberto da Microsoft](https://opensource.microsoft.com/codeofconduct/). Para saber mais, confira as [Perguntas frequentes do Código de Conduta](https://opensource.microsoft.com/codeofconduct/faq/) ou contate [opencode@microsoft.com](mailto:opencode@microsoft.com) se tiver outras dúvidas ou comentários.

## Perguntas e comentários
Adoraríamos receber seus comentários sobre o exemplo de Trechos de Código do SDK do Microsoft Graph SDK para Android. Você pode nos enviar comentários na seção [Problemas](../../issues) deste repositório. <br/>
As perguntas gerais sobre o desenvolvimento do Microsoft Graph devem ser postadas no [Stack Overflow](http://stackoverflow.com/questions/tagged/microsoftgraph). Não deixe de marcar as perguntas com [microsoftgraph].

## Recursos adicionais

* [Introdução a APIs do Office 365 fornecidas pelo Microsoft Graph](http://dev.office.com/getting-started/office365apis)
* [Visão geral do Microsoft Graph](http://graph.microsoft.io)
* [SDK do Microsoft Graph para Android](../../../msgraph-sdk-android)
* [Exemplo de conexão para Android usando o SDK do Microsoft Graph](../../../android-java-connect-sample)

Copyright © 2015 Microsoft. Todos os direitos reservados.